<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int fid=Integer.parseInt(request.getParameter("fid"));
Connection con = DbConnection.getcon();
String query = "delete from faculty where fid=?";
PreparedStatement ps = con.prepareStatement(query);
ps.setInt(1, fid);
ps.executeUpdate();
ps.close();
con.close();
response.sendRedirect("Viewfaculty.jsp");
%>
</body>
</html>