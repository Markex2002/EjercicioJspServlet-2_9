package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.iesvdm.jsp_servlet_jdbc.model.Usuario;

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
            Objects.requireNonNull(request.getParameter("localidad"));
            //CONTRACT nonBlank
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("localidad").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            password = request.getParameter("localidad");

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
            Objects.requireNonNull(request.getParameter("localidad"));
            //CONTRACT nonBlank
            //UTILIZO isBlank SOBRE EL PARÁMETRO DE TIPO String PARA CHEQUEAR QUE NO ES UN PARÁMETRO VACÍO "" NI CADENA TODO BLANCOS "    "
            //          |                                EN EL CASO DE QUE SEA BLANCO LO RECIBIDO, LANZO UNA EXCEPCIÓN PARA INVALIDAR EL PROCESO DE VALIDACIÓN
            //          -------------------------v                      v---------------------------------------|
            if (request.getParameter("localidad").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            password = request.getParameter("localidad");

            socioID = Integer.parseInt(request.getParameter("socioID"));

            return Optional.of(new Usuario(socioID, nombre, password));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }
}
