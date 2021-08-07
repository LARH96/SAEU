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
    private int provincia;
    private int canton;
    private int distrito;
    private int barrio;
    private String otrasSennas;

    public Direccion() {
    }
    
    public Direccion(int id, int provincia, int canton, int distrito, int barrio, String otrasSennas) {
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

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public int getBarrio() {
        return barrio;
    }

    public void setBarrio(int barrio) {
        this.barrio = barrio;
    }

    public String getOtrasSennas() {
        return otrasSennas;
    }

    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
    }
}
