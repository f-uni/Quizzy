<!DOCTYPE html>
<%@page import="it.quizzy.databaselayer.models.Quiz"%>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/bulma.min.css">
<link rel="stylesheet" type="text/css" href="/css/myQuizzies.css">

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
			<a class="navbar-item " href="/"> <img src="/images/logo4.png"
				width="100" height="100">
			</a> <a role="button" class="navbar-burger" aria-label="menu"
				aria-expanded="false" data-target="navbarBasicExample"> <span
				aria-hidden="true"></span> <span aria-hidden="true"></span> <span
				aria-hidden="true"></span>
			</a>
		</div>

		<div id="navbarBasicExample" class="navbar-menu">
			<div class="navbar-start">
				<a class="navbar-item hover-underline-animation"
					href="/home/dashboard.jsp"> HOME </a> <a
					class="navbar-item hover-underline-animation is-active"
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
						</a> <a class="button is-profile"> <img class="profile-image"
							src="/images/profileDoc.png" height="100" width="100">
						</a>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<div class="container-fluid ">
		<div class="wrapper">
			<div class="quizzies">
				<%
				for (Quiz q : dmSession.getQuizzies()) {
				%>
				<div class="quiz columns">
					<div class="column is-11 is-10-mobile quiz-titolo">
						<%
						out.print(q.getRecord().getTitolo());
						%>
					</div>
					<div class="column is-1 is-2-mobile">
						<a class="play-button"
							href="<%out.print("/home/checkIn.jsp?quiz=" + q.getRecord().getId());%>">&#9654</a>
					</div>

				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
<script src="/js/dashboard.js"></script>
</html>
<%
}
}
%>