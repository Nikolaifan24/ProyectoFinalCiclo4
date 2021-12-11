package com.proyectoCiclo4.dto;

public class VentaRequestDto {
	
	private VentaDto ventaDto;
	private String ciudad;
	public VentaDto getVentaDto() {
		return ventaDto;
	}
	public void setVentaDto(VentaDto ventaDto) {
		this.ventaDto = ventaDto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
