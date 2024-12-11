<html>
<body>
<h2><%= "Hello World!" %></h2>

<a href="<%= request.getContextPath()%>/paginas/enfermeiro/agenda.jsp">Enfermeiro Agenda</a>
  
<a href="<%=request.getContextPath()%>/paginas/responsavel/cadastrar-responsavel.jsp">Cadastrar Responsavel</a>
  
<a href="<%=request.getContextPath()%>/paginas/escola/perfil-escola.jsp">Perfil Escola</a>

</body>
</html>
