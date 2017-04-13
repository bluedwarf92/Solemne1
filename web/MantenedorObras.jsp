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
                        <%-- Buscador Obras --%>
                        <div class="form-horizontal">
                            <form class="form-inline" method="GET" action="./buscarObra">
                                <div class="form-group">
                                    <label class="sr-only" for="txtBuscarObra">Buscar Obra Por Capataz</label>
                                    <input type="text" class="form-control" id="txtBuscarObra" name="txtBuscarObra" placeholder="Username">
                                </div>                                    
                                <button  type="submit" class="btn btn-default" >Buscar Obra&nbsp;<span class="glyphicon glyphicon-search"></span></button>
                            </form>
                        </div>
                        <%-- Fin Buscador--%>
                        <br>
                        <jsp:useBean id="obra" class="duoc.cl.entidades.Obra" scope="page"/>
                        <table class="table table-hover tablesorter" id="tableObra">
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
                                <c:forEach items="${listadoObra}" var="obra">
                                    <tr>                                       
                                        <td><c:out value="${obra.id_obra}" /></td>                                          
                                        <td> <select>
                                                <c:choose>
                                                    <c:when test="${obra.id_tipo_obra == 1}"><option value="1" selected="true">Residencial</option>
                                                        <option value="2">Comercial</option><option value="3">Industrial</option><option value="4">Obras Publicas</option></c:when>
                                                    <c:when test="${obra.id_tipo_obra == 2}"><option value="1" >Residencial</option>
                                                        <option value="2" selected="true">Comercial</option><option value="3">Industrial</option><option value="4">Obras Publicas</option></c:when>
                                                    <c:when test="${obra.id_tipo_obra == 3}"><option value="1" >Residencial</option>
                                                        <option value="2" >Comercial</option><option value="3" selected="true">Industrial</option><option value="4">Obras Publicas</option></c:when>
                                                    <c:when test="${obra.id_tipo_obra == 4}"><option value="1" >Residencial</option>
                                                        <option value="2" >Comercial</option><option value="3" >Industrial</option><option value="4" selected="true">Obras Publicas</option></c:when>
                                                    <c:otherwise>
                                                        <option value="1" >Residencial</option>
                                                        <option value="2" >Comercial</option>
                                                        <option value="3" >Industrial</option>
                                                        <option value="4" >Obras Publicas</option>
                                                    </c:otherwise>
                                                </c:choose></select>                               
                                        </td>
                                        <c:set var="descripcion"><c:out value="${obra.descripcion}" /></c:set>
                                        <td><input type="text" id="txtDescripcion" name="txtDescripcion" value="${descripcion}"  /></td>
                                        <c:set var="direccion"><c:out value="${obra.direccion}" /></c:set>
                                        <td><input type="text" id="txtDireccion" name="txtDireccion" value="${direccion}"  /></td>
                                        <c:set var="valor_hora"><c:out value="${obra.valor_hora}" /></c:set>
                                        <td><input type="text" id="txtValorHora" name="txtValorHora" value="${valor_hora}"  /></td>
                                        <td><c:out value="${obra.fecha_inicio}" /></td>
                                        <td><c:out value="${obra.fecha_fin}" /></td>
                                        <c:url var="editar" value="/editarObra">
                                            <c:param name="id_obra" value="${obra.id_obra}"/>                                                                    
                                        </c:url>
                                        <td><button type="submit" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                        <c:url var="eliminar" value="/deleteObra">
                                            <c:param name="id_obra" value="${obra.id_obra}"/>                                      
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
                        
                        <c:if test="${exitoIngresoObra!=null}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${exitoIngresoObra}"/>
                                <c:remove var="exitoIngresoObra"/>
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
                <%-- Formulario Nueva Obra --%>   
                <c:choose>
                    <c:when test="${obraBuscada==null}">
                        <jsp:include page="/getAllTipoObra" flush="true" />
                        <jsp:include page="/getAllRegiones" flush="true" />
                         <jsp:include page="/getAllCiudades" flush="true" />
                        <script>
                            function getval(sel)
                                {
                                alert(sel.value);
                                var valorIdRegion = sel.value;
                                document.getElementById('id_regionS').value = valorIdRegion;                               
                                document.getElementById('ddlCiudades').style.display='block';
                                }
                        </script>
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formNewObra" name="formNewObra" method="POST" action="./addObra">       
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Ingreso</h3>
                                    <div class="form-group">
                                        <select class="form-control " id="id_tipo_obra" name="ddlTipoObras">
                                            <option value="0"><c:out value="--Seleccione Tipo Obra--"/></option>
                                            <c:forEach items="${listadoTipoObra}" var="tipo_obras">
                                                <option value="${tipo_obras.getId_tipo_obra()}"><c:out value="${tipo_obras.getDescripcion()}"/></option>
                                            </c:forEach>
                                        </select>   
                                    </div>  
                                    <div class="form-group">
                                        <select class="form-control " id="id_region" name="ddlRegiones" onchange="getval(this)">
                                            <option value="0"><c:out value="--Seleccione Region --"/></option>
                                            <c:forEach items="${listadoRegiones}" var="region">
                                                <option value="${region.getId_region()}"><c:out value="${region.getNombre_region()}"/></option>
                                            </c:forEach>
                                        </select>   
                                    </div>  
                                    <div class="form-group">
                                        <input type="hidden" id="id_regionS" name="id_regionS" value="5">
                                        <c:if test="${param.id_regionS!=0}">
                                        <select class="form-control " id="id_ciudad" name="ddlCiudades" style="display: none;">
                                            <option value="0"><c:out value="--Seleccione Ciudad --"/></option>
                                            <c:forEach items="${listadoCiudades}" var="ciudad">
                                                <c:if test="${ciudad.getId_region() == param.id_regionS}">
                                                <option value="${ciudad.getId_ciudad()}"><c:out value="${ciudad.getNombre_ciudad()}"/></option>
                                                </c:if>
                                            </c:forEach>
                                        </select> </c:if>  
                                           
                                    </div>  
                                    <div class="form-group">
                                        <label for="newDireccion">Direccion</label>
                                        <input type="text" class="form-control" id="newDireccion" name="newDireccion" placeholder="Direccion"  >
                                    </div> 
                                    <div class="form-group">
                                        <label for="newValorHora">Valor Hora</label>
                                        <input type="text" class="form-control" id="newValorHora" name="newValorHora" placeholder="Valor Hora">
                                    </div>
                                    <div class="form-group">
                                        <label for="newFechaInicio">Fecha Inicio</label>
                                        <input type="text" class="form-control" id="newFechaInicio" name="newFechaInicio" placeholder="12/04/2017">  
                                    </div> 
                                    <div class="form-group">
                                        <label for="newFechaFin">Fecha Fin</label>
                                        <input type="text" class="form-control" id="newFechaFin" name="newFechaFin" placeholder="14/11/2017">  
                                    </div>
                                                                      
                                    <div class="form-group">
                                        <label for="newDescripcion">Descripcion</label>
                                        <input type="text" class="form-control" id="newDescripcion" name="newDescripcion" placeholder="Descripcion">
                                    </div>                     
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="agregarObra" id="agregarObra">Agregar</button>
                                </form> 
                            </div>
                            <!-- Popup Div Ends Here -->
                        </div>
                        <%-- Formulario Nueva Obra Fin --%>
                    </c:when>
                    <c:otherwise>                        
                        <%-- Formulario Editar Obra --%>
                        <div id="abc" style="overflow:hidden;">
                            <!-- Popup Div Starts Here -->
                            <div id="popupContact">
                                <!-- Contact Us Form -->
                                <form class="form-horizontal" id="formEditUs" method="POST" action="./editarObra">   
                                    <input type="hidden" name="hdnId_obra" value="${obraBuscada.getId_obra()}"/> 
                                    <input type="hidden" name="hdnId_obra" value="${obraBuscada.getId_Tipo_Obra()}"/> 
                                    <img id="close" src="img/3.png" onclick ="div_hide()">
                                    <h3>Formulario de Modificacion</h3>
                                    <div class="form-group">
                                        <select class="form-control " id="id_tipo_obra" name="ddlTipoObras">
                                            <option value="0"><c:out value="--Seleccione Tipo Obra--"/></option>
                                            <c:forEach items="${listadoTipoObra}" var="tipo_obras">
                                                <option value="${tipo_obras.getId_tipo_obra()}"><c:out value="${tipo_obras.getDescripcion()}"/></option>
                                            </c:forEach>
                                        </select>   
                                    </div>  
                                    <div class="form-group">
                                        <label for="modDireccion">Direccion</label>
                                        <input type="text" class="form-control" id="modDireccion" name="modDireccion" placeholder="Direccion"  value="<c:out value="${obraBuscada.getDireccion()}"/>">
                                    </div>         
                                    <div class="form-group">
                                        <label for="modValorHora">Valor Hora</label>
                                        <input type="text" class="form-control" id="modValorHora" name="modValorHora" placeholder="Valor Hora" value="<c:out value="${obraBuscada.getValor_hora()}"/>">
                                    </div>        
                                    <div class="form-group">
                                        <label for="modFechaInicio">Fecha Inicio</label>
                                        <input type="text" class="form-control" id="modFechaInicio" name="modFechaInicio" placeholder="12/04/2017" value="<c:out value="${obraBuscada.getFecha_inicio()}"/>">  
                                    </div>         
                                   <div class="form-group">
                                        <label for="modFechaFin">Fecha Fin</label>
                                        <input type="text" class="form-control" id="modFechaFin" name="modFechaFin" placeholder="12/04/2017" value="<c:out value="${obraBuscada.getFecha_Fin()}"/>">  
                                    </div> 
                                    <div class="form-group">
                                        <label for="modDescripcion">Descripcion</label>
                                        <input type="text" class="form-control" id="modDescripcion" name="modDescripcion" placeholder="Descripcion" value="<c:out value="${obraBuscada.getDescripcion()}"/>">
                                    </div>                                                                      
                                    <button style="width:100%;" type="submit" class="btn btn-primary" name="editarObra" id="editarObra">Agregar</button>
                                </form> 
                            </div>
                            <!-- Popup Div Ends Here -->
                        </div>
                        <%-- Formulario Editar Obra Fin --%>
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
