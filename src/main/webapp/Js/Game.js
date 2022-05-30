
function estadistica() {
    document.getElementById('izquierda').classList.toggle('active');
}
function inventario() {
    document.getElementById('derecha').classList.toggle('active');
}
    
function batalla() {
    document.getElementById('opciones').style.display="flex";
    document.getElementById('opciones').classList.toggle('active');
    document.getElementById('quehacer').style.display="none";
}

function iniciarJuego(){
    var Http;
    Http = new XMLHttpRequest;

    paisHttp.onreadystatechange = function (){
        if (paisHttp.readyState==4 && Http.status==200){
            document.getElementById("batallainfo").innerHTML=Http.responseText;
        }
    }

    paisHttp.open("GET","http://localhost:3308/proyectodam/Juego",false);
    paisHttp.send();

}
  

