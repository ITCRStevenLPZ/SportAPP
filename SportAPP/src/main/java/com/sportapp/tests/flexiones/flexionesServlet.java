package com.sportapp.tests.flexiones;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.Flexiones;
import com.sportapp.databases.FlexionesConex;



public class flexionesServlet extends HttpServlet {
	
	FlexionesConex conex = new FlexionesConex();
	Flexiones fl = new Flexiones();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "¡Ingresar Prueba Flexiones!":
			int cantidad1 = Integer.parseInt(req.getParameter("cantidad"));
			String fecha1 = req.getParameter("fecha");
			int edad1 = Integer.parseInt(req.getParameter("edad"));
			PrintWriter out = res.getWriter();	
			HttpSession session = req.getSession();
			int cedula = (int) session.getAttribute("cedula");
			System.out.println(cedula);
			conex.insertar(fecha1, edad1,cantidad1, cedula);
			String Error = "Has ingresado tu Prueba de Flexiones de manera exitosa!";
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + Error + "'" + ");</script>");
			out.println("</head><body></body></html>");
			break;
		case "¡Consultar Resultados de las Pruebas!":
			List<Flexiones>datos = conex.listar();
			req.setAttribute("flexiones", datos);
			req.getRequestDispatcher("Flexiones.jsp").forward(req, res);
			break;
		case "Modificar":
			Flexiones pe = conex.listarId(id);
			req.setAttribute("flexion", pe);
			req.getRequestDispatcher("ModFlexiones.jsp").forward(req, res);
			break;
		case "Eliminar":
			conex.eliminar(id);
			res.sendRedirect("Flexiones.jsp");
			break;
		case "Actualizar":
			java.util.Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
			int cantidad = Integer.parseInt(req.getParameter("cantidad"));
			int edad = Integer.parseInt(req.getParameter("edad"));
			int ID = Integer.parseInt(req.getParameter("ID"));
			fl.setID(ID);
			fl.setFecha(fecha);
			fl.setFlexiones(cantidad);
			fl.setResultado(conex.evaluarFlexiones(edad, cantidad));
			conex.actualizar(fl);
			res.sendRedirect("Flexiones.jsp");
			break;
		default:
			throw new AssertionError();
		}
	}

}
