<!doctype html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css">
	<script  src="jquery/jquery.js"></script>
	<script src="jquery/jquery.validate.js"></script>
	<script src="jquery/additional-methods.js"></script>
<meta charset="utf-8">
<title>..::Booking Routers::..</title>
<link rel="shortcut icon" href="img/br.ico" />
</head>
</head>
<body>
<div id="pagina">
<header>
<img src="imagenes/Logo.png" height="125px" width="100%"> 
</header>
<br>
<nav>
<ul id="main">
   <li><a href="bookasp.html">Inicio</li></a>    
   <li><a href="verificarRegistro.jsp">Verificar Registro</a></li>
   <li><a href="#">Gestion Reserva</a>
   <ul class="submain">
   <li><a href="#">Verificar Reserva</a>  	  
   <li><a href="#">Cancelar Reserva</a></li>
   </ul>
   </li>
   <li><a href="#">Gestion Rutas</a>
   <ul class="submain">
   <li><align="center" onClick="cerrar();showDiv('caso8');"><a href="#">Generar Rutas</a>
   <li><align="center" onClick="cerrar();showDiv('caso9');"><a href="#">Modificar Rutas</a></li>
   </ul>
   </li>
   <li><div align="center"><a href="#">Reportes</a> 
    <ul class="submain">
    <li><div align="center"><a href="#">Reservas</a> 
    <li><div align="center"><a href="#">Rutas</a>
    <li><div align="center"><a href="#">Conductores</a> 
    <li><div align="center"><a href="#">Clientes</a>
    <li<<div align="center"><a href="#">Turistas</a> 
    </div>
     </li>
  </ul>
</li>
  <li>
    <div align="center" onClick="abrirVentana();cerrarVentana()"><a href="#">Salir</a> 
    </div>
</li>
</menu>
</div>
<div id="caso2"  style="display:none; position: relative; top: 100px;">
<Center>
<table width="641" border="0">
  <tr>
    <td colspan="2" align="center"><strong><font size="+1">Verificar Registro de Usuarios</font></strong></td>
  </tr>
  <tr>
    <td colspan="2">Caso Uso 2 - Permitir a la gerencia verificar el registro de usuarios vía Web.</td>
    </tr>
  <tr>
    <td width="87"><label for="fil"><strong>Filtro </strong></label><font color="#FF0000">*</td>
    <td width="544"><select name="select2" required id="fil" tabindex="1">
     <!--  <option>-</option>-->
      <option>no validados</option>
     <!-- <option>independientes validados</option>
      <option>Operador validados</option>-->
    </select>
      <select name="select4" id="select4" tabindex="2">
        <option selected>Ordenar</option>
        <option>Nombres</option>
        <option>Documento</option>
        <!--  <option>-</option>-->        <!-- <option>independientes validados</option>
      <option>Operador validados</option>-->
      </select>
      <select name="select5" required id="select5" tabindex="3">
        <option selected>Cantidad</option>
        <option>1-5</option>
        <option>6-10</option>
        <option>+10</option>
        <!--  <option>-</option>-->        <!-- <option>independientes validados</option>
      <option>Operador validados</option>-->
      </select><img src="imagenes/buscar.png" width="21" height="19" onclick="showDiv('caso2x1')" alt="Buscar de acuerdo al filtro"/></td>
  </tr>
  <tr>
    <td colspan="2">
    <div id="caso2x1"  style="display:none; position: relative">
    <table width="500" border="1">
      <tr>
        <td width="197">Miranda Rodrigo </td>
        <td width="80">132131132</td>
        <td width="80">2014-07-25</td>
        <td width="40" align="center"><img src="imagenes/buscar.png" width="21" height="19" alt="Buscar de acuerdo al filtro"/></td>
      </tr>
      <tr>
        <td width="197">Saavedra Maldonado Isabela</td>
        <td width="80">10101101</td>
        <td width="80">2014-06-16</td>
        <td align="center"><img src="imagenes/buscar.png" width="21" height="19" onclick="showDiv('caso2x')" alt="Buscar de acuerdo al filtro"/></td>
      </tr>
      <tr>
        <td>Zambrano Alex</td>
        <td width="80">654465555</td>
        <td width="80">2014-07-20</td>
        <td align="center"><img src="imagenes/buscar.png" width="21" height="19" alt="Buscar de acuerdo al filtro"/></td>
      </tr>
    </table></td>
    </tr>

  </table>
