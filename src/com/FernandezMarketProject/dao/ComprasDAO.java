/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.dao;

import com.FernandezMarketProject.models.Compras_Model;
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
public class ComprasDAO {

    /**
     * Inserta un usuario en la base de datos
     *
     * @param user
     * @return
     */
	
	public static int insertUpdateDeleteCompras(String pOpc, Compras_Model compra) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Compras(?, ?, ?, ?, ?, ?);");
           
            statement.setString(1, pOpc);
            
            statement.setLong(2, compra.getIdCompra());
            
            statement.setLong(3, compra.getPedidoCompra());
            
            statement.setLong(4, compra.getProductoCompra());
            
            statement.setShort(5, compra.getCantidadPiezasCompra());
            
            statement.setBigDecimal(6, compra.getPrecioProductoCompra());
            
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

    public static List<Compras_Model> getCompras(String pOpc, Compras_Model compra) throws Exception  {
        List<Compras_Model> listaCompras = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Compras(?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);
            
            statement.setLong(2, compra.getIdCompra());
            
            statement.setLong(3, compra.getPedidoCompra());
            
            statement.setLong(4, compra.getProductoCompra());
            
            statement.setShort(5, compra.getCantidadPiezasCompra());
            
            statement.setBigDecimal(6, compra.getPrecioProductoCompra());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	long IdCompra = resultSet.getLong("IdCompra");
            	long PedidoCompra = resultSet.getLong("PedidoCompra");
            	long ProductoCompra = resultSet.getLong("ProductoCompra");
            	short CantidadPiezasCompra = resultSet.getShort("CantidadPiezasCompra");
            	BigDecimal PrecioProductoCompra = resultSet.getBigDecimal("PrecioProductoCompra");
            	
            	
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
                
                
            	listaCompras.add(new Compras_Model(
            			IdCompra, PedidoCompra, ProductoCompra, CantidadPiezasCompra, PrecioProductoCompra
                		));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaCompras;
    }

    
}
