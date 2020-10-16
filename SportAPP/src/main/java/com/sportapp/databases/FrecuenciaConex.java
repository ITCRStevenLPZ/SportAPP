package com.sportapp.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FrecuenciaConex {
	PreparedStatement ps;
	ResultSet rs;
	Conexion c = new Conexion();
	Connection con;
	public FrecuenciaConex() {
	}
	public List listar() {
		List<Frecuencias> lista = new ArrayList<>();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("Select distinct * from frecuencias inner join usuario_frecuencias on frecuencias.id_frecuencias = usuario_frecuencias.id_frecuencias");
			rs = ps.executeQuery();
			while(rs.next()) {
				Frecuencias f= new Frecuencias();
				f.setID(rs.getInt(1));
				f.setFecha(rs.getDate(3));
				f.setFrecuencia(rs.getInt(4));
				f.setDescripcion(rs.getString(2));
				lista.add(f);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return lista;
	}
	
	public void insertar (String fecha,int frecuencia,String descripcion,int cedula)  {
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("INSERT INTO frecuencias(descripcion,frecuencia,fecha) VALUES ('"+descripcion+"', "+frecuencia+", to_date('" + fecha + "', 'YYYY-MM-DD'))");
			ps.executeQuery();
			ps = con.prepareStatement("INSERT INTO usuario_frecuencias(numero_cedula) VALUES ("+cedula+")");
			ps.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Frecuencias listarId(String id) {
		String sql = "SELECT * FROM frecuencias where frecuencias.id_frecuencias = " + id;
		Frecuencias f = new Frecuencias();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				f.setID(rs.getInt(1));
				f.setFecha(rs.getDate(3));
				f.setFrecuencia(rs.getInt(4));
				f.setDescripcion(rs.getString(2));
				//System.out.println(p.getFecha());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;	
	}
	
	public int actualizar(Frecuencias f) {
		int r = 0;
		String sql  = "UPDATE frecuencias set descripcion = ?, fecha = ?, frecuencia = ? where frecuencias.id_frecuencias= ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getDescripcion());
			ps.setDate(2, f.getFecha());
			ps.setInt(3, f.getFrecuencia());
			ps.setInt(4, f.getID());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			}else {
				r=0;
			}
			
			}catch(Exception e){
				e.printStackTrace();
		}
		return r;
	}
	public void eliminar(String id) {
		String sql2 = "Delete FROM frecuencias where frecuencias.id_frecuencias = " + id;
		String sql = "Delete FROM usuario_frecuencias where usuario_frecuencias.id_frecuencias = " + id;
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			ps = con.prepareStatement(sql2);
			ps.executeQuery();
		
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
}