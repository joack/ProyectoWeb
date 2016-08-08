/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Carrito;

/**
 *
 * @author Joack
 */
public interface ICart 
{
    public Carrito getCart();
    public void destroyCart();
    
    public float getTotalProductPrice( int key);
    public float getTotalPrice();
    public void recalcTotalPrice( float monto );
    
    //public IProduct getItem(int key);
    
    public void addItem( int key, int cantidad );
    public void removeItem( int key, int cantidad );
    
    public void setItemAmount(int key, int cantidad);
    public void deleteItem(int key);
    
    public void removeAllItems();
    public void payProducts();
}
