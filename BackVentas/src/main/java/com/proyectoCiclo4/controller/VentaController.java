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

import com.proyectoCiclo4.dao.VentaDao;
import com.proyectoCiclo4.dto.VentaDto;
import com.proyectoCiclo4.dto.VentaRequestDto;
import com.proyectoCiclo4.enums.CollectionEnum;



@CrossOrigin(origins = "*")
@RestController
public class VentaController {
	
	@PostMapping("/crearVenta")
	public boolean crearVenta(@RequestBody VentaRequestDto ventaRequest) {
		VentaDao venta = new VentaDao(getCollectionEnum(ventaRequest.getCiudad()));
		return venta.crear(ventaRequest.getVentaDto());
	}
	
	@GetMapping("/listarVenta/{ciudad}")
	public ArrayList<VentaDto> listarVenta(@PathVariable("ciudad") String ciudad) {
		ArrayList<VentaDto> listado;
		VentaDao venta = new VentaDao(getCollectionEnum(ciudad));
		listado = venta.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarVenta/{codigoVenta}/{ciudad}")
	public boolean eliminarVenta(@PathVariable("codigoVenta") String codigoVenta, @PathVariable("ciudad") String ciudad) {
		boolean rta = false;
		VentaDao venta = new VentaDao(getCollectionEnum(ciudad));
		rta = venta.eliminar(codigoVenta);
		return rta;
	}
	
	@GetMapping("/buscarVenta/{codigoVenta}/{ciudad}")
	public ArrayList<VentaDto> buscarVenta(@PathVariable("codigoVenta") String codigoVenta, @PathVariable("ciudad") String ciudad) {
		ArrayList<VentaDto> listado;
		VentaDao venta = new VentaDao(getCollectionEnum(ciudad));
		listado = venta.buscar(codigoVenta);
		return listado;
	}
	
	@PutMapping("/actualizarVenta/{codigoVenta}")
	public boolean actualizarVenta(@PathVariable("codigoVenta") String codigoVenta, @RequestBody VentaRequestDto ventaRequest) {
		boolean estado = false;
		VentaDao venta = new VentaDao(getCollectionEnum(ventaRequest.getCiudad()));
		estado = venta.actualizar(codigoVenta, ventaRequest.getVentaDto());
		return estado;
	}
	
	private CollectionEnum getCollectionEnum(String ciudad) {
		return CollectionEnum.valueOf(ciudad.toUpperCase());
	}
}
