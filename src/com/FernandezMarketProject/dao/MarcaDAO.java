package com.FernandezMarketProject.dao;


import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FernandezMarketProject.models.Marcas_Model;
import com.FernandezMarketProject.utils.DbConnection;

public class MarcaDAO {

	public static int insertUpdateDeleteMarcas(String pOpc, Marcas_Model marca) throws Exception {
    	Connection con = null;
    	CallableStatement statement = null;

        int rowsAffectted = 0;
        try {
            con = DbConnection.getConnection();
            
            statement = con.prepareCall("CALL sp_Marcas(?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setInt(2, marca.getIdMarca());            
            statement.setString(3, marca.getNombreCategoria());   
            statement.setBlob(4, marca.getImagenMarca());
            statement.setString(5, marca.getPaginaMarca());
            
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

    public static List<Marcas_Model> getMarcas(String pOpc, Marcas_Model marca) throws Exception  {
        List<Marcas_Model> listaMarca = new ArrayList<>();
        Connection con = null;
        CallableStatement statement = null;

        try {
            con = DbConnection.getConnection();
            statement = con.prepareCall("CALL sp_Marcas(?, ?, ?, ?, ?);");
            
            statement.setString(1, pOpc);            
            statement.setInt(2, marca.getIdMarca());            
            statement.setString(3, marca.getNombreCategoria());   
            statement.setBlob(4, marca.getImagenMarca());
            statement.setString(5, marca.getPaginaMarca());
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
            	short IdMarca = resultSet.getShort("IdMarca");
                String NombreMarca = resultSet.getString("NombreMarca");
                InputStream ImagenMarca = resultSet.getBinaryStream("ImagenMarca");
                String PaginaMarca = resultSet.getString("PaginaMarca");
                
                listaMarca.add(new Marcas_Model(IdMarca, NombreMarca, ImagenMarca, PaginaMarca)
                		);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            statement.close();
            con.close();
        }

        return listaMarca;
    }
	
    
    
    

}
