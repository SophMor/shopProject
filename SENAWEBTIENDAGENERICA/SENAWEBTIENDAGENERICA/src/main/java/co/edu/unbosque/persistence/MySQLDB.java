package co.edu.unbosque.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLDB {

	private String cxString = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC&useSSL=false";
	private String user = "root";
	private String pass = "";
	private Connection con = null;
	private Statement stmt;
	private ResultSet rs;

	public String conectar() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(cxString, user, pass);
		} catch (Exception e) {
			return e.toString();
		}
		return "OK";
	}

	public String insertarDB(String cadenaInsert) {
		String res = "";
		try {
			res = conectar();
			stmt = con.createStatement();
			stmt.executeUpdate(cadenaInsert);
			con.close();
		} catch (Exception e) {
			return res +"----"+e.toString();
		}
		return "OK";
	}
}
