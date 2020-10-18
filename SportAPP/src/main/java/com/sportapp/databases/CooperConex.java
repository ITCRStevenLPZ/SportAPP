package com.sportapp.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.Row;

public class CooperConex {
	PreparedStatement ps;
	ResultSet rs;
	ResultSet rs2;
	Conexion c = new Conexion();
	Connection con;
	Session sess;
	public CooperConex() {
	}

	public List<Cooper> listar() {
		List<Cooper> lista = new ArrayList<>();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("Select distinct * from test_cooper inner join usuario_cooper on test_cooper.cooper_id = usuario_cooper.id_cooper");
			rs = ps.executeQuery();
			while(rs.next()) {
				Cooper co= new Cooper();
				co.setID(rs.getInt(1));
				co.setFecha(rs.getDate(2));
				co.setDistancia(rs.getInt(3));
				co.setResultado(rs.getString(4));			
				lista.add(co);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return lista;
	}
	public String evaluarCooper(int edad, int res) {
		String resultado = "No es aplicable";
		try {
			sess= c.conectarCassandra();
		    String cqlStatement = "SELECT * FROM cooper";
		    for (Row row : sess.execute(cqlStatement)) {
		    	int c_edad = row.getInt("cooper_edad");
		    	if(edad >= c_edad && edad < (c_edad + 10) ) {
		        	if(res <= row.getInt("cooper_malo")) {
		        		resultado = "Malo";
		        	}else if(res >= row.getInt("cooper_medio")&& res < row.getInt("cooper_bueno")) {
		        		resultado = "Medio";
		        	}else if(res >= row.getInt("cooper_bueno")&& res < row.getInt("cooper_muy_bueno")) {
		        		resultado = "Bueno";
		        	}else if(res >= row.getInt("cooper_muy_bueno")&& res < row.getInt("cooper_excelente")){
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
	
	public void insertar (String fecha,int distancia,int edad, int res, int cedula)  {

		try {
			con = c.conectarOracle();
			ps = con.prepareStatement("INSERT INTO test_cooper(fecha_test,distancia,resultado) VALUES (to_date('" + fecha + "', 'YYYY-MM-DD'),"+distancia+", '"+evaluarCooper(edad,res)+"')");
			ps.executeQuery();
			ps = con.prepareStatement("INSERT INTO usuario_cooper(numero_cedula) VALUES ("+cedula+")");
			ps.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public Cooper listarId(String id) {
		String sql = "SELECT * FROM test_cooper where test_cooper.cooper_id = " + id;
		Cooper co = new Cooper();
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				co.setID(rs.getInt(1));
				co.setFecha(rs.getDate(2));
				co.setDistancia(rs.getInt(3));
				co.setResultado(rs.getString(4));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return co;	
	}
	
	public int actualizar(Cooper co) {
		int r = 0;
		String sql  = "UPDATE test_cooper set fecha_test = ?, distancia = ?, resultado = ? where test_cooper.cooper_id= ?";
		try {
			con = c.conectarOracle();
			ps = con.prepareStatement(sql);
			ps.setDate(1, co.getFecha());
			ps.setInt(2, co.getDistancia());	
			ps.setString(3, co.getResultado());
			ps.setInt(4, co.getID());
			System.out.println(co.getID());
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
		String sql2 = "Delete FROM test_cooper where test_cooper.cooper_id = " + id;
		String sql = "Delete FROM usuario_cooper where usuario_cooper.id_cooper = " + id;
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
	
	public List<CooperData> listarData() {
		List<CooperData> lista = new ArrayList<>();
		try {
			sess= c.conectarCassandra();
			String cqlStatement = "SELECT * FROM cooper";
		    for (Row row : sess.execute(cqlStatement)) {
		    	CooperData nuevo = new CooperData();
		    	nuevo.setEdad(row.getInt("cooper_edad"));
		    	nuevo.setMalo(row.getInt("cooper_malo"));
		    	nuevo.setMedio(row.getInt("cooper_medio"));
		    	nuevo.setBueno(row.getInt("cooper_bueno"));
		    	nuevo.setMuy_bueno(row.getInt("cooper_muy_bueno"));
		    	nuevo.setExcelente(row.getInt("cooper_excelente"));
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
			String cqlStatement = "SELECT * FROM cooper";
		    for (Row row : sess.execute(cqlStatement)) {
		    	if(row.getInt("cooper_edad")==edad) {
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
			String cqlStatement= "insert into cooper(cooper_edad, cooper_malo, cooper_medio, cooper_bueno, cooper_muy_bueno, cooper_excelente) values ("+edad+","+malo+","+medio+","+bueno+","+muyBueno+","+excelente+")";
			sess.execute(cqlStatement);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void actualizarData(CooperData co) {
		String cqlStatement= "update cooper SET cooper_malo = "+co.getMalo()+" , cooper_medio = "+co.getMedio()+", cooper_bueno = "+co.getBueno()+", cooper_muy_bueno = "+co.getMuy_bueno()+", cooper_excelente = "+co.getExcelente()+" where cooper_edad ="+co.getEdad();
		try {
			con = c.conectarOracle();
			sess.execute(cqlStatement);
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	
	public CooperData MostrarxID(int id) {
		String cqlStatement = "SELECT * FROM cooper WHERE cooper_edad = " + id;
		CooperData co = new CooperData();
		try {
			sess= c.conectarCassandra();
		    for (Row row : sess.execute(cqlStatement)) {
		    	co.setEdad(row.getInt("cooper_edad"));
		    	co.setMalo(row.getInt("cooper_malo"));
		    	co.setMedio(row.getInt("cooper_medio"));
		    	co.setBueno(row.getInt("cooper_bueno"));
		    	co.setMuy_bueno(row.getInt("cooper_muy_bueno"));
		    	co.setExcelente(row.getInt("cooper_excelente"));
		    }
		}catch(Exception e){		
			e.printStackTrace();
			
		}
		return co;
	}
	
	public void eliminarData(int id) {
		String cqlStatement= "DELETE FROM cooper WHERE cooper_edad="+id;
		try {
			con = c.conectarOracle();
			sess.execute(cqlStatement);
			
			}catch(Exception e){
				e.printStackTrace();
		}
	}
}