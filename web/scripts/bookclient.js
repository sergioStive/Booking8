function requisitos(idelemento)
{
	if (idelemento.value=="") {
		//idelemento.placeholder="Debe registrar este campo";
		idelemento.style.border="1px solid red";
		war.hidden=false;
	}	
	else if (idelemento!==""){
		idelemento.style.border="1px solid gray";
		war.hidden=true;
		}
	}
 
function cerrar() {
    hideDiv('caso3');hideDiv('caso4');hideDiv('caso4x');hideDiv('caso6');hideDiv('caso6x');hideDiv('caso7');hideDiv('caso7x');hideDiv('servicios');hideDiv('reserva');hideDiv('reservam');
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
function validar(){
	
	
	if (dire.value==""){
		//dire.placeholder="Debe registrar este campo";
		dire.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	dire.style.border="1px solid gray";
	}
	if (tel.value==""){
		//dire.placeholder="Debe registrar este campo";
		tel.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	tel.style.border="1px solid gray";
	}
	if (cor.value==""){
		//dire.placeholder="Debe registrar este campo";
		cor.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	cor.style.border="1px solid gray";
	}
	if (paisnac.value==""){
		//dire.placeholder="Debe registrar este campo";
		paisnac.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	paisnac.style.border="1px solid gray";
	}
	if (ciunac.value==""){
		//dire.placeholder="Debe registrar este campo";
		ciunac.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	ciunac.style.border="1px solid gray";
	}
	
	 }
	 
function contrase(){
var x=con.value;
var y=vcon.value;
if ((x==y)&&(x!="")&&(y!=""))
{
	alert('Contraseña Valida!!');
	con.style.border="1px solid gray";
	vcon.style.border="1px solid gray";
}
else {
    alert('Contraseña Invalida!!\nLas contraseñas no son iguales!!');
	con.value ="";
	vcon.value="";
}
}