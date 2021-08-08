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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import model.DeportistaDB;
import model.Direccion;
import model.DisciplinaDeportiva;
import model.Instructor;
import model.InstructorDB;
import model.Telefono;
import utilitario.Email;

/**
 *
 * @author LARH96
 */
@Named(value = "beanInstructor")
@SessionScoped
public class beanInstructor implements Serializable {

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
    private List<Telefono> listaTelefono = new ArrayList<Telefono>();
    private Direccion oDireccion = new Direccion();
    private String otrasSennas;

    //extra
    private int telefono1;
    private int telefono2;
    private int disciplinaDeportiva1;
    private int disciplinaDeportiva2;
    private int disciplinaDeportiva3;
    private String mensajeExito;
    private String mensajeFallido;

    /**
     * Creates a new instance of beanDeportista
     */
    public beanInstructor() {
    }

    //==========================================================================
    // Accessors
    //==========================================================================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisciplinaDeportiva1() {
        return disciplinaDeportiva1;
    }

    public void setDisciplinaDeportiva1(int disciplinaDeportiva1) {
        this.disciplinaDeportiva1 = disciplinaDeportiva1;
    }

    public int getDisciplinaDeportiva2() {
        return disciplinaDeportiva2;
    }

    public void setDisciplinaDeportiva2(int disciplinaDeportiva2) {
        this.disciplinaDeportiva2 = disciplinaDeportiva2;
    }

    public int getDisciplinaDeportiva3() {
        return disciplinaDeportiva3;
    }

    public void setDisciplinaDeportiva3(int disciplinaDeportiva3) {
        this.disciplinaDeportiva3 = disciplinaDeportiva3;
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

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public List<Telefono> getListaTelefono() {
        return listaTelefono;
    }

    public void setListaTelefono(List<Telefono> listaTelefono) {
        this.listaTelefono = listaTelefono;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }

    public Direccion getoDireccion() {
        return oDireccion;
    }

    public void setoDireccion(Direccion oDireccion) {
        this.oDireccion = oDireccion;
    }

    //==========================================================================
    // Validators
    //==========================================================================
    public void validaProvincia(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0.0")) {
            String mensaje = "Provincia no especificada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            oDireccion.setProvincia(valorInt);
        }
    }

    public void validaCanton(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0.0")) {
            String mensaje = "Cantón no especificado";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            oDireccion.setCanton(valorInt);
        }
    }

    public void validaDistrito(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0.0")) {
            String mensaje = "Distrito no especificado";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            oDireccion.setDistrito(valorInt);
        }
    }

    public void validaBarrio(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0.0")) {
            String mensaje = "Barrio no especificado";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            oDireccion.setBarrio(valorInt);
        }
    }

    public void validaOtrasSennas(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        if (valor.isEmpty()) {
            String mensaje = "Debes indicar Otras señas";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            oDireccion.setOtrasSennas(valor);
        }
    }

    public void validaDisciplinaDeportiva1(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0")) {
            String mensaje = "Disciplina deportiva no especificada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else if (valorInt == disciplinaDeportiva2 || valorInt == disciplinaDeportiva3) {
            String mensaje = "Las disciplinas escogidas deben ser diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva1(valorInt);
        }
    }

    public void validaDisciplinaDeportiva2(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0")) {
            String mensaje = "Disciplina deportiva no especificada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else if (valorInt == disciplinaDeportiva1 || valorInt == disciplinaDeportiva3) {
            String mensaje = "Las disciplinas escogidas deben ser diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva1(valorInt);
        }
    }

    public void validaDisciplinaDeportiva3(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0")) {
            String mensaje = "Disciplina deportiva no especificada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else if (valorInt == disciplinaDeportiva1 || valorInt == disciplinaDeportiva2) {
            String mensaje = "Las disciplinas escogidas deben ser diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva1(valorInt);
        }
    }

    //==========================================================================
    // Methods
    //==========================================================================
    public void limpiaCasillas() {
        this.id = 0;
        getTipoIdentificacion();
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correoElectronico = "";
        this.log_estado = 1;
        this.listaTelefono.clear();
        this.telefono1 = 0;
        this.telefono2 = 0;
        this.otrasSennas = "";
    }

    public void asignaDireccion() {
        setoDireccion(new Direccion(this.id, oDireccion.getProvincia(),
                oDireccion.getCanton(), oDireccion.getDistrito(), oDireccion.getBarrio(), this.otrasSennas));
    }

    public void asignaTipoIdentificacion(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        if (valor.isEmpty()) {
            String mensaje = "Tipo identificación no seleccionada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            this.tipoIdentificacion = Integer.parseInt(valor);
        }
    }

    public void creaInstructor() throws SNMPExceptions, SQLException {
        this.mensajeExito = "";
        this.mensajeFallido = "";

        this.log_estado = 1;
        java.util.Date date = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.codUsuario_Registra = this.id;
        this.fechaRegistra = date2;
        this.codUsuario_Edita = this.id;
        this.fechaEdita = date2;

        Instructor oInstructor = new Instructor(
                this.id, this.tipoIdentificacion, this.nombre, this.apellido1,
                this.apellido2, this.correoElectronico,
                this.log_estado, this.codUsuario_Registra, date2,
                this.codUsuario_Edita, date2, this.oDireccion
        );
        oInstructor.agregaTelefono(new Telefono(this.id, this.telefono1, 1, this.id, date2, 0, date2));
        oInstructor.agregaTelefono(new Telefono(this.id, this.telefono2, 1, this.id, date2, 0, date2));
        oInstructor.agregaDisciplinaDeportiva(new DisciplinaDeportiva(this.disciplinaDeportiva1));
        oInstructor.agregaDisciplinaDeportiva(new DisciplinaDeportiva(this.disciplinaDeportiva2));
        oInstructor.agregaDisciplinaDeportiva(new DisciplinaDeportiva(this.disciplinaDeportiva3));

        InstructorDB oInstructorDB = new InstructorDB();

        if (oInstructorDB.consultarInstructor(this.id) == true) {
            mensajeFallido = "Instructor ya registrado!";
        } else {
            oInstructorDB.insertarInstructor(oInstructor);
            mensajeExito = "Instructor correctamente registrado!";
            limpiaCasillas();
            //throw new ValidatorException(new FacesMessage(mensaje));
        }
    }
}
