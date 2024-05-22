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

@WebServlet(name = "IniciarSesionServlet", value = "/IniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/iniciarSesion.jsp");

        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/iniciarSesion.jsp");
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        boolean usuarioExistente = false;

        List<Usuario> listado = this.usuarioDAO.getAll();
        request.setAttribute("listado", listado);


        //Primero comprobamos que el usuario exista realmente, comparando nombres y Contraseñas
        for (Usuario usuario : listado) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
                usuarioExistente = true;
            }
        }

        //Si existe, comprobamos si es un admin o no
        if (usuarioExistente){
            if (nombre.equals("admin")){
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/paginaAdmin.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/paginaUsuario.jsp");
            }
        } else {
            request.setAttribute("error", "Error de validación!");
        }



        dispatcher.forward(request, response);
    }
}