package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.biswa.Dao.FacultyDao;
import com.biswa.entity.Faculty;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String event=request.getParameter("event");
		if(event.equals("addFaculty")) {
			String fName=request.getParameter("fname");
			String fEmail=request.getParameter("femail");
			String fPass=request.getParameter("fpass");
			String fAdd=request.getParameter("fadd");

			Faculty f=new Faculty();
			f.setfAdd(fAdd);
			f.setfEmail(fEmail);
			f.setfName(fName);
			f.setfPass(fPass);

			FacultyDao fd=new FacultyDao();
			int status=fd.saveFaculty(f);
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}
	}

}
