<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>¡Ingresa Sesion!</title>
</head>
<img src= "Logo.png"  alt="SportAPP Logo"/> 

<legend>¡Bienvenido a SportAPP! La aplicacion donde tu vida fitness va a mejorar de manera 100% gratis.</legend>
<body>
	<form accept-charset="UTF-8" action="login" autocomplete="off"
		method="post">
		<fieldset>
			<legend>¡Si ya tienes cuenta, ingresa!</legend>
			<label for="nombreUsuario">Nombre de Usuario</label><br /> <input
				name="nombreUsuario" type="text" /> <br /> <label
				for="contrasenaUsuario">Contrasena</label><br /> <input
				name="contrasenaUsuario" type="text" /> <br /> 
				<a href="Olvidar.jsp">¿Olvido la
			contrasena?</a>
			<button type="submit" value="login">Ingresar Sesion</button>
		</fieldset>
	</form>
	<form action="Register.jsp">	
	<legend>¿Eres nuevo?, ¡Registrate!<br ></legend>
	<button type="submit" value="register">¡Registrate Aca!</button>
	</form>
</body>
</html>