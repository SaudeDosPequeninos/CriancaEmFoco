<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Turmas</title>
</head>
<body>
    <div>
        <h1>Turmas</h1>
        <a href="<%=request.getContextPath()%>/inserir">Nova Turma</a>
    </div>
    <c:if turmas="${not empty turmas}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Ano</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="turma" items="${turmas}">
                    <tr>
                        <td>${turma.id}</td>
                        <td>${turma.numero}</td>
                        <td>${turma.ano}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/editar?id=${turma.id}">Editar</a> |
                            <a href="<%=request.getContextPath()%>/deletar?id=${turma.id}">Deletar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if turmas="${empty turmas}">
        <p>Não há turmas cadastradas.</p>
    </c:if>
</body>
</html>
