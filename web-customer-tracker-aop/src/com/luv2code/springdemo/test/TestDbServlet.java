package com.luv2code.springdemo.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user = "springstudent";
		String password = "springstudent";
		String driver = "com.mysql.cj.jdbc.Driver";
		PrintWriter out = response.getWriter();
		
		try {
			// On the previous projects this driver was included in the hibernate.cfg.xml
			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Successfull connection");
			
			out.println("Successfull connection to database: " + jdbcUrl);
			
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			out.close();
		} finally {
			
		}
	}

}
