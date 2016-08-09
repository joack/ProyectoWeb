/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.SendEmail;
import ServiceManager.Service;
import interfaces.IUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joack
 */
public class ForgotPass extends HttpServlet 
{
    private Service service = Service.getService();
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
        String email = request.getParameter("email");
        
        if (service.isAlreadyUser(email)) 
        {
            IUser user =  service.readAUser(email);
  
            String msg = "Has recibido este mensaje debido a que has olvidado tu contraseña. \n"
                       + "Si no has sido tú el solicitante, por favor no ignora este mail. \n\n"
                       + "La clave es: " + user.getPassword();

            SendEmail.send(email, "Forgotten Password", msg);
            
            String exito =  "El mensaje se ha enviado correctamente. Por\n"
                    +       "favor revisa tu correo electronico.";
            
            request.getSession().setAttribute("exito", exito);
            request.getRequestDispatcher("pages/success.jsp").forward(request, response);
        }else{
            String error = "El usuario ingresado es invalido. Ingrese un usuario valido.";
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
