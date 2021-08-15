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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AsignacionDeportistaAInstructor;
import model.AsignacionDeportistaAInstructorDB;
import model.DisciplinaDeportiva;

/**
 *
 * @author LARH96
 */
@Named(value = "beanAsignacionDeportistaAInstructor")
@SessionScoped
public class beanAsignacionDeportistaAInstructor implements Serializable {

    private int idInstructor;
    private beanProvincias obeanProvincias = new beanProvincias();
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva = new beanDisciplinaDeportiva();
    private List<AsignacionDeportistaAInstructor> listaAsignacionDeportistaAInstructor = new ArrayList<AsignacionDeportistaAInstructor>();
    private boolean desabilitar = true;
    private String mensajeExito;
    private String mensajeFallido;
    private boolean modoEditarActivado = false;
    private beanInstructor obeanInstructor = new beanInstructor();
    private int idBuscar;
    
    /**
     * Creates a new instance of beanAsignacionDeportistaAInstructor
     */
    public beanAsignacionDeportistaAInstructor() throws SNMPExceptions, SQLException {
        cargaTabla();
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public beanInstructor getObeanInstructor() {
        return obeanInstructor;
    }

    public void setObeanInstructor(beanInstructor obeanInstructor) {
        this.obeanInstructor = obeanInstructor;
    }

    public List<AsignacionDeportistaAInstructor> getListaAsignacionDeportistaAInstructor() {
        return listaAsignacionDeportistaAInstructor;
    }

    public void setListaAsignacionDeportistaAInstructor(List<AsignacionDeportistaAInstructor> listaAsignacionDeportistaAInstructor) {
        this.listaAsignacionDeportistaAInstructor = listaAsignacionDeportistaAInstructor;
    }

    public int getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(int idBuscar) {
        this.idBuscar = idBuscar;
    }   

    public boolean isModoEditarActivado() {
        return modoEditarActivado;
    }

    public void setModoEditarActivado(boolean modoEditarActivado) {
        this.modoEditarActivado = modoEditarActivado;
    }
   
    public String getMensajeExito() {
        return mensajeExito;
    }

    public void setMensajeExito(String mensajeExito) {
        this.mensajeExito = mensajeExito;
    }

    public String getMensajeFallido() {
        return mensajeFallido;
    }

    public void setMensajeFallido(String mensajeFallido) {
        this.mensajeFallido = mensajeFallido;
    }

    public boolean isDesabilitar() {
        return desabilitar;
    }

    public void setDesabilitar(boolean desabilitar) {
        this.desabilitar = desabilitar;
    }
   
    public beanProvincias getObeanProvincias() {
        return obeanProvincias;
    }

    public void setObeanProvincias(beanProvincias obeanProvincias) {
        this.obeanProvincias = obeanProvincias;
    }

    public beanDisciplinaDeportiva getObeanDisciplinaDeportiva() {
        return obeanDisciplinaDeportiva;
    }

    public void setObeanDisciplinaDeportiva(beanDisciplinaDeportiva obeanDisciplinaDeportiva) {
        this.obeanDisciplinaDeportiva = obeanDisciplinaDeportiva;
    }
    
    public void desabilitarAFalse() {
        this.desabilitar = false;
    }

    public void modoEditar() {
        modoEditarActivado = true;
        desabilitar = false;
    }

    public void desabilitarAtrue() {
        desabilitar = true;
    }
    
    public void limpiaCasillas() throws SNMPExceptions, SQLException {
        idBuscar = 0;
        modoEditarActivado = false;
        desabilitarAtrue();
        obeanDisciplinaDeportiva.setId(0);
        mensajeExito = "";
        mensajeFallido = "";
        obeanProvincias.setCod_provincia(0);
        obeanProvincias.setCod_canton(0);
        obeanProvincias.setCod_distrito(0);
        obeanProvincias.setCod_barrio(0);
        cargaTabla();
    }
    public void cargaTabla() throws SNMPExceptions, SQLException{
        AsignacionDeportistaAInstructorDB oAsignacionDeportistaAInstructorDB = new AsignacionDeportistaAInstructorDB();
        listaAsignacionDeportistaAInstructor = oAsignacionDeportistaAInstructorDB.moTodoInstructorAsignado();
    }
    
    public String devuelveNombreInstructor(AsignacionDeportistaAInstructor pAsignacionDeportistaAInstructor){
        return pAsignacionDeportistaAInstructor.getNombreInstructor() + " " +
                pAsignacionDeportistaAInstructor.getApellido1Instructor() + " " +
                pAsignacionDeportistaAInstructor.getApellido2Instructor();
    }
}
