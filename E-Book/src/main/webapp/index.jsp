<%@page import="com.biswa.entity.User"%>
<%@page import="com.biswa.util.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.biswa.dao.BookDAOimpl"%>
<%@page import="java.util.List"%>
<%@page import="com.biswa.entity.BookDtls"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Book: index</title>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/book.jpeg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #f7f7f7;
}
</style>
</head>
<body style="background-color: #f7f7f7;">

<%
User u=(User)session.getAttribute("userobj"); 
%>

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img ">
		<h2 class="text-center text-warning">EBook Management System</h2>
	</div>
	
	<!-- start recent book -->

	<div class="container ">
		<h3 class="text-center">Recent Book</h3>
		<div class="row">
			<%
				BookDAOimpl dao2=new BookDAOimpl(DbConnection.getcon());	
				List<BookDtls>	list2=dao2.getRecentBook();
				for(BookDtls b:list2){
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="java book" src="book/<%=b.getPhoto() %>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthor() %></p>
						<p>
						
						<%
						if(b.getBookCategory().equals("old")){
						%>
							<div class="row ">
							Categories:<%=b.getBookCategory() %></p>
							<a href="viewbooks.jsp?bid=<%=b.getBookId() %>" class=" btn btn-success btn-sm ml-1">View Details</a> 
							<a href="" class=" btn btn-danger btn-sm  ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
							</div>
							
						<%
						}else{
						%>
						Categories:<%=b.getBookCategory() %></p>
						<div class="row ">
							<a href="" class=" btn btn-danger btn-sm"><i class="fa-solid fa-cart-shopping"></i>Add Cart</a> <a
								href="viewbooks.jsp?bid=<%=b.getBookId() %>" class=" btn btn-success btn-sm ml-1">View Details</a> <a
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
		<div class="text-center mt-1">
		<a href="all_recent_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

<!-- end recent book -->

<hr>
<!-- start new book -->

	<div class="container ">
		<h3 class="text-center">New Book</h3>
		<div class="row">
			
			<%
				BookDAOimpl dao=new BookDAOimpl(DbConnection.getcon());	
			List<BookDtls>	list=dao.getNewBook();
			for(BookDtls b:list){
				%>
				<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto() %>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthor() %></p>
						<p>Categories:<%=b.getBookCategory() %></p>
						<div class="row ">
						
						<%
						if(u==null){
						%>
						<a href="login.jsp" class=" btn btn-danger btn-sm "><i class="fa-solid fa-cart-shopping"></i>Add Cart</a>
							
						<%	
						}else{
							%>
							<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getId()%>" class=" btn btn-danger btn-sm "><i class="fa-solid fa-cart-shopping"></i>Add Cart</a>
							
							
						<%
						}
						%>
							 <a
								href="viewbooks.jsp?bid=<%=b.getBookId() %>" class=" btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class=" btn btn-danger btn-sm  ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
						</div>
					</div>
				</div>
				</div>
			<%
			}
			%>
				
			
	
		</div>
		
		<div class="text-center mt-1">
		<a href="all_new_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

<!-- end new book -->

<hr>
<!-- start old book -->

	<div class="container ">
		<h3 class="text-center">Old Book</h3>
		<div class="row">
		
		
			<%
				BookDAOimpl dao3=new BookDAOimpl(DbConnection.getcon());	
				List<BookDtls>	list3=dao3.getOldBook();
				for(BookDtls b:list3){
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="java book" src="book/<%=b.getPhoto() %>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthor() %></p>
						<p>Categories:<%=b.getBookCategory() %></p>
						<div class="row ml-4">
							 <a
								href="viewbooks.jsp?bid=<%=b.getBookId() %>" class=" btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class=" btn btn-danger btn-sm  ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
						</div>
						
					</div>
				</div>
			</div>
		
			<% 
			}
			%>
	
		</div>
		
		<div class="text-center mt-1">
		<a href="all_old_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

<!-- end old book -->

<%@include file="all_component/footer.jsp" %>
</body>
</html>