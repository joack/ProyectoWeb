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
public interface IObligacionAdmin <Usuario>
{
    public boolean createUser( Usuario user );
    public boolean deleteUser( Object primaryKey );
    public boolean updateUser( Usuario user );
    
    public Usuario readAUser( Object primaryKey );
    public ArrayList<Usuario> readAllUsers();
}
