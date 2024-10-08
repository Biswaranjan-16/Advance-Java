<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student registration</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f9;
}

.container {
	width: 80%;
	margin: auto;
	overflow: hidden;
}

header {
	background: #50b3a2;
	color: #fff;
	padding-top: 30px;
	min-height: 70px;
	border-bottom: #e8491d 3px solid;
}

header a {
	color: #fff;
	text-decoration: none;
	text-transform: uppercase;
	font-size: 16px;
}

header ul {
	padding: 0;
	list-style: none;
}

header li {
	display: inline;
	padding: 0 20px 0 20px;
}

.main-form {
	background: #fff;
	padding: 20px;
	margin-top: 30px;
	width: 60%;
}

.form-section {
	margin-bottom: 20px;
	width: 60%;
}

.form-section h2 {
	color: #50b3a2;
	border-bottom: 2px solid #e8491d;
}

label {
	display: block;
	margin-bottom: 5px;
}

input, select, textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.form-actions {
	display: flex;
	justify-content: space-between;
}

.form-actions button {
	background: #50b3a2;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
}

.form-actions button:hover {
	background: #45a089;
}

footer {
	text-align: center;
	padding: 20px;
	background: #333;
	color: #fff;
}
</style>
</head>
<body>
	<form>
		<header>
			<div class="container">
				<h1>Student Registration</h1>
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
		</header>

		<div class="container">
			<form class="main-form">
				<div class="form-section">
					<h2>Personal Information</h2>
					<label for="name">Full Name:</label> <input type="text" id="name"
						name="name" required> <label for="dob">Date of
						Birth:</label> <input type="date" id="dob" name="dob" required> <label
						for="gender">Gender:</label> <select id="gender" name="gender"
						required>
						<option value="">Select</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select> <label for="address">Address:</label>
					<textarea id="address" name="address" rows="4" required></textarea>

					<label for="contact">Contact Number:</label> <input type="tel"
						id="contact" name="contact" required> <label for="email">Email
						Address:</label> <input type="email" id="email" name="email" required>
				</div>

				<div class="form-section">
					<h2>Academic Information</h2>
					<label for="previous-school">Previous School/College:</label> <input
						type="text" id="previous-school" name="previous-school" required>

					<label for="grades">Grades/Marks:</label> <input type="text"
						id="grades" name="grades" required> <label for="course">Course
						Interested In:</label> <input type="text" id="course" name="course"
						required> <label for="qualifications">Additional
						Qualifications:</label> <input type="text" id="qualifications"
						name="qualifications" required>

                            <tr>
				<td><input type="submit" name="submit" required></td>
				<td><input type="reset" name="reset" required></td>
			</tr>
					</header>
			</form>
</body>
</html>