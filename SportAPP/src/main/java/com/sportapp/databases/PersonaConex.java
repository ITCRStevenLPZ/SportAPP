package com.sportapp.databases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaConex {
	PreparedStatement ps;
	ResultSet rs;
	ResultSet rs2;
	Conexion c = new Conexion();
	Connection con;
	public PersonaConex() {
	}
	/*public List listar(int cedPersona) {
		List<Persona> lista = new ArrayList<>();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("Select * from Persona");
			rs = ps.executeQuery();
			while(rs.next()) {
				Pesos p= new Pesos();
				p.setFecha(rs.getDate(1));
				p.setPeso(rs.getFloat(2));
				p.setDescripcion(rs.getString(3));
				lista.add(p);
			}
		}catch(Exception e){
			
		}
		return lista;
	}*/
	
	public Boolean insertar (String nombre, String primerApellido, String segundoApellido, int cedula, int altura, int telefono,
			String sexo, String fechaNacimiento, String nombreUsuario, String contrasena, String respuesta1, String respuesta2, String respuesta3) {
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("SELECT username_check('"+nombreUsuario+"') FROM registro");
			rs = ps.executeQuery();
			ps = con.prepareStatement("SELECT cedula_check("+cedula+") FROM registro");
			rs2 = ps.executeQuery();
			if(rs==null || rs2!=null) {
				return null;
			}else {
				ps = con.prepareStatement("INSERT INTO usuarios(numero_cedula,altura,primer_apellido, segundo_apellido, nombre, sexo, telefono, fecha_nacimiento) VALUES('"+ cedula+ "', '" + altura + "', '" + primerApellido + "', '" + segundoApellido + "', '" + nombre + "', '" + sexo + "', '" + telefono + "', to_date('" + fechaNacimiento + "', 'YYYY-MM-DD')" +")");
				ps.executeQuery();
				ps = con.prepareStatement("INSERT INTO registro(numero_cedula,nombre_usuario,contrasena,res_pre_1, res_pre_2,res_pre_3) VALUES('"+ cedula+ "', '" + nombreUsuario + "', '" + contrasena + "', '" + respuesta1 + "', '" + respuesta2 + "', '" + respuesta3 +"')");
				ps.executeQuery();
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int ingresar(String nombreUsuario, String contrasena) {
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("SELECT validar('"+nombreUsuario+"','"+contrasena+"') FROM registro");
			rs = ps.executeQuery();
			ps = con.prepareStatement("SELECT username_check('"+nombreUsuario+"')FROM registro");
			rs2 = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1) == null) {
					return 0;
				}else {
					if(rs2.next()) {
						if(rs2.getString(1) == null) {
							return 0;
						}else {
							return Integer.parseInt(rs2.getString(1));
						}
					}else {
						if(rs2.getString(1) == null) {
							return 0;
						}else {
							return Integer.parseInt(rs2.getString(1));
						}
					}
				}
			}else {
				if(rs2.next()) {
					if(rs2.getString(1) == null) {
						return 0;
					}else {
						return Integer.parseInt(rs2.getString(1));
					}
				}else {
					if(rs2.getString(1) == null) {
						return 0;
					}else {
						return Integer.parseInt(rs2.getString(1));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public Persona listar(int cedula) {
		String sql = "SELECT * FROM usuarios where usuarios.numero_cedula = " + cedula;
		String sql2 = "SELECT * FROM registro where registro.numero_cedula = " + cedula;
		Persona p = new Persona();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setNombre(rs.getString(1));
				p.setPrimerApellido(rs.getString(2));
				p.setSegundoApellido(rs.getString(3));
				p.setCedula(rs.getInt(4));
				p.setAltura(rs.getFloat(5));
				p.setTelefono(rs.getInt(6));
				p.setSexo(rs.getString(7));
				p.setFechaNacimiento(rs.getDate(8));
			}
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setNombreUsuario(rs.getString(2));
				p.setContrasena(rs.getString(3));
				p.setRespuesta1(rs.getString(4));
				p.setRespuesta2(rs.getString(5));
				p.setRespuesta3(rs.getString(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;	
	}
	public int actualizar(Persona p) {
		int r = 0;
		String sql  = "UPDATE usuarios set nombre = ?, primer_apellido = ?, segundo_apellido = ?, altura = ?, telefono = ?, sexo = ?, fecha_nacimiento = ? where usuarios.numero_cedula = ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getPrimerApellido());
			ps.setString(3, p.getSegundoApellido());
			ps.setFloat(4, p.getAltura());
			ps.setInt(5, p.getTelefono());
			ps.setString(6, p.getSexo());
			ps.setDate(7, p.getFechaNacimiento());
			ps.setInt(8, p.getCedula());
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
	
	public int actualizarContrasena(Persona p) {
		int r = 0;
		String sql  = "UPDATE registro set contrasena = ?, res_pre_1 = ?, res_pre_2 = ?, res_pre_3 = ? where registro.numero_cedula = ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getContrasena());
			ps.setString(2, p.getRespuesta1());
			ps.setString(3, p.getRespuesta2());
			ps.setString(4, p.getRespuesta3());
			ps.setInt(5, p.getCedula());
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
}