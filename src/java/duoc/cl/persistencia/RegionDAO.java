/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Region;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class RegionDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Region objRegion = (Region) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Region(Nombre) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objRegion.getNombre_region());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Region en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Region en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Region> listadoRegiones = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM REGION;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Region objRegion = new Region(rs.getInt(1), rs.getString(2));
                listadoRegiones.add(objRegion);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de region: " + e.getMessage());
        }
        return listadoRegiones;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Region objRegion = (Region) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE Region SET Nombre=? WHERE id_region=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objRegion.getNombre_region());
            ps.setInt(2, objRegion.getId_region());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar region: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la region en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM REGION WHERE ID_REGION=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar la region: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la region: " + e.getMessage());
        }
        return false;
    }

}
