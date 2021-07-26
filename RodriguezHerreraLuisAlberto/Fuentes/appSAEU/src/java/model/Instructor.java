/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author LARH96
 */
public class Instructor extends Persona {

    public Instructor(int id, int tipoIdentificacion, String nombre, String apellido1, String apellido2, String correoElectronico, int DisciplinaDeportiva, int log_estado, int codUsuario_Registra, Date fechaRegistra, int codUsuario_Edita, Date fechaEdita, Direccion oDireccion) {
        super(id, tipoIdentificacion, nombre, apellido1, apellido2, correoElectronico, DisciplinaDeportiva, log_estado, codUsuario_Registra, fechaRegistra, codUsuario_Edita, fechaEdita, oDireccion);
    }
}
