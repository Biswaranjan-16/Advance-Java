package com.Biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.Biswa.dao.FacultyDao;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/facultydelete")
public class DeleteFacultyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int fid=Integer.parseInt(request.getParameter("fid"));
		FacultyDao fd=new FacultyDao();
		int status=fd.deleteFaculty(fid);
		
		if(status>0) {
			out.print("delete successfully");
		}else {
			out.print("delete failed");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
