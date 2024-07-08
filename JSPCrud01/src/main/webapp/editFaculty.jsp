<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Faculty</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
	
	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-9">
				<h1 class="mb-3">Edit Faculty</h1>
				<%
					int fid=Integer.parseInt(request.getParameter("fid"));
				    Connection con = DbConnection.getcon();
					String query="select * from faculty where fid=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, fid);
					ResultSet rs= ps.executeQuery();
					while(rs.next()){
				%>
				<form action="UpdateFaculty.jsp">
					<div class="row g-3">
						<div class="col-md-12">
							<label for="your-name" class="form-label">Faculty Name</label> 
							<input type="hidden" name="fid" value="<% out.print(rs.getInt(1));%>">
							<input type="text" class="form-control" id="your-name" name="fname" value="<% out.print(rs.getString(2)); %>" required>
						</div>

						<div class="col-md-12">
							<label for="your-email" class="form-label">Faculty Email</label>
							<input type="email" class="form-control" id="your-email" name="femail" value="<% out.print(rs.getString(3)); %>" required>
						</div>
						<div class="col-md-12">
							<label for="your-subject" class="form-label">Faculty Password</label> 
							<input type="text" class="form-control" id="your-subject" name="fpass" value="<% out.print(rs.getString(4)); %>">
						</div>
						<div class="col-12">
							<label for="your-message" class="form-label">Faculty Address</label>
							<input class="form-control" id="your-message" name="fadd"  value="<% out.print(rs.getString(5)); %>" required>
						</div>
						<div class="col-12">
							<div class="row">
								<div class="col-md-12">
									<button data-res="" type="submit" class="btn btn-primary w-100 fw-bold">Update Faculty</button>
								</div>
							</div>
						</div>
					</div>
				</form>
				<%
					}
				%>
			</div>
		</div>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>