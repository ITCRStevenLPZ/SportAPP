package com.sportapp.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PesoConex {
	PreparedStatement ps;
	ResultSet rs;
	Conexion c = new Conexion();
	Connection con;
	public PesoConex() {
	}
	public List listar() {
		List<Pesos> lista = new ArrayList<>();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("Select distinct * from pesos inner join usuario_pesos on pesos.id_pesos = usuario_pesos.id_pesos");
			rs = ps.executeQuery();
			while(rs.next()) {
				Pesos p= new Pesos();
				p.setID(rs.getInt(1));
				p.setFecha(rs.getDate(3));
				p.setPeso(rs.getFloat(4));
				p.setDescripcion(rs.getString(2));
				lista.add(p);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return lista;
	}
	
	public void insertar (String fecha,float peso,String descripcion,int cedula)  {
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("INSERT INTO pesos(descripcion,peso,fecha) VALUES ('"+descripcion+"', "+peso+", to_date('" + fecha + "', 'YYYY-MM-DD'))");
			ps.executeUpdate();
			ps = con.prepareStatement("INSERT INTO usuario_pesos(numero_cedula) VALUES ("+cedula+")");
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Pesos listarId(String id) {
		String sql = "SELECT * FROM pesos where pesos.id_pesos = " + id;
		Pesos p = new Pesos();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setID(rs.getInt(1));
				p.setFecha(rs.getDate(3));
				p.setPeso(rs.getFloat(4));
				p.setDescripcion(rs.getString(2));
				//System.out.println(p.getFecha());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;	
	}
	
	public int actualizar(Pesos p) {
		int r = 0;
		String sql  = "UPDATE pesos set descripcion = ?, fecha = ?, peso = ? where pesos.id_pesos = ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getDescripcion());
			ps.setDate(2, p.getFecha());
			ps.setFloat(3, p.getPeso());
			ps.setInt(4, p.getID());
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
		String sql2 = "Delete FROM pesos where pesos.id_pesos = " + id;
		String sql = "Delete FROM usuario_pesos where usuario_pesos.id_pesos = " + id;
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps = con.prepareStatement(sql2);
			ps.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
}