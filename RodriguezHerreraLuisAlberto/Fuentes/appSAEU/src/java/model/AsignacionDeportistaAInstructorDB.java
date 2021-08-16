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
import java.util.LinkedList;

import javax.naming.NamingException;

/**
 *
 * @author LARH96
 */
public class AsignacionDeportistaAInstructorDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public AsignacionDeportistaAInstructorDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public LinkedList<AsignacionDeportistaAInstructor> moTodoInstructorAsignado(
            int pIdDisciplinaDeportiva, int pIdProvincia, int pIdCanton,
            int pIdDistrito, int pIdBarrio, int pIdDeportista)
            throws SNMPExceptions, SQLException {
        String selectDeportistas = "";
        String selectParaComparar = "";
        int idAComparar = 0;
        boolean existe = false;

        LinkedList<AsignacionDeportistaAInstructor> listaAsignacionDeportistaAInstructor = new LinkedList<AsignacionDeportistaAInstructor>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();
            if (pIdDeportista != 0) {
                selectDeportistas
                        = "SELECT id, nombre, apellido1, apellido2 "
                        + "FROM Deportista "
                        + "WHERE id = " + pIdDeportista + ";";
            } else if (pIdDisciplinaDeportiva == 0
                    && pIdProvincia == 0
                    && pIdCanton == 0
                    && pIdDistrito == 0
                    && pIdBarrio == 0) {
                selectDeportistas
                        = "SELECT id, nombre, apellido1, apellido2 "
                        + "FROM Deportista";
            } else if (pIdDisciplinaDeportiva != 0
                    && pIdProvincia == 0
                    && pIdCanton == 0
                    && pIdDistrito == 0
                    && pIdBarrio == 0) {
                selectDeportistas
                        = "SELECT id, nombre, apellido1, apellido2 "
                        + "FROM Deportista "
                        + "WHERE idDisciplinaDeportiva = " + pIdDisciplinaDeportiva + ";";
            } else if (pIdDisciplinaDeportiva != 0
                    && pIdProvincia != 0) {
                selectDeportistas
                        = "SELECT dep.id, dep.nombre, dep.apellido1, dep.apellido2 "
                        + "FROM Deportista dep INNER JOIN Direccion dir ON dep.id = dir.id "
                        + "WHERE idDisciplinaDeportiva = " + pIdDisciplinaDeportiva + " "
                        + "AND dir.idProvincia = " + pIdProvincia + " "
                        + "AND dir.idCanton = " + pIdCanton + " "
                        + "AND dir.idDistrito = " + pIdDistrito + " "
                        + "AND dir.idBarrio = " + pIdBarrio + " ";
            } else if (pIdProvincia != 0) {
                selectDeportistas
                        = "SELECT dep.id, dep.nombre, dep.apellido1, dep.apellido2 "
                        + "FROM Deportista dep INNER JOIN Direccion dir ON dep.id = dir.id "
                        + "WHERE "
                        + "dir.idCanton = " + pIdCanton + " "
                        + "AND dir.idDistrito = " + pIdDistrito + " "
                        + "AND dir.idBarrio = " + pIdBarrio + " ";
            }

            ResultSet rsPA1 = accesoDatos.ejecutaSQLRetornaRS(selectDeportistas);

            //se llama el array con los proyectos
            while (rsPA1.next()) {
                idAComparar = rsPA1.getInt("id");
                int idDeportista;
                String nombreDeportista;
                String apellido1Deportista;
                String apellido2Deportista;
                int idInstructor;
                String nombreInstructor;
                String apellido1Instructor;
                String apellido2Instructor;

                selectParaComparar
                        = "SELECT adi.idDeportista as idDeportista, d.nombre as nombreDeportista, d.apellido1 as apellido1Deportista, d.apellido2 as apellido2Deportista, "
                        + "adi.idInstructor as idInstructor, i.nombre as nombreInstructor, i.apellido1 as apellido1Instructor, i.apellido2 as apellido2Instructor "
                        + "FROM AsignDeportistaPorInstructor adi "
                        + "INNER JOIN Instructor i ON adi.idInstructor = i.id "
                        + "INNER JOIN Deportista d ON adi.idDeportista = d.id "
                        + "WHERE adi.log_estado = 1 "
                        + "AND adi.idDeportista = " + "'" + idAComparar + "';";
                ResultSet rsPA2 = accesoDatos.ejecutaSQLRetornaRS(selectParaComparar);
                existe = false;
                if (rsPA2.next()) {
                    existe = true;
                }

                if (existe) {
                    idDeportista = rsPA2.getInt("idDeportista");
                    nombreDeportista = rsPA2.getString("nombreDeportista");
                    apellido1Deportista = rsPA2.getString("apellido1Deportista");
                    apellido2Deportista = rsPA2.getString("apellido2Deportista");
                    idInstructor = rsPA2.getInt("idInstructor");
                    nombreInstructor = rsPA2.getString("nombreInstructor");
                    apellido1Instructor = rsPA2.getString("apellido1Instructor");
                    apellido2Instructor = rsPA2.getString("apellido2Instructor");
                } else {
                    idDeportista = rsPA1.getInt("id");
                    nombreDeportista = rsPA1.getString("nombre");
                    apellido1Deportista = rsPA1.getString("apellido1");
                    apellido2Deportista = rsPA1.getString("apellido2");
                    idInstructor = 0;
                    nombreInstructor = "Nadie";
                    apellido1Instructor = "";
                    apellido2Instructor = "";
                }

                AsignacionDeportistaAInstructor oAsignacionDeportistaAInstructor
                        = new AsignacionDeportistaAInstructor(
                                idDeportista, nombreDeportista, apellido1Deportista, apellido2Deportista,
                                idInstructor, nombreInstructor, apellido1Instructor, apellido2Instructor);

                listaAsignacionDeportistaAInstructor.add(oAsignacionDeportistaAInstructor);
                rsPA2.close();
            }
            rsPA1.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaAsignacionDeportistaAInstructor;
    }

    public void editarInstructor(int pIdDeportista, int pIdInstructor)
            throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String update = "";

        update
                += "UPDATE AsignDeportistaPorInstructor "
                + "SET idInstructor = " + "'" + pIdInstructor + "'"
                + "WHERE idDeportista = " + "'" + pIdDeportista + "';";

        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }

    public boolean consultarExistencia(int pIdDeportista)
            throws SNMPExceptions, SQLException {

        boolean existe = false;
        String select = "";
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select = "select * from AsignDeportistaPorInstructor where idDeportista= " + pIdDeportista;

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

    public void insertar(AsignacionDeportistaAInstructor pAsignacionDeportistaAInstructor)
            throws SNMPExceptions, SQLException {
        String strSQL;

        try {
            //Inserta direccion del instructor
            strSQL
                    = "INSERT INTO AsignDeportistaPorInstructor(idInstructor, idDeportista, log_estado, "
                    + "codUsuario_Registra, fechaRegistra, codUsuario_Edita, fechaEdita) VALUES "
                    + "(" + "'" + pAsignacionDeportistaAInstructor.getIdInstructor() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getIdDeportista() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getLog_estado() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getCodUsuario_Registra() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getFechaRegistra() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getCodUsuario_Edita() + "'" + ","
                    + "'" + pAsignacionDeportistaAInstructor.getFechaEdita() + "'" + ");";

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
}
