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
  <button type="button" class="btn btn-primary">NOTA</button>
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="nota-list.jsp">CADASTRAR NOTA</a>
    <a class="dropdown-item" href="nota-list.jsp">LISTAR NOTAS</a>
      <a class="dropdown-item" href="#">ESTATISTICA NOTAS</a>
  </div>
  
</div> 
 <div class="btn-group">
  <button type="button" class="btn btn-primary">ALUNO</button>
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="aluno.jsp">CADASTRAR ALUNO</a>
    <a class="dropdown-item" href="aluno-list.jsp">LISTAR ALUNOS</a>
  </div>
</div> 

 <div class="btn-group">
  <button type="button" class="btn btn-primary">PROFESSOR</button>
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">CADASTRAR PROFESSOR</a>
    <a class="dropdown-item" href="#">LISTAR PROFESSOR</a>
  </div>
</div> 


 <div class="btn-group">
  <a href="login.jsp" class="btn-group"><button type="button" class="btn btn-primary">SAIR</button>
  </a>
  
</div> 

		</nav>
		
		
	</header>

	<img src="./img/logo.jpg">


	<footer>
		<adress> www.Exemplo.unicarioca.com.br</adress>
	</footer>
</body>
</html>