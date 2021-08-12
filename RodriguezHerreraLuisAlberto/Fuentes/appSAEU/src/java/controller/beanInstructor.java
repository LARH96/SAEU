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
import javax.naming.NamingException;
import model.Direccion;
import model.DisciplinaDeportiva;
import model.Instructor;
import model.InstructorDB;
import model.Telefono;

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
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva1 = new beanDisciplinaDeportiva();
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva2 = new beanDisciplinaDeportiva();
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva3 = new beanDisciplinaDeportiva();
    private beanProvincias obeanProvincias = new beanProvincias();
    private int telefono1;
    private int telefono2;
    private int disciplinaDeportiva1;
    private int disciplinaDeportiva2;
    private int disciplinaDeportiva3;
    private String mensajeExito;
    private String mensajeFallido;
    private int idBuscar;
    private boolean desabilitar;
    private boolean desabilitarId;
    private boolean modoEditarActivado = false;
    private Instructor oInstructorSinEditar = null;

    /**
     * Creates a new instance of beanDeportista
     */
    public beanInstructor() {
    }

    public boolean isModoEditarActivado() {
        return modoEditarActivado;
    }

    public void setModoEditarActivado(boolean modoEditarActivado) {
        this.modoEditarActivado = modoEditarActivado;
    }

    public boolean isDesabilitarId() {
        return desabilitarId;
    }

    public void setDesabilitarId(boolean desabilitarId) {
        this.desabilitarId = desabilitarId;
    }

    public beanProvincias getObeanProvincias() {
        return obeanProvincias;
    }

    public void setObeanProvincias(beanProvincias obeanProvincias) {
        this.obeanProvincias = obeanProvincias;
    }

    public boolean getDesabilitar() {
        return desabilitar;
    }

    public void setDesabilitar(boolean desabilitar) {
        this.desabilitar = desabilitar;
    }

    public int getIdBuscar() {
        return idBuscar;
    }

    public beanDisciplinaDeportiva getObeanDisciplinaDeportiva1() {
        return obeanDisciplinaDeportiva1;
    }

    public void setObeanDisciplinaDeportiva1(beanDisciplinaDeportiva obeanDisciplinaDeportiva1) {
        this.obeanDisciplinaDeportiva1 = obeanDisciplinaDeportiva1;
    }

    public beanDisciplinaDeportiva getObeanDisciplinaDeportiva2() {
        return obeanDisciplinaDeportiva2;
    }

    public void setObeanDisciplinaDeportiva2(beanDisciplinaDeportiva obeanDisciplinaDeportiva2) {
        this.obeanDisciplinaDeportiva2 = obeanDisciplinaDeportiva2;
    }

    public beanDisciplinaDeportiva getObeanDisciplinaDeportiva3() {
        return obeanDisciplinaDeportiva3;
    }

    //==========================================================================
    // Accessors
    //==========================================================================
    public void setObeanDisciplinaDeportiva3(beanDisciplinaDeportiva obeanDisciplinaDeportiva3) {
        this.obeanDisciplinaDeportiva3 = obeanDisciplinaDeportiva3;
    }

    public void setIdBuscar(int idBuscar) {
        this.idBuscar = idBuscar;
    }

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
            String mensaje = "Disciplina deportiva 1 debe ser especificada";
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
            setDisciplinaDeportiva2(valorInt);
        } else if (valorInt == disciplinaDeportiva1 || valorInt == disciplinaDeportiva3) {
            String mensaje = "Las disciplinas escogidas deben ser diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva2(valorInt);
        }
    }

    public void validaDisciplinaDeportiva3(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0")) {
            setDisciplinaDeportiva3(valorInt);
        } else if (valorInt == disciplinaDeportiva1 || valorInt == disciplinaDeportiva2) {
            String mensaje = "Las disciplinas escogidas deben ser diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva3(valorInt);
        }
    }

    //==========================================================================
    // Methods
    //==========================================================================
    public void limpiaCasillas() {
        modoEditarActivado = false;
        this.idBuscar = 0;
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
        desabilitarAFalse();
        obeanDisciplinaDeportiva1.setId(0);
        obeanDisciplinaDeportiva2.setId(0);
        obeanDisciplinaDeportiva3.setId(0);
        mensajeExito = "";
        mensajeFallido = "";
        obeanProvincias.setCod_provincia(0);
        obeanProvincias.setCod_canton(0);
        obeanProvincias.setCod_distrito(0);
        obeanProvincias.setCod_barrio(0);
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

    public void creaInstructor() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        this.mensajeExito = "";
        this.mensajeFallido = "";
        InstructorDB oInstructorDB = new InstructorDB();

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

        if (modoEditarActivado) {
            oInstructorDB.editarInstructor(oInstructor, oInstructorSinEditar);
            mensajeExito = "Instructor editado correctamente!";
        } else {
            if (oInstructorDB.consultarInstructor(this.id) == true) {
                mensajeFallido = "Instructor ya registrado!";
            } else {
                oInstructorDB.insertarInstructor(oInstructor);
                limpiaCasillas();
                mensajeExito = "Instructor correctamente registrado!";
            }
        }

        modoEditarActivado = false;
    }

    public void buscarInstructor() throws SNMPExceptions, SQLException {
        modoEditarActivado = false;
        mensajeExito = "";
        mensajeFallido = "";

        Instructor oInstructor = null;
        InstructorDB oInstructorDB = new InstructorDB();

        if (oInstructorDB.consultarInstructor(this.idBuscar) == false) {
            mensajeFallido = "Instructor no existe!";
        } else {
            oInstructor = oInstructorDB.buscarInstructor(this.idBuscar);
            this.id = oInstructor.getId();
            this.tipoIdentificacion = oInstructor.getTipoIdentificacion();
            this.nombre = oInstructor.getNombre();
            this.apellido1 = oInstructor.getApellido1();
            this.apellido2 = oInstructor.getApellido2();
            this.correoElectronico = oInstructor.getCorreoElectronico();
            this.log_estado = oInstructor.getLog_estado();
            this.otrasSennas = oInstructor.getoDireccion().getOtrasSennas();
            this.telefono1 = oInstructor.getListaTelefono().get(0).getNumero();
            this.telefono2 = oInstructor.getListaTelefono().get(1).getNumero();
            this.obeanDisciplinaDeportiva1.setId(oInstructor.getListaDisciplinaDeportiva().get(0).getId());
            this.obeanDisciplinaDeportiva2.setId(oInstructor.getListaDisciplinaDeportiva().get(1).getId());
            this.obeanDisciplinaDeportiva3.setId(oInstructor.getListaDisciplinaDeportiva().get(2).getId());
            this.obeanProvincias.setCod_provincia(oInstructor.getoDireccion().getProvincia());
            this.obeanProvincias.setCod_canton(oInstructor.getoDireccion().getCanton());
            this.obeanProvincias.setCod_distrito(oInstructor.getoDireccion().getDistrito());
            this.obeanProvincias.setCod_barrio(oInstructor.getoDireccion().getBarrio());

            //For posible update
            oInstructorSinEditar = oInstructor;
            oInstructorSinEditar.agregaTelefono(new Telefono(oInstructor.getListaTelefono().get(0).getNumero()));
            oInstructorSinEditar.agregaTelefono(new Telefono(oInstructor.getListaTelefono().get(1).getNumero()));
            oInstructorSinEditar.agregaDisciplinaDeportiva(new DisciplinaDeportiva(oInstructor.getListaDisciplinaDeportiva().get(0).getId()));
            oInstructorSinEditar.agregaDisciplinaDeportiva(new DisciplinaDeportiva(oInstructor.getListaDisciplinaDeportiva().get(1).getId()));
            oInstructorSinEditar.agregaDisciplinaDeportiva(new DisciplinaDeportiva(oInstructor.getListaDisciplinaDeportiva().get(2).getId()));

            desabilitarAtrue();
        }
    }

    public void desabilitarAFalse() {
        desabilitar = false;
        desabilitarId = false;
    }

    public void modoEditar() {
        modoEditarActivado = true;
        desabilitar = false;
        desabilitarId = true;
    }

    public void desabilitarAtrue() {
        desabilitar = true;
        desabilitarId = true;
    }
}
