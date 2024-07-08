package com.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.demo.Dao.FacultyDao;


public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
		String fname=request.getParameter("fname");
		String femail=request.getParameter("femail");
		String fpass=request.getParameter("fpass");
		String fadd=request.getParameter("fadd");
		
		FacultyDao fd=new FacultyDao();
	int status=	fd.saveFaculty(fname, femail, fpass, fadd);
		if(status>0) {
			out.print("<h1 style='color:green'>record inserted successfulluy</h1>");
		}else {
		out.println("<h1 style='color:red'>record inserted failed</h1>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}		

}
