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
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		
		if(session.getAttribute("nombreUsuario")==null){
			response.sendRedirect("Login.jsp");	
		}
	%>
¡Bienvenido(a) a SportAPP!



<form action="logout">
		<input type = "submit" value = "logout" >
</form>

</body>
</html>