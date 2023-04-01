<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Motos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<h3>Listagem de Motos</h3>

		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/moto" method="get">
			<button type="submit" class="btn btn-primary">Nova</button>
		</form>

		<c:if test="${empty motos}">
			<h5>Sem motos cadastradas!!!</h5>
		</c:if>

		<c:if test="${not empty motos}">
			<h5>Motos cadastradas: ${motos.size()}!!!</h5>

			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Código</th>
			      <th>Marca</th>
			      <th>Modelo</th>
			      <th>Turbo</th>
			      <th>Valor</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="m" items="${motos}">
				    <tr>
				      <td>${m.id}</td>
				      <td>${m.codigo}</td>
				      
				      <td>${m.marca}</td>
				        <td>${m.modelo}</td>
				      <td>${m.turbo}</td>
				      <td>${m.valor}</td>
				      <td><a href="/moto/${m.id}/excluir">Excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>