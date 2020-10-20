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
<title>Home</title>
<style>
body {
  background-image: url("https://img.freepik.com/fotos-gratis/texturas-de-parede-cinza-para-plano-de-fundo_74190-2715.jpg?size=626&ext=jpg");
  background-size: 100%;
}
</style>

</head>
<body>

<nav style="font-size: 40px; text-align: center; background-color: background;">
Colégio Estadual Professor Antônio
</nav>

<div class="container text-center" style="margin-top:3%">
<form method="post" action="/adicionarTurma">
	<b>Nome da Turma:</b>
	<input type="text" name="nomeTurma" value="" required="required">
	<button class="btn btn-small" type="submit" style="background-color: background;">Adicionar Turma</button>
	<br/>
</form>
</div>

<table class="striped">
	<thead>
		<tr>
			<th>Nome da Turma</th>
			<th>Detalhes</th>
			<th>Excluir</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaturma}" var="t">
			<tr>
				<td>${t.nomeTurma}</td>			
				<td><a href="${caminho}/turma/${t.idTurma}"><i class="fas fa-edit" style="color: green;"></i></a></td>			
				<td><a href="${caminho}/excluirturma/${t.idTurma}"><i class="fas fa-trash" style="color: firebrick;"></i></a></td>			
			</tr>
		</c:forEach>
	</tbody>	
</table>


</html>