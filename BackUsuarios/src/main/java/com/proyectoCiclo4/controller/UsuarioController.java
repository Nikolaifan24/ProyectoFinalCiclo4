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

import com.proyectoCiclo4.dao.UsuarioDao;
import com.proyectoCiclo4.dto.UsuarioDto;
import com.proyectoCiclo4.dto.UsuarioRequestDto;
import com.proyectoCiclo4.enums.CollectionEnum;


@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
	

	@PostMapping("/login")
	public boolean login(@RequestBody UsuarioRequestDto usuarioRequest) {
		UsuarioDao usuario = new UsuarioDao(getCollectionEnum(usuarioRequest.getCiudad()));
		return usuario.login(usuarioRequest.getUsuarioDto());
	}
	
	@PostMapping("/crearUsuario")
	public boolean crearUsuario(@RequestBody UsuarioRequestDto usuarioRequest) {
		UsuarioDao usuario = new UsuarioDao(getCollectionEnum(usuarioRequest.getCiudad()));
		return usuario.crear(usuarioRequest.getUsuarioDto());
	}
	
	@GetMapping("/listarUsuario/{ciudad}")
	public ArrayList<UsuarioDto> listarUusario(@PathVariable("ciudad") String ciudad) {
		ArrayList<UsuarioDto> listado;
		UsuarioDao usuario = new UsuarioDao(getCollectionEnum(ciudad));
		listado = usuario.listar();
		return listado;
	}
	
	@DeleteMapping("/eliminarUsuario/{user}/{ciudad}")
	public boolean eliminarUsuario(@PathVariable("user") String user, @PathVariable("ciudad") String ciudad) {
		UsuarioDao usuario = new UsuarioDao(getCollectionEnum(ciudad));
		return usuario.eliminar(user);
	}
	
	@GetMapping("/buscarUsuario/{user}/{ciudad}")
	public ArrayList<UsuarioDto> buscarUsuario(@PathVariable("user") String user, @PathVariable("ciudad") String ciudad) {
		ArrayList<UsuarioDto> listado;
		UsuarioDao usuario= new UsuarioDao(getCollectionEnum(ciudad));
		listado = usuario.buscar(user);
		return listado;
	}
	
	@PutMapping("/actualizarUsuario/{user}")
	public boolean actualizarUsuario(@PathVariable("user") String user, @RequestBody UsuarioRequestDto usuarioRequest) {
		UsuarioDao usuario = new UsuarioDao(getCollectionEnum(usuarioRequest.getCiudad()));
		return usuario.actualizar(user, usuarioRequest.getUsuarioDto());
	}
	
	private CollectionEnum getCollectionEnum(String ciudad) {
		return CollectionEnum.valueOf(ciudad.toUpperCase());
	}
}
