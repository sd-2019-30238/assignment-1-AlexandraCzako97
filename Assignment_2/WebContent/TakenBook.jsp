<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<style>
body {font-family: Arial;
      background-image: url("login.jpeg");
      }


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
.button {
  background-color: #CD5C5C; 
  border-radius: 4px;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
.button1{
  background-color: #CD5C5C; 
  border-radius: 4px;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.button:hover {
  background-color: #B22222;

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
}
</style>
</head>
<body>
<h1>Sorry! This book is not available!</h1>
<a class="button" href="BookList.jsp" >Search for other books</a>


</body>
</html>