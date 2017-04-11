/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class ObraDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Obra objObra = (Obra) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO obra(id_tipo_obra,direccion,id_comuna,valor_hora,fecha_inicio,fecha_fin,descripcion) VALUES(?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objObra.getId_tipo_obra());
            ps.setString(2, objObra.getDireccion());
            ps.setInt(3, objObra.getId_comuna());
            ps.setInt(4, objObra.getValor_hora());
            ps.setDate(5, objObra.getFecha_inicio());
            ps.setDate(6, objObra.getFecha_fin());
            ps.setString(7,objObra.getDescripcion());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Obra en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Obra en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Obra> listadoObras = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM Obra;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Obra objObra = new Obra(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7),rs.getString(8));
                listadoObras.add(objObra);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Obras: " + e.getMessage());
        }
        return listadoObras;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Obra objObra = (Obra) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE obra SET id_tipo_obra = ?, direccion = ?, id_comuna = ?, valor_hora = ?, fecha_inicio = ?, fecha_fin = ?, descripcion=? WHERE id_obra = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objObra.getId_tipo_obra());
            ps.setString(2, objObra.getDireccion());
            ps.setInt(3, objObra.getId_comuna());
            ps.setInt(4, objObra.getValor_hora());
            ps.setDate(5, objObra.getFecha_inicio());
            ps.setDate(6, objObra.getFecha_fin());
            ps.setString(7,objObra.getDescripcion());
            ps.setInt(8, objObra.getId_obra());

            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la Obra en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Obra WHERE id_obra=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar el Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el Obra: " + e.getMessage());
        }
        return false;
    }

}
