package com.sportapp.databases;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	String dbURL = "jdbc:oracle:thin:@192.168.0.15:1521:db1";
    String username = "ronald";
    String password = "Roniexy50";
	Cluster cluster;
	Session session = null;
	Connection conn = null;
	public Connection conectarOracle(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
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
