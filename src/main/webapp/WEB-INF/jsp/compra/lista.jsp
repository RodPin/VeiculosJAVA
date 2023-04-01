<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Compras</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<h3>Listagem de Compras</h3>

		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/compra" method="get">
			<button type="submit" class="btn btn-primary">Novo</button>
		</form>

		<c:if test="${empty compras}">
			<h5>Sem compras cadastradas!!!</h5>
		</c:if>

		<c:if test="${not empty compras}">
			<h5>Compras cadastrados: ${compras.size()}!!!</h5>

			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Descrição</th>
			      <th>Data</th>
			      <th>Clientes</th>
			      <th>Produtos</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="co" items="${compras}">
				    <tr>
				      <td>${co.id}</td>
				      <td>${co.descricao}</td>
				      <td>${co.data}</td>
				      <td>${co.cliente.nome}</td>
				      <td>${co.veiculos.size()}</td>
				      <td><a href="/compra/${p.id}/excluir">Excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>