/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LARH96
 */
public class InstructorDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public InstructorDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public void insertarInstructor(Instructor pInstructor)
            throws SNMPExceptions, SQLException {
        String strSQL;

        try {
            //Inserta direccion del instructor
            strSQL
                    = "INSERT INTO Direccion(id, idProvincia, idCanton,"
                    + " idDistrito, idBarrio, OtrasSennas) VALUES "
                    + "(" + "'" + pInstructor.getId() + "'" + ","
                    + "'" + pInstructor.getoDireccion().getProvincia() + "'" + ","
                    + "'" + pInstructor.getoDireccion().getCanton() + "'" + ","
                    + "'" + pInstructor.getoDireccion().getDistrito() + "'" + ","
                    + "'" + pInstructor.getoDireccion().getBarrio() + "'" + ","
                    + "'" + pInstructor.getoDireccion().getOtrasSennas() + "'" + ");";

            //Inserta instructor
            strSQL
                    += "INSERT INTO Instructor(id, idTipoIdentificacion, nombre, "
                    + "apellido1, apellido2, correoElectronico, "
                    + "log_estado, codUsuario_Registra, fechaRegistra, "
                    + "codUsuario_Edita, fechaEdita) VALUES "
                    + "(" + "'" + pInstructor.getId() + "'" + ","
                    + "'" + pInstructor.getTipoIdentificacion() + "'" + ","
                    + "'" + pInstructor.getNombre() + "'" + ","
                    + "'" + pInstructor.getApellido1() + "'" + ","
                    + "'" + pInstructor.getApellido2() + "'" + ","
                    + "'" + pInstructor.getCorreoElectronico() + "'" + ","
                    + "'" + pInstructor.getLog_estado() + "'" + ","
                    + "'" + pInstructor.getCodUsuario_Registra() + "'" + ","
                    + "'" + pInstructor.getFechaRegistra() + "'" + ","
                    + "'" + pInstructor.getCodUsuario_Edita() + "'" + ","
                    + "'" + pInstructor.getFechaEdita() + "'" + ");\n\n";

            //Inserta telefonos del deportista
            for (Telefono tel : pInstructor.getListaTelefono()) {
                strSQL
                        += "INSERT INTO Telefono(id, numero, log_estado, "
                        + "codUsuario_Registra, fechaRegistra, "
                        + "codUsuario_Edita, fechaEdita) VALUES "
                        + "(" + "'" + tel.getId() + "'" + ","
                        + "'" + tel.getNumero() + "'" + ","
                        + "'" + tel.getLog_estado() + "'" + ","
                        + "'" + tel.getCodUsuario_Registra() + "'" + ","
                        + "'" + tel.getFechaRegistra() + "'" + ","
                        + "'" + tel.getCodUsuario_Edita() + "'" + ","
                        + "'" + tel.getFechaEdita() + "'" + ");\n\n";
            }

            //Inserta disciplinas deportivas del instructor
            for (DisciplinaDeportiva dis : pInstructor.getListaDisciplinaDeportiva()) {
                strSQL
                        += "INSERT INTO InstructorDisciplinaDeportiva(idInstructor,"
                        + " idDisciplinaDeportiva) VALUES ("
                        + "'" + pInstructor.getId() + "'" + ","
                        + "'" + dis.getId() + "'" + ");";
            }

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

    public boolean consultarInstructor(int pId)
            throws SNMPExceptions, SQLException {

        boolean existe = false;
        String select = "";
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select = "select * from Instructor where id=" + pId;

            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            if (rsPA.next()) {

                existe = true;
            }

            rsPA.close();

            return existe;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }

    }
}
