package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseController {
	public Connection getConnection() throws SQLException {
		String connectionUrl = "jdbc:mysql://localhost:3306/qlvt.db"; 
		Connection con = DriverManager.getConnection(connectionUrl, "root","root");
		return con;
	}
}