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
import interfaces.IObligacionArticuloDescrip;
import interfaces.IObligacionDescriptionManager;
import interfaces.IObligacionProducManager;
import interfaces.IUser;
import java.util.ArrayList;
import modelo.ProdDescripcion;
import modelo.Producto;
import modelo.Tupla;

/**
 *
 * @author Joack
 */
public class Service implements IObligacionAdmin<IUser>, IObligacionProducManager<IArticulo>, IObligacionDescriptionManager<IDescripcionArticulo>, IObligacionArticuloDescrip<Tupla>
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

    // <editor-fold defaultstate="collapsed" desc="Methods Articulo.">
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

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods Articulo descripcion.">
    @Override
    public boolean createDescrip(IDescripcionArticulo descrip) 
    {
        return service.createDescrip(descrip);
    }

    @Override
    public boolean deleteDescrip(Object primaryKey) 
    {
        return service.deleteDescrip(primaryKey);
    }

    @Override
    public boolean updateDescrip(IDescripcionArticulo descrip) 
    {
        return service.updateDescrip(descrip);
    }

    @Override
    public IDescripcionArticulo readDescrip(Object primaryKey) 
    {
        return service.readDescrip(primaryKey);
    }

    @Override
    public ArrayList<IDescripcionArticulo> readAllDescrip() 
    {
        return service.readAllDescrip();
    }

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods Tuplas.">
 
    @Override
    public boolean createTupla(Tupla prod) 
    {
        return service.createTupla(prod);
    }

    @Override
    public boolean deleteTupla(Object primaryKey) 
    {
        return service.deleteTupla(primaryKey);
    }

    @Override
    public boolean updateTupla(Tupla prod) 
    {
        return service.updateTupla(prod);
    }

    @Override
    public Tupla readTupla(Object primaryKey) 
    {
        return service.readTupla(primaryKey);
    }

    @Override
    public ArrayList<Tupla> readAllTupla() 
    {
        return service.readAllTupla();
    }
    
    //</editor-fold>   
    
    public boolean articuloExist( Object primaryKey )
    {
        return( service.readAnArticulo(primaryKey) != null );
    }

    public ArrayList<Producto> listaDeProductos()
    {
        ArrayList<Producto> listaProductos = new ArrayList();
        ArrayList<Tupla> tuplas = service.readAllTupla();
        int pK, fK;
        IArticulo art;
        IDescripcionArticulo descrip;
        
        for( Tupla tupla: tuplas)
        {
            pK = tupla.getPrimaryKey();
            fK = tupla.getForeignKey();
            art = readAnArticulo(pK);
            descrip = readDescrip(fK);
            
            if (descrip == null) 
            {
                descrip = new ProdDescripcion(-1, -1, "null", "null", -1);
            }
            
            listaProductos.add( new Producto(art.getIdCodigo()       , 
                                             descrip.getIdArticulo() , 
                                             art.getMarca()          , 
                                             art.getModelo()         , 
                                             art.getNombre()         , 
                                             descrip.getDescripcion(), 
                                             descrip.getImagen()     , 
                                             descrip.getStock()      , 
                                             descrip.getPrecio()     ));
        }
        
        return listaProductos;
    }     
    
//</editor-fold> 
   
//<editor-fold defaultstate="collapsed" desc="Cart Manager Services.">

public boolean agregarProductoAlCarrito( Articulo articulo, int cantidad )
{
    return true;
}    
    
    
//</editor-fold>

}
