package com.proyectoCiclo4.dao;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.proyectoCiclo4.dto.UsuarioDto;
import com.proyectoCiclo4.enums.CollectionEnum;

public class UsuarioDao {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> usuarios;
	
	public UsuarioDao(CollectionEnum collectionEnum) {
		try {
			
			conexion = MongoClients.create("mongodb+srv://mintic:mintic123@cluster00.ftgk7.mongodb.net/test");
			baseDatos = conexion.getDatabase("db_usuarios");
			usuarios = baseDatos.getCollection(collectionEnum.getCollectionName());
			
		} catch (Exception e) {
		
			System.out.println("Error al conectar");
			
		}
	}
	
	private void cerrar() {
		try {
			
			conexion.close();
			System.out.println("Conexión cerrada");
			
		} catch (Exception e) {
			
			System.out.println("Error al conectar");
			
		}
	}
	
	
	public boolean login(UsuarioDto usuarioDto) {
		boolean rta = false;
		String user = usuarioDto.getUsuario().toString();
		try {
			ArrayList<Document> documentoUsuario = usuarios.find(new Document("usuario",user)).into(new ArrayList<>());
			if (!documentoUsuario.isEmpty()) {
				final String documentoPassword = documentoUsuario.get(0).getString("password");
				if (documentoPassword.equals(usuarioDto.getPassword().toString())) {
					rta = true;
				}
			} 
			
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
			
		}
		return rta;
		
	}
	
	
	public boolean crear(UsuarioDto usuarioDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("usuario", usuarioDto.getUsuario())
					 .append("password", usuarioDto.getPassword());
					 
			usuarios.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<UsuarioDto> listar() {
		ArrayList<UsuarioDto> listado = new ArrayList<UsuarioDto>();
		try {
			ArrayList<Document> documentos = usuarios.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				UsuarioDto nuevo = new UsuarioDto();
				nuevo.setUsuario(doc.getString("usuario"));
				nuevo.setPassword(doc.getString("password"));
				
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(String user) {
		boolean rta=false;
		try {
			DeleteResult estado = usuarios.deleteOne(new Document("usuario", user));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	public ArrayList<UsuarioDto> buscar(String user) {
		ArrayList<UsuarioDto> listado = new ArrayList<UsuarioDto>();
		try {
			ArrayList<Document> documentos = usuarios.find(new Document("usuario", user)).into(new ArrayList<>());
			for(Document doc: documentos) {
				UsuarioDto nuevo = new UsuarioDto();
				nuevo.setUsuario(doc.getString("usuario"));
				nuevo.setPassword(doc.getString("password"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	public boolean actualizar(String user, UsuarioDto usuarioDto) {
		boolean rta = false;
		try {
			Document documento = new Document();
			documento.append("usuario", usuarioDto.getUsuario())
			 		 .append("password", usuarioDto.getPassword());
			 		 
			Document filtro = new Document("usuario", user);
			
			UpdateResult estado = usuarios.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
	
	
}
