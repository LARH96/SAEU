/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javax.faces.validator.ValidatorException;
import model.Deportista;
import model.Telefono;
import model.DeportistaDB;
import utilitario.ValidadorFormatos;
import javax.faces.context.FacesContext;
import dao.SNMPExceptions;
import java.util.LinkedList;
import javax.naming.NamingException;
import model.Direccion;
import model.Provincia;
import model.ProvinciaDB;
import utilitario.Email;

/**
 *
 * @author LARH96
 */
@Named(value = "beanDeportista")
@SessionScoped
public class beanDeportista implements Serializable {

    private int id;
    private int tipoIdentificacion;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;
    private int DisciplinaDeportiva;
    private int log_estado;
    private int codUsuario_Registra;
    private Date fechaRegistra;
    private int codUsuario_Edita;
    private Date fechaEdita;
    private float peso;
    private String talla;
    private float altura;
    private String objetivoDeporte1;
    private String objetivoDeporte2;
    private String objetivoDeporte3;
    private int pago;
    private List<Telefono> listaTelefono = new ArrayList<Telefono>();
    private List<Deportista> listaDeportista = new ArrayList<Deportista>();
    private Direccion oDireccion = new Direccion();
    private beanDisciplinaDeportiva obeanDisciplinaDeportiva = new beanDisciplinaDeportiva();
    private String otrasSennas;

    //extra
    private int telefono1;
    private int telefono2;
    private float imc;
    private String gradoObesidad;
    String mensajeExito;
    String mensajeFallido;
    private beanProvincias obeanProvincias = new beanProvincias();

    /**
     * Creates a new instance of beanDeportista
     */
    public beanDeportista() {

    }

    public beanDisciplinaDeportiva getObeanDisciplinaDeportiva() {
        return obeanDisciplinaDeportiva;
    }

    public void setObeanDisciplinaDeportiva(beanDisciplinaDeportiva obeanDisciplinaDeportiva) {
        this.obeanDisciplinaDeportiva = obeanDisciplinaDeportiva;
    }

    public beanProvincias getObeanProvincias() {
        return obeanProvincias;
    }

    public void setObeanProvincias(beanProvincias obeanProvincias) {
        this.obeanProvincias = obeanProvincias;
    }

