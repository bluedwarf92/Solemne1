/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class AsistenciaDAO implements ICRUD{

    @Override
    public boolean addElemento(Object objetoInsert) {
        Asistencia objAsistencia = (Asistencia) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO asistencia(Asiste,id_obra,id_usuario,fecha)VALUES(?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBoolean(1, objAsistencia.getAsiste());
            ps.setInt(2, objAsistencia.getId_obra());
            ps.setInt(3, objAsistencia.getId_usuario());
            ps.setDate(4, objAsistencia.getFecha());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Asistencia en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Asistencia en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Asistencia> listadoAsistencia = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT id_asistencia,id_obra,id_usuario,asiste,fecha FROM Asistencia;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asistencia objAsistencia = new Asistencia(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4), rs.getDate(5));
                listadoAsistencia.add(objAsistencia);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Asistencias: " + e.getMessage());
        }
        return listadoAsistencia; 
        
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Asistencia objAsistencia = (Asistencia) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE asistencia SET Asiste = ?,id_obra = ?,id_usuario = ?,fecha = ? WHERE id_asistencia = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBoolean(1, objAsistencia.getAsiste());
            ps.setInt(2, objAsistencia.getId_obra());
            ps.setInt(3, objAsistencia.getId_usuario());
            ps.setDate(4, objAsistencia.getFecha());
            ps.setInt(5, objAsistencia.getId_asistencia());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar Asistencia: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la Asistencia en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Asistencia WHERE id_asistencia=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar la asistencia: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la asistencia: " + e.getMessage());
        }
        return false;
    }
    
}
