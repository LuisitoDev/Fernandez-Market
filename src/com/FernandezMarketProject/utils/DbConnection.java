/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FernandezMarketProject.utils;

import java.sql.*;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import javax.sql.DataSource; //TODO: CU�L ES MEJOR? EL DE JAVAX O EL DE TOMCAT

/**
 * Esta clase nos ayuda a crear la conexion a la base de datos
 *
 * @author magoc
 */
public class DbConnection {

    // Creamos el objeto conexion
    private static final BasicDataSource dataSource = new BasicDataSource();

    // Inicializamos la conexion
    static {
        // Tipo de Driver, este es el de mysql
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // La URL a la conexion, especificando que es de mysql
        // la ruta que es localhost puerto 3306
        // el nombre de la base de datos que es INSERTAR_NOMBRE
        // lo demas son parametros para que no tengan problemas con zonas horarias
        //TODO: CAMBIAR A 3305
        dataSource.setUrl("jdbc:mysql://localhost:3305/fernandez_market_db?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        // El nombre de usuario de su conexion
        dataSource.setUsername("admin");
        // La contrase�a del usuario de su conexion
        dataSource.setPassword("root");
        // dataSource.setMaxIdle(0);
        // dataSource.setMaxActive(100);
    }

    /**
     * *
     * Metodo para obtener la conexion
     *
     * @return Conexion a Base de datos
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Metodo para cerrar la conexion
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        dataSource.close();
    }
    
    
    
    public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        for (int x = 1; x <= columns; x++) {
            if (columnName.equals(rsmd.getColumnName(x))) {
                return true;
            }
        }
        return false;
    }
    
}
