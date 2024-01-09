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
		PartitaManager pm = (PartitaManager) session.getAttribute("partitaCorrente");
		
		if(pm==null){
			response.sendRedirect("/home/dashboard.jsp");
		}else{
			if(pm.getDomandaCorrente()==0){
				pm.getServer().stopAcceptRequest();
			}
			String domanda=pm.prossimaDomanda();
			if(domanda==null){
				response.sendRedirect("/finePartita.jsp");
			}else{
				out.println(domanda);
			}
		}
	}
}
%>
<a href="/prossimaDomanda.jsp">Prossima domanda</a>