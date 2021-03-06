<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MainPage</title>
<script>

addedBooks = [];

//filter by title
function myFunction() {
	var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("booksTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        
        for (x = 0; x < td.length; x++) {
            if (td[x].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
	}

function addRow(title,price)
{
	if(addedBooks.find(b => b.title == title)) return;
	addedBooks.push({title: title, price: price});
    var ptable = document.getElementById('myLibrary');

    var tr = document.createElement("tr");
    var td = document.createElement("td");
    td.innerHTML = title;
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerHTML = price;
    tr.appendChild(td);
    ptable.appendChild(tr);
    
    /*var checkoutForm = document.getElementById('checkoutForm');
    var titleInput = checkoutForm.querySelector('input[name="title"]');
    var statusInput = checkoutForm.querySelector('input[name="status"]');
    titleInput.value = title;
    statusInput.value = "TAKEN";*/
    
    
    var returnForm = document.getElementById('returnForm');
    var titleInput = returnForm.querySelector('input[name="title"]');
    var statusInput = returnForm.querySelector('input[name="status"]');
    var emailInput = returnForm.querySelector('input[name="email"]');
    titleInput.value = title;
    statusInput.value = "FREE";
    emailInput.value = "testmailps123@gmail.com";
  }


</script>
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

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for books..">

	
	<h1>All the books:</h1>
	<br><br>
	<table  id="booksTable" >
		<tr>
			<th >Title</th>
			<th >Author</th>
			<th >Genre</th>
			<th >Release Date</th>
			<th >Price(RON)</th>
			<th> Add to MyLibrary</th>
			

		</tr>
		<c:forEach var="book" items="${allBooks}">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.genre}</td>
				<td>${book.release_date}</td>
				<td>${book.price}</td>
				<td><input type="button" value="Add" onclick="addRow(`${book.title}`, '${book.price}');" class="button"></td>

</tr>
		</c:forEach>
	</table>
<br><br><br>

<br><br><br>

	<h1>My Library:</h1>

<table  id="myLibrary" >
		<tr>
			<th >Title</th>
			<th >Price</th>
		</tr>
	</table>

<br><br><br>
 <!--<form method="post" action="Checkout" id="checkoutForm">
    <input type="text" name="title" hidden>
    <input type="text" name="status" hidden>
	<input type="submit" value="Check Out"  class="button">
</form>
<br><br><br>-->
 <!--<form method="post" action="Return" id="returnForm">
    <input type="text" name="title" hidden>
    <input type="text" name="status" hidden>
	<input type="submit" value="Return book"  class="button">
</form>-->
<form method="post" action="Return" id="returnForm">
    <input type="text" name="title" hidden>
    <input type="text" name="status" hidden>
    <input type="text" name="email" hidden>
	<input type="submit" value="Return book"  class="button">

<br><br><br>


</body>
</html>