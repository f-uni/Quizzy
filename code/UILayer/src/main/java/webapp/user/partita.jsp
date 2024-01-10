<%@page import="it.quizzy.logiclayer.manager.UtenteManager"%>
<%
String nickname = (String) request.getParameter("nickname");
Integer pin = (Integer) session.getAttribute("pin");

if (nickname == null || pin == null){
	response.sendRedirect("/user/pin.jsp");
}else{
	UtenteManager um = new UtenteManager(nickname, pin);
	session.setAttribute("um", um);
}
	

%>

<div id="domanda"></div>

<script>
	var source = new EventSource("/sse/0000");
	source.onmessage = function(event) {
		console.log("Received event: " + event.data);
	}
</script>
