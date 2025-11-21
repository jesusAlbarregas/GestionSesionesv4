package es.albarregas.models;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jesus
 */
public class Utilities {

    public static Boolean camposVacios(Enumeration<String> campos, HttpServletRequest request) {

        Boolean error = false;
        while (campos.hasMoreElements() && !error) {
            String nombre = campos.nextElement();
            if (request.getParameter(nombre).length() == 0) {
                error = true;
            }
        }
        return error;
    }

}
