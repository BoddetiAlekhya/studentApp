package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.model.Student;
import com.student.service.StudentService;

/**
 * Servlet implementation class ServletDetails
 */
@WebServlet("/StudentDetailEdit")
public class EditStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentService();
	
	
	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletbbbequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	int id=Integer.parseInt(request.getParameter("rollNo"));	
	Student student = null;
	try {
	student=studentService.getStudentDetails(id);
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	request.setAttribute("student", student);
	RequestDispatcher rd = request.getRequestDispatcher("/StudentDetailEdit.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int rollNo=Integer.parseInt(request.getParameter("rollNo"));
			String name = request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String className = request.getParameter("className");
			System.out.println(rollNo+" "+name+" "+age+""+className);
			studentService.updateStudent(rollNo, name, age, className);
				RequestDispatcher req = request.getRequestDispatcher("Edited.jsp");
				req.include(request, response);
			}
}
