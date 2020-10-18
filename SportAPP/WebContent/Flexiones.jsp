<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prueba de Flexiones</title>

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
img {
  display: inline;
  margin: 0px 0px 0px 20px;
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
.container {
  position: absolute;
  margin: 250px 920px;
  min-width: 930px;
  padding: 20px;
  background-color: white;
}
.container2 {
  position: absolute;
  margin: 250px 10px;
  min-width: 900px;
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


.btn:hover {
  opacity: 1;
}
.btn3 {
  background-color: #2924cf;
  color: white;
  padding: 20px 20px;
  border: none;
  cursor: pointer;
  width: 35%;
  opacity: 0.6;
}

.btn3:hover {
  opacity: 1;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
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
    <a href="Menu.jsp">Menu</a>
    <a href="Pesos.jsp">Control de Pesos</a>
    <a href="Frecuencias.jsp">Control de Frecuencias</a>
    <a class="active" href="Tests.jsp">Pruebas Fisicas</a><br /><br /><br /><br />
    <form accept-charset="ISO-8859-1" action="logout" autocomplete="off" method="get">
    	<input type="submit" value="CerrarSesion" class="btn2"></input> <br />
	</form>
  </div>
  <div id="navbar-initial">
  	<a href="Tests.jsp">Acerca de las Pruebas</a>
  	<a href="Cooper.jsp">Prueba de Cooper</a>
  	<a class="active" href="Flexiones.jsp">Prueba de Flexiones</a>
  </div>
</div>
<form accept-charset="ISO-8859-1" action="flexiones" autocomplete="off"
		method="post" class="container2">
		<fieldset>
			<h1>¡Realiza la Prueba e Ingresa tus Resultados aca!</h1>
			<p>Todos los campos son de caracter obligatorios.</p>
			
			<label for="fecha"><b>Fecha de Medicion</b></label><input type="date" name="fecha" min="2020-01-01" required/> <br /><br />
			
			<label for="cantidad"><b>Cantidad de Flexiones</b></label><br /> <input placeholder="Ingresar Cantidad de Flexiones" name="cantidad" type="text" /> <br required/> 
			
			<label for="edad"><b>Edad</b></label><br /> <input placeholder="Ingresar Edad" name="edad" type="text" /> <br required/> 

			<input type="submit"  name="accion" value = "¡Ingresar Prueba Flexiones!" class = "btn"></input> 
		</fieldset>	
</form>

	<form accept-charset="ISO-8859-1" action="flexiones" method="post" class="container">
		<fieldset>
			<h1>¡Consulta tus Pruebas de Flexiones!</h1>
			<input type="submit"  name="accion" value = "¡Consultar Resultados de las Pruebas!" class = "btn"></input> <br />
		</fieldset>	
	<div>
		<table>
			<tr>
		    	<th>Cantidad de Flexiones</th>
		    	<th>Fecha</th>
		    	<th>Resultado</th>
			</tr>
		<tbody>
			<c:forEach var="dato" items = "${flexiones}">
				<tr> 
					<td>${dato.getFlexiones()}</td>
					<td>${dato.getFecha()}</td>
					<td>${dato.getResultado()}</td>
					<td>
						<form action="flexiones" method="post">
							<input type="hidden" name  = "ID" value = "${dato.getID()}">						
							<input type="submit" name  = "accion" value = "Modificar" class = "btn3">
							<input type="submit" name  = "accion" value = "Eliminar" class = "btn3">
						</form>
					
					</td>
				</tr>
			</c:forEach> 
		</tbody>

		</table>
	</div>
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