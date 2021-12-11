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
import com.proyectoCiclo4.dao.ClienteDao;
import com.proyectoCiclo4.dto.ClienteDto;
import com.proyectoCiclo4.dto.ClienteRequestDto;
import com.proyectoCiclo4.enums.CollectionEnum;



@CrossOrigin(origins = "*")
@RestController
public class ClienteController {
	
	@PostMapping("/crearCliente")
	public boolean crearCliente(@RequestBody ClienteRequestDto clienteRequest) {
		ClienteDao cliente = new ClienteDao(getCollectionEnum(clienteRequest.getCiudad()));
		return cliente.crear(clienteRequest.getClienteDto());
	}
	
	@GetMapping("/listarCliente/{ciudad}")
	public ArrayList<ClienteDto> listarCliente(@PathVariable("ciudad") String ciudad) {
		ArrayList<ClienteDto> listado;
		ClienteDao cliente = new ClienteDao(getCollectionEnum(ciudad));
		listado = cliente.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarCliente/{cedula}/{ciudad}")
	public boolean eliminarCliente(@PathVariable("cedula") String cedula, @PathVariable("ciudad") String ciudad) {
		boolean rta = false;
		ClienteDao cliente = new ClienteDao(getCollectionEnum(ciudad));
		rta = cliente.eliminar(cedula);
		return rta;
	}
	
	@GetMapping("/buscarCliente/{cedula}/{ciudad}")
	public ArrayList<ClienteDto> buscarCliente(@PathVariable("cedula") String cedula, @PathVariable("ciudad") String ciudad) {
		ArrayList<ClienteDto> listado;
		ClienteDao cliente = new ClienteDao(getCollectionEnum(ciudad));
		listado = cliente.buscar(cedula);
		return listado;
	}
	
	@PutMapping("/actualizarCliente/{cedula}")
	public boolean actualizarCliente(@PathVariable("cedula") String cedula, @RequestBody ClienteRequestDto clienteRequest) {
		boolean estado = false;
		ClienteDao cliente = new ClienteDao(getCollectionEnum(clienteRequest.getCiudad()));
		estado = cliente.actualizar(cedula, clienteRequest.getClienteDto());
		return estado;
	}
	
	private CollectionEnum getCollectionEnum(String ciudad) {
		return CollectionEnum.valueOf(ciudad.toUpperCase());
	}
}
