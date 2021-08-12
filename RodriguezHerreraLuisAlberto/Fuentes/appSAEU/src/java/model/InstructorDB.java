/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.beanDisciplinaDeportiva;
import dao.AccesoDatos;
import dao.SNMPExceptions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

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

    public Instructor buscarInstructor(int pId) throws SNMPExceptions, SQLException {
        String select1 = "";
        String select2 = "";
        String select3 = "";
        Instructor oInstructor = null;
        Direccion oDireccion = null;

        try {
            //Se crea la sentencia de Busqueda
            select1
                    = "select i.idTipoIdentificacion, i.id, i.nombre, i.apellido1, i.apellido2, "
                    + "d.idProvincia, d.idCanton, d.idDistrito, d.idBarrio, d.OtrasSennas, i.correoElectronico, "
                    + "i.log_estado, i.codUsuario_Registra, i.fechaRegistra, i.codUsuario_Edita, i.fechaEdita "
                    + "from Instructor i INNER JOIN Direccion d ON i.id = d.id "
                    + "where log_estado = 1 AND i.id = "
                    + "'" + pId + "'" + ";";

            select2 = "select t.numero "
                    + "from Telefono t, Instructor i "
                    + "where i.log_estado = 1 AND t.log_estado = 1 AND i.id = t.id "
                    + "AND i.id = "
                    + "'" + pId + "'" + ";";

            select3 = "select idd.idDisciplinaDeportiva, d.descripcion "
                    + "from InstructorDisciplinaDeportiva idd, Instructor i, DisciplinaDeportiva d "
                    + "where i.log_estado = 1 AND d.log_estado = 1 AND i.id = idd.idInstructor AND idd.idDisciplinaDeportiva = d.id "
                    + "AND i.id = "
                    + "'" + pId + "'" + " order by idd.id;";

            ResultSet rsPA1 = accesoDatos.ejecutaSQLRetornaRS(select1);
            ResultSet rsPA2 = accesoDatos.ejecutaSQLRetornaRS(select2);
            ResultSet rsPA3 = accesoDatos.ejecutaSQLRetornaRS(select3);

            while (rsPA1.next()) {
                int idTipoIdentificacion = rsPA1.getInt("idTipoIdentificacion");
                int id = rsPA1.getInt("id");
                String nombre = rsPA1.getString("nombre");
                String apellido1 = rsPA1.getString("apellido1");
                String apellido2 = rsPA1.getString("apellido2");
                int idProvincia = rsPA1.getInt("idProvincia");
                int idCanton = rsPA1.getInt("idCanton");
                int idDistrito = rsPA1.getInt("idDistrito");
                int idBarrio = rsPA1.getInt("idBarrio");
                String OtrasSennas = rsPA1.getString("OtrasSennas");
                String correoElectronico = rsPA1.getString("correoElectronico");
                int log_estado = rsPA1.getInt("log_estado");
                int codUsuario_Registra = rsPA1.getInt("codUsuario_Registra");
                Date fechaRegistra = rsPA1.getDate("fechaRegistra");
                int codUsuario_Edita = rsPA1.getInt("codUsuario_Edita");
                Date fechaEdita = rsPA1.getDate("fechaEdita");
                //Instructor
                oDireccion = new Direccion(id, idProvincia, idCanton, idDistrito, idBarrio, OtrasSennas);
                oInstructor = new Instructor(id, idTipoIdentificacion, nombre, apellido1,
                        apellido2, correoElectronico, log_estado, codUsuario_Registra,
                        fechaRegistra, codUsuario_Edita, fechaEdita, oDireccion);
            }

            //Telefonos instructor
            while (rsPA2.next()) {
                int num = rsPA2.getInt("numero");
                //se construye el objeto.
                Telefono oTelefono = new Telefono(num);
                oInstructor.agregaTelefono(oTelefono);
            }

            ////Disciplinas Deportivas instructor
            while (rsPA3.next()) {
                int idDisciplinaDeportiva = rsPA3.getInt("idDisciplinaDeportiva");
                String descripcion = rsPA3.getString("descripcion");
                //se construye el objeto.
                DisciplinaDeportiva oDisciplinaDeportiva = new DisciplinaDeportiva(idDisciplinaDeportiva, descripcion);
                oInstructor.agregaDisciplinaDeportiva(oDisciplinaDeportiva);
            }

            rsPA1.close();//se cierra el ResultSeat.
            rsPA2.close();//se cierra el ResultSeat.
            rsPA3.close();//se cierra el ResultSeat.
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        }
        return oInstructor;
    }

    public void editarInstructor(Instructor pInstructor, Instructor pInstructorSinEditar)
            throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String update = "";

        update
                += "UPDATE Direccion "
                + "SET "
                + "idProvincia = " + "'" + pInstructor.getoDireccion().getProvincia() + "',"
                + "idCanton = " + "'" + pInstructor.getoDireccion().getCanton() + "',"
                + "idDistrito = " + "'" + pInstructor.getoDireccion().getDistrito() + "',"
                + "idBarrio = " + "'" + pInstructor.getoDireccion().getBarrio() + "',"
                + "OtrasSennas = " + "'" + pInstructor.getoDireccion().getOtrasSennas() + "' "
                + "WHERE id = " + "'" + pInstructor.getId() + "';";

        update
                += "UPDATE Instructor "
                + "SET "
                + "idTipoIdentificacion = " + "'" + pInstructor.getTipoIdentificacion() + "',"
                + "nombre = " + "'" + pInstructor.getNombre() + "',"
                + "apellido1 = " + "'" + pInstructor.getApellido1() + "',"
                + "apellido2 = " + "'" + pInstructor.getApellido2() + "',"
                + "correoElectronico = " + "'" + pInstructor.getCorreoElectronico() + "',"
                + "codUsuario_Edita = " + "'" + pInstructor.getCodUsuario_Edita() + "',"
                + "fechaEdita = " + "'" + pInstructor.getFechaEdita() + "' "
                + "WHERE id = " + "'" + pInstructor.getId() + "';";

        for (int i = 0; i < 2; i++) {
            update
                    += "UPDATE Telefono "
                    + "SET "
                    + "numero = " + "'" + pInstructor.getListaTelefono().get(i).getNumero() + "',"
                    + "codUsuario_Edita = " + "'" + pInstructor.getListaTelefono().get(i).getCodUsuario_Edita() + "',"
                    + "fechaEdita = " + "'" + pInstructor.getListaTelefono().get(i).getFechaEdita() + "' "
                    + "WHERE id = " + "'" + pInstructor.getId() + "' "
                    + "AND numero = " + "'" + pInstructorSinEditar.getListaTelefono().get(i).getNumero() + "';";
        }

        int ultCampoDiscip = ultimoCampoDisciplinaDeportiva(pInstructor.getId());

        for (int i = 0; i < 3; i++) {

            if (i == 2) {
                update
                        += "UPDATE InstructorDisciplinaDeportiva "
                        + "SET "
                        + "idDisciplinaDeportiva = " + "'" + pInstructor.getListaDisciplinaDeportiva().get(i).getId() + "' "
                        + "WHERE idInstructor = " + "'" + pInstructor.getId() + "' "
                        + "AND id = " + "'" + ultCampoDiscip + "' "
                        + "AND idDisciplinaDeportiva = " + "'" + pInstructorSinEditar.getListaDisciplinaDeportiva().get(i).getId() + "';";
            } else {
                update
                        += "UPDATE InstructorDisciplinaDeportiva "
                        + "SET "
                        + "idDisciplinaDeportiva = " + "'" + pInstructor.getListaDisciplinaDeportiva().get(i).getId() + "' "
                        + "WHERE idInstructor = " + "'" + pInstructor.getId() + "' "
                        + "AND idDisciplinaDeportiva = " + "'" + pInstructorSinEditar.getListaDisciplinaDeportiva().get(i).getId() + "';";
            }
        }

        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }

    public int ultimoCampoDisciplinaDeportiva(int pIdInstructor)
            throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String update = "";
        int resp = 0;

        update
                += "select max(id) as id from InstructorDisciplinaDeportiva where idInstructor = "
                + pIdInstructor + ";";

        ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(update);

        while (rsPA.next()) {
            resp = rsPA.getInt("id");
        }

        //Se ejecuta la sentencia SQL
        return resp;
    }
}
