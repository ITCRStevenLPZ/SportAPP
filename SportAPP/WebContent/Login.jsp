<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>¡Ingresa Sesion!</title>

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

  min-height: 480px;

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
  display: block;
  margin-left: 600px;
  margin-right: auto;
}
</style>
</head>
<div class="bg-img">
<body>
<img src="Logo.png" alt="Logo SportAPP" style="width:30%;">
	<form accept-charset="UTF-8" action="login" autocomplete="off"
		method="post" class = "container">
			<legend>¡Si ya tienes cuenta, ingresa!</legend>
			<label for="nombreUsuario"><b>Nombre de Usuario</b></label><br /> <input name="nombreUsuario" type="text" required/> <br />

			<label for="contrasenaUsuario"><b>Contrasena</b></label><br /> <input name="contrasenaUsuario" type="password" required/> <br />

			<a href="Olvidar.jsp">¿Olvido la contrasena?</a>
			
			<button type="submit" value="login" class = "btn">Ingresar Sesion</button>
	</form>
	<form action="Register.jsp" class = "container2">	
	<legend>¿Eres nuevo?, ¡Registrate!<br ></legend>
	<button type="submit" class = "btn" value="register">¡Registrate Aca!</button>
	</form>
</body>
</html>