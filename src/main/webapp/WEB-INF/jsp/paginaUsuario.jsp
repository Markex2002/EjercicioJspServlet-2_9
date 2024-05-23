<%--
  Created by IntelliJ IDEA.
  User: marcom
  Date: 22/5/24
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Usuario</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="estilos.css" />
    <link rel="stylesheet" type="text/css" href="css/backtop.css" />
</head>
<body>

<div class="container bg-light">
    <h1>Pagina del Usuario</h1>
    <form action="IniciarSesionServlet">
        <button type="submit">Volver</button>
    </form>

    <form method="post" action="PintarPiramideServlet">
        <div class="row body mt-2">
            <div class="col-md-3 align-self-center">Pinta una Pirámide</div>
            <div class="col-md-9 align-self-center"><label>
                <input type="number" name="cantidad"/>
            </label></div>
        </div>
        <div class="col-md-6 align-self-center py-4">
            <input class="btn btn-primary" type="submit" value="Aceptar">
        </div>
    </form>
</div>

<%
    //PILLAMOS LA CANTIDAD QUE NOS HA REENVIADO EL SERVLET Y LA UTILIZAMOS
    if (request.getParameter("cantidad") != null){
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        //COMPROBAMOS QUE SI HAYA UNA CANTIDAD ENVIADA
        if (cantidad >= 0) {
            for (int i = 1; i <= cantidad; i++) {
%><p><%
                // Imprimir espacios
                for (int j = cantidad; j > i; j--) {
    %><img src="imgs/vacio.png"> <%
                }
                // Imprimir asteriscos
                for (int k = 1; k <= (2 * i - 1); k++) {
%> <img src="imgs/906sm.png"> <%
                }
                // Salto de línea para la siguiente fila
%></p><%
            }
        }
    }
%>











</body>
</html>
