/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
import interfaces.IObligacionArticuloDescrip;
import interfaces.IObligacionDescriptionManager;
import interfaces.IUser;
import modelo.ProdArticulo;
import modelo.ProdDescripcion;
import modelo.Tupla;
import modelo.UsuarioAdmin;
import modelo.UsuarioComun;

/**
 *
 * @author Joack
 */
public class ServiceDAO implements IObligacionAdmin<IUser>, IObligacionProducManager<IArticulo>, IObligacionDescriptionManager<IDescripcionArticulo>, IObligacionArticuloDescrip<Tupla>
{
    // <editor-fold defaultstate="collapsed" desc="String Query tabla de usuarios."> 
    
    private static final String     SQL_INSERT_USER   = "INSERT INTO usuarios(email, user, password, rol) VALUES(?, ?, ?, ?)";
    private static final String     SQL_DELETE_USER   = "DELETE FROM usuarios WHERE email = ?";
    
    private static final String     SQL_UPDATE_USER   = "UPDATE usuarios " +
                                                        "SET    password = ?, rol = ?, `user` = ? " +
                                                        "WHERE  email = ? ";
    
    private static final String     SQL_READ_USER     = "SELECT * FROM usuarios WHERE email = ?";
    private static final String     SQL_READALL_USERS = "SELECT * FROM usuarios"; 

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="String Query tabla articulo-descrip.">
    
    private static final String     SQL_INSERT_PROD_DESC    =   "INSERT INTO articulodescrip( idCodigo, idArticulo ) " +
                                                                "VALUES (?, ?)";
    
    private static final String     SQL_DELETE_PROD_DESC    =   "DELETE FROM articulodescrip " +
                                                                "WHERE idCodigo = ?";
    
    private static final String     SQL_UPDATE_PROD_DESC    =   "UPDATE articulodescrip " +
                                                                "SET idArticulo = ? " +
                                                                "WHERE idCodigo = ?";

    private static final String     SQL_READ_PROD_DESC      =   "SELECT * FROM articulodescrip " +
                                                                "WHERE idCodigo = ?";
    
    private static final String     SQL_READALL_PROD_DESC   =   "SELECT * FROM articulodescrip";
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="String Query tabla articulos.">
    
    private static final String     SQL_INSERT_PROD     =   "INSERT INTO articulos(idCodigo, marca, modelo, nombre )" +
                                                            "VALUES (?, ?, ?, ?)";
    
    private static final String     SQL_DELETE_PROD     =   "DELETE FROM articulos " +
                                                            "WHERE  idCodigo = ? ";
    
    private static final String     SQL_UPDATE_PROD     =   "UPDATE articulos " +
                                                            "SET    marca = ?, modelo = ?, nombre = ? " +
                                                            "WHERE  idCodigo = ? "; 

    private static final String     SQL_READ_PROD       =   "SELECT * FROM articulos " +                                                          
                                                            "WHERE  idCodigo = ? "; 

    private static final String     SQL_READALL_PROD    =   "SELECT * FROM articulos";
        
    //</editor-fold>    
    
    // <editor-fold defaultstate="collapsed" desc="String Query tabla descripcion.">
    
    private static final String     SQL_INSERT_DESC     =   "INSERT INTO descripcion(idArticulo, stock, descripcion, imagen, precio )" +
                                                            "VALUES (?, ?, ?, ?, ?)";
    
    private static final String     SQL_DELETE_DESC     =   "DELETE FROM descripcion " +
                                                            "WHERE  idArticulo = ?";
    
    private static final String     SQL_UPDATE_DESC     =   "UPDATE descripcion " +
                                                            "SET stock = ?, descripcion = ?, imagen = ?, precio = ?" +
                                                            "WHERE idArticulo = ?";
    
    private static final String     SQL_READ_DESC       =   "SELECT * FROM descripcion " +
                                                            "WHERE idArticulo = ?";
    
    private static final String     SQL_READALL_DESC    =   "SELECT * FROM descripcion";
                                                            
    //</editor-fold>
    
    private static final Conexion   CONEXION        =   Conexion.estado(); 
    
 
// <editor-fold defaultstate="collapsed" desc="Administracion de usuarios."> 
    
    @Override
    public boolean createUser(IUser clase) 
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
    public boolean updateUser(IUser clase) 
    {
        PreparedStatement pStatement;
        
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE_USER);
            
