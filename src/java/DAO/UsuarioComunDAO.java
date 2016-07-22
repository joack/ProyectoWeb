/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import SuperClases.Usuario;
import interfaces.IObligacion;
import java.util.ArrayList;

/**
 *
 * @author Joack
 */
public class UsuarioComunDAO implements IObligacion<Usuario>
{

    @Override
    public boolean create(Usuario clase) 
    {
        return false;
    }

    @Override
    public boolean delete(Object key) 
    {
        return false;
    }

    @Override
    public boolean update(Usuario clase) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(Object key) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> readAll() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
