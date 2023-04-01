
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html>
<html>
<head>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Sistema de Veiculos</title>
</head>
<body>
	<i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<h3>Listagem de Usuários</h3>

		<i:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</i:if>

		<i:if test="${empty usuarios}">
			<h5>Não existem usuários cadastrados!!!</h5>
		</i:if>

		<i:if test="${not empty usuarios}">
			<h5>Quantidade de usuários cadastrados: ${usuarios.size()}!!!</h5>

			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Senha</th>
			      <th>E-mail</th>
			      <th>Tipo</th>
			      <th>Setor</th>
			      <th>Idade</th>
			      <th>Salário</th>
			      <th>Clientes</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<i:forEach var="u" items="${usuarios}">
				    <tr>
				      <td>${u.id}</td>
				      <td>${u.nome}</td>
				      <td>${u.senha}</td>
				      <td>${u.email}</td>
				      <td>${u.tipo}</td>
				      <td>${u.setor}</td>
				      <td>${u.idade}</td>
				      <td>${u.salario}</td>
				      <td>${u.clientes.size()}</td>
				      <td>${u.veiculos.size()}</td>
				      <td><a href="/usuario/${u.id}/excluir"  class="danger">excluir</a></td>
				    </tr>
			    </i:forEach>
			  </tbody>
			</table>
		</i:if>
	</div>

</body>
</html>