/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Pelicula;

import Entidad.Pelicula;
import Modelo.ModelPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ServletMantenimientoPelicula", urlPatterns = {"/ServletMantenimientoPelicula"})
public class ServletMantenimientoPelicula extends HttpServlet {

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

        String nombre = request.getParameter("nombre");
        int genero = Integer.parseInt(request.getParameter("idGenero"));
        String str_genero = "";
        String clasificacion = request.getParameter("clasificacion");
        String str_clasificacion = "";
        String duracion = request.getParameter("duracion");
        String director = request.getParameter("director");
        String actores = request.getParameter("actores");
        String sinopsis = request.getParameter("sinopsis");
        
        //PROCESANDO VALORES
        nombre = nombre.toUpperCase();
        switch (genero) {
            case 1:
                str_genero = "COMEDIA";
                break;
            case 2:
                str_genero = "DRAMA";
                break;
            case 3:
                str_genero = "CIENCIA FICCION";
                break;
            case 4:
                str_genero = "ROMANTICO";
                break;
            case 5:
                str_genero = "ANIMACION";
                break;
        }

        switch (clasificacion) {
            case "A":
                str_clasificacion = "APTA PARA TODOS";
                break;
            case "C":
                str_clasificacion = "SOLO ADULTOS";
                break;
        }
        
        director = director.toUpperCase();
        actores = actores.toUpperCase();
        sinopsis = sinopsis.toUpperCase();

        //ENVIANDO VALORES AL JSP
        request.setAttribute("jsp_nombre", nombre);
        request.setAttribute("jsp_genero", str_genero);
        request.setAttribute("jsp_clasificacion", str_clasificacion);
        request.setAttribute("jsp_duracion", duracion);
        request.setAttribute("jsp_director", director);
        request.setAttribute("jsp_actores", actores);
        request.setAttribute("jsp_sinopsis", sinopsis);
        
        //INSERTAMOS EN BASE DE DATOS
        Pelicula nuevaPeli = new Pelicula();
        nuevaPeli.setNombre(nombre);
        nuevaPeli.setGenero(String.valueOf(genero));
        nuevaPeli.setActores(actores);
        nuevaPeli.setDirector(director);
        nuevaPeli.setSinopsis(sinopsis);
        nuevaPeli.setClasificacion(clasificacion);
        nuevaPeli.setDuracion(duracion);
        
        ModelPelicula modelPelicula = new ModelPelicula();
        modelPelicula.savePelicula(nuevaPeli);
        
        // REDIRECCION A JSP
        request.getRequestDispatcher("Pelicula.jsp").forward(request, response);

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
