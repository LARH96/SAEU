/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import model.DisciplinaDeportiva;
import model.DisciplinaDeportivaDB;
import model.Instructor;

/**
 *
 * @author LARH96
 */
@Named(value = "beanDisciplinaDeportiva")
@SessionScoped
public class beanDisciplinaDeportiva implements Serializable {

    private int id;
    private String descripcion;
    private boolean log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;
    private LinkedList<SelectItem> listaDisciplinaDeportiva = new LinkedList();
    
    /**
     * Creates a new instance of beanDisciplinaDeportiva
     */
    public beanDisciplinaDeportiva() {
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

    public LinkedList<SelectItem> getListaDisciplinaDeportiva() throws SNMPExceptions, SQLException {
        LinkedList<DisciplinaDeportiva> lista = new LinkedList<DisciplinaDeportiva>();
        DisciplinaDeportivaDB oDisciplinaDeportivaDB = new DisciplinaDeportivaDB();
        int id = 0;
        String descripcion = "";

        lista = oDisciplinaDeportivaDB.moTodo();

        LinkedList resultList = new LinkedList();

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            DisciplinaDeportiva oTipoIdentificacion = (DisciplinaDeportiva) iter.next();
            id = oTipoIdentificacion.getId();
            descripcion = oTipoIdentificacion.getDescripcion();
            resultList.add(new SelectItem(id, descripcion));

        }
        return resultList;
    }
}
