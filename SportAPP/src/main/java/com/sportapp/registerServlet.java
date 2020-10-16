package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.PersonaConex;
public class registerServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PersonaConex Conex = new PersonaConex();
		String nombrePersona = req.getParameter("nombrePersona");
		String apellidoPersona = req.getParameter("apellidoPersona");
		String apellidoPersona2 = req.getParameter("apellidoPersona2");
		int cedulaPersona = Integer.parseInt(req.getParameter("cedulaPersona"));
		int altura = Integer.parseInt(req.getParameter("altura"));
		int telefonoPersona = Integer.parseInt(req.getParameter("telefonoPersona"));
		String nombreUsuario= req.getParameter("nombreUsuario");
		String fechaNacimiento = req.getParameter("fechaNacimiento");
		String contrasena = req.getParameter("contrasena");
		String confirmarContrasena = req.getParameter("confirmarContrasena");
		String sexo = req.getParameter("Sexo");
		String respuesta1 = req.getParameter("pregunta1");
		String respuesta2 = req.getParameter("pregunta2");
		String respuesta3 = req.getParameter("pregunta3");
		
		PrintWriter out = res.getWriter();
		
		if(!contrasena.equals(confirmarContrasena)) {
			String Error = "Error, has ingresado la contrasena mal!";
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + Error + "'" + ");</script>");
			out.println("</head><body></body></html>");
			res.sendRedirect("Register.jsp");
		}else {
			Boolean veri = Conex.insertar(nombrePersona, apellidoPersona, apellidoPersona2, cedulaPersona, altura, telefonoPersona, sexo, fechaNacimiento,nombreUsuario, contrasena,respuesta1,respuesta2,respuesta3);
			if(veri==null) {
				String Error = "Error, has ingresado un nombre de usuario que ya existe o la cedula ya esta registrada !";
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + Error + "'" + ");</script>");
				out.println("</head><body></body></html>");
			}else {
				HttpSession session = req.getSession();
				session.setAttribute("nombreUsuario", nombreUsuario);
				session.setAttribute("contrasena", contrasena);
				session.setAttribute("cedula", cedulaPersona);
				res.sendRedirect("Menu.jsp");
			}

		}
		
		
		

	}
}
