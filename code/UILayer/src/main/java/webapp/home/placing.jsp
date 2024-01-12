<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="stylesheet" type="text/css" href="/css/placing.css">
</head>

<%@page import="it.quizzy.logiclayer.manager.PartitaManager"%>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>

<%@page import="it.quizzy.databaselayer.models.Utente"%>

<%@page import="java.util.List"%>

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
%>

<body>
	<div class="centered-div">
		<p class="loginText">Placing</p>
		<div class="container-label">
			<div class="label-avatar label">
				<p class="label-text position">Avatar</p>
			</div>
			<div class="label-name label">
				<p class="label-text position">Name</p>
			</div>
			<div class="label-points label">
				<p class="label-text position">Points</p>
			</div>
		</div>
		<div class="middle">
			<%
			pm.calcolaClassifica();
			List<Utente> giocatori = pm.getGiocatori();
			for (int i = 0; i < giocatori.size(); i++) {
				try {
					Utente u = giocatori.get(i);
			%>
			<div class="placing-item">
				<div class="placing">
					<p class="text-avatar-display grid-item position">1.</p>
				</div>
				<img class="img-avatar-display grid-item" src="/images/avatar1.png">
				<div>
					<p class="text-avatar-display grid-item">
						<%
						out.print(u.getRecord().getNickname());
						%>
					</p>
				</div>
				<div>
					<p class="text-avatar-display grid-item">
						<%
						out.print(u.getRecord().getPunteggio());
						%>
					</p>
				</div>
			</div>
			<%
			} catch (Exception e) {
			}
			}
			;
			%>
		</div>
		<a href="/home/prossimaDomanda.jsp">Prossima Domanda</a>
	</div>
</body>
<%
}
}
}
%>


</html>