<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de login</title>

<link href="resources/css/estiloformulariologin.css" rel="stylesheet">
<link href="resources/css/estilopesquisalogin.css" rel="stylesheet">

</head>
<body>

	<!-- AQUI COMEÇA O CÓDIGO PARA REALIZAR PESQUISA DE LOGINS NO SISTEMA -->

	<br />

	<div id='busca'>
		<form class="search" action="PesquisarLogins" method="POST">



			<input id="btnBusca1" name="pesquisa" type="text" value=""
				placeholder="Digite o que você procura" /> <input id="btnBusca"
				type="submit" value="Pesquisar" /> <input type="submit" id="button"
				value="Voltar" /> <input TYPE="button" id="button" VALUE="Home"
				onclick="window.location.href='menu.jsp'">


		</form>

	</div>
	<!-- AQUI TERMINA O CÓDIGO PARA REALIZAR PESQUISA DE LOGINS NO SISTEMA -->






	<!-- AQUI COMEÇA O CÓDIGO DO FORMULARIO PARA CADASTRO DE LOGINS -->
	
	
	<h1 style="color: teal; font-family: cursive;">Bem vindo a área de cadastro de login</h1>


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

                <td><input type="submit" id="button"value="Cadastrar" /></td>
				
				<td><input type="reset" id="button"value="Cancelar" /></td>
			</tr>

		</table>

	</form>



	<!-- AQUI TERMINA O CÓDIGO DO FORMULARIO PARA CADASTRO DE LOGINS -->



	<!-- AQUI COMEÇA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE LOGINS -->

	<br />
	<br />

    
    
	<table >

		<tr style="color: olive; font-family:Lucida Bright; font-size: 15px">
			
			<th>ID</th>
			
            <th>Login</th>
            
			<th>Senha</th>
			
			<th>Excluir</th>
			
		<!--  	<th>Editar</th>  -->
            

		</tr>

		<c:forEach items="${logins}" var="usuario">
		
		 

			<tr>

               
				<td><c:out value="${usuario.id }"></c:out></td>
				<td><c:out value="${usuario.login }"></c:out></td>
			<!--  	<td><c:out value="${usuario.senha}"></c:out></td> -->


				<!-- AQUI COMEÇA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->

				<td><a href="LoginServlet?acao=deletar&usuario=${usuario.id}">
				<img alt="" src="resources/images/excluir.png" width="20px" height="20px"></a></td>
				<td><a href="LoginServlet?acao=editar&usuario=${usuario.id}">
				<img alt="" src="resources/images/editar.png" width="20px" height="20px"></a></td>



				<!-- AQUI TERMINA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->



			</tr>


		</c:forEach>



	</table>



	<!-- AQUI TERMINA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE LOGINS -->





</body>
</html>