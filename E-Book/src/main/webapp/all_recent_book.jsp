<%@page import="java.util.List"%>
<%@page import="com.biswa.entity.BookDtls"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="com.biswa.dao.BookDAOimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Recent Book</title>
<%@include file="all_component/allcss.jsp"%>

<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-3">
			<%
				BookDAOimpl dao2=new BookDAOimpl(DbConnection.getcon());	
				List<BookDtls>	list2=dao2.getAllRecentBook();
				for(BookDtls b:list2){
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-2">
					<div class="card-body text-center">
						<img alt="java book" src="book/<%=b.getPhoto() %>"
							style="width: 100px; height: 150px" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthor() %></p>
						<p>
						
						<%
						if(b.getBookCategory().equals("old")){
						%>
							<div class="row ">
							Categories:<%=b.getBookCategory() %></p>
							<a href="" class=" btn btn-success btn-sm ml-1">View Details</a> 
							<a href="" class=" btn btn-danger btn-sm  ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
							</div>
							
						<%
						}else{
						%>
						Categories:<%=b.getBookCategory() %></p>
						<div class="row ">
							<a href="" class=" btn btn-danger btn-sm"><i class="fa-solid fa-cart-shopping"></i>Add Cart</a> <a
								href="" class=" btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class=" btn btn-danger btn-sm  ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
						</div>
						<% 	
							}
						%>
						
						
					</div>
				</div>
			</div>
		
			<% 
			}
			%>
		
		</div>
	</div>

</body>
</html>