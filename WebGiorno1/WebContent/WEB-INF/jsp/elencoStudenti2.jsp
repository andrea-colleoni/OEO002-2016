<%@page import="java.util.List"%>
<%@page import="it.overnet.web.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<% for (Studente st : (List<Studente>)request.getAttribute("elenco")) { %>
		<tr>
			<td><%= st.getNome() %></td>
			<td><%= st.getCognome() %></td>
			<td><%= st.getDataNascita() %></td>
			<td><%= st.getMatricola() %></td>
		</tr>
		<% } %>
	</tbody>
</table>
</body>
</html>