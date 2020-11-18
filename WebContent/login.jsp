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

						<form action="<%=request.getContextPath()%>/validar" method="get">


							<fieldset class="form-group">
								<label for="text">Matricula:</label> <input type="text"
									class="form-control" placeholder="Enter Matricula"
									id="matricula" name="matricula">
							</fieldset>

							<fieldset class="form-group">
								<label for="pwd">Senha:</label> <input type="password"
									class="form-control" placeholder="Enter Senha" id="senha"
									name="senha">
							</fieldset>

							<button type="submit" class="btn btn-success">Entrar</button>
							<button type="submit" class="btn btn-success">Cadastrar</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 			<img src="./img/livro.jpg"> -->
</body>
</html>