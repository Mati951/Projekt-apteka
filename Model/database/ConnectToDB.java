package database;

import java.sql.*;

public class ConnectToDB {
	public static Connection con;
	public static Statement st;
	public static ResultSet rs;

	public ConnectToDB() throws ClassNotFoundException, SQLException {
		
		
	}
		
	public static void polacz() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sid", "sid");
	}
	
	public static void rozlacz() throws Exception {
		con.close();
	}
}
