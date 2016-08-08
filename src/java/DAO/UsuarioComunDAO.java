/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ServiceManager.Service;
import interfaces.ICart;
import modelo.Carrito;

/**
 *
 * @author Joack
 */
public class UsuarioComunDAO implements ICart
{
    private final Service service = Service.getService(); 

    @Override
    public Carrito getCart() {
        return service.getCart();
    }

    @Override
    public void destroyCart() 
    {
        service.destroyCart();
    }

    @Override
    public float getTotalProductPrice( int key)
    {
        return service.getTotalProductPrice(key);
    }
    
    
    @Override
    public float getTotalPrice() 
    {
        return service.getTotalPrice(); 
    }
    
    @Override
    public void recalcTotalPrice( float monto )
    {       
        service.recalcTotalPrice(monto);
    }
    
    @Override
    public void addItem(int key, int cantidad) 
    {
        service.addItem(key, cantidad);
    }

    @Override
    public void removeItem(int key, int cantidad) 
    {
        service.removeItem(key, cantidad);
    }

    @Override
    public void setItemAmount(int key, int cantidad)
    {
        service.setItemAmount(key, cantidad);
    }
       
    @Override
    public void deleteItem(int key) 
    {
        service.deleteItem(key);
    }
     
    @Override
    public void removeAllItems() 
    {
        service.removeAllItems();
    }

    @Override
    public void payProducts() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
