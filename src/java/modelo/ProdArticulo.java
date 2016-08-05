/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Articulo;
import interfaces.IArticulo;

/**
 *
 * @author Joack
 */
public class ProdArticulo extends Articulo implements IArticulo
{
    private String nombre;
    private String marca;
    private String modelo;

    public ProdArticulo(){}

    public ProdArticulo(int idCodigo, String nombre, String marca, String modelo)
    {
        super(idCodigo, 0);
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    @Override
    public int getIdArticulo(){
        return 0;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
