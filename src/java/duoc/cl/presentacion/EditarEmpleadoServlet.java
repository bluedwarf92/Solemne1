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
        int id = Integer.parseInt(request.getParameter("id_empleado"));     
        EmpleadoBO objEmpleadoBO = new EmpleadoBO();
        Empleado objEmpleado = objEmpleadoBO.getEmpleado(id);
        if (objEmpleado != null) {
            sesion.setAttribute("empleadoBuscado", objEmpleado);
            response.sendRedirect("MantenedorEmpleados.jsp");
        } else {
            sesion.setAttribute("error", "no se encontró el empleado");
            response.sendRedirect("MantenedorEmpleados.jsp");
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
        HttpSession sesion=request.getSession();
        int id_empleado=Integer.parseInt(request.getParameter("hdnId_empleado"));
        String RUT=request.getParameter("modRUT");
        String Nombre =request.getParameter("modNombre"); 
        String Apellidos =request.getParameter("modApellido");
        int telefono=Integer.parseInt(request.getParameter("modTelefono"));
        String Direccion =request.getParameter("modDireccion");
        Empleado objEmpleado= new Empleado(id_empleado, Nombre, Apellidos, telefono, Direccion, RUT);
        EmpleadoBO objEmpleadoBO= new EmpleadoBO();
        if(objEmpleadoBO.update(objEmpleado)){
            sesion.removeAttribute("empleadoBuscado");
            sesion.setAttribute("exitoIngresoEmpleado", "Empleado Actualizado Correctamente");
            response.sendRedirect("MantenedorEmpleados.jsp");
        }else{
            sesion.setAttribute("error", "No se pudo updatear el empleado");
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