    public LinkedList<Deportista> getListaDeportista() throws SNMPExceptions, SQLException {

        LinkedList<Deportista> lista = new LinkedList<Deportista>();
        DeportistaDB oDeportistaDB = new DeportistaDB();

        lista = oDeportistaDB.moTodo();

        LinkedList resultLista = new LinkedList();

        resultLista = lista;
        return resultLista;
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

    //==========================================================================
    // Accessors
    //==========================================================================
    public void setMensajeFallido(String mensajeFallido) {
        this.mensajeFallido = mensajeFallido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDisciplinaDeportiva() {
        return DisciplinaDeportiva;
    }

    public void setDisciplinaDeportiva(int DisciplinaDeportiva) {
        this.DisciplinaDeportiva = DisciplinaDeportiva;
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

    public String getMensaje() {
        return mensajeExito;
    }

    public void setMensaje(String mensaje) {
        this.mensajeExito = mensaje;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getObjetivoDeporte1() {
        return objetivoDeporte1;
    }

    public void setObjetivoDeporte1(String objetivoDeporte1) {
        this.objetivoDeporte1 = objetivoDeporte1;
    }

    public String getObjetivoDeporte2() {
        return objetivoDeporte2;
    }

    public void setObjetivoDeporte2(String objetivoDeporte2) {
        this.objetivoDeporte2 = objetivoDeporte2;
    }

    public String getObjetivoDeporte3() {
        return objetivoDeporte3;
    }

    public void setObjetivoDeporte3(String objetivoDeporte3) {
        this.objetivoDeporte3 = objetivoDeporte3;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
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

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }

    public String getGradoObesidad() {
        return gradoObesidad;
    }

    public void setGradoObesidad(String gradoObesidad) {
        this.gradoObesidad = gradoObesidad;
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

    public void validaDisciplinaDeportiva(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valor.equals("0")) {
            String mensaje = "Disciplina deportiva no especificada";
            throw new ValidatorException(new FacesMessage(mensaje));
        } else {
            setDisciplinaDeportiva(valorInt);
        }
    }

    public void validaPeso(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        if (valor.equals("0.0")) {
            String mensaje = "Peso no válido";
            throw new ValidatorException(new FacesMessage(mensaje));
        }
    }

    public void validaTalla(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        if (valor.equals("S")
                || valor.equals("M")
                || valor.equals("L")
                || valor.equals("XL")
                || valor.equals("XXL")) {
        } else {
            String mensaje = "Talla no valida, debe ser S, M, L, XL ó EG";
            throw new ValidatorException(new FacesMessage(mensaje));
        }
    }

    public void validaAltura(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        if (valor.equals("0.0")) {
            String mensaje = "Altura no válida";
            throw new ValidatorException(new FacesMessage(mensaje));
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

    public void validaTelefono1(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        this.setTelefono1(valorInt);
    }
    
    public void validaTelefono2(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String valor = value.toString();
        double valorDouble = Double.parseDouble(valor);
        int valorInt = (int) valorDouble;
        if (valorInt == this.telefono1) {
            String mensaje = "Debe indicar teléfonos diferentes";
            throw new ValidatorException(new FacesMessage(mensaje));
        }
    }

    //==========================================================================
    // Methods
    //==========================================================================
    public void asignaIMCYGradoObesidad() {
        calculaIMC();
        calculaGradoObesidad();
    }

    public void calculaIMC() {
        Deportista oDeportista = new Deportista();
        this.imc = oDeportista.calculaIMC(this.peso, this.altura);
    }

    public void calculaGradoObesidad() {
        Deportista oDeportista = new Deportista();
        this.gradoObesidad = oDeportista.calculaGradoObesidad(this.imc);
    }

    public void limpiaCasillas() {
        this.id = 0;
        getTipoIdentificacion();
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correoElectronico = "";
        this.log_estado = 1;
        this.peso = 0f;
        this.talla = "";
        this.altura = 0.0f;
        this.objetivoDeporte1 = "";
        this.objetivoDeporte2 = "";
        this.objetivoDeporte3 = "";
        this.pago = 0;
        this.listaTelefono.clear();
        this.telefono1 = 0;
        this.telefono2 = 0;
        this.otrasSennas = "";
        this.imc = 0;
        this.gradoObesidad = "";
        obeanProvincias.setCod_provincia(0);
        obeanProvincias.setCod_canton(0);
        obeanProvincias.setCod_distrito(0);
        obeanProvincias.setCod_barrio(0);
        obeanDisciplinaDeportiva.setId(0);
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

    public String creaDeportista() throws SNMPExceptions, SQLException {
        String paginaADevolver = "";
        this.mensajeExito = "";
        this.mensajeFallido = "";

        this.pago = 1;
        this.log_estado = 1;
        java.util.Date date = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.codUsuario_Registra = this.id;
        this.fechaRegistra = date2;
        this.codUsuario_Edita = this.id;
        this.fechaEdita = date2;

        Deportista oDeportista = new Deportista(
                this.peso, this.talla, this.altura,
                this.objetivoDeporte1, this.objetivoDeporte2,
                this.objetivoDeporte3, this.pago, this.id,
                this.tipoIdentificacion, this.nombre, this.apellido1,
                this.apellido2, this.correoElectronico, this.DisciplinaDeportiva,
                this.log_estado, this.codUsuario_Registra, date2,
                this.codUsuario_Edita, date2, this.oDireccion
        );
        oDeportista.agregaTelefono(new Telefono(this.id, this.telefono1, 1, this.id, date2, 0, date2));
        oDeportista.agregaTelefono(new Telefono(this.id, this.telefono2, 1, this.id, date2, 0, date2));

        DeportistaDB oDeportistaDB = new DeportistaDB();

        if (oDeportistaDB.consultarDeportista(this.id) == true) {
            mensajeFallido = "Deportista ya registrado!";
            Email oEmail = new Email();
            oEmail.sendEmail(this.correoElectronico, oDeportista);
            //throw new ValidatorException(new FacesMessage(mensajeExito));
        } else {
            oDeportistaDB.insertarDeportista(oDeportista);
            mensajeExito = "Registro almacenado correctamente";
            limpiaCasillas();
            paginaADevolver = "miscellaneusEnvioEmailAutoRegistroAtleta.xhtml";
            //throw new ValidatorException(new FacesMessage(mensaje));
        }
        return paginaADevolver;
    }

    public void editarPagoDeportista(Deportista pDeportista) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        DeportistaDB oDeportistaDB = new DeportistaDB();
        oDeportistaDB.cambiarEstadoPagoDeportista(pDeportista.getId(), (pDeportista.getPagoString().equals("Pagado")) ? 0 : 1);
        mensajeExito = "Registro almacenado correctamente";
    }

    public String volverEnvioEmail() {
        String devolverPagina = "securityLoginSportPlayer.xhtml";

        mensajeExito = "";

        return devolverPagina;
    }
}
