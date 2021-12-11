package com.proyectoCiclo4.dto;

import com.proyectoCiclo4.enums.CollectionEnum;

public class ClienteRequestDto {
	
	private ClienteDto clienteDto;
	private String ciudad;
	
	public ClienteDto getClienteDto() {
		return clienteDto;
	}
	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
