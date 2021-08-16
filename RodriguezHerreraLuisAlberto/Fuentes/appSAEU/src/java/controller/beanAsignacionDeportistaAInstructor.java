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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.AsignacionDeportistaAInstructor;
import model.AsignacionDeportistaAInstructorDB;
/**
 *
 * @author LARH96
 */
@Named(value = "beanAsignacionDeportistaAInstructor")
@SessionScoped
public class beanAsignacionDeportistaAInstructor implements Serializable {

    private int idInstructor;
    private int idDeportista;
    private int log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;

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

    public int getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(int idDeportista) {
        this.idDeportista = idDeportista;
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

    public void cargaTabla() throws SNMPExceptions, SQLException {
        AsignacionDeportistaAInstructorDB oAsignacionDeportistaAInstructorDB = new AsignacionDeportistaAInstructorDB();
        listaAsignacionDeportistaAInstructor = oAsignacionDeportistaAInstructorDB.moTodoInstructorAsignado(
                obeanDisciplinaDeportiva.getId(), (int)obeanProvincias.cod_provincia, (int)obeanProvincias.cod_canton,
                (int)obeanProvincias.cod_distrito, (int)obeanProvincias.cod_barrio, this.idBuscar);
    }

    public String devuelveNombreInstructor(AsignacionDeportistaAInstructor pAsignacionDeportistaAInstructor) {
        return pAsignacionDeportistaAInstructor.getNombreInstructor() + " "
                + pAsignacionDeportistaAInstructor.getApellido1Instructor() + " "
                + pAsignacionDeportistaAInstructor.getApellido2Instructor();
    }

    public void guardarInstructorDelDeportista(int pIdDeportista, int pIdInstructor) throws SNMPExceptions,
            SQLException, NamingException, ClassNotFoundException {
        this.mensajeExito = "";
        this.mensajeFallido = "";
        AsignacionDeportistaAInstructorDB oAsignacionDeportistaAInstructorDB = new AsignacionDeportistaAInstructorDB();

        if (modoEditarActivado) {
            if (oAsignacionDeportistaAInstructorDB.consultarExistencia(pIdDeportista)) {
                oAsignacionDeportistaAInstructorDB.editarInstructor(pIdDeportista, pIdInstructor);
                mensajeExito = "Registro editado correctamente";
            } else {
                this.log_estado = 1;
                java.util.Date date = new java.util.Date();
                java.sql.Date date2 = new java.sql.Date(date.getTime());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                this.codUsuario_Registra = 0;
                this.fechaRegistra = date2;
                this.codUsuario_Edita = 0;
                this.fechaEdita = date2;
                AsignacionDeportistaAInstructor oAsignacionDeportistaAInstructor = new AsignacionDeportistaAInstructor(
                        pIdDeportista, pIdInstructor, log_estado, codUsuario_Registra, fechaRegistra, codUsuario_Edita, fechaEdita
                );

                oAsignacionDeportistaAInstructorDB.insertar(oAsignacionDeportistaAInstructor);
                limpiaCasillas();
                mensajeExito = "Registro almacenado correctamente";
                modoEditarActivado = false;
            }
        }
    }
}
