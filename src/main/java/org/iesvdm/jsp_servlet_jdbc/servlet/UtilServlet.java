package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.iesvdm.jsp_servlet_jdbc.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

public class UtilServlet {

    public static Optional<Usuario> validaGrabar(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        //int socioID = -1;
        String nombre = null;
        String password = null;
        try {

            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            Objects.requireNonNull(request.getParameter("nombre"));
            //CONTRACT nonBlank..
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("nombre").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            nombre = request.getParameter("nombre");



            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            Objects.requireNonNull(request.getParameter("password"));
            //CONTRACT nonBlank
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("password").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            password = request.getParameter("password");

            return Optional.of(new Usuario(-1, nombre, password));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }


    public static Optional<Usuario> validaEDitar(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        int socioID = -1;
        String nombre = null;
        String password = null;
        try {

            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            Objects.requireNonNull(request.getParameter("nombre"));
            //CONTRACT nonBlank..
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("nombre").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            nombre = request.getParameter("nombre");



            //UTILIZO LOS CONTRACTS DE LA CLASE Objects PARA LA VALIDACIÓN
            //             v---- LANZA NullPointerException SI EL PARÁMETRO ES NULL
            Objects.requireNonNull(request.getParameter("password"));
            //CONTRACT nonBlank
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("password").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            password = request.getParameter("password");

            socioID = Integer.parseInt(request.getParameter("socioID"));

            return Optional.of(new Usuario(socioID, nombre, password));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();
    }





    /**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:
     8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password ) throws NoSuchAlgorithmException {
        MessageDigest digest;

        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] byteHash) {

        StringBuilder hexString = new StringBuilder(2 * byteHash.length);
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}