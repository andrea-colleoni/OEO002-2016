<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prima pagina JSP</title>
</head>
<body>
<h1>Hello World da JSP!!</h1>
<% for(int i = 0; i < 20; i++) { %>
	<h2>
	<% out.write(new java.util.Date().toString()); %>
	</h2>
<% } %>
</body>
</html>