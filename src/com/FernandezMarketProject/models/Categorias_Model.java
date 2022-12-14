package com.FernandezMarketProject.models;

import java.io.InputStream;

public class Categorias_Model {
	private byte IdCategoria;
	private String TituloCategoria;
	private InputStream ImagenCategoria;
	
	 
	

	public Categorias_Model(byte idCategoria, String tituloCategoria, InputStream imagenCategoria) {
		super();
		IdCategoria = idCategoria;
		TituloCategoria = tituloCategoria;
		ImagenCategoria = imagenCategoria;
	}

	public Categorias_Model(byte idCategoria) {
		super();
		IdCategoria = idCategoria;
	}

	public Categorias_Model(String tituloCategoria) {
		super();
		TituloCategoria = tituloCategoria;
	}

	public Categorias_Model() {
		super();
	}

	public byte getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(byte idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getTituloCategoria() {
		return TituloCategoria;
	}

	public void setTituloCategoria(String tituloCategoria) {
		TituloCategoria = tituloCategoria;
	}

	public InputStream getImagenCategoria() {
		return ImagenCategoria;
	}

	public void setImagenCategoria(InputStream imagenCategoria) {
		ImagenCategoria = imagenCategoria;
	} 
	
	
}
