function login() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("resultat").innerHTML=http.responseText;
        }
    }

    http.open("POST","http://localhost:7070/demo/Usuario",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value+"&&operacion=login");
}
function registrar() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("resultat").innerHTML=http.responseText;
        }
    }

    http.open("POST","http://localhost:7070/demo/Usuario",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value+"&&password2="+document.getElementById("password2").value+"&&operacion=registrar");
}