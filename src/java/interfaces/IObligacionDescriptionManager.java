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
public interface IObligacionDescriptionManager<Descripcion>
{
    public boolean createDescrip(Descripcion prodDescrip);
    public boolean deleteDescrip(Object primaryKey);
    public boolean updateDescrip(Descripcion prodDescrip);
    
    public Descripcion readDescrip(Object primaryKey);
    public ArrayList<Descripcion> readAllDescrip();
}
