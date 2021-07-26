package utilitario;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorFormatos {
    //Atributos a nivel de la clase
    private static String mensajeError;

    /**
     * Validar si un hilera es formato n�merica entera
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo entera
     */
    public static boolean validarEntero(String pValor) {
        boolean vResultado = false;
        int vValor = 0;

        try {
            mensajeError = "";
            vValor = Integer.parseInt(pValor);
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }

    /**
     * Validar si un hilera es formato n�merica double
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo double
     */
    public static boolean validarDouble(String pValor) {
        boolean vResultado = false;
        double vValor = 0d;

        try {
            mensajeError = "";
            vValor = Double.parseDouble(pValor);
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }

    /**
     * Validar si un hilera es formato n�merica float
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo float
     */
    public static boolean validarFloat(String pValor) {
        boolean vResultado = false;
        double vValor = 0f;

        try {
            mensajeError = "";
            vValor = Float.parseFloat(pValor);
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }

    /**
     * Validar si un hilera es formato fecha --> dd/MM/yyyy
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo fecha
     */
    public static boolean validarFecha(String pValor) {
        SimpleDateFormat vFechaFormato = new SimpleDateFormat("dd/MM/yyyy");
        boolean vResultado = false;
        Date vValor;

        try {
            // El m�todo parse devuelve null si no se ha podido parsear el string en seg�n
            // el formato indicado. Este m�todo lanza una excepci�n NullPointer exception
            // si alguno de sus par�metros es null
            Date vFecha = vFechaFormato.parse(pValor, new ParsePosition(0));
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }

    /**
     * Validar si un hilera es formato fecha + hora --> dd/MM/yyyy HH:mm
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo fecha + hora
     */
    public static boolean validarFechaHora(String pValor) {
        SimpleDateFormat vFechaFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        boolean vResultado = false;
        Date vValor;

        try {
            // El m�todo parse devuelve null si no se ha podido parsear el string en seg�n
            // el formato indicado. Este m�todo lanza una excepci�n NullPointer exception
            // si alguno de sus par�metros es null
            Date vFecha = vFechaFormato.parse(pValor, new ParsePosition(0));
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }

    /**
     * Validar si un hilera es formato fecha + hora:segundos --> dd/MM/yyyy HH:mm:ss
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera es tipo fecha + hora:segundos
     */
    public static boolean validarFechaHoraSegundos(String pValor) {
        SimpleDateFormat vFechaFormato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        boolean vResultado = false;
        Date vValor;

        try {
            // El m�todo parse devuelve null si no se ha podido parsear el string en seg�n
            // el formato indicado. Este m�todo lanza una excepci�n NullPointer exception
            // si alguno de sus par�metros es null
            Date vFecha = vFechaFormato.parse(pValor, new ParsePosition(0));
            vResultado = true;
        } catch (Exception e) {
            mensajeError = e.toString();
        }
        return vResultado;
    }
    
    /**
     * Validar si un hilera est� vac�a
     * @param pValor Hilera a evaluar
     * @return True si el contenido de la hilera est� vaci�
     */    
    public static boolean validarVacio(String pValor){
        boolean vResultado = false;
        
        if (pValor.trim().length()<=0){
            vResultado = true;
        }
                
        return vResultado;
    }
    
    /**
     * Rellena una hilera con espacios vac�os al final
     * y retorna la hilera con el tama�o indicado
     * @param pValor Hilera a modificar
     * @param pTamanno Tama�a m�ximo de la hilera
     * @return Hilera rellenada con espacios en blanco al final
     */
    public static String rellenarHilera(String pValor, int pTamanno){
        String vResultado = pValor.trim();
        
        for (int i=0; i<= pTamanno; i++){
            vResultado += " ";
        }
        return vResultado.substring(0, pTamanno);
    }
    
    /**
     * Retornar el �ltimo mensaje de error ocurrido en la clase
     * @return Mensaje del error
     */
    public static String getMensajeError(){
        return mensajeError;
    }
}
