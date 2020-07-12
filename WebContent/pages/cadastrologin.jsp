<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de login</title>
</head>
<body>

	<!-- AQUI COMEÇA O CÓDIGO PARA REALIZAR PESQUISA DE LOGINS NO SISTEMA -->

	<div>
		<form class="search" action="PesquisarLogins" method="POST">

			<input id="txbusca" name="pesquisa" type="text" value=""placeholder="Digite o que você procura"/> 
				
				
			<input id="btnBusca"type="submit" value="Pesquisar" />
			<input type="submit" value="Voltar" />
			
			<input TYPE="button" VALUE="Home"
             onclick="window.location.href='menu.jsp'"> 


		</form>

	</div>
	<!-- AQUI TERMINA O CÓDIGO PARA REALIZAR PESQUISA DE LOGINS NO SISTEMA -->




	<h1>Bem vindo a tela cadastro de login</h1>

	<!-- AQUI COMEÇA O CÓDIGO DO FORMULARIO PARA CADASTRO DE LOGINS -->
	<form action="LoginServlet" method="post">

		<table>

			<tr>

				<td><input type="text" id="id" name="id" hidden=""
					value="${usuario.id }" /></td>
			</tr>

			<tr>
				<td>Login</td>
				<td><input type="text" required id="login" name="login"
					value="${usuario.login }" /></td>
			</tr>

			<tr>
				<td>Senha</td>
				<td><input type="password" required id="senha" name="senha"
					value="${usuario.senha }" /></td>
			</tr>



			<tr>

				<td><input type="submit" value="Cadastrar" /></td>
				<td><input type="reset" value="Cancelar" /></td>
			</tr>

		</table>

	</form>

	<!-- AQUI TERMINA O CÓDIGO DO FORMULARIO PARA CADASTRO DE LOGINS -->

	<br />
	<br />

	<!-- AQUI COMEÇA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE LOGINS -->

	<table border="1">

		<tr>
			<th>ID</th>
			<th>Login</th>
			<th>Senha</th>
			<th>Excluir</th>
			<th>Editar</th>


		</tr>

		<c:forEach items="${logins}" var="usuario">

			<tr>

				<td><c:out value="${usuario.id }"></c:out></td>
				<td><c:out value="${usuario.login }"></c:out></td>
				<td><c:out value="${usuario.senha}"></c:out></td>


				<!-- AQUI COMEÇA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->

				<td><a href="LoginServlet?acao=deletar&usuario=${usuario.id}">Excluir</a></td>
				<td><a href="LoginServlet?acao=editar&usuario=${usuario.id}">Editar</a></td>



				<!-- AQUI TERMINA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->



			</tr>


		</c:forEach>



	</table>

	<!-- AQUI TERMINA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE LOGINS -->



</body>
</html>