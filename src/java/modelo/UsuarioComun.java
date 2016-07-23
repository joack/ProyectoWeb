/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SuperClases.Usuario;
import java.util.ArrayList;

public class UsuarioComun extends Usuario
{
    private String nickName;
    
    ArrayList<Electrodomestico> carrito = new ArrayList();
    
    public UsuarioComun(String email, String nickName, String password, String rol) 
    {
        super(email, password, rol);
        this.nickName = nickName;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
}
