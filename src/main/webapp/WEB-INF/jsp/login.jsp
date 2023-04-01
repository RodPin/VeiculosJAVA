
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Sistema de veiculos</title>
</head>
<body>

    <i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<h2>Login</h2>
		<i:if test="${not empty mensagem}">		
			<div class="alert alert-danger">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</i:if>

		<form action="/login" method="post">

		  <div class="form-group">
		    <label>E-mail:</label>
		    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="admin@gmail.com">
		  </div>

		  <div class="form-group">
		    <label>Senha:</label>
		    <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="123">
		  </div>

		  <button type="submit" class="btn btn-primary">Logar</button>
		</form>
	</div>

</body>
</html>