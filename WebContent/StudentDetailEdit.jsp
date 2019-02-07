<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentDetailEdit" method="post">
<table>
		<tr>
			<td>RollNO:</td>
			<td> <input type="text" name="rollNo" value="${student.rollNo}"> </td>
			
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${student.name}"></td>
			
		</tr>
		<tr>
			<td>Age:</td>
			<td><input type="text" name="age" value="${student.age}"></td>
			
		</tr>
		<tr>
			<td>Class:</td>
			<td><input type="text" name="className" value="${student.className}"></td>
			
		</tr>
		<tr>
			<td><input type="submit" value="submit"></td>
			
	
	</table>
	</form>
</body>
</html>