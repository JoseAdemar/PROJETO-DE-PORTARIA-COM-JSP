<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>

	<h1>Ben vindo a tela de login</h1>

	<form action="ValidarLogin" method="post">

		<table>

			<tr>
				<td>Login</td>
				<td><input type="text" required id="login" name="login" /></td>
			</tr>

			<tr>
				<td>Senha</td>
				<td><input type="password" required id="senha" name="senha" /></td>
			</tr>

			<tr>
				
				<td><input type="submit" value="Entrar" /></td>
			</tr>

		</table>


	</form>

</body>
</html>