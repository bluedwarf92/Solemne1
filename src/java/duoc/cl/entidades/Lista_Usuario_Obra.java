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
public class Lista_Usuario_Obra {

    private int id_lista_usuario_obra;
    private int id_obra;
    private int id_usuario;

    public Lista_Usuario_Obra() {
    }

    public Lista_Usuario_Obra(int id_lista_usuario_obra, int id_obra, int id_usuario) {
        this.id_lista_usuario_obra = id_lista_usuario_obra;
        this.id_obra = id_obra;
        this.id_usuario = id_usuario;
    }

    public int getId_lista_usuario_obra() {
        return id_lista_usuario_obra;
    }

    public void setId_lista_usuario_obra(int id_lista_usuario_obra) {
        this.id_lista_usuario_obra = id_lista_usuario_obra;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Lista_Usuario_Obra{" + "id_lista_usuario_obra=" + id_lista_usuario_obra + ", id_obra=" + id_obra + ", id_usuario=" + id_usuario + '}';
    }

}
