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

    public LinkedList<AsignacionDeportistaAInstructor> moTodoInstructorAsignado() throws SNMPExceptions, SQLException {
        String selectDeportistas = "";
        String selectParaComparar = "";
        int idAComparar = 0;
        boolean existe = false;

        LinkedList<AsignacionDeportistaAInstructor> listaAsignacionDeportistaAInstructor = new LinkedList<AsignacionDeportistaAInstructor>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //se ejecuta la sentencia sql
            selectDeportistas
                    = "SELECT id, nombre, apellido1, apellido2 "
                    + "FROM Deportista";

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
}
