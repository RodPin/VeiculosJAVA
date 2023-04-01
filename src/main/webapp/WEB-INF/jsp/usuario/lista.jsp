
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppLanche</title>
</head>
<body>

	<div class="container">
		<form action="/usuario" method="get">
			<h3>Listagem de Usuários</h3>

			<button type="submit">Novo</button>
		</form>

		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>Nome</th>
		      <th>Senha</th>
		      <th>E-mail</th>
		      <th>Características</th>
		      <th>Tipo</th>
		      <th>Setor</th>
		      <th>Idade</th>
		      <th>Salário</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>Rodrigo Gomes</td>
		      <td>123</td>
		      <td>rodrigo@gmail.com</td>
		      <td>Estudante</td>
		      <td>Estudante</td>
		      <td>Infnet</td>
		      <td>26td>
		      <td>999</td>
		    </tr>
		  </tbody>
		</table>		
	</div>

</body>
</html>