/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.dao;

import com.FernandezMarketProject.models.Productos_Model;
import com.FernandezMarketProject.utils.DbConnection;

import java.io.InputStream;
import java.math.BigDecimal;
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
public class ProductoDAO {

    /**
     * Inserta un usuario en la base de datos
     *
     * @param user
     * @return
     */
	
	public static int insertUpdateDeleteProductos(String pOpc, Productos_Model producto) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Productos(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
           
            statement.setString(1, pOpc);
            
            statement.setLong(2, producto.getIdProducto());
            
            statement.setString(3, producto.getNombreProducto());
           
            statement.setString(4, producto.getDescripcionProducto());
            
            statement.setBlob(5, producto.getImagenProducto());
            
            statement.setBigDecimal(6, producto.getPrecioProducto());
            
            statement.setBigDecimal(7, producto.getDescuentoProducto());
            
            if (producto.getFechaCreacionProducto() != null) {
            java.util.Date utilDateFechaCrea = producto.getFechaCreacionProducto();
    		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());
    		
            statement.setDate(8, fechaConvertidaFechaCrea);
            }
            else {
            	statement.setDate(8, null);
            }
            
            statement.setInt(9, producto.getCantidadStockProducto());
            statement.setInt(10, producto.getMarcaProducto());
            
            statement.setShort(11, producto.getSubcategoriaProducto());
            
            statement.setString(12, producto.getMarcaProductoTexto());
            
            statement.setLong(13, producto.getIdUsuario());
            
            statement.setInt(14, producto.getNumeroProductoPagina());
            
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

    public static List<Productos_Model> getProductos(String pOpc, Productos_Model producto) throws Exception  {
        List<Productos_Model> listaProductos = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Productos(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);
            
            statement.setLong(2, producto.getIdProducto());
            
            statement.setString(3, producto.getNombreProducto());
           
            statement.setString(4, producto.getDescripcionProducto());
            
            statement.setBlob(5, producto.getImagenProducto());
            
            statement.setBigDecimal(6, producto.getPrecioProducto());
            
            statement.setBigDecimal(7, producto.getDescuentoProducto());
            
            if (producto.getFechaCreacionProducto() != null) {
            java.util.Date utilDateFechaCrea = producto.getFechaCreacionProducto();
    		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());
    		
            statement.setDate(8, fechaConvertidaFechaCrea);
            }
            else {
            	statement.setDate(8, null);
            }
            
            statement.setInt(9, producto.getCantidadStockProducto());
            statement.setInt(10, producto.getMarcaProducto());
            
            statement.setShort(11, producto.getSubcategoriaProducto());
            
            statement.setString(12, producto.getMarcaProductoTexto());
            
            statement.setLong(13, producto.getIdUsuario());
            
            statement.setInt(14, producto.getNumeroProductoPagina());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	long IdProducto = resultSet.getLong("IdProducto");
            	String NombreProducto = resultSet.getString("NombreProducto");
            	String DescripcionProducto = resultSet.getString("DescripcionProducto");
            	InputStream ImagenProducto = resultSet.getBinaryStream("ImagenProducto");
            	BigDecimal PrecioProducto = resultSet.getBigDecimal("PrecioProducto");
            	BigDecimal DescuentoProducto = resultSet.getBigDecimal("DescuentoProducto");;
            	 
            	Date FechaCreacionProducto = resultSet.getDate("FechaCreacionProducto");
            	int CantidadStockProducto = resultSet.getInt("CantidadStockProducto");
            	 
            	int MarcaProducto = resultSet.getInt("MarcaProducto");
            	 
            	short SubcategoriaProducto = resultSet.getShort("SubcategoriaProducto");
            	
            	
            	String MarcaProductoTexto = resultSet.getString("MarcaProductoTexto");
            	
            	String TituloSubcategoria = "";
            	
                if (DbConnection.hasColumn(resultSet, "TituloSubcategoria"))
                	TituloSubcategoria = resultSet.getString("TituloSubcategoria");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasFavoritasUsuario"))
//                	cantPreguntasFavoritasUsuario = resultSet.getLong("CantPreguntasFavoritasUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasUtilesUsuario"))
//                	cantPreguntasUtilesUsuario = resultSet.getLong("CantPreguntasUtilesUsuario");
//                
//                if (DbConnection.hasColumn(resultSet, "CantPreguntasNoUtilesUsuario"))
//                	cantPreguntasNoUtilesUsuario = resultSet.getLong("CantPreguntasNoUtilesUsuario");
                
                
            	listaProductos.add(new Productos_Model(
                		IdProducto, NombreProducto, DescripcionProducto, ImagenProducto, PrecioProducto, DescuentoProducto, 
                		FechaCreacionProducto, CantidadStockProducto, MarcaProducto, SubcategoriaProducto, MarcaProductoTexto, TituloSubcategoria
                		));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaProductos;
    }

    
}
