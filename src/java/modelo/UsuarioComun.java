/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Usuario;
import interfaces.IUser;
import java.util.ArrayList;

public class UsuarioComun extends Usuario implements IUser
{
    private String nickName;
    
    ArrayList<Producto> carrito = new ArrayList();
    
    public UsuarioComun(){
        super(null, null, null);
    }
    
    public UsuarioComun(String email, String nickName, String password, String rol) 
    {
        super(email, password, rol);
        this.nickName = nickName;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean isAdministrator() {
        return false;
    }
    
}
