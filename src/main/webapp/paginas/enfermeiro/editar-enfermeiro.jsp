<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cadastro: Enfermeiro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/editar-enfermeiro.css">
     <script src="${pageContext.request.contextPath}/resources/js/editar-enfermeiro.js"></script>
</head>
<body>
    <header>
        <nav>
            <div class="nav-counteiner">
              <a href="editar-enfermeiro.jsp" class="hamburguer-sidebar"></a>
              <a href="editar-enfermeiro.jsp" class="home-button"></a>
              <div class= "hamburgue-icon" >
              <img src="${pageContext.request.contextPath}/resources/imagens/hamburgue.svg" alt="hamburgue-icon" >
              </div>
              <div class= "casa-icon" >
              <img src="${pageContext.request.contextPath}/resources/imagens/casa.svg" alt="casa-icon" >
              </div>
              <div class= "configuracao-icon" >
              <img src="${pageContext.request.contextPath}/resources/imagens/configuracao.svg" alt="configuracao-icon" >
              </div>
              <div class= "sininho-icon" >
              <img src="${pageContext.request.contextPath}/resources/imagens/sininho.svg" alt="sininho-icon" >
              </div>
              <div class= "perfil-icon">
		      <img src="${pageContext.request.contextPath}/resources/imagens/Perfil.svg" alt="perfil-icon">
			  </div>
            </div>
        </nav>
    </header>
 
	<div class="container-foto-perfil">
	<div class= "foto-perfil-icon">
	<img src="${pageContext.request.contextPath}/resources/imagens/foto-perfil.svg" alt="foto-perfil-icon">
	</div>
	</div>
	
    <div class="container-informacoes-basica">
        <h2>Informações Básicas</h2>
    </div>
 
    <div class="EditarEnfermeiro-form">
        <form action="editar-enfermeiro" method="POST" onsubmit="return checkSenha()">
 
            <div class="cpf">
                <label for="cpf-user">CPF</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/cpf.svg" alt="cpf-icon">
                <input type="text" id="cpf-user" name="cpf-user" placeholder="xxx.xxx.xxx-xx" value="145.541.877.71" minlength="14" maxlength="14" required>
            </div>
 
            <div class="data-de-nascimento">
                <label for="data-de-nascimento">Data de Nascimento</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/calendario.svg" alt="calendario-icon">
                <input type="date" id="data-de-nascimento" name="data-de-nascimento" value="1990-08-19" required aria-placeholder="dd/mm/aaaa">
            </div>
 
            <div class="coren">
                <label for="coren-user">Coren</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/coren.svg" alt="coren-icon">
                <input type="text" id="coren-user" name="coren-user" placeholder="xxxxxxxx" value="SC131214" minlength="8" maxlength="8" required>
            </div>
 
            <div class="container-informacoes-contato">
                <h2>Informações de Contato</h2>
            </div>
 
            <div class="nome">
                <label for="nome-user">Nome</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/pessoa.svg" alt="pessoa-icon">
                <input type="text" id="nome-user" name="nome-user" placeholder="Informe seu nome" value="Clarice" required>
            </div>
 
            <div class="sobrenome">
                <label for="sobrenome-user">Sobrenome</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/pessoa.svg" alt="pessoa-icon">
                <input type="text" id="sobrenome-user" name="sobrenome-user" placeholder="Informe seu sobrenome" value="Medeiros" required>
            </div>
 
            <div class="telefone">
                <label for="telefone-user">Telefone</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/telefone.svg" alt="telefone-icon">
                <input type="text" id="telefone-user" name="telefone-user" placeholder="(ddd) 9xxxxxxxx" value="47 98840-4764" minlength="9" maxlength="9" required>
            </div>
 
            <div class="email">
                <label for="email-user">E-mail</label>
                <img src="${pageContext.request.contextPath}/resources/imagens/email.svg" alt="email-icon">
                <input type="email" id="email-user" name="email-user" placeholder="exemplo@exemplo.com" value="claricemedeiros@gmail.com" required>
            </div>
 
            <div class="container-alterar-senha">
                <h2>Alterar Senha</h2>
            </div>
 
            <div class="nova-senha">
                <label for="nova-senha-user">Nova Senha</label>
                <div class="novo-cadeado">
                <img src="${pageContext.request.contextPath}/resources/imagens/cadeado.svg" alt="cadeado-icon">
                </div>
                <div class="novo-olho-fechado-icon" id="olho-fechado-novo" onclick="toggleIco()">
                <img src="${pageContext.request.contextPath}/resources/imagens/olho-fechado.svg" alt="olho-fechado-icon">
                </div>
                <div class="novo-olho-aberto-icon" id="olho-aberto-novo" style="display: none;" onclick="toggleIco()">
                <img src="${pageContext.request.contextPath}/resources/imagens/olho-aberto.svg" alt="olho-aberto-icon">
                </div>
                <input type="password" id="nova-senha-user" name="nova-senha-user" placeholder="XXXXXXXX" minlength="8" maxlength="20" required>
            </div>
 
            <div class="confirmar-senha">
                <label for="confirmar-senha-user">Confirmar Senha</label>
                <div class="confirmar-cadeado">
                <img src="${pageContext.request.contextPath}/resources/imagens/cadeado.svg" alt="cadeado-icon">
                </div>
                <div class="confirmar-olho-fechado-icon" id="olho-fechado-confirmar" onclick="toggleIcoConfirmarSenha()">
                <img src="${pageContext.request.contextPath}/resources/imagens/olho-fechado.svg" alt="olho-fechado-icon">
                </div>
                <div class="confirmar-olho-aberto-icon" id="olho-aberto-confirmar" style="display: none;" onclick="toggleIcoConfirmarSenha()">
                <img src="${pageContext.request.contextPath}/resources/imagens/olho-aberto.svg" alt="olho-aberto-icon">
                </div>
                <input type="password" id="confirmar-senha-user" name="confirmar-senha-user" placeholder="XXXXXXXX" minlength="8" maxlength="20" required>
            </div>
 
            <div class="form-buttons">
                <button type="reset">Cancelar</button>
                <button type="submit" >Salvar</button>
            </div>
        </form>
    </div>
</body>
</html>