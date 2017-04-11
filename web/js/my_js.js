/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    function mostrarForm() {
        var form = document.getElementById("formNewUser");
        if (form.style.display !== 'none') {
            form.style.display = 'none';
        } else {
            form.style.display = 'block';
        }
    }
    
 /**   $(document).ready(function() {
                $('#tableUsuarios').paging({limit:4});
            });   **/
            
function div_show() {
document.getElementById('abc').style.display = "block";
}
//Function to Hide Popup
function div_hide(){
document.getElementById('abc').style.display = "none";
}

function check_pass() {
    if (document.getElementById('newPass').value ==
            document.getElementById('newPass2').value) {
        
        document.getElementById('agregarUsuario').disabled = false;
    } else {
        document.getElementById('agregarUsuario').disabled = true;
        document.getElementById('msjPassMatch').style.display = "block";
    }
}
