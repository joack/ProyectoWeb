/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Articulo;
import java.util.ArrayList;



public class Carrito 
{
    private ArrayList<ElementoDelCarrito> carrito;
    public static Carrito instance;
    
    private Carrito()
    {
        carrito = new ArrayList();
    }
    
    public static Carrito getCarrito()
    {
        if( instance == null )
        {
            instance = new Carrito();
        }
        
        return instance;
    }
    
    public void agregarAlCarrito( Articulo articulo, int cantidad )
    {
        ElementoDelCarrito producto;
        boolean isNotExistProduct = false;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == articulo.getIdCodigo()) 
            {
                producto.incrementElementoDelCarrito(cantidad);
                carrito.add(i, producto);
                isNotExistProduct = true;
                break;
            }
        }
        
        if (!isNotExistProduct) 
        {
            carrito.add( new ElementoDelCarrito(articulo, cantidad));
        }
    }
    
    
}
