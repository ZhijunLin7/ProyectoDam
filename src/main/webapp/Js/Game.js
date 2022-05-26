
function estadistica() {
    document.getElementById('izquierda').classList.toggle('active');
}
function inventario() {
    document.getElementById('derecha').classList.toggle('active');
}

function atacar(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
        }
    }

    http.open("POST","http://localhost:7070/ProyectoDam/src/main/java/Main",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("a="+document.getElementById("a").value+"&&b="+document.getElementById("b").value);
}

function objeto(){
    var http;
        http = new XMLHttpRequest;

        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }

        http.open("POST","http://localhost:7070/ProyectoDam/src/main/java/Main",true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("a="+document.getElementById("a").value+"&&b="+document.getElementById("b").value);
}

function habilidad(){
    var http;
        http = new XMLHttpRequest;

        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }

        http.open("POST","http://localhost:7070/ProyectoDam/src/main/java/Main",true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("a="+document.getElementById("a").value+"&&b="+document.getElementById("b").value);
}

function juego(){
    var http;
        http = new XMLHttpRequest;

        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }

        http.open("POST","http://localhost:7070/ProyectoDam/src/main/java/Main",true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("a="+document.getElementById("a").value+"&&b="+document.getElementById("b").value);
}
  

