<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Clientes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<form action="/cliente/incluir" method="post">
			<h3>Cadastro de Clientes</h3>

			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Rodrigo Gomes" class="form-control">
			</div>

			<div class="form-group">
				<label>CPF:</label> 	
				<input type="text" name="cpf" value="21999511231" class="form-control">
			</div>

			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="rodrigo@gmail.com" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>