/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UsuarioAdminDAO;
import SuperClases.Usuario;
import interfaces.IUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioAdmin;
import modelo.UsuarioComun;

/**
 *
 * @author Joack
 */
public class AdministradorUsuarioEditar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        UsuarioAdminDAO admin = (UsuarioAdminDAO) request.getSession().getAttribute("usuario");
        
        String email    = (String)request.getParameter("email");
        String nick     = (String)request.getParameter("nick");
        String pass     = (String)request.getParameter("pass");
        String isAdmin  = (String)request.getParameter("isAdmin");
               
        
        if( admin.isAlreadyUser(email) )
        {   
            IUser user;
            if (isAdmin != null) 
            {
                user = new UsuarioAdmin(email, pass, "admin");
            }else{
                user = new UsuarioComun(email, nick, pass, "user");
            }
            
            if( admin.updateUser(user) ) 
            {
                String exito = "Se ha actualizado con exito.";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("pages/success.jsp").forward(request, response);
            }else{
                String error = "Error al actualizar.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("pages/error.jsp").forward(request, response);
            }
            
        }else{
                String error = "Usuario no encontrado.";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("pages/error.jsp").forward(request, response);
        }     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
