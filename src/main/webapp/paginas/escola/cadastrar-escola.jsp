<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/resources/css/cadastrar-escola.css"%></style>
    <script><%@include file="/resources/js/cadastrar-escola.js"></script>
    <title>Cadastro: Escola</title>
</head>

<body>

    <div class="header">
        <div class="top-bar">
            <a href="../../index.jsp" class="house-ico">
                <img src="../../resources/images/house-ico.svg" alt="house-ico">
            </a>
            <a href="#" class="tab-ico">
                <img src="../../resources/images/tab-ico.svg" alt="tab-ico">
            </a>
        </div>
    </div>
    
        <c:if test="${escola != null}">
			<form action="atualizar-escola" method="post">
		</c:if>
		<c:if test="${escola == null}">
			<form action="inserir-escola" method="post">
		</c:if>
		<c:if test="${escola != null}">
			<input type="hidden" name="id-escola" value="<c:out value='${escola.id}' />" />
			<input type="hidden" name="id-contato" value="<c:out value='${contato.id}' />" />
			<input type="hidden" name="id-endereco" value="<c:out value='${endereco.id}' />" />
		</c:if>
            
                <div id="passo1" style="display: block;">
                    <div class="titulo">
                        <img src="../../resources/images/titulo.svg" alt="Titulo Cadastro">
                    </div>

                    <div class="razaoSocial">
                        <label for="razao-social-user" class="text-style obrigatorio">Razão Social</label>
                        <div class="user-ico">
                            <img src="../../resources/images/user-ico.svg" alt="user-ico">
                        </div>
                        <input type="text" value="<c:out value='${escola.nomeId}' />" id="razao-social-user" name="razao-social-user" placeholder="Informe o nome" required><br>
                    </div>

                    <div class="nomeFantasia">
                        <label for="nome-fantasia-user" class="text-style">Nome Fantasia</label>
                        <div class="user-ico-fantasia">
                            <img src="../../resources/images/user-ico.svg" alt="user-ico-fantasia">   
                        </div>
                        <input type="text" value="<c:out value='${escola.sobrenome}' />" id="nome-fantasia-user" name="nome-fantasia-user" placeholder="Opcional"><br>
                    </div>

                    <div class="cnpj">
                        <label for="cnpj-user" class="text-style obrigatorio">CNPJ</label>
                        <div class="cnpj-ico">
                            <img src="../../resources/images/cnpj-ico.svg" alt="cnpj-ico">                           
                        </div>
                        <input type="text" value="<c:out value='${escola.idFiscal}' />" id="cnpj-user" name="cnpj-user" required pattern="\d{14}" title="Digite 14 dígitos" placeholder="Informe o CNPJ" maxlength="14" minlength="14"><br>
                    </div>

                    <div class="telefone">
                        <label for="tel-user" class="text-style obrigatorio">Telefone</label>
                        <div class="tel-ico">
                            <img src="../../resources/images/telefone-ico.svg" alt="telefone-ico">                  
                        </div>
                        <input type="tel" value="<c:out value='${contato.numCelular}' />" id="tel-user" name="tel-user" required pattern="\d{10,11}" title="Digite 10 ou 11 dígitos" placeholder="(DDD) 9xxxxxxxx" maxlength="11" minlength="10"><br>
                    </div>

                    <div class="email">
                        <label for="email-user" class="text-style obrigatorio">E-mail</label>
                        <div class="email-ico">
                            <img src="../../resources/images/email-ico.svg" alt="email-ico">  
                        </div>
                        <input type="email" value="<c:out value='${escola.email}' />" id="email-user" name="email-user" required placeholder="exemplo@exemplo.com"><br>
                    </div>

                    <button type="button" id="esconder-passo1" onclick="mostrarProximo('passo1', 'passo2')">AVANÇAR</button>
                </div>

                <div id="passo2" style="display:none;">
                    <div class="titulo-cadastro2">
                        <img src="../../resources/images/titulo2.svg" alt="titulo-cadastro2">                   
                    </div>

                    <div class="estado">
                        <label for="estado-user" class="text-style obrigatorio">Estado</label>
                        <div class="estado-ico">
                            <img src="../../resources/images/estado-ico.svg" alt="estado-ico">                  
                        </div>
                        <input type="text" value="<c:out value='${endereco.estado}' />" id="estado-user" name="estado-user" placeholder="Informe o estado" required><br>
                    </div>

                    <div class="cidade">
                        <label for="cidade-user" class="text-style obrigatorio">Cidade</label>
                        <div class="cidade-ico">
                            <img src="../../resources/images/estado-ico.svg" alt="cidade-ico">
                        </div>
                        <input type="text" value="<c:out value='${endereco.cidade}' />" id="cidade-user" name="cidade-user" required placeholder="Informe a cidade"><br>
                    </div>

                    <div class="logradouro">
                        <label for="logradouro-user" class="text-style obrigatorio">Logradouro</label>
                        <div class="logradouro-ico">
                            <img src="../../resources/images/logradouro-ico.svg" alt="logradouro-ico">
                        </div>
                        <input type="text" value="<c:out value='${endereco.logradouro}' />" id="logradouro-user" name="logradouro-user" required placeholder="Informe a rua"><br>
                    </div>

                    <div class="cep">
                        <label for="cep-user" class="text-style obrigatorio">CEP</label>
                        <div class="cep-ico">
                            <img src="../../resources/images/cep-ico.svg" alt="cep-ico">
                        </div>
                        <input type="text" value="<c:out value='${endereco.cep}' />" id="cep-user" name="cep-user" required pattern="\d{8}" title="Digite 8 dígitos" placeholder="Informe o CEP" maxlength="8" minlength="8"><br>
                    </div>

                    <div class="tipo">
                        <label for="tipo-user" class="text-style obrigatorio">Tipo</label>
                        <div class="tipo-ico">
                            <img src="../../resources/images/tipo-ico.svg" alt="tipo-ico">
                        </div>
                        <input type="text" value="<c:out value='${endereco.tipo}' />" id="tipo-user" name="tipo-user" required placeholder="Ex: Casa, Apto, etc."><br>
                    </div>

                    <div class="bairro">
                        <label for="bairro-user" class="text-style obrigatorio">Bairro</label>
                        <div class="bairro-ico">
                            <img src="../../resources/images/bairro-ico.svg" alt="bairro-ico">
                        </div>
                        <input type="text" value="<c:out value='${endereco.bairro}' />" id="bairro-user" name="bairro-user" required placeholder="Informe o bairro"><br>
                    </div>
                    
                    <div class="numero">
                    	<label for = "numero-user" class="text-style obrigatorio">Numero</label>
                    	<div class="numero-ico">
                    		<img src="../../resources/images/numero-ico.svg" alt="numero-ico">
                    	</div>
                    	<input type="number" value="<c:out value='${endereco.numero}' />" id="numero-user" name="numero-user" required min="1" placeholder="Informe o número e complemento"><br>
                    </div>

                    <button type="button" id="voltar-passo1" onclick="mostrarProximo('passo2', 'passo1')">VOLTAR</button>
                    <button type="button" id="esconder-passo2" onclick="mostrarProximo('passo2', 'passo3')">AVANÇAR</button>
                </div>

				<div id="passo3" style="display:none;">
				    <div class="titulo-cadastro3">
				        <img src="../../resources/images/titulo3.svg" alt="titulo-cadastro3">
				    </div>               
				
				    <div class="tipos-procedimento">
				        <label for="tipos-procedimento-user" class="text-style obrigatorio">Tipos de Procedimentos</label>
				        <div class="procedimento-ico">
				            <img id="tipos-procedimento-seta" src="../../resources/images/seta-baixo.svg" alt="seta-baixo" onclick="toggleIcoBaixo()">
				            <img id="seta-cima" src="../../resources/images/seta-cima.svg" alt="seta-cima" style="display:none;" onclick="toggleIcoBaixo()">
				        </div>                    
				        <select name="tipos-procedimento-user" id="tipos-procedimento-user" required>
				            <optgroup label="Selecione um tipo de procedimento">
				            <c:forEach var="procedimento" items="${procedimentos}">
				                <option value="<c:out value='${procedimento.id}' />"><c:out value='${procedimento.nomeProcedimento}' /></option>
				            </c:forEach>
				            </optgroup>
				        </select>
				    </div>
				
				    <div class="senha">
				        <label for="senha-user" class="text-style obrigatorio">Senha</label>
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
				        <label for="confirmar-senha-user" class="text-style obrigatorio">Confirmar Senha</label>
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
				        <button type="submit" class="confimar-botao-style" id="confirmar-btn">CONFIRMAR</button>        
				    </div>
				</div>
            </form>
</body>
</html>