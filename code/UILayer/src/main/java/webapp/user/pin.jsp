<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUIZZY</title>
    <link rel="icon" type="image/png" href="/images/Logo3.png">
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <link rel="stylesheet" type="text/css" href="/css/background.css">
</head>

<style>
.btn {
    width: 50%;
    min-width: 150px;
    padding: 7px;
    height: 2.5rem;
    border-radius: 15px;
    border: 4px solid #e8560d;
    background-color: #e8560d;
    color: white;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bold;
    font-size: 1rem;
    box-shadow: 2px -1px 12px -3px #00000073;
}
</style>

<body>
    <form class="centered-div" style="margin-bottom:auto !important" action="/user/login.jsp">
        <p class="loginText"> PIN:</p>
        <input type="text" class="nameInput" name="pin" required>
        <input class="btn" type="submit" value="Submit">
    </form>
</body>
</html>