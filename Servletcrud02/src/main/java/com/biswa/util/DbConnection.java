package com.biswa.util;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.jsp.tagext.TryCatchFinally;

public class DbConnection {
public static Connection getcon() {
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","biswa");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
