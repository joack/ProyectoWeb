/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceManager;

import DAO.ServiceDAO;
import SuperClases.Articulo;
import SuperClases.Usuario;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import java.util.ArrayList;

/**
 *
 * @author Joack
 */
public class Service implements IObligacionAdmin<Usuario>, IObligacionProducManager<Articulo>
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
    public boolean createUser(Usuario user)
    {
        return service.createUser(user);
    }
    
    @Override
    public boolean deleteUser(Object primaryKey) 
    {
        return service.deleteUser(primaryKey);
    }    
    
    @Override
    public boolean updateUser( Usuario user )
    {
        return service.updateUser(user);
    }
    
    @Override
    public Usuario readAUser(Object primaryKey) 
    {
       return service.readAUser(primaryKey); 
    }
    
    @Override
    public ArrayList<Usuario> readAllUsers() 
    {
        return service.readAllUsers();
    }
  
    public boolean isAlreadyUser( Object primaryKey )
    {
        return( service.readAUser(primaryKey) != null );
    }
    
    public boolean isAdministrator( Usuario user )
    {
        return user.isAdministrator();
    }    
    
//</editor-fold>    

// <editor-fold defaultstate="collapsed" desc="Product Manager Services.">    
    
    @Override
    public boolean createArticulo(Articulo articulo) 
    {
        return service.createArticulo(articulo);
    }

    @Override
    public boolean deleteArticulo(Object primaryKey) 
    {
        return service.deleteArticulo(primaryKey);
    }

    @Override
    public boolean updateArticulo(Articulo articulo) 
    {
        return service.updateArticulo(articulo);
    }

    @Override
    public Articulo readAnArticulo(Object primaryKey) 
    {
        return service.readAnArticulo(primaryKey);
    }

    @Override
    public ArrayList<Articulo> readAllArticulos() 
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
    
}
