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
public class Electrodomestico extends Articulo
{
    private String  marca;
    private String  modelo;
    private String  nombre;
    private int     stock;
    private String  descripcion;
    private String  imagen;
    private float   precio;

    public Electrodomestico(){}


    public Electrodomestico( int idCodigo, int idArticulo, String marca, String modelo, String nombre, String descripcion, String imagen, int stock, float precio ) 
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

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
    public String getImagen()
    {
        return imagen;
    }

    public void setImagen(String imagen) 
    {
        this.imagen = imagen;
    }  

    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca) 
    {
        this.marca = marca;
    }

    public String getModelo() 
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public float getPrecio() 
    {
        return precio;
    }

    public void setPrecio(float precio) 
    {
        this.precio = precio;
    }
    
}
