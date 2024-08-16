<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>home:user</h1>
	<c:if test="${not empty userobj}">
	<h1>Name:$(userobj.name)</h1>
	<h1>Email:$(userobj.email)</h1>
		<%-- <div class="container text-center">
			<div class="alert alert-success" role="alert">Name:${userobj.name}</div>
			<div class="alert alert-success" role="alert">Email:${userobj.email}</div>
		</div> --%>
		<c:remove var="userobj" />
	</c:if>
</body>
</html>