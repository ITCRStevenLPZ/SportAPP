<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registrarse</title>
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

  min-height: 1700px;

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
  margin: 70px 0px 0px 475px;
  max-width: 600px;
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
  margin-left: 350px;
  margin-right: auto;
}
</style>
</head>
<body>

<div class="bg-img">
<img src="Logo.png" alt="Logo SportAPP" style="width:30%;">
	<form action="Login.jsp" class="container2">
	
		<b> ¿Ya tienes cuenta en la aplicacion? </b> <br/> <br/>
		
		<button type="submit" value="login" class="btn">Ingresa Sesion Aca!</button>

	</form>
	<form accept-charset="ISO-8859-1" action="register" autocomplete="off"
		method="post" class="container">
		<fieldset>
			<h1>¡Registrate!</h1>
			<p>Todos los campos son de caracter obligatorios.</p>
			
			<label for="nombrePersona"><b>Nombre</b></label><br /> <input placeholder="Ingresar Nombre" name="nombrePersona" type="text" /> <br required/> 
			
			<label for="apellidoPersona"><b>Primer Apellido</b></label><br /> <input placeholder="Ingresar Primer Apellido" name="apellidoPersona" type="text" required/> <br />
			
			<label for="apellidoPersona2"><b>Segundo Apellido</b></label><br /> <input placeholder="Ingresar Segundo Apellido" name="apellidoPersona2" type="text" required/> <br /> 
			
			<label for="cedulaPersona"><b>Cédula</b></label><br /> <input placeholder="Ingresar Cedula" name="cedulaPersona" type="text" required/> <br /> 
			
			<label for="telefonoPersona"><b>Numero de Telefono</b></label><br /> <input placeholder="Ingresar Numero Telefonico" name="telefonoPersona" type="text" required/> <br />
			
			<label for="nombreUsuario"><b>Nombre de Usuario</b></label><br /> <input placeholder="Ingresar Nombre de Usuario" name="nombreUsuario" type="text" required/> <br /> 
			
			<label for="contrasena"><b>Contrasena</b></label><br /><input placeholder="Ingresar Contrasena" id ="contrasena" name="contrasena" type="password" required/> <br />
			
			<input type="checkbox" onclick="mostrarContrasena()"><b> Mostrar Contrasena </b> <br /> <br /> 
			
			
			<label for="confirmarContrasena"><b>Repetir contrasena</b></label><br /> <input placeholder="Volver a Ingresar Contrasena" name="confirmarContrasena" type="password" required/> <br /> 
			
			<b>Sexo</b> <br />
			
			<input checked="checked" name="Sexo" type="radio" value="Hombre" required/> <b>Hombre   </b> <input name="Sexo" type="radio" value="Mujer" required/><b> Mujer</b> <br /> <br />
			
			<p>Preguntas de Seguridad. ¡Con ellas puedes recuperar tu contrasena!</p> 
			
			<label for="pregunta1"><b>¿Cual es su color favorito?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="pregunta1" type="text" required/> <br /> 
			
			<label for="pregunta2"><b>¿Cual es su deporte favorito?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="pregunta2" type="text" required/><br /> 
			
			<label for="pregunta3"><b>¿Cual es tu lugar de nacimiento?</b></label><br /> <input placeholder="Ingresar Respuesta a Pregunta" name="pregunta3" type="text" required/> <br />
			
			<label for="fecha"><b>Fecha de nacimiento  </b></label><input type="date" name="fecha" min="1940-01-01" required/> <br /><br />
			
			<b>¿Has practicado deporte?</b> <br />
			
			<input checked="checked" name="Deporte" type="radio" value="Si" required/>Si he practricado deporte <input name="Deporte" type="radio" value="No" required/>No he practicado deporte <br /> <br />

			<button type="submit" value="register" class="btn">Registrarse</button> <br />
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