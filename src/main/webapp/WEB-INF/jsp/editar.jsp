<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar</title>
<style>
body {
  background-image: url("https://img.freepik.com/fotos-gratis/texturas-de-parede-cinza-para-plano-de-fundo_74190-2715.jpg?size=626&ext=jpg");
  background-size: 100%;
}
</style>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<blockquote style=""><b>Você poderá editar o nome e notas do aluno!</b></blockquote>

<div> 
<form method="post" action="editar">
<b>Identificação:</b><br/>
<input type="number" name="idAluno" value="${aluno.idAluno}" id="idAluno" readonly>
<b>Nome:</b><br/>
<input type="text" name="nome" value="${aluno.nome}" id="nome">
<br/><b>Nota 1:</b><br/>
<input type="number" name="nota1" value="${aluno.nota1}" id="nota1">
<br/><b>Nota 2:</b><br/>
<input type="number" name="nota2" value="${aluno.nota2}" id="nota2"><br/>
<br/><b>Media:</b><br/>
<input type="number" name="media" value="${aluno.media}" id="media" readonly>
<br/><b>Situação:</b><br/>
<input type="text" name="situacao" value="${aluno.situacao}" id="situacao" readonly>
<button type="submit" class="btn btn-sm" style="background-color: black; margin-left: 1%">Salvar</button><br/>
</form>
</div>

<a href="/turma" style="margin-left: 2.5%;">Voltar</a>

</body>
</html>