
//Sirve para abrir panel de jugador
function estadistica() {
    document.getElementById('izquierda').classList.toggle('active');
}
//Sirve para abrir inventario de jugador
function inventario() {
    document.getElementById('derecha').classList.toggle('active');
}
//Sirve para hacer batalla
function batalla() {
    document.getElementById('opciones').style.display="flex";
    document.getElementById('opciones').classList.toggle('active');
    document.getElementById('quehacer').style.display="none";
}

//Al cargar la pagina mira si el personaje esta creado o no en el base de datos en caso de si carga los informaciones y lo guarda en storage.
function info_jugador() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
           var respuesta = http.responseText;
           if (respuesta==null) {

           }
           else{
                var txt = http.responseText;
                var temp = txt.split(",");
            
                var datos =["nom_personaje","Vida","Mana","NIVEL","EXPERIENCIA","EXPERIENCIA_MAX","VIDA_MAX","MAGIA_MAXIMA","FUERZA","Inteligencia","Vitalidad","Voluntad","Defensa","Agilidad","Habitacion","Oro"]
                var posicion = 1;
                for (let j = 0; j < datos.length; j++) {
                    if (j==0) {
                        document.getElementById(datos[j]).innerHTML=temp[posicion];
                    } else {
                        document.getElementById(datos[j]).innerHTML=temp[posicion];
                    }
                    posicion = posicion +2;
                }
            }
        }
    }

    http.open("POST","http://localhost:7070/demo/Jugador",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("id_usuario="+localStorage.getItem("id_usuario"));
}

function random_stats() {
    var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET","http://localhost:7070/demo/Jugador", true);
        httpRequest.send();
      
        httpRequest.onreadystatechange = function () {
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                var estats = httpRequest.responseText;
                var temp = estats.split(",");
                var datos =["Random_Fuerza","Random_Inteligencia","Random_Vitalidad","Random_Voluntad","Random_Defensa","Random_Agilidad"]
                document.getElementById("Comenzar").disabled= false;
                var posicion = 1;
                for (let j = 0; j < datos.length; j++) {
                    if (j == 0) {
                        document.getElementById(datos[j]).innerHTML=temp[posicion];
                    } else {
                        document.getElementById(datos[j]).innerHTML=temp[posicion];
                    }
                    posicion = posicion +2;
                }

            }
        }

}

function comenzar() {
    document.getElementById("juego").classList.toggle('active');
    document.getElementById("charcrear").classList.toggle('close');

    var nombre= document.getElementById("nombre_personaje").value;
    var fuerza= document.getElementById("Random_Fuerza").innerHTML;
    var Inteligencia= document.getElementById("Random_Inteligencia").innerHTML;
    var Vitalidad= document.getElementById("Random_Vitalidad").innerHTML;
    var Voluntad= document.getElementById("Random_Voluntad").innerHTML;
    var Defensa= document.getElementById("Random_Defensa").innerHTML;
    var Agilidad= document.getElementById("Random_Agilidad").innerHTML;

    var datos =["nom_personaje","Vida","Mana","NIVEL","EXPERIENCIA","EXPERIENCIA_MAX","VIDA_MAX","MAGIA_MAXIMA","FUERZA","Inteligencia","Vitalidad","Voluntad","Defensa","Agilidad","Habitacion","Oro"]
    if (fuerza != "∞") {
        document.getElementById("nom_personaje").innerHTML=nombre;
        document.getElementById("Vida").innerHTML=100;
        document.getElementById("Mana").innerHTML=25;
        document.getElementById("NIVEL").innerHTML=1;
        document.getElementById("EXPERIENCIA").innerHTML=0;
        document.getElementById("EXPERIENCIA_MAX").innerHTML=100;
        document.getElementById("VIDA_MAX").innerHTML=100;
        document.getElementById("MAGIA_MAXIMA").innerHTML=25;
        document.getElementById("FUERZA").innerHTML=fuerza;
        document.getElementById("Inteligencia").innerHTML=Inteligencia;
        document.getElementById("Vitalidad").innerHTML=Vitalidad;
        document.getElementById("Voluntad").innerHTML=Voluntad;
        document.getElementById("Defensa").innerHTML=Defensa;
        document.getElementById("Agilidad").innerHTML=Agilidad;
        document.getElementById("Habitacion").innerHTML=0;
        document.getElementById("Oro").innerHTML=0;

    }
    
}



