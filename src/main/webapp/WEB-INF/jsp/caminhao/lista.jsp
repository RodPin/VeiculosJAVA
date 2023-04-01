<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Caminhoes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<h3>Listagem de Caminhoes</h3>

		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/caminhao" method="get">
			<button type="submit" class="btn btn-primary">Novo</button>
		</form>

		<c:if test="${empty caminhaos}">
			<h5>Sem caminhoes cadastrados.</h5>
		</c:if>

		<c:if test="${not empty caminhaos}">
			<h5>Caminhoes cadastrados: ${caminhaos.size()}!!!</h5>

			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Código</th>
			      <th>Marca</th>
			      <th>Modelo</th>
			      <th>Combustivel</th>
			      <th>Valor</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="c" items="${caminhaos}">
				    <tr>
				      <td>${c.id}</td>
				      <td>${c.codigo}</td>
				      <td>${c.marca}</td>
				        <td>${c.modelo}</td>
				      <td>${c.combustivel}</td>
				      <td>${c.valor}</td>
				      <td><a href="/caminhao/${c.id}/excluir">Excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>