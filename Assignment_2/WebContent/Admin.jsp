<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
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
  width:40%;
  background-color: #CD5C5C;
  color: white;
  padding: 12px 190px;
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
<h1>Hello, Admin!</h1>
<br><br>

<form action="Admin" method="post">

    <b>Title:</b>  &nbsp&nbsp&nbsp&nbsp <input type="text" name="title"/><br>
    <b>Author:</b>   &nbsp<input type="text" name="author" /><br>
    <b>Genre:</b>  &nbsp  <input type="text" name="genre" /><br>
    <b>Date:</b>  &nbsp&nbsp&nbsp  <input type="text" name="release_date" /><br> 
    <b>Price:</b>   &nbsp&nbsp  <input type="text" name="price"/><br>
    <b>Status:</b>   &nbsp<input type="text" name="status" /><br>
    <b>Rating:</b>    <input type="text" name="rating" /><br>

    <input type="submit" value="Insert"/><br><br>
</form>        


</body>
</html>