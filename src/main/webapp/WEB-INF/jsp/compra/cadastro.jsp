
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Compras</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<form action="/compra/incluir" method="post">
			<h3>Cadastro de Compras</h3>

			<div class="form-group">
				<label>Descri��o:</label> 	
				<input type="text" name="descricao" value="compra 1" class="form-control">
			</div>

			<div class="form-group">
				<label>Caracter�sticas:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="web" value="true" class="form-check-input" > Turbo
			      </label>
			    </div>
			</div>

<!-- 			<div class="form-group"> -->
<!-- 				<label>Data:</label> 	 -->
<!-- 				<input type="text" name="data" value="16/03/2023" class="form-control"> -->
<!-- 			</div> -->

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>