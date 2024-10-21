<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CadastroEscola.css">
    <title>Cadastro: Escola</title>
    <style>
    </style>
</head>

<body>
    <div class="top-bar"></div>
    <a href="#" class="house-ico">
    </a>
    
    <a href="#" class="tab-ico"> <!-- SVG do tab --> </a>

    <div class="CadastroEscola-form">
        <form action="inserir-escola" method="POST">

            <div id="passo1">
                <h2>Passo 1 - Informações Básicas</h2>

                <label for="razao-social">Razão Social*</label>
                <input type="text" id="razao-social" name="razao-social" required placeholder="Informe o nome"><br>

                <label for="nome-fantasia">Nome Fantasia:</label>
                <input type="text" id="nome-fantasia" name="nome-fantasia" placeholder="Opcional"><br>

                <label for="cnpj">CNPJ*:</label>
                <input type="number" id="cnpj" name="cnpj" required pattern="\d{14}" title="Digite 14 dígitos" placeholder="Informe o CNPJ" maxlength="14" minlength="14"><br>

                <label for="tel">Telefone*:</label>
                <input type="number" id="telefone" name="telefone" required pattern="\d{10,11}" title="Digite 10 ou 11 dígitos" placeholder="(DDD) 9xxxxxxxx" maxlength="11" minlength="10"><br>

                <label for="email">E-mail*:</label>
                <input type="email" id="email" name="email" required placeholder="exemplo@exemplo.com"><br>

                <input type="button" id="esconder-passo1" value="AVANÇAR">
            </div>

            <div id="passo2">
                <h2>Passo 2 - Endereço</h2>

                <label for="estado">Estado*:</label>
                <input type="text" id="estado" name="estado" required placeholder="Informe o estado"><br>

                <label for="cidade">Cidade*:</label>
                <input type="text" id="cidade" name="cidade" required placeholder="Informe a cidade"><br>

                <label for="logradouro">Logradouro*:</label>
                <input type="text" id="logradouro" name="logradouro" required placeholder="Informe a rua"><br>

                <label for="cep">CEP*:</label>
                <input type="number" id="cep" name="cep" required pattern="\d{8}" title="Digite 8 dígitos" placeholder="Informe o CEP" maxlength="8" minlength="8"><br>

                <label for="bairro">Bairro*:</label>
                <input type="text" id="bairro" name="bairro" required placeholder="Informe o bairro"><br>

                <label for="numero">Número*:</label>
                <input type="number" id="numero" name="numero" required min="1" placeholder="Informe o número e complemento"><br>

                <input type="button" value="< VOLTAR">
                <input type="button" value="CONTINUAR" >
            </div>

            <div id="passo3">
                <h2>Passo 3 - Informações Adicionais e Senha</h2>

                <label for="tipos-procedimento">Tipos de Procedimentos*</label>
                <div class="procedimento-container">
                    Procedimentos
                </div>
                <div class="procedimento-list" id="procedimentos">
                    <select id="tipos-procedimento-cadastro" name="tipos-procedimento[]" multiple required>
                        <option value="Procedimento 1">Procedimento 1</option>
                        <option value="Procedimento 2">Procedimento 2</option>
                        <option value="Procedimento 3">Procedimento 3</option>
                        <option value="Procedimento 4">Procedimento 4</option>
                    </select>
                    <small>Segure o CTRL para selecionar múltiplos procedimentos</small><br><br>
                </div>

                <label for="senha">Senha*</label>
                <input type="password" name="senha" id="senha" required minlength="8" maxlength="20" placeholder="Informe uma senha"><br>

                <label for="confirmar-senha">Confirmar Senha*</label>
                <input type="password" name="confirmar-senha-cadastro" id="confirmar-senha-cadastro" required minlength="8" maxlength="20" placeholder="Informe a senha novamente"><br>

                <input type="button" value="< VOLTAR">
                <input type="submit" value="CONFIRMAR">
            </div>

        </form>
    </div>
</body>
</html>