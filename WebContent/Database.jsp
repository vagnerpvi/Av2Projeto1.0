<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database</title>
</head>
<body>
<div class="row">

		<div class="container">

			<div class="container col-md-5">
				<div card="card">
					<div card="card-body">

						<div class="container text-left">
							<a href=" <%=request.getContextPath()%>/CriarDatabase"
								class="nav-link"><button class="btn btn-success">CRIAR
									DATABASE</button></a>
						</div>

						<div class="container text-left">
							<a href=" <%=request.getContextPath()%>/CriarUsuario"
								class="nav-link"><button class="btn btn-success">CRIAR
									USUARIOS</button></a>
						</div>
						<div class="container text-left">
							<a href=" <%=request.getContextPath()%>/LoginUsuario"
								class="nav-link"><button class="btn btn-success">LOGIN
								</button></a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


			
</body>
</html>