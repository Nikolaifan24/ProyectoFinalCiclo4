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
	
	
	/*public boolean ValordeVenta(VentaDto ventaDto) {
		Double valorU = Double.parseDouble(ventaDto.getValorUnitario());
		Double ivaCompra = Double.parseDouble(ventaDto.getValorIvaProducto());
		Integer cantidadProducto = Integer.parseInt(ventaDto.getCantidadProducto());
		Double valorProductos = valorU * cantidadProducto;
		Double valorIvas = ivaCompra * cantidadProducto;
		Double valorVenta = valorProductos + valorIvas;
		boolean rta = false;
		try {
			Document documento = new Document("_id", new ObjectId());
			documento.append("valorTotalVenta", valorProductos )
					 .append("valorTotalIva", valorIvas )
					 .append("VentaconIva", valorVenta);
			ventas.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		return rta;
		
	}*/
	
	public boolean crear(VentaDto ventaDto) {
		
		boolean rta = false;
		double total1 =  ventaDto.getValorUnitario1()*ventaDto.getCantidadProducto1();
		double total2 =  ventaDto.getValorUnitario2()*ventaDto.getCantidadProducto2();
		double total3 =  ventaDto.getValorUnitario3()*ventaDto.getCantidadProducto3();
		double totalVentasin = total1 + total2 + total3;
		double totaliva = totalVentasin*0.19;
		double totalVentacon = totalVentasin +totaliva;
		try {
			
			Document documento = new Document("_id", new ObjectId());
			documento.append("codigoVenta", ventaDto.getCodigoVenta())
					 .append("cedulaCliente", ventaDto.getCedulaCliente())
					 .append("codigoProducto1", ventaDto.getCodigoProducto1())
					 .append("cantidadProducto1", ventaDto.getCantidadProducto1())
					 .append("valorUnitario1", ventaDto.getValorUnitario1())
					 .append("codigoProducto2", ventaDto.getCodigoProducto2())
					 .append("cantidadProducto2", ventaDto.getCantidadProducto2())
					 .append("valorUnitario2", ventaDto.getValorUnitario2())
					 .append("codigoProducto3", ventaDto.getCodigoProducto3())
					 .append("cantidadProducto3", ventaDto.getCantidadProducto3())
					 .append("valorUnitario3", ventaDto.getValorUnitario3())
			         .append("valorProducto1", ventaDto.getValorUnitario1()*ventaDto.getCantidadProducto1())
			         .append("valorProducto2", ventaDto.getValorUnitario2()*ventaDto.getCantidadProducto2())
			         .append("valorProducto3", ventaDto.getValorUnitario3()*ventaDto.getCantidadProducto3())
			         .append("valorTotalVenta",totalVentasin )
			         .append("valorTotalIva",totaliva )
			         .append("valorTotalVentaConIva",totalVentacon );
			         /*.append("valorTotalIva", ventaDto.getValorTotalVenta())
					 .append("valorTotalVentaConIva",  ventaDto.getValorTotalVenta()+ventaDto.getValorTotalVenta()*0.19);*/
					 /*.append("valorTotalVenta",  )
					 .append("valorTotalIva", valorIvas )
					 .append("VentaconIva", valorVenta);*/
					 
			ventas.insertOne(documento);
			System.out.println("Documento creado");
			this.cerrar();
			rta = true;
		} catch (Exception e) {
			System.out.println("No se pudo agregar el documento");
		}
		//ValordeVenta(ventaDto);
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
				nuevo.setCodigoProducto1(doc.getString("codigoProducto1"));
				nuevo.setCantidadProducto1(doc.getInteger("cantidadProducto1"));
				nuevo.setValorUnitario1(doc.getDouble("valorUnitario1"));
				nuevo.setCodigoProducto2(doc.getString("codigoProducto2"));
				nuevo.setCantidadProducto2(doc.getInteger("cantidadProducto2"));
				nuevo.setValorUnitario2(doc.getDouble("valorUnitario2"));
				nuevo.setCodigoProducto3(doc.getString("codigoProducto3"));
				nuevo.setCantidadProducto3(doc.getInteger("cantidadProducto3"));
				nuevo.setValorUnitario3(doc.getDouble("valorUnitario3"));
				nuevo.setValorProducto1(doc.getDouble("valorProducto1"));
				nuevo.setValorProducto2(doc.getDouble("valorProducto2"));
				nuevo.setValorProducto3(doc.getDouble("valorProducto3"));
				nuevo.setValorTotalVenta(doc.getDouble("valorTotalVenta"));
				nuevo.setValorTotalIva(doc.getDouble("valorTotalIva"));
				nuevo.setValorTotalVentaConIva(doc.getDouble("valorTotalVentaConIva"));
				
				
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
				nuevo.setCodigoProducto1(doc.getString("codigoProducto1"));
				nuevo.setCantidadProducto1(doc.getInteger("cantidadProducto1"));
				nuevo.setValorUnitario1(doc.getDouble("valorUnitario1"));
				nuevo.setCodigoProducto2(doc.getString("codigoProducto2"));
				nuevo.setCantidadProducto2(doc.getInteger("cantidadProducto2"));
				nuevo.setValorUnitario2(doc.getDouble("valorUnitario2"));
				nuevo.setCodigoProducto3(doc.getString("codigoProducto3"));
				nuevo.setCantidadProducto3(doc.getInteger("cantidadProducto3"));
				nuevo.setValorUnitario3(doc.getDouble("valorUnitario3"));
				nuevo.setValorProducto1(doc.getDouble("valorProducto1"));
				nuevo.setValorProducto2(doc.getDouble("valorProducto2"));
				nuevo.setValorProducto3(doc.getDouble("valorProducto3"));
				nuevo.setValorTotalVenta(doc.getDouble("valorTotalVenta"));
				nuevo.setValorTotalIva(doc.getDouble("valorTotalIva"));
				nuevo.setValorTotalVentaConIva(doc.getDouble("valorTotalVentaConIva"));
				
				listado.add(nuevo);
			}
			System.out.println("Documento encontrado");
		} catch (Exception e) {
			System.out.println("No se pudo encontrar el documento");
		}
		this.cerrar();
		return listado;
		
	}
	
	
	
}
