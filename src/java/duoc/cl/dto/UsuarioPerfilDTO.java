/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dto;

import java.io.Serializable;

/**
 *
 * @author Cami
 */
public class UsuarioPerfilDTO implements Serializable {

    private int id_usuario;
    private String username;
    private String password;
    private int id_perfil;
    private String descripcion;

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(int id_usuario, String username, String password, int id_perfil, String descripcion) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.id_perfil = id_perfil;
        this.descripcion = descripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UsuarioPerfilDTO{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + ", id_perfil=" + id_perfil + ", descripcion=" + descripcion + '}';
    }
}
