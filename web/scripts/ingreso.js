function rol() {
var a=usu.value;
if (a==1) {
window.close("ingreso.html");  
window.open("bookasp.jsp"); 
} 
else if (a==2){
window.close("ingreso.html"); 
window.open("bookclient.html");
}
else {
alert('Contraseña Invalida!\n Ingrese a ¿Olvidé mi contraseña?'); 
cerrarVentana();
abrirVentana();
}
}
function abrirVentana() {
    window.open("ingreso.html");
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