<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
</head>
<style>
.is-hidden {
	display: none;
}
</style>
<%@page import="it.quizzy.logiclayer.manager.UtenteManager"%>
<%
String nickname = (String) request.getParameter("nickname");
String avatar = (String) request.getParameter("avatar");
Integer pin = (Integer) session.getAttribute("pin");

if (nickname == null || pin == null || avatar == null) {
	response.sendRedirect("/user/pin.jsp");
} else {
	UtenteManager um = new UtenteManager(nickname, pin);
	session.setAttribute("um", um);
%>


<div id="domandaVF" class="is-hidden">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/track.css">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/questionVF.css">

</head>
<body>
	<div class="timeview"></div>
	<div class="loader"></div>
	<button class="timer">11</button>
	<div class="question  shadow" id="domandaVeroFalso">ì----------------
		questions here -----------------ì</div>
	<div class="container">
		<div class="answer one" id="Vero">
			<span class="leftCol">
				<button class="circle one">A</button>
			</span>
			<p class="content-p">Vero</p>
			<img class="img-answ" src="/images/circle.png">
		</div>
		<div class="answer two" id="Falso">
			<span class="leftCol">
				<button class="circle two">B</button>
			</span>
			<p class="content-p">Falso</p>
			<img class="img-answ" src="/images/square.png">
		</div>
	</div>
</body>
	</html>
</div>

<div id="domandaRM" class="is-hidden">
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
	<button class="timer">11</button>
	<div class="question  shadow" id="domandaRispostaMultipla">ì----------------
		questions here -----------------ì</div>
	<div class="container">
		<div class="answer one" id="R1">
			<span class="leftCol">
				<button class="circle one">A</button>
			</span>
			<p class="content-p" id="R1-content">a.no.1</p>
			<img class="img-answ" src="/images/circle.png">
		</div>
		<div class="answer two" id="R2">
			<span class="leftCol">
				<button class="circle two">B</button>
			</span>
			<p class="content-p" id="R2-content">a no.2</p>
			<img class="img-answ" src="/images/square.png">
		</div>
		<div class="answer three" id="R3">
			<span class="leftCol">
				<button class="circle three">C</button>
			</span>
			<p class="content-p" id="R3-content">a no.3</p>
			<img class="img-answ" src="/images/rhombus.png">
		</div>
		<div class="answer four" id="R4">
			<span class="leftCol">
				<button class="circle four">D</button>
			</span>
			<p class="content-p" id="R4-content">a no.3</p>
			<img class="img-answ" src="/images/triangle.png">
		</div>
	</div>
</body>
	</html>
</div>

<div id="wait" class="">
	<!DOCTYPE html>
	<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/loading.css">
<title>QUIZZY</title>
</head>
<body>
	<span class="back"> <span>W</span> <span>a</span> <span>i</span>
		<span>t</span> <span>i</span> <span>n</span> <span>g</span>
	</span>

</body>
	</html>
</div>

<div id="rispostaCorretta" class="is-hidden">
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
<link rel="stylesheet" type="text/css" href="/css/answers.css">
</head>
<body>
	<div class="centered-div">
		<p class="label-text position">CORRECT ANSWER!</p>
		<div class="middle">
			<div class="points">
				<div class="inside-points">
					<p class="text-points">+100</p>
				</div>
			</div>
			<img src="/images/rigthAnswer.png" class="img-answer">
			<div class="inner">
				<div class="rigth">
					<p class="label-text position" id="RC-pos">13th</p>
				</div>
				<div class="left">
					<p class="label-text" id="RC-punti">Your Points: 9999</p>
				</div>
			</div>

		</div>
	</div>

</body>
	</html>
</div>

<div id="rispostaErrata" class="is-hidden">
	<!DOCTYPE html>
	<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="stylesheet" type="text/css" href="/css/placing.css">
<link rel="stylesheet" type="text/css" href="/css/answers.css">
</head>
<body>
	<div class="centered-div">
		<p class="label-text position">WRONG ANSWER!</p>
		<div class="middle">
			<div class="points">
				<div class="inside-points">
					<p class="text-points">+0</p>
				</div>
			</div>
			<img src="/images/wrongAnswer.png" class="img-answer">
			<div class="inner">
				<div class="rigth">
					<p class="label-text position" id="RE-pos">13th</p>
				</div>
				<div class="left">
					<p class="label-text " id="RE-punti">Your Points: 9999</p>
				</div>
			</div>

		</div>
	</div>

</body>
	</html>
</div>

<script>
	const sessionId =
<%out.print("\"" + session.getId() + "\"");%>
	;

	let socket = new WebSocket("ws://127.0.0.1:8080/join/" + sessionId);

	socket.onopen = function(e) {
		alert("[open] Connessione stabilita");
	};

	socket.onmessage = function(event) {
		console.log(event.data);
		var data = JSON.parse(event.data.split("$")[1]);
		var evento = event.data.split("$")[0];

		switch (evento) {
		case "new_domanda_0":
			nuovaDomandaVeroFalso(data);
			break;
		case "new_domanda_1":
			nuovaDomandaRispostaMultipla(data);
			break;
		case "risposta_corretta":
			rispostaCorretta(data);
			break;
		case "risposta_errata":
			rispostaErrata(data);
			break;
		case "risultati":
			break;
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

	function resetView() {
		document.getElementById("domandaVF").classList.add("is-hidden");
		document.getElementById("domandaRM").classList.add("is-hidden");
		document.getElementById("wait").classList.add("is-hidden");
		document.getElementById("rispostaCorretta").classList.add("is-hidden");
		document.getElementById("rispostaErrata").classList.add("is-hidden");
	}

	function nuovaDomandaVeroFalso(data) {
		resetView();
		document.getElementById("domandaVeroFalso").innerHTML = data.domanda;
		document.getElementById("Vero").onclick = ()=>rispondiDomanda("vero");
		document.getElementById("Falso").onclick = ()=>rispondiDomanda("falso");
		document.getElementById("domandaVF").classList.remove("is-hidden");
	}

	function nuovaDomandaRispostaMultipla(data) {
		resetView();
		document.getElementById("domandaRispostaMultipla").innerHTML = data.domanda;
		data.risposte.forEach((e, index)=>{
			index++;
			console.log("R"+index+"-content");
			document.getElementById("R"+index+"-content").innerHTML=data.risposte[index-1];
			document.getElementById("R"+index).onclick=()=>rispondiDomanda(data.risposte[index-1]);;
		});
		document.getElementById("domandaRM").classList.remove("is-hidden");
	}

	function wait(){
		resetView();
		document.getElementById("wait").classList.remove("is-hidden");
	}

	function rispostaCorretta(data){
		resetView();
		document.getElementById("RC-pos").innerHTML="";
		document.getElementById("RC-punti").innerHTML="Your Points: "+data.punti;
		document.getElementById("rispostaCorretta").classList.remove("is-hidden");
	}

	function rispostaErrata(data){
		resetView();
		document.getElementById("RE-pos").innerHTML="";
		document.getElementById("RE-punti").innerHTML="Your Points: "+data.punti;
		document.getElementById("rispostaErrata").classList.remove("is-hidden");
	}

	function rispondiDomanda(risp){
		console.log(risp);
		wait();
		socket.send("risposta$"+JSON.stringify({risposta:risp}));
	}
</script>


<%
}
%>