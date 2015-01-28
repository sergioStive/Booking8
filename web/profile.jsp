
<%@page import="co.sena.edu.booking.DAO.personasDAO"%>
<%@page import="co.sena.edu.booking.DTO.personasDTO"%>
<!doctype html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/css.css">
	<script  src="jquery/jquery.js"></script>
	<script src="jquery/jquery.validate.js"></script>
	<script src="jquery/additional-methods.js"></script>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/br.ico" />
<title>..::Booking Routers::..</title>
</head>
<body>
<div id="pagina">
<header>
<img src="imagenes/Logo.png" height="125px" width="100%"/> 
</header>
    <br>
<nav>
<ul id="main">
        <a href="menu.html"><li>INICIO</li></a>
        <li>Reservas
        	<UL class="submain">
	        <a href="reserva.html"><li>Nueva Solicitud</li></a>
			<a href="mreserva.html"><li>Mis Resevas</li></a>
        </UL>
        </li>
        <li>Mi Cuenta
        <UL class="submain">
			<a href="profile.jsp"> <li>Mis datos</li></a>
            <a href="pass.html"><li>Cambiar Contraseña</li></a>
	        
        </UL>
        </li>
 
        </ul>
</nav>

<main>
<div style="width:100%; background: #0C4391; height: 50px; margin-top:10px; padding-top:5px; border-radius:15px;color:#e2c60f;" >
<h3><center >Actualizar Datos</center></h3>
</div>
 <%
                                    HttpSession misesion = request.getSession(false);

                                    if (misesion.getAttribute("logueado") != null) {
                                        personasDTO pdto = null;
                                        personasDTO persona = null;
                                        personasDAO pdao = new personasDAO();
                                        pdto = (personasDTO) misesion.getAttribute("logueado");
                                        persona = pdao.ListarUnaPersona(Integer.parseInt(pdto.getIdPersona()));                                       
                                                

                                %>
<form name="Registro" id="registro" action="menu.html" method="get" >
<div class="register" >
<label for="nombre" class="labele">Nombre </label>
<input type="text" name="nombre" id="nombre" placeholder="Carlos Hanks" readonly class="form-control inputtext" tabindex="1" style="border:none">  
<br>
<label for="documento" class="labele">Documento</label>
<input type="text" name="documento" id="documento" placeholder="1030603462" readonly class="form-control inputtext" tabindex="3" style="border:none">
<br>
<label for="fechNac" class="labele">Fecha de <br> Nacimiento </label>
<input type="text" name="fechNac" id="fechNac" placeholder="20-12-1991" readonly class="form-control inputdate" tabindex="3" style="border:none"> 
<br>
<label for="eMail" class="labele">Correo electronico </label>
<input name="cor" type="email" id="cor" value="" style="width:250px; height:25px" placeholder="asldj@misena.edu.co" autofocus required class="form-control inputtext" tabindex="4" style="border:none">
</div>
<div class="register">
<label for="telefono" class="labele">Telefono de <br> Contacto </label>
<input type="text" name="telefono" id="telefono" placeholder="32019823212" required class="form-control inputtext" tabindex="6">  
<br>
<label for="residencia" class="labele">Pais de <br> Residencia </label>
<select class="form-control" id="residencia"> 
	<optgroup label="Africa">
    
    </optgroup>
    <optgroup label="America">
    <option value="Argentina"> Argentina </option>
    <option value="Bolivia"> Bolivia </option>
    <option value="Canada"> Canadá </option>
    <option value="Chile"> Chile </option>
    <option value="Colombia"> Colombia </option>
    <option value="EEUU">Estados Unidos </option>
    <option value="Guatemala" > Guatemala </option>
    <option value="Mexico"> Mexico </option>
    <option value="Paraguay"> Paraguay </option>
    <option value="Peru"> Peru </option>
    <option value="Uruguay"> Uruguay </option>
    </optgroup>
    <optgroup label="Asia">
    
    </optgroup>
    <optgroup label="Europa">
    
    </optgroup>
    <optgroup label="Oceania">
    
    </optgroup>
</select>
<br>
<br>
<label for="nacionalidad" class="labele">Nacionalidad</label>
<input type="text" name="nacionalidad" id="nacionalidad" class="form-control inputtext" id="nacionalidad" style="border:none" readonly placeholder="Colombiano"> 


</div>
</div>
<script>
$().ready(function() {
    
	$("#registro").validate({
		rules:{
				telefono:{	
					required:true,
					minlength:10,
					digits:true
					}
			},
			messages: {

				documento:{
					required:"Campo Requerido",
					minlength:"MÃ­nimo {0} caracteres"
					},
				telefono:{	
					required:"Campo Requerido",
					minlength:"MÃ­nimo {0} caracteres",
					digits:"Solo numeros telefonicos"
					}
			}
			});
});

</script>
<div style="width:100%; margin:auto; ">
<button type="submit" class="btn btn-success"> Actualizar </button>
</div>
 <%
                                        }
                                    %>
</form>
<div style="width:100%; background: #0C4391; height: 30px; margin-top:10px; padding-top:5px; border-radius:3px;color:#e2c60f; margin-bottom:1%; float:left">
<a href="../en/profile.html">English</a> ||  <a href="../es/profile.html">Spanish</a>
</div>
</main>
</body>
</html>
