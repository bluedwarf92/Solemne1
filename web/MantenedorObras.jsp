<%-- 
    Document   : MantenedorObras
    Created on : Apr 11, 2017, 5:06:27 PM
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
        <script src="js/bootrsap-pagination-table.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/my_js.js"></script>
        <title>Mantenedor Obras</title>
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
                            <li><a href="MantenedorObras.jsp">Mantenedor Obras</a></li>
                            <li><a href="MantendorTipoObras.jsp">Mantenedor Tipo Obras</a></li>
                        </ul>
                    </li>
                    <li><a href="MantenedorEmpleados">Ver Reportes</a></li>
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

    <%-- paginador tabla --%>
    <script>
        $(document).ready(function () {

            $('#myTableBody').pageMe({pagerSelector: '#myPager', showPrevNext: true, hidePageNumbers: false, perPage: 5});

        });
    </script>
    <%-- paginador tabla fin --%>
    <body>
        <c:choose>
            <c:when test="${usuarioConectado!=null}">
                <%-- Jumbotron --%>
                <div class="container">
                    <div class="jumbotron">
                        <%--<form action="./buscarObra" method="POST" > --%>
                        <h1><span class="glyphicon glyphicon-road" aria-hidden="true"></span> Mantenedor Obras</h1>
                        <h2><small>Administra las Obras existentes en el sistema</small></h2>
                        <p>Este mantenedor te permite modificar y agregar Obras</p>
                        <button type="button" class="btn btn-success" id="popup" onclick="div_show();">Formulario Ingreso</button>
                        <%-- </form>--%>
                    </div>
                </div>
                <%-- Jumbotron FIN --%> 
                <%--Inicio Tabla Mantenedor --%>
                <jsp:include page="/getAllObras" flush="true"/>
                <div class="container">
                    <%--<div class="jumbotron">--%>
                    <div class="panel-body">
                        <%-- Buscador Usuarios --%>
                        <div class="form-horizontal">
                            <form class="form-inline" method="GET" action="./buscarObra">
                                <div class="form-group">
                                    <label class="sr-only" for="txtBuscarObra">Buscar Obra Por Capataz</label>
                                    <input type="text" class="form-control" id="txtBuscarObra" name="txtBuscarObra" placeholder="Username">
                                </div>                                    
                                <button  type="submit" class="btn btn-default" >Buscar Usuario&nbsp;<span class="glyphicon glyphicon-search"></span></button>
                            </form>
                        </div>
                        <%-- Fin Buscador--%>
                        <br>
                        <jsp:useBean id="obra" class="duoc.cl.entidades.Obra" scope="page"/>
                        <table class="table table-hover tablesorter" id="tableUsuarios">
                            <thead>
                                <tr>
                                    <th>id Obra</th>
                                    <th>Tipo Obra</th>
                                    <th>Descripcion</th>
                                    <th>Direccion</th>
                                    <th>Valor Hora</th>
                                    <th>Fecha Inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>                                    
                                </tr>
                            </thead>
                            <tbody id="myTableBody">
                                <c:forEach items="${listadoObras}" var="obra">
                                    <tr>                                       
                                        <td><c:out value="${usuario.id_usuario}" /></td>       
                                        <c:set var="username"><c:out value="${usuario.username}" /></c:set>
                                        <td><input type="text" id="txtUsername" name="txtUsername" value="${username}"  /></td>
                                            <c:set var="password"><c:out value="${usuario.password}" /></c:set>
                                        <td><input type="password" id="txtPassword" name="txtPassword" value="${password}"  /></td>
                                            <c:set var="id_perfil"><c:out value="${usuario.id_perfil}" /></c:set>
                                            <td> <select>
                                                <c:choose>
                                                    <c:when test="${usuario.id_perfil == 1}"><option value="1" selected="true">Administrador</option>
                                                        <option value="2">Supervisor</option><option value="3">Capataz</option><option value="4">Obrero</option></c:when>
                                                    <c:when test="${usuario.id_perfil == 2}"><option value="1" >Administrador</option>
                                                        <option value="2" selected="true">Supervisor</option><option value="3">Capataz</option><option value="4">Obrero</option></c:when>
                                                    <c:when test="${usuario.id_perfil == 3}"><option value="1" >Administrador</option>
                                                        <option value="2" >Supervisor</option><option value="3" selected="true">Capataz</option><option value="4">Obrero</option></c:when>
                                                    <c:when test="${usuario.id_perfil == 4}"><option value="1" >Administrador</option>
                                                        <option value="2" >Supervisor</option><option value="3" >Capataz</option><option value="4" selected="true">Obrero</option></c:when>
                                                    <c:otherwise>
                                                        <option value="1" >Administrador</option>
                                                        <option value="2" >Supervisor</option>
                                                        <option value="3" >Capataz</option>
                                                        <option value="4" >Obrero</option>
                                                    </c:otherwise>
                                                </c:choose></select>                               
                                        </td><td><c:out value="${usuario.id_empleado}" /></td>

                                        <c:url var="editar" value="/editarUsuario">
                                            <c:param name="id_usuario" value="${usuario.id_usuario}"/>                                                                    
                                        </c:url>
                                        <td><button type="submit" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                        <c:url var="eliminar" value="/deleteUsuario">
                                            <c:param name="id_usuario" value="${usuario.id_usuario}"/>                                      
                                        </c:url>
                                        <td><button type="button" class="btn btn-xs btn-danger" onclick="window.location.href = '${eliminar}'">Eliminar</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <%-- paging --%>
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager"></ul>
                        </div>
                        <%-- end paging --%>
                        <%-- Fin Tabla Mantenedor --%>               
                        <%-- mensajes de validacion --%>
                        <br><hr> <div class="clearfix"></div>
                        
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
                        <c:if test="${error1!=null}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${error1}"/>
                                <c:remove var="error1"/>
                            </div>
                        </c:if>
                        
                        <%-- fin mensajes validacion --%>
                    </div>
                </div>
                <%--</div>--%>

                <hr class='divider'>
                <%-- Formulario Nuevo Usuario --%>   
                <c:choose>
                    <c:when test="${usuarioBuscado==null}">
                        <jsp:include page="/getAllEmpleadoSinUs" flush="true" />
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formNewUsuario" name="formNewUsuario" method="POST" action="./addUsuario">       
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Ingreso</h3>
                                    <div class="form-group">
                                        <label for="newUsername">Username</label>
                                        <input type="text" class="form-control" id="newUsername" name="newUsername" placeholder="Nombre usuario"  >
                                    </div> 
                                    <div class="form-group">
                                        <label for="newPass">Password</label>
                                        <input type="password" class="form-control" id="newPass" name="newPass" placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <label for="newPass2">Re-enter Password</label>
                                        <input type="password" class="form-control" id="newPass2" name="newPass2" placeholder="Password" onchange="check_pass();">  
                                    </div> 
                                    <label id="msjPassMatch" name="msjPassMatch" style="color:red;display: none;">Passwords incorrectas, intentelo denuevo.</label>
                                    <div class="form-group">
                                        <select class="form-control " id="id_empleado" name="ddlEmpleados">
                                            <option value="0"><c:out value="--Seleccione Empleado--"/></option>
                                            <c:forEach items="${listadoEmpleados}" var="empleados">
                                                <option value="${empleados.getId_empleado()}"><c:out value="${empleados.getNombre()}"/>&nbsp;<c:out value="${empleados.getApellidos()}"/></option>
                                            </c:forEach>
                                        </select>   
                                    </div>                                    
                                    <div class="form-group">
                                        <label for="newPerfil">Perfil</label>
                                        <select id="newPerfil" name="newPerfil">
                                            <option value="1">Administrador</option>
                                            <option value="2">Supervisor</option>
                                            <option value="3">Capataz</option>
                                            <option value="4">Obrero</option>
                                        </select>
                                    </div>                     
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="agregarUsuario" id="agregarUsuario">Agregar</button>
                                </form> 
                            </div>
                            <!-- Popup Div Ends Here -->
                        </div>
                        <%-- Formulario Nuevo Usuario Fin --%>
                    </c:when>
                    <c:otherwise>                        
                        <%-- Formulario Editar Usuario --%>
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formEditUs" method="POST" action="./editarUsuario">   
                                    <input type="hidden" name="hdnId_usuario" value="${usuarioBuscado.getId_usuario()}"/> 
                                    <input type="hidden" name="hdnId_empleado" value="${usuarioBuscado.getId_empleado()}"/> 
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Modificacion</h3>
                                    <div class="form-group">
                                        <label for="modUsername">Username</label>
                                        <input type="text" class="form-control" id="modUsername" name="modUsername" placeholder="Nombre de Usuario"    value="<c:out value="${usuarioBuscado.getUsername()}"/>" >
                                    </div> 
                                    <div class="form-group">
                                        <label for="modPassword">Password</label>
                                        <input type="text" class="form-control" id="modPassword" name="modPassword" placeholder="Mario" value="<c:out value="${usuarioBuscado.getPassword()}"/>">
                                    </div>
                                     <div class="form-group">
                                        <label for="modPerfil">Perfil</label>
                                        <select id="modPerfil" name="modPerfil">
                                            <option value="1">Administrador</option>
                                            <option value="2">Supervisor</option>
                                            <option value="3">Capataz</option>
                                            <option value="4">Obrero</option>
                                        </select>
                                    </div>                                            
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="editarUsuario" id="editarUsuario">Agregar</button>
                                </form> 
                            </div>
                            <!-- Popup Div Ends Here -->
                        </div>
                        <%-- Formulario Editar Empleado Fin --%>
                        <script type="text/javascript">
                        document.getElementById('abc').style.display = "block";
                        </script>
                    </c:otherwise>
                </c:choose>

            </c:when>
            <c:otherwise>
                <c:redirect url="Login.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </body>
</html>
