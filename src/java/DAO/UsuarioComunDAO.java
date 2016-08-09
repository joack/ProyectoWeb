/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ServiceManager.Service;
import interfaces.ICart;
import java.util.ArrayList;
import modelo.Carrito;
import modelo.Producto;

/**
 *
 * @author Joack
 */
public class UsuarioComunDAO implements ICart
{
    private final Service serviceManager = Service.getService(); 

    @Override
    public Carrito getCart() {
        try{
            return serviceManager.getCart();
        }finally{
            serviceManager.closeService();
        }
        
    }

    @Override
    public void destroyCart() 
    {
        try{
            serviceManager.destroyCart();
        }finally{
            serviceManager.closeService();
        }        
        
    }

    @Override
    public float getTotalProductPrice( int key)
    {
        try{
            return serviceManager.getTotalProductPrice(key);
        }finally{
            serviceManager.closeService();
        }     
    }
    
    
    @Override
    public float getTotalPrice() 
    {
        try{
            return serviceManager.getTotalPrice();
        }finally{
            serviceManager.closeService();
        }   
    }
    
    @Override
    public void recalcTotalPrice( float monto )
    {
        try{
            serviceManager.recalcTotalPrice(monto);
        }finally{
            serviceManager.closeService();
        }      
    }
    
    @Override
    public void addItem(int key, int cantidad) 
    {
        try{
            serviceManager.addItem(key, cantidad);
        }finally{
            serviceManager.closeService();
        }  
    }

    @Override
    public void removeItem(int key, int cantidad) 
    {
        try{
            serviceManager.removeItem(key, cantidad);
        }finally{
            serviceManager.closeService();
        }  
    }

    @Override
    public void setItemAmount(int key, int cantidad)
    {
        try{
            serviceManager.setItemAmount(key, cantidad);
        }finally{
            serviceManager.closeService();
        }   
    }
       
    @Override
    public void deleteItem(int key) 
    {
        try{
            serviceManager.deleteItem(key);
        }finally{
            serviceManager.closeService();
        }   
    }
     
    @Override
    public void removeAllItems() 
    {
        try{
            serviceManager.removeAllItems();
        }finally{
            serviceManager.closeService();
        }   
    }

    @Override
    public void payProducts() 
    {
        try{
            serviceManager.payProducts();
        }finally{
            serviceManager.closeService();
        }
    }

    public ArrayList<Producto> getProductList()
    {
        ArrayList<Producto> lista = serviceManager.listaDeProductos();
        
        for (int i = 0; i < lista.size(); i++) 
        {
            if (lista.get(i).getStock() == 0 ) 
            {
                lista.remove(i);
            }
        }
        return lista;
    }
}
