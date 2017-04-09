/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Tipo_Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class Tipo_ObraDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Tipo_Obra objTipo_Obra = (Tipo_Obra) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Tipo_Obra(Descripcion) VALUES(?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objTipo_Obra.getDescripcion());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Tipo_Obra en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Tipo_Obra en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Tipo_Obra> listadoTipo_Obras = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM Tipo_Obra;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tipo_Obra objTipo_Obra = new Tipo_Obra(rs.getInt(1), rs.getString(2));
                listadoTipo_Obras.add(objTipo_Obra);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Tipo_Obras: " + e.getMessage());
        }
        return listadoTipo_Obras;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Tipo_Obra objTipo_Obra = (Tipo_Obra) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE Tipo_Obra SET descripcion=? WHERE id_Tipo_Obra = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objTipo_Obra.getDescripcion());
            ps.setInt(2, objTipo_Obra.getId_tipo_obra());

            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar Tipo_Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la Tipo_Obra en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Tipo_Obra WHERE id_Tipo_Obra=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar el Tipo_Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el Tipo_Obra: " + e.getMessage());
        }
        return false;
    }

}
