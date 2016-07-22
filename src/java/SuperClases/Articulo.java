/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperClases;

/**
 *
 * @author Joack
 */
public abstract class Articulo 
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

    public int getIdCodigo() 
    {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) 
    {
        this.idCodigo = idCodigo;
    }

    public int getIdArticulo() 
    {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) 
    {
        this.idArticulo = idArticulo;
    }
    
    public int getStock() 
    {
        return 0;
    }

    public void setStock(int stock){}

    public String getDescripcion() 
    {
        return "";
    }

    public void setDescripcion(String descripcion){}
    
    public String getImagen()
    {
        return "";
    }

    public void setImagen(String imagen){}  

    public String getMarca() 
    {
        return "";
    }

    public void setMarca(String marca){}

    public String getModelo() 
    {
        return "";
    }

    public void setModelo(String modelo){}

    public String getNombre() 
    {
        return "";
    }

    public void setNombre(String nombre){}

    public float getPrecio() 
    {
        return 0;
    }

    public void setPrecio(float precio){}    
    
}