            //UPDATE usuarios SET password = ? , rol = ? , user = ? WHERE email = ?"
            pStatement.setString(1, clase.getPassword());
            pStatement.setString(2, clase.getRol());
            pStatement.setString(3, clase.getNickName());
            pStatement.setString(4, clase.getEmail());
            
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
    public IUser readAUser(Object key) 
    {
        PreparedStatement   pStatement;
        ResultSet           resultSet;
        IUser               usuario = null;
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
    public ArrayList<IUser> readAllUsers() 
    {
        PreparedStatement       pStatement;
        ResultSet               resultSet;
        ArrayList<IUser>        usuariosList    = new ArrayList();
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
                usuariosList.add((IUser) usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuariosList;
    } 


//</editor-fold>    
    
// <editor-fold defaultstate="collapsed" desc="Administracion de productos.">     

    // <editor-fold defaultstate="collapsed" desc="Metodos Query para articulos.">    
    @Override
    public boolean createArticulo( IArticulo articulo) 
    {
        // "INSERT INTO articulos(idCodigo,  marca, modelo, nombre )"
        // "VALUES (?, ?, ?, ?)";
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_PROD); 
            
            
            pStatement.setInt   (1, articulo.getIdCodigo()     );
            pStatement.setString(2, articulo.getMarca()        );
            pStatement.setString(3, articulo.getModelo()       );
            pStatement.setString(4, articulo.getNombre()       );
            
            if ( pStatement.executeUpdate() > 0 ) 
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
    public boolean deleteArticulo(Object primaryKey) 
    {
        //"DELETE FROM articulos " +
        //"WHERE  idCodigo = ? ";
        PreparedStatement   pStatement;
        
        try {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_DELETE_PROD);               
                pStatement.setInt(1, (int)primaryKey );
                               
                if ( pStatement.executeUpdate() > 0 )
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
    public boolean updateArticulo(IArticulo articulo) 
    {
        //"UPDATE articulos " +
        //"SET    marca = ?, modelo = ?, nombre = ? " +
        //"WHERE  idCodigo = ? ";
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE_PROD);
            
            pStatement.setString(1, articulo.getMarca()        );
            pStatement.setString(2, articulo.getModelo()       );
            pStatement.setString(3, articulo.getNombre()       );          
            pStatement.setInt   (4, articulo.getIdCodigo()     );
            
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
        //"SELECT * FROM articulos "                                                           
        //"WHERE  idCodigo = ? ";
        
        ResultSet rs;
        IArticulo producto = null;
        PreparedStatement pStatement;

        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ_PROD);
            
            pStatement.setInt( 1, (int)primaryKey );
            rs = pStatement.executeQuery();

            while(rs.next())
            {
                producto = new ProdArticulo(rs.getInt(1)   ,                    /* idCodigo     */                                               
                                            rs.getString(4),                    /* nombre       */
                                            rs.getString(2),                    /* marca        */
                                            rs.getString(3));                   /* modelo       */
                                                                                                
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
        // "SELECT * FROM articulos"

        ResultSet rs;
        ArrayList<IArticulo> articulos = new ArrayList();        
        PreparedStatement pStatement;
        
        try {
            pStatement =  CONEXION.getConnection().prepareStatement(SQL_READALL_PROD);
            rs = pStatement.executeQuery();
            
            while( rs.next())
            {
                articulos.add(new ProdArticulo( rs.getInt(1)   ,                /* idCodigo     */                                                               
                                                rs.getString(4),                /* nombre       */
                                                rs.getString(2),                /* marca        */
                                                rs.getString(3)));              /* modelo       */                                                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return articulos;
    }
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos Query para descripciones."> 
    
    @Override
    public boolean createDescrip(IDescripcionArticulo descrip) 
    {
        //"INSERT INTO descripcion(idArticulo, stock, descripcion, imagen, precio )" +
        //"VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_DESC); 
            
            
            pStatement.setInt   (1, descrip.getIdArticulo() );
            pStatement.setInt   (2, descrip.getStock()      );
            pStatement.setString(3, descrip.getDescripcion());
            pStatement.setString(4, descrip.getImagen()     );
            pStatement.setFloat (5, descrip.getPrecio()     );
            
            if ( pStatement.executeUpdate() > 0 ) 
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
    public boolean deleteDescrip( Object primaryKey) 
    {
        //"DELETE FROM descripcion " +
        //"WHERE  idArticulo = ?"
        PreparedStatement   pStatement;
        
        try {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_DELETE_DESC);               
                pStatement.setInt(1, (int)primaryKey );
                               
                if ( pStatement.executeUpdate() > 0 )
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
    public boolean updateDescrip(IDescripcionArticulo descrip) 
    {
        //"UPDATE descripcion " +
        //"SET stock = ?, descripcion = ?, imagen = ?, precio = ?" +
        //"WHERE idArticulo = ?"
        
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE_DESC);
            
            pStatement.setInt   (1, descrip.getStock()        );
            pStatement.setString(2, descrip.getDescripcion()  );
            pStatement.setString(3, descrip.getImagen()       );          
            pStatement.setFloat (4, descrip.getPrecio()       );
            pStatement.setFloat (5, descrip.getIdArticulo()   );
            
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
    public IDescripcionArticulo readDescrip(Object primaryKey) 
    {
        //"SELECT * FROM descripcion " +
        //"WHERE idArticulo = ?";
        
        ResultSet rs;
        IDescripcionArticulo producto = null;
        PreparedStatement pStatement;

        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ_DESC);
            
            pStatement.setInt( 1, (int)primaryKey );
            rs = pStatement.executeQuery();

            while(rs.next())
            {
                producto = new ProdDescripcion(rs.getInt(1)   ,                 /* idArticulo   */                                               
                                               rs.getInt(2)   ,                 /* stock        */
                                               rs.getString(3),                 /* descripcion  */
                                               rs.getString(4),                 /* imagen       */
                                               rs.getFloat (5) );               /* precio       */                                                    
            }
        } catch (SQLException | NullPointerException ex) {        
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return producto;        
    }

    @Override
    public ArrayList<IDescripcionArticulo> readAllDescrip() 
    {
        //"SELECT * FROM descripcion" 
        
        ResultSet rs;
        ArrayList<IDescripcionArticulo> descripciones = new ArrayList();        
        PreparedStatement pStatement;
        
        try {
            pStatement =  CONEXION.getConnection().prepareStatement(SQL_READALL_DESC);
            rs = pStatement.executeQuery();
            
            while( rs.next())
            {
                descripciones.add(new ProdDescripcion(  rs.getInt(1)   ,                 /* idArticulo   */                                               
                                                        rs.getInt(2)   ,                 /* stock        */
                                                        rs.getString(3),                 /* descripcion  */
                                                        rs.getString(4),                 /* imagen       */
                                                        rs.getFloat (5)));               /* precio       */
                                                                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return descripciones;        
    } 
 
    //</editor-fold> 
 
    // <editor-fold defaultstate="collapsed" desc="Metodos Query para articulo-descripcion.">
    
    @Override
    public boolean createTupla( Tupla tupla ) 
    {
        //"INSERT INTO articulo-descrip( idCodigo, idArticulo )" +
        //"VALUES (?, ?)";
        
        boolean isValidArticulo = readAnArticulo( tupla.getPrimaryKey() ) != null;
        boolean isValidDescrip  = readDescrip   ( tupla.getForeignKey() ) != null;
        
        if( isValidArticulo && isValidDescrip )       
        {
            PreparedStatement pStatement;
            try {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_INSERT_PROD_DESC); 

                pStatement.setInt   (1, tupla.getPrimaryKey() );
                pStatement.setInt   (2, tupla.getForeignKey() );


                if ( pStatement.executeUpdate() > 0 ) 
                {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                CONEXION.cerrarConexion();
            }               
        }
   
        return false;        
    }

    @Override
    public boolean deleteTupla(Object primaryKey) 
    {
        //"DELETE FROM articulo-descrip" +
        //"WHERE idCodigo = ?"
        PreparedStatement   pStatement;
        
        try {
                pStatement = CONEXION.getConnection().prepareStatement(SQL_DELETE_PROD_DESC);               
                pStatement.setInt(1, (int)primaryKey );
                               
                if ( pStatement.executeUpdate() > 0 )
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
    public boolean updateTupla(Tupla tupla) 
    {
        //"UPDATE articulo-descrip" +
        //"SET idArticulo = ?" +
        //"WHERE idCodigo = ?"
        
        PreparedStatement pStatement;
        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_UPDATE_PROD_DESC);
            
            pStatement.setInt(1, tupla.getForeignKey() );
            pStatement.setInt(2, tupla.getPrimaryKey() );
            
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
    public Tupla readTupla(Object primaryKey) 
    {
        //"SELECT * FROM articulo-descrip" +
        //"WHERE idCodigo = ?"
        ResultSet rs;
        Tupla tupla = null;
        PreparedStatement pStatement;

        try {
            pStatement = CONEXION.getConnection().prepareStatement(SQL_READ_PROD_DESC);
            
            pStatement.setInt( 1, (int)primaryKey );
            rs = pStatement.executeQuery();

            while(rs.next())
            {
                tupla = new Tupla(  rs.getInt(1),                    /* idCodigo   */                                               
                                    rs.getInt(2));                   /* idArticulo */                                                                                                  
            }
        } catch (SQLException | NullPointerException ex) {        
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return tupla;        
    }

    @Override
    public ArrayList<Tupla> readAllTupla() 
    {
        //"SELECT * FROM articulo-descrip"
        
        ResultSet rs;
        ArrayList<Tupla> tuplasProducto = new ArrayList();        
        PreparedStatement pStatement;
        
        try {
            pStatement =  CONEXION.getConnection().prepareStatement(SQL_READALL_PROD_DESC);
            rs = pStatement.executeQuery();
            
            while( rs.next())
            {
                tuplasProducto.add( new Tupla(  rs.getInt(1) ,                  /* idCodigo   */                                               
                                                rs.getInt(2)));                 /* idArticulo */                                                      
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectrodomesticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        
        return tuplasProducto;        
    }
 
    // </editor-fold>
    
    
 // </editor-fold>       
}