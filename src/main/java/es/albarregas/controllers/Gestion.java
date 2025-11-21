package es.albarregas.controllers;

import es.albarregas.beans.Cliente;
import es.albarregas.models.EnumConverter;
import es.albarregas.models.Utilities;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 *
 * @author jesus
 */
@WebServlet(name = "Gestion", urlPatterns = {"/Gestion"})
public class Gestion extends HttpServlet {

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
//        processRequest(request, response);
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
        String opcion = request.getParameter("enviar");
        String url = ".";
        
        Cliente cliente = new Cliente();

        switch (opcion) {
            case "Crear":
            case "Modificar":
                Boolean error = Utilities.camposVacios(request.getParameterNames(), request);
                if (!error) {

                    DateConverter converter = new DateConverter();
                    converter.setPattern("yyyy-MM-dd");
                    ConvertUtils.register(converter, Date.class);
                    ConvertUtils.register(new EnumConverter(), Cliente.TipoIdentificacion.class);

                    try {
                        BeanUtils.populate(cliente, request.getParameterMap());
                    } catch (IllegalAccessException | InvocationTargetException ex) {
                        Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    request.getSession().setAttribute("cliente", cliente);
                    url = "index.jsp";
                } else {

                    request.setAttribute("error", "Todos los campos son obligatorios");
                    url = (opcion.equalsIgnoreCase("modificar")) ? "JSP/modificar.jsp" : "JSP/crear.jsp";
                }
                break;

            case "Eliminar":
                request.getSession().removeAttribute("cliente");
                break;

        }

        request.getRequestDispatcher(url).forward(request, response);
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
