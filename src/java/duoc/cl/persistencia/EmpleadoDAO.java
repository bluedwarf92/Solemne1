/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class EmpleadoDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Empleado objEmpleado = (Empleado) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO EMPLEADO(Nombre,Apellidos,Telefono,Direccion,RUT) VALUES (?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objEmpleado.getNombre());
            ps.setString(2, objEmpleado.getApellidos());
            ps.setInt(3, objEmpleado.getTelefono());
            ps.setString(4, objEmpleado.getDireccion());
            ps.setString(5, objEmpleado.getRUT());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar empleado en la BD: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar empleado en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Empleado> listadoEmpleado = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM Empleado;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado objEmpleado = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                listadoEmpleado.add(objEmpleado);
            }
        } catch (Exception e) {
            System.out.println("Problemas en la lectura " + e.getMessage());
        }
        return listadoEmpleado;
    }
    
     

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Empleado objEmpleado = (Empleado) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE EMPLEADO SET NOMBRE=?,APELLIDOS=?,TELEFONO=?, DIRECCION=?,RUT=? WHERE ID_EMPLEADO=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objEmpleado.getNombre());
            ps.setString(2, objEmpleado.getApellidos());
            ps.setInt(3, objEmpleado.getTelefono());
            ps.setString(4, objEmpleado.getDireccion());
            ps.setString(5, objEmpleado.getRUT());
            ps.setInt(6, objEmpleado.getId_empleado());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar empleado: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar empleado en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Empleado WHERE id_empleado=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar el empleado: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el empleado: " + e.getMessage());
        }
        return false;
    }
    
    public Empleado readElemento(int id_empleado) {
        Empleado objEmpleado = new Empleado();
        try {
            Connection con = Conexion.getConexion();
            String query = "select e.id_empleado,e.Nombre,e.Apellidos,e.Telefono,e.Direccion,e.RUT  from empleado e, usuario u where e.id_empleado = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_empleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado objEmp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                objEmpleado = objEmp;
            }
        } catch (Exception e) {
            System.out.println("Problemas en la lectura " + e.getMessage());
        }
        return objEmpleado;
    }

}
