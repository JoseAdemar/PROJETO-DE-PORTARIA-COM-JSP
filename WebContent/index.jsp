<%@page import="beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de login</title>

<!-- AQUI COMEÇA O CÓDIGO EXTERNO CSS PARA O FORMULARIO DE LOGIN -->


<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

<!-- AQUI TERMINA O CÓDIGO EXTERNO CSS PARA O FORMULARIO DE LOGIN -->

<!-- AQUI COMEÇA O CÓDIGO CSS LOCAL PARA O FORMULÁRIO DE LOGIN -->

<link rel="stylesheet" type="text/css"
	href="resources/css/estilologin.css" media="screen" />

<!-- AQUI TERMINA O CÓDIGO CSS LOCAL PARA O FORMULÁRIO DE LOGIN -->

</head>
<body>

    <br/><br/>

	<div class="main-block">
		<h1>Área de Login</h1>

		<form action="ValidarLogin" method="post">


			<div class="account-type">
				<hr>
			</div>


			<label id="icon" for="name"><i class="fas fa-user"></i></label> <input
				type="text" name="login" id="login" placeholder="usuario" required />
			<label id="icon" for="name"><i class="fas fa-unlock-alt"></i></label>
			<input type="password" name="senha" id="senha" placeholder="senha"
				required />
			<hr>
			
			<br/><br/><br/>

			<div class="btn-block">
				<p>Clique em logar para ter acesso ao sistema</p>
				<button type="submit">Entrar</button>
			</div>


		</form>
		
		
	</div>

</body>
</html>