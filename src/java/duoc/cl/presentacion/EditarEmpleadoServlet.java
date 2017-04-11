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
@WebServlet(name = "EditarEmpleadoServlet", urlPatterns = {"/editarEmpleado"})
public class EditarEmpleadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("id_usuario"));
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        String apellidos = request.getParameter("txtApellidos");
        int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
        String direccion = request.getParameter("txtDireccion");
        EmpleadoBO objEmpleadoBO = new EmpleadoBO();
        Empleado objEmpleado = objEmpleadoBO.getEmpleado(id);
        if (objEmpleado != null) {
            sesion.setAttribute("empleadoBuscado", objEmpleado);
            response.sendRedirect("MantenedorEmpleado.jsp");
        } else {
            sesion.setAttribute("error", "no se encontró el empleado");
            response.sendRedirect("MantenedorEmpleado.jsp");
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
