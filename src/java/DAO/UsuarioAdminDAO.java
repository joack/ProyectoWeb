package DAO;

import ServiceManager.Service;
import SuperClases.Articulo;
import SuperClases.Usuario;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import java.util.ArrayList;


public class UsuarioAdminDAO implements IObligacionAdmin<Usuario>, IObligacionProducManager<Articulo>
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
    public boolean createArticulo( Articulo articulo) 
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
    public boolean updateArticulo(Articulo articulo) 
    {      
        try{
            return service.updateArticulo(articulo);
        }finally{
            service.closeService();
        }         
    }

    @Override
    public Articulo readAnArticulo(Object primaryKey) 
    {  
        try{
            return service.readAnArticulo(primaryKey);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public ArrayList<Articulo> readAllArticulos() 
    {
        try{
            return service.readAllArticulos();
        }finally{
            service.closeService();
        }     
    }
    
// </editor-fold>
    
}
