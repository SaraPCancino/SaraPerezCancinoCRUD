/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sara
 */
public class Editar2 extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //obtener las variables
            int id;
            String nom, pass, email, pais;
            id= Integer.parseInt(request.getParameter("id2"));
            nom=request.getParameter("nombre2");
            pass=request.getParameter("password2");
            email=request.getParameter("email2");
            pais=request.getParameter("pais2");
            
            //generar objeto del alumno 
              Alumno a = new Alumno();
            
            //envio datos del alumno
              a.setId(id);
              a.setNombre(nom);
              a.setPassword(pass);
              a.setEmail(email);
              a.setPais(pais);
              
              //ejecutar la query
              int estatus = acciones_alumno.Actualizar_alumno(a); 
              
              if(estatus > 0){
                  response.sendRedirect("Consultar_Lista");
              }else{
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editar2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error al momento de obtener los datos</h1>"
            +"<a href ='index.html'>Regresar al menú principal</a>");
            out.println("</body>");
            out.println("</html>");
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
