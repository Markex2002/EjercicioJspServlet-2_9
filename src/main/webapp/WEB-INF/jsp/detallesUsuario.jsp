<%@ page import="java.sql.*" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario"%>
<%@ page import="org.iesvdm.jsp_servlet_jdbc.model.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles Usuario</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="estilos.css" />
    <link rel="stylesheet" type="text/css" href="css/backtop.css" />
</head>
<body class="bg-light">

<!-- BackToTop Button -->
<a href="javascript:void(0);" id="backToTop" class="back-to-top">
    <i class="arrow"></i><i class="arrow"></i>
</a>

<%
    //Pedimos al usuario que hemos encontrado
    Usuario usuario = (Usuario) request.getAttribute("usuarioEncontrado");
%>

<div class="container bg-white sticky-top">
    <h1>GestiBank</h1>

    <hr>

    <div id="<%=usuario.getUsuarioId()%>" class="row mt-2 body bg-white">
        <div class="row align-self-center">Codigo: <%=usuario.getUsuarioId() %>
        </div>
        <div class="row align-self-center">Nombre: <%=usuario.getNombre() %>
        </div>
        <div class="row align-self-center">Password: <%=usuario.getPassword() %>
        </div>

        <form class="align-self-center my-4" action="ListarUsuariosServlet">
            <button type="submit">ACEPTAR</button>
        </form>
    </div>
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
