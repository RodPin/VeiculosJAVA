<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Motos</title>
</head>
<body>
	<i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">

		<form action="/moto/incluir" method="post">
			<h3>Cadastro de Motos</h3>

		

			<div class="form-group">
				<label>Características:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="turbo" value="true" class="form-check-input" > Turbo
			      </label>
			    </div>
			</div>
			
			<div class="form-group">
				<label>Marca:</label> 	
				<input type="text" name="codigo" value="52" class="form-control">
			</div>

			<div class="form-group">
				<label>Marca:</label> 	
				<input type="text" name="marca" value="suzuki" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Modelo:</label> 	
				<input type="text" name="Modelo" value="rampage" class="form-control">
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