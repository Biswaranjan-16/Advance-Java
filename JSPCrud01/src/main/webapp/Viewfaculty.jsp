<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View faculty</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<table class="table table-hover table-success table-striped">
				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
						<th scope="col">Address</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>

				<tbody>
					<%
					Connection con = DbConnection.getcon();
					String query = "select fid,fname,femail,fpass,fadd from faculty";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
					%>
					<tr>
						<th scope="row">
							<%
							out.print(rs.getInt(1));
							%>
						</th>
						<th>
							<%
							out.print(rs.getString(2));
							%>
						</th>
						<th>
							<%
							out.print(rs.getString(3));
							%>
						</th>
						<th>
							<%
							out.print(rs.getString(4));
							%>
						</th>
						<th>
							<%
							out.print(rs.getString(5));
							%>
						</th>
						<th><a class="btn btn-info" href="editFaculty.jsp?fid=<% out.print(rs.getInt(1));%>">Edit</a></th>
						<th><a class="btn btn-danger" href="DeleteFaculty.jsp?fid=<% out.print(rs.getInt(1));%>">Delete</a></th>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>