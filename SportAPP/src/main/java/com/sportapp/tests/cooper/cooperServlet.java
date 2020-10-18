package com.sportapp.tests.cooper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.Cooper;
import com.sportapp.databases.CooperConex;




public class cooperServlet extends HttpServlet {
	
	CooperConex conex = new CooperConex();
	Cooper co = new Cooper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("ID");
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "¡Ingresar Prueba Cooper!":
			int distancia1 = Integer.parseInt(req.getParameter("distancia"));
			String fecha1 = req.getParameter("fecha");
			int edad1 = Integer.parseInt(req.getParameter("edad"));
			int cantidad1 = (int)(0.2 *(distancia1/12)+3.5);
			PrintWriter out = res.getWriter();	
			HttpSession session = req.getSession();
			int cedula = (int) session.getAttribute("cedula");
			System.out.println(cedula);
			conex.insertar(fecha1, distancia1, edad1,cantidad1, cedula);
			String Error = "Has ingresado tu Prueba de Cooper de manera exitosa!";
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + Error + "'" + ");</script>");
			out.println("</head><body></body></html>");
			break;
		case "¡Consultar Resultados de las Pruebas!":
			List<Cooper>datos = conex.listar();
			req.setAttribute("coopers", datos);
			req.getRequestDispatcher("Cooper.jsp").forward(req, res);
			break;
		case "Modificar":
			Cooper pe = conex.listarId(id);
			req.setAttribute("cooper", pe);
			req.getRequestDispatcher("ModCooper.jsp").forward(req, res);
			break;
		case "Eliminar":
			conex.eliminar(id);
			res.sendRedirect("Cooper.jsp");
			break;
		case "Actualizar":
			java.util.Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fecha"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
			int distancia = Integer.parseInt(req.getParameter("distancia"));
			int cantidad = (int)(0.2 *(distancia/12)+3.5);
			int edad = Integer.parseInt(req.getParameter("edad"));
			int ID = Integer.parseInt(req.getParameter("ID"));
			co.setID(ID);
			co.setFecha(fecha);
			co.setDistancia(distancia);
			co.setResultado(conex.evaluarCooper(edad, cantidad));
			conex.actualizar(co);
			res.sendRedirect("Cooper.jsp");
			break;
		default:
			throw new AssertionError();
		}
	}

}
