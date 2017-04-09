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
public class Asistencia {

    private int id_asistencia;
    private int id_obra;
    private int id_usuario;
    private Boolean asiste;
    private Date fecha;

    public Asistencia() {
    }

    public Asistencia(int id_asistencia, int id_obra, int id_usuario, Boolean asiste, Date fecha) {
        this.id_asistencia = id_asistencia;
        this.id_obra = id_obra;
        this.id_usuario = id_usuario;
        this.asiste = asiste;
        this.fecha = fecha;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
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

    public Boolean getAsiste() {
        return asiste;
    }

    public void setAsiste(Boolean asiste) {
        this.asiste = asiste;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id_asistencia=" + id_asistencia + ", id_obra=" + id_obra + ", id_usuario=" + id_usuario + ", asiste=" + asiste + ", fecha=" + fecha + '}';
    }

}
