<%-- 
    Document   : MantenedorEmpleados
    Created on : Apr 7, 2017, 3:54:39 PM
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
        <title>Mantenedor Empleados</title>
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
                            
                        </ul>
                    </li>
                    <li><a href="MantenedorEmpleados">Ver Reportes</a></li>
                    <li><a href="MantenedorPersonal">Otro</a></li>
                    <a href="HomeAdmin.jsp"></a>
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
                        <%--<form action="./buscarEmpleado" method="POST" > --%>
                        <h1><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Mantenedor Empleados</h1>
                        <h2><small>Administra los Empleados existentes en el sistema</small></h2>
                        <p>Este mantenedor te permite modificar y agregar Empleados, incluyendo sus caracteristicas.</p>
                        <button type="button" class="btn btn-success" id="popup" onclick="div_show();">Formulario Ingreso</button>
                        <%-- </form>--%>
                    </div>
                </div>
                <%-- Jumbotron FIN --%> 
                <%--Inicio Tabla Mantenedor --%>
                <jsp:include page="/getAllEmpleados" flush="true"/>
                <div class="container">
                    <%--<div class="jumbotron">--%>
                    <div class="panel-body">
                        <%-- Buscador Empleados --%>
                        <div class="form-horizontal">
                            <form class="form-inline" method="GET" action="./buscarEmpleado">
                                <div class="form-group">
                                    <label class="sr-only" for="txtBuscarEmpleado">RUT Empleado</label>
                                    <input type="text" class="form-control" id="txtBuscarEmpleado" name="txtBuscarEmpleado" placeholder="Rut Empleado">
                                </div>                                    
                                <button  type="submit" class="btn btn-default" >Buscar Empleado &nbsp;<span class="glyphicon glyphicon-search"></span></button>
                            </form>
                        </div>
                        <%-- Fin Buscador--%>
                        <br>
                        <jsp:useBean id="empleado" class="duoc.cl.entidades.Empleado" scope="page"/>
                        <table class="table table-hover tablesorter" id="tableEmpleados">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>RUT</th>
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Telefono</th>
                                    <th>Direccion</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tbody id="myTableBody">
                                <c:forEach items="${listadoEmpleado}" var="empleado">
                                    <tr>
                                        <c:set var="id_empleado"><c:out value="${empleado.id_empleado}" /></c:set>
                                        <td><c:out value="${id_empleado}"/></td>       
                                        <c:set var="rut"><c:out value="${empleado.RUT}" /></c:set>
                                        <td><input type="text" id="txtRut" name="txtRut" value="${rut}"  /></td>
                                            <c:set var="nombre"><c:out value="${empleado.nombre}" /></c:set>
                                        <td><input type="text" id="txtNombre" name="txtNombre" value="${nombre}"  /></td>
                                            <c:set var="apellidos"><c:out value="${empleado.apellidos}" /></c:set>
                                        <td><input type="text" id="txtApellidos" name="txtApellidos" value="${apellidos}"  /></td>
                                            <c:set var="telefono"><c:out value="${empleado.telefono}" /></c:set>
                                        <td><input type="text" id="txtTelefono" name="txtTelefono" value="${telefono}"  /></td>
                                            <c:set var="direccion"><c:out value="${empleado.direccion}" /></c:set>
                                        <td><input type="text" id="txtDirecion" name="txtDireccion" value="${direccion}"  /></td>   
                                            <c:url var="editar" value="/editarEmpleado">
                                                <c:param name="id_empleado" value="${empleado.id_empleado}"/>                                     
                                                <c:param name="RUT" value="${param.txtRut}"/>
                                                <c:param name="Nombre" value="${param.txtNombre}"/>
                                                <c:param name="Apellidos" value="${param.txtApellidos}"/>
                                                <c:param name="telefono" value="${param.txtTelefono}"/>
                                                <c:param name="direccion" value="${param.txtDireccion}"/>   --%>                                             
                                        </c:url>
                                        <td><button type="submit" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                        <c:url var="eliminar" value="/deleteEmpleado">
                                            <c:param name="id_usuario" value="${empleado.id_empleado}"/>                                      
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

                        <c:if test="${exitoIngresoEmpleado!=null}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${exitoIngresoEmpleado}"/>
                                <c:remove var="exitoIngresoEmpleado"/>
                            </div>
                        </c:if>
                        <c:if test="${error!=null}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${error}"/>
                                <c:remove var="error"/>
                            </div>
                        </c:if>
                        <%-- fin mensajes validacion --%>
                    </div>
                </div>
                <%--</div>--%>

                <hr class='divider'>
                <%-- Formulario Nuevo Empleado --%>   
                <c:choose>
                    <c:when test="${empleadoBuscado==null}">
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formNewEmp" method="POST" action="./addEmpleado">       
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Ingreso</h3>
                                    <div class="form-group">
                                        <label for="newRUT">RUT</label>
                                        <input type="text" class="form-control" id="newRUT" name="newRUT" placeholder="17812895-7"  >
                                    </div> 
                                    <div class="form-group">
                                        <label for="newNombre">Nombre</label>
                                        <input type="text" class="form-control" id="newNombre" name="newNombre" placeholder="Mario">
                                    </div>
                                    <div class="form-group">
                                        <label for="newApellido">Apellidos</label>
                                        <input type="text" class="form-control" id="newApellido" name="newApellido" placeholder="Gomez Gonzalez">                        
                                    </div> 
                                    <div class="form-group">
                                        <label for="newTelefono">Telefono</label>
                                        <input type="text" class="form-control" id="newTelefono" name="newTelefono" placeholder="95419545" >
                                        <label style="color:red;display: none;" name="msjValTel" id="msjPassMatch"  >ingrese s&oacute;lo numeros</label>
                                    </div> 
                                    <div class="form-group">
                                        <label for="newDireccion">Direccion</label>
                                        <input type="text" class="form-control" id="newDireccion" name="newDireccion" placeholder="Coronel Pereira 1240">
                                    </div>                     
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="agregarEmp" id="agregarEmp">Agregar</button>
                                </form> 
                            </div>
                            <!-- Popup Div Ends Here -->
                        </div>
                        <%-- Formulario Nuevo Empleado Fin --%>
                    </c:when>
                    <c:otherwise>                        
                        <%-- Formulario Editar Empleado --%>
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formEditEmp" method="POST" action="./editarEmpleado">   
                                    <input type="hidden" name="hdnId_empleado" value="${empleadoBuscado.getId_empleado()}"/> 
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Modificacion</h3>
                                    <div class="form-group">
                                        <label for="modRUT">RUT</label>
                                        <input type="text" class="form-control" id="modRUT" name="modRUT" placeholder="17812895-7"    value="<c:out value="${empleadoBuscado.getRUT()}"/>" >
                                    </div> 
                                    <div class="form-group">
                                        <label for="modNombre">Nombre</label>
                                        <input type="text" class="form-control" id="modNombre" name="modNombre" placeholder="Mario" value="<c:out value="${empleadoBuscado.getNombre()}"/>">
                                    </div>
                                    <div class="form-group">
                                        <label for="modApellido">Apellidos</label>
                                        <input type="text" class="form-control" id="modApellido" name="modApellido" placeholder="Gomez Gonzalez" value="<c:out value="${empleadoBuscado.getApellidos()}"/>">                        
                                    </div> 
                                    <div class="form-group">
                                        <label for="modTelefono">Telefono</label>
                                        <input type="text" class="form-control" id="modTelefono" name="modTelefono" placeholder="95419545" value="<c:out value="${empleadoBuscado.getTelefono()}"/>">
                                        <label style="color:red;display: none;" name="msjValTel" id="msjValTel"  >ingrese s&oacute;lo numeros</label>
                                    </div> 
                                    <div class="form-group">
                                        <label for="modDireccion">Direccion</label>
                                        <input type="text" class="form-control" id="newDireccion" name="modDireccion" placeholder="Coronel Pereira 1240" value="<c:out value="${empleadoBuscado.getDireccion()}"/>">
                                    </div>                     
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="editarEmp" id="editarEmp">Agregar</button>
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
