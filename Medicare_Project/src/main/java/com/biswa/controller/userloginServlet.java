package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class userloginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
    
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
  }

  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String myemail = request.getParameter("lmail");
    String mypass = request.getParameter("lpass");
    
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");  
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","biswa"); 
      
      
      PreparedStatement preparedStatement = con.prepareStatement("select * from user where uemail=? and upassword =?");
      preparedStatement.setString(1, myemail); 
      preparedStatement.setString(2, mypass);
      
      ResultSet rs = preparedStatement.executeQuery();
      
      if (rs.next()) {
        
        response.sendRedirect("Admin/index.jsp");
      } else {
        
        out.print("<h3>Email id and password didn't match</h3>");
        
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
      
      
      out.print("<h3>"+e.getMessage()+"</h3>");
      
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.include(request, response);
    }
  }

}