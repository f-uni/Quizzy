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

		if (pm == null) {
	response.sendRedirect("/home/dashboard.jsp");
		} else {
	if (pm.getDomandaCorrente() == 0) {
		pm.getServer().stopAcceptRequest();
	}
	String domanda = pm.prossimaDomanda();

	if (domanda == null) {
		response.sendRedirect("/home/results.jsp");
	} else {
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/track.css">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/question.css">

</head>
<body>
	<div class="timeview"></div>
	<div class="loader"></div>
	<div class="question  shadow">
		<%
		out.print(domanda);
		%>
	</div>
	<button>
		<a href="/home/placing.jsp">Avanti</a>
	</button>

</body>
</html>



<%
}
}
}
}
%>