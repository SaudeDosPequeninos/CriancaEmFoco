<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil Enfermeiro</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/perfil-enfermeiro.css">
</head>
<body>
    <nav>
        <div class="nav-icons">
            <span>
                <ul>
                    <li><a href="#"><i><img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/hamburguer.svg" alt="Menu hamburguer"></i></a></li>
                    <li><a href="index.jsp"><i><img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/home.svg" alt="Home"></i></a></li>
                </ul>
            </span>
        </div>
        
        <div class="nav-settings">
            <div id="block-search">
                <div id="search-nav">
                    <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/lupa.svg" alt="Lupa">
                </div>
            </div>
            <button type="button">
                <div id="bell">
                    <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/sino.svg" alt="Sino">
                    <div id="notification-active"></div>
                </div>
            </button>
            <a href="">
                <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/engrenagem.svg" alt="Configuração">
            </a>
            <a href="">
                <div id="nav-picture" class="person-picture">
                	<img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/perfil.svg" alt="Foto Perfil">
                </div>
            </a>
        </div>
    </nav>

    <main>
        <div id="conteudo">
            <div id="header-info"> 
                <div id="info-user-container">
                    <div id="header-picture" class="person-picture">
						<img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/nav/perfil.svg" alt="Foto Perfil">
						<div id="edit-perfil">
                            <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/main/header/lapis.svg" alt="Lapis">
                        </div>
                    </div>
                    <div id="info-user">
                        <h2><c:out value="${usuario.nomeId }"/></h2>
                        <h3><c:out value="${usuario.email }"/></h3>
                        <h3><c:out value="COREN: ${usuario.registroCoren }"/></h3>
                    </div>
                </div>
                <div id="actions-user">
                    <div id="actions">
                        <div id="icons">
                            <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/main/header/email.svg" alt="Email">
                            <button>
                                <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/main/header/historico.svg" alt="Historico">
                            </button>
                        </div>
                        <div id="lembrete">
                            <h3>Lembrete</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div id="boards">
                <div id="options-user">
                    <div id="option1" class="option">
                        <h2>Procedimentos</h2>
                        <button>ver perfil</button>
                    </div>
                    <div class="option">
                        <h2>Agendas</h2>
                        <button>ver perfil</button>
                    </div>
                    <div class="option">
                        <h2>Turmas</h2>
                        <button>ver perfil</button>
                    </div>
                </div>
                <div id="escola">
                    <a href="">
                        <div id="escola-frame">
                            <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/main/options/book.svg" alt="Escola">
                        </div>
                        <p>Escola</p>
                    </a>
                </div>
            </div>
        </div>
        <div id="help">
            <a href="">
                <div id="help-frame">
                    <img src="<%= request.getContextPath() %>/resources/imagens/perfil-enfermeiro/main/options/interrogacao.svg" alt="?">
                </div>
            </a>
        </div>
    </main> 
</body>
</html>