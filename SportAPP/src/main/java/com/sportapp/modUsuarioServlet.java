package com.sportapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportapp.databases.Persona;
import com.sportapp.databases.PersonaConex;



public class modUsuarioServlet extends HttpServlet {
	
	PersonaConex conex = new PersonaConex();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "Cambiar Contrasena":
			HttpSession session = req.getSession();
			int cedula = (int) session.getAttribute("cedula");
			Persona p = conex.listar(cedula);
			req.setAttribute("persona", p);
			req.getRequestDispatcher("CambiarContrasena.jsp").forward(req, res);
			break;
		case "Cambiar Datos de Cuenta":
			HttpSession session1 = req.getSession();
			int cedula1 = (int) session1.getAttribute("cedula");
			Persona p1 = conex.listar(cedula1);
			req.setAttribute("persona", p1);
			req.getRequestDispatcher("ModificarUsuario.jsp").forward(req, res);
			break;
		case "Actualizar":
			HttpSession session2 = req.getSession();
			int cedula2 = (int) session2.getAttribute("cedula");
			Persona p2 = conex.listar(cedula2);
			java.util.Date utilDate = null;
			try {
				utilDate = new SimpleDateFormat("YYYY-MM-DD").parse(req.getParameter("fechaNacimiento"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
			p2.setNombre(req.getParameter("nombrePersona"));
			p2.setPrimerApellido(req.getParameter("apellidoPersona"));
			p2.setSegundoApellido(req.getParameter("apellidoPersona2"));
			p2.setCedula(cedula2);
			p2.setAltura(Float.parseFloat(req.getParameter("altura")));
			p2.setTelefono(Integer.parseInt(req.getParameter("telefonoPersona")));
			p2.setSexo(req.getParameter("Sexo"));
			p2.setFechaNacimiento(fecha);
			conex.actualizar(p2);
			res.sendRedirect("ConfCuenta.jsp");
			break;
		case "Actualizar Contrasena":
			HttpSession session3 = req.getSession();
			int cedula3 = (int) session3.getAttribute("cedula");
			Persona p3 = conex.listar(cedula3);
			PrintWriter out = res.getWriter();
			if(!req.getParameter("contrasenaNueva").equals(req.getParameter("repetirContrasena"))) {
				String Error = "Error, has ingresado la nueva contrasena mal!";
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + Error + "'" + ");</script>");
				out.println("</head><body></body></html>");
			}else if(0 == conex.ingresar((String)session3.getAttribute("nombreUsuario"), req.getParameter("contrasenaActual"))) {
				String Error = "Error, has ingresado la contrasena actual mal!";
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + Error + "'" + ");</script>");
				out.println("</head><body></body></html>");
			}else {
				p3.setContrasena(req.getParameter("contrasenaNueva"));
				p3.setRespuesta1(req.getParameter("pregunta1"));
				p3.setRespuesta2(req.getParameter("pregunta2"));
				p3.setRespuesta3(req.getParameter("pregunta3"));
				p3.setCedula(cedula3);
				conex.actualizarContrasena(p3);
				res.sendRedirect("ConfCuenta.jsp");
			}
			break;
		case "Recuperar Contrasena":
			PrintWriter out1 = res.getWriter();
			HttpSession session4 = req.getSession();
			Persona p4 = conex.listar(Integer.parseInt(req.getParameter("cedulaPersona")));
			if(!p4.getNombreUsuario().equals(req.getParameter("nombreUsuario"))){
				String Error = "Error, el nombre del usuario no coincide!";
				out1.println("<script type='text/javascript'>");
				out1.println("alert(" + "'" + Error + "'" + ");</script>");
				out1.println("</head><body></body></html>");
			}else if(!p4.getRespuesta1().equals(req.getParameter("respuesta1"))||!p4.getRespuesta2().equals(req.getParameter("respuesta2"))||!p4.getRespuesta3().equals(req.getParameter("respuesta3"))) {
				String Error = "Error, las respuestas a las preguntas no coinciden!";
				out1.println("<script type='text/javascript'>");
				out1.println("alert(" + "'" + Error + "'" + ");</script>");
				out1.println("</head><body></body></html>");
			}else if(!req.getParameter("contrasena").equals(req.getParameter("confirmarContrasena"))) {
					String Error = "Error, has ingresado la nueva contrasena mal!";
					out1.println("<script type='text/javascript'>");
					out1.println("alert(" + "'" + Error + "'" + ");</script>");
					out1.println("</head><body></body></html>");					
			}else {
				p4.setContrasena(req.getParameter("contrasena"));
				conex.actualizarContrasena(p4);
				session4.setAttribute("nombreUsuario", p4.getNombreUsuario());
				session4.setAttribute("contrasena", p4.getContrasena());
				session4.setAttribute("cedula", p4.getCedula());
				res.sendRedirect("Menu.jsp");
			}
			break;
		default:
			throw new AssertionError();
		}
	}

}