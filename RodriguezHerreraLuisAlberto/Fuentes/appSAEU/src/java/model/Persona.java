/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author LARH96
 */
public class Persona {

    private int id;
    private int tipoIdentificacion;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;
    private int log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;
    private Direccion oDireccion;

    public Persona() {
    }

    public Persona(int id, int tipoIdentificacion, String nombre, String apellido1, String apellido2, String correoElectronico, int log_estado, int codUsuario_Registra, Date fechaRegistra, int codUsuario_Edita, Date fechaEdita, Direccion oDireccion) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.log_estado = log_estado;
        this.codUsuario_Registra = codUsuario_Registra;
        this.fechaRegistra = fechaRegistra;
        this.codUsuario_Edita = codUsuario_Edita;
        this.fechaEdita = fechaEdita;
        this.oDireccion = oDireccion;
    }

    public Persona(int id, int tipoIdentificacion, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getLog_estado() {
        return log_estado;
    }

    public void setLog_estado(int log_estado) {
        this.log_estado = log_estado;
    }

    public int getCodUsuario_Registra() {
        return codUsuario_Registra;
    }

    public void setCodUsuario_Registra(int codUsuario_Registra) {
        this.codUsuario_Registra = codUsuario_Registra;
    }

    public Date getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(Date fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public int getCodUsuario_Edita() {
        return codUsuario_Edita;
    }

    public void setCodUsuario_Edita(int codUsuario_Edita) {
        this.codUsuario_Edita = codUsuario_Edita;
    }

    public Date getFechaEdita() {
        return fechaEdita;
    }

    public void setFechaEdita(Date fechaEdita) {
        this.fechaEdita = fechaEdita;
    }

    public Direccion getoDireccion() {
        return oDireccion;
    }

    public void setoDireccion(Direccion oDireccion) {
        this.oDireccion = oDireccion;
    }
}
