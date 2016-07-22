/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ElectrodomesticoDAO;
import DAO.ServiceDAO;
import DAO.UsuarioAdminDAO;
import DAO.UsuarioComunDAO;
import ServiceManager.Service;
import SuperClases.Articulo;
import modelo.Electrodomestico;
import SuperClases.Usuario;
import java.util.ArrayList;


/**
 *
 * @author Joack
 */
public class Prueba 
{
    public static void main(String args[])
    {
        Service servicio = Service.getService();
        UsuarioAdminDAO admin;
        UsuarioComunDAO cliente;
        ArrayList<Articulo> lista = null;
        
        Usuario user = servicio.readAUser("joaquinacuna_1407@hotmail.com");
        
        if (user.isAdministrator()) 
        {
            admin = new UsuarioAdminDAO();
            lista = admin.readAllArticulos();
        }else{
            cliente = new UsuarioComunDAO();
        }
        
        
        
        /*user = admin.readAUser("joaquinacuna_1407@hotmail.com");
        
        
        
        System.out.println(user.getEmail());
        System.out.println(user.getNickName());
        System.out.println(user.getPassword());
        System.out.println(user.getRol());
        
        
        Electrodomestico producto;
        
        producto = admin.readAnArticulo(1);
        
        System.out.println(producto.getIdCodigo());
        System.out.println(producto.getPrecio());*/

    }
}
