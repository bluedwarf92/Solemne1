/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.entidades;

/**
 *
 * @author Cami
 */
public class Usuario {

    private int id_usuario;
    private String username;
    private String password;
    private int id_perfil;
    private int id_empleado;

    public Usuario() {
    }

    public Usuario(int id_usuario, String username, String password, int id_perfil, int id_empleado) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.id_perfil = id_perfil;
        this.id_empleado = id_empleado;
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + ", id_perfil=" + id_perfil + ", id_empleado=" + id_empleado + '}';
    }
}
