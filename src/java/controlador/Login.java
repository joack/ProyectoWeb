/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UsuarioAdminDAO;
import ServiceManager.Service;
import SuperClases.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Joack
 */
public class Login extends HttpServlet 
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
        
        String usuario  = request.getParameter("txtUserName");
        String password = request.getParameter("txtPass");
        
       
        if ( service.isAlreadyUser(usuario) ) 
        {
            Usuario user = service.readAUser(usuario);
            if ( user.getPassword().equals(password)) 
            {     
                if (service.isAdministrator(user)) 
                {

                    request.getSession().setAttribute("usuario", new UsuarioAdminDAO());
                    request.getRequestDispatcher("/pages/welcomeAdmin.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("usuario", usuario);
                    request.getRequestDispatcher("/pages/welcome.jsp").forward(request, response);

                }
            }else{
                String error = "Contraseña incorrecta.";
                errorPage( error, request, response );
                request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("/pages/signup.jsp").forward(request, response);
        }

        service.closeService();

    }
    
    private void errorPage( String error, HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException
    {
        request.getSession().setAttribute("error", error);
        request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

    
}
