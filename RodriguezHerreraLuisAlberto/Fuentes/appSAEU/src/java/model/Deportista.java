/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LARH96
 */
public class Deportista extends Persona {

    private float peso;
    private String talla;
    private float altura;
    private String objetivoDeporte1;
    private String objetivoDeporte2;
    private String objetivoDeporte3;
    private int pago;
    private int DisciplinaDeportiva;
    private List<Telefono> listaTelefono = new ArrayList<Telefono>();
    
    private String pagoString;

    public Deportista() {

    }

    public Deportista(float peso, String talla, float altura,
            String objetivoDeporte1, String objetivoDeporte2,
            String objetivoDeporte3, int pago, int id,
            int tipoIdentificacion, String nombre, String apellido1,
            String apellido2, String correoElectronico, int DisciplinaDeportiva,
            int log_estado, int codUsuario_Registra, Date fechaRegistra,
            int codUsuario_Edita, Date fechaEdita, Direccion oDireccion) {

        super(id, tipoIdentificacion, nombre, apellido1, apellido2, correoElectronico, log_estado, codUsuario_Registra, fechaRegistra, codUsuario_Edita, fechaEdita, oDireccion);
        this.peso = peso;
        this.talla = talla;
        this.altura = altura;
        this.objetivoDeporte1 = objetivoDeporte1;
        this.objetivoDeporte2 = objetivoDeporte2;
        this.objetivoDeporte3 = objetivoDeporte3;
        this.pago = pago;
        this.DisciplinaDeportiva = DisciplinaDeportiva;
    }

    public Deportista(int id, int tipoIdentificacion, String nombre, String apellido1, String apellido2, String pago) {
        super(id, tipoIdentificacion, nombre, apellido1, apellido2);
        this.pagoString = pago;
    }

    public String getPagoString() {
        return pagoString;
    }

    public void setPagoString(String pagoString) {
        this.pagoString = pagoString;
    }
    
    public int getDisciplinaDeportiva() {
        return DisciplinaDeportiva;
    }

    public void setDisciplinaDeportiva(int DisciplinaDeportiva) {
        this.DisciplinaDeportiva = DisciplinaDeportiva;
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

    public List<Telefono> getListaTelefono() {
        return listaTelefono;
    }

    public void setListaTelefono(List<Telefono> listaTelefono) {
        this.listaTelefono = listaTelefono;
    }

    public void agregaTelefono(Telefono pTelefono) {
        listaTelefono.add(pTelefono);
    }

    public float calculaIMC(float peso, float altura) {
        return (float) (peso / Math.pow(altura, 2));
    }

    public String calculaGradoObesidad(float imc) {
        String gradoObesidad = "";

        if (imc <= 18.5) {
            gradoObesidad = "Peso inferior al normal";
        } else if (imc > 18.5 && imc <= 24.9) {
            gradoObesidad = "Normal";
        } else if (imc > 24.9 && imc <= 29.9) {
            gradoObesidad = "Peso superior al normal";
        } else if (imc >= 30) {
            gradoObesidad = "Obesidad";
        }

        return gradoObesidad;
    }
}
