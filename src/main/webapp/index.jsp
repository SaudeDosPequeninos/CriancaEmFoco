<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro: Turma</title>
    <style>
    </style>
</head>

<body>
    <div class="top-bar"></div>
    <a href="#" class="house-ico"></a>
    <a href="#" class="tab-ico"></a>

    <div class="CadastroEscola-form">
        <form action="#" method="POST">

            <div id="passo1">
                <h2>Informações Básicas</h2>

                <label for="nome-turma">Nome Turma*</label>
                <input type="text" id="nome-turma-cadastro" name="nome-turma-cadastro" placeholder="Ex: 5º ano" required><br>

                <label for="turno">Turno*:</label>
                <input type="text" id="turno-cadastro" name="turno-cadastro" placeholder="Ex: Matutino" required><br>

                <label for="ano-letivo">Ano Letivo*:</label>
                <input type="number" id="ano-letivo-cadastro" name="ano-letivo-cadastro" placeholder="0000" min="1900" max="2100" required><br>
       
                <input type="button" id="esconder-passo1" value="AVANÇAR">
            </div>
		</form>
    </div>
</body>
</html>