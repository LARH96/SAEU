/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SNMPExceptions;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import model.TipoIdentificacion;
import model.TipoIdentificacionDB;

/**
 *
 * @author LARH96
 */
@Named(value = "beanTipoIdentificacion")
@SessionScoped
public class beanTipoIdentificacion implements Serializable {

    private int id;
    private String descripcion;
    private boolean log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;
    private LinkedList<SelectItem> listaTipoIdentificacion = new LinkedList();

    /**
     * Creates a new instance of beanTipoIdentificacion
     */
    public beanTipoIdentificacion() throws SNMPExceptions, SQLException {
        getListaTipoIdentificacion();
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

    public LinkedList<SelectItem> getListaTipoIdentificacion() throws SNMPExceptions, SQLException {

        LinkedList<TipoIdentificacion> lista = new LinkedList<TipoIdentificacion>();
        TipoIdentificacionDB oTipoIdentificacionDB = new TipoIdentificacionDB();
        int id = 0;
        String descripcion = "";

        lista = oTipoIdentificacionDB.moTodo();

        LinkedList resultList = new LinkedList();

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            TipoIdentificacion oTipoIdentificacion = (TipoIdentificacion) iter.next();
            id = oTipoIdentificacion.getId();
            descripcion = oTipoIdentificacion.getDescripcion();
            resultList.add(new SelectItem(id, descripcion));

        }
        return resultList;
    }
}
