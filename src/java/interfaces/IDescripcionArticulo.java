/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

public interface IDescripcionArticulo 
{   
    public int    getIdArticulo();
    
    public int    getStock();
    public float  getPrecio();
    public String getDescripcion();
    public String getImagen();

    public void   setStock( int stock );
    public void   setPrecio( float precio );
    public void   setDescripcion( String descripcion );
    public void   setImagen( String imagen );       
}
