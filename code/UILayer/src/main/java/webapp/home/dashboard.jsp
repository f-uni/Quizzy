<!DOCTYPE html>
<%@page import="it.quizzy.logiclayer.manager.DocenteManager"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="/images/Logo3.png">
    <link rel="stylesheet" type="text/css" href="/css/bulma.min.css">
    <link rel="stylesheet" type="text/css" href="/css/dashboard.css">
    <title>QUIZZY</title>
</head>
<%

DocenteManager dmSession = (DocenteManager)session.getAttribute("dm");  
if(dmSession==null){
	response.sendRedirect("/home/login.jsp");
}else{
	if(!dmSession.isLogged()){
		response.sendRedirect("/home/login.jsp");
	}else{
		%>
		
<body>
    <nav class="navbar is-high shadow has-border-yellow" role="navigation" aria-label="main navigation" >
        <div class="navbar-brand">
          <a class="navbar-item " href="https://bulma.io">
            <img src="/images/logo4.png" width="100" height="100">
          </a>
      
          <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
      
        <div id="navbarBasicExample" class="navbar-menu">
          <div class="navbar-start">
            <a class="navbar-item hover-underline-animation is-active">
              HOME
            </a>

            <a class="navbar-item hover-underline-animation">
              My Quiz
            </a>
      
            <a class="navbar-item hover-underline-animation">
              All Quiz
            </a>
      
          </div>
      
          <div class="navbar-end">
            <div class="navbar-item">
                
              <div class="buttons">
                <input class="searchBar" type="text" placeholder="Search...">
                <a class="button is-warning shadow">
                  <i class="fa-solid fa-plus" aria-hidden="true" ></i><strong>New Quiz</strong>
                </a>
                <a class="button is-profile">
                    <img class="profile-image" src="/images/profileDoc.png" height="100" width="100">
                </a>
              </div>
            </div>
          </div>
        </div>
      </nav>
      <div class="container-fluid text-box">
        <div class="container center">
            <img src="/images/Logo3-removebg-preview.png" height="500" width="500">
        </div>
      </div>
      <div class="container-fluid dashedBorder">
        <div class="container informative">
            <div class="container informative-div">
              <h1  class="informative-header"> About Us</h1>
              <p class="informative-content">
                Una scuola bergamasca commissiona la realizzazione di una piattaforma
                che permetta una diversa interazione professore-studente per migliorare la didattica e l'apprendimento.
                 Secondo un sondaggio svolto dai professori della scuola, il risultato con più votazioni è
                  l’utilizzo di uno strumento di quiz alternativo che possa essere svolto in classe, ma anche 
                  a distanza che risvegli la curiosità degli studenti e gli permetta di imparare e di divertirsi
                 allo stesso momento.</p>
            </div>
            <img src="/images/aboutus.png" class="informative-img" style="display: flex;">
        </div>
      </div>
      <div class="container-fluid">
		benvenuto <% out.print(dmSession.getNome()); %>
      </div>
</body>
<script src="/js/dashboard.js"></script>
</html>
		<% 
	}
}

%>