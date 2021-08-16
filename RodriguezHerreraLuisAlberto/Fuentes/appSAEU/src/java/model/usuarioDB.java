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
public class usuarioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public usuarioDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public static Usuario Autenticar(String pUsuario, String pContrasenna) throws SNMPExceptions {
        String select = "";
        Usuario oUsuario = null;
        
        //retorna nulo si no lo encuentra
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "SELECT u.nombre, u.idTipoPerfil "
                    + "FROM Usuario u INNER JOIN Contrasenna c ON u.id = c.idUsuario "
                    + "WHERE u.log_estado = 1 "
                    + "AND c.actual = " + "'" + pContrasenna + "'"
                    + "AND u.nombre = " + "'" + pUsuario + "';";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                String nombre = rsPA.getString("nombre");
                int idTipoPerfil = rsPA.getInt("idTipoPerfil");

                //se construye el objeto.
                oUsuario = new Usuario(nombre, idTipoPerfil);
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return oUsuario;
    }
}
