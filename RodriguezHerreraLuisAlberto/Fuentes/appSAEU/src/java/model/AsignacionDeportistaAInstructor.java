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
public class AsignacionDeportistaAInstructor {

    private int idDeportista;
    private String nombreDeportista;
    private String apellido1Deportista;
    private String apellido2Deportista;
    private int idInstructor;
    private String nombreInstructor;
    private String apellido1Instructor;
    private String apellido2Instructor;

    public AsignacionDeportistaAInstructor(int idDeportista, String nombreDeportista, String apellido1Deportista, String apellido2Deportista, int idInstructor, String nombreInstructor, String apellido1Instructor, String apellido2Instructor) {
        this.idDeportista = idDeportista;
        this.nombreDeportista = nombreDeportista;
        this.apellido1Deportista = apellido1Deportista;
        this.apellido2Deportista = apellido2Deportista;
        this.idInstructor = idInstructor;
        this.nombreInstructor = nombreInstructor;
        this.apellido1Instructor = apellido1Instructor;
        this.apellido2Instructor = apellido2Instructor;
    }
    
    public int getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(int idDeportista) {
        this.idDeportista = idDeportista;
    }

    public String getNombreDeportista() {
        return nombreDeportista;
    }

    public void setNombreDeportista(String nombreDeportista) {
        this.nombreDeportista = nombreDeportista;
    }

    public String getApellido1Deportista() {
        return apellido1Deportista;
    }

    public void setApellido1Deportista(String apellido1Deportista) {
        this.apellido1Deportista = apellido1Deportista;
    }

    public String getApellido2Deportista() {
        return apellido2Deportista;
    }

    public void setApellido2Deportista(String apellido2Deportista) {
        this.apellido2Deportista = apellido2Deportista;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    public String getApellido1Instructor() {
        return apellido1Instructor;
    }

    public void setApellido1Instructor(String apellido1Instructor) {
        this.apellido1Instructor = apellido1Instructor;
    }

    public String getApellido2Instructor() {
        return apellido2Instructor;
    }

    public void setApellido2Instructor(String apellido2Instructor) {
        this.apellido2Instructor = apellido2Instructor;
    }
    
    
}
