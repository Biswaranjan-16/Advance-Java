package com.biswa.util;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getcon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","biswa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static String Path() {
		
		return "C:/Users/biswa/eclipse-workspace/Medicare_Project/src/main/webapp/Admin/images";
	}
}
