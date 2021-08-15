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
import java.util.Iterator;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author LARH96
 */
public class DeportistaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public DeportistaDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public void insertarDeportista(Deportista pDeportista)
            throws SNMPExceptions, SQLException {
        String strSQL;

        try {
            //Inserta direccion del deportista
            strSQL
                    = "INSERT INTO Direccion(id, idProvincia, idCanton,"
                    + " idDistrito, idBarrio, OtrasSennas) VALUES "
                    + "(" + "'" + pDeportista.getId() + "'" + ","
                    + "'" + pDeportista.getoDireccion().getProvincia() + "'" + ","
                    + "'" + pDeportista.getoDireccion().getCanton() + "'" + ","
                    + "'" + pDeportista.getoDireccion().getDistrito() + "'" + ","
                    + "'" + pDeportista.getoDireccion().getBarrio() + "'" + ","
                    + "'" + pDeportista.getoDireccion().getOtrasSennas() + "'" + ");";

            //Inserta deportista
            strSQL
                    += "INSERT INTO Deportista(id, idTipoIdentificacion, nombre, "
                    + "apellido1, apellido2, correoElectronico, idDisciplinaDeportiva, "
                    + "peso, talla, altura, objetivoDeporte1, objetivoDeporte2, "
                    + "objetivoDeporte3, log_estado, codUsuario_Registra, fechaRegistra, "
                    + "codUsuario_Edita, fechaEdita, pago) VALUES "
                    + "(" + "'" + pDeportista.getId() + "'" + ","
                    + "'" + pDeportista.getTipoIdentificacion() + "'" + ","
                    + "'" + pDeportista.getNombre() + "'" + ","
                    + "'" + pDeportista.getApellido1() + "'" + ","
                    + "'" + pDeportista.getApellido2() + "'" + ","
                    + "'" + pDeportista.getCorreoElectronico() + "'" + ","
                    + "'" + pDeportista.getDisciplinaDeportiva() + "'" + ","
                    + "'" + pDeportista.getPeso() + "'" + ","
                    + "'" + pDeportista.getTalla() + "'" + ","
                    + "'" + pDeportista.getAltura() + "'" + ","
                    + "'" + pDeportista.getObjetivoDeporte1() + "'" + ","
                    + "'" + pDeportista.getObjetivoDeporte2() + "'" + ","
                    + "'" + pDeportista.getObjetivoDeporte3() + "'" + ","
                    + "'" + pDeportista.getLog_estado() + "'" + ","
                    + "'" + pDeportista.getCodUsuario_Registra() + "'" + ","
                    + "'" + pDeportista.getFechaRegistra() + "'" + ","
                    + "'" + pDeportista.getCodUsuario_Edita() + "'" + ","
                    + "'" + pDeportista.getFechaEdita() + "'" + ","
                    + "'" + pDeportista.getPago() + "'" + ");\n\n";

            //Inserta telefonos del deportista
            for (Telefono tel : pDeportista.getListaTelefono()) {
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

            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }

    public boolean consultarDeportista(int pId)
            throws SNMPExceptions, SQLException {

        boolean existe = false;
        String select = "";
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select = "select * from Deportista where id=" + pId;

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

    public LinkedList<Deportista> moTodo() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<Deportista> listaDeportista = new LinkedList<Deportista>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "SELECT id, idTipoIdentificacion, nombre, apellido1, "
                    + "apellido2, pago FROM Deportista WHERE log_estado = 1";
            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                int id = rsPA.getInt("id");
                int idTipoIdentificacion = rsPA.getInt("idTipoIdentificacion");
                String nombre = rsPA.getString("nombre");
                String apellido1 = rsPA.getString("apellido1");
                String apellido2 = rsPA.getString("apellido2");
                int pago = rsPA.getInt("pago");

                String pagoString = "";
                //se construye el objeto
                if (pago == 1) {
                    pagoString = "Pagado";
                } else {
                    pagoString = "Pendiente";
                }
                Deportista oDeportista = new Deportista(id, idTipoIdentificacion, nombre, apellido1, apellido2, pagoString);

                listaDeportista.add(oDeportista);
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaDeportista;
    }

    public void cambiarEstadoPagoDeportista(int pIdDeportista, int pPagoCambiado)
            throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String update = "";

        update
                += "UPDATE Deportista "
                + "SET "
                + "pago = " + "'" + pPagoCambiado + "' "
                + "WHERE id = " + "'" + pIdDeportista + "';";

        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
}
