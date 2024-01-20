<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/results.css">
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
	pm.getServer().stopPartita();

	List<Utente> giocatori = pm.getGiocatori();
%>
<body>
	<div class="centered-div">
		<div class="container-results">
			<div class="image-container third">
				<img class="avatar-podium avatar-third"
					src="/images/avatar<%if (giocatori.size() >= 3)
	out.print(giocatori.get(3 - 1).getRecord().getAvatar());
else
	out.print("0");%>.png">
			</div>
			<div class="image-container first">
				<img class="crown" src="/images/corona.png"> <img
					class="avatar-podium avatar-first"
					src="/images/avatar<%if (giocatori.size() >= 1)
	out.print(giocatori.get(1 - 1).getRecord().getAvatar());
else
	out.print("0");%>.png">
			</div>
			<div class="image-container second">
				<img class="avatar-podium avatar-secomd"
					src="/images/avatar<%if (giocatori.size() >= 2)
	out.print(giocatori.get(2 - 1).getRecord().getAvatar());
else
	out.print("0");%>.png">
			</div>

			<div class="podium thirdPlace">
				<div class="name">
					<p>
						<%
						if (giocatori.size() >= 3)
							out.print(giocatori.get(3 - 1).getRecord().getNickname());
						%>
					</p>
				</div>
				<div class="position">
					<img class="img-position third-position"
						src="/images/thirdplace.png">
				</div>
			</div>

			<div class="podium firstPlace">
				<div class="name">
					<p>
						<%
						if (giocatori.size() >= 1)
							out.print(giocatori.get(1 - 1).getRecord().getNickname());
						%>
					</p>
				</div>
				<div class="position">
					<div class="position">
						<img class="img-position first-position"
							src="/images/firstplace.png">
					</div>
				</div>
			</div>

			<div class="podium secondPlace">
				<div class="name">
					<p>
						<%
						if (giocatori.size() >= 2)
							out.print(giocatori.get(2 - 1).getRecord().getNickname());
						%>
					</p>
				</div>
				<div class="position">
					<div class="position">
						<img class="img-position second-position"
							src="/images/secondplace.png">
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
<%
}
}
}
%>
</html>