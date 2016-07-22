/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Usuario;

/**
 *
 * @author Joack
 */
public class UsuarioAdmin extends Usuario
{
    
    public UsuarioAdmin(String email,String password, String rol) 
    {
        super(email, password, rol);
    }
    
    @Override
    public boolean isAdministrator()
    {
        return true;
    }
}
