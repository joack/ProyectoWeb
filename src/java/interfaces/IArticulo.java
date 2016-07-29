/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Joack
 */
public interface IArticulo 
{
    public int getIdCodigo();
    public int getIdArticulo();
    public int getStock();
    public float getPrecio();
    public String getDescripcion();
    public String getImagen();
    public String getNombre();
    public String getMarca();
    public String getModelo();
    
    public void setIdCodigo( int idCodigo );
    public void setIdArticulo( int idArticulo);
    public void setStock( int stock );
    public void setPrecio( float precio);
    public void setDescripcion( String descripcion );
    public void setImagen( String imagen );
    public void setNombre( String nombre );
    public void setMarca( String marca);
    public void setModelo( String modelo);
    
}
