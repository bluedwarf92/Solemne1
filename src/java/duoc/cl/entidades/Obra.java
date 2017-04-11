/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.entidades;

import java.sql.Date;

/**
 *
 * @author Cami
 */
public class Obra {

    private int id_obra;
    private int id_tipo_obra;
    private String direccion;
    private int id_comuna;
    private int valor_hora;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String descripcion;

    public Obra() {
    }

    public Obra(int id_obra, int id_tipo_obra, String direccion, int id_comuna, int valor_hora, Date fecha_inicio, Date fecha_fin, String descripcion) {
        this.id_obra = id_obra;
        this.id_tipo_obra = id_tipo_obra;
        this.direccion = direccion;
        this.id_comuna = id_comuna;
        this.valor_hora = valor_hora;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }
    

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public int getId_tipo_obra() {
        return id_tipo_obra;
    }

    public void setId_tipo_obra(int id_tipo_obra) {
        this.id_tipo_obra = id_tipo_obra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Obra{" + "id_obra=" + id_obra + ", id_tipo_obra=" + id_tipo_obra + ", direccion=" + direccion + ", id_comuna=" + id_comuna + ", valor_hora=" + valor_hora + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", descripcion=" + descripcion + '}';
    }

   

}
