<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CadastroEscola.css">
    <title>Cadastro:Turma</title>
    <style>
    </style>
</head>

<body>
    <div class="top-bar"></div>
    <a href="#" class="house-ico"></a>
    <a href="#" class="tab-ico"></a>

    <div class="CadastroEscola-form">
        <form action="criancaemfoco/cadastro/escola" method="POST">
            <div id="turma">
                <h2>Informações Básicas</h2>

                <label for="nome-turma">Nome Turma*:</label>
                <input type="text" id="nome-turma-cadastro" name="nome-turma-cadastro" placeholder="Informe o nome" required><br>

                <label for="turno">Turno*:</label>
                <input type="text" id="turno-turma" name="turno-turma" placeholder="turno-turma" required><br>

                <label for="cnpj">Ano Letivo*:</label>
                <input type="number" id="cnpj-cadastro" name="cnpj-cadastro" required pattern="\d{14}" title="Digite 14 dígitos" placeholder="Informe o CNPJ" maxlength="14" minlength="14"><br>

                <label for="tel">Telefone*:</label>
                <input type="number" id="tel-cadastro" name="tel-cadastro" required pattern="\d{10,11}" title="Digite 10 ou 11 dígitos" placeholder="(DDD) 9xxxxxxxx" maxlength="11" minlength="10"><br>

                <label for="email">E-mail*:</label>
                <input type="email" id="email-cadastrar" name="email-cadastrar" required placeholder="exemplo@exemplo.com"><br>

                <input type="button" id="esconder-passo1" onclick="mostrarProximo('passo1', 'passo2')" value="AVANÇAR">
            </div>
        </form>
    </div>

    <script src="CadastroEscola.js"></script>
    <script>
    </script>
</body>
</html>
