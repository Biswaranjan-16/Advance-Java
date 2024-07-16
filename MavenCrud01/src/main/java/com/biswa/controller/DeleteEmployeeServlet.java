package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.biswa.Dao.EmployeeDao;

import javax.servlet.annotation.WebServlet;
@WebServlet("/employeedelete")
public class DeleteEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int eid=Integer.parseInt(request.getParameter("eid"));
		EmployeeDao ed=new EmployeeDao();
		int status=ed.deleteEmployee(eid);
		
		if(status>0) {
			out.print("delete successfully");
		}else {
			out.print("delete failed");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
