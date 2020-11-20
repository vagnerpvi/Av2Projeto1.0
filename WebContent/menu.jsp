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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/menu.css">
<title>Unicarioca</title>



</head>
<body>

<header>
 <nav class="navbar navbar-expand-sm bg-light navbar-light">

		<div class="btn-group">

			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">Notas</button>
				<div class="dropdown-menu">

					<a class="dropdown-item" href="nota-list.jsp"> <i
						 aria-hidden="true"></i> Cadastrar Nota
					</a> 
					
					<a class="dropdown-item" href="#">
					<i  aria-hidden="true"></i>Listar
						Notas </a> 
						
						<a class="dropdown-item" href="#"><i
						aria-hidden="true"></i>Estatistica Notas</a>
				</div>
			</div>

			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">Cadastrar</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="aluno-list.jsp"> <i
						class="fa fa-user fa-fw"></i>Aluno
					</a> <a class="dropdown-item" href="#"> <i class="fa fa-user fa-fw"></i>Professor
					</a> <a class="dropdown-item" href="#">Curso</a> <a
						class="dropdown-item" href="#">Disciplina</a> <a
						class="dropdown-item" href="nota-list.jsp">Notas</a>
				</div>
			</div>
			<button type="button" class="btn btn-primary">Sair</button>
		</div>


	</nav>
</header>
	
	<img src="./img/logo.jpg">


<footer>
  <adress> www.Exemplo.unicarioca.com.br</adress>
</footer>
</body>
</html>