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
<link rel="stylesheet" href="./css/loginCadastro.css">

<title>CADASTRAR LOGIN</title>
</head>
<body>

<header style="text-align: center;">CADASTRAR LOGIN</header>
<div class="login-page">
  <div class="form" >
    <form class="login-form" action="<%=request.getContextPath()%>/cadastrarLogin" method="get">
      <input type="text" placeholder="matricula" required name="matricula"/>
      <input type="password" placeholder="senha" required name="senha"/>
    <button>Salvar</button>
    
      <p class="message">Já e Registrado? <a href="<%=request.getContextPath()%>/showLogin">Login</a></p>
    </form>
  </div>
</div>
	

</body>
</html>