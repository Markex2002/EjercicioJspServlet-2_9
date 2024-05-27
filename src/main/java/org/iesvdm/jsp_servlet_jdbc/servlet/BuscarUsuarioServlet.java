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
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BuscarUsuarioServlet", value = "/BuscarUsuarioServlet")
public class BuscarUsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoUsuariosB.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoNombreUsuarios.jsp");
        String nombre = request.getParameter("nombre");

        List<Usuario> listado = this.usuarioDAO.getAll();
        List<Usuario> usuariosEncontrados = new ArrayList<>();
        request.setAttribute("listado", listado);


        //Primero comprobamos que el usuario exista realmente, comparando nombres y Contraseñas
        for (Usuario usuario : listado) {
            if (usuario.getNombre().contains(nombre)){
                usuariosEncontrados.add(usuario);
            }
        }

        if (usuariosEncontrados.size() == 1){
            request.setAttribute("usuarioEncontrado", usuariosEncontrados.get(0));
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallesUsuario.jsp");
        } else if (usuariosEncontrados.size() > 1){
            request.setAttribute("usuariosEncontrados", usuariosEncontrados);
        }

        dispatcher.forward(request, response);
    }
}