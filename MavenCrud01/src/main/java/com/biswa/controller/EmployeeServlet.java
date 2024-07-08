package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.biswa.Dao.EmployeeDao;
import com.biswa.entity.Employee;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String ename=request.getParameter("ename");
		String ephone=request.getParameter("ephone");
		String eemail=request.getParameter("eemail");
		String epass=request.getParameter("epass");
		String eadd=request.getParameter("eadd");

		Employee e=new Employee();
		e.setEadd(eadd);
		e.setEemail(eemail);
		e.setEphone(ephone);
		e.setEname(ename);
		e.setEpass(epass);

		EmployeeDao ed=new EmployeeDao();
		int status=ed.saveEmployee(e);

		if(status>0) {
			out.print("Employeey inserted successfully");
		}else {
			out.print("Employee inserted failed");
		}
	}
}


