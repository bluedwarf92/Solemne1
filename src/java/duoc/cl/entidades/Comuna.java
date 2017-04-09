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
public class Comuna {

    private int id_comuna;
    private String nombre_comuna;

    public Comuna() {
    }

    public Comuna(int id_comuna, String nombre_comuna) {
        this.id_comuna = id_comuna;
        this.nombre_comuna = nombre_comuna;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public String getNombre_comuna() {
        return nombre_comuna;
    }

    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }

    @Override
    public String toString() {
        return "Comuna{" + "id_comuna=" + id_comuna + ", nombre_comuna=" + nombre_comuna + '}';
    }
}
