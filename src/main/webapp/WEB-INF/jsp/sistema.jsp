<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="estilo.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Cadastro de Alunos</title>

<style>
body {
  background-image: url("https://img.freepik.com/fotos-gratis/texturas-de-parede-cinza-para-plano-de-fundo_74190-2715.jpg?size=626&ext=jpg");
  background-size: 100%;
}
</style>
</head>
<body>

<nav>
<div class="nav-wrapper" style="text-align: center; font-size: 48px; font-variant: small-caps; background-color: background">Cadastro de Alunos
<ul id="" class="right hide-on-med-and-down">
<li><a href="/">Inicio</a></li> 
</ul>
</div>
</nav>

<div style="margin-left:35%;margin-top: 2%"> 
<div class="row">
<form method="post" action="/cadastrar" class="col s6">
<b>Nome:</b><br/>
<input type="text" name="nome" value="" id="nome">
<br/><b>Nota 1:</b><br/>
<input type="number" name="nota1" value="" id="nota1">
<br/><b>Nota 2:</b><br/>
<input type="number" name="nota2" value="" id="nota2"><br/>
<button type="submit" class="btn btn-sm" style="background-color: black; margin-left: 30%">Cadastrar Aluno</button><br/>
</form>
</div>
</div>

<table class="striped">
<thead>
	<tr>
		<th>Identificação</th>
		<th>Nome</th>
		<th>Nota 1</th>
		<th>Nota 2</th>
		<th>Média</th>
		<th>Situação</th>
		<th>Editar</th>
		<!--<th>Excluir</th>-->
	</tr>
	</thead> 
	<tbody>
		<c:forEach items="${lista}" var="a">
		<tr>
			<td>${a.idAluno}</td>
			<td>${a.nome}</td>
			<td>${a.nota1}</td>
			<td>${a.nota2}</td>
			<th>${a.media}</th>
			<th>${a.situacao}</th>
			<td><a href="${caminho}/editar/${a.idAluno}"><i class="fas fa-user-edit" style="color: green;"></i></a></td>
			<!--<td><a href="${caminho}/excluir/${a.idAluno}"><i class="fas fa-trash" style="color: firebrick;"></i></a></td> -->
		</tr>	
		</c:forEach> 
	</tbody>	
</table>
</body>
</html>