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
 */
public interface IObligacionProducManager<Articulo> extends IObligacionDescriptionManager
{
    public boolean createArticulo(Articulo articulo);
    public boolean deleteArticulo(Object primaryKey);
    public boolean updateArticulo(Articulo articulo);
    
    public Articulo readAnArticulo(Object primaryKey);
    public ArrayList<Articulo> readAllArticulos();
}
