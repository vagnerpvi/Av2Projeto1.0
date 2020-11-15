<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<nav class="nav-bar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<ul>
				<li><a href=" <%=request.getContextPath()%>/listaAlunos"
					class="nav-link"><button class="btn btn-success">LISTA
							ALUNOS</button></a></li>
			</ul>
	</header>
	<div class="row">

		<div class="container">

			<div class="container text-left">
				<a href=" <%=request.getContextPath()%>/novoAluno" class="nav-link"><button
						class="btn btn-success">ADICIONAR ALUNO</button></a>
			</div>


		</div>

	</div>
	<h2>${mensagem}</h2>
	<table class="table table-bordered">
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
</body>

</html>