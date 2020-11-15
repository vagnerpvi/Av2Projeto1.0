<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/login.css">

<title>LOGIN</title>
</head>
<body>

	<div class="divCenter">
		<header style="text-align: center;">PORTAL DA UNIVERSIDADE</header>

		<div class="container">

			<div class="container col-md-5">
				<div card="card">
					<div card="card-body">

						<c:if test='${login != null}'>
							<form action="atualizarLogin" method="get">
						</c:if>

						<c:if test='${login == null}'>
							<form action="inserirLogin" method="get">
						</c:if>

						<caption>

							<h2>
								<c:if test='${login != null}'>
									<h2 style="text-align: center">EDITAR LOGIN</h2>
								</c:if>


								<c:if test="${login == null}">
									<h2 style="text-align: center">ADICIONAR LOGIN</h2>
								</c:if>

							</h2>

						</caption>
						
						
							<c:if test="${login != null}">
								<input type="hidden" value="<c:out value='${login.id_login}'/>"
									name="id_login" />

							</c:if>


							<fieldset class="form-group">
								<label for="text">Matricula:</label> <input type="text"
									value="<c:out value='${login.matricula}'/>"
									class="form-control" placeholder="Enter Matricula"
									id="matricula" name="matricula">
							</fieldset>

							<fieldset class="form-group">
								<label for="pwd">Senha:</label> <input type="password"
									value="<c:out value='${login.senha}'/>" class="form-control"
									placeholder="Enter Senha" id="senha"  name="senha">
							</fieldset>


							<fieldset class="form-group">
								<label>ID Aluno:</label> <input type="text"
									value="<c:out value='${login.id_aluno}'/>" class="form-control"
									name="id_aluno" />
							</fieldset>

							<fieldset class="form-group">
								<label>ID Professor:</label> <input type="text"
									value="<c:out value='${login.id_professor}'/>"
									class="form-control" name="id_professor" />
							</fieldset>

							<button type="submit" class="btn btn-success">Salvar</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 			<img src="./img/livro.jpg"> -->
</body>
</html>