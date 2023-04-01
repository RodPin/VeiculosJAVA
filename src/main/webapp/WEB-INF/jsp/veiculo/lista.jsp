<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Veiculos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">

		<h3>Listagem de Veiculos</h3>

		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<c:if test="${empty veiculos}">
			<h5>Sem veiculos cadastrados!!!</h5>
		</c:if>

		<c:if test="${not empty veiculos}">
			<h5>Veiculos cadastrados: ${veiculos.size()}!!!</h5>

			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Código</th>
			      <th>Nome</th>
			      <th>Valor</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="v" items="${veiculos}">
				    <tr>
				      <td>${v.id}</td>
				      <td>${v.codigo}</td>
				      <td>${v.nome}</td>
				      <td>${v.valor}</td>
				      <td><a href="/veiculo/${p.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>