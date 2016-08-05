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

    public String getNombre();
    public String getMarca();
    public String getModelo();
    
    public void   setNombre( String nombre );
    public void   setMarca( String marca );
    public void   setModelo( String modelo);
    
}
