<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/resources/css/cadastro-turma.css"%></style>
    <script><%@include file="/resources/js/cadastro-turma.js"%></script>
    <title>Cadastro:Turma</title>
    <style>
    </style>
</head>

<body>
    <header>
        <div class="top-bar">
        <a href="#" class="house-ico">
        <img src="<%=request.getContextPath()%>/resources/images/house-ico.svg" alt="house-ico">
        </a>
        <a href="#" class="tab-ico">
        <img src="<%=request.getContextPath()%>/resources/images/hamburguer-ico.svg" alt="hamburguer-ico">
        </a>
        </div>
    </header>

    <div class="CadastroEscola-form">
        <form action="criancaemfoco/cadastro/escola" method="POST">
            <div id="turma">
                <h2 class="text-style" id="title">Informações Básicas</h2>

                <div class="nome-turma">
                    <label for="nome-turma" class="text-style obrigatorio text-left">Nome Turma</label>
                    <div class="livro-ico">
                        <img src="<%=request.getContextPath()%>/resources/images/livro-ico.svg" alt="livro-ico">
                    </div>
                    <input type="text" value="<c:out value='${turma.turmaAluno}' />" id="nome-turma" name="nome-turma" placeholder="Informe o nome" required><br>
                </div>

                <div class="turno">
                    <label for="turno" class="text-style obrigatorio text-left">Turno</label>
                    <div class="relogio-ico">
                        <img src="<%=request.getContextPath()%>/resources/images/relogio-ico.svg" alt="relogio-ico">
                    </div>
                    <input type="text" value="<c:out value='${turma.turnoTurma}' />" id="turno-turma" name="turno-turma" placeholder="Ex: matutino" required><br>
                </div>

                <div class="ano-letivo">
                    <label for="ano-letivo" class="text-style obrigatorio text-left">Ano Letivo</label>
                    <div class="calendario-ico">
                        <img src="<%=request.getContextPath()%>/resources/images/calendario-ico.svg" alt="calendario-ico">
                    </div>
                    <input type="number" value="<c:out value='${turma.anoTurma}' />" id="ano-letivo" name="ano-letivo" placeholder="0000" min="1900" max="2100" required><br>
                </div>

                <input type="submit" id="concluir" class="text-style" value="CONCLUIR">
            </div>
        </form>
    </div>
</body>
</html>
