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
 * @param <unaClase>
 */
public interface IObligacion <unaClase> 
{
    public boolean create( unaClase clase);
    public boolean delete( Object key );
    public boolean update( unaClase clase );
    
    public unaClase read ( Object key );
    public ArrayList<unaClase> readAll();
}
