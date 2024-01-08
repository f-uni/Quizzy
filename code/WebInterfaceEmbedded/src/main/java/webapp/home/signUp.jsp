<!DOCTYPE html>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="icon" type="image/png" href="/images/Logo3.png">
    <link rel="stylesheet" type="text/css" href="/css/signUpDoc.css">
    <title>Document</title>
</head>
<%   

String nome=request.getParameter("nome");
String mail=request.getParameter("email");
String password=request.getParameter("password");

if(nome!=null && mail!=null && password!=null){
	DocenteManager dm = new DocenteManager();
	boolean success=dm.signUp(nome, mail, password);
	if(success){
		 response.sendRedirect("/home/login.jsp");
	}
	session.setAttribute("dm",dm);
}
%> 
<body>
    <form class="container inside-form" action="/home/signUp.jsp">
        <p class="login-title">Sign Up</p>
        <div>
            <input class="signIn name" type="text" placeholder="Name" name="nome"> 
            <img class="icon" src="/images/icons8-utente-48.png">
        </div>
        <div>
            <input class="signIn email" type="email" placeholder="Email" name="email">
            <img class="icon" src="/images/icons8-nuovo-messaggio-64.png">
        </div>
        <div>
            <input class="signIn password" type="password" placeholder="Password" name="password">
            <img class="icon" src="/images/icons8-password-64.png">
        </div>
        <button class="sign-Up has-margin"> Sign Up</button>
    </form>
</body>
</html>