/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import SuperClases.Articulo;
import SuperClases.Usuario;
import conexion.Conexion;
import interfaces.IArticulo;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IDescripcionArticulo;
import modelo.Electrodomestico;
import modelo.UsuarioAdmin;
import modelo.UsuarioComun;

/**
 *
 * @author Joack
 */
public class ServiceDAO implements IObligacionAdmin<Usuario>, IObligacionProducManager<IArticulo>
{
    private static final String     SQL_INSERT_USER   = "INSERT INTO usuarios(email, user, password, rol) VALUES(?, ?, ?, ?)";
    private static final String     SQL_DELETE_USER   = "DELETE FROM usuarios WHERE email = ?";
    private static final String     SQL_UPDATE_USER   = "UPDATE usuarios SET password = ? WHERE email = ?";
    private static final String     SQL_READ_USER     = "SELECT * FROM usuarios WHERE email = ?";
    private static final String     SQL_READALL_USERS = "SELECT * FROM usuarios"; 

    private static final String     SQL_INSERT      =   "INSERT INTO electrodomesticos(idCodigo, idArticulo, marca, modelo, nombre )" +
                                                        "VALUES (?, ?, ?, ?, ?)";

    private static final String     SQL_INSERT_DESC =   "INSERT INTO descripcionarticulos(idArticulo, stock, descripcion, imagen, precio )" +
                                                        "VALUES (?, ?, ?, ?, ?)";
    
    private static final String     SQL_DELETE      =   "DELETE FROM electrodomesticos    WHERE idCodigo   = ? ";
    
    private static final String     SQL_DELETE_DESC =   "DELETE FROM descripcionarticulos WHERE idArticulo = ?";
    
    private static final String     SQL_UPDATE      =   "UPDATE electrodomesticos, descripcionarticulos " +
                                                        "SET marca = ?, modelo = ?, nombre = ?, stock = ?, descripcion = ?, imagen = ? , precio = ?" +
                                                        "WHERE electrodomesticos.`idCodigo` = ? " + 
                                                        "AND descripcionarticulos.`idArticulo` = ?";
    
    private static final String     SQL_READ        =   "SELECT * FROM electrodomesticos " + 
                                                        "NATURAL JOIN descripcionarticulos " + 
                                                        "WHERE electrodomesticos.`idCodigo` = ? "+ 
                                                        "AND electrodomesticos.`idArticulo` = descripcionarticulos.`idArticulo`";
    
    private static final String     SQL_READALL     =   "SELECT * FROM electrodomesticos\n" +
                                                        "NATURAL JOIN descripcionarticulos\n" +
                                                        "WHERE electrodomesticos.`idArticulo` = descripcionarticulos.`idArticulo`";
                                                        
    
    private static final Conexion   CONEXION        =   Conexion.estado(); 
    
 
// <editor-fold defaultstate="collapsed" desc="Administracion de usuarios."> 
    
    @Override
    public boolean createUser(Usuario clase) 
    {
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_USER);
            
            pStatement.setString(1, clase.getEmail()        );
            pStatement.setString(2, clase.getNickName()     );
            pStatement.setString(3, clase.getPassword()     );
            pStatement.setString(4, clase.getRol()          );
            
            if(pStatement.executeUpdate() > 0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            CONEXION.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public boolean deleteUser(Object key) 
    {
        PreparedStatement pStatemen;
        try {
            pStatemen = CONEXION.getConnection().prepareStatement(SQL_DELETE_USER);
            pStatemen.setString(1, key.toString());
            
            if( pStatemen.executeUpdate() > 0 )
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        } 
        
        return false;        
    }   
    
    @Override
    public boolean updateUser(Usuario clase) 
    {
        PreparedStatement pStatement;
        
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE_USER);
            
            pStatement.setString(1, clase.getPassword());
            pStatement.setString(2, clase.getEmail());
            
            if (pStatement.executeUpdate() > 0 )
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return false;
    } 
    
