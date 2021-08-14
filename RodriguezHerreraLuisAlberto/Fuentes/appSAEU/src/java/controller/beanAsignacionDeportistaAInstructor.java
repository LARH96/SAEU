/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author LARH96
 */
@Named(value = "beanAsignacionDeportistaAInstructor")
@SessionScoped
public class beanAsignacionDeportistaAInstructor implements Serializable {

    private beanProvincias obeanProvincias = new beanProvincias();
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva = new beanDisciplinaDeportiva();
    private boolean desabilitar = false;
    private String mensajeExito;
    private String mensajeFallido;
    private boolean modoEditarActivado = false;
    
    /**
     * Creates a new instance of beanAsignacionDeportistaAInstructor
     */
    public beanAsignacionDeportistaAInstructor() {
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
        desabilitar = false;
    }

    public void modoEditar() {
        modoEditarActivado = true;
        desabilitar = false;
    }

    public void desabilitarAtrue() {
        desabilitar = true;
    }
    
    public void limpiaCasillas() {
        modoEditarActivado = false;
        desabilitarAFalse();
        obeanDisciplinaDeportiva.setId(0);
        mensajeExito = "";
        mensajeFallido = "";
        obeanProvincias.setCod_provincia(0);
        obeanProvincias.setCod_canton(0);
        obeanProvincias.setCod_distrito(0);
        obeanProvincias.setCod_barrio(0);
    }
}
