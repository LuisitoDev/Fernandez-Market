package com.FernandezMarketProject.dao;


import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FernandezMarketProject.models.Promociones_Model;
import com.FernandezMarketProject.utils.DbConnection;

public class PromocionDAO {

	public static int insertUpdateDeletePromociones(String pOpc, Promociones_Model promocion) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Promociones(?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setInt(2, promocion.getIdPromocion());         
            statement.setBlob(3, promocion.getImagenPromocion());
            statement.setShort(4, promocion.getSubcategoria());
            
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

    public static List<Promociones_Model> getPromociones(String pOpc, Promociones_Model promocion) throws Exception  {
        List<Promociones_Model> listaPromociones = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Promociones(?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setInt(2, promocion.getIdPromocion());         
            statement.setBlob(3, promocion.getImagenPromocion());
            statement.setShort(4, promocion.getSubcategoria());
            
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	int IdPromocion  = resultSet.getInt("IdPromociones");
            	InputStream ImagenPromocion = resultSet.getBinaryStream("ImagenPromocion");
            	short Subcategoria = resultSet.getShort("Subcategoria");
            	
                listaPromociones.add(new Promociones_Model(IdPromocion, ImagenPromocion, Subcategoria)
                		);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaPromociones;
    }
	
    
    
    

}
