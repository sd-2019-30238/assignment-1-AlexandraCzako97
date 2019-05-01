<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
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
  padding: 12px 71px;
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
<h1> Your books everywhere!!</h1>
<br><br>
<form action="Login" method="post" >

    <b>Username:</b>    <input type="text" name="username"/><br>
    <b>Password:</b>    <input type="text" name="password" /><br>
    <input type="submit" value="Login"/>

</form>
<br><br>
<h3> You don't have an account? Register here: </h3><a href="register.html">Register</a>
</body>
</html>