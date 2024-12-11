<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/cadastrar-agendamento.css">
    <title>Cadastro: Agendamento</title>
</head>

<body>
    <div class="top-bar"></div>
    <a href="<%=request.getContextPath()%>/index.jsp" class="house-ico">
        <img src="<%=request.getContextPath()%>/resources/images/house-ico.svg" alt="tab-ico">
    </a>
    <a href="#" class="tab-ico">
        <img src="<%=request.getContextPath()%>/resources/images/tab-ico.svg" alt="tab-ico">
    </a>

    <a href="#" class="sino-ico">
        <img src="<%=request.getContextPath()%>/resources/images/sino.svg" alt="sino-ico">
    </a>

    <a href="#" class="config-ico">
        <img src="<%=request.getContextPath()%>/resources/images/config.svg" alt="config-ico">
    </a>

    <a href="#" class="user-ico">
        <img src="<%=request.getContextPath()%>/resources/images/user.svg" alt="user-ico">
    </a>

    <div class="coisas">
    <div class="perfil">Perfil</div>
    <div class="traco-ico">
        <img src="<%=request.getContextPath()%>/resources/images/traco-ico.svg" alt="traco-ico">
    </div>
    <div class="traco-ico-dois">
        <img src="<%=request.getContextPath()%>/resources/images/traco-ico.svg" alt="traco-ico">
    </div>
    <div class="procedimento">Procedimento</div><div class="agendar-procedimento">Agendar procedimento</div>
    </div>

    <div class="search-tab">
        <input type="text" id="search">
        <img src="<%=request.getContextPath()%>/resources/images/lupa.svg" alt="lupa" id="lupa-ico">
    </div>

        <form action="inserir-agendamento" method="POST">
            <div id="agendamento">
                <div class="agendamento">
                    <div class="titulo">Agendar Procedimento</div>

                    <div id="tipos-procedimento">
                        <label for="tipo-procedimento" class="text-style obrigatorio">Procedimento</label>
				        <select name="tipos-procedimento" id="procedimento" required>
				            <optgroup label="Selecione um procedimento">
				            <c:forEach var="procedimento" items="${agendamentos}">
				                <option value="<c:out value='${procedimento.id}' />"><c:out value='${agendamento.agendamentoProcedimento}' /></option>
				            </c:forEach>
				            </optgroup>
				        </select>
                    </div>

                    <div class="observacao">
                        <label for="observacao" class="text-style obrigatorio">Observações</label>
                        <input type="text" value="<c:out value='${agendamento.descricao}' />" id="observacao" name="observacao" placeholder="Digite aqui alguma observação sobre o procedimento (opcional)">
                    </div>
                    
                        <div class="relogio-ico">
                            <img src="<%=request.getContextPath()%>/resources/images/relogio.svg" alt="relogio" id="relogio-ico">
                        </div>

                    <div id="horario-agendamento" class="horario">
                        <label for="horario" class="text-style obrigatorio">Horário</label>
				        <select name="horario" id="horario" required>
				            <optgroup label="Selecione um horario">
				            <c:forEach var="procedimento" items="${agendamentos}">
				                <option value="<c:out value='${agendamento.horario}' />"><c:out value='${agendamento.horario}' /></option>
				            </c:forEach>
				            </optgroup>
				        </select>
                    </div>

                    <div id="data">
                        <label for="data-agendamento" class="text-style obrigatorio">Data</label>
                        <div class="calendario-ico">
                            <img src="<%=request.getContextPath()%>/resources/images/calendario.svg" alt="calendario" id="calendario-ico">
                        </div>
                        <input type="date" value="<c:out value='${agendamento.data}' />" id="data-agendamento" name="data-agendamento" placeholder="dd/mm/aaaa" required>
                    </div>
                </div>
                
					<div class="checkbox-section">
						<label class="termos">
						    <span>Li e concordo com os <a href="#">Termos de Uso e Política de Privacidade</a></span>
						    <input type="checkbox" name="termos" required>
						    <div class="caixa-customizada"></div>
						</label>
					</div>
                
						<div class="seta-ico">
                            <img src="<%=request.getContextPath()%>/resources/images/seta.svg" alt="seta" id="seta-ico">
                        </div>
                        
						<div class="seta-ico-2">
                            <img src="<%=request.getContextPath()%>/resources/images/seta.svg" alt="seta" id="seta-ico">
                        </div>

                <a href="<%=request.getContextPath()%>/index.jsp" id="cancelar">CANCELAR</a>
                <button type="submit" id="cadastrar">CADASTRAR</button>
            </div>
        </form>
</body>
</html>