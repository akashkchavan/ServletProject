package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankServlet extends HttpServlet{
	
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
	
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println("<h1>In Form Page</h1>");
		
		String username = req.getParameter("username");
		String age= req.getParameter("age");
		String Address= req.getParameter("Address");
		String Adhar= req.getParameter("Adhar");
		String mobile= req.getParameter("mobile");
		String document = req.getParameter("Document");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankservlet","root","root123");
			PreparedStatement st = con.prepareStatement("insert into bank (name, age, adress, adhar , mobile)values (?,?,?,?,?)");
			st.setString(1, username);
			st.setString(2, age);
			st.setString(3, Address);
			st.setString(4, Adhar);
			st.setString(5, mobile);
//			st.setString(6, document);
			int executeUpdate = st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Record Inserted:");
		if(document.equals("checked")) {
			
			writer.println("Registered");
			
		}else {
			
			writer.println(" Not Registered");
    }
   }

	
}
   

