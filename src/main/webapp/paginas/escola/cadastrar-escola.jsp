<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../resources/css/cadastrar-escola.css">
    <script src="../../resources/js/cadastrar-escola.js"></script>
    <title>Cadastro: Escola</title>
</head>

<body>

    <div class="header">
        <div class="top-bar"></div>
        <a href="../../index.jsp" class="house-ico">
            <img src="../../resources/images/house-ico.svg" alt="house-ico">
        </a>
        <a href="#" class="tab-ico">
            <img src="../../resources/images/tab-ico.svg" alt="tab-ico">
        </a>
    </div>

    <div id="cadastroescola-form">
        <form action="criancaemfoco/cadastro/escola" method="POST">
            <div id="passo1" style="display: block;">
                <div class="titulo">
                    <img src="../../resources/images/titulo.svg" alt="Titulo Cadastro">
                </div>                

                <div class="razaoSocial">
                    <label for="razao-social" class="obrigatorio">Razão Social</label>
                    <div class="user-ico">
                        <img src="../../resources/images/user-ico.svg" alt="user-ico">
                    </div>
                    <input type="text" id="razao-social-user" name="razao-social-user" placeholder="Informe o nome" required><br>
                </div>

                <div class="nomeFantasia">
                    <label for="nome-fantasia">Nome Fantasia</label>
                    <div class="user-ico-fantasia">
                        <img src="../../resources/images/user-ico.svg" alt="user-ico-fantasia">   
                    </div>
                    <input type="text" id="nome-fantasia-user" name="nome-fantasia-user" placeholder="Opcional"><br>
                </div>

                <div class="cnpj">
                    <label for="cnpj" class="obrigatorio">CNPJ</label>
                    <div class="cnpj-ico">
                        <img src="../../resources/images/cnpj-ico.svg" alt="cnpj-ico">                           
                    </div>
                    <input type="text" id="cnpj-user" name="cnpj-user" required pattern="\d{14}" title="Digite 14 dígitos" placeholder="Informe o CNPJ" maxlength="14" minlength="14"><br>
                </div>
                
                <div class="telefone">
                    <label for="tel" class="obrigatorio">Telefone</label>
                    <div class="tel-ico">
                        <img src="../../resources/images/telefone-ico.svg" alt="telefone-ico">                  
                    </div>
                    <input type="tel" id="tel-user" name="tel-user" required pattern="\d{10,11}" title="Digite 10 ou 11 dígitos" placeholder="(DDD) 9xxxxxxxx" maxlength="11" minlength="10"><br>
                </div>

                <div class="email">
                    <label for="email" class="obrigatorio">E-mail</label>
                    <div class="email-ico">
                        <img src="../../resources/images/email-ico.svg" alt="email-ico">  
                    </div>
                    <input type="email" id="email-user" name="email-user" required placeholder="exemplo@exemplo.com"><br>
                </div>

                <button type="button" id="esconder-passo1" onclick="mostrarProximo('passo1', 'passo2')">AVANÇAR</button>
            </div>

            <div id="passo2" style="display:none;">
                <div class="titulo-cadastro2">
                    <img src="../../resources/images/titulo2.svg" alt="titulo-cadastro2">                   
                </div>

                <div class="estado">
                    <label for="estado" class="obrigatorio">Estado</label>
                    <div class="estado-ico">
                        <img src="../../resources/images/estado-ico.svg" alt="estado-ico">                  
                    </div>
                    <input type="text" id="estado-user" name="estado-user" placeholder="Informe o estado" required><br>
                </div>

                <div class="cidade">
                    <label for="cidade" class="obrigatorio">Cidade</label>
                    <div class="cidade-ico">
                        <img src="../../resources/images/estado-ico.svg" alt="cidade-ico">
                    </div>
                    <input type="text" id="cidade-user" name="cidade-user" required placeholder="Informe a cidade"><br>
                </div>

                <div class="logradouro">
                    <label for="logradouro" class="obrigatorio">Logradouro</label>
                    <div class="logradouro-ico">
                        <img src="../../resources/images/logradouro-ico.svg" alt="logradouro-ico">
                    </div>
                    <input type="text" id="logradouro-user" name="logradouro-user" required placeholder="Informe a rua"><br>
                </div>

                <div class="cep">
                    <label for="cep" class="obrigatorio">CEP</label>
                    <div class="cep-ico">
                        <img src="../../resources/images/cep-ico.svg" alt="cep-ico">
                    </div>
                    <input type="text" id="cep-user" name="cep-user" required pattern="\d{8}" title="Digite 8 dígitos" placeholder="Informe o CEP" maxlength="8" minlength="8"><br>
                </div>

                <div class="tipo">
                    <label for="tipo" class="obrigatorio">Tipo</label>
                    <div class="tipo-ico">
                        <img src="../../resources/images/tipo-ico.svg" alt="tipo-ico">
                    </div>
                    <input type="text" id="tipo-user" name="tipo-user" required placeholder="Ex: Casa, Apto, etc."><br>
                </div>

                <div class="bairro">
                    <label for="bairro" class="obrigatorio">Bairro</label>
                    <div class="bairro-ico">
                        <img src="../../resources/images/bairro-ico.svg" alt="bairro-ico">
                    </div>
                    <input type="text" id="bairro-user" name="bairro-user" required placeholder="Informe o bairro"><br>
                </div>

                <button id="voltar-passo1" onclick="mostrarProximo('passo2', 'passo1')">VOLTAR</button>
                <button id="esconder-passo2" onclick="mostrarProximo('passo2', 'passo3')">AVANÇAR</button>
            </div>

            <div id="passo3" style="display:none;">
                <div class="titulo-cadastro3">
                    <img src="../../resources/images/titulo3.svg" alt="titulo-cadastro3">
                </div>

                <div class="tipos-procedimento">
                    <label for="tipos-procedimento" class="obrigatorio">Tipos de Procedimentos</label>
                    <select name="tipos-procedimento-user" id="tipos-procedimento-user">
                        <optgroup>Selecione um tipo de procedimento</optgroup>
                        <option value="procedimento1">Procedimento 1</option>
                        <option value="procedimento2">Procedimento 2</option>
                        <option value="procedimento3">Procedimento 3</option>
                    </select>
                </div>

                <div class="senha">
                    <label for="senha" class="obrigatorio">Senha</label>
                    <div class="icone-senha">
                        <div class="senha-fechada-ico">
                            <img src="../../resources/images/senha-fechada.svg" alt="senha-fechada-ico">
                        </div>

                        <div class="olho-senha" id="olho-aberto">
                            <img src="../../resources/images/olho-ico.svg" alt="olho-senha-aberto" onclick="toggleIco()">
                        </div>

                        <div class="olho-senha-fechado" id="olho-fechado" style="display: none;">
                            <img src="../../resources/images/olho-fechado.svg" alt="olho-senha-fechado" onclick="toggleIco()">
                        </div>
                    </div>

                    <input type="password" id="senha-user" name="senha-user" placeholder="Informe uma senha" required>
                </div>

                <div class="confirmar-senha">
                    <label for="confirmar-senha" class="obrigatorio">Confirmar Senha</label>
                    <div class="icone-confirmar-senha">
                        <div class="confirmar-senha-fechada-ico">
                            <img src="../../resources/images/senha-aberta.svg" alt="senha-fechada-ico">
                        </div>

                        <div class="olho-senha-aberto-confirmar-senha" id="olho-aberto-confirmar">
                            <img src="../../resources/images/olho-ico.svg" alt="olho-senha-aberto" onclick="toggleIcoConfirmarSenha()">
                        </div>

                        <div class="olho-senha-fechado-confirmar-senha" id="olho-fechado-confirmar" style="display: none;">
                            <img src="../../resources/images/olho-fechado.svg" alt="olho-senha-fechado" onclick="toggleIcoConfirmarSenha()">
                        </div>
                    </div>

                    <input type="password" id="confirmar-senha-user" name="confirmar-senha-user" placeholder="Informe a senha novamente" required>
                </div>

                <div class="voltar">
                    <div class="voltar-seta">
                        <img src="../../resources/images/seta.svg" alt="seta">
                    </div>

                    <div class="voltar-botao">
                        <button type="button" class="voltar-botao-style" onclick="mostrarProximo('passo3', 'passo2')">VOLTAR</button>
                    </div>
                </div>

                <div class="botao-confirmar">
                    <div class="botao">
                        <button type="submit" class="confimar-botao-style">CONFIRMAR</button>
                    </div>
                </div>
        </form>
    </div>
</body>
</html>
