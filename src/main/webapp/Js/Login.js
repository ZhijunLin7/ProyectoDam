function AlLogin() {
    document.getElementById("box1").style.display="none";
    document.getElementById("box2").style.display="block";
    document.getElementById("AlLogin").style.backgroundColor="peachpuff";
    document.getElementById("AlRegistrar").style.backgroundColor="rgb(216,216,216)";
}

function AlRegistrar() {
    document.getElementById("box1").style.display="block";
    document.getElementById("box2").style.display="none";
    document.getElementById("AlLogin").style.backgroundColor="rgb(216,216,216)";
    document.getElementById("AlRegistrar").style.backgroundColor="peachpuff";
}

function login() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            var re =http.responseText;
            
            switch (re) {
                case "No existe Usuario":
                    document.getElementById("resultado").innerHTML=http.responseText;
                    break;
            
                case "Error de contrasena":
                    document.getElementById("resultado").innerHTML=http.responseText;
                    break;

                default:
                    document.getElementById("resultado").innerHTML="Registracion correctamente";
                    localStorage.setItem("id_usuario",http.responseText);
                    window.location.replace("/demo/html/Game.html");
                    break;
            }
            
            
        }
    }

    http.open("POST","http://localhost:7070/demo/Usuario",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("usernamelogin").value+"&&password="+document.getElementById("passwordlogin").value+"&&operacion=login");
}
function registrar() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("resultado").innerHTML=http.responseText;
        }
    }

    http.open("POST","http://localhost:7070/demo/Usuario",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value+"&&password2="+document.getElementById("password2").value+"&&operacion=registrar");
}