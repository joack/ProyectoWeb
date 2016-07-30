package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.UsuarioAdminDAO;
import interfaces.IArticulo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joack
 */
public class AdministradorProductoDescripcionEditar extends HttpServlet {

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
        
        //int idArticulo  = (int)     request.getSession().getAttribute("idArticulo");
        String descrip  = (String)  request.getSession().getAttribute("idDescrip");
        String imagen   = (String)  request.getSession().getAttribute("idImagen");
        int precio      = (int)     request.getSession().getAttribute("idPrecio");
        int stock       = (int)     request.getSession().getAttribute("idStock");
        
        /*IArticulo articulo = admin.readAnArticulo(idArticulo);
        
        articulo.setDescripcion(descrip);
        articulo.setImagen(imagen);
        articulo.setPrecio(precio);
        articulo.setStock(stock);
        
        if(admin.updateArticulo(articulo)) 
        {
            String exito = "Se ha actualizado exitosamente.";
            request.getSession().setAttribute("exito", exito);
            request.getRequestDispatcher("page/success.jsp").forward(request, response);
        }else{
            String error = "No se ha podido actualizar.";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("page/error.jsp").forward(request, response);        
        } */   
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
