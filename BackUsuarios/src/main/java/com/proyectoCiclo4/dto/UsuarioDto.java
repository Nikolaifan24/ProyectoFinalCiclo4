package com.proyectoCiclo4.dto;

public class UsuarioDto {
	
	private String usuario;
	private String password;
	
	public UsuarioDto() {
		
	}

	public UsuarioDto(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
