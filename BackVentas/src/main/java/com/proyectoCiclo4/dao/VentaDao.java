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
import com.proyectoCiclo4.dto.VentaDto;
import com.proyectoCiclo4.enums.CollectionEnum;

public class VentaDao {
	MongoClient conexion;
	MongoDatabase baseDatos;
	MongoCollection<org.bson.Document> ventas;
	
	public VentaDao(CollectionEnum collectionEnum) {
		try {
			
			conexion = MongoClients.create("mongodb+srv://mintic:mintic123@cluster23.jvuu6.mongodb.net/test");
			baseDatos = conexion.getDatabase("db_ventas");
			ventas = baseDatos.getCollection(collectionEnum.getCollectionName());
			
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
	
	public boolean crear(VentaDto ventaDto) {
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoVenta", ventaDto.getCodigoVenta())
					 .append("cedulaCliente", ventaDto.getCedulaCliente())
					 .append("codigoProducto", ventaDto.getCodigoProducto())
					 .append("cantidadProducto", ventaDto.getCantidadProducto())
					 .append("valorUnitario", ventaDto.getValorUnitario())
					 .append("valorProducto", ventaDto.getValorProducto())
					 .append("valorIvaProducto", ventaDto.getValorIvaProducto())
					 .append("valorTotalVenta", ventaDto.getValorTotalVenta())
					 .append("valorTotalIva", ventaDto.getValorTotalIva())
					 .append("valorTotalVentaConIva", ventaDto.getValorTotalVentaConIva())
					 .append("precioVenta", ventaDto.getPrecioVenta());
			ventas.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
	}
	
	public ArrayList<VentaDto> listar() {
		ArrayList<VentaDto> listado = new ArrayList<VentaDto>();
		try {
			ArrayList<Document> documentos = ventas.find().into(new ArrayList<>());
			for(Document doc: documentos) {
				VentaDto nuevo = new VentaDto();
				nuevo.setCodigoVenta(doc.getString("codigoVenta"));
				nuevo.setCedulaCliente(doc.getString("cedulaCliente"));
				nuevo.setCodigoProducto(doc.getString("codigoProducto"));
				nuevo.setCantidadProducto(doc.getString("cantidadProducto"));
				nuevo.setValorUnitario(doc.getString("valorUnitario"));
				nuevo.setValorProducto(doc.getString("valorProducto"));
				nuevo.setValorIvaProducto(doc.getString("valorIvaProducto"));
				nuevo.setValorTotalVenta(doc.getString("valorTotalVenta"));
				nuevo.setValorTotalIva(doc.getString("valorTotalIva"));
				nuevo.setValorTotalVentaConIva(doc.getString("valorTotalVentaConIva"));
				nuevo.setPrecioVenta(doc.getString("precioVenta"));
			listado.add(nuevo);
			}
			System.out.println("Listado generado");
		} catch (Exception e) {
			System.out.println("No se pudo listar los documentos");
		}
		return listado;
	}
	
	public boolean eliminar(String codigoVenta) {
		boolean rta=false;
		try {
			DeleteResult estado = ventas.deleteOne(new Document("codigoVenta", codigoVenta));
			System.out.println("Se eliminó el documento");
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo eliminar el documento");
		}
		return rta;
	}
	
	public ArrayList<VentaDto> buscar(String codigoVenta) {
		ArrayList<VentaDto> listado = new ArrayList<VentaDto>();
		try {
			ArrayList<Document> documentos = ventas.find(new Document("codigoVenta", codigoVenta)).into(new ArrayList<>());
			for(Document doc: documentos) {
				VentaDto nuevo = new VentaDto();
				nuevo.setCodigoVenta(doc.getString("codigoVenta"));
				nuevo.setCedulaCliente(doc.getString("cedulaCliente"));
				nuevo.setCodigoProducto(doc.getString("codigoProducto"));
				nuevo.setCantidadProducto(doc.getString("cantidadProducto"));
				nuevo.setValorUnitario(doc.getString("valorUnitario"));
				nuevo.setValorProducto(doc.getString("valorProducto"));
				nuevo.setValorIvaProducto(doc.getString("valorIvaProducto"));
				nuevo.setValorTotalVenta(doc.getString("valorTotalVenta"));
				nuevo.setValorTotalIva(doc.getString("valorTotalIva"));
				nuevo.setValorTotalVentaConIva(doc.getString("valorTotalVentaConIva"));
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
	
	public boolean actualizar(String codigoVenta, VentaDto ventaDto) {
		boolean rta = false;
		try {
			
			Document documento = new Document();
			documento.append("codigoVenta", ventaDto.getCodigoVenta())
			 .append("cedulaCliente", ventaDto.getCedulaCliente())
			 .append("codigoProducto", ventaDto.getCodigoProducto())
			 .append("cantidadProducto", ventaDto.getCantidadProducto())
			 .append("valorUnitario", ventaDto.getValorUnitario())
			 .append("valorProducto", ventaDto.getValorProducto())
			 .append("valorIvaProducto", ventaDto.getValorIvaProducto())
			 .append("valorTotalVenta", ventaDto.getValorTotalVenta())
			 .append("valorTotalIva", ventaDto.getValorTotalIva())
			 .append("valorTotalVentaConIva", ventaDto.getValorTotalVentaConIva())
			 .append("precioVenta", ventaDto.getPrecioVenta());
			
			Document filtro = new Document("codigoVenta", codigoVenta);
			UpdateResult estado = ventas.replaceOne(filtro, documento);
			System.out.println("Documento actualizado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo actualizar el documento");
		}
		return rta;
	}
	
	
}
