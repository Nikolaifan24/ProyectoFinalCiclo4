package com.proyectoCiclo4.dto;

public class ProductoRequestDto {
	
	private ProductoDto productoDto;
	private String ciudad;
	public ProductoDto getProductoDto() {
		return productoDto;
	}
	public void setProductoDto(ProductoDto productoDto) {
		this.productoDto = productoDto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
