package com.FernandezMarketProject.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Productos_Model {
	private long IdProducto;
	private String NombreProducto; 
	private String DescripcionProducto; 
	private InputStream ImagenProducto;
	private BigDecimal PrecioProducto;
	private BigDecimal DescuentoProducto; 
	 
	private Date FechaCreacionProducto;
	private int CantidadStockProducto;
	 
	private int MarcaProducto;
	 
	private short SubcategoriaProducto;
	  
	private String MarcaProductoTexto;

	//No va en el constructor
	private long IdUsuario;
	
	private String TituloSubcategoria;

	 private int NumeroProductoPagina;
	 
	 private short cantidadPiezasComprar;
	
	public Productos_Model(long idProducto) {
		super();
		IdProducto = idProducto;
	}







	public Productos_Model(long idProducto, String nombreProducto, String descripcionProducto,
			InputStream imagenProducto, BigDecimal precioProducto, BigDecimal descuentoProducto,
			Date fechaCreacionProducto, int cantidadStockProducto, int marcaProducto, short subcategoriaProducto,
			String marcaProductoTexto, String tituloSubcategoria) {
		super();
		IdProducto = idProducto;
		NombreProducto = nombreProducto;
		DescripcionProducto = descripcionProducto;
		ImagenProducto = imagenProducto;
		PrecioProducto = precioProducto;
		DescuentoProducto = descuentoProducto;
		FechaCreacionProducto = fechaCreacionProducto;
		CantidadStockProducto = cantidadStockProducto;
		MarcaProducto = marcaProducto;
		SubcategoriaProducto = subcategoriaProducto;
		MarcaProductoTexto = marcaProductoTexto;
		TituloSubcategoria = tituloSubcategoria;

	}


	


	public Productos_Model() {
		super();
	}




	public long getIdProducto() {
		return IdProducto;
	}




	public void setIdProducto(long idProducto) {
		IdProducto = idProducto;
	}




	public String getNombreProducto() {
		return NombreProducto;
	}




	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}




	public String getDescripcionProducto() {
		return DescripcionProducto;
	}




	public void setDescripcionProducto(String descripcionProducto) {
		DescripcionProducto = descripcionProducto;
	}




	public InputStream getImagenProducto() {
		return ImagenProducto;
	}




	public void setImagenProducto(InputStream imagenProducto) {
		ImagenProducto = imagenProducto;
	}




	public BigDecimal getPrecioProducto() {
		return PrecioProducto;
	}




	public void setPrecioProducto(BigDecimal precioProducto) {
		PrecioProducto = precioProducto;
	}

	
	public BigDecimal getPrecioFinalProducto() {
		BigDecimal PrecioFinalProducto = PrecioProducto.subtract(getValorDescontado());
		
		PrecioFinalProducto = PrecioFinalProducto.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return PrecioFinalProducto;
	}

	public BigDecimal getValorDescontado() {
		BigDecimal valorAux = PrecioProducto.multiply(DescuentoProducto);
		BigDecimal divisor = new BigDecimal(100);
		
		BigDecimal valorDividido = valorAux.divide(divisor);
		
		valorDividido = valorDividido.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return valorDividido;
	}


	public BigDecimal getDescuentoProducto() {
		return DescuentoProducto;
	}
	
	public BigDecimal getProcentajeDescuentoProducto() {
		return DescuentoProducto.setScale(0, BigDecimal.ROUND_HALF_EVEN);
	}




	public void setDescuentoProducto(BigDecimal descuentoProducto) {
		DescuentoProducto = descuentoProducto;
	}




	public Date getFechaCreacionProducto() {
		return FechaCreacionProducto;
	}




	public void setFechaCreacionProducto(Date fechaCreacionProducto) {
		FechaCreacionProducto = fechaCreacionProducto;
	}




	public int getCantidadStockProducto() {
		return CantidadStockProducto;
	}




	public void setCantidadStockProducto(int cantidadStockProducto) {
		CantidadStockProducto = cantidadStockProducto;
	}




	public int getMarcaProducto() {
		return MarcaProducto;
	}




	public void setMarcaProducto(int marcaProducto) {
		MarcaProducto = marcaProducto;
	}




	public short getSubcategoriaProducto() {
		return SubcategoriaProducto;
	}




	public void setSubcategoriaProducto(short subcategoriaProducto) {
		SubcategoriaProducto = subcategoriaProducto;
	}





	public String getMarcaProductoTexto() {
		return MarcaProductoTexto;
	}



	public void setMarcaProductoTexto(String marcaProductoTexto) {
		MarcaProductoTexto = marcaProductoTexto;
	}


	public long getIdUsuario() {
		return IdUsuario;
	}


	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}

	

	public String getTituloSubcategoria() {
		return TituloSubcategoria;
	}


	public void setTituloSubcategoria(String tituloSubcategoria) {
		TituloSubcategoria = tituloSubcategoria;
	}


	public int getNumeroProductoPagina() {
		return NumeroProductoPagina;
	}

	public void setNumeroProductoPagina(int numeroProductoPagina) {
		NumeroProductoPagina = numeroProductoPagina;
	}







	public short getCantidadPiezasComprar() {
		return cantidadPiezasComprar;
	}







	public void setCantidadPiezasComprar(short cantidadPiezasComprar) {
		this.cantidadPiezasComprar = cantidadPiezasComprar;
	}

	
	
	public BigDecimal getTotalPorPiezas() {
		BigDecimal precioFinal = getPrecioFinalProducto();
		BigDecimal cantidadPiezas = new BigDecimal(cantidadPiezasComprar); 
		
		return precioFinal.multiply(cantidadPiezas);
		
	}
	


	
	
}
