/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import model.Usuario;
import model.usuarioDB;

/**
 *
 * @author LARH96
 */
@Named(value = "beanLogin")
@SessionScoped
public class beanLogin implements Serializable {

    String UsuarioIngresado;
    String Password;
    Usuario Usuario1;

    private String mensajeExito;
    private String mensajeFallido;

    /**
     * Creates a new instance of LoginControlador
     */
    public beanLogin() {
    }

    public Usuario getUsuario1() {
        return Usuario1;
    }

    public void setUsuario1(Usuario Usuario1) {
        this.Usuario1 = Usuario1;
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

    public String getUsuarioIngresado() {
        return UsuarioIngresado;
    }

    public void setUsuarioIngresado(String Usuario) {
        this.UsuarioIngresado = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void validaUsuario(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        mensajeFallido = "";
        String valor = value.toString();
        if (valor.equals("")) {
            mensajeFallido = "Debes digitar un Usuario y una Contraseña";
            throw new ValidatorException(new FacesMessage(mensajeFallido));
        } else {
            this.UsuarioIngresado = valor;
        }
    }

    public void validaContrasenna(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        mensajeFallido = "";
        String valor = value.toString();
        if (valor.equals("")) {
            mensajeFallido = "Debes digitar un Usuario y una contraseña";
            throw new ValidatorException(new FacesMessage(mensajeFallido));
        } else {
            this.Password = valor;
        }
    }

    public String autenticarDeportista() {
        mensajeFallido = "";
        String pagina = "";

        try {
            Usuario1 = usuarioDB.Autenticar(this.getUsuarioIngresado(), this.getPassword());

            if (Usuario1 != null && Usuario1.getTipoPerfil() == 2) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", Usuario1);
                //FacesContext.getCurrentInstance().getExternalContext().redirect("trainerPrincipal.xhtml");
                pagina = "sportPlayerPrincipal.xhtml";
            } else {
                mensajeFallido = "Usuario o contraseña invalida";
            }
        } catch (Exception e) {

        }
        return pagina;
        //si autentica redirigue a sportPlayerPrincipal.xhtml y sino devuelve mensaje de usuario o contraseña invalida
    }

    public String autenticarInstructor() {
        mensajeFallido = "";
        String pagina = "";

        try {
            Usuario1 = usuarioDB.Autenticar(this.getUsuarioIngresado(), this.getPassword());

            if (Usuario1 != null && Usuario1.getTipoPerfil() == 3) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", Usuario1);
                //FacesContext.getCurrentInstance().getExternalContext().redirect("trainerPrincipal.xhtml");
                pagina = "trainerPrincipal.xhtml";
            } else {
                mensajeFallido = "Usuario o contraseña invalida";
            }
        } catch (Exception e) {

        }
        return pagina;
        //si autentica redirigue a sportPlayerPrincipal.xhtml y sino devuelve mensaje de usuario o contraseña invalida
    }

    public String autenticarAdmin() {
        mensajeFallido = "";
        String pagina = "";

        try {
            Usuario1 = usuarioDB.Autenticar(this.getUsuarioIngresado(), this.getPassword());

            if (Usuario1 != null && Usuario1.getTipoPerfil() == 1) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", Usuario1);
                //FacesContext.getCurrentInstance().getExternalContext().redirect("trainerPrincipal.xhtml");
                pagina = "adminPrincipal.xhtml";
            } else {
                mensajeFallido = "Usuario o contraseña invalida";
            }
        } catch (Exception e) {

        }
        return pagina;
        //si autentica redirigue a sportPlayerPrincipal.xhtml y sino devuelve mensaje de usuario o contraseña invalida
    }

    public void validaAccesoPaginaPorPerfil(int idPerfilPagina) throws IOException {
        UsuarioIngresado = "";
        Password = "";
        beanObtenerDatosSesion obeanObtenerDatosSesion = new beanObtenerDatosSesion();
        obeanObtenerDatosSesion.consultarSesion();

        if (obeanObtenerDatosSesion.getTipoPerfil() != idPerfilPagina) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("securityUsuarioNoAutorizado.xhtml");
        }
    }

}
