/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import ServiceManager.Service;
import interfaces.ICart;
import interfaces.IProduct;
import java.util.ArrayList;


public class Carrito implements ICart
{
    Service service = Service.getService();
    
    private ArrayList<ElementoDelCarrito> carrito;
    private static Carrito instance;
    private float costo = 0;
    
    private Carrito()
    {
        carrito = new ArrayList();
    }
    
    public static Carrito createCarrito()
    {
        if( instance == null )
        {
            instance = new Carrito();
        }
        
        return instance;
    }
    
    @Override
    public Carrito getCart()
    {
        return instance;
    }
    
    @Override
    public void destroyCart()
    {
        instance = null;
    }
    
    @Override
    public void addItem( int key, int cantidad )
    {
        ElementoDelCarrito producto;
        boolean isNotExistProduct = false;

        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == key) 
            {
                if(producto.incrementElementoDelCarrito(cantidad)) 
                {
                    carrito.set(i, producto);   
                }
                isNotExistProduct = true;
                break;
            }
        }
        
        if (!isNotExistProduct) 
        {              
            carrito.add( new ElementoDelCarrito(service.getProducto(key), cantidad));
        }
    }
  
    @Override
    public void removeItem( int key, int cantidad )
    {
        ElementoDelCarrito producto;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == key ) 
            {
                if ((producto.getCantidad() - cantidad) > 0 ) 
                {
                    producto.decrementElementoDelCarrito(cantidad);
                    carrito.set(i, producto);
                    
                }else{
                    if ((producto.getCantidad() - cantidad) == 0 )
                    {
                        carrito.remove(i);
                    }
                }                
            }
        }           
    }
    
    @Override
    public float getTotalProductPrice(int key)
    {
        ElementoDelCarrito producto;
        float total = 0;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            if (producto.getProductKey() == key ) 
            {
                total = producto.getPrecioTotalDelProducto();
                break;
            }
        }
        return total;
    }
    
    
    @Override
    public float getTotalPrice()
    {
        costo = 0;
        for( ElementoDelCarrito producto: carrito )
        {
            costo += producto.getPrecioTotalDelProducto();
        }
        return costo;
    }
    
    public ElementoDelCarrito getItem_(int key)
    {
        ElementoDelCarrito producto = null;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == key ) 
            {
                break;
            }
        }
        return producto;
    }
    
    @Override
    public void recalcTotalPrice(float monto)
    {
        if ((this.costo - monto ) <= 0 )  
        {
            this.costo = 0;
        }else{
            this.costo -= monto;
        }        
    }
 
    public ArrayList<ElementoDelCarrito> getProductos()
    {
        return carrito;
    }
    
    @Override
    public void removeAllItems()
    {
        carrito.clear();
    }
    
    @Override
    public void deleteItem(int key)
    {
        ElementoDelCarrito producto;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == key ) 
            {
                carrito.remove(i);
                break;
            }
        }
        
    }
       
    @Override
    public void setItemAmount(int key, int cantidad)
    {
        ElementoDelCarrito producto;
        
        for (int i = 0; i < carrito.size(); i++) 
        {
            producto = carrito.get(i);
            
            if (producto.getProductKey() == key ) 
            {
                if ((producto.getStock()>= cantidad)&&(cantidad > 0))
                {
                    producto.setCantidad(cantidad);
                }
                break;
            }
        }       
    }

    @Override
    public void payProducts() 
    {
        IProduct prod;
        int stock = 0;
        
        for( ElementoDelCarrito elemento: carrito )
        {
            prod = elemento.getProducto();
            stock = prod.getStock();
            stock -= elemento.getCantidad();
            prod.setStock(stock);
            service.updateDescrip(prod);           
        }  
    }
    
}
