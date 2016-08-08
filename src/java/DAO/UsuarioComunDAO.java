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
import modelo.ElementoDelCarrito;

/**
 *
 * @author Joack
 */
public class UsuarioComunDAO implements ICart
{
    private final Service serviceManager = Service.getService(); 

    @Override
    public Carrito getCart() {
        return serviceManager.getCart();
    }

    @Override
    public void destroyCart() 
    {
        serviceManager.destroyCart();
    }

    @Override
    public float getTotalProductPrice( int key)
    {
        return serviceManager.getTotalProductPrice(key);
    }
    
    
    @Override
    public float getTotalPrice() 
    {
        return serviceManager.getTotalPrice(); 
    }
    
    @Override
    public void recalcTotalPrice( float monto )
    {       
        serviceManager.recalcTotalPrice(monto);
    }
    
    @Override
    public void addItem(int key, int cantidad) 
    {
        serviceManager.addItem(key, cantidad);
    }

    @Override
    public void removeItem(int key, int cantidad) 
    {
        serviceManager.removeItem(key, cantidad);
    }

    @Override
    public void setItemAmount(int key, int cantidad)
    {
        serviceManager.setItemAmount(key, cantidad);
    }
       
    @Override
    public void deleteItem(int key) 
    {
        serviceManager.deleteItem(key);
    }
     
    @Override
    public void removeAllItems() 
    {
        serviceManager.removeAllItems();
    }

    @Override
    public void payProducts() 
    {
        serviceManager.payProducts();
    }

   
}
