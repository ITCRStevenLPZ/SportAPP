<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Principal</title>
</head>
<body>
	<%
		if(session.getAttribute("nombreUsuario")==null){
			response.sendRedirect("Login.jsp");
			out.println(session.getAttribute("nombreUsuario") +"\n" + session.getAttribute("contrasena")+"\n");
		}
	%>
¡Bienvenido(a) a SportAPP!

<form action="logout">
		<input type = "submit" value = "logout" >
</form>

</body>
</html>