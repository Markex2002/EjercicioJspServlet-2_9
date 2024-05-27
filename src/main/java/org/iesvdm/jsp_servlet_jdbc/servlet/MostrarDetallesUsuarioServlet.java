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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MostrarDetallesUsuarioServlet", value = "/MostrarDetallesUsuariosServlet")
public class MostrarDetallesUsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detallesUsuario.jsp");
        int codigo = Integer.parseInt(request.getParameter("codigo"));

        List<Usuario> listado = this.usuarioDAO.getAll();
        request.setAttribute("listado", listado);
        Usuario usuarioEncontrado = null;


        //Primero comprobamos que el usuario exista realmente, comparando nombres y Contraseñas
        for (Usuario usuario : listado) {
            if (usuario.getUsuarioId() == codigo){
                usuarioEncontrado = usuario;
            }
        }

        request.setAttribute("usuarioEncontrado", usuarioEncontrado);

        dispatcher.forward(request, response);
    }
}