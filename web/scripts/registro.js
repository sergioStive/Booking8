
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

function edad() {
var fecNac = new Date(date.value);
var hoy = new Date();
var a = hoy.getFullYear();
var m = hoy.getMonth()+1;
var d = hoy.getDate();
var af = fecNac.getFullYear();
var mf = fecNac.getMonth()+1;
var df = fecNac.getDate()+1;
var hoyx = (a*365)+(m*30)+d;
var fecNacx = (af*365)+(mf*30)+df;
var dif = hoyx-fecNacx;
var difx = dif/365;
if (difx<18){
//alert('Usted es Menor de edad!!!\n'+'Fecha Nacimiento'+fecNacx+'\n'+'Hoy'+hoyx+'\n'+'Edad'+difx);
alert('Usted es menor de edad!!!\nEl sistema no permite registrar menores de edad!\n'+hoyx);
cerrarVentana();
}
	else {
	date.style.border="1px solid gray";
}
}
function cerrarVentana() {
    window.close("registro.jsp");
    window.open("Index.html");
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

function validar(){
	if (nombre.value==""){
		//nombre.placeholder="Debe registrar este campo";
		nombre.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	nombre.style.border="1px solid gray";
	}
	if (ape.value==""){
	//	ape.placeholder="Debe registrar este campo";
		ape.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	ape.style.border="1px solid gray";
	}
		if (doc.value==""){
	//	doc.placeholder="Debe registrar este campo";
		doc.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	doc.style.border="1px solid gray";
	}
	if (date.value==""){
		date.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	date.style.border="1px solid gray";
	}
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
	if (con.value==""){
		//dire.placeholder="Debe registrar este campo";
		con.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	con.style.border="1px solid gray";
	}
	if (vcon.value==""){
		//dire.placeholder="Debe registrar este campo";
		vcon.style.border="1px solid red";
		war.hidden=false;
	}
	else {
	vcon.style.border="1px solid gray";
	}
	 }