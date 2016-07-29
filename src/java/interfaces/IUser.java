/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Joack
 */
public interface IUser 
{
    public String getEmail();
    public String getPassword();
    public String getNickName();
    public String getRol();
    public boolean isAdministrator();
    
    public void setPassword( String password );
    public void setNickName( String nickName );
  
    public void setRol( String rol );
    
}
