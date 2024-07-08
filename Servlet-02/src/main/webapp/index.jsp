<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Registration</h1>
	<form action="lion"  method="post"  enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name</td>
				<td>
				<input type="hidden" name="hid" value="HiddenFieldFormData">
				<input type="text" name="name" required>
				</td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="Email" name="email" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="Password" name="password" required></td>
			</tr>

			<tr>
				<td>Date</td>
				<td><input type="Date" name="date" required></td>
			</tr>

			<tr>
				<td>Color</td>
				<td><input type="Color" name="color" required></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male" required>Male
					&nbsp; <input type="radio" name="gender" value="female" required>Female
				</td>
			</tr>

			<tr>
				<td>Course</td>
				<td><input type="checkbox" name="Course1" value="math" required>Math 
					&nbsp; <input type="checkbox" name="Course2" value="bio" required>Bio
					&nbsp; <input type="checkbox" name="Course3" value="it" required>IT
					&nbsp;</td>
			</tr>

			<tr>
				<td>Month</td>
				<td><input type="Month" name="month" required></td>
			</tr>

			<tr>
				<td>Number</td>
				<td><input type="Number" name="number" required></td>
			</tr>

			<tr>
				<td>Range</td>
				<td>0<input type="Range" name="range" required>100</td>
			</tr>

			<tr>
				<td>Search</td>
				<td><input type="Search" name="search" required></td>
			</tr>

			<tr>
				<td>Url</td>
				<td><input type="Url" name="url" required></td>
			</tr>

			<tr>
				<td>Teliphone</td>
				<td><input type="Teliphone" name="tel" required></td>
			</tr>

			<tr>
				<td>datetime-local</td>
				<td><input type="datetime-local" name="datetime" required></td>
			</tr>

			<tr>
				<td>Image</td>
				<td><input type="file" name="img" required></td>
			</tr>

			<tr>
				<td>Chose class</td>
				<td><select name="Choseclass" id="">chose class
						<option value="select">---select---</option>
						<option value="course 1">course 1</option>
						<option value="course 2">course 2</option>
						<option value="course 3">course 3</option>
						<option value="course 4">course 4</option>
						<option value="course 5">course 5</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" required></td>
				<td><input type="reset" name="reset" required></td>
			</tr>
		</table>
	</form>
</body>
</html>