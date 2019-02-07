<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details Table</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<h1>Student Details Comes Here</h1>
	<table>
		<tr>
			<td>RollNO:</td>
			<td>${student.rollNo}</td>
			
		</tr>
		<tr>
			<td>Name:</td>
			<td>${student.name}</td>
			
		</tr>
		<tr>
			<td>Age:</td>
			<td>${student.age}</td>
			
		</tr>
		<tr>
			<td>Class:</td>
			<td>${student.className}</td>
			
		</tr>
		
	
	</table>
	
</body>
</html>