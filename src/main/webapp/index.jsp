<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CadastroEscola.css">
    <title>Cadastro:Agendamento</title>
</head>

<body>
    <div class="top_bar"></div>
    <a href="#" class="house_ico"></a>
    <a href="#" class="tab_ico"></a>

    <div class="CadastroEscola-form">
        <form action="cadastrar-classe" method="POST">
            
            <div id="agendamento">
                <div class="agendamento">
                    <h2>Agendamento</h2>
					<div></div>
                    <div class="tipos-procedimento">
                        <label for="tipo-procedimento">Tipo de Procedimento</label>
                        <select id="tipo-procedimento" name="tipo-procedimento" required>
                            <option value="administracao-de-medicamento">Administração de Medicamento</option>
                            <option value="verificacao-de-glicose">Verificação de Glicose</option>
                        </select>
                    </div>

                    <label for="descricao-detalhada">Descrição Detalhada</label>
                    <input type="text" id="descricao-detalhada" name="descricao-detalhada" placeholder="Digite a descrição detalhada (se necessário)" required>

                    <div class="categoria-procedimento">
                        <label for="categoria-procedimento">Categoria do Procedimento</label>
                        <select id="categoria-procedimento" name="categoria-procedimento" required>
                            <option value="diario">Diário</option>
                            <option value="semanal">Semanal</option>
                            <option value="emergencial">Emergencial</option>
                        </select>
                    </div>

                    <label for="data-agendamento">Data e Hora do Procedimento</label>
                    <input type="datetime-local" id="data-agendamento" name="data-agendamento" required>

                    <label for="frequencia">Frequência</label>
                    <select id="frequencia" name="frequencia" required>
                        <option value="unico">Único</option>
                        <option value="recorrente">Recorrente</option>
                    </select>
                </div>

                <div class="informacoes-medicas" id="informacoes-medicas">
                    <h3>Informações Médicas</h3>

                    <label for="medicamento-necessario">Medicamento Necessário</label>
                    <input type="text" id="medicamento-necessario" name="medicamento-necessario" placeholder="Medicamento necessário" required>

                    <label for="dose">Dose</label>
                    <input type="text" id="dose" name="dose" placeholder="Digite a dose" required>

                    <label for="frequencia-administracao">Frequência de Administração</label>
                    <input type="text" id="frequencia-administracao" name="frequencia-administracao" placeholder="Digite a frequência de administração" required>
                </div>

                <div class="documentos" id="documentos">
                    <h3>Autorizações e Documentos</h3>

                    <label for="autorizacao-medica">Autorização Médica (opcional)</label>
                    <input type="file" id="autorizacao-medica" name="autorizacao-medica" accept=".pdf,.doc,.docx">

                    <label for="autorizacao-responsaveis">Autorização dos Pais ou Responsáveis</label>
                    <input type="checkbox" id="autorizacao-responsaveis" name="autorizacao-responsaveis" required>
                    <label for="autorizacao-responsaveis">Autorizo</label>
                </div>

                <div class="acompanhamento" id="acompanhamento">
                    <h3>Acompanhamento</h3>

                    <label for="enfermeiro-designado">Enfermeiro Designado</label>
                    <select id="enfermeiro-designado" name="enfermeiro-designado" required>
                        <option value="enfermeiro-1">Enfermeiro 1</option>
                        <option value="enfermeiro-2">Enfermeiro 2</option>
                    </select>

                    <label for="notificacoes">Notificações Automáticas</label>
                    <input type="checkbox" id="notificacoes" name="notificacoes" checked>
                    <label for="notificacoes">Ativar notificações para responsáveis e escola</label>

                    <label for="observacoes">Observações Adicionais</label>
                    <textarea id="observacoes" name="observacoes" placeholder="Digite suas observações"></textarea>
                </div>

                <input type="submit" value="Cadastrar Agendamento">
            </div>
        </form>
    </div>
</body>

</html>