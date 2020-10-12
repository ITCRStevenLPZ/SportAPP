package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nombreUsuario = req.getParameter("nombreUsuario");
		String contrasenaUsuario = req.getParameter("contrasenaUsuario");;
		PrintWriter out = res.getWriter();		
		res.sendRedirect("Menu.jsp");
	}


}
