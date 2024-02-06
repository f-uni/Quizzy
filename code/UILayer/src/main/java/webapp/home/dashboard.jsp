<!DOCTYPE html>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/bulma.min.css">
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
<link rel="stylesheet" type="text/css" href="/css/scrollbar.css">
<title>QUIZZY</title>
</head>
<%
DocenteManager dmSession = (DocenteManager) session.getAttribute("dm");
if (dmSession == null) {
	response.sendRedirect("/home/login.jsp");
} else {
	if (!dmSession.isLogged()) {
		response.sendRedirect("/home/login.jsp");
	} else {
%>

<body>
	<nav class="navbar is-high shadow has-border-yellow" role="navigation"
		aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item " href="/index.html"> <img
				src="/images/logo4.png" width="100" height="100">
			</a> <a role="button" class="navbar-burger" aria-label="menu"
				aria-expanded="false" data-target="navbarBasicExample"> <span
				aria-hidden="true"></span> <span aria-hidden="true"></span> <span
				aria-hidden="true"></span>
			</a>
		</div>

		<div id="navbarBasicExample" class="navbar-menu">
			<div class="navbar-start">
				<a class="navbar-item hover-underline-animation is-active"
					href="/home/dashboard.jsp"> HOME </a> <a
					class="navbar-item hover-underline-animation"
					href="/home/myQuizzies.jsp"> My Quiz </a> <a
					class="navbar-item hover-underline-animation"> All Quiz </a>

			</div>

			<div class="navbar-end">
				<div class="navbar-item">

					<div class="buttons">
						<input class="searchBar" type="text" placeholder="Search...">
						<a class="button is-warning shadow" href="/home/newQuiz.jsp">
							<i class="fa-solid fa-plus" aria-hidden="true"></i><strong>New
								Quiz</strong>
						</a> <a class="button is-danger shadow"
							href="/home/login.jsp?logout=true"> <i
							class="fa-solid fa-plus" aria-hidden="true"></i><strong>LogOut</strong>
						</a> <a class="button is-profile"> <img class="profile-image"
							src="/images/profileDoc.png" height="100" width="100">
						</a>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<div class="container-fluid text-box">
		<div class="container center">
			<img src="/images/Logo3-removebg-preview.png" height="500"
				width="500">
		</div>
	</div>
	<div class="container-fluid dashedBorder">
		<div class="container informative">
			<div class="container informative-div">
				<h1 class="informative-header">About Us</h1>
				<p class="informative-content">Quizzy è una piattaforma di
					apprendimento tramite gioco, utilizzata a scopo didattico in un
					ambiente scolastico e educativo. Il suo funzionamento si basa sui
					quiz, ovvero una serie di domande decise dal docente che mirano a
					valutare le conoscenze degli studenti e allo stesso tempo svolgono
					il ruolo di un importante ripasso interattivo.</p>
			</div>
			<img src="/images/aboutus.png" class="informative-img"
				style="display: flex;">
		</div>
	</div>
</body>
<script src="/js/dashboard.js"></script>
</html>
<%
}
}
%>