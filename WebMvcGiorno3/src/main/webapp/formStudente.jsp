<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Studente</title>
</head>
<body>
	<form method="POST">
		<label for="nome">Nome</label> 
		<input type="text" name="nome"
			value="${studente.nome}" /> <br /> 
			<label for="cognome">Cognome</label>
		<input type="text" name="cognome" value="${studente.cognome}" /> <br />
		<label for="dataNascita">Data di nascita</label> 
		<input type="date"
			name="dataNascita" value="${studente.dataNascita}" /> <br /> 
			<label
			for="altezzaInCm">Altezza In cm</label> 
			<input type="number"
			name="altezzaInCm" value="${studente.altezzaInCm}" /> <br /> 
			<label
			for="pesoInKg">Peso in kg</label> 
			<input type="number"
			name="pesoInKg" value="${studente.pesoInKg}" /> <br /> 
			<label
			for="matricola">Matricola</label> 
			<input type="number"
			name="matricola" value="${studente.matricola}" /> <br /> 
			<input
			type="submit" name="submit" value="Salva" />
	</form>
</body>
</html>