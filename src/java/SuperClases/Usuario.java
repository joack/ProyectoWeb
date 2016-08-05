/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperClases;

/**
 *
 * @author Joack
 */
public abstract class Usuario
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

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
   
    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getRol() 
    {
        return rol;
    }
  
    public void setRol(String rol) 
    {
        this.rol = rol;
    }
    
    public abstract boolean isAdministrator();
    
    
}
