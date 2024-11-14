<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro: Agendamento</title>
</head>

<body>
    <div class="top_bar"></div>
    <a href="/index.jsp" class="house_ico"></a>
    <a href="#" class="tab_ico"></a>

    <div class="CadastroEscola-form">
        <form action="inserir-agendamento" method="POST">

            <div id="agendamento">
                <div class="agendamento">
                    <div class="title">Agendar Procedimento</div>

                    <div id="tipos-procedimento">
                        <label for="tipo-procedimento">Procedimento*</label>
                        <select id="tipo-procedimento" name="tipo-procedimento" required>
                            <option disabled selected>Selecione um Procedimento</option>
                            <option value="administracao-de-medicamento">Administração de Medicamento</option>
                            <option value="verificacao-de-glicose">Verificação de Glicose</option>
                        </select>
                    </div>

                    <div id="observacao">
                        <label for="observacao">Observações</label>
                        <input type="text" id="observacao" name="observacao" placeholder="Digite aqui alguma observação sobre o procedimento (opcional)">
                    </div>

                    <div id="horario-agendamento" class="horario">
                        <label for="horario">Horário*</label>
                        <select id="horario" name="horario" required>
                            <option disabled selected>Selecione um Horário</option>
                            <option value="18:30">18:30</option>
                            <option value="20:30">20:30</option>
                        </select>
                    </div>

                    <div id="data" class="Data">
                        <label for="data-agendamento">Data*</label>
                        <input type="date" id="data-agendamento" name="data-agendamento" placeholder="dd/mm/aaaa" required>
                    </div>
                </div>

                <input type="submit" value="Cadastrar Agendamento">
            </div>
        </form>
    </div>
</body>
</html>