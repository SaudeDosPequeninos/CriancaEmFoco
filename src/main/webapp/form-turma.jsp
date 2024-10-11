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
				<label>Nome da Turma:</label>
				<input type="text" id="nomeTurma" name="nomeTurma" required>
				<label>Turno:</label>
				<input type="text" id="turnoTurma" name="turnoTurma" required>
				<label>Ano Letivo:</label>
				<input type="text" id="anoLetivo" name="anoLetivo" required>
				<button type="submit">Concluir</button>
				<button type="reset">Limpar Formulário</button>
			</form>
		</div>
	</body>
</html>