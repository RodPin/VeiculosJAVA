<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<html>
<head>
   	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Usu�rio</title>
</head>
<body>
	<i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<form action="/usuario/incluir" method="post">
			<h3>Cadastro de Usu�rio</h3>

			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Rodrigo Gomes" class="form-control">
			</div>

			<div class="form-group">
				<label>Senha:</label>
				<input type="password" name="senha" value="123123123" class="form-control">
			</div>

			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="rodrigo@gmail.com" class="form-control">
			</div>

			<div class="form-group">
				<label>Idade:</label> 	
				<input type="text" name="idade" value="26" class="form-control">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>