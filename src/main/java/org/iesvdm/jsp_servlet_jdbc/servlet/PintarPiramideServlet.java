package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.UsuarioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.UsuarioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Usuario;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PintarPiramideServlet", value = "/PintarPiramideServlet")
public class PintarPiramideServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //USAMOS REQUEST.GETPARAMETER PARA RECIBIR EL ID, Y CON EL DAO, BORRAMOS AL USUARIO
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        //PREPARAMOS EL LISTADO Y LO PONEMOS COMO ATRIBUTO PARA QUE LISTADOJSP PUEDA USARLO OTRA VEZ
        request.setAttribute("cantidad", cantidad);

        //CREAMOS UNA REDIRECCION, QUE ADEMAS, MANDARA LOS OBJETOS QUE HEMOS DEFINIDO CON EL REQUEST
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/paginaUsuario.jsp");
        dispatcher.forward(request, response);
    }
}