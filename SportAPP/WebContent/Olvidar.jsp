<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RecuperarContrasena</title>
</head>
<body>
	<form accept-charset="UTF-8" action="olvidar" autocomplete="off"
		method="post">
		<fieldset>
			<legend>¡Cambia tu contrasena! Ingresa algunos de tus datos
				y las respuestas a tus preguntas.</legend>
			<label for="nombreUsuario">Nombre de Usuario</label><br /> <input name="nombreUsuario" type="text" /> <br />
			<label for="cedulaPersona">Cedula</label><br /> <input name="cedulaPersona" type="text" /> <br />
			 <label for="respuesta1">¿Cual es tu color favorito?</label><br /> <input name="respuesta1" type="text" /><br />
			  <label for="respuesta2">¿Cual es tu deporte favorito?</label><br /> <input name="respuesta2" type="text" /><br />
			   <label for="respuesta3">¿Cual es tu lugar de nacimiento?</label><br /> <input name="respuesta3" type="text" /><br />
			<button type="submit" value="olvidar">¡Recuperar Contrasena!</button>
		</fieldset>
	</form>
</body>
</html>