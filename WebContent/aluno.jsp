<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/cadastrarAluno.css">
<title>Cadastro de alunos</title>
</head>
<body>


	<header>
	
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href=" <%=request.getContextPath()%>/listaAlunos">LISTAR ALUNOS</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href=" <%=request.getContextPath()%>/home">HOME</a>
    </li>
  
  </ul>
</nav>
	
	</header>
	<div class="container-fluid">
	
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

</body>
</html>
