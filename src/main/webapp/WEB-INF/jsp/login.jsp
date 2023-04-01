
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Sistema de veiculos</title>
</head>
<body>

	<div class="container">
		<h2>Login de usuario</h2>

		<form action="/login" method="post">

		  <div class="form-group">
		    <label>E-mail:</label>
		    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="rodrigo@gmail.com">
		  </div>

		  <div class="form-group">
		    <label>Senha:</label>
		    <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="123123123">
		  </div>

		  <button type="submit" class="btn btn-default">Logar</button>
		</form>
	</div>

</body>
</html>