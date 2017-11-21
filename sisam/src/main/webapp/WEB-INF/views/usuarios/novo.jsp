<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SISAM - Sistema de Avaliação de Módulo do Infnet</title>
</head>
<body>
	
	<h4>Cadastro de usuário</h4>
	<hr />
	
	<form action="/sisam/usuario/salvar" method="POST">
		<div>
			<label>Matrícula: </label>
			<input type="text" name="matricula" />
		</div>
		<div>
			<label>Senha: </label>
			<input type="password" name="senha" />
		</div>
		<div>
			<label>E-mail: </label>
			<input type="text" name="email" />
		</div>
		<div>
			<label>Perfil: </label>
			<input type="text" name="perfil.id" />
		</div>
		<button type="submit">Cadastrar</button>
	</form>

</body>
</html>