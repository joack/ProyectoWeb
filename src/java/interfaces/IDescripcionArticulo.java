/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

public interface IDescripcionArticulo 
{

    public String getMarca();
    public void   setMarca(String marca);

    public String getModelo();
    public void   setModelo(String modelo);

    public String getNombre();
    public void   setNombre(String nombre);

    public int    getStock();
    public void   setStock(int stock);

    public String getDescripcion();
    public void   setDescripcion(String descripcion);

    public String getImagen();
    public void   setImagen(String imagen);

    public float  getPrecio();
    public void   setPrecio(float precio);
    
    
}
