package DAO;

import ServiceManager.Service;
import interfaces.IArticulo;
import interfaces.IObligacionAdmin;
import interfaces.IObligacionProducManager;
import java.util.ArrayList;
import interfaces.IDescripcionArticulo;
import interfaces.IObligacionArticuloDescrip;
import interfaces.IObligacionDescriptionManager;
import interfaces.IUser;
import modelo.Producto;
import modelo.Tupla;


public class UsuarioAdminDAO implements IObligacionAdmin<IUser>, IObligacionProducManager<IArticulo>, IObligacionDescriptionManager<IDescripcionArticulo>, IObligacionArticuloDescrip<Tupla>
{
    private final Service service = Service.getService();

    
// <editor-fold defaultstate="collapsed" desc="Administracion de Usuarios.">   
    @Override
    public boolean createUser(IUser clase) 
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
    public boolean updateUser(IUser clase) 
    { 
        try{
            return service.updateUser(clase);
        }finally{
            service.closeService();
        }           
    }

    @Override
    public IUser readAUser(Object key) 
    {
        try{
            return service.readAUser(key);
        }finally{
            service.closeService();
        }    
    }

    @Override
    public ArrayList<IUser> readAllUsers() 
    {
        try{
            return service.readAllUsers();
        }finally{
            service.closeService();
        }        
    }
    
    public boolean isAlreadyUser( Object key )
    {
        return service.isAlreadyUser(key);
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
    public boolean createDescrip(IDescripcionArticulo descrip) 
    {
        try{
            return service.createDescrip(descrip);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public boolean deleteDescrip(Object primaryKey) 
    {      
        try{
            return service.deleteDescrip(primaryKey);
        }finally{
            service.closeService();
        }       
    }

    @Override
    public boolean updateDescrip(IDescripcionArticulo descrip) 
    {
        try{
            return service.updateDescrip(descrip);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public IDescripcionArticulo readDescrip(Object primaryKey) 
    {
        try{
            return service.readDescrip(primaryKey);
        }finally{
            service.closeService();
        }        
    }

    @Override
    public ArrayList<IDescripcionArticulo> readAllDescrip() 
    {
        try{
            return service.readAllDescrip();
        }finally{
            service.closeService();
        }        
    }
    
    
    public ArrayList<Producto> getAllProducts()
    {
        try{
            return service.listaDeProductos();
        }finally{
            service.closeService();
        }    
    }
    
    public ArrayList<IArticulo> getAllArticulos()
    {
        try{
            return service.readAllArticulos();
        }finally{
            service.closeService();
        }        
    }
    
    public ArrayList<IDescripcionArticulo> getAllDescripciones()
    {
        try{
            return service.readAllDescrip();
        }finally{
            service.closeService();
        }    
    }
    
    
// </editor-fold>

    @Override
    public boolean createTupla(Tupla prod) 
    {
         try{
            return service.createTupla(prod);
        }finally{
            service.closeService();
        }       
    }

    @Override
    public boolean deleteTupla(Object primaryKey) {
        try{
            return service.deleteTupla(primaryKey);
        }finally{
            service.closeService();
        }
    }

    @Override
    public boolean updateTupla(Tupla prod) {
         try{
            return service.updateTupla(prod);
        }finally{
            service.closeService();
        }       
    }

    @Override
    public Tupla readTupla(Object primaryKey) {
        try{
            return service.readTupla(primaryKey);
        }finally{
            service.closeService();
        }
    }

    @Override
    public ArrayList<Tupla> readAllTupla() {
        try{
            return service.readAllTupla();
        }finally{
            service.closeService();
        }
    }


    
}
