import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sportapp.databases.Conexion;

public class main {
	public static void main(String[] args) {
		Conexion c = new Conexion();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try {
			con = c.conectarOracle();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	

}
