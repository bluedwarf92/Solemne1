/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.negocio;
import duoc.cl.entidades.Empleado;
import java.util.List;
import duoc.cl.persistencia.EmpleadoDAO;

/**
 *
 * @author Cami
 */
public class EmpleadoBO {
    private EmpleadoDAO objEmpleadoDAO;

    public EmpleadoBO() {
        this.objEmpleadoDAO = new EmpleadoDAO();
    }

    public List<Empleado> getAllPerfil() {
        return this.objEmpleadoDAO.readElementos();
    }
    
    public Empleado getEmpleado(int id_empleado){
        return this.objEmpleadoDAO.readElemento(id_empleado);
    }
    
    public boolean addEmpleado(Empleado objEmpleado){
        return this.objEmpleadoDAO.addElemento(objEmpleado);
    }
    
    public boolean deleteEmpleado(int id_empleado){
        return this.objEmpleadoDAO.deleteElemento(id_empleado);
    }
}
