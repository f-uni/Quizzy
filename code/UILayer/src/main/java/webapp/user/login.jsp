<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>QUIZZY</title>
<link rel="icon" type="image/png" href="/images/Logo3.png">
<link rel="stylesheet" type="text/css" href="/css/background.css">
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="stylesheet" type="text/css" href="/css/track.css">
</head>
<style>
</style>
</head>

<%
String pin = null;

try {
	pin = (String) request.getParameter("pin");
} catch (Exception e) {
	response.sendRedirect("/user/pin.jsp");
}

if (pin == null) {
	response.sendRedirect("/user/pin.jsp");
} else {
	session.setAttribute("pin", pin);
%>
<body>
	<div class="centered-div">

		<img class="avatar" src="/images/UserDefault.jpg" id="avatar"></img>
		<p class="loginText">Choose an avatar</p>
		<button class="select" onclick="showAvatarOption()"
			id="selectionButton">
			<i class="fa fa-plus" aria-hidden="true" style="font-size: large;">
				<span
				style="font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;">&nbsp;
					Select</span>
			</i>
		</button>

		<div class="image-selector" id="image-selector">
			<div class="image-container">
				<img class="avataricon" src="/images/avatar1.png"
					onclick="chosenAvatar(1)" alt="Immagine 1"> <img
					class="avataricon" src="/images/avatar2.png"
					onclick="chosenAvatar(2)" alt="Immagine 2"> <img
					class="avataricon" src="/images/avatar3.png"
					onclick="chosenAvatar(3)" alt="Immagine 3"> <img
					class="avataricon" src="/images/avatar4.png"
					onclick="chosenAvatar(4)" alt="Immagine 4"> <img
					class="avataricon" src="/images/avatar5.png"
					onclick="chosenAvatar(5)" alt="Immagine 5"> <img
					class="avataricon" src="/images/avatar6.png"
					onclick="chosenAvatar(6)" alt="Immagine 6"> <img
					class="avataricon" src="/images/avatar7.png"
					onclick="chosenAvatar(7)" alt="Immagine 7"> <img
					class="avataricon" src="/images/avatar8.png"
					onclick="chosenAvatar(8)" alt="Immagine 8"> <img
					class="avataricon" src="/images/avatar9.png"
					onclick="chosenAvatar(9)" alt="Immagine 9">
			</div>
		</div>
		<br> <br>
		<hr>
		<form action="partita.jsp">
			<p class="loginText">Enter a name:
			<p>
				<input class="nameInput" type="text" placeholder="Enter a name"
					name="nickname" required> <br>
				<button class="select" type="submit" value="Submit">Submit</button>
				<input style="display: none" type="text" name="avatar"
					id="avatarInput" value="1">
		</form>
	</div>
</body>
<script src="/js/login.js">
	
</script>
<%
}
%>
</html>