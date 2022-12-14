package com.FernandezMarketProject.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedidos_Model {
	private long IdPedido;
	private Date FechaCreacionPedido;
	private String DomicilioPedido;
	private String TelefonoClientePedido;
	private String BancoClientePedido;
	private String NumCuentaClientePedido;
	
	private BigDecimal PrecioTotalPedido;
	private long UsuarioPedido;

	
	private String Calle;
	private String N_Int;
	private String N_Ext;
	private String Colonia;
	private String Estado;
	private String Municipio;
	private String CP;
	
	
	
	public Pedidos_Model(long idPedido, Date fechaCreacionPedido, String domicilioPedido, String telefonoClientePedido,
			String bancoClientePedido, String numCuentaClientePedido, BigDecimal precioTotalProducto, long usuarioPedido) {
		super();
		IdPedido = idPedido;
		FechaCreacionPedido = fechaCreacionPedido;
		DomicilioPedido = domicilioPedido;
		TelefonoClientePedido = telefonoClientePedido;
		BancoClientePedido = bancoClientePedido;
		NumCuentaClientePedido = numCuentaClientePedido;
		PrecioTotalPedido = precioTotalProducto;
		UsuarioPedido = usuarioPedido;
	}


	

	public Pedidos_Model(String domicilioPedido, String telefonoClientePedido,
			String bancoClientePedido, String numCuentaClientePedido, BigDecimal precioTotalPedido, long usuarioPedido) {
		super();
		DomicilioPedido = domicilioPedido;
		TelefonoClientePedido = telefonoClientePedido;
		BancoClientePedido = bancoClientePedido;
		NumCuentaClientePedido = numCuentaClientePedido;
		PrecioTotalPedido = precioTotalPedido;
		UsuarioPedido = usuarioPedido;
	}




	public Pedidos_Model() {
		super();
	}


	public long getIdPedido() {
		return IdPedido;
	}


	public void setIdPedido(long idPedido) {
		IdPedido = idPedido;
	}


	public Date getFechaCreacionPedido() {
		return FechaCreacionPedido;
	}


	public void setFechaCreacionPedido(Date fechaCreacionPedido) {
		FechaCreacionPedido = fechaCreacionPedido;
	}


	public String getDomicilioPedido() {
		return DomicilioPedido;
	}


	public void setDomicilioPedido(String domicilioPedido) {
		DomicilioPedido = domicilioPedido;
	}


	public String getTelefonoClientePedido() {
		return TelefonoClientePedido;
	}


	public void setTelefonoClientePedido(String telefonoClientePedido) {
		TelefonoClientePedido = telefonoClientePedido;
	}


	public String getBancoClientePedido() {
		return BancoClientePedido;
	}


	public void setBancoClientePedido(String bancoClientePedido) {
		BancoClientePedido = bancoClientePedido;
	}


	public String getNumCuentaClientePedido() {
		return NumCuentaClientePedido;
	}


	public void setNumCuentaClientePedido(String numCuentaClientePedido) {
		NumCuentaClientePedido = numCuentaClientePedido;
	}


	public BigDecimal getPrecioTotalPedido() {
		return PrecioTotalPedido;
	}


	public void setPrecioTotalPedido(BigDecimal precioTotalProducto) {
		PrecioTotalPedido = precioTotalProducto;
	}


	public long getUsuarioPedido() {
		return UsuarioPedido;
	}

	
	public void setUsuarioPedido(long usuarioPedido) {
		UsuarioPedido = usuarioPedido;
	}



	public void createDireccionCompleta() {
		try {
			
		
		String[] parts = DomicilioPedido.split(", ");
		
		Calle = parts[0];
		String numeroCompleto = parts[1];
		Colonia = parts[2];
		Municipio = parts[3];
		Estado = parts[4];
		CP = parts[5];
		
		
		String[] numeros = numeroCompleto.split(" - ");
		
		N_Int = numeros[0];
		if (numeros.length == 2)
			N_Ext = numeros[1];
		
		}
		catch(Exception  e) {
			Calle = "";
			String numeroCompleto = "";
			Colonia = "";
			Municipio = "";
			Estado = "";
			CP = "";
			
			N_Int = "";
			N_Ext = "";
			
			TelefonoClientePedido = "";
			BancoClientePedido = "";
			NumCuentaClientePedido = "";
		}
		
	}
	
	

	public String getCalle() {
		return Calle;
	}




	public void setCalle(String calle) {
		Calle = calle;
	}




	public String getN_Int() {
		return N_Int;
	}




	public void setN_Int(String n_Int) {
		N_Int = n_Int;
	}




	public String getN_Ext() {
		return N_Ext;
	}




	public void setN_Ext(String n_Ext) {
		N_Ext = n_Ext;
	}




	public String getColonia() {
		return Colonia;
	}




	public void setColonia(String colonia) {
		Colonia = colonia;
	}




	public String getEstado() {
		return Estado;
	}




	public void setEstado(String estado) {
		Estado = estado;
	}




	public String getMunicipio() {
		return Municipio;
	}




	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}




	public String getCP() {
		return CP;
	}




	public void setCP(String cP) {
		CP = cP;
	}
	
	
	
	
	
}
