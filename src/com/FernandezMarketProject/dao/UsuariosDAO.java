/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.dao;

import com.FernandezMarketProject.models.Usuarios_Model;
import com.FernandezMarketProject.utils.DbConnection;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author magoc
 */
public class UsuariosDAO {

    /**
     * Inserta un usuario en la base de datos
     *
     * @param user
     * @return
     */
	
	public static int insertUpdateDeleteUsuario(String pOpc, Usuarios_Model usuario) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Usuarios(?, ?, ?, ?, ?, ?, ?, ?, ?);");
           
            statement.setString(1, pOpc);
            
            statement.setLong(2, usuario.getIdUsuario());
            
            statement.setString(3, usuario.getNombreUsuario());
           
            statement.setString(4, usuario.getApellidoPaternoUsuario());
            
            statement.setString(5, usuario.getApellidoMaternoUsuario());
            
            statement.setString(6, usuario.getCorreoUsuario());
            
            statement.setString(7, usuario.getPasswordUsuario());
            
            if (usuario.getFechaCreacionUsuario() != null) {
            java.util.Date utilDateFechaCrea = usuario.getFechaCreacionUsuario();
    		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());
    		
            statement.setDate(8, fechaConvertidaFechaCrea);
            }
            else {
            	statement.setDate(8, null);
            }
            
            statement.setByte(9, usuario.getEstadoUsuario());
            
            rowsAffectted = statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            rowsAffectted = 0;
        } finally {
        	statement.close();
            con.close();
        }
        return rowsAffectted;
    }

    public static List<Usuarios_Model> getUsuarios(String pOpc, Usuarios_Model usuario) throws Exception  {
        List<Usuarios_Model> listaUsuarios = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Usuarios(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);
            statement.setLong(2, usuario.getIdUsuario());
            statement.setString(3, usuario.getNombreUsuario());           
            statement.setString(4, usuario.getApellidoPaternoUsuario());            
            statement.setString(5, usuario.getApellidoMaternoUsuario());
            
            statement.setString(6, usuario.getCorreoUsuario());       
            statement.setString(7, usuario.getPasswordUsuario());
            
            if (usuario.getFechaCreacionUsuario() != null) {
            java.util.Date utilDateFechaCrea = usuario.getFechaCreacionUsuario();
    		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());            
            statement.setDate(8, fechaConvertidaFechaCrea);
            }
            else {
            	statement.setDate(8, null);
            }
            
            statement.setByte(9, usuario.getEstadoUsuario());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                long IdUsuario = resultSet.getLong("IdUsuario");
                String NombreUsuario = resultSet.getString("NombreUsuario");
                String ApellidoPaternoUsuario = resultSet.getString("ApellidoPaternoUsuario");
                String ApellidoMaternoUsuario = resultSet.getString("ApellidoMaternoUsuario");
                String CorreoUsuario = resultSet.getString("CorreoUsuario");
                String PasswordUsuario = resultSet.getString("PasswordUsuario");
                Date FechaCreacionUsuario = resultSet.getDate("FechaCreacionUsuario");
                byte EstadoUsuario = resultSet.getByte("EstadoUsuario");
                
//                long cantPreguntasUsuario = 0;
//                long cantRespuestasUsuario = 0;
//                long cantPreguntasFavoritasUsuario = 0;
//                long cantPreguntasUtilesUsuario = 0;
//                long cantPreguntasNoUtilesUsuario = 0;
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasUsuario"))
//                	cantPreguntasUsuario = resultSet.getLong("CantPreguntasUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantRespuestasUsuario"))
//                	cantRespuestasUsuario = resultSet.getLong("CantRespuestasUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasFavoritasUsuario"))
//                	cantPreguntasFavoritasUsuario = resultSet.getLong("CantPreguntasFavoritasUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasUtilesUsuario"))
//                	cantPreguntasUtilesUsuario = resultSet.getLong("CantPreguntasUtilesUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasNoUtilesUsuario"))
//                	cantPreguntasNoUtilesUsuario = resultSet.getLong("CantPreguntasNoUtilesUsuario");
                
                
                listaUsuarios.add(new Usuarios_Model(
                		IdUsuario, NombreUsuario, ApellidoPaternoUsuario, ApellidoMaternoUsuario,
                		 CorreoUsuario, PasswordUsuario, FechaCreacionUsuario, EstadoUsuario
                		));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaUsuarios;
    }

    
}
