package com.proyectoCiclo4.dto;

public class VentaDto {
	
	private String codigoVenta;
	private String cedulaCliente;
	private String codigoProducto1;
	private int cantidadProducto1;
	private Double valorUnitario1;
	private String codigoProducto2;
	private int cantidadProducto2;
	private Double valorUnitario2;
	private String codigoProducto3;
	private int cantidadProducto3;
	private Double valorUnitario3;
	private Double valorProducto1;
	private Double valorProducto2;
	private Double valorProducto3;
	private Double valorTotalVenta;
	private Double valorTotalIva;
	private Double valorTotalVentaConIva;
		
	public VentaDto() {
		
	}

	public VentaDto(String codigoVenta, String cedulaCliente, String codigoProducto1, int cantidadProducto1,
			Double valorUnitario1, String codigoProducto2, int cantidadProducto2, Double valorUnitario2,
			String codigoProducto3, int cantidadProducto3, Double valorUnitario3, Double valorProducto1,
			Double valorProducto2, Double valorProducto3, Double valorTotalVenta, Double valorTotalIva,
			Double valorTotalVentaConIva) {
		super();
		this.codigoVenta = codigoVenta;
		this.cedulaCliente = cedulaCliente;
		this.codigoProducto1 = codigoProducto1;
		this.cantidadProducto1 = cantidadProducto1;
		this.valorUnitario1 = valorUnitario1;
		this.codigoProducto2 = codigoProducto2;
		this.cantidadProducto2 = cantidadProducto2;
		this.valorUnitario2 = valorUnitario2;
		this.codigoProducto3 = codigoProducto3;
		this.cantidadProducto3 = cantidadProducto3;
		this.valorUnitario3 = valorUnitario3;
		this.valorProducto1 = valorProducto1;
		this.valorProducto2 = valorProducto2;
		this.valorProducto3 = valorProducto3;
		this.valorTotalVenta = valorTotalVenta;
		this.valorTotalIva = valorTotalIva;
		this.valorTotalVentaConIva = valorTotalVentaConIva;
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

	public String getCodigoProducto1() {
		return codigoProducto1;
	}

	public void setCodigoProducto1(String codigoProducto1) {
		this.codigoProducto1 = codigoProducto1;
	}

	public int getCantidadProducto1() {
		return cantidadProducto1;
	}

	public void setCantidadProducto1(int cantidadProducto1) {
		this.cantidadProducto1 = cantidadProducto1;
	}

	public Double getValorUnitario1() {
		return valorUnitario1;
	}

	public void setValorUnitario1(Double valorUnitario1) {
		this.valorUnitario1 = valorUnitario1;
	}

	public String getCodigoProducto2() {
		return codigoProducto2;
	}

	public void setCodigoProducto2(String codigoProducto2) {
		this.codigoProducto2 = codigoProducto2;
	}

	public int getCantidadProducto2() {
		return cantidadProducto2;
	}

	public void setCantidadProducto2(int cantidadProducto2) {
		this.cantidadProducto2 = cantidadProducto2;
	}

	public Double getValorUnitario2() {
		return valorUnitario2;
	}

	public void setValorUnitario2(Double valorUnitario2) {
		this.valorUnitario2 = valorUnitario2;
	}

	public String getCodigoProducto3() {
		return codigoProducto3;
	}

	public void setCodigoProducto3(String codigoProducto3) {
		this.codigoProducto3 = codigoProducto3;
	}

	public int getCantidadProducto3() {
		return cantidadProducto3;
	}

	public void setCantidadProducto3(int cantidadProducto3) {
		this.cantidadProducto3 = cantidadProducto3;
	}

	public Double getValorUnitario3() {
		return valorUnitario3;
	}

	public void setValorUnitario3(Double valorUnitario3) {
		this.valorUnitario3 = valorUnitario3;
	}

	public Double getValorProducto1() {
		return valorProducto1;
	}

	public void setValorProducto1(Double valorProducto1) {
		this.valorProducto1 = valorProducto1;
	}

	public Double getValorProducto2() {
		return valorProducto2;
	}

	public void setValorProducto2(Double valorProducto2) {
		this.valorProducto2 = valorProducto2;
	}

	public Double getValorProducto3() {
		return valorProducto3;
	}

	public void setValorProducto3(Double valorProducto3) {
		this.valorProducto3 = valorProducto3;
	}

	public Double getValorTotalVenta() {
		return valorTotalVenta;
	}

	public void setValorTotalVenta(Double valorTotalVenta) {
		this.valorTotalVenta = valorTotalVenta;
	}

	public Double getValorTotalIva() {
		return valorTotalIva;
	}

	public void setValorTotalIva(Double valorTotalIva) {
		this.valorTotalIva = valorTotalIva;
	}

	public Double getValorTotalVentaConIva() {
		return valorTotalVentaConIva;
	}

	public void setValorTotalVentaConIva(Double valorTotalVentaConIva) {
		this.valorTotalVentaConIva = valorTotalVentaConIva;
	}

	
	
	
}
