package com.sportapp.frecuencias;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.FrecuenciaConex;

public class ingFrecServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		FrecuenciaConex Conex = new FrecuenciaConex();
		int frecuencia = Integer.parseInt(req.getParameter("frecuencia"));
		String descripcion = req.getParameter("descripcion");
		String fecha = req.getParameter("fecha");
		PrintWriter out = res.getWriter();	
		HttpSession session = req.getSession();
		int cedula = (int) session.getAttribute("cedula");
		System.out.println(cedula);
		Conex.insertar(fecha, frecuencia, descripcion, cedula);
		String Error = "Has ingresado tu frecuencia de manera exitosa!";
		out.println("<script type='text/javascript'>");
		out.println("alert(" + "'" + Error + "'" + ");</script>");
		out.println("</head><body></body></html>");
	}		

}


