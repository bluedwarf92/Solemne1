/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Comuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class ComunaDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Comuna objComuna = (Comuna) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Comuna(Nombre) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objComuna.getNombre_comuna());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Comuna en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Comuna en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Comuna> listadoComunas = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM COMUNA;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comuna objComuna = new Comuna(rs.getInt(1), rs.getString(2));
                listadoComunas.add(objComuna);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de comunas: " + e.getMessage());
        }
        return listadoComunas;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Comuna objComuna = (Comuna) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE COMUNA SET Nombre=? WHERE ID_COMUNA=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objComuna.getNombre_comuna());
            ps.setInt(2, objComuna.getId_comuna());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar comuna: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la comuna en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM COMUNA WHERE ID_COMUNA=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar la comuna: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la comuna: " + e.getMessage());
        }
        return false;
    }
    
}
