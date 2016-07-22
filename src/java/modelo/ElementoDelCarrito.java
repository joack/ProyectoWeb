/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Articulo;

/**
 *
 * @author Joack
 */
public class ElementoDelCarrito 
{
    private final Articulo producto;
    private int cantidad = 0;
    
    public ElementoDelCarrito( Articulo producto, int cantidad )
    {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getProductKey()
    {
        return producto.getIdCodigo();
    }
    
    public void incrementElementoDelCarrito( int cantidad )
    {
        this.cantidad += cantidad;
    }
    
}
