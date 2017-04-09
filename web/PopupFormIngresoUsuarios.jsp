<%-- 
    Document   : PopupFormIngresoUsuarios
    Created on : Apr 7, 2017, 2:47:41 PM
    Author     : Cami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Popup contact form</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/theme.css" rel="stylesheet"/> 
        <link href="css/elements.css" rel="stylesheet">
        <script src="js/my_js.js"></script>
    </head>
    <!-- Body Starts Here -->
    <body id="body" style="overflow:hidden;">
        <div id="abc">
            <!-- Popup Div Starts Here -->
            <div id="popupContact">
                <!-- Contact Us Form -->
                <form class="form-horizontal" id="formNewUser" method="POST" action="MUser">       
                    <img id="close" src="img/3.png" onclick ="div_hide()">
                    <h2 id="tituloPopup" name="tituloPopup">Formulario de Ingreso</h2>
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
        <!-- Display Popup Button -->
        <h1>Click Button To Popup Form Using Javascript</h1>
        <button id="popup" onclick="div_show()">Popup</button>
    </body>
    <!-- Body Ends Here -->
</html>
