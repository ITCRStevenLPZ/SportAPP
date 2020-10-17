package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.PersonaConex;

public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersonaConex Conex = new PersonaConex();
		String nombreUsuario = req.getParameter("nombreUsuario");
		String contrasenaUsuario = req.getParameter("contrasenaUsuario");	
		PrintWriter out = res.getWriter();
		int veri = Conex.ingresar(nombreUsuario, contrasenaUsuario);
		if(veri==0) {
			String Error = "Error, has ingresado un nombre de usuario no existe o una contrasena incorrecta!";
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + Error + "'" + ");</script>");
			out.println("</head><body></body></html>");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("nombreUsuario", nombreUsuario);
			session.setAttribute("contrasena", contrasenaUsuario);
			session.setAttribute("cedula", veri);
			System.out.println(veri);
			res.sendRedirect("Menu.jsp");
		}
		
	}


}
