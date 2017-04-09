/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.persistencia;

import duoc.cl.dto.UsuarioPerfilDTO;
import duoc.cl.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cami
 */
public class UsuarioDAO implements ICRUD {

    @Override
    public boolean addElemento(Object objetoInsert) {
        Usuario objUsuario = (Usuario) objetoInsert;
        try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO USUARIO(username,password,id_perfil,id_empleado) VALUES (?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getUsername());
            ps.setString(2, objUsuario.getPassword());
            ps.setInt(3, objUsuario.getId_perfil());
            ps.setInt(3, objUsuario.getId_empleado());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("problemas al insertar usuario en la bd: " + e.getMessage());
                return false;
            }
        } catch (Exception e) {
            System.out.println("problemas para insertar usuario en la BD: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List readElementos() {
        List<Usuario> listadoUsuario = new LinkedList<>();
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                listadoUsuario.add(objUsuario);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura: " + e.getMessage());
        }
        return listadoUsuario;
    }

    @Override
    public boolean updateElemento(Object objetoUpdate) {
        Usuario objUsuario = (Usuario) objetoUpdate;
        try {
            Connection con = Conexion.getConexion();
            String query = "UPDATE USUARIO SET USERNAME=?,PASSWORD=?,ID_PERFIL=? WHERE ID_USUARIO=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, objUsuario.getUsername());
            ps.setString(2, objUsuario.getPassword());
            ps.setInt(3, objUsuario.getId_perfil());
            ps.setInt(4, objUsuario.getId_usuario());
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Problemas al actualizar usuario" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("No se pudo actualizar usuario en la base de datos");
        }
        return false;
    }

    @Override
    public boolean deleteElemento(int codigo) {
        try {
            Connection con = Conexion.getConexion();
            String query = "DELETE FROM USUARIO WHERE ID_USUARIO=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            try {
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                System.out.println("Error al eliminar el usuario: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el usuario: " + e.getMessage());
        }
        return false;
    }

    public Usuario validarUsuario(String login) {
        Usuario objUsuario = null;
        String query = "SELECT id_usuario,username,password,id_perfil,id_empleado FROM USUARIO WHERE USERNAME=?;";
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("problemas al validar " + e.getMessage());
        }
        return objUsuario;
    }

    public Usuario buscaUsuarioXcodigo(int id_usuario) {
        Usuario infoUsuario = null;
        try {
            Connection con = Conexion.getConexion();
            String query = "SELECT * FROM USUARIO WHERE ID_USUARIO=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                infoUsuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("no se pudo ingresar al sistema");
        }
        return infoUsuario;
    }
    
    public List readUsuariosPerfilDTO(){
        List<UsuarioPerfilDTO>listadoUsuario= new LinkedList<>();
        try{
            Connection con = Conexion.getConexion();
            String query="SELECT USU.ID_USUARIO,USU.USERNAME,USU.PASSWORD,USU.ID_PERFIL,PER.DESCRIPCION FROM USUARIO USU,"
                    + " PERFIL PER WHERE PER.ID_PERFIL=USU.ID_PERFIL ;";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                UsuarioPerfilDTO objUsuarioPerfilDTO= new UsuarioPerfilDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                listadoUsuario.add(objUsuarioPerfilDTO);
            }            
        }catch(Exception e){
            System.out.println("Problemas en la lectura "+e.getMessage());
        }
        return listadoUsuario;
    }
}
