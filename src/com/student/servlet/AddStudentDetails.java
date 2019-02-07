package com.student.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.service.StudentService;

/**
 * Servlet implementation class AddStudentDetails
 */
@WebServlet("/AddStudentDetails")
public class AddStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/AddStudentDetails.jsp");
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
		studentService.addStudent(rollNo,name,age,className);
			response.sendRedirect("/studentdetails/ServletDetails");

}
}