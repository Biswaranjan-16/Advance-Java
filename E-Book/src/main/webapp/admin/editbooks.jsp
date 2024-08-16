<%@page import="com.biswa.util.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.biswa.dao.BookDAOimpl" %>
<%@page import="java.util.List"%>
<%@page import="com.biswa.entity.BookDtls"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Edit Books</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f7f7f7">
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row pt-2">
			<div class="col-md-3 offset-md-4">
				<div class="card ">
					<div class="card-body ">
					
						<h4 class="text-center">Edit Books</h4>
						
						
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						BookDAOimpl dao=new BookDAOimpl(DbConnection.getcon());
						BookDtls b=dao.getBookById(id);
						
						%>
						<form action="../editbooks" method="post">
						<input type="hidden" name="id" value="<%=b.getBookId()%>">
							<div class="form-group">
								<label>Book Name *</label> <input type="text" name="bookName"
									class="form-control" aria-describedby="emailHelp" required value="<%=b.getBookName()%>">
							</div>

							<div class="form-group">
								<label>Author Name *</label> <input type="text"
									name="authorName" class="form-control"
									aria-describedby="emailHelp" required value="<%=b.getAuthor() %>">
							</div>

							<div class="form-group">
								<label>Book Price *</label> <input type="number"
									name="bookPrice" class="form-control"
									aria-describedby="emailHelp" required value="<%=b.getPrice() %>">
							</div>
							
							<div class="form-group">
								<label>Book Status *</label> <select id="status"
									class="form-control" name="bStatus" required value="<% %>">
								<%
								if("Active".equals(b.getStatus())){%>
								<option value="Active">Active</option>
								<option value="Inactive">Inactive</option>
								<%
								}else{%>
								<option value="Active">Active</option>
								<option value="Inactive">Inactive</option>
								<%
								}
								%>
									
								</select>
							</div>
							
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update Book</button>
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>

	<div style="margin-top: 70px">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>