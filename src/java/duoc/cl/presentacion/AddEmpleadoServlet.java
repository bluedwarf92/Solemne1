/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.presentacion;

import duoc.cl.entidades.Empleado;
import duoc.cl.negocio.EmpleadoBO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cami
 */
@WebServlet(name = "AddEmpleadoServlet", urlPatterns = {"/addEmpleado"})
public class AddEmpleadoServlet extends HttpServlet {


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
        HttpSession sesion = request.getSession();
        String RUT = request.getParameter("newRUT");
        String nombre = request.getParameter("newNombre");
        String apellidos = request.getParameter("newApellido");
        int telefono = Integer.parseInt(request.getParameter("newTelefono"));
        String direccion = request.getParameter("newDireccion");
        
        if (!((telefono == 0) || (RUT == null) || (nombre == null) || (apellidos == null) || (direccion == null))) {
            Empleado objEmpleado = new Empleado(0, nombre, apellidos, telefono, direccion, RUT);
            EmpleadoBO objEmpleadoBO = new EmpleadoBO();
            if (objEmpleadoBO.addEmpleado(objEmpleado)) {
                sesion.setAttribute("exitoIngresoEmpleado", "Empleado Correctamente Ingresado");
                response.sendRedirect("MantenedorEmpleados.jsp");
            } else {
                sesion.setAttribute("error", "No se pudo ingresar la información.");
                response.sendRedirect("MantenedorEmpleados.jsp");
            }

        } else {
            sesion.setAttribute("error1", "debe completar todos los campos");
            response.sendRedirect("MantenedorEmpleados.jsp");
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
