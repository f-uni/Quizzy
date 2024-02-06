<!DOCTYPE html>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/loginDoc.css">
</head>
<%

DocenteManager dmSession = (DocenteManager)session.getAttribute("dm");  
if(dmSession!=null){
	if(dmSession.isLogged()){
		String logout=request.getParameter("logout");
		if(logout!=null){
			session.setAttribute("dm",null);
		}else{
			response.sendRedirect("/home/dashboard.jsp");
		}
	}
}

String mail = request.getParameter("email");
String password = request.getParameter("password");

if (mail != null && password != null) {
	DocenteManager dm = new DocenteManager();
	boolean success = dm.login(mail, password);
	if (success) {
		response.sendRedirect("/home/dashboard.jsp");
	}
	session.setAttribute("dm", dm);
}
%>

<body>
	<div class="container inside-form">
		<form action="/home/login.jsp" method="POST">
			<p class="login-title">Sign In</p>
			<div>
				<input class="signIn email" type="email" placeholder="Email"
					name="email"> <img class="icon"
					src="/images/icons8-nuovo-messaggio-64.png">
			</div>
			<div>
				<input class="signIn password" type="password"
					placeholder="Password" name="password"> <img class="icon"
					src="/images/icons8-password-64.png">
			</div>
			<button class="sign-Up has-margin">Login</button>
		</form>
		<hr class="divider">
		<p class="login-text">New Here?</p>
		<a href="/home/signUp.jsp"><button class="sign-Up">Sign Up</button></a>
	</div>

</body>
</html>