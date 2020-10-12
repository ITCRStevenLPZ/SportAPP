package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class olvidarServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nombreUsuario = req.getParameter("nombreUusario");
		int cedulaPersona = Integer.parseInt(req.getParameter("cedulaPersona"));
		String respuesta1 = req.getParameter("respuesta1");
		String respuesta2 = req.getParameter("respuesta2");
		String respuesta3 = req.getParameter("respuesta3");
		
		PrintWriter out = res.getWriter();
		out.println(respuesta1 +"\n" + respuesta2+"\n" + respuesta3 +"\n" + cedulaPersona +"\n" + nombreUsuario +"\n");
	}

}
