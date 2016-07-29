package DAO;

import ServiceManager.Service;
import SuperClases.Articulo;
import SuperClases.Usuario;
import interfaces.IArticulo;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import java.util.ArrayList;
import interfaces.IDescripcionArticulo;


public class UsuarioAdminDAO implements IObligacionAdmin<Usuario>, IObligacionProducManager<IArticulo>
{
    private final Service service = Service.getService();

    
// <editor-fold defaultstate="collapsed" desc="Administracion de Usuarios.">   
    @Override
    public boolean createUser(Usuario clase) 
    {   
        try{
            return service.createUser(clase);
        }finally{
            service.closeService();
        }
    }

    @Override
    public boolean deleteUser(Object key) 
    { 
        try{
            return service.deleteUser(key);
        }finally{
            service.closeService();
        }           
    }

    @Override
    public boolean updateUser(Usuario clase) 
    { 
        try{
            return service.updateUser(clase);
        }finally{
            service.closeService();
        }           
    }

    @Override
    public Usuario readAUser(Object key) 
    {
        try{
            return service.readAUser(key);
        }finally{
            service.closeService();
        }    
    }

    @Override
    public ArrayList<Usuario> readAllUsers() 
    {
        try{
            return service.readAllUsers();
        }finally{
            service.closeService();
        }        
    }
    
// </editor-fold>
    
    
// <editor-fold defaultstate="collapsed" desc="Administracion de productos.">     
    @Override
    public boolean createArticulo( IArticulo articulo) 
    {  
        try{
            return service.createArticulo(articulo);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public boolean deleteArticulo(Object primaryKey) 
    {   
        try{
            return service.deleteArticulo(primaryKey);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public boolean updateArticulo(IArticulo articulo) 
    {      
        try{
            return service.updateArticulo(articulo);
        }finally{
            service.closeService();
        }         
    }

    @Override
    public IArticulo readAnArticulo(Object primaryKey) 
    {  
        try{
            return service.readAnArticulo(primaryKey);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public ArrayList<IArticulo> readAllArticulos() 
    {
        try{
            return service.readAllArticulos();
        }finally{
            service.closeService();
        }     
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
