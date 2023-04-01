<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<html>
<head>
   	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Usuário</title>
</head>
<body>
	<i:import url="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<form action="/usuario/incluir" method="post">
			<h3>Cadastro de Usuário</h3>

			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Rodrigo Gomes" class="form-control">
			</div>

			<div class="form-group">
				<label>Senha:</label>
				<input type="password" name="senha" value="123123123" class="form-control">
			</div>

			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="rodrigo@gmail.com" class="form-control">
			</div>

			<div class="form-group">
				<label>Idade:</label> 	
				<input type="text" name="idade" value="26" class="form-control">
			</div>

			<div class="form-group">
				<label>Salário:</label> 	
				<input type="text" name="salario" value="111111" class="form-control">
			</div>

			
			<div class="form-group">						
				<label>Tipo:</label>			
				<div class="form-check">
				  <label class="form-check-label">
				    <input type="radio" name="tipo" value="P" class="form-check-input" > Padrão
				  </label>
				</div>			
				<div class="form-check">Ö
				  <label class="form-check-label">
					<input type="radio" name="tipo" value="D" class="form-check-input"> Diretor
				  </label>
				</div>			
				<div class="form-check">
				  <label class="form-check-label">
				    <input type="radio" name="tipo" value="A" checked class="form-check-input"> Administrador
				  </label>
				</div>			
			</div>

			<div class="form-group">
				<label>Setor:</label>
				<select name="setor" class="form-control">
					<option value="1">Diretoria</option>
					<option value="2">Comercial</option>
					<option value="3" selected>Desenvolvimento</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>