<%@page import="co.sena.edu.booking.DAO.personasDAO"%>
<%@page import="co.sena.edu.booking.DTO.personasDTO"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Booking Routers</title>
        <link type="text/css" rel="stylesheet" href="css/css.css" />
        <link type="text/css" rel="stylesheet" href="bootstrap-3.2.0-dist/bootstrap-3.2.0-dist/css/bootstrap.css">
        <link rel="shortcut icon" href="imagenes/br.ico" />
        <script src="scripts/bookclient.js" type="text/javascript">
        </script>
    </head>
    <body>
<div class ="contenedor">
<div class="banner"> 
<p><a href="Index.html"><img src="imagenes/Logo.png" alt="Booking Routers" width="1360" height="126" title="Forget the rest, call the best"  /></a></p>
</div>
                <nav>
                    <ul id="main">  
                        <li><a align="left" href="Index.html">Inicio</a></li>
                        <li><a align="center" href="#">Gestion Reserva</a>
                            <ul class="submain">
                                <li><a href="#">Solicitar Reservas </a></li>
                                <li><a href="#">Modificar Reserva</a> </li>
                                <li><a href="#">Cancelar Reserva</a></li>
                            </ul>
                        </li>
                        <li><a align="center"  href="#">Reportes</a>
                            <ul class="submain">
                                <li><a align="center"  href="#">Reservas</a> </li>
                            </ul>
                        </li>
                        <li><a align="center" href="Index.html">Salir</a> 
                        </li>

                        <main>
                            

                                <%
                                    HttpSession misesion = request.getSession(false);

                                    if (misesion.getAttribute("logueado") != null) {
                                        personasDTO pdto = null;
                                        personasDTO persona = null;
                                        personasDAO pdao = new personasDAO();
                                        pdto = (personasDTO) misesion.getAttribute("logueado");
                                        persona = pdao.ListarUnaPersona(pdto.getIdPersona());                                       
                                                

                                %>

                                <form id="registro" action="modificar" method="post"> 
                                    <table width="744" align="center" id="registro">

                                        <h3><center >MODIFICAR DATOS DE REGISTRO</center></h3>
                                        <main>
                                            <td align="left"><label for="nombre" class="labele"><strong>Nombres<font color="#FF0000">*</strong></label></font></td>
                                            <td><input name="nombres" type="text" value="<%=persona.getNombres()%>" style="width:250px; height:25px " autofocus readonly="readonly" id="nombre" placeholder="Nombres" class="form-control inputtext" tabindex="1" minlenght=3>
                                            </td>
                                            <td><label for="ape" class="labele"><strong>Apellidos<font color="#FF0000">*</strong></label></font></td>
                                            <td><input name="apellidos" type="text" value="<%=persona.getApellidos()%>" style="width:250px; height:25px" autofocus readonly="readonly" id="ape" placeholder="Apellidos" required class="form-control inputtext"tabindex="2" onChange="requisitos(ape)"></td>
                                            <td>&nbsp;</td>    
                                            <tr>
                                                <td><label for="doc" class="labele"><strong>Documento <font color="#FF0000">*</strong></label></font></td>
                                                <td><input name="doc" type="number" value="<%=persona.getIdPersona()%>" style="width:250px; height:30px" autofocus readonly="readonly" id="doc" placeholder="Doc Identidad" required class="form-control inputtext" tabindex="3" onChange="requisitos(doc)"></td>    
                                                <td width="60" nowrap><label for="date" class="labele"><strong>Fecha Nacimiento<font color="#FF0000">* </strong></label></font></td>
                                                <td><input name="date" type="text" value="<%=persona.getFechaNto()%>" readonly="readonly" id="date" style="width:250px; height:25px" required class="form-control inputtext" tabindex="4" onChange="edad()"></td>    
                                            <tr>
                                                <td ><label for="tel" class="labele"><strong> Telefono <font color="#FF0000">*</strong></label></font></td>
                                                <td><input name="tel" type="text" id="tel" value="<%=persona.getTelefono()%>" style="width:250px; height:25px" placeholder="Telefono" autofocus  required class="form-control inputtext" tabindex="6" onChange="requisitos(tel)"></td>   
                                                <td><label for="cor" class="labele"><strong>Correo<font color="#ff0000">*</strong></label></font></td>
                                                <td><input name="cor" type="email" id="cor" value="<%=persona.getCorreoElectronico()%>" style="width:250px; height:25px" placeholder="asldj@misena.edu.co" autofocus required class="form-control inputtext" tabindex="7" onChange="requisitos(cor)"></td>
                                                <td>&nbsp;</td>    
                                            <tr>
                                                <td><label for="paisnac" class="labele"><strong>País <font color="#ff0000">* </strong></label></font></td>
                                                <td><input name="paisnac" id="paisnac" value="<%=persona.getIdNacionalidad()%>" style="width:250px; height:30px" placeholder="Seleccione país" autofocus required class="form-control inputtext" list="paises" tabindex="8" >
                                                    <datalist id="paises">
                                                        <option value="1">Argentina</option>
                                                        <option value="2">Brasil</option>
                                                        <option value="3">Chile</option>
                                                        <option value="4">Colombia</option>
                                                        <option value="5">Ecuador</option>
                                                        <option value="6">Perú</option>
                                                    </datalist>
                                                </td>

                                            <a name="war" id="war" class="tooltip" href="#" hidden><font color="#FF0000">* Campo requerido</font><span class="custom critical"><img src="imagenes/Critical.png" alt="Error" height="48" width="48"><em>Critico</em>Los campos en Rojo se deben diligenciar</span></a>
                                            </td>
                                            <td><label for="ciunac" class="labele"><strong>Ciudad<font color="#FF0000">*</strong></label></font></td>
                                            <td><input name="ciunac" id="ciunac"value="<%=persona.getPais()%>" style="width:250px; height:30px" placeholder="Seleccione ciudad" autofocus required class="form-control inputtext"  list="ciudades" tabindex="9">
                                                <datalist id="ciudades">
                                                    <option label="BOG">Bogota</option>
                                                    <option label="CLO">Cali</option>
                                                    <option label="MED">Medellin</option>
                                                    <option label="BAR">Barranquilla</option>
                                                </datalist>
                                            </td>
                                            <td nowrap>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            </tr>
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
                                    </fieldset>
                                    <%
                                        }
                                    %>
                                </form>
                            </div>                            
                        </main>
                           <div class="idioma4">
                           <a href="../en/pass.html">English</a> ||  <a href="../es/pass.html">Spanish</a>
                          </div>
                        </body>
                        <html>

