package com.sportapp.databases;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;  
public class Main {
	public static void main(String[] args) {
			Cluster cluster;
			Session session;
			Connection conn = null;
			try {
				cluster = Cluster.builder().addContactPoint("localhost").build();
				session = cluster.connect("sportapp");
				session.execute("INSERT INTO test (id_test, nombre) VALUES (2, 'Fuerza')");
			}catch (Throwable t){
				
			}
			
			String dbURL = "jdbc:oracle:thin:@192.168.100.55:1521:db1";
            String username = "ronald";
            String password = "Roniexy50";
            
			try {
				conn = DriverManager.getConnection(dbURL, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (conn != null) {
			    System.out.println("Connected");
			  //step3 create the statement object  
			    Statement stmt;
				try {
					stmt = (Statement) conn.createStatement();
				    ResultSet rs=stmt.executeQuery("select * from classes");  
				    while(rs.next())  
				    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				} catch (SQLException e) {
					e.printStackTrace();
				}  


			}
			
		
	}
}
