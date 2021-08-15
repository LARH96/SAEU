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
public class DisciplinaDeportivaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public DisciplinaDeportivaDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public LinkedList<DisciplinaDeportiva> moTodo() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<DisciplinaDeportiva> listaDisciplinaDeportiva = new LinkedList<DisciplinaDeportiva>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "SELECT id, descripcion FROM DisciplinaDeportiva WHERE log_estado = 1";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                int id = rsPA.getInt("id");
                String descripcion = rsPA.getString("descripcion");

                //se construye el objeto.
                DisciplinaDeportiva oDisciplinaDeportiva = new DisciplinaDeportiva(id, descripcion);

                listaDisciplinaDeportiva.add(oDisciplinaDeportiva);
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaDisciplinaDeportiva;
    }
}
