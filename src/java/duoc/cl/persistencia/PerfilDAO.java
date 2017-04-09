/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class PerfilDAO implements ICRUD{

    @Override
    public boolean addElemento(Object objetoInsert) {
        Perfil objPerfil = (Perfil) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Perfil(descripcion)VALUES(?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objPerfil.getDescripcion());            
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Perfil en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Perfil en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Perfil> listadoPerfil = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT id_perfil,descripcion FROM Perfil;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Perfil objPerfil = new Perfil(rs.getInt(1), rs.getString(2));
                listadoPerfil.add(objPerfil);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Perfil: " + e.getMessage());
        }
        return listadoPerfil; 
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Perfil objPerfil = (Perfil) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE Perfil SET descripcion=? WHERE id_Perfil = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objPerfil.getDescripcion());
            ps.setInt(2, objPerfil.getId_perfil());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar Perfil: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la Perfil en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Perfil WHERE id_Perfil=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar la Perfil: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la Perfil: " + e.getMessage());
        }
        return false;
    }
    
}
