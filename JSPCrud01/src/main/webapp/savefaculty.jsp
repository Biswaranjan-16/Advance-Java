<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Faculty</title>
</head>
<body>
	<%
	int status = 0;
	String fname = request.getParameter("fname");
	String femail = request.getParameter("femail");
	String fpass = request.getParameter("fpass");
	String fadd = request.getParameter("fadd");

	Connection con = DbConnection.getcon();
	String query = "insert into faculty(fname,femail,fpass,fadd)values(?,?,?,?)";
	PreparedStatement ps = con.prepareStatement(query);

	ps.setString(1, fname);
	ps.setString(2, femail);
	ps.setString(3, fpass);
	ps.setString(4, fadd);
	status = ps.executeUpdate();

	if (status > 0) {
	%>
	<h1 style="color: green">Data Inserted Successfully !!!</h1>
	<a href="index.jsp">Back</a>
	<%
	} else {
	%>
	<h1 style="color: red">Data Inserted failed !!!</h1>
	<a href="index.jsp">Back</a>
	<%
	}
	%>
</body>
</html>