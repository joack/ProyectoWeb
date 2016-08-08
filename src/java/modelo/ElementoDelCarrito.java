/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import interfaces.IProduct;

/**
 *
 * @author Joack
 */
public class ElementoDelCarrito 
{
    private final IProduct producto;
    private int cantidad = 0;
    
    
    //Constructor
    public ElementoDelCarrito( IProduct producto, int cantidad )
    {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getCantidad()
    {
        return cantidad;
    }
    
    public int getProductKey()
    {
        return producto.getIdCodigo();
    }
    
    public IProduct getProducto()
    {
        return producto;
    }
    
    public float getPrecioProducto()
    {
        return producto.getPrecio();
    }
        
    public float getPrecioTotalDelProducto()
    {
        return cantidad * producto.getPrecio();
    }   
    
    public int getStock()
    {
        return producto.getStock();
    }
    
    public void setCantidad( int cantidad)
    {
        this.cantidad = cantidad;
    }
    
    
    public boolean incrementElementoDelCarrito( int cantidad )
    {
        int stock = producto.getStock();
        int cantActual = this.cantidad + cantidad;
        
        if (cantActual < (stock +1)) 
        {
            this.cantidad += cantidad;
            return true;
        }
        return false;
        
    }
    
    public void decrementElementoDelCarrito( int cantidad )
    {
        if ( (this.cantidad - cantidad) < 0 )
        {
            this.cantidad = 0;
        }else{
            this.cantidad -= cantidad;
        }
    }
   

    
}
