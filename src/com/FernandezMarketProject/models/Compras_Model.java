package com.FernandezMarketProject.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compras_Model {
	private long IdCompra;
	private long PedidoCompra;
	private long ProductoCompra;
	private short CantidadPiezasCompra;
	private BigDecimal PrecioProductoCompra;
	
	public Compras_Model() {
		super();
	}

	public Compras_Model(long idCompra, long pedidoCompra, long productoCompra, short cantidadPiezasCompra,
			BigDecimal precioProductoCompra) {
		super();
		IdCompra = idCompra;
		PedidoCompra = pedidoCompra;
		ProductoCompra = productoCompra;
		CantidadPiezasCompra = cantidadPiezasCompra;
		PrecioProductoCompra = precioProductoCompra;
	}

	public long getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(long idCompra) {
		IdCompra = idCompra;
	}

	public long getPedidoCompra() {
		return PedidoCompra;
	}

	public void setPedidoCompra(long pedidoCompra) {
		PedidoCompra = pedidoCompra;
	}

	public long getProductoCompra() {
		return ProductoCompra;
	}

	public void setProductoCompra(long productoCompra) {
		ProductoCompra = productoCompra;
	}

	public short getCantidadPiezasCompra() {
		return CantidadPiezasCompra;
	}

	public void setCantidadPiezasCompra(short cantidadPiezasCompra) {
		CantidadPiezasCompra = cantidadPiezasCompra;
	}

	public BigDecimal getPrecioProductoCompra() {
		return PrecioProductoCompra;
	}

	public void setPrecioProductoCompra(BigDecimal precioProductoCompra) {
		PrecioProductoCompra = precioProductoCompra;
	}
	
	
	
}
