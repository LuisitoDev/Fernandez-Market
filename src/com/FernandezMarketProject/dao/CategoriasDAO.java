package com.FernandezMarketProject.dao;


import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FernandezMarketProject.models.Categorias_Model;
import com.FernandezMarketProject.utils.DbConnection;

public class CategoriasDAO {

	public static int insertUpdateDeleteCategoria(String pOpc, Categorias_Model categoria) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Categorias(?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setByte(2, categoria.getIdCategoria());            
            statement.setString(3, categoria.getTituloCategoria());  
            statement.setBlob(4, categoria.getImagenCategoria());
            
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

    public static List<Categorias_Model> getCategorias(String pOpc, Categorias_Model categoria) throws Exception  {
        List<Categorias_Model> listaCategorias = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Categorias(?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setByte(2, categoria.getIdCategoria());            
            statement.setString(3, categoria.getTituloCategoria());
            statement.setBlob(4, categoria.getImagenCategoria());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	byte IdCategoria = resultSet.getByte("IdCategoria");
                String TituloCategoria = resultSet.getString("TituloCategoria");
                InputStream ImagenCategoria = resultSet.getBinaryStream("ImagenCategoria");
                
                listaCategorias.add(new Categorias_Model(IdCategoria, TituloCategoria, ImagenCategoria)
                		);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaCategorias;
    }
	

}
