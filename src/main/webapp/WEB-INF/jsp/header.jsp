
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Sistema De Veiculos</a>
    </div>

    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
	  <i:if test="${not empty usuario}">	
	      <li><a href="/usuario/lista">Usu�rio</a></li>
	      <li><a href="/cliente/lista">Cliente</a></li>
	      <li><a href="/veiculo/lista">Veiculo</a></li>
	      <li><a href="/carro/lista">Carro</a></li>
	      <li><a href="/moto/lista">Moto</a></li>
	      <li><a href="/caminhao/lista">Caminhao</a></li>
	      <li><a href="/compra/lista">Compra</a></li>
      </i:if>
    </ul>

    <ul class="nav navbar-nav navbar-right">
	    <i:if test="${empty usuario}">
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Registre-se</a></li>
		</i:if>
		<i:if test="${not empty usuario}">
	      <li><a> ${usuario.nome}</a></li>
	      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </i:if>
    </ul>
  </div>
</nav>