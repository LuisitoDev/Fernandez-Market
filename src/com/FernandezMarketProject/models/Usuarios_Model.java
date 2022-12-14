/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Date;

/**
 *
 * @author magoc
 */
public class Usuarios_Model {

    private long IdUsuario;
    private String NombreUsuario; 
    private String ApellidoPaternoUsuario;
    private String ApellidoMaternoUsuario; 
    
    private String CorreoUsuario;
    private String PasswordUsuario;
    private Date FechaCreacionUsuario; 
    private byte EstadoUsuario;
    
    
	public Usuarios_Model(long idUsuario, String nombreUsuario, String apellidoPaternoUsuario,
			String apellidoMaternoUsuario, String correoUsuario, String passwordUsuario, 
			Date fechaCreacionUsuario, byte estadoUsuario) {
		super();
		IdUsuario = idUsuario;
		NombreUsuario = nombreUsuario;
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
		CorreoUsuario = correoUsuario;
		PasswordUsuario = passwordUsuario;
		FechaCreacionUsuario = fechaCreacionUsuario;
		EstadoUsuario = estadoUsuario;
	}
	
	
	
	
	
	public Usuarios_Model(long idUsuario) {
		super();
		IdUsuario = idUsuario;
	}






	public Usuarios_Model(String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario,
			String correoUsuario, String passwordUsuario, Date fechaCreacionUsuario, byte estadoUsuario) {
		super();
		NombreUsuario = nombreUsuario;
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
		CorreoUsuario = correoUsuario;
		PasswordUsuario = passwordUsuario;
		FechaCreacionUsuario = fechaCreacionUsuario;
		EstadoUsuario = estadoUsuario;
	}





	public Usuarios_Model(long idUsuario, String nombreUsuario, String apellidoPaternoUsuario,
			String apellidoMaternoUsuario, String passwordUsuario) {
		super();
		IdUsuario = idUsuario;
		NombreUsuario = nombreUsuario;
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
		PasswordUsuario = passwordUsuario;
	}


	public Usuarios_Model() {
		super();
	}


	


	public Usuarios_Model(String nombreUsuario, String apellidoPaternoUsuario, String apellidoMaternoUsuario,
			String correoUsuario, String passwordUsuario) {
		super();
		NombreUsuario = nombreUsuario;
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
		CorreoUsuario = correoUsuario;
		PasswordUsuario = passwordUsuario;
	}


	


	public Usuarios_Model(long idUsuario, String nombreUsuario, String apellidoPaternoUsuario,
			String apellidoMaternoUsuario, String correoUsuario, String passwordUsuario) {
		super();
		IdUsuario = idUsuario;
		NombreUsuario = nombreUsuario;
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
		CorreoUsuario = correoUsuario;
		PasswordUsuario = passwordUsuario;
	}





	public Usuarios_Model(String correoUsuario, String passwordUsuario) {
		super();
		CorreoUsuario = correoUsuario;
		PasswordUsuario = passwordUsuario;
	}
	



	public long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}
	public String getApellidoPaternoUsuario() {
		return ApellidoPaternoUsuario;
	}
	public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
		ApellidoPaternoUsuario = apellidoPaternoUsuario;
	}
	public String getApellidoMaternoUsuario() {
		return ApellidoMaternoUsuario;
	}
	public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
		ApellidoMaternoUsuario = apellidoMaternoUsuario;
	}
	public String getNombreCompletoUsuario() {
		String nombreCompleto = NombreUsuario + " " + ApellidoPaternoUsuario + " " + ApellidoMaternoUsuario;
		return nombreCompleto;
	}
	public String getCorreoUsuario() {
		return CorreoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		CorreoUsuario = correoUsuario;
	}
	public String getPasswordUsuario() {
		return PasswordUsuario;
	}
	public void setPasswordUsuario(String passwordUsuario) {
		PasswordUsuario = passwordUsuario;
	}
	public Date getFechaCreacionUsuario() {
		return FechaCreacionUsuario;
	}
	public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
		FechaCreacionUsuario = fechaCreacionUsuario;
	}
	public byte getEstadoUsuario() {
		return EstadoUsuario;
	}
	public String getEstadoUsuarioString() {
		if (EstadoUsuario == 1) {
			return "Activo";
		}
		else {
			return "Inactivo";
		}
	}
	public void setEstadoUsuario(byte estadoUsuario) {
		EstadoUsuario = estadoUsuario;
	}

}