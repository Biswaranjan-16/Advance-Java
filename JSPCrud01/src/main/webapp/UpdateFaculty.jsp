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
			String fName= request.getParameter("fname");
			String fEmail= request.getParameter("femail");
			String fPass= request.getParameter("fpass");
			String fAdd= request.getParameter("fadd");
			
			
			Connection con = DbConnection.getcon();
			String query="update faculty set fName=?,fEmail=?,fPass=?,fAdd=? where fid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, fName);
			ps.setString(2, fEmail);
			ps.setString(3, fPass);
			ps.setString(4, fAdd);
			ps.setInt(5, fid);
			ps.executeUpdate();
			ps.close();
			con.close();
			response.sendRedirect("Viewfaculty.jsp");
			
		%>
</body>
</html>