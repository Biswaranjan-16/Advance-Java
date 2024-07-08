
<%@page import="com.biswa.util.DbConnection"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<body>
	<form action="savefaculty.jsp">
		<table border="1">
			<tr>
				<td colspan="2" style="text-align: center;">Faculty insert</td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="fname" required></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="femail" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="fpass" required></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="fadd" required></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="submit"></td>
			</tr>

		</table>

	</form>
	<div>
		<h1>
			<a href="Viewfaculty.jsp">View faculty</a>
		</h1>
	</div>
<br><hr>
<div>
<form>
Batch name:<input type="text">
Batch name:<input type="datetime-local">
Batch teacher:<select>
<option>--select--</option>
<% 
Connection con = DbConnection.getcon();
String query="select fid,fname from faculty";
PreparedStatement ps=con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
while(rs.next()){
%>
<option value="<% out.print(rs.getInt(1));%>"><% out.print(rs.getString(2));%></option>
<%
}
%>
</select>
</form>
</div>
</body>
</html>
