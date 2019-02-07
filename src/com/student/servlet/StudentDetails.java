package com.student.servlet;

import java.io.IOException;
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
@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService retrieveData = new StudentService();
	
	
	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletbbbequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("rollNo"));	
		Student student = null;
		try {
		student=retrieveData.getStudentDetails(id);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/StudentDetails.jsp");
			rd.forward(request, response);
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//}
	

}