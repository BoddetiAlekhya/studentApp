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
	<h1>Student Details Table</h1>
	<div class="container">
	<table border=1 >
		<tr align="center">
			<th>RollNo</th>
			<th>Name</th>
			<th>Age</th>
			<th>ClassName</th>
			
		</tr>
		<c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.rollNo}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.age}" /></td>
                    <td><c:out value="${student.className}" /></td>
                    <td><a href="StudentDetailEdit?rollNo=${student.rollNo}" >Edit</a></td>
					<td><a href="DeleteStudentDetails?rollNo=${student.rollNo}" >Delete</a></td>
					<td><a href="StudentDetails?rollNo=${student.rollNo}" >view</a></td>
                </tr>
                
			</c:forEach>
			
	</table>
	</div>
	<h1><a href="AddStudentDetails?rollNo=${student.rollNo}" >Add new student details</a></h1>
</body>
</html>