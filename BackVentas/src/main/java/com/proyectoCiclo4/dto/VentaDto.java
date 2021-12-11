package com.proyectoCiclo4.dto;

public class VentaDto {
	
	private String codigoVenta;
	private String cedulaCliente;
	private String codigoProducto;
	private String cantidadProducto;
	private String valorUnitario;
	private String valorProducto;
	private String valorIvaProducto;
	private String valorTotalVenta;
	private String valorTotalIva;
	private String valorTotalVentaConIva;
	private String precioVenta;
	
	public VentaDto() {
		
	}

	public VentaDto(String codigoVenta, String cedulaCliente, String codigoProducto, String cantidadProducto,
			String valorUnitario, String valorProducto, String valorIvaProducto, String valorTotalVenta,
			String valorTotalIva, String valorTotalVentaConIva, String precioVenta) {
		this.codigoVenta = codigoVenta;
		this.cedulaCliente = cedulaCliente;
		this.codigoProducto = codigoProducto;
		this.cantidadProducto = cantidadProducto;
		this.valorUnitario = valorUnitario;
		this.valorProducto = valorProducto;
		this.valorIvaProducto = valorIvaProducto;
		this.valorTotalVenta = valorTotalVenta;
		this.valorTotalIva = valorTotalIva;
		this.valorTotalVentaConIva = valorTotalVentaConIva;
		this.precioVenta = precioVenta;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(String codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(String cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(String valorProducto) {
		this.valorProducto = valorProducto;
	}

	public String getValorIvaProducto() {
		return valorIvaProducto;
	}

	public void setValorIvaProducto(String valorIvaProducto) {
		this.valorIvaProducto = valorIvaProducto;
	}

	public String getValorTotalVenta() {
		return valorTotalVenta;
	}

	public void setValorTotalVenta(String valorTotalVenta) {
		this.valorTotalVenta = valorTotalVenta;
	}

	public String getValorTotalIva() {
		return valorTotalIva;
	}

	public void setValorTotalIva(String valorTotalIva) {
		this.valorTotalIva = valorTotalIva;
	}

	public String getValorTotalVentaConIva() {
		return valorTotalVentaConIva;
	}

	public void setValorTotalVentaConIva(String valorTotalVentaConIva) {
		this.valorTotalVentaConIva = valorTotalVentaConIva;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
}
