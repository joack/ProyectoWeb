/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceManager;

import DAO.ServiceDAO;
import SuperClases.Articulo;
import interfaces.IDescripcionArticulo;
import interfaces.IArticulo;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import interfaces.IUser;
import java.util.ArrayList;

/**
 *
 * @author Joack
 */
public class Service implements IObligacionAdmin<IUser>, IObligacionProducManager<IArticulo>
{
    private final  ServiceDAO   service;
    private static Service      instance;
    
    private Service()
    {
            service = new ServiceDAO();
    }
    
    public synchronized static Service getService()
    {
        if( instance == null )
        {
            instance = new Service();
        }
            
        return instance;   
    }
    
    public void closeService()
    {
        instance = null;
    }
  
// <editor-fold defaultstate="collapsed" desc="User Manager Services."> 

    @Override
    public boolean createUser(IUser user)
    {
        return service.createUser(user);
    }
    
    @Override
    public boolean deleteUser(Object primaryKey) 
    {
        return service.deleteUser(primaryKey);
    }    
    
    @Override
    public boolean updateUser( IUser user )
    {
        return service.updateUser(user);
    }
    
    @Override
    public IUser readAUser(Object primaryKey) 
    {
       return service.readAUser(primaryKey); 
    }
    
    @Override
    public ArrayList<IUser> readAllUsers() 
    {
        return service.readAllUsers();
    }
  
    public boolean isAlreadyUser( Object primaryKey )
    {
        return( service.readAUser(primaryKey) != null );
    }
    
    public boolean isAdministrator( IUser user )
    {
        return user.isAdministrator();
    }    
    
//</editor-fold>    

// <editor-fold defaultstate="collapsed" desc="Product Manager Services.">    
    
    @Override
    public boolean createArticulo(IArticulo articulo) 
    {
        return service.createArticulo(articulo);
    }

    @Override
    public boolean deleteArticulo(Object primaryKey) 
    {
        return service.deleteArticulo(primaryKey);
    }

    @Override
    public boolean updateArticulo(IArticulo articulo) 
    {
        return service.updateArticulo(articulo);
    }

    @Override
    public IArticulo readAnArticulo(Object primaryKey) 
    {
        return service.readAnArticulo(primaryKey);
    }

    @Override
    public ArrayList<IArticulo> readAllArticulos() 
    {
        return service.readAllArticulos();
    }

    public boolean articuloExist( Object primaryKey )
    {
        return( service.readAnArticulo(primaryKey) != null );
    }
    
    
//</editor-fold> 
   
//<editor-fold defaultstate="collapsed" desc="Cart Manager Services.">

public boolean agregarProductoAlCarrito( Articulo articulo, int cantidad )
{
    return true;
}    
    
    
//</editor-fold>

    @Override
    public boolean createDescrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDescrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDescrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDescripcionArticulo readDescrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IDescripcionArticulo> readAllDescrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
