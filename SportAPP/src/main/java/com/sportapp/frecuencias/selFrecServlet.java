package com.sportapp.frecuencias;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.FrecuenciaConex;
import com.sportapp.databases.Frecuencias;



public class selFrecServlet extends HttpServlet {
	
	FrecuenciaConex conex = new FrecuenciaConex();
	Frecuencias f = new Frecuencias();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "¡Consultar Frecuencias!":
			List<Frecuencias>datos = conex.listar();
			req.setAttribute("frecuencias", datos);
			req.getRequestDispatcher("ConsFrecuencias.jsp").forward(req, res);
			break;
		case "Modificar":
			Frecuencias fr = conex.listarId(id);
			req.setAttribute("frecuencia", fr);
			req.getRequestDispatcher("ModFrecuencias.jsp").forward(req, res);
			break;
		case "Eliminar":
			conex.eliminar(id);
			res.sendRedirect("ConsFrecuencias.jsp");
			break;
		case "Actualizar":
			java.util.Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
			int frecuencia = Integer.parseInt(req.getParameter("peso"));
			String descripcion = req.getParameter("descripcion");
			int ID = Integer.parseInt(req.getParameter("ID"));
			f.setID(ID);
			f.setFecha(fecha);
			f.setFrecuencia(frecuencia);
			f.setDescripcion(descripcion);
			conex.actualizar(f);
			res.sendRedirect("ConsFrecuencias.jsp");
			break;
		default:
			throw new AssertionError();
		}
	}

}
