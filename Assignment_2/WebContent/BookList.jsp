<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MainPage</title>
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

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr{background-color: #f2f2f2}

th {
  background-color: #CD5C5C;
  color: white;
}
}
</style>
</head>
<body>


		
	
	<h1>Search for your favorite books:</h1>
	<br><br>
	<table  id="booksTable" >
		<tr>
			<th >Title</th>
			<th >Author</th>
			<th >Genre</th>
			<th >Release Date</th>
			<th >Price</th>
			<th >Status</th>
			<th >Rating</th>
			<th> Add to MyLibrary</th>
			

		</tr>
		<c:forEach var="book" items="${allBooks}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.genre}</td>
				<td>${book.release_date}</td>
				<td>${book.price}</td>
				<td>${book.status}</td>
				<td>${book.rating}</td>
				<td><button type="button" class="button"><a href="${pageContext.request.contextPath }/MyLibrary.jsp" style="color: rgb(255,255,255)">Add</a></button>
</tr>
		</c:forEach>
	</table>
	<br><br><br>

<button type="button" class="button"><a href="${pageContext.request.contextPath }/MyLibrary.jsp" style="color: rgb(255,255,255)">Go to MyLibrary</a></button>


</body>
</html>