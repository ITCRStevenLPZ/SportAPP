<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificacion de Datos Personales</title>

<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

#navbar {
  overflow: hidden;
  background-image: url("fondo1.jpg");
  padding: 10px 10px;
  transition: 0.4s;
  position: fixed;
  width: 100%;
  top: 0;
  z-index: 99;
}

#navbar a {
  float: left;
  color: white;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

#navbar a:hover {
  background-color: #e1bdf8;
  color: white;
}

#navbar a.active {
  background-color: #9b00ff;
  color: white;
}
#navbar a.logout {
  background-color: #3366ff;
  color: white;
}

#navbar-right {
  float: right;
}
#navbar-initial {
  float: initial;
}

@media screen and (max-width: 580px) {
  #navbar {
    padding: 20px 10px !important;
  }
  #navbar a {
    float: none;
    display: block;
    text-align: left;
  }
  #navbar-right {
    float: none;
  }
}
.container {
  position: absolute;
  margin: 250px 0px 0px 475px;
  min-width: 1000px;
  padding: 20px;
  background-color: white;
}
.container2 {
  position: absolute;
  margin: 70px 0px 0px 475px;
  max-width: 600px;
  padding: 20px;
  background-color: white;
}
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #9933ff;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
.btn2 {
  background-color: #9933ff;
  color: white;
  padding: 20px 20px;
  border: none;
  cursor: pointer;
  width: 20%;
  opacity: 0.6;
}

.btn2:hover {
  opacity: 1;
}
img {
  display: inline;
  margin: 0px 0px 0px 20px;
}
</style>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		
		if(session.getAttribute("nombreUsuario")==null){
			response.sendRedirect("Login.jsp");	
		}
	%>
<div id="navbar">
  <img src="Logo.png" alt="Logo SportAPP" style="width:10%;">
  <div id="navbar-right">
    <a class="active" href="Menu.jsp">Menu</a>
    <a href="Pesos.jsp">Control de Pesos</a>
    <a href="Frecuencias.jsp">Control de Frecuencias</a>
    <a href="Tests.jsp">Pruebas Fisicas</a><br /><br /><br /><br />
       <form accept-charset="ISO-8859-1" action="logout" autocomplete="off" method="get">
    	<input type="submit" value="CerrarSesion" class="btn2"></input> <br />
	</form>
  </div>
  <div id="navbar-initial">
  	<a href="Menu.jsp">Acerca de Nosotros</a>
  	<a class="active" href="ConfCuenta.jsp">Configurar Cuenta</a>
  	<a href="ConfApp.jsp"> Colaboradores</a>
  </div>
</div>

	<form accept-charset="ISO-8859-1" action="modUsuario" autocomplete="off"
		method="post" class="container">
		<fieldset>
			<h1>¡Cambia tus Datos!</h1>
			<p>Todos los campos son de caracter obligatorios.</p>
			
			<label for="nombrePersona"><b>Nombre</b></label><br /> <input placeholder="Ingresar Nombre" name="nombrePersona" type="text" value="${persona.getNombre()}" required/ /> <br > 
			
			<label for="apellidoPersona"><b>Primer Apellido</b></label><br /> <input placeholder="Ingresar Primer Apellido" name="apellidoPersona"value="${persona.getPrimerApellido()}"  type="text" required/> <br />
			
			<label for="apellidoPersona2"><b>Segundo Apellido</b></label><br /> <input placeholder="Ingresar Segundo Apellido" name="apellidoPersona2" value="${persona.getSegundoApellido()}" type="text" required/> <br /> 
			
			<label for="altura"><b>Altura (en centimetros)</b></label><br /><input placeholder="Ingresar Altura"name="altura" value="${persona.getAltura()}" type="text" required/> <br />
			
			<label for="telefonoPersona"><b>Numero de Telefono</b></label><br /> <input placeholder="Ingresar Numero Telefonico" name="telefonoPersona" value="${persona.getTelefono()}" type="text" required/> <br />
			
			<b>Sexo</b> <br />
			
			<input checked="checked" name="Sexo" type="radio" value="Hombre" required/> <b>Hombre   </b> <input name="Sexo" type="radio" value="Mujer" required/><b> Mujer</b> <br /> <br />
			
			<label for="fechaNacimiento"><b>Fecha de nacimiento  </b> <input type="date" name="fechaNacimiento" min="1940-01-01" max="2030-12-31"> <br /> <br />	
			
			<input type="submit" name = "accion" value="Actualizar" class="btn"></input> <br />
		</fieldset>	
	</form>

<script>
// When the user scrolls down 80px from the top of the document, resize the navbar's padding and the logo's font size
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
    document.getElementById("navbar").style.padding = "10px 10px";
  } else {
    document.getElementById("navbar").style.padding = "40px 10px";
  }
}
</script>

</body>
</html>