package com.proyectoCiclo4.dto;

public class ProductoDto {
	
	private String codigo;
	private String nombre;
	private String nitproveedor;
	private String precioCompra;
	private String ivaCompra;
	private String precioVenta;
	
	public ProductoDto() {
		
	}

	public ProductoDto(String codigo, String nombre, String nitproveedor, String precioCompra, String ivaCompra,
			String precioVenta) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nitproveedor = nitproveedor;
		this.precioCompra = precioCompra;
		this.ivaCompra = ivaCompra;
		this.precioVenta = precioVenta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(String nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}

	public String getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(String ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
}
