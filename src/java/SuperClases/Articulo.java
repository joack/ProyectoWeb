/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperClases;

import interfaces.IArticulo;

/**
 *
 * @author Joack
 */
public abstract class Articulo  implements IArticulo
{
    private int     idCodigo;   //clave primaria.
    private int     idArticulo; //clave foranea.
 
    public Articulo() 
    {
    }

    public Articulo(int idCodigo) 
    {
        this.idCodigo = idCodigo;
    }

    public Articulo(int idCodigo, int idArticulo) 
    {
        this.idCodigo = idCodigo;
        this.idArticulo = idArticulo;
    }

    @Override
    public int getIdCodigo() 
    {
        return idCodigo;
    }

    @Override
    public void setIdCodigo(int idCodigo) 
    {
        this.idCodigo = idCodigo;
    }

    @Override
    public int getIdArticulo() 
    {
        return idArticulo;
    }

    @Override
    public void setIdArticulo(int idArticulo) 
    {
        this.idArticulo = idArticulo;
    }
    
    @Override
    public abstract int getStock();

    @Override
    public void setStock(int stock){}

    @Override
    public abstract String getDescripcion();

    @Override
    public void setDescripcion(String descripcion){}
    
    @Override
    public abstract String getImagen();

    
    @Override
    public void setImagen(String imagen){}  

    @Override
    public abstract String getMarca();

    @Override
    public void setMarca(String marca){}

    @Override
    public abstract String getModelo(); 


    @Override
    public void setModelo(String modelo){}

    @Override
    public abstract String getNombre();

    @Override
    public void setNombre(String nombre){}

    @Override
    public abstract float getPrecio();

    @Override
    public void setPrecio(float precio){}  
    
}
