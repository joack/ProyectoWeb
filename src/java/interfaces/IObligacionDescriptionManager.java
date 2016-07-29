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
public interface IObligacionDescriptionManager 
{
    public boolean createDescrip();
    public boolean deleteDescrip();
    public boolean updateDescrip();
    
    public IDescripcionArticulo readDescrip();
    public ArrayList<IDescripcionArticulo> readAllDescrip();
}
