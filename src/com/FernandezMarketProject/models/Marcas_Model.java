package com.FernandezMarketProject.models;

import java.io.InputStream;

public class Marcas_Model {
	private int IdMarca;
	private String NombreMarca;
	private InputStream ImagenMarca;
	private String PaginaMarca; 
	

	
	
	


	public Marcas_Model(int idMarca, String nombreMarca, InputStream imagenMarca, String paginaMarca) {
		super();
		IdMarca = idMarca;
		NombreMarca = nombreMarca;
		ImagenMarca = imagenMarca;
		PaginaMarca = paginaMarca;
	}




	public Marcas_Model(int idMarca) {
		super();
		IdMarca = idMarca;
	}
	
	


	public Marcas_Model(String nombreCategoria, InputStream imagenMarca) {
		super();
		NombreMarca = nombreCategoria;
		ImagenMarca = imagenMarca;
	}



	public Marcas_Model() {
		super();
	}


	public int getIdMarca() {
		return IdMarca;
	}



	public void setIdMarca(int idMarca) {
		IdMarca = idMarca;
	}



	public String getNombreCategoria() {
		return NombreMarca;
	}



	public void setNombreCategoria(String nombreCategoria) {
		NombreMarca = nombreCategoria;
	}



	public InputStream getImagenMarca() {
		return ImagenMarca;
	}



	public void setImagenPerfilUsuario(InputStream imagenMarca) {
		ImagenMarca = imagenMarca;
	}




	public String getNombreMarca() {
		return NombreMarca;
	}




	public void setNombreMarca(String nombreMarca) {
		NombreMarca = nombreMarca;
	}




	public String getPaginaMarca() {
		return PaginaMarca;
	}




	public void setPaginaMarca(String paginaMarca) {
		PaginaMarca = paginaMarca;
	}




	public void setImagenMarca(InputStream imagenMarca) {
		ImagenMarca = imagenMarca;
	}


	 
	 
}
