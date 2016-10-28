<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Elenco Studenti</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Gestione Studenti</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="elencoStudenti.htm">Elenco</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div style="margin-top: 100px;">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Comandi</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Data di nascita</th>
						<th>Matricola</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${elenco}" var="st">
						<tr>
							<td><a href="/modificaStudente.htm?id=${st.id}">M</a>
							<a href="/eliminaStudente.htm?id=${st.id}">E</a></td>
							<td>${st.nome}</td>
							<td>${st.cognome}</td>
							<td>${st.dataNascita}</td>
							<td>${st.matricola}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-primary" href="/nuovoStudente.htm" role="button">Nuovo studente</a>
		</div>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>