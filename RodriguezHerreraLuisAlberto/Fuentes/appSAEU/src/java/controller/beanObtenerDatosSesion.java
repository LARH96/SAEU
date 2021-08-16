/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author LARH96
 */
@Named(value = "beanObtenerDatosSesion")
@SessionScoped
public class beanObtenerDatosSesion implements Serializable {

    Usuario UsuarioLogin;
    String datos;
    int tipoPerfil;

    public Usuario getUsuarioLogin() {
        return UsuarioLogin;
    }

    public int getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(int tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public void setUsuarioLogin(Usuario UsuarioLogin) {
        this.UsuarioLogin = UsuarioLogin;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    /**
     * Creates a new instance of ObtenerDatosSesion
     */
    public beanObtenerDatosSesion() {
    }

    public void consultarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        final Map<String, Object> session = context.getSessionMap();
        final Usuario user = (Usuario)session.get("Usuario");

        if (user != null) {
            try {
                String userId = user.getId();
                this.setDatos(userId);

                int tipPerfil = user.getTipoPerfil();
                this.setTipoPerfil(tipPerfil);

            } catch (ClassCastException e) {

            }
        } else {
            context.invalidateSession();
        }
    }
}