    @Override
    public Usuario readAUser(Object key) 
    {
        PreparedStatement   pStatement;
        ResultSet           resultSet;
        Usuario             usuario     = null;
        
        try { 
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ_USER);
            
            pStatement.setString(1, key.toString());
            
            resultSet = pStatement.executeQuery();
            
            while(resultSet.next())
            {
                if (resultSet.getString("rol").equals("admin")) 
                {
                    usuario = new UsuarioAdmin( resultSet.getString(1),
                                                resultSet.getString(3),
                                                resultSet.getString(4) );    
                }else{
                    usuario = new UsuarioComun( resultSet.getString(1),
                                                resultSet.getString(2),
                                                resultSet.getString(3),
                                                resultSet.getString(4) );
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }

        return usuario;
    }

    @Override
    public ArrayList<Usuario> readAllUsers() 
    {
        PreparedStatement       pStatement;
        ResultSet               resultSet;
        ArrayList<Usuario>      usuariosList    = new ArrayList();
        Usuario                 usuario;
        
        try {    
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READALL_USERS);
            
            resultSet = pStatement.executeQuery();
            
            while( resultSet.next() )
            {
                if (resultSet.getString("rol").equals("admin")) 
                {
                    usuario = new UsuarioAdmin( resultSet.getString(1),
                                                resultSet.getString(3),
                                                resultSet.getString(4) );    
                }else{
                    usuario = new UsuarioComun( resultSet.getString(1),
                                                resultSet.getString(2),
                                                resultSet.getString(3),
                                                resultSet.getString(4) );
                }
                usuariosList.add( usuario );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuariosList;
    } 


//</editor-fold>    
    
// <editor-fold defaultstate="collapsed" desc="Administracion de productos.">     
    
    @Override
    public boolean createArticulo( IArticulo articulo) 
    {
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT); 
            
            
            pStatement.setInt   (1, articulo.getIdCodigo()     );
            pStatement.setInt   (2, articulo.getIdArticulo()   );
            pStatement.setString(3, articulo.getMarca()        );
            pStatement.setString(4, articulo.getModelo()       );
            pStatement.setString(5, articulo.getNombre()       );
            
            if ( pStatement.executeUpdate() > 0 ) 
            {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_DESC);

                pStatement.setInt   (1, articulo.getIdArticulo()   );
                pStatement.setInt   (2, articulo.getStock()        );
                pStatement.setString(3, articulo.getDescripcion()  );
                pStatement.setString(4, articulo.getImagen()       );
                pStatement.setFloat (5, articulo.getPrecio()       );

                if( pStatement.executeUpdate() > 0 )
                {
                        return true;
                }
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public boolean deleteArticulo(Object primaryKey) 
    {
        PreparedStatement   pStatement;
        IArticulo           producto    = readAnArticulo(primaryKey);
        
        try {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_DELETE);
                
                pStatement.setInt(1, producto.getIdCodigo());
                
                
                if ( pStatement.executeUpdate() > 0 )
                {
                    pStatement = CONEXION.getConnection().prepareStatement(SQL_DELETE_DESC);
                    pStatement.setInt(1, producto.getIdArticulo());
                    
                    if ( pStatement.executeUpdate() > 0 ) 
                    {
                        return true;
                    }
                }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public boolean updateArticulo(IArticulo articulo) 
    {
            PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE);
            
            pStatement.setString(1, articulo.getMarca()        );
            pStatement.setString(2, articulo.getModelo()       );
            pStatement.setString(3, articulo.getNombre()       );
            pStatement.setInt   (4, articulo.getStock()        );
            pStatement.setString(5, articulo.getDescripcion()  );
            pStatement.setString(6, articulo.getImagen()       );
            pStatement.setFloat (7, articulo.getPrecio()       );
            pStatement.setInt   (8, articulo.getIdCodigo()     );
            pStatement.setInt   (9, articulo.getIdArticulo()   ); 
            
            if ( pStatement.executeUpdate() > 0) 
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public IArticulo readAnArticulo(Object primaryKey) 
    {
        ResultSet rs;
        Electrodomestico producto = null;
        PreparedStatement pStatement;

        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ);
            
            pStatement.setInt( 1, Integer.parseInt(primaryKey.toString()) );
            rs = pStatement.executeQuery();

            while(rs.next())
            {
                producto = new Electrodomestico(    rs.getInt(2),               /* idCodigo     */
                                                    rs.getInt(1),               /* idArticulo   */
                                                    rs.getString(3),            /* marca        */
                                                    rs.getString(4),            /* modelo       */
                                                    rs.getString(5),            /* nombre       */
                                                    rs.getString(7),            /* descipcion   */
                                                    rs.getString(8),            /* imagen       */
                                                    rs.getInt(6),               /* stock        */
                                                    rs.getFloat(9));            /* precio       */
            }
        } catch (SQLException | NullPointerException ex) {        
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return producto;
    }

    @Override
    public ArrayList<IArticulo> readAllArticulos() 
    {
        ResultSet rs;
        ArrayList<IArticulo> electrodomesticos = new ArrayList();        
        PreparedStatement pStatement;
        
        try {
            pStatement =  CONEXION.getConnection().prepareStatement(SQL_READALL);
            rs = pStatement.executeQuery();
            
            while( rs.next())
            {
                electrodomesticos.add(new Electrodomestico(     rs.getInt(2),       /* idCodigo     */
                                                                rs.getInt(1),       /* idArticulo   */
                                                                rs.getString(3),    /* marca        */
                                                                rs.getString(4),    /* modelo       */
                                                                rs.getString(5),    /* nombre       */
                                                                rs.getString(7),    /* descipcion   */
                                                                rs.getString(8),    /* imagen       */
                                                                rs.getInt(6),       /* stock        */
                                                                rs.getFloat(9)));   /* precio       */ 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return electrodomesticos;
    }
    
    @Override
    public boolean createDescrip() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDescrip() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDescrip() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDescripcionArticulo readDescrip() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IDescripcionArticulo> readAllDescrip() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    
// </editor-fold>   
    
}
