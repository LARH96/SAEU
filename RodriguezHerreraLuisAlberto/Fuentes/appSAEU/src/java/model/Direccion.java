/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LARH96
 */
public class Direccion {
    
    private int id;
    private String provincia;
    private String canton;
    private String distrito;
    private String barrio;
    private String otrasSennas;

    public Direccion(int id, String provincia, String canton, String distrito, String barrio, String otrasSennas) {
        this.id = id;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.barrio = barrio;
        this.otrasSennas = otrasSennas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }
}
