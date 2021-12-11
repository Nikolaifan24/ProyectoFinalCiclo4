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
import com.proyectoCiclo4.dto.ProductoDto;
import com.proyectoCiclo4.enums.CollectionEnum;

public class ProductoDao {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> productos;
	
	public ProductoDao(CollectionEnum collectionEnum) {
		try {
			
			conexion = MongoClients.create("mongodb+srv://mintic:mintic123@cluster11.s0xsj.mongodb.net/test");
			baseDatos = conexion.getDatabase("db_productos");
			productos = baseDatos.getCollection(collectionEnum.getCollectionName());
			
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
	
	public boolean crear(ProductoDto productoDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigo", productoDto.getCodigo())
					 .append("nombre", productoDto.getNombre())
					 .append("nitproveedor", productoDto.getNitproveedor())
					 .append("precioCompra", productoDto.getPrecioCompra())
					 .append("ivaCompra", productoDto.getIvaCompra())
					 .append("precioVenta", productoDto.getPrecioVenta());
			productos.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<ProductoDto> listar() {
		ArrayList<ProductoDto> listado = new ArrayList<ProductoDto>();
		try {
			ArrayList<Document> documentos = productos.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				ProductoDto nuevo = new ProductoDto();
				nuevo.setCodigo(doc.getString("codigo"));
				nuevo.setNombre(doc.getString("nombre"));
				nuevo.setNitproveedor(doc.getString("nitproveedor"));
				nuevo.setPrecioCompra(doc.getString("precioCompra"));
				nuevo.setIvaCompra(doc.getString("ivaCompra"));
				nuevo.setPrecioVenta(doc.getString("precioVenta"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(String codigo) {
		boolean rta=false;
		try {
			DeleteResult estado = productos.deleteOne(new Document("codigo", codigo));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	public ArrayList<ProductoDto> buscar(String codigo) {
		ArrayList<ProductoDto> listado = new ArrayList<ProductoDto>();
		try {
			ArrayList<Document> documentos = productos.find(new Document("codigo", codigo)).into(new ArrayList<>());
			for(Document doc: documentos) {
				ProductoDto nuevo = new ProductoDto();
				nuevo.setCodigo(doc.getString("codigo"));
				nuevo.setNombre(doc.getString("nombre"));
				nuevo.setNitproveedor(doc.getString("nitproveedor"));
				nuevo.setPrecioCompra(doc.getString("precioCompra"));
				nuevo.setIvaCompra(doc.getString("ivaCompra"));
				nuevo.setPrecioVenta(doc.getString("precioVenta"));
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	public boolean actualizar(String codigo, ProductoDto productoDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigo", productoDto.getCodigo())
			 .append("nombre", productoDto.getNombre())
			 .append("nitproveedor", productoDto.getNitproveedor())
			 .append("precioCompra", productoDto.getPrecioCompra())
			 .append("ivaCompra", productoDto.getIvaCompra())
			 .append("precioVenta", productoDto.getPrecioVenta());
			
			Document filtro = new Document("codigo", codigo);
			UpdateResult estado = productos.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
	
	
}
