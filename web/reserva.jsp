 	 	<!doctype html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css">
<script src="scripts/registro.js" type="text/javascript"></script>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/br.ico" />
<title>..::Booking Routers::..</title>
</head>
<body>
<div class ="contenedor">
<div class="banner"> 
<p><a href="Index.html"><img src="imagenes/Logo.png" alt="Booking Routers" width="1360" height="126" title="Forget the rest, call the best"  /></a></p>
</div>
<nav>
<ul id="main">
    <li><a href="Index.html">Inicio</li></a>
       <li><a align="center" href="#">Reservas</a>
                            <ul class="submain">
                                <li><a href="reserva.jsp">Solicitar Reserva</a></li>
                                <li><a href="mreserva.html">Mis Reservas</a> </li>
                                </ul>
                        </li>
                         <li><a align="center" href="#">Mi Cuenta</a>
                            <ul class="submain">
                                <li><a href="actualizarDatos1.jsp">Mis Datos</a></li>
                                <li><a href="cambiarContraseña.jsp">Cambiar Contraseña</a> </li>
                                </ul>
                        </li>
      
        </ul>

</nav>
<main>
<form name="form1" action="Reserva" method="post" > 
<table width="744" align="center" id="registro">
<tr>
<td colspan="5" align="center"><font size="+1"><h1><strong>Reservas</strong></h1></font></td>
</tr>
<tr>
                          
<td><label for="reser" class="labele"><strong>Numero Reserva<font color="#FF0000">*</strong></label></font></td>
<td><input name="reser" type="text" style="width:250px; height:25px " autofocus id="reser" class="form-control    inputtext" tabindex="1" onChange="requisitos(nombre)" minlenght=3>
</td>
<td><label for="estado" class="labele"><strong>Estado Reserva<font color="#FF0000">*</strong></label></font></td>
<td><input name="estado" type="text" style="width:250px; height:30px" autofocus id="estado" placeholder="Seleccione" required class="form-control inputtext" list="es" tabindex="2" onChange="requisitos(ape)">
<datalist id="es">
<option value="0">No Validada</option>
</datalist>                                   
</td>
</tr>
<tr>
<td><label for="ser" class="labele"><strong>Servicio<font color="#FF0000">*</strong></label></font></td>
<td><input name="ser" id="ser" style="width:250px; height:35px" placeholder="Seleccione servicio" autofocus required class="form-control inputtext" list="servis" tabindex="9" size="30">   
      <datalist id="servis">     
      <option value="1">Airport and Jet Aviation Centers</option>
      <option value="2">Port and Cruise Ship Transportation</option>
      <option value="3">Transfer</option>
      <option value="4">By the Hour</option>
      <option value="5">Events</option>
      <option value="6">Tours</option>
      <option value="7">Atraccions Vacation Ideas</option>
      </datalist> 
 </td>
</select>                                        
<td><label for="aer" class="labele"><strong>Aerolineas<font color="#FF0000">*</strong></label></font></td>
<td><input name="aer" id="aer" style="width:250px; height:35px" placeholder="Seleccione Aerolinea" autofocus required class="form-control inputtext" list="aero">   
      <datalist id="aero">
      <option value="Avianca">Avianca</option>
      <option value="LAN">LAN</option>
      <option value="US Airways">US Airways</option>
      <option value="American Airlin">American Airline</option>
      </datalist> 
 </td>
</tr>
<tr>
<td><label for="res" class="labele"><strong>Responsable<font color="#FF0000">*</strong></label></font></td>
<td><input name="res" type="text" id="res" style="width:250px; height:25px" placeholder="Responsable" autofocus  required class="form-control inputtext"></td>   
<td><label for="fec" class="labele"><strong>Fecha Reserva<font color="#FF0000">* </strong></label></font></td>
<td><input name="fec" type="date" id="fec" style="width:250px; height:25px" required class="form-control inputtext" tabindex="4" onChange="edad()"></td>    
</tr> 
<td><label for="hora" class="labele">Hora de Vuelo</label></td>
<td><input type="time" name="hora" id="hora" style="width:250px; height:25px" class="form-control" required></td>
<td><label for="aerop" class="labele">Aeropuesto Destino</label></td>
<td><select type="time" name="aerop" id="aerop" style="width:250px; height:30px" placeholder="Aeropuerto" autofocus  required class="form-control inputtext">
<option>Fort Louderdale</option>
</select>
</td>
</tr>
<tr>
<td><input name="submit11" class="btn btn-success" type="button" id="ccon" tabindex="19" onClick="contrase()" value="Validar contraseña"style="position:relative; left:160px"></td>
<td><input type="submit" name="registro"  id="registro" class="btn btn-success"  value="Registrar" onclick="validar(registro)" style="position:relative; left:173px">
<input type="reset" name="button" class="btn btn-success" id="button" value="Limpiar formulario" style="position:relative; left:190px" ></td>
<td><input type="button" name="button2"class="btn btn-success" id="button2" value="Salir" onClick="cerrarVentana()" style="position:relative; left:190px;"></td>
</tr>
</table>
</fieldset>
</form>
</div> 



</div>
<div style="width:100%; background: #0C4391; height: 30px; margin-top:10px; padding-top:5px; border-radius:3px;color:#e2c60f; margin-bottom:1%; float:left">
<a href="../en/reserva.html">English</a> ||  <a href="../es/reserva.html">Spanish</a>
</div>
</main>

</body>
</html>
