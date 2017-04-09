/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.entidades.Lista_Usuario_Obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class Lista_Usuario_ObraDAO implements ICRUD{

    @Override
    public boolean addElemento(Object objetoInsert) {
        Lista_Usuario_Obra objLista_Usuario_Obra = (Lista_Usuario_Obra) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO Lista_Usuario_Obra(id_usuario,id_obra,)VALUES(?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objLista_Usuario_Obra.getId_usuario());
            ps.setInt(2, objLista_Usuario_Obra.getId_obra());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar Lista_Usuario_Obra en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar Lista_Usuario_Obra en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Lista_Usuario_Obra> listadoLista_Usuario_Obra = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM Lista_Usuario_Obra;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lista_Usuario_Obra objLista_Usuario_Obra = new Lista_Usuario_Obra(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                listadoLista_Usuario_Obra.add(objLista_Usuario_Obra);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura de Lista_Usuario_Obras: " + e.getMessage());
        }
        return listadoLista_Usuario_Obra; 
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Lista_Usuario_Obra objLista_Usuario_Obra = (Lista_Usuario_Obra) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE Lista_Usuario_Obra SET id_obra = ?,id_usuario = ? WHERE id_Lista_Usuario_Obra = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, objLista_Usuario_Obra.getId_obra());
            ps.setInt(2, objLista_Usuario_Obra.getId_usuario());
            ps.setInt(3, objLista_Usuario_Obra.getId_lista_usuario_obra());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar Lista_Usuario_Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la Lista_Usuario_Obra en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM Lista_Usuario_Obra WHERE id_Lista_Usuario_Obra=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar la Lista_Usuario_Obra: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la Lista_Usuario_Obra: " + e.getMessage());
        }
        return false;
    }
    
}
