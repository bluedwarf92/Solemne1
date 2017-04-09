/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class CiudadDAO implements ICRUD{

    @Override
    public boolean addElemento(Object objetoInsert) {
        Ciudad objCiudad = (Ciudad) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Ciudad(Nombre) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objCiudad.getNombre_ciudad());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Ciudad en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Ciudad en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Ciudad> listadoCiudades = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM CIUDAD;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciudad objCiudad = new Ciudad(rs.getInt(1), rs.getString(2));
                listadoCiudades.add(objCiudad);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Ciudades: " + e.getMessage());
        }
        return listadoCiudades;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Ciudad objCiudad = (Ciudad) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE Ciudad SET Nombre=? WHERE ID_CIUDAD=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objCiudad.getNombre_ciudad());
            ps.setInt(2, objCiudad.getId_ciudad());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar ciudad: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la ciudad en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
         try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM CIUDAD WHERE ID_CIUDAD=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar el ciudad: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el ciudad: " + e.getMessage());
        }
        return false;
    }
    
}
