<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Studenti</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Data di nascita</th>
			<th>Matricola</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${elenco}" var="st"> 
		<tr>
			<td>${st.nome}</td>
			<td>${st.cognome}</td>
			<td>${st.dataNascita}</td>
			<td>${st.matricola}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>