<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>Booking Routers</title>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css" />
<link rel="shortcut icon" href="imagenes/br.ico" />

</head>
<body>

 <div class ="contenedor">
 <div class="banner">
 <p><a href="Index.html"><img src="imagenes/Logo.png" alt="Bookin Routers" width="1360" height="126" title="Forget the rest, call the best" /></a></p>
 </div>
<div class="menu">    
<menu id="nav"> 
 <li>
 <div align="center"> <a href="Index.html">Inicio</a>
</li>
</li>
<br>
<br>
<li>
<div align="center"> <a href="recuperarContraseña.html">¡Olvido su contraseña!</a>
</li>
<main>
<center>
<form name="form1" action="Controlador" method="post" > 
<table id="registro">

<h1><strong>Ingreso Usuarios Registrados</strong></h1></td>   

<label for="usu" class="labele"><strong>Usuario<font color="#FF0000">*</strong></label></font>
<input name="idPersona" type="text" style="width:250px; height:25px " autofocus id="usu" placeholder="usuario" required class="form-control inputtext"  onChange="requisitos(nombre)" minlenght=3>

<br>

<label for="con" class="labele"><strong>Contraseña<font color="#FF0000">*</strong></label></font>
<input name="contraseña" type="password" style="width:250px; height:25px " required id="con" placeholder="*******" required class="form-control inputtext"  minlenght=3>
<br>
<input name="submit10" class="btn btn-success"  type="submit" id="submit10" onClick= "rol()" value="Ingresar">
</table>
</center>
</form>
<%
 if(request.getParameter("invalida") != null  ) {
%>
<div class="valido">
    <b> sus datos no son validos</b>
</div>
<%
 }
%>
</menu>
</main>
<div class="idioma"> 
<a href="../en/menu.html">English</a> || <a href="../es/menu.html">Spanish</a>
</div>
</body>
</html>