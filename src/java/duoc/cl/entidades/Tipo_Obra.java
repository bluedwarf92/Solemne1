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
public class Tipo_Obra {

    private int id_tipo_obra;
    private String descripcion;

    public Tipo_Obra() {
    }

    public Tipo_Obra(int id_tipo_obra, String descripcion) {
        this.id_tipo_obra = id_tipo_obra;
        this.descripcion = descripcion;
    }

    public int getId_tipo_obra() {
        return id_tipo_obra;
    }

    public void setId_tipo_obra(int id_tipo_obra) {
        this.id_tipo_obra = id_tipo_obra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tipo_Obra{" + "id_tipo_obra=" + id_tipo_obra + ", descripcion=" + descripcion + '}';
    }

}
