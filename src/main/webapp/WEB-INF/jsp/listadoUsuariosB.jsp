<%@ page import="java.sql.*" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario"%>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Socios</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="estilos.css" />
    <link rel="stylesheet" type="text/css" href="css/backtop.css" />
</head>
<body class="bg-light">

<!-- BackToTop Button -->
<a href="javascript:void(0);" id="backToTop" class="back-to-top">
    <i class="arrow"></i><i class="arrow"></i>
</a>

<div class="container bg-white sticky-top">
    <div class="row mb-2 border-bottom">
        <div class="col-md-8 h1">Listado de Usuarios</div>
        <form class="col-md-2 align-self-center" action="IniciarSesionServlet">
            <button type="submit">Volver</button>
        </form>
        <div class="col-md-2 align-self-center" ><form method="get" action="GrabarUsuariosServlet">
            <input class="btn btn-primary"  type="submit" value="Crear Socio">
        </form></div>
    </div>
    <div class="row">
        <div class="col-md-1 h3">ID</div>
        <div class="col-md-3 h3">Nombre</div>
        <div class="col-md-6 h3">Password</div>
        <div class="col-md-2 h3 text-center">Operación</div>
    </div>
</div>

<div class="container bg-light">
    <%
    //                                                          v----RECOGER listado DE SOCIO DEL request
    List<Usuario> listado = (List<Usuario>) request.getAttribute("listado");
    // FOR-EACH SOBRE LA COLECCIÓN DE listado DE SOCIO
    for (Usuario usuario : listado) {
    %>
    <div id="<%=usuario.getUsuarioId()%>" class="row mt-2 body">
        <div class="col-md-1 align-self-center"><%=usuario.getUsuarioId() %>
        </div>
        <div class="col-md-3 align-self-center"><%=usuario.getNombre() %>
        </div>
        <div class="col-md-6 align-self-center"><%=usuario.getPassword() %>
        </div>

        <div class="col-md-2 align-self-center text-center">
            <form class="d-inline" method="post" action="BorrarSociosServlet">
                <input type="hidden" name="codigo" value="<%=usuario.getUsuarioId() %>"/>
                <input class="btn btn-primary"  type="submit" value="Borrar">
            </form>
            <form class="d-inline" method="get" action="EditarUsuariosServlet">
                <input type="hidden" name="codigo" value="<%=usuario.getUsuarioId() %>"/>
                <input class="btn btn-primary"  type="submit" value="Editar">
            </form>
        </div>
    </div>
        <%
      //v--- FIN DEL BUCLE FOR CON HTML INCRUSTADO
    } // for
    %>

    <hr>

    <form method="post" action="GrabarUsuariosServlet">
        <h2>Crear Usuario</h2>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Nombre</div>
            <div class="col-md-6 align-self-center"><input type="text" name="nombre"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">password</div>
            <div class="col-md-6 align-self-center"><input type="text" name="password"/></div>
        </div>
        <div class="row mt-2">
            <div class="col-md-6">
                &nbsp;
            </div>
            <div class="col-md-6 align-self-center">
                <input class="btn btn-primary" type="submit" value="Aceptar">
            </div>
        </div>
    </form>

    <hr>

    <h2>Buscar Usuario</h2>
    <form method="post" action="BuscarUsuarioServlet" class="row mt-2 my-4">
        <label class="col-4"><input type="text" name="nombre"></label>
        <input class="col-2" type="submit">
    </form>
</div>

<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript">
    $(function (){
        //IMPLEMENTANDO UN BOTÓN backToTop
        let btn = $('#backToTop');
        $(window).on('scroll', function() {
            if ($(window).scrollTop() > 300) {
                btn.addClass('show');
            } else {
                btn.removeClass('show');
            }
        });
        btn.on('click', function(e) {
            e.preventDefault();
            $('html, body').animate({
                scrollTop: 0
            }, '300');
        });
    });

</script>
<%
    Integer newSocioID = (Integer) request.getAttribute("newSocioID");
    if (newSocioID != null) {
%>

<div class="modal fade" id="newSocioIDModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Grabar Socio</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Grabado correctamente usuario con ID <%=newSocioID%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary close" data-dismiss="modal">Cerrar</button>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    //DINAMISMO CON JQUERY..
    //CUANDO SE CARGA EL DOM JQUERY EJECUTA SOBRE SELECTOR DE CAPA MODAL AL MODAL
    $(function (){
        $('#newSocioIDModal').modal('show');
        $('#newSocioIDModal').on('click', 'button.close', function (eventObject) {
            $('#newSocioIDModal').modal('hide');

            //PARA HACER SMOOTH SCROLL AL ELEMENTO NUEVO ELEMENTO EN LA PÁGINA
            $('html, body').animate({
                scrollTop: $('#<%=newSocioID%>').offset().top
            }, 2000, () => $('#<%=newSocioID%>').addClass('highlight'));
        });
    });
</script>
<% } %>
<script type="text/javascript" src="js/bootstrap.bundle.js" ></script>
</body>
</html>
