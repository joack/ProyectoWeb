/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Articulo;
import interfaces.IDescripcionArticulo;

/**
 *
 * @author Joack
 */
public class ProdDescripcion extends Articulo implements IDescripcionArticulo
{
    private int     stock;
    private String  descripcion;
    private String  imagen;
    private float   precio;
 
    public ProdDescripcion() {}

    public ProdDescripcion(int idArticulo, int stock, String descripcion, String imagen, float precio) {
        super(0, idArticulo);
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }
    
    @Override
    public int getIdCodigo(){
        return 0;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }
   
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    @Override
    public String getImagen() {
        return imagen;
    }

    @Override
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
        
   
    
}
