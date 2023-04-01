<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Compras</title>
</head>
<body>
	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/header.jsp"/>

	<div class="container">
	
		<form action="/compra/incluir" method="post">
			<h3>Cadastro de Compras</h3>

			<div class="form-group">
				<label>Descrição:</label> 	
				<input type="text" name="descricao" value="Descricao da Compra 1" class="form-control">
			</div>
			
			<div class="form-group">
				<c:if test="${not empty clientes}">
					<label>Cliente:</label>
					<select name="cliente" class="form-control">
						<c:forEach var="c" items="${clientes}">
							<option value="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty clientes}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem clientes cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty veiculos}">
					<label>Veiculos:</label>
				    <c:forEach var="v" items="${veiculos}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="veiculos" value="${v.id}" class="form-check-input"> ${v.modelo}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty veiculos}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem veiculos cadastrados!</label>
				</c:if>
			</div>
			
			<button ${botao} type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>