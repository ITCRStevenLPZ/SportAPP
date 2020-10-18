package com.sportapp.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

public class FlexionesConex {
	PreparedStatement ps;
	ResultSet rs;
	ResultSet rs2;
	Conexion c = new Conexion();
	Connection con;
	Session sess;
	public FlexionesConex() {
	}

	public List<Flexiones> listar() {
		List<Flexiones> lista = new ArrayList<>();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("Select distinct * from flexiones inner join usuario_flexiones on flexiones.id_flex = usuario_flexiones.id_flexiones");
			rs = ps.executeQuery();
			while(rs.next()) {
				Flexiones co= new Flexiones();
				co.setID(rs.getInt(1));
				co.setFecha(rs.getDate(2));
				co.setFlexiones(rs.getInt(3));
				co.setResultado(rs.getString(4));			
				lista.add(co);
			}
		}catch(Exception e){		
			e.printStackTrace();		
		}
		return lista;
	}
	public String evaluarFlexiones(int edad, int res) {
		String resultado = "No es aplicable";
		try {
			sess= c.conectarCassandra();
		    String cqlStatement = "SELECT * FROM flexiones";
		    for (Row row : sess.execute(cqlStatement)) {
		    	int c_edad = row.getInt("flexiones_edad");
		    	if(edad >= c_edad && edad < (c_edad + 10) ) {
		        	if(res <= row.getInt("flexiones_malo")) {
		        		resultado = "Malo";
		        	}else if(res >= row.getInt("flexiones_medio")&& res < row.getInt("flexiones_bueno")) {
		        		resultado = "Medio";
		        	}else if(res >= row.getInt("flexiones_bueno")&& res < row.getInt("flexiones_muy_bueno")) {
		        		resultado = "Bueno";
		        	}else if(res >= row.getInt("flexiones_muy_bueno")&& res < row.getInt("felxiones_excelente")){
		        		resultado = "Muy Bueno";		   
		        	}else {
		        		resultado = "Excelente";
		        	}
		        }
		    }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 return resultado;
	}
	
	public void insertar (String fecha, int edad, int res, int cedula)  {

		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("INSERT INTO flexiones(fecha_test,cantidad_flexiones,resultado) VALUES (to_date('" + fecha + "', 'YYYY-MM-DD'),"+res+", '"+evaluarFlexiones(edad,res)+"')");
			ps.executeQuery();
			ps = con.prepareStatement("INSERT INTO usuario_flexiones(numero_cedula) VALUES ("+cedula+")");
			ps.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Flexiones listarId(String id) {
		String sql = "SELECT * FROM flexiones where flexiones.id_flex = " + id;
		Flexiones fl = new Flexiones();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				fl.setID(rs.getInt(1));
				fl.setFecha(rs.getDate(2));
				fl.setFlexiones(rs.getInt(3));
				fl.setResultado(rs.getString(4));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return fl;	
	}
	
	public int actualizar(Flexiones co) {
		int r = 0;
		String sql  = "UPDATE flexiones set fecha_test = ?, cantidad_flexiones = ?, resultado = ? where flexiones.id_flex= ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setDate(1, co.getFecha());
			ps.setInt(2, co.getFlexiones());	
			ps.setString(3, co.getResultado());
			ps.setInt(4, co.getID());
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
		String sql2 = "Delete FROM flexiones where flexiones.id_flex = " + id;
		String sql = "Delete FROM usuario_flexiones where usuario_flexiones.id_flexiones = " + id;
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
	public List<FlexionesData> listarData() {
		List<FlexionesData> lista = new ArrayList<>();
		try {
			sess= c.conectarCassandra();
			String cqlStatement = "SELECT * FROM flexiones";
		    for (Row row : sess.execute(cqlStatement)) {
		    	FlexionesData nuevo = new FlexionesData();
		    	nuevo.setEdad(row.getInt("flexiones_edad"));
		    	nuevo.setMalo(row.getInt("flexiones_malo"));
		    	nuevo.setMedio(row.getInt("flexiones_medio"));
		    	nuevo.setBueno(row.getInt("flexiones_bueno"));
		    	nuevo.setMuy_bueno(row.getInt("flexiones_muy_bueno"));
		    	nuevo.setExcelente(row.getInt("felxiones_excelente"));
		    	lista.add(nuevo);
		    }
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return lista;
	
	}
	
	public Boolean VerificarEdad(int edad) {
		try {
			sess= c.conectarCassandra();
			String cqlStatement = "SELECT * FROM flexiones";
		    for (Row row : sess.execute(cqlStatement)) {
		    	if(row.getInt("flexiones_edad")==edad) {
		    		return true;
		    	}
		    }
		}catch(Exception e){		
			e.printStackTrace();
			
		}
		
		return false;
	
	}
	
	public void insertarData (int edad,int malo ,int medio, int bueno, int muyBueno, int excelente)  {
		try {
			sess = c.conectarCassandra();
			String cqlStatement= "insert into flexiones(flexiones_edad, flexiones_malo, flexiones_medio, flexiones_bueno, flexiones_muy_bueno, felxiones_excelente) values ("+edad+","+malo+","+medio+","+bueno+","+muyBueno+","+excelente+")";
			sess.execute(cqlStatement);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void actualizarData(FlexionesData co) {
		String cqlStatement= "update flexiones SET flexiones_malo = "+co.getMalo()+" , flexiones_medio = "+co.getMedio()+", flexiones_bueno = "+co.getBueno()+", flexiones_muy_bueno = "+co.getMuy_bueno()+", felxiones_excelente = "+co.getExcelente()+" where flexiones_edad ="+co.getEdad();
		try {
			con = c.conectarOracle();
			sess.execute(cqlStatement);
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	public FlexionesData MostrarxID(int id) {
		String cqlStatement = "SELECT * FROM flexiones WHERE flexiones_edad = " + id;
		FlexionesData co = new FlexionesData();
		try {
			sess= c.conectarCassandra();
		    for (Row row : sess.execute(cqlStatement)) {
		    	co.setEdad(row.getInt("flexiones_edad"));
		    	co.setMalo(row.getInt("flexiones_malo"));
		    	co.setMedio(row.getInt("flexiones_medio"));
		    	co.setBueno(row.getInt("flexiones_bueno"));
		    	co.setMuy_bueno(row.getInt("flexiones_muy_bueno"));
		    	co.setExcelente(row.getInt("felxiones_excelente"));
		    }
		}catch(Exception e){		
			e.printStackTrace();
			
		}
		return co;
	}
	
	public void eliminarData(int id) {
		String cqlStatement= "DELETE FROM flexiones WHERE flexiones_edad="+id;
		try {
			con = c.conectarOracle();
			sess.execute(cqlStatement);
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
}