/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Articulo;
import interfaces.IProduct;

/**
 *
 * @author Joack
 */
public class Producto extends Articulo implements IProduct
{
    private String  marca;
    private String  modelo;
    private String  nombre;
    private int     stock;
    private String  descripcion;
    private String  imagen;
    private float   precio;

    public Producto(){}

    public Producto( int idCodigo, int idArticulo, String marca, String modelo, String nombre, String descripcion, String imagen, int stock, float precio ) 
    {
        super(idCodigo, idArticulo );
        this.marca          = marca;
        this.modelo         = modelo;
        this.nombre         = nombre;
        this.stock          = stock;
        this.descripcion    = descripcion;
        this.imagen         = imagen;
        this.precio         = precio;
    }

    @Override
    public int getStock() 
    {
        return stock;
    }

    @Override
    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    @Override
    public String getDescripcion() 
    {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    @Override
    public String getImagen()
    {
        return imagen;
    }

    @Override
    public void setImagen(String imagen) 
    {
        this.imagen = imagen;
    }  

    @Override
    public String getMarca() 
    {
        return marca;
    }

    @Override
    public void setMarca(String marca) 
    {
        this.marca = marca;
    }

    @Override
    public String getModelo() 
    {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    @Override
    public String getNombre() 
    {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    @Override
    public float getPrecio() 
    {
        return precio;
    }

    @Override
    public void setPrecio(float precio) 
    {
        this.precio = precio;
    }
    
}
