<%@page import="it.quizzy.logiclayer.manager.QuizManager"%>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<%
DocenteManager dmSession = (DocenteManager)session.getAttribute("dm");  
if(dmSession==null){
	response.sendRedirect("/home/login.jsp");
}else{
	if(!dmSession.isLogged()){
		response.sendRedirect("/home/login.jsp");
	}else{
		request.getAttribute("quiz");
		//process insert
	}
}
%>