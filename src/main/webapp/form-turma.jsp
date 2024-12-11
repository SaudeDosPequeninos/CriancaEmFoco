<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro Turma Lindo D+</title>
	</head>
	<body>
		<div>
			<form action="inserir" method="post">
				<label>Ano da Turma:</label>
				<input type="text" id="ano-turma" name="ano-turma" required>
				<label>Série:</label>
				<input type="text" id="numero-turma" name="numero-turma" required>
				<button type="submit">Concluir</button>
				<button type="reset">Limpar Formulário</button>
			</form>
		</div>
	</body>
</html>