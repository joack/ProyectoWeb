/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Joack
 * @param <Producto>
 */
public interface IObligacionArticuloDescrip<Producto>
{
    public boolean createTupla (Producto prod) ;
    public boolean deleteTupla( Object primaryKey);
    public boolean updateTupla( Producto prod);
    
    public Producto readTupla(Object primaryKey);
    public ArrayList<Producto> readAllTupla();
}
