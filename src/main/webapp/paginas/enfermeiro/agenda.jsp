<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/agenda.css">
</head>

<body>
    <nav>
        <div id="icons-nav-left" class="icons-nav">
            <ul>
                <li id="hamburguer"><button><img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/hamburguer.svg" alt="Menu Hamburguer"></button></li>
                <li><a href=""><img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/home.svg" alt="Home"></a></li>
            </ul>
        </div>
        <div id="search-nav">
            <div id="itens-search">
                <input type="search" name="pesquisa" id="pesquisa">
                <img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/lupa.svg" alt="Pesquisa">
            </div>
        </div>
        <div id="icons-nav-right" class="icons-nav">
            <ul>
                <li><button><img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/sino.svg" alt="Notificações"></button></li>
                <li><a href=""><img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/engrenagem.svg" alt="Configurações"></a></li>
                    <div id="img-user-nav">
                        <img src="<%=request.getContextPath()%>/resources/imagens/agenda/nav/user-img.svg" alt="Foto">
                    </div>
            </ul>
        </div>
    </nav>

    <main>
        <span id="path-page">
            <p><span class="vermelho">Perfil</span> > Agenda</p>
        </span>
        <div id="header">
            <div id="title">
                <h1>Agenda</h1>
            </div>
            <div id="filtros">
                <span id="filtros-data">
                    <button class="button-filtro" onclick="timeSelection(1)"><p><span id="mes">mês</span></p></button>
                    <button class="button-filtro" onclick="timeSelection(2)"><p><span id="semana-day">semana</span></p></button>
                    <button class="button-filtro" onclick="timeSelection(3)"><p><span id="hoje">hoje</span></p></button>
                </span>
                <div id="section-button">
                    <button id="button-table-filter">
                        <div id="table-filter">
                            <p>Filtros</p>
                            <img src="<%=request.getContextPath()%>/resources/imagens/agenda/filtros/filtro.svg" alt="Filtro">
                        </div>
                    </button>
                    <span id="button-add">
                        <button><img src="<%=request.getContextPath()%>/resources/imagens/agenda/filtros/blocos.svg" alt="Blocos"></button>
                        <img src="<%=request.getContextPath()%>/resources/imagens/agenda/filtros/sepadador.svg" alt="">
                        <button><img src="<%=request.getContextPath()%>/resources/imagens/agenda/filtros/linha.svg" alt="Linhas"></button>
                    </span>
                </div>
            </div>
        </div>
        
        <div id="semana">
            <div id="seg" class="card-semana" onclick="daySelection(1)">
                <p class="dia-semana"><span>SEG</span></p>
                <p class="data"><span></span>25/11</p>
            </div>
            <div id="ter" class="card-semana" onclick="daySelection(2)">
                <p class="dia-semana"><span>TER</span></p>
                <p class="data"><span></span>26/11</p>
            </div>
            <div id="qua" class="card-semana" onclick="daySelection(3)">
                <p class="dia-semana"><span>QUA</span></p>
                <p class="data"><span></span>27/11</p>
            </div>
            <div id="qui" class="card-semana" onclick="daySelection(4)">
                <p class="dia-semana"><span>QUI</span></p>
                <p class="data"><span></span>28/11</p>
            </div>
            <div id="sex" class="card-semana" onclick="daySelection(5)">
                <p class="dia-semana"><span>SEX</span></p>
                <p class="data"><span></span>29/11</p>
            </div>
        </div>

        <div id="cards-agendamento">
            <c:forEach var="agendamentos" items="${agendamento}">
            	<div class="line-agendamento">
                <div class="dt-hora">
                    <img src="<%=request.getContextPath()%>/resources/imagens/agenda/line/relogio.svg" alt="Relógio">
                    <p><c:out value="${agendamento.hora }"/></p>
                </div>
                <div class="user-info">
                    <div class="foto-user">
                        <img src="<c:out value="${agendamento.fotoAluno }"/>" alt="Usuario">
                    </div>
                    <p><c:out value="${agendamento.nomeAluno}"/></p>
                </div>
                <div class="status">
                    <img src="<%=request.getContextPath()%>/resources/imagens/agenda/line/status.svg" alt="Status">
                </div>
                <div class="mais">
                    <img src="<%=request.getContextPath()%>/resources/imagens/agenda/line/flecha.svg" alt="Flecha">
                </div>
            </div>
            </c:forEach>
        </div>
    </main>
    <script src="<%=request.getContextPath()%>/resorces/js/agenda.js"></script>
</body>
</html>