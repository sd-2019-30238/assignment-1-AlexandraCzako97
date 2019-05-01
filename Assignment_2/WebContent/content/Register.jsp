<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterPage</title>
<style>
body {font-family: Arial;
      background-image: url("login.jpeg");
      margin-left: 40%;
      margin-top: 10%}


input[type=text], select, textarea {
  width: 35%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #CD5C5C;
  color: white;
  padding: 12px 165px;
  border: none;
  border-radius: 4px;
  cursor: pointer;

}

input[type=submit]:hover {
  background-color: #B22222;

}

</style>
</head>
<body>
<h1> Register here:</h1>
<br><br>

<form action="Register" method="post">

    <b>Username:</b>   &nbsp <input type="text" name="username"/><br>
    <b>Password1:</b>   <input type="text" name="password" /><br>
    <b>Password2:</b>    <input type="text" name="password" /><br>
    <b>Payment plan:</b>    <input type="radio" name="plan" value="monthly"/>Monthly
                            <input type="radio" name="plan" value="yearly"/>Yearly<br><br>
    <input type="submit" value="Register"/>

</form>

</body>
</html>