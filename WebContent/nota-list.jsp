<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="/css/cadastroNotas.css" rel="stylesheet" type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script src="WebContent/js/inativarCamposCadastroNotas.js"></script>


</head>
<body style="flex: 0" background="red">

	<div class="row">

		<div class="container">

			<div class="container col-md-5">
				<div card="card">
					<div card="card-body">

						<c:if test='${nota != null}'>

							<form action="atualizarNota" method="get">
						</c:if>

						<c:if test='${nota == null}'>
							<form action="inserirNota" method="get">
						</c:if>

						<caption>

							<h2>
								<c:if test='${nota != null}'>
									<h2 style="text-align: center">EDITAR NOTA</h2>
								</c:if>


								<c:if test='${nota == null}'>
									<h2 style="text-align: center">ADICIONAR NOTA</h2>
								</c:if>

							</h2>

						</caption>

						<c:if test='${nota != null}'>
							<input type="hidden" value="<c:out value='${nota.id_nota}'/>"
								name="id_nota" />

						</c:if>

						<div class="form-inline">


							<div class="form-group4">
								<label for="select">Matricula :</label> <input type="text"
									value="<c:out value='${nota.id_aluno}'/>" class="form-control"
									placeholder="Matricula" id="id-aluno" name="id_aluno">
							</div>
							<div class="form-group4">
								<label for="text">Turma :</label> <input type="text"
									value="<c:out value='${nota.id_turma}'/>" class="form-control"
									placeholder="Disciplina" id="id-turma" name="id_turma">
							</div>


							<!-- 	<div class="form-group4">
								<label for="text">Avaliação :</label> <select name="selecione"
									class="form-control" id="selecione"
									onchange="verifica(this.value)">
									<option value='0'>AV1</option>
									<option value='1'>AV2</option>
									<option value='2'>AV3</option>
								</select>


							</div> -->

						</div>

						<div class="borderBox">
							<section>
								<h5>AV1</h5>
							</section>
							<div>
								<fieldset class="form-group">
									<label>Trabalho Acadêmico(AV1):</label> <input type="text"
										value="<c:out value='${nota.av1}'/>" class="form-control"
										placeholder="AV1" id="av1" name="av1">
								</fieldset>

								<fieldset class="form-group">
									<label>APS-1:</label> <input type="text"
										value="<c:out value='${nota.aps_1}'/>" class="form-control"
										placeholder="APS-1" id="aps1" name="aps_1">
								</fieldset>


							</div>
						</div>

						<div class="forma-group2 borderBox">
							<section>
								<h5>AV2</h5>
							</section>

							<fieldset class="form-group">
								<label>Trabalho Acadêmico(AV2):</label> <input type="text"
									value="<c:out value='${nota.av2}'/>" class="form-control"
									placeholder="AV2" id="av2" name="av2">
							</fieldset>

							<fieldset class="form-group">
								<label>APS-2:</label> <input type="text"
									value="<c:out value='${nota.aps_2}'/>" class="form-control"
									placeholder="APS-1" id="aps2" name="aps_2">
							</fieldset>

						</div>

						<div class="form-group3 borderBox">
							<section>
								<h5>AV3</h5>
							</section>
							<fieldset class="form-group">
								<label>AV3:</label> <input type="text"
									value="<c:out value='${nota.av3}'/>" class="form-control"
									placeholder="AV3" id="av3" name="av3">
							</fieldset>

						</div>

						<button type="submit" class="btn btn-primary" class="btn">Salvar</button>

						</form>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<nav class="nav-bar navbar-expand-md navbar-dark"
		style="background-color: blue"></nav>
	<ul>
		<li><a href=" <%=request.getContextPath()%>/listaNotas"
			class="nav-link"><button class="btn btn-success">LISTAR
					NOTAS</button></a></li>
	</ul>






	<div class="container text-left">
		<a href=" <%=request.getContextPath()%>/home" class="nav-link"><button
				class="btn btn-success">HOME</button></a>
	</div>





	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id_notas</th>
				<th>av1</th>
				<th>av2</th>
				<th>av3</th>
				<th>aps_1</th>
				<th>aps_2</th>
				<th>media</th>
				<th>id_aluno</th>
				<th>id_Turma</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nota" items="${listaNotas}">>
				<tr>
					<td><c:out value="${nota.id_nota}" /></td>
					<td><c:out value="${nota.av1}" /></td>
					<td><c:out value="${nota.av2}" /></td>
					<td><c:out value="${nota.av3}" /></td>
					<td><c:out value="${nota.aps_1}" /></td>
					<td><c:out value="${nota.aps_2}" /></td>
					<td><c:out value="${nota.media}" /></td>
					<td><c:out value="${nota.id_aluno}" /></td>
					<td><c:out value="${nota.id_turma}" /></td>
					<td><a
						href="editarNota?id_nota=<c:out value='${nota.id_nota}'/>">Editar</a></td>
					<td><a
						href="deletarNota?id_nota=<c:out value='${nota.id_nota}'/>">Deletar</a></td>
				</tr>
			</c:forEach>


		</tbody>

	</table>
	
</body>
</html>