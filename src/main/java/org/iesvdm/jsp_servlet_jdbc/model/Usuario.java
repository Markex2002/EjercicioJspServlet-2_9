package org.iesvdm.jsp_servlet_jdbc.model;

import java.util.Objects;

/**
 * POJO o BEAN QUE REPRESENTA LA TABLA socio
 */
public class Usuario {

    private int usuarioId;
    private String nombre;
    private String password;

    public Usuario() {
    }

    public Usuario(int usuarioId, String nombre, String password) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.password = password;
    }

    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return usuarioId == usuario.usuarioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", password=" + password +
                '}';
    }
}
