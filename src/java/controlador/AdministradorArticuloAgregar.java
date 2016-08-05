/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UsuarioAdminDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProdArticulo;

/**
 *
 * @author Joack
 */
public class AdministradorArticuloAgregar extends HttpServlet {

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
        
        int idCodigo  = Integer.parseInt(request.getParameter("idCodigo"));
        String marca  = (String)request.getParameter("idMarca");
        String modelo = (String)request.getParameter("idModelo");
        String nombre = (String)request.getParameter("idNombre");
        
        ProdArticulo articulo = new ProdArticulo(idCodigo, nombre, marca, modelo);
        
        if (admin.createArticulo(articulo)) 
        {
            String exito = "Se ha creado el articulo exitosamente.";
            request.getSession().setAttribute("exito", exito);
            request.getRequestDispatcher("pages/success.jsp").forward(request, response);
        }else{
            String error = "No se ha podido crear el articulo.";
            request.getSession().setAttribute("exito", error);
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
