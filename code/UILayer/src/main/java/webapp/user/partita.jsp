<%@page import="it.quizzy.logiclayer.manager.UtenteManager"%>
<%
String nickname = (String) request.getParameter("nickname");
Integer pin = (Integer) session.getAttribute("pin");

if (nickname == null || pin == null) {
	response.sendRedirect("/user/pin.jsp");
} else {
	UtenteManager um = new UtenteManager(nickname, pin);
	session.setAttribute("um", um);
%>

<div id="domanda"></div>

<script>
	const sessionId =
<%out.print("\"" + session.getId() + "\"");%>
	;

	let socket = new WebSocket("ws://127.0.0.1:8080/partecipa/" + sessionId);

	socket.onopen = function(e) {
		alert("[open] Connessione stabilita");
	};

	socket.onmessage = function(event) {
		console.log(event.data);
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



<%
}
%>


