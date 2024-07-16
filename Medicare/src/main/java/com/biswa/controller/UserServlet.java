package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biswa.dao.UserDao;
import com.biswa.entity.user;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Uname=request.getParameter("uname");
		String Uemail=request.getParameter("uemail");
		String Uphone=request.getParameter("uphone");
		String Upassword=request.getParameter("upassword");
		
		user u = new user();
		u.setUname(Uname);
		u.setUemail(Uemail);
		u.setUphone(Uphone);
		u.setUpassword(Upassword);
		
		UserDao ud=new UserDao();
		int status=ud.saveUser(u);

		response.sendRedirect("index.jsp");  
	}

	
		
	}


