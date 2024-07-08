package com.Biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.Biswa.dao.FacultyDao;
import com.Biswa.entity.Faculty;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String femail=request.getParameter("femail");
		String fpass=request.getParameter("fpass");
		String fadd=request.getParameter("fadd");
		
		Faculty f=new Faculty();
		f.setFadd(fadd);
		f.setFemail(femail);
		f.setFname(fname);
		f.setFpass(fpass);
		
		FacultyDao fd=new FacultyDao();
		int status=fd.saveFaculty(f);
		
		if(status>0) {
			out.print("faculty inserted successfully");
		}else {
			out.print("faculty inserted failed");
		}
	}

}
