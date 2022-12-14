package com.FernandezMarketProject.models;

import java.io.InputStream;

public class Subcategorias_Model {
	private short IdSubcategoria;
	private String TituloSubcategoria;
	private byte CategoriaPadre;
	private InputStream ImagenSubcategoria;

	private short CantidadProductos;

	private String NombreProducto; 
	
	
	
	



	public Subcategorias_Model(short idSubcategoria, String tituloSubcategoria, byte categoriaPadre,
			InputStream imagenSubcategoria, short cantidadProductos) {
		super();
		IdSubcategoria = idSubcategoria;
		TituloSubcategoria = tituloSubcategoria;
		CategoriaPadre = categoriaPadre;
		ImagenSubcategoria = imagenSubcategoria;
		CantidadProductos = cantidadProductos;
	}



	public String getNombreProducto() {
		return NombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}



	public Subcategorias_Model(short idSubcategoria) {
		super();
		IdSubcategoria = idSubcategoria;
	}
	
	

	public Subcategorias_Model(String tituloSubcategoria, byte categoriaPadre) {
		super();
		TituloSubcategoria = tituloSubcategoria;
		CategoriaPadre = categoriaPadre;
	}
	
	public Subcategorias_Model() {
		super();
	}

	public short getIdSubcategoria() {
		return IdSubcategoria;
	}


	public void setIdSubcategoria(short idSubcategoria) {
		IdSubcategoria = idSubcategoria;
	}


	public String getTituloSubcategoria() {
		return TituloSubcategoria;
	}


	public void setTituloSubcategoria(String tituloSubcategoria) {
		TituloSubcategoria = tituloSubcategoria;
	}


	public byte getCategoriaPadre() {
		return CategoriaPadre;
	}


	public void setCategoriaPadre(byte categoriaPadre) {
		CategoriaPadre = categoriaPadre;
	}
	

	public short getCantidadProductos() {
		return CantidadProductos;
	}


	public void setCantidadProductos(short cantidadProductos) {
		CantidadProductos = cantidadProductos;
	}



	public InputStream getImagenSubcategoria() {
		return ImagenSubcategoria;
	}



	public void setImagenSubcategoria(InputStream imagenSubcategoria) {
		ImagenSubcategoria = imagenSubcategoria;
	}
	
	

}
