package com.proyectoCiclo4.dto;


public class UsuarioRequestDto {
	
	private UsuarioDto usuarioDto;
	private String ciudad;
	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}
	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