</div>
  <div id="caso2x"  style="display: none; position: relative; top: 100px;">
  <center>
  <table width="641" border="0">
  <tr>
    <td><strong>Nombres</strong></td>
    <td colspan="3">Saavedra Maldonado Isabela</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="87"><strong>Número Documento </strong><font color="#FF0000"></td>
    <td width="200">10101101</td>
    <td>&nbsp;</td>
    <td><strong>Empresa</strong></td>
    <td>Sena</td>
  </tr>
  <tr>
    <td width="87"><strong>Fecha Nacimiento </strong><font color="#FF0000"></td>
    <td>20/07/1983</td>
    <td>&nbsp;</td>
    <td><strong>Cargo</strong></td>
    <td>Analista Programador</td>
  </tr>
  <tr>
    <td width="87"><strong>Dirección </strong><font color="#FF0000"></td>
    <td>Calle 148 No. 94ª-10 Casa 53</td>
    <td>&nbsp;</td>
    <td><strong>Ciudad</strong></td>
    <td>Bogota</td>
  </tr>
  <tr>
    <td width="87"><strong>Teléfonos </strong><font color="#FF0000"></td>
    <td>8133609, 311 4992904</td>
    <td>&nbsp;</td>
    <td><strong>País</strong></td>
    <td>Colombia</td>
  </tr>
  <tr>
    <td width="87"><strong>Correo Electrónico</strong><font color="#FF0000"></td>
    <td>wilsonacua@misena.edu.do</td>
    <td>&nbsp;</td>
    <td><strong>Dirección</strong></td>
    <td>Carrera 13 No. 65 - 10</td>
  </tr>

  <tr>
    <td width="87"><strong>Ciudad</strong><font color="#FF0000"></td>
    <td>Bogota</td>
    <td>&nbsp;</td>
    <td><strong>Teléfonos</strong></td>
    <td>545466</td>
  </tr>
  <tr>
    <td><strong>País </strong></td>
    <td>Colombia</td>
    <td>&nbsp;</td>
    <td rowspan="2"><strong>Observaciones </strong></td>
    <td rowspan="2">Soy el hijo de Santos</td>
  </tr>
    <tr>
  	<td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <tr>
    <td width="87"><label for="rol"><strong>Rol</strong></label><font color="#FF0000">* </td>
    <td><select name="select7" id="rol">
      <option>0-No validado</option>
      <option>1-Independiente</option>
      <option>2-Operador</option>
    </select></td>
    <td>&nbsp;</td>
    <td colspan="2"><input name="textfield36" type="text" id="textfield36" size="30"></td>
    </tr>
  <tr>
    <td colspan="2"><strong>Campos obligatorios</strong><font color="#FF0000">*</font></td>
    <td width="19">&nbsp;</td>
    <td width="102"><input type="submit" name="submit10" id="submit10" value="Confirmar Rol" onClick="alert('Usted asigno Rol!!\n Se enviará un correo al cliente informado del nuevo rol!!');hideDiv('caso2');hideDiv('caso2x');hideDiv('caso2x1')"></td>
    <td width="211"><input type="button" name="button3" id="button3" value="Salir" onClick="cerrar()"></td>
  </tr>
  </table>
  </div>

<Center>
  <div id="caso5"  style="display: none; position: relative; top: 100px;">
    <table width="641" border="0">
  <tr>
    <td colspan="3" align="center"><strong><font size="+1">Verificar Reservas</font></strong></td>
  </tr>

  
 
</body>
<html>