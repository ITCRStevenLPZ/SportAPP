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
import com.sportapp.databases.CooperData;




public class cooperDataServlet extends HttpServlet {
	
	CooperConex conex = new CooperConex();
	CooperData co = new CooperData();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String accion = req.getParameter("accion");	
		switch(accion) {
		case "Cambiar Datos Cooper":
			res.sendRedirect("CooperConf.jsp");
			break;
		case "Consultar Datos Cooper":
			List<CooperData>datos = conex.listarData();
			req.setAttribute("dataCoopers", datos);
			req.getRequestDispatcher("CooperConf.jsp").forward(req, res);
			break;
		case "Ingresar Nuevo Dato":
			int edad = Integer.parseInt((String) req.getParameter("edad"));
			int malo  = Integer.parseInt((String) req.getParameter("malo"));
			int medio = Integer.parseInt((String) req.getParameter("medio"));
			int bueno = Integer.parseInt((String) req.getParameter("bueno"));
			int muyBueno = Integer.parseInt((String) req.getParameter("muyBueno"));
			int excelente = Integer.parseInt((String) req.getParameter("excelente"));
			if(conex.VerificarEdad(edad)==false) {
				conex.insertarData(edad, malo, medio, bueno, muyBueno, excelente);
				res.sendRedirect("CooperConf.jsp");
			}else {
				String Error = "Error, has ingresado una edad que ya esta registrada, verifica a la derecha!";
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + Error + "'" + ");</script>");
				out.println("</head><body></body></html>");
			}
			break;
			
		case "Modificar":
			CooperData data = conex.MostrarxID(Integer.parseInt((String) req.getParameter("edad")));
			req.setAttribute("dataCooper", data);
			req.getRequestDispatcher("CooperConfMod.jsp").forward(req, res);
			break;
		case "Actualizar":
			CooperData co1 = new CooperData();
			co1.setEdad(Integer.parseInt((String) req.getParameter("edad")));
			co1.setMalo(Integer.parseInt((String) req.getParameter("malo")));
			co1.setMedio(Integer.parseInt((String) req.getParameter("medio")));
			co1.setBueno(Integer.parseInt((String) req.getParameter("bueno")));
			co1.setMuy_bueno(Integer.parseInt((String) req.getParameter("muyBueno")));
			co1.setExcelente(Integer.parseInt((String) req.getParameter("excelente")));
			conex.actualizarData(co1);
			res.sendRedirect("CooperConf.jsp");
			break;
		case "Eliminar":
			conex.eliminarData(Integer.parseInt((String) req.getParameter("edad")));
			res.sendRedirect("CooperConf.jsp");
			break;
		default:
			throw new AssertionError();
		}
	}

}
