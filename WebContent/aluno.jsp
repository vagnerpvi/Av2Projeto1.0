<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Cadastro de alunos</title>
</head>
<body>


	<header>
		<nav class="nav-bar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<ul>
				<li><a href=" <%=request.getContextPath()%>/listaAlunos"
					class="nav-link"><button class="btn btn success">LISTA
							alunos</button></a></li>
			</ul>
				<ul>
				<li><a href=" <%=request.getContextPath()%>/home"
					class="nav-link"><button class="btn btn success">LISTA
							alunos</button></a></li>
			</ul>
	</header>
	<div class="row">

		<div class="container">

			<div class="container col-md-5">
				<div card="card">
					<div card="card-body">

						<c:if test='${aluno != null}'>
							<form action="atualizarAluno" method="get">
						</c:if>

						<c:if test='${aluno == null}'>
							<form action="inserirAluno" method="get">
						</c:if>

						<caption>

							<h2>
								<c:if test='${aluno != null}'>
									<h2 style="text-align: center">EDITAR ALUNO</h2>
								</c:if>


								<c:if test="${aluno == null}">
									<h2 style="text-align: center">ADICIONAR ALUNO</h2>
								</c:if>

							</h2>

						</caption>

						<c:if test="${aluno != null}">
							<input type="hidden" value="<c:out value='${aluno.id_aluno}'/>"
								name="id_aluno" />

						</c:if>


						<fieldset class="form-group">
							<label>Nome:</label> <input type="text"
								value="<c:out value='${aluno.nome}'/>" class="form-control"
								name="nome" />
						</fieldset>

						<fieldset class="form-group">
							<label>Curso:</label> <input type="text"
								value="<c:out value='${aluno.curso}'/>" class="form-control"
								name="curso" />
						</fieldset>

						<fieldset class="form-group">
							<label>ID Professor:</label> <input type="text"
								value="<c:out value='${aluno.id_professor}'/>"
								class="form-control" name="id_professor" />
						</fieldset>

						<button type="submit" class="btn btn-success">Salvar</button>

						</form>
						
					</div>
				</div>
			</div>
</body>
</html>
