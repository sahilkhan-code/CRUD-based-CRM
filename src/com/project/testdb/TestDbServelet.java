package com.project.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServelet
 */
@WebServlet("/TestDbServelet")
public class TestDbServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServelet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		String user  = "springdemo";
		String pass = "springdemo";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_directory?useSSL=FALSE&serverTimezone=UTC";
 	 	String driver = "com.mysql.jdbc.Driver";
 	 	
		//get connection to database
 	 	
 	 	try {
 	 		PrintWriter out = response.getWriter();
 	 		out.println("Connection to database : " + jdbcUrl);
 	 		
 	 		Class.forName(driver);
 	 		Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
 	 		out.println("successful");
 	 		
 	 		myConn.close();
 	 	}
 	 	catch(Exception e) {
 	 		e.printStackTrace();
  	 	}
	}
	

}


















