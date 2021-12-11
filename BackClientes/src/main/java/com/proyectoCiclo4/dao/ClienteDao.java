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
import com.proyectoCiclo4.dto.ClienteDto;
import com.proyectoCiclo4.enums.CollectionEnum;

public class ClienteDao {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> clientes;
	
	public ClienteDao(CollectionEnum collectionEnum) {
		try {
			
			conexion = MongoClients.create("mongodb+srv://mintic:mintic123@cluster0.nknyh.mongodb.net/test");
			baseDatos = conexion.getDatabase("db_clientes");
			clientes = baseDatos.getCollection(collectionEnum.getCollectionName());
			
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
	
	public boolean crear(ClienteDto clienteDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("cedula", clienteDto.getCedula())
					 .append("nombre", clienteDto.getNombre())
					 .append("direccion", clienteDto.getDireccion())
					 .append("telefono", clienteDto.getTelefono())
					 .append("correo", clienteDto.getCorreo());
			clientes.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ClienteDto> listar() {
		ArrayList<ClienteDto> listado = new ArrayList<ClienteDto>();
		try {
			ArrayList<Document> documentos = clientes.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				ClienteDto nuevo = new ClienteDto();
				nuevo.setCedula(doc.getString("cedula"));
				nuevo.setNombre(doc.getString("nombre"));
				nuevo.setDireccion(doc.getString("direccion"));
				nuevo.setTelefono(doc.getString("telefono"));
				nuevo.setCorreo(doc.getString("correo"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(String cedula) {
		boolean rta=false;
		try {
			DeleteResult estado = clientes.deleteOne(new Document("cedula", cedula));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	public ArrayList<ClienteDto> buscar(String cedula) {
		ArrayList<ClienteDto> listado = new ArrayList<ClienteDto>();
		try {
			ArrayList<Document> documentos = clientes.find(new Document("cedula", cedula)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ClienteDto nuevo = new ClienteDto();
				nuevo.setCedula(doc.getString("cedula"));
				nuevo.setNombre(doc.getString("nombre"));
				nuevo.setDireccion(doc.getString("direccion"));
				nuevo.setTelefono(doc.getString("telefono"));
				nuevo.setCorreo(doc.getString("correo"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	public boolean actualizar(String cedula, ClienteDto clienteDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("cedula", clienteDto.getCedula())
			 		 .append("nombre", clienteDto.getNombre())
			 		 .append("direccion", clienteDto.getDireccion())
			 		 .append("telefono", clienteDto.getTelefono())
			 		 .append("correo", clienteDto.getCorreo());
			
			Document filtro = new Document("cedula", cedula);
			
			UpdateResult estado = clientes.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
	
	
}
