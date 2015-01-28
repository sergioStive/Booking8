<%@page import="java.util.ArrayList"%>
<%@page import="co.sena.edu.booking.DAO.personasDAO"%>
<%@page import="co.sena.edu.booking.DTO.personasDTO"%>
<!doctype html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css">
	 <link rel="shortcut icon" href="imagenes/br.ico" />
         <script src="scripts/registro.js" type="text/javascript"></script>
         <script src="scripts/ingreso.js" type="text/javascript"></script>
         <script src="scripts/bookasp.js" type="text/javascript"></script>
<meta charset="utf-8">
<title>..::Booking Routers::..</title>
<link rel="shortcut icon" href="img/br.ico" />
</head>

<body>
<div class ="contenedor">
<div class="banner"> 
<p><a href="Index.html"><img src="imagenes/Logo.png" alt="Booking Routers" width="1360" height="126" title="Forget the rest, call the best"  /></a></p>
</div>
<ul id="main">
   <li><a href="Index.html">Inicio</li></a>
   <li><a href="#">Gestion Reserva</a>
   <ul class="submain">
   <li><a href="#">Verificar Reserva</a>  	  
   <li><a href="#">Cancelar Reserva</a></li>
   </ul>
   </li>
   <li><div align="center"><a href="#">Gestion Rutas</a>
   <ul class="submain">
   <li><a href="#">Generar Rutas</a>
   <li><a href="#">Modificar Rutas</a></li>
   </ul>
   </div>
   </li>
   <li><div align="center"><a href="#">Reportes</a> 
    <ul class="submain">
    <li><div align="center"><a href="#">Reservas</a> 
    <li><div align="center"><a href="#">Rutas</a>
    <li><div align="center"><a href="#">Conductores</a> 
    <li><div align="center"><a href="#">Clientes</a>
    <li><div align="center"><a href="#">Turistas</a> 
    </div>
     </li>
  </ul>
</li>
  <li>
    <div align="center" onClick="abrirVentana();cerrarVentana()"><a href="Index.html">Salir</a> 
    </div>
</li>
<center>
    <%personasDTO  per= new personasDTO();
      personasDAO pers = new personasDAO(); 
      ArrayList<personasDTO> misPersonas= new ArrayList();
      misPersonas =(ArrayList<personasDTO>) pers.listarPersonas();
      
      
      
      %>    
<h1> Usuarios Registrados</h1>
<table border="1" id="one-column-emphasis">
    <tr>
        <th>CEDULA</th>
        <th>NOMBRES</th>
        <th>APELLIDOS</th>
        <th>FECHANTO</th>
        <th>PAIS</th>
        <th>IDPAIS</th>
        <th>TELEFONO</th>
        <th>CONTRASEÑA</th>
        <th>CORREO</th>
        <th>ELIMINAR</th>
    </tr>
    <%
      for(personasDTO so: misPersonas){
          
      
    %>
    <tr>
        <td><%=so.getIdPersona()%></td>
        <td><%=so.getNombres()%></td>
        <td><%=so.getApellidos()%></td>
        <td><%=so.getFechaNto()%></td>
        <td><%=so.getPais()%></td>
        <td><%=so.getIdNacionalidad()%></td>
        <td><%=so.getTelefono()%></td>
        <td><%=so.getContraseña()%></td>
        <td><%=so.getCorreoElectronico()%></td>
        <td><a href="Controlador?id=<%=so.getIdPersona()%>"><img src="imagenes/Eliminar.png" align="middle" width="32" height="32" title="Eliminar"></a></td>
    
    </tr>
    <%
    }
    %>
</table>
</center>
</body>
<html>