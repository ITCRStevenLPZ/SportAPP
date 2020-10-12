package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class registerServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String nombrePersona = req.getParameter("nombrePersona");
		String apellidoPersona = req.getParameter("apellidoPersona");
		String apellidoPersona2 = req.getParameter("apellidoPersona2");
		int cedulaPersona = Integer.parseInt(req.getParameter("cedulaPersona"));
		int telefonoPersona = Integer.parseInt(req.getParameter("telefonoPersona"));
		int telefonoPersona2 = Integer.parseInt(req.getParameter("telefonoPersona2"));
		String nombreUsuario= req.getParameter("nombreUsuario");
		String contrasena = req.getParameter("contrasena");
		String confirmarContrasena = req.getParameter("confirmarContrasena");
		String sexo = req.getParameter("Sexo");
		String respuesta1 = req.getParameter("pregunta1");
		String respuesta2 = req.getParameter("pregunta2");
		String respuesta3 = req.getParameter("pregunta3");
		
		PrintWriter out = res.getWriter();
		
		if(!contrasena.equals(confirmarContrasena)) {
			res.sendRedirect("Register.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("nombreUsuario", nombreUsuario);
			session.setAttribute("contrasena", contrasena);
			res.sendRedirect("Menu.jsp");
		}
		
		
		

	}
}
