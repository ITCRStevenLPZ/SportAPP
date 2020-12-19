package com.sportapp.databases;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	String dbURL = "jdbc:postgresql://localhost:5432/pruebas";
    String username = "ronald";
    String password = "Roniexy50";
	Cluster cluster;
	Session session = null;
	Connection conn = null;
	public Connection conectarOracle(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println(conn);
		}
		return conn;
	}
	public Session conectarCassandra(){		
		try {
			cluster = Cluster.builder().addContactPoint("localhost").build();
			session = cluster.connect("sportapp");
		}catch (Throwable t){
			t.printStackTrace();
		}
			
		return session;	
	}
}
