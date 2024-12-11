<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Salvo!</title>
	</head>
	<body>
		<div>
			<h1>Turma salva no banco.</h1>
			<a href="<%=request.getContextPath()%>/inserir">Nova Turma</a>
			<a href="<%=request.getContextPath()%>/atualizar">Editar Turma</a>
			<a href="<%=request.getContextPath()%>/listar">Ver Turmas</a>
		</div>
	</body>
</html>