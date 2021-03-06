/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ServiceManager.Service;
import SuperClases.Usuario;
import interfaces.IUser;
import java.io.IOException;
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
public class SignUp extends HttpServlet 
{ 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        Service service = Service.getService();
        IUser usuario;
        
        String email    = request.getParameter("email");
        String username = request.getParameter("nick");
        String password = request.getParameter("pass");
        String isAdmin  = request.getParameter("admin");
        
        if (email != null && username != null && password != null ) 
        {
            if( isAdmin != null )
            {
                usuario = new UsuarioAdmin( email, password, "admin" );
            }else{
                usuario = new UsuarioComun( email, username, password, "user" );
            }


            if (service.createUser(usuario)) 
            {
                String success = "Usuario agregado correstamente.";
                request.getSession().setAttribute("exito", success);
                request.getRequestDispatcher("/pages/success.jsp").forward(request, response);
            }else{
                String error = "<br>Error al registrar, intentelo de nuevo.";
                String linkVolver = "#";
                request.getSession().setAttribute("error", error);
                request.getSession().setAttribute("link", linkVolver);
                request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
            }
        }else{
            String error = "Los campos no puede estar vacios";
            request.getSession().setAttribute("error", error);
            request.getSession().setAttribute("link", "index.jsp");
            request.getRequestDispatcher("pages/error.jsp").forward(request, response);
        }
        
        service.closeService();
        //response.sendRedirect(request.getHeader("referer"));
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
