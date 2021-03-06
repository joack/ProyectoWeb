/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UsuarioAdminDAO;
import DAO.UsuarioComunDAO;
import ServiceManager.Service;
import interfaces.IUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrito;


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
            IUser user = service.readAUser(usuario);
            if ( user.getPassword().equals(password)) 
            {   
                request.getSession(true);
                
                if (service.isAdministrator(user)) 
                {
                    request.getSession().setAttribute("usuario", new UsuarioAdminDAO());
                    
                    String pagina = "/pages/welcomeAdmin.jsp";
                    request.getSession().setAttribute("pagina", pagina);
                    
                    response.sendRedirect("loginRedirect.do");
                }else{                    
                    request.getSession().setAttribute("usuario", new UsuarioComunDAO());
                    
                    
                    request.getSession().setAttribute("carrito", service.getCart());
                    request.getSession().setAttribute("userDT", user );
                    
                    String pagina = "/pages/welcome.jsp";                    
                    request.getSession().setAttribute("pagina", pagina);
                    request.getSession().setAttribute(pagina, pagina);
                    
                    response.sendRedirect("loginRedirect.do");

                    
                }
            }else{
                String error = "Contraseña incorrecta.";
                errorPage( error, request, response );
                request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
            }
        }else{
            request.getSession().setAttribute( "ok", false );
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
