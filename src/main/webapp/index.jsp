<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro:Turma</title>
    <style>
    </style>
</head>

<body>
    <div class="top-bar"></div>
    <a href="#" class="house-ico"></a>
    <a href="#" class="tab-ico"></a>

    <div class="CadastroEscola-form">
        <form action="cadastrar/turma/inserir" method="POST">
            <div id="passo1">
                <h2>Informações Básicas</h2>

                <label for="nome-user">Nome Turma*</label>
                <input type="text" id="nome-user" name="nome-user" placeholder="Ex: 5º ano" required><br>

                <label for="turno">Turno*</label>
                <input type="text" id="turno-cadastro" name="turno-cadastro" placeholder="Ex: Matutino" required><br>

                <label for="ano-letivo">Ano Letivo*</label>
                <input type="number" id="ano-letivo" name="ano-letivo" placeholder="0000" min="1900" max="2100" required><br>
       
                <input type="button" id="esconder-passo1" value="AVANÇAR">
            </div>
		</form>
    </div>
</body>
</html>