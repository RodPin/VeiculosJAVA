<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Carros</title>
</head>
<body>
	<i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">

		<form action="/moto/incluir" method="post">
			<h3>Cadastro de Carros</h3>

	
			<div class="form-group">
				<label>Características:</label>
			</div>
			
			<div class="form-group">
				<label>Codigo:</label> 	
				<input type="text" name="codigo" value="56" class="form-control">
			</div>

			<div class="form-group">
				<label>Marca:</label> 	
				<input type="text" name="marca" value="bmw" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Modelo:</label> 	
				<input type="text" name="Modelo" value="x10" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Portas:</label>
					<select name="cliente" class="form-control">
						
							<option value="2">2 Portas</option>
							<option value="4">4 Portas</option>
						
					</select>
			</div>
			<div class="form-group">
				<label>Valor:</label> 	
				<input type="text" name="valor" value="10000" class="form-control">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>