package com.student.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.student.model.Student;

public class StudentService {
	public List<Student> getStudents() throws SQLException {
		List<Student> students = new ArrayList<>();
		try {
			Connection con = getConnection();

			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from listOfStudents");

			while (rs.next()) {
				int rollNo = rs.getInt("RollNo");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String className = rs.getString("class");
				//System.out.println(rollNo+" "+ name+" "+ age+" "+ className);
				students.add(new Student(rollNo, name, age, className));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return students;
	}


	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/student", "root", "root");
		return con;
	}
	
	
	public Student getStudentDetails(int id) throws SQLException {
		Student student = null;
		try {
			Connection con = getConnection();

			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from listOfStudents where RollNo="+id);

			while (rs.next()) {
				int rollNo = rs.getInt("RollNo");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				String className = rs.getString("class");
				//System.out.println(rollNo+" "+ name+" "+ age+" "+ className);
				student=new Student(rollNo, name, age, className);
			}

			con.close();

		} catch (Exception e) {
			//System.out.println(e);
		}

		return student;
	}
	
	public void deleteStudentDetails(int id) throws SQLException {
		Student student = null;
		try {
			Connection con = getConnection();

			Statement stmt = (Statement) con.createStatement();
			stmt.execute("delete from listOfStudents where RollNo="+id);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	


public void addStudent(int rollNo,String name,int age,String className) {
	Student student = null;
	try {
		Connection con = getConnection();

		Statement stmt = (Statement) con.createStatement();
		stmt.execute("insert into listOfStudents(RollNo,Name,Age,Class) values("+rollNo+",'"+name+"',"+age+",'"+className+"')");
		
		con.close();

	}catch (Exception e) {
		System.out.println(e);
	}
}
public void updateStudent(int rollNo,String name,int age,String className) {
	Student student = null;
	try {
		Connection con = getConnection();

		Statement stmt = (Statement) con.createStatement();
		stmt.execute("update listOfStudents set RollNo="+rollNo+",Name='"+name+"',Age="+age+",Class='"+className+ "' where RollNo="+rollNo);;
		
		con.close();

	}catch (Exception e) {
		System.out.println(e);
	}
}
}