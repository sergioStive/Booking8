/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import co.sena.edu.booking.DAO.personasDAO;
import co.sena.edu.booking.DTO.personasDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class Controlador extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("registro") != null) {

            personasDTO pdto = new personasDTO();
            personasDAO pdao = new personasDAO();
            
            pdto.setIdPersona(Long.parseLong(request.getParameter("doc")));
            pdto.setNombres(request.getParameter("nombres"));
            pdto.setApellidos(request.getParameter("apellidos"));
            pdto.setCorreoElectronico(request.getParameter("cor"));
            pdto.setFechaNto(request.getParameter("date"));
            pdto.setIdNacionalidad(Integer.parseInt(request.getParameter("paisnac")));
            pdto.setPais(request.getParameter("ciunac"));
            pdto.setTelefono(Integer.parseInt(request.getParameter("tel")));
            pdto.setContraseña(Integer.parseInt(request.getParameter("con")));
            
            String mensaje = pdao.crearPersona(pdto);
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("logueado", pdto);
            response.sendRedirect("menu.jsp?msg="+mensaje);
        }
        else if(request.getParameter("id")!= null){
            personasDAO pdao = new personasDAO();
            String eliminado= pdao.eliminar(Long.parseLong(request.getParameter("id")));
            response.sendRedirect("verificarRegistro.jsp?eliminado="+eliminado);
            }
        
          else if (request.getParameter("submit10") != null){
           personasDAO pert = new personasDAO();
           
          
           
       long x =   pert.isAcountExists(Integer.parseInt(request.getParameter("contraseña")),Long.parseLong(request.getParameter("idPersona")));
           
           if ( x != 0 && x != 10301023) {
               personasDTO per = new personasDTO();
               
               per= pert.ListarUnaPersona(Long.parseLong(request.getParameter("idPersona")));
               HttpSession misesion =request.getSession(true);
               misesion.setAttribute("logueado", per);
               response.sendRedirect("menu.jsp");
               
           }
           else if (x == 0) {
               
               response.sendRedirect("ingreso.jsp?invalida="+x);
               
           }
           else if(x==10301023 && x != 0){
               response.sendRedirect("verificarRegistro.jsp");
           }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
