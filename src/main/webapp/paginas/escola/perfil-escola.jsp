<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Perfil Escola</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/perfil-escola.css">
</head>
<body>
    <nav>
        <div id="icons-logo">
            <ul>
                <li><a href="#"><img src="<%=request.getContextPath()%>/imagens/escola/perifl/nav/hamburguer.svg" alt="Menu"></a></li>
                <li><a href="index.html"><img src="<%=request.getContextPath()%>/imagens/escola/perifl/nav/home.svg" alt="Home"></a></li>
            </ul>
        </div>
        <div id="search-bar">
            <div id="bar">
                <input type="search" name="search-nav" id="search-nav">
                <img src="<%=request.getContextPath()%>/imagens/escola/perifl/nav/lupa.svg" alt="Lupa">
            </div>
        </div>
        <div id="notification-nav">
            <button><img class="img-perfil" src="<%=request.getContextPath()%>/imagens/escola/perifl/nav/sino.svg" alt="Sino"></button>
        </div>
        <div id="config-nav">
            <a href="#"><img src="<%=request.getContextPath()%>/imagens/escola/perifl/nav/engrenagem.svg" alt="Engrenagem"></a>
        </div>
        <div id="profile-user-nav">
            <div id="moldura-nav">
                <img src="<%=request.getContextPath()%>/imagens/escola/perifl/escola.svg" alt="Foto Perfil">
            </div>
        </div>
    </nav>
    <main>
        <div id="path-role">
            <p>Perfil</p>
        </div>
        <div id="header">
            <div id="moldura-header">
                <img src="<%=request.getContextPath()%>/imagens/escola/perifl/escola.svg" alt="Foto Perfil">
                <div id="edicao">
                    <a href="#"><img src="<%=request.getContextPath()%>/imagens/escola/perifl/header/caneta.svg" alt="Caneta"></a>
                </div>
            </div>
            <div id="info-escola">
                <div id="nome-escola">
                    <p><c:out value="escola.nomeId"/> </p>
                </div>
                <div id="email-escola">
                    <p><c:out value="escola.email"/></p>
                </div>
            </div>
        </div>
        <div id="bottom">
            <div id="enfermeiros-card" class="card">
                <div id="icon-enfermeiro" class="card-icon">
                    <img src="<%=request.getContextPath()%>/imagens/escola/perifl/bottom/enfermeiro.svg" alt="Enfermeiro">
                </div>
                <div class="nome-card">
                    <p>ENFERMEIROS</p>
                </div>
                <div class="ver-mais">
                    <button>VER MAIS</button>
                </div>
            </div>
            <div id="turmas-card" class="card">
                <div id="icon-turma" class="card-icon">
                    <img src="<%=request.getContextPath()%>/imagens/escola/perifl/bottom/turma.svg" alt="Turma">
                </div>
                <div class="nome-card">
                    <p>TURMAS</p>
                </div>
                <div class="ver-mais">
                    <button>VER MAIS</button>
                </div>
            </div>
            <div id="alunos-card" class="card">
                <div id="icon-alunos" class="card-icon">
                    <img src="<%=request.getContextPath()%>/imagens/escola/perifl/bottom/alunos.svg" alt="Alunos">
                </div>
                <div class="nome-card">
                    <p>ALUNOS</p>
                </div>
                <div class="ver-mais">
                    <button>VER MAIS</button>
                </div>
            </div>
        </div>
    </main>
</body>
</html>