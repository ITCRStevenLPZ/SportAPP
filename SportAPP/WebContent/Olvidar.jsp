<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RecuperarContrasena</title>
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("fondo1.jpg");

  min-height: 1000px;

  /* Center and scale the image nicely */
  background-position: center;
  background-size: cover;
  position: relative;

}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  top: 0;
  margin: 30px;
  max-width: 600px;
  padding: 20px;
  background-color: white;
}
.container2 {
  position: absolute;
  right: 50;
  top: 0;
  margin: 30px;
  max-width: 700px;
  padding: 20px;
  background-color: white;
}

/* Full-width input fields */
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
img {
  display: inline;
  margin: 300px 0px 0px 1000px;
}
</style>
</head>
<body>
<div class="bg-img">
<img src="Logo.png" alt="Logo SportAPP" style="width:30%;">
	<form accept-charset="UTF-8" action="olvidar" autocomplete="off"
		method="post" class = "container2">
		<fieldset>
			<h1>Cambio de Contrasena</h1>
			<p>¡Para realizar el cambio de contrasena es necesario que ingreses todos estos datos!</p>
			<label for="nombreUsuario"><b>Nombre de Usuario</b></label><br /> <input placeholder="Ingresar Nombre de Usuario" name="nombreUsuario" type="text" required/> <br />
			
			<label for="cedulaPersona"><b>Cedula</b></label><br /> <input placeholder="Ingresar Cedula" name="cedulaPersona" type="text" required/> <br />
			
			<label for="respuesta1"><b>¿Cual es tu color favorito?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="respuesta1" type="text" required/><br />
			 
			<label for="respuesta2"><b>¿Cual es tu deporte favorito?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="respuesta2" type="text" required/><br />
			  
			<label for="respuesta3"><b>¿Cual es tu lugar de nacimiento?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="respuesta3" type="text" required/><br />
			
			<label for="contrasena"><b>Contrasena</b></label><br /><input placeholder="Ingresar Contrasena" id ="contrasena" name="contrasena" type="password" required/> <br />
			
			<input type="checkbox" onclick="mostrarContrasena()"><b> Mostrar Contrasena </b> <br /> <br /> 	
			
			<label for="confirmarContrasena"><b>Repetir contrasena</b></label><br /> <input placeholder="Volver a Ingresar Contrasena" name="confirmarContrasena" type="password" required/> <br /> 
			   
			<button type="submit" value="olvidar" class="btn" >¡Recuperar Contrasena!</button>
		</fieldset>
	</form>
</div>
<script>
function mostrarContrasena() {
  var x = document.getElementById("contrasena");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</body>
</html>