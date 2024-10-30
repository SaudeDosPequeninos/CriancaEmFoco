<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Listar Escola</title>
	</head>
<body>
	<div>
		<div>
			<h1>Escola</h1>
			<input type="search" id="listar-escola-email" onkeyup="filtrarTabelaEmail()" placeholder="Procure por e-mails...">
			<table id="tabela-escola">
				<thead>
					<tr>
						<th>Razão Social</th>
						<th>Nome Fantasia</th>
						<th>CNPJ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="escola" items="${escola}">
						<tr>
							<td><c:out value="${escola.nomeId}" /></td>
							<td><c:out value="${escola.sobrenome}" /></td>
							<td><c:out value="${escola.idFiscal}" /></td>
							<td>
								<a href="editar-escola?id=<c:out value='${escola.id}'/>">Editar</a>
								<a href="deletar-escola?id=<c:out value='${escola.id}'/>">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
