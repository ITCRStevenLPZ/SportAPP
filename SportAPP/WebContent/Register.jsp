<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrarse</title>
</head>
<img src= "Logo.png"  alt="SportAPP Logo"/> 
<body>
	<form accept-charset="ISO-8859-1" action="register"
		autocomplete="off" method="post">
		<fieldset>
			<legend>Registrarse, todos los campos son de caracter obligatorio:</legend>
			<label for="nombrePersona">Nombre</label><br /> <input name="nombrePersona" type="text"/> <br /> 
			<label for="apellidoPersona">Primer Apellido</label><br /> <input name="apellidoPersona" type="text"/> <br /> 
			<label for="apellidoPersona2">Segundo Apellido</label><br /> <input name="apellidoPersona2" type="text" /> <br /> 
			<label for="cedulaPersona">Cédula</label><br /> <input name="cedulaPersona" type="text" /> <br /> 
			<label for="telefonoPersona">Numero de Telefono</label><br /> <input name="telefonoPersona" type="text"/> <br /> 
			<label for="telefonoPersona2">Numero de Telefono #2</label><br /> <input name="telefonoPersona2" type="text"/> <br /> 	
			<label for="nombreUsuario">Nombre de Usuario</label><br /> <input name="nombreUsuario" type="text"/> <br /> 	
			<label for="contrasena">Contrasena</label><br /> <input name="contrasena" type="password"/> <br /> 	
			<label for="confirmarContrasena">Repetir contrasena</label><br /> <input name="confirmarContrasena" type="password"/> <br /> 	
			<input checked="checked" name="Sexo" type="radio" value="Hombre" /> Hombre <br /> 
			<input name="Sexo" type="radio" value="Mujer" /> Mujer <br />
			<legend>Preguntas de Seguridad. ¡Con ellas puedes recuperar tu contrasena!</legend>
			<label for="pregunta1">¿Cual es su color favorito?</label><br /> <input name="pregunta1" type="text"/> <br /> 	
			<label for="pregunta2">¿Cual es su deporte favorito?</label><br /> <input name="pregunta2" type="text"/> <br /> 	
			<label for="pregunta3">¿Cual es tu lugar de nacimiento?</label><br /> <input name="pregunta3" type="text"/> <br /> 	

			<button type="submit" value="register">Registrarse</button>
		</fieldset>
	</form>
	
	<form action="Login.jsp">
		<legend>
		¿Ya tienes cuenta en la aplicacion? <br>	
		</legend>
		<button
		type="submit" value="login"> Ingresa Sesion Aca!
		</button>
	
	</form>
</body>
</html>