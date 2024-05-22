package org.iesvdm.jsp_servlet_jdbc.dao;

import org.iesvdm.jsp_servlet_jdbc.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {

    public void create(Usuario usuario);

    public List<Usuario> getAll();
    public Optional<Usuario> find(int id);

    public void update(Usuario usuario);

    public void delete(int id);
}
