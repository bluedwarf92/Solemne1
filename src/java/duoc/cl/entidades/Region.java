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
public class Region {

    private int id_region;
    private String nombre_region;

    public Region() {
    }

    public Region(int id_region, String nombre_region) {
        this.id_region = id_region;
        this.nombre_region = nombre_region;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    @Override
    public String toString() {
        return "Region{" + "id_region=" + id_region + ", nombre_region=" + nombre_region + '}';
    }
}
