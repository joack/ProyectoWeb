package DAO;

import modelo.Producto;
import conexion.Conexion;
import interfaces.IObligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElectrodomesticoDAO implements IObligacion<Producto>
{
    private static final String     SQL_INSERT      =   "INSERT INTO electrodomesticos(idCodigo, idArticulo, marca, modelo, nombre )" +
                                                        "VALUES (?, ?, ?, ?, ?)";

    private static final String     SQL_INSERT_DESC =   "INSERT INTO descripcionarticulos(idArticulo, stock, descripcion, imagen )" +
                                                        "VALUES (?, ?, ?, ? )";
    
    private static final String     SQL_DELETE      =   "DELETE FROM electrodomesticos    WHERE idCodigo   = ? ";
    
    private static final String     SQL_DELETE_DESC =   "DELETE FROM descripcionarticulos WHERE idArticulo = ?";
    
    private static final String     SQL_UPDATE      =   "UPDATE electrodomesticos, descripcionarticulos " +
                                                        "SET marca = ?, modelo = ?, nombre = ?, stock = ?, descripcion = ?, imagen = ? " +
                                                        "WHERE electrodomesticos.`idCodigo` = ? " + 
                                                        "AND descripcionarticulos.`idArticulo` = ?";
    
    private static final String     SQL_READ        =   "SELECT * FROM electrodomesticos " + 
                                                        "NATURAL JOIN descripcionarticulos " + 
                                                        "WHERE electrodomesticos.`idCodigo` = ? "+ 
                                                        "AND electrodomesticos.`idArticulo` = descripcionarticulos.`idArticulo`";
    
    private static final String     SQL_READALL     =   "SELECT electrodomesticos " +
                                                        "NATURAL JOIN descripcionarticulos"; 
                                                            
    private static final Conexion   CONEXION        =   Conexion.estado();
    
    
    @Override
    public boolean create(Producto clase) 
    {
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT); 
            
            
            pStatement.setInt   (1, clase.getIdCodigo()     );
            pStatement.setInt   (2, clase.getIdArticulo()   );
            pStatement.setString(3, clase.getMarca()        );
            pStatement.setString(4, clase.getModelo()       );
            pStatement.setString(5, clase.getNombre()       );
            
            if ( pStatement.executeUpdate() > 0 ) 
            {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_DESC);

                pStatement.setInt   (1, clase.getIdArticulo()   );
                pStatement.setInt   (2, clase.getStock()        );
                pStatement.setString(3, clase.getDescripcion()  );
                pStatement.setString(4, clase.getImagen()       );

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
    public boolean delete(Object key) 
    {
        PreparedStatement   pStatement;
        Producto producto    = read(key);
        
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
    public boolean update(Producto clase) 
    {
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE);
            
            pStatement.setString(1, clase.getMarca()        );
            pStatement.setString(2, clase.getModelo()       );
            pStatement.setString(3, clase.getNombre()       );
            pStatement.setInt   (4, clase.getStock()        );
            pStatement.setString(5, clase.getDescripcion()  );
            pStatement.setString(6, clase.getImagen()       );
            pStatement.setInt   (7, clase.getIdCodigo()     );
            pStatement.setInt   (8, clase.getIdArticulo()   ); 
            
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
    public Producto read(Object key) 
    {
        ResultSet rs;
        Producto producto = null;
        PreparedStatement pStatement;

        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ);
            
            pStatement.setInt( 1, Integer.parseInt(key.toString()) );
            rs = pStatement.executeQuery();

            while(rs.next()) 
            {
                producto = new Producto( rs.getInt(2),               /* idCodigo     */
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
    public ArrayList<Producto> readAll() 
    {
        ResultSet rs;
        ArrayList<Producto> electrodomesticos = new ArrayList();        
        PreparedStatement pStatement;
        
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READALL);
            rs = pStatement.executeQuery();
            
            while( rs.next())
            {
                electrodomesticos.add(new Producto(  rs.getInt(2),       /* idCodigo     */
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
}
