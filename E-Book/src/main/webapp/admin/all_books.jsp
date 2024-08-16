<%@page import="com.biswa.util.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="com.biswa.dao.BookDAOimpl"%>
<%@page import="java.util.List"%>
<%@page import="com.biswa.entity.BookDtls"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Books</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
<c:redirect url="login.jsp"/> 
</c:if>

	<h3 class="text-center">Hello Admin</h3>

	<c:if test="${not empty succMsg }">
		<h5 class="text-center text-success">${succMsg }</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>


	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${failedMsg }</h5>
		<c:remove var="failedMsg" scope="session" />
	</c:if>


	<table class="table table-striped  ">
		<thead class="bg-dark text-white text-center">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Book Category</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody class="text-center">

			<% 
		
		BookDAOimpl dao=new BookDAOimpl(DbConnection.getcon());
		List<BookDtls> list=dao.getAllBooks();
		for(BookDtls b:list){
		%>
			<tr>
				<td><%=b.getBookId() %></td>
				<td><img src="../book/<%=b.getPhoto() %>"
					style="width: 50px; height: 50px;"></td>
				<td><%=b.getBookName() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getBookCategory() %></td>
				<td><%=b.getStatus() %></td>
				<td><a href="editbooks.jsp?id=<%=b.getBookId() %>"
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a> <a href="../delete?id=<%=b.getBookId()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>Delete</a></td>
			</tr>
			<%
		}
		%>


		</tbody>
	</table>



	<div style="margin-top: 390px">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>