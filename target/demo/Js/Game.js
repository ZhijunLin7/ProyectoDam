
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
    getmonstruo();

    
}
//Coge un monstruo de base de datos y guarda en sesion storage ademas mete donde toca
function getmonstruo() {
    var http = new XMLHttpRequest;
        
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 200) {
                var estatsmons = http.responseText;
                colocarmons(estatsmons);
                
            }
        }
        http.open("GET","http://localhost:7070/demo/Datos", true);
        http.send();
      
}

//Al cargar la pagina mira si el personaje esta creado o no en el base de datos en caso de si carga los informaciones y lo guarda en storage.
function info_jugador() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
           var respuesta = http.responseText;
        
           if (respuesta=="null") {
                document.getElementById("juego").classList.toggle('close');
                document.getElementById("charcrear").classList.toggle('active');
           }
           else{
                var txt = http.responseText;
                colocar(txt);
            }
        }
    }

    http.open("POST","http://localhost:7070/demo/Jugador",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("id_usuario="+localStorage.getItem("id_usuario"));
}
//Si no esta creado la pagina usa este get para conseguir lo estadistica generado en el java
function random_stats() {
    var http = new XMLHttpRequest();
        http.open("GET","http://localhost:7070/demo/Jugador", true);
        http.send();
      
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 200) {
                var estats = http.responseText;
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
//El metodo que esta con el boton de crear personaje, que mete los estat donde toca y guarda en sesion storage.
function comenzar() {
    document.getElementById("juego").classList.toggle('close');
    document.getElementById("charcrear").classList.toggle('active');

    var nombre= document.getElementById("nombre_personaje").value;
    var fuerza= document.getElementById("Random_Fuerza").innerHTML;
    var Inteligencia= document.getElementById("Random_Inteligencia").innerHTML;
    var Vitalidad= document.getElementById("Random_Vitalidad").innerHTML;
    var Voluntad= document.getElementById("Random_Voluntad").innerHTML;
    var Defensa= document.getElementById("Random_Defensa").innerHTML;
    var Agilidad= document.getElementById("Random_Agilidad").innerHTML;

    var datos =["nom_personaje","Vida","Mana","NIVEL","EXPERIENCIA","EXPERIENCIA_MAX","VIDA_MAX","MAGIA_MAXIMA","FUERZA","Inteligencia","Vitalidad","Voluntad","Defensa","Agilidad","Habitacion","Oro"]
    var estat =[nombre,100,25,1,0,100,100,25,fuerza,Inteligencia,Vitalidad,Voluntad,Defensa,Agilidad,0,0]
    if (fuerza != "∞") {
        for (let i = 0; i < datos.length; i++) {
            document.getElementById(datos[i]).innerHTML=estat[i];
        }

    }
    var stat;
    for (let x = 0; x < datos.length; x++) {
        var stat =stat + datos[x]+","+estat[x]+","
            
    }
    sessionStorage.setItem("EstatJug",stat);
  
   
}

function colocar(txt) {
    sessionStorage.setItem("EstatJug",txt);
    var datos =["nom_personaje","Vida","Mana","NIVEL","EXPERIENCIA","EXPERIENCIA_MAX","VIDA_MAX","MAGIA_MAXIMA","FUERZA","Inteligencia","Vitalidad","Voluntad","Defensa","Agilidad","Habitacion","Oro"]
    var temp = txt.split(",");
    var posicion = 1;
    for (let j = 0; j < datos.length; j++) {
        if (j == 0) {
            document.getElementById(datos[j]).innerHTML=temp[posicion];
        } else {
            document.getElementById(datos[j]).innerHTML=temp[posicion];
        }
        posicion = posicion +2;
    }
    var vida =parseInt(temp[3])*100/parseInt(temp[13]);
    var mana =parseInt(temp[5])*100/parseInt(temp[15]);
    document.getElementById("jug-vida").value=vida;
    document.getElementById("jug-mana").value=mana;
}
function colocarmons(txt) {
    sessionStorage.setItem("Estatmons",txt);
    var temp = txt.split(",");
    var vida =parseInt(temp[11])*100/parseInt(temp[7]);
    var mana =parseInt(temp[13])*100/parseInt(temp[9]);
    document.getElementById("nombre_mons").innerHTML=temp[3];
    document.getElementById("monster-vida").value=vida;
    document.getElementById("monster-mana").value=mana;

    
}

function Atacar() {
    var http;
    http = new XMLHttpRequest;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
           var respuesta = http.responseText;
           var resp =respuesta.split(";");
            colocar(resp[0]);
            colocarmons(resp[1]);

            document.getElementById("batallaingfo").getElementsByTagName("ul")[0].appendChild(document.createElement("li").appendChild(document.createTextNode(resp[2])));
            document.getElementById("batallaingfo").getElementsByTagName("ul")[0].appendChild(document.createElement("hr"));


        }
    }

    http.open("POST","http://localhost:7070/demo/Datos",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("Estatjug="+sessionStorage.getItem("EstatJug")+"&&Estatmons="+sessionStorage.getItem("Estatmons"));
}

