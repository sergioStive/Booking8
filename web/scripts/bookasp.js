function cerrar() {
    hideDiv('caso2');hideDiv('caso2x');hideDiv('caso2x1');hideDiv('caso5');hideDiv('caso5x');hideDiv('caso6');hideDiv('caso6x');hideDiv('caso8');hideDiv('caso8x'); hideDiv('caso9');hideDiv('caso9x');hideDiv('156c');hideDiv('156cm');hideDiv('ruta');hideDiv('rutam');
}
function abrirVentana() {
    window.open("Index.html");
}
function cerrarVentana() {
    window.close();
}
 function showDiv( id ) {
   document.getElementById( id ).style.display = "block";  
}
 function hideDiv( id ) {
   document.getElementById( id ).style.display = "none";  
}