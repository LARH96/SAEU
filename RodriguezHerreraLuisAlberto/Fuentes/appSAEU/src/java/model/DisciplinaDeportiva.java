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
public class DisciplinaDeportiva {
    
    private int id;
    private String descripcion;
    private boolean log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;

    public DisciplinaDeportiva() {
    }

    public DisciplinaDeportiva(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public DisciplinaDeportiva(int id, String descripcion, boolean log_estado, int codUsuario_Registra, Date fechaRegistra, int codUsuario_Edita, Date fechaEdita) {
        this.id = id;
        this.descripcion = descripcion;
        this.log_estado = log_estado;
        this.codUsuario_Registra = codUsuario_Registra;
        this.fechaRegistra = fechaRegistra;
        this.codUsuario_Edita = codUsuario_Edita;
        this.fechaEdita = fechaEdita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isLog_estado() {
        return log_estado;
    }

    public void setLog_estado(boolean log_estado) {
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
}
