<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Add Books</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f7f7f7">
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
<c:redirect url="login.jsp"/> 
</c:if>

	<div class="container">
		<div class="row pt-2">
			<div class="col-md-3 offset-md-4">
				<div class="card ">
					<div class="card-body ">

						<h4 class="text-center">Add Books</h4>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<c:if test="${not empty failedMsg }">
							<p class="text-center text-danger">${failedMsg }</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<form action="../add_books" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label>Book Name *</label> <input type="text" name="bookName"
									class="form-control" aria-describedby="emailHelp" required>
							</div>

							<div class="form-group">
								<label>Author Name *</label> <input type="text"
									name="authorName" class="form-control"
									aria-describedby="emailHelp" required>
							</div>

							<div class="form-group">
								<label>Book Price *</label> <input type="number"
									name="bookPrice" class="form-control"
									aria-describedby="emailHelp" required>
							</div>
							<div class="form-group">
								<label>Book Category *</label> <select id="category"
									class="form-control" name="bCategory" required>
									<option selected disabled>--- Select ---</option>
									<option value="New">New Book</option>
								</select>

							</div>
							<div class="form-group">
								<label>Book Status *</label> <select id="status"
									class="form-control" name="bStatus" required>
									<option selected disabled>--- Select ---</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>
							<div class="form-group">
								<label>Upload Image</label> <input type="file" name="bImage"
									class="form-control" required>
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Add Book</button>
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