<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/login.css">
    <title>Login</title>
</head>
<body>
    <nav>
        <span>
            <ul>
                <li><a href="#"><i><img src="<%= request.getContextPath()%>/resources/imagens/login/nav/hamburguer.svg" alt="Menu hamburguer"></i></a></li>
                <li><a href="index.jsp"><i><img src="<%= request.getContextPath()%>/resources/imagens/login/nav/home.svg" alt="Home"></i></a></li>
            </ul>
        </span>
    </nav>
    <main>
        <div id="img-side">
            <img src="<%= request.getContextPath()%>/resources/imagens/login/main/fundo.svg" alt="Imagem de Fundo">
        </div>
        <div id="form-side">
            <div id="form-conteiner">
                <div id="form-header">
                    <h1>LOGIN</h1>
                </div>
                <div id="form-dec"> 
                    <form action="logar-usuario">
                        <div id="input-form">
                            <div id="input-email" class="input-dec">
                                <i><img src="<%= request.getContextPath()%>/resources/imagens/login/main/form/email.svg" alt="Email"></i>
                                <input type="email" name="email-user" id="email-user" placeholder="E-MAIL:" required>
                            </div>
                            <div class="input-dec"> 
                                <i><img src="<%= request.getContextPath()%>/resources/imagens/login/main/form/senha.svg" alt="Senha"></i>
                                <input type="password" name="senha-user" id="senha-user" placeholder="SENHA" required>
                                <i><button type="button" id="olho" onclick="verSenha()"><img id="olhos" src="<%= request.getContextPath()%>/resources/imagens/login/main/form/olho-fechado.svg" alt="Olho"></button></i>
                            </div>
                        </div>
                        <div id="forgot-pass">
                            <a href="">ESQUECEU SUA SENHA?</a>
                        </div>
                        <div id="button-submit">
                            <button type="submit" id="submit">ENTRAR</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>

<script src="<%= request.getContextPath()%>/resources/js/login.js"></script>
</body>
</html>