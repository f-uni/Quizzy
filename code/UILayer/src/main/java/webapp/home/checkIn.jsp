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
		request.getParameter("idQuiz");
		PartitaManager pm = new PartitaManager(dmSession.getId(), 26);
		session.setAttribute("partitaCorrente", pm);
%>

<body>
	<div class="container">
	
	
		<p class="text-join">Player partecipating:</p>
		<div class="middle">
			<div class="grid-container" id="players">
				
			</div>
		</div>
		
		<a href="/home/prossimaDomanda.jsp">Avvia Partita</a>
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
		var evento=data.split("$")[0];
		if(evento=="new_player"){
			var nome=data.replace(evento+"$", "");
			var random= Math.floor(Math.random() * (9 - 1 + 1) + 1)
			document.getElementById("players").innerHTML+='<div class="grid-item"><img class="img-avatar-display" src="/images/avatar'+random+'.png">'+
			'<p class="text-avatar-display">'+nome+'</p></div>'
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
%>