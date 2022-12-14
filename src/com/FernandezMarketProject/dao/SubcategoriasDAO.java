package com.FernandezMarketProject.dao;


import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FernandezMarketProject.models.Subcategorias_Model;
import com.FernandezMarketProject.utils.DbConnection;

public class SubcategoriasDAO {

	public static int insertUpdateDeleteSubcategoria(String pOpc, Subcategorias_Model subcategoria) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Subcategorias(?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setShort(2, subcategoria.getIdSubcategoria());            
            statement.setString(3, subcategoria.getTituloSubcategoria());   
            statement.setByte(4, subcategoria.getCategoriaPadre());
            statement.setBlob(5, subcategoria.getImagenSubcategoria());
            statement.setString(6, subcategoria.getNombreProducto());
            
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

    public static List<Subcategorias_Model> getSubcategorias(String pOpc, Subcategorias_Model subcategoria) throws Exception  {
        List<Subcategorias_Model> listaSubcategorias = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Subcategorias(?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setShort(2, subcategoria.getIdSubcategoria());            
            statement.setString(3, subcategoria.getTituloSubcategoria());   
            statement.setByte(4, subcategoria.getCategoriaPadre());
            statement.setBlob(5, subcategoria.getImagenSubcategoria());
            statement.setString(6, subcategoria.getNombreProducto());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	short IdSubcategoria = resultSet.getShort("IdSubcategoria");
                String TituloCategoria = resultSet.getString("TituloSubcategoria");
                byte CategoriaPadre = resultSet.getByte("CategoriaPadre");
                InputStream ImagenSubcategoria = resultSet.getBinaryStream("ImagenSubcategorias");
                
                short CantidadProductos = 0;
            	
                if (DbConnection.hasColumn(resultSet, "CantidadProductos"))
                	CantidadProductos = resultSet.getShort("CantidadProductos");
                
                listaSubcategorias.add(new Subcategorias_Model(IdSubcategoria, TituloCategoria, CategoriaPadre, ImagenSubcategoria, CantidadProductos)
                		);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaSubcategorias;
    }
	

}
