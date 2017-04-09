<%-- 
    Document   : HomeAdmin
    Created on : Apr 7, 2017, 9:06:06 AM
    Author     : Cami
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>       
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>                       
        <link href="css/theme.css" rel="stylesheet"/>       
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Home Administrador</title>
        <%-- Barra Navegacion --%>
    <nav class="navbar navbar-default">
        <div class="container-fluid">  
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">SGA</a>
            </div>   
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="HomeAdmin.jsp">Home <span class="sr-only">(current)</span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mantenedores <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="MantenedorUsuarios.jsp">Mantenedor Usuarios</a></li>
                            <li><a href="MantenedorEmpleados.jsp">Mantenedor Empleados</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                    <li><a href="MantenedorUsuarios">Ver Reportes</a></li>
                    <li><a href="MantenedorPersonal">Otro</a></li>
                    <li><a href="MantenedorPacientes.jsp">Otro</a></li> 
                    </li>
                </ul>      
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="logOut">LogOut <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>       
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <%-- Barra Navegacion Fin--%> 
</head>
<body>
<c:choose>
    <c:when test="${usuarioConectado!=null}">
        <%-- Jumbotron --%>
        <div class="container">
            <div class="jumbotron">
                <h2>Hola, <label style="color:#1B689E"><c:if test="${datosEmpleado!=null}"><c:out value="${datosEmpleado.getNombre()}"/>&nbsp<c:out value="${datosEmpleado.getApellidos()}"/></c:if></label></h2>
                <p>Bienvenido a home Administrador, donde podrás gestionar todos los datos utilizados en este sistema.</p>
            </div></div>
            <%-- Jumbotron fin --%>
    </c:when>
    <c:otherwise>
        <c:redirect url="Login.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
