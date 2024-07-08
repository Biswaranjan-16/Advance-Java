package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.filters.ExpiresFilter.XPrintWriter;
@WebServlet("/lion")
@MultipartConfig
public class TestServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String date=request.getParameter("date");
	String color=request.getParameter("color");
	String gender=request.getParameter("gender");
	String Course1=request.getParameter("Course1");
	String Course2=request.getParameter("Course2");
	String Course3=request.getParameter("Course3");
	String month=request.getParameter("month");
	String number=request.getParameter("number");
	String range=request.getParameter("range");
	String search=request.getParameter("search");
	String url=request.getParameter("url");
	
	
	
	out.print("<h1>From data of all  the table </h1>");
	out.print("<h1>Name :"+name+"</h1>");
	out.print("<h1>Email :"+email+" </h1>");
	out.print("<h1>Password :"+password+"</h1>");
	out.print("<h1> Date :"+date+"</h1>");
	out.print("<h1>Color :"+color+"</h1>");
	out.print("<h1>Gender :"+gender+"</h1>");
	out.print("<h1>Course1 :"+Course1+"</h1>");
	out.print("<h1>Course2 :"+Course2+"</h1>");
	out.print("<h1>Course3 :"+Course3+"</h1>");
	out.print("<h1>Month :"+month+"</h1>");
	out.print("<h1>Number :"+number+"</h1>");
	out.print("<h1>Range :"+range+"</h1>");
	out.print("<h1>Search :"+search+"</h1>");
	
	}

}
