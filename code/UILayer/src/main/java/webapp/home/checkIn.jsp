<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/checkIn.css">
</head>

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
		//TODO: parametrizzare il quiz
		Integer idQuiz = Integer.parseInt(request.getParameter("quiz"));
		if (idQuiz == null) {
	response.sendRedirect("/home/myQuizzies.jsp");
		} else {
	PartitaManager pm = new PartitaManager(dmSession.getId(), 26);
	session.setAttribute("partitaCorrente", pm);
%>

<body>
	<div class="container">


		<p class="text-join">Player partecipating:</p>
		<div class="middle">
			<div class="grid-container" id="players"></div>
		</div>

		<a href="/home/prossimaDomanda.jsp">Avvia Partita</a>
		<p style="background: #fff; font-size: 24px">
			<%
			out.print(pm.getPin());
			%>
		</p>
	</div>

</body>

<script>
	const sessionId =
<%out.print("\"" + session.getId() + "\"");%>
	;

	let socket = new WebSocket("ws://127.0.0.1:8080/host/" + sessionId);

	socket.onopen = function(e) {
		alert("[open] Connessione stabilita");
	};

	socket.onmessage = function(event) {
		console.log(event.data);
		var data = event.data.toString();
		var evento = data.split("$")[0];
		if (evento == "new_player") {
			var d = JSON.parse(data.replace(evento + "$", ""));
			document.getElementById("players").innerHTML += '<div class="grid-item"><img class="img-avatar-display" src="/images/avatar'+d.avatar+'.png">'
					+ '<p class="text-avatar-display">'
					+ d.nickname
					+ '</p></div>'
		}

	};

	socket.onclose = function(event) {
		if (event.wasClean) {
			alert(`[close] Connessione chiusa con successo, code=${event.code} reason=${event.reason}`);
		} else {
			alert('[close] Connection morta.');
		}
	};

	socket.onerror = function(error) {
		alert(`[error] ${error.message}`);
	};
</script>

</html>

<%
}
}
}
%>