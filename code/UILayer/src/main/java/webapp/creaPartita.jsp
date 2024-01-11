<%@page import="it.quizzy.logiclayer.manager.PartitaManager"%>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>

<%
DocenteManager dmSession = (DocenteManager) session.getAttribute("dm");
if (dmSession == null) {
	response.sendRedirect("/home/login.jsp");
} else {
	if (!dmSession.isLogged()) {
		response.sendRedirect("/home/login.jsp");
	} else {
		request.getParameter("idQuiz");
		PartitaManager pm = new PartitaManager(dmSession.getId(), 26);
		session.setAttribute("partitaCorrente", pm);
	}
}
%>

<a href="/prossimaDomanda.jsp">Avvia Partita</a>

<script>
	
</script>