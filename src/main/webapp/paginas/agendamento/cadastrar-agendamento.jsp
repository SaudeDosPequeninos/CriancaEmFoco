<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro: Agendamento</title>
</head>

<body>
    <div class="top_bar"></div>
    <a href="<%=request.getContextPath()%>/index.jsp" class="house_ico"></a>
    <a href="#" class="tab_ico"></a>

    <div class="CadastroEscola-form">
        <form action="inserir-agendamento" method="POST">

            <div id="agendamento">
                <div class="agendamento">
                    <div class="title">Agendar Procedimento</div>

                    <div id="tipos-procedimento">
                        <label for="tipo-procedimento">Procedimento*</label>
				        <select name="tipos-procedimento" id="procedimento" required>
				            <optgroup label="Selecione um procedimento">
				            <c:forEach var="procedimento" items="${agendamentos}">
				                <option value="<c:out value='${procedimento.id}' />"><c:out value='${agendamento.agendamentoProcedimento}' /></option>
				            </c:forEach>
				            </optgroup>
				        </select>
                    </div>

                    <div id="observacao">
                        <label for="observacao">Observações</label>
                        <input type="text" value="<c:out value='${agendamento.descricao}' />" id="observacao" name="observacao" placeholder="Digite aqui alguma observação sobre o procedimento (opcional)">
                    </div>

                    <div id="horario-agendamento" class="horario">
                        <label for="horario">Horário*</label>
				        <select name="horario" id="horario" required>
				            <optgroup label="Selecione um horario">
				            <c:forEach var="procedimento" items="${agendamentos}">
				                <option value="<c:out value='${agendamento.horario}' />"><c:out value='${agendamento.horario}' /></option>
				            </c:forEach>
				            </optgroup>
				        </select>
                    </div>

                    <div id="data" class="Data">
                        <label for="data-agendamento">Data*</label>
                        <input type="date" value="<c:out value='${agendamento.data}' />" id="data-agendamento" name="data-agendamento" placeholder="dd/mm/aaaa" required>
                    </div>
                </div>

                <input type="submit" value="Cadastrar Agendamento">
            </div>
        </form>
    </div>
</body>
</html>