/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperClases;

import interfaces.IUser;

/**
 *
 * @author Joack
 */
public abstract class Usuario implements IUser
{
    private String email;
    private String password;
    private String rol;

    public Usuario(String email, String password, String rol) 
    {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    @Override
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }


    @Override
    public String getPassword() 
    {
        return password;
    }

    @Override
    public void setPassword(String password) 
    {
        this.password = password;
    }

    @Override
    public String getRol() 
    {
        return rol;
    }

    @Override
    public void setRol(String rol) 
    {
        this.rol = rol;
    }
    
    @Override
    public String getNickName()
    {
        return "";
    }

    @Override
    public void setNickName( String nickName){}
    

    @Override
    public abstract boolean isAdministrator();
    
    
}
