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
}
