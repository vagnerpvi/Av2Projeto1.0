<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="utf-8">
<title>LISTA DE ALUNOS</title>
</head>
<body>

	<header>
	
		
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href=" <%=request.getContextPath()%>/listaAlunos">LISTAR ALUNOS</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href=" <%=request.getContextPath()%>/novoAluno" >NOVO ALUNO</a>
    </li>
  
  </ul>
</nav>
		


	<div class="container-fluid">
	<table class="table">
    <thead class="thead-dark">
		<thead>
			<tr>
				<th>Id_aluno</th>
				<th>Nome</th>
				<th>Curso</th>
				<th>Id_professor</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${listaAlunos}">
				<tr>
					<td><c:out value="${aluno.id_aluno}" /></td>
					<td><c:out value="${aluno.nome}" /></td>
					<td><c:out value="${aluno.curso}" /></td>
					<td><c:out value="${aluno.id_professor}" /></td>
					<td><a
						href="editarAluno?id_aluno=<c:out value='${aluno.id_aluno}'/>">Editar</a></td>
					<td><a
						href="deletarAluno?id_aluno=<c:out value='${aluno.id_aluno}'/>">Deletar</a></td>

				</tr>
		</tbody>
		</c:forEach>
	</table>
	</div>
</body>

</html>