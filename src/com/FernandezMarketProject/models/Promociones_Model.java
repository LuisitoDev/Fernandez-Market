package com.FernandezMarketProject.models;

import java.io.InputStream;

public class Promociones_Model {
	private int IdPromocion;
	private InputStream ImagenPromocion;
	private short Subcategoria; 
	
	public Promociones_Model(int idMarca, InputStream imagenMarca, short subcategoria) {
		super();
		IdPromocion = idMarca;
		ImagenPromocion = imagenMarca;
		Subcategoria = subcategoria;
	}




	public Promociones_Model(int idMarca) {
		super();
		IdPromocion = idMarca;
	}
	

	public Promociones_Model() {
		super();
	}




	public int getIdPromocion() {
		return IdPromocion;
	}




	public void setIdPromocion(int idPromocion) {
		IdPromocion = idPromocion;
	}




	public InputStream getImagenPromocion() {
		return ImagenPromocion;
	}




	public void setImagenPromocion(InputStream imagenPromocion) {
		ImagenPromocion = imagenPromocion;
	}




	public short getSubcategoria() {
		return Subcategoria;
	}




	public void setSubcategoria(short subcategoria) {
		Subcategoria = subcategoria;
	}


	 
	 
}
