<%-- 
    Document   : MantenedorUsuarios
    Created on : Apr 7, 2017, 10:22:49 AM
    Author     : Cami
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/theme.css" rel="stylesheet"/> 
        <link href="css/elements.css" rel="stylesheet"/> 
        <script src="js/jquery.min.js"></script> 
        <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/my_js.js"></script>
        <title>Mantenedor Usuarios</title>
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
                    <li><a href="HomeAdmin.jsp">Home <span class="sr-only">(current)</span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mantenedores <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="MantenedorUsuarios.jsp">Mantenedor Usuarios</a></li>
                            <li><a href="MantenedorEmpleados.jsp">Mantenedor Empleados</a></li>
                            <li><a href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li><a href="MantenedorUsuarios">Ver Reportes</a></li>
                    <li><a href="MantenedorPersonal">Otro</a></li>
                    <li><a href="MantenedorPacientes.jsp">Otro</a></li> 

                </ul>      
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="logOut">LogOut <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>       
                </ul>
            </div>
        </div>
    </nav>
    <%-- Barra Navegacion Fin--%> 
</head>
<body>
    <%-- Jumbotron --%>
    <div class="container">
        <div class="jumbotron">
            <h1><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Mantenedor Usuarios</h1>
            <h2><small>Administra los Usuarios existentes en el sistema</small></h2>
            <p>Este mantenedor te permite modificar y agregar usuarios, incluyendo sus caracteristicas y sus privilegios.</p>
            <button class="btn btn-success" id="popup" onclick="div_show()">Formulario Ingreso</button>
        </div>
    </div>
    <%-- Jumbotron FIN --%> 
    <%--Inicio Tabla Mantenedor --%>
    <jsp:include page="/getAllUsuarios" flush="true"/>
    <div class="container">
        <div class="jumbotron">
            <div class="panel-body">
                <jsp:useBean id="usuario" class="duoc.cl.dto.UsuarioPerfilDTO" scope="page"/>
                <table class="table table-bordered table-striped ">
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Password</td>
                            <td>Perfil</td>
                            <td>Editar</td>
                            <td>Eliminar</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listadoUsuario}" var="usuario">
                            <tr>
                                <td><c:out value="${usuario.username}"/></td>
                                <c:set var="pass"><c:out value="${usuario.password}" /></c:set>
                                <td><input type="password" value="${pass}"/> </td>
                                <td><c:out value="${usuario.descripcion}"/></td>
                                <c:url var="editar" value="/editarUsuario">
                                    <c:param name="id_usuario" value="${usuario.id_usuario}"/>
                                </c:url>
                                <td><button type="button" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                <c:url var="eliminar" value="/eliminaUsuario">
                                    <c:param name="id_usuario" value="${usuario.id_usuario}"/>
                                </c:url>
                                <td><button type="button" class="btn btn-xs btn-danger" onclick="window.location.href = '${eliminar}'">Eliminar</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <%-- Fin Tabla Mantenedor --%>
                <%-- Buscador Usuarios --%>
                <div class="form-horizontal">
                    <form class="form-inline">
                        <div class="form-group">
                            <label class="sr-only" for="txtBuscaUsuario">Nombre Usuario</label>
                            <input type="text" class="form-control" id="txtBuscaUsuario" name="txtBuscaUsuario" placeholder="Nombre Usuario">
                        </div>                                    
                        <button type="submit" class="btn btn-default">Buscar por usuario</button>
                        <button type="button" class="btn btn-primary" onclick="window.location.href = 'AgregarUsuario.jsp'">Agregar</button>
                    </form>
                </div>
                <c:if test="${exitoIngresoUsuario!=null}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${exitoIngresoUsuario}"/>
                        <c:remove var="exitoIngresoUsuario"/>
                    </div>
                </c:if>
                <c:if test="${error!=null}">
                    <div class="alert alert-danger" role="alert">
                        <c:out value="${error}"/>
                        <c:remove var="error"/>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <%-- Fin Buscador--%>
    <hr class='divider'>
    <%-- Formulario Nuevo Usuario --%>    
     <div id="abc" style="overflow:hidden;">
            <!-- Popup Div Starts Here -->
            <div id="popupContact">
                <!-- Contact Us Form -->
                <form class="form-horizontal" id="formNewUser" method="POST" action="./addUsuario">       
                    <img id="close" src="img/3.png" onclick ="div_hide()">
                    <h3>Formulario de Ingreso</h3>
                    <div class="form-group">
                        <label for="newUsername">Username</label>
                        <input type="text" class="form-control" id="newUsername" name="newUsername" placeholder="Red Dwarf">
                    </div>
                    <div class="form-group">
                        <label for="newPass">Password</label>
                        <input type="password" class="form-control" id="newPass" name="newPass" placeholder="Password">
                    </div> 
                    <div class="form-group">
                        <label for="newPass2">Re-enter Password</label>
                        <input type="password" class="form-control" id="newPass2" name="newPass2" placeholder="Password" onchange='check_pass();'>
                        <label style="color:red;display: none;" name="msjPassMatch" id="msjPassMatch"  >Passwords no coinciden, intentelo denuevo</label>
                    </div> 
                    <div class="form-group">
                        <label for="newPerfil">Profile</label>
                        <select class="form-control" id="newPerfil" name="newPerfil">
                            <option value="1">Administrator</option>
                            <option value="2">Supervisor</option>
                            <option value="3">Capataz</option>
                            <option value="4">Obrero</option>
                        </select>
                    </div>
                    <button style="width:100%;" type="submit" class="btn btn-primary" name="agregarUser" id="agregarUser">Agregar</button>
                </form> 
            </div>
            <!-- Popup Div Ends Here -->
        </div>
    <%-- Formulario Nuevo Usuario Fin --%>

</body>
</html>
