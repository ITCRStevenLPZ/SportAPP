package com.sportapp.pesos;

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

import com.sportapp.databases.PesoConex;
import com.sportapp.databases.Pesos;


public class selPesosServlet extends HttpServlet {
	
	PesoConex conex = new PesoConex();
	Pesos p = new Pesos();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "¡Consultar Pesos!":
			List<Pesos>datos = conex.listar();
			req.setAttribute("pesos", datos);
			req.getRequestDispatcher("ConsPesos.jsp").forward(req, res);
			break;
		case "Modificar":
			Pesos pe = conex.listarId(id);
			req.setAttribute("peso", pe);
			req.getRequestDispatcher("ModPesos.jsp").forward(req, res);
			break;
		case "Eliminar":
			conex.eliminar(id);
			res.sendRedirect("ConsPesos.jsp");
			break;
		case "Actualizar":
			java.util.Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
			float peso = Float.parseFloat(req.getParameter("peso"));
			String descripcion = req.getParameter("descripcion");
			int ID = Integer.parseInt(req.getParameter("ID"));
			p.setID(ID);
			p.setFecha(fecha);
			p.setPeso(peso);
			p.setDescripcion(descripcion);
			conex.actualizar(p);
			res.sendRedirect("ConsPesos.jsp");
			break;
		default:
			throw new AssertionError();
		}
	}

}
