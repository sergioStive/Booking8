<%@page import="co.sena.edu.booking.DAO.personasDAO"%>
<%@page import="co.sena.edu.booking.DTO.personasDTO"%>
<!doctype html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css">
<script src="scripts/registro.js" type="text/javascript"></script>
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
<li><a align="center" href="#">Reservas</a>
<ul class="submain">
<li><a href="reserva.jsp">Nueva Solicitud </a></li>
<li><a href="mreserva.html">Mis Reservas</a></li>
</ul>
</li>
<li><a align="center" href="#">Mi Cuenta</a>
    
<ul class="submain">
<li><a href="actualizarDatos1.jsp">Mis Datos</a></li>
</ul>
</li>   
</ul>
     <%
                                    HttpSession misesion = request.getSession(false);

                                    if (misesion.getAttribute("logueado") != null) {
                                        personasDTO pdto = null;
                                        personasDTO persona = null;
                                        personasDAO pdao = new personasDAO();
                                        pdto = (personasDTO) misesion.getAttribute("logueado");
                                        persona = pdao.ListarUnaPersona(pdto.getIdPersona());                                       
                                                

                                %>
                                <div class="table">
                                <form id="registro" action="cambiarClave?id=<%=persona.getIdPersona()%>" method="post"> 
                                    <table align="center" id="registro" >

                                        <h3><center >CAMBIAR CONTRASEÑA</center></h3>
                                        <main>
                                           
                                            <tr> 
                                                <td><label for="con" class="labele"><strong>Contraseña<font color="#FF0000">*</strong></label></font></td>  
                                                <td><input name="con" type="password" id="con" value="<%=persona.getContraseña()%>" style="width:250px; height:25px" tabindex="17" autofocus required class="form-control inputtext">
                                                <td><label for="con" class="labele"><strong>Confirmar<font color="#FF0000">* </strong></label></font>  
                                                <td><input name="vcon" type="password" id="vcon" value="<%=persona.getContraseña()%>" style="width:250px; height:25px" tabindex="18" autofocus required class="form-control inputtext"></td>
                                            </tr>
                                            <tr>
                                                <td><input name="submit11" class="btn btn-success" type="button" id="ccon" tabindex="19" onClick="contrase()" value="Validar contraseña"style="position:relative; left:150px"></td>
                                                <td><input name="submit10" class="btn btn-success" type="submit" id="submit10" tabindex="20"  value="Guardar Cambios" onClick="validar(registro)" style="position:relative; left:163px"></td>
                                                <td><input type="reset" name="button" class="btn btn-success" id="button" value="Limpiar formulario" style="position:relative; left:80px" ></td>
                                                <td>
                                                    <input type="button" name="button2"class="btn btn-success" id="button2" value="Salir" onClick="cerrarVentana()" style="position:relative; left:85px;"></td>
                                            </tr>
                                    </table>
                                </div>
                                    </fieldset>
                                    <%
                                        }
                                    %>
</form>
</div>
</main>                                      
<div class="idioma3">
<a href="../en/pass.html">English</a> ||  <a href="../es/pass.html">Spanish</a>
</div>
</body>
</html>
