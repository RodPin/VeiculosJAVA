<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">	
	<meta charset="ISO-8859-1">
	<title>Cadastro de Usu�rio</title>
</head>
<body>
	<div class="container">
		<form action="/usuario/incluir" method="post">
			<h3>Cadastro de Usu�rio</h3>

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
				<label>Sal�rio:</label> 	
				<input type="text" name="salario" value="111111" class="form-control">
			</div>

			<div class="form-group">
				<label>Caracter�sticas:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="caracteristicas" value="De" checked class="form-check-input" > Developer
			      </label>
			    </div>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="caracteristicas" value="An"  class="form-check-input"> Analista
			      </label>
			    </div>
			    <div class="form-check">
			      <label class="form-check-label">
		        		<input type="checkbox" name="caracteristicas" value="Da" class="form-check-input"> Database
			      </label>
			    </div>
			</div>

			<div class="form-group">						
				<label>Tipo:</label>			
				<div class="form-check">
				  <label class="form-check-label">
				    <input type="radio" name="tipo" value="P" class="form-check-input" > Padr�o
				  </label>
				</div>			
				<div class="form-check">
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