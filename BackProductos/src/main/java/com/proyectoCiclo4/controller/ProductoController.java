package com.proyectoCiclo4.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoCiclo4.dao.ProductoDao;
import com.proyectoCiclo4.dto.ProductoDto;
import com.proyectoCiclo4.dto.ProductoRequestDto;
import com.proyectoCiclo4.enums.CollectionEnum;



@CrossOrigin(origins = "*")
@RestController
public class ProductoController {
	
	@PostMapping("/crearProducto")
	public boolean crearCliente(@RequestBody ProductoRequestDto productoRequest) {
		ProductoDao producto = new ProductoDao(getCollectionEnum(productoRequest.getCiudad()));
		return producto.crear(productoRequest.getProductoDto());
	}
	
	@GetMapping("/listarProducto/{ciudad}")
	public ArrayList<ProductoDto> listarProducto(@PathVariable("ciudad") String ciudad) {
		ArrayList<ProductoDto> listado;
		ProductoDao producto = new ProductoDao(getCollectionEnum(ciudad));
		listado = producto.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarProducto/{codigo}/{ciudad}")
	public boolean eliminarProducto(@PathVariable("codigo") String codigo, @PathVariable("ciudad") String ciudad) {
		boolean rta = false;
		ProductoDao producto = new ProductoDao(getCollectionEnum(ciudad));
		rta = producto.eliminar(codigo);
		return rta;
	}
	
	@GetMapping("/buscarProducto/{cedula}/{ciudad}")
	public ArrayList<ProductoDto> buscarProducto(@PathVariable("cedula") String codigo, @PathVariable("ciudad") String ciudad) {
		ArrayList<ProductoDto> listado;
		ProductoDao producto = new ProductoDao(getCollectionEnum(ciudad));
		listado = producto.buscar(codigo);
		return listado;
	}
	
	@PutMapping("/actualizarProducto/{codigo}")
	public boolean actualizarProducto(@PathVariable("codigo") String codigo, @RequestBody ProductoRequestDto productoRequest) {
		boolean estado = false;
		ProductoDao producto = new ProductoDao(getCollectionEnum(productoRequest.getCiudad()));
		estado = producto.actualizar(codigo, productoRequest.getProductoDto());
		return estado;
	}
	
	private CollectionEnum getCollectionEnum(String ciudad) {
		return CollectionEnum.valueOf(ciudad.toUpperCase());
	}
}
