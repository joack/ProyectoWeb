/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joack
 */
public class Conexion 
{
    public  static  Conexion    instance;
    private         Connection  connection;     //conexion a la base de datos

    
    private Conexion()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // nombre Controlador
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo?zeroDateTimeBehavior=convertToNull", "root","" ); // getConnection(url, user, password)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static Conexion estado()
    {
        if( instance == null )
        {
            instance = new Conexion();
        }
        
        return instance;
    }

    public Connection getConnection() 
    {
        return connection;
    }
    
    public void cerrarConexion()
    {
        instance = null;
    }
    
}
