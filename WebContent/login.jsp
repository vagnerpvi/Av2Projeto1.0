<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/login.css">

<title>LOGIN</title>

</head>
<body>
	<header style="text-align: center;">PORTAL DA UNIVERSIDADE</header>

	<div class="login-form">
		<div class="form">


			<form class="login-form"
				action="<%=request.getContextPath()%>/validar" method="get">
				<input type="text" placeholder="matricula" required name="matricula" />
				<input type="password" placeholder="senha" required name="senha" />
				<button>Entrar</button>
				<p class="message">
					Não Registrado? <a href="<%=request.getContextPath()%>/novoLogin"">Crie
						uma Conta</a>
				</p>
			</form>
		</div>
	</div>

</body>
</html>