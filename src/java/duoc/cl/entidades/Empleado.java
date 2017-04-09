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
public class Empleado {

    private int id_empleado;
    private String Nombre;
    private String Apellidos;
    private int telefono;
    private String direccion;
    private String RUT;

    public Empleado() {
    }

    public Empleado(int id_empleado, String Nombre, String Apellidos, int telefono, String direccion, String RUT) {
        this.id_empleado = id_empleado;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.RUT = RUT;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", RUT=" + RUT + '}';
    }
}
