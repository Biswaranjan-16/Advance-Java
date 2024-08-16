<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #05315d;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.registration-container {
	background: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
	max-width: 600px;
	width: 80%;
}

.registration-container h3 {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div class="registration-container">
		<h3 class="text-center">REGISTRATION</h3>
		<form action="user" method="post">
			<div class="form-group">
			<input type="hidden" id="hdn" >
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="uname" placeholder="Enter name" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="uemail"  placeholder="Enter email" required>
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="tel"
					class="form-control" id="phone" name="uphone" placeholder="Enter phone number" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="upassword"  placeholder="Password" required>
			</div>

			<button type="submit" class="btn btn-primary btn-block "
				onclick="add()">Submit</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="script.js"></script>
</body>
</html>