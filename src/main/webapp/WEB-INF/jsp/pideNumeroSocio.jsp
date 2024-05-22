<%@ page import="java.sql.*" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="estilos.css" />
  </head>
  <body>
    <table>
      <tr><th>Código</th><th>Nombre</th><th>Estatura</th><th>Edad</th><th>Localidad</th></tr>
    <%
//                                                              v----RECOGER listado DE SOCIO DEL request --%>
        List<Socio> listado = (List<Socio>) request.getAttribute("listado");

//      FOR-EACH SOBRE LA COLECCIÓN DE listado DE SOCIO--%>
        for(Socio usuario: listado) {
          %>
      <tr>
<%--           v--- EXPRESIÓN ACCEDIENDO A LOS VALORES DE SOCIO--%>
        <td><%=usuario.getSocioId() %>
        </td>
        <td><%=usuario.getNombre() %>
        </td>
        <td><%=usuario.getEdad() %>
        </td>
        <td><%=usuario.getEstatura() %>
        </td>
        <td><%= usuario.getLocalidad()%>
        </td>

      <td>
      <form method="get" action="borraSocio.jsp">
        <input type="hidden" name="codigo" value="<%=usuario.getSocioId() %>"/>
        <input type="submit" value="Borrar">
      </form>
      </td></tr>
    <%

<%--    v--- FIN DEL BUCLE FOR CON HTML INCRUSTADO--%>
      } // for
     %>
    </table>
  </body>
</html>