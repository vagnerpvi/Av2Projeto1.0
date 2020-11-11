<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
<title>Insert title here</title>
</head>
<body>

	<div class="divCenter">
		<header style="text-align: center;">PORTAL DA UNIVERSIDADE</header>


		<form action="/action_page.php">

			<div class="form-group">
				<label for="email">Matricula:</label> <input type="email"
					class="form-control" placeholder="Enter Matricula" id="matricula">
			</div>
			<div class="form-group">
				<label for="pwd">Senha:</label> <input type="password"
					class="form-control" placeholder="Enter Senha" id="senha">
			</div>

			<a href="index.html"><button type="button"
					class="btn btn-primary">Enviar</button></a>
		</form>
	</div>





	<img src="./img/livro.jpg">
</body>
</html>