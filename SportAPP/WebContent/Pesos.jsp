<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Control Pesos</title>

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
</style>

</head>
<body>
	<%
		//response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		//if(session.getAttribute("nombreUsuario")==null){
		//	response.sendRedirect("Login.jsp");	
		//}
	%>
<div id="navbar">
  <img src="Logo.png" alt="Logo SportAPP" style="width:10%;">
  <div id="navbar-right">
    <a href="Menu.jsp">Menu</a>
    <a class="active" href="Pesos.jsp">Control de Pesos</a>
    <a href="Frecuencias.jsp">Control de Frecuencias</a>
    <a href="Tests.jsp">Pruebas Fisicas</a>
    <a class="logout" href="/logout">Cerrar Sesion</a>
  </div>
  <div id="navbar-initial">
  	<a class="active" href="Pesos.jsp">Insertar Pesos</a>
  	<a href="ConsPesos.jsp">Consultar Pesos</a>
  	<a href="ModPesos.jsp">Modificar y Eliminar Pesos</a>
  </div>
</div>

<div style="margin-top:210px;padding:15px 15px 2500px;font-size:30px">
  <p><b>¡Bienvenido(a) a Insertar Pesos!</b></p>
</div>
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