/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LARH96
 */
public class Instructor extends Persona {

    private List<Telefono> listaTelefono = new ArrayList<Telefono>();
    private List<DisciplinaDeportiva> listaDisciplinaDeportiva = new ArrayList<DisciplinaDeportiva>();

    public Instructor(int id, int tipoIdentificacion, String nombre,
            String apellido1, String apellido2, String correoElectronico,
            int log_estado, int codUsuario_Registra, Date fechaRegistra,
            int codUsuario_Edita, Date fechaEdita, Direccion oDireccion) {
        super(id, tipoIdentificacion, nombre, apellido1, apellido2,
                correoElectronico, log_estado, codUsuario_Registra,
                fechaRegistra, codUsuario_Edita, fechaEdita, oDireccion);
    }

    public Instructor(int id, int tipoIdentificacion, String nombre, String apellido1, String apellido2) {
        super(id, tipoIdentificacion, nombre, apellido1, apellido2);
    }

    public void agregaTelefono(Telefono pTelefono) {
        listaTelefono.add(pTelefono);
    }

    public List<Telefono> getListaTelefono() {
        return listaTelefono;
    }

    public List<DisciplinaDeportiva> getListaDisciplinaDeportiva() {
        return listaDisciplinaDeportiva;
    }

    public void setListaDisciplinaDeportiva(List<DisciplinaDeportiva> listaDisciplinaDeportiva) {
        this.listaDisciplinaDeportiva = listaDisciplinaDeportiva;
    }

    public void setListaTelefono(List<Telefono> listaTelefono) {
        this.listaTelefono = listaTelefono;
    }

    public void agregaDisciplinaDeportiva(DisciplinaDeportiva pDisciplinaDeportiva) {
        listaDisciplinaDeportiva.add(pDisciplinaDeportiva);
    }

    public String toString() {
        return this.getId() + " - "
                + this.getNombre() + " "
                + this.getApellido1() + " "
                + this.getApellido2();
    }
}
