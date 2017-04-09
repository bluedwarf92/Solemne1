/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.presentacion;

import duoc.cl.entidades.Empleado;
import duoc.cl.entidades.Usuario;
import duoc.cl.negocio.EmpleadoBO;
import duoc.cl.negocio.UsuarioBO;
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
@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/validaUsuario"})
public class InicioSesionServlet extends HttpServlet {


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
        String login = request.getParameter("txtUsername");
        String pass = request.getParameter("txtPassword");
        UsuarioBO objUsuarioBO = new UsuarioBO();
        Usuario objUsuario = objUsuarioBO.validaUsuario(login);
        if (objUsuario != null) {
            if (objUsuario.getUsername().equals(login) && objUsuario.getPassword().equals(pass)) {
                EmpleadoBO objEmpleadoBO = new EmpleadoBO();
                sesion.setAttribute("usuarioConectado", objUsuario);
                Empleado objEmpleado = objEmpleadoBO.getEmpleado(objUsuario.getId_empleado());
                sesion.setAttribute("datosEmpleado", objEmpleado);
                switch (objUsuario.getId_perfil()) {
                    case 1:
                        response.sendRedirect("HomeAdmin.jsp");
                        break;
                    case 2:
                        response.sendRedirect("HomeSupervisor.jsp");
                        break;
                    case 3:
                        response.sendRedirect("HomeCapataz.jsp");
                        break;
                    case 4:
                        response.sendRedirect("HomeObrero.jsp");
                        break;
                }
            } else {
                sesion.setAttribute("error", "la contraseña ingresada es incorrecta");
                response.sendRedirect("Login.jsp");
            }

        } else {
            sesion.setAttribute("error", "El Usuario no Existe");
            response.sendRedirect("Login.jsp");
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
