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
<h1> Successfully logged in!</h1>
<h2> Continue the adventure:<a href="BookList.jsp">>>Search the library</a></h2>
<br><br>

<br><br>
</body>
</html>