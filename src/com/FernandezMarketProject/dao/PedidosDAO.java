/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.dao;

import com.FernandezMarketProject.models.Pedidos_Model;
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
public class PedidosDAO {

    /**
     * Inserta un usuario en la base de datos
     *
     * @param user
     * @return
     */
	
	public static int insertUpdateDeletePedidos(String pOpc, Pedidos_Model pedido) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Pedidos(?, ?, ?, ?, ?, ?, ?, ?, ?);");
           
            statement.setString(1, pOpc);
            
            statement.setLong(2, pedido.getIdPedido());
            
            if (pedido.getFechaCreacionPedido() != null) {
                java.util.Date utilDateFechaCrea = pedido.getFechaCreacionPedido();
        		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());
        		
                statement.setDate(3, fechaConvertidaFechaCrea);
                }
                else {
                	statement.setDate(3, null);
                }
           
            statement.setString(4, pedido.getDomicilioPedido());
            
            statement.setString(5, pedido.getTelefonoClientePedido());
            
            statement.setString(6, pedido.getBancoClientePedido());
            
            statement.setString(7, pedido.getNumCuentaClientePedido());
            
            statement.setBigDecimal(8, pedido.getPrecioTotalPedido());
            
            statement.setLong(9, pedido.getUsuarioPedido());
            
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

    public static List<Pedidos_Model> getPedidos(String pOpc, Pedidos_Model pedido) throws Exception  {
        List<Pedidos_Model> listaPedido = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Pedidos(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);
            
            statement.setLong(2, pedido.getIdPedido());
            
            if (pedido.getFechaCreacionPedido() != null) {
                java.util.Date utilDateFechaCrea = pedido.getFechaCreacionPedido();
        		java.sql.Date fechaConvertidaFechaCrea = new java.sql.Date(utilDateFechaCrea.getTime());
        		
                statement.setDate(3, fechaConvertidaFechaCrea);
                }
                else {
                	statement.setDate(3, null);
                }
           
            statement.setString(4, pedido.getDomicilioPedido());
            
            statement.setString(5, pedido.getTelefonoClientePedido());
            
            statement.setString(6, pedido.getBancoClientePedido());
            
            statement.setString(7, pedido.getNumCuentaClientePedido());
            
            statement.setBigDecimal(8, pedido.getPrecioTotalPedido());
            
            statement.setLong(9, pedido.getUsuarioPedido());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	long IdPedido = resultSet.getLong("IdPedido");
            	Date FechaCreacionPedido = resultSet.getDate("FechaCreacionPedido");
            	String DomicilioPedido = resultSet.getString("DomicilioPedido");
            	String TelefonoClientePedido = resultSet.getString("TelefonoClientePedido");
            	String BancoClientePedido = resultSet.getString("BancoClientePedido");
            	String NumCuentaClientePedido = resultSet.getString("NumCuentaClientePedido");
            	
            	BigDecimal PrecioTotalPedido = resultSet.getBigDecimal("PrecioTotalPedido");
            	long UsuarioPedido = resultSet.getInt("UsuarioPedido");
            	
            	
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
                
                
            	listaPedido.add(new Pedidos_Model(
                		IdPedido, FechaCreacionPedido, DomicilioPedido, TelefonoClientePedido, BancoClientePedido, 
                		NumCuentaClientePedido, PrecioTotalPedido, UsuarioPedido
                		));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaPedido;
    }

    
}
