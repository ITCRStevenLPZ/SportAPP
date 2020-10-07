package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String nombrePersona = req.getParameter("nombrePersona");
		String apellidoPersona = req.getParameter("apellidoPersona");
		String apellidoPersona2 = req.getParameter("apellidoPersona2");
		int cedulaPersona = Integer.parseInt(req.getParameter("cedulaPersona"));
		int telefonoPersona = Integer.parseInt(req.getParameter("telefonoPersona"));
		int telefonoPersona2 = Integer.parseInt(req.getParameter("telefonoPersona2"));
		
		PrintWriter out = res.getWriter();
		out.println(nombrePersona +"\n" + apellidoPersona+"\n" + apellidoPersona2 +"\n" + cedulaPersona +"\n" + telefonoPersona +"\n" + telefonoPersona2 );

	}
}
