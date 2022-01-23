package Conecta;

import java.sql.*;
import javax.swing.JOptionPane;



public class sqliteConnection {
	Connection conn = null;
	public static Connection dbConnector() {
	
		
		//conexión con la BD
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:Arkanoid.db");
			return conn;
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}