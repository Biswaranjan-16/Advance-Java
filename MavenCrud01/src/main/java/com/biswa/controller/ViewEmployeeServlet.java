package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biswa.Dao.EmployeeDao;
import com.biswa.entity.Employee;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ViewEmployee")
public class ViewEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();


		EmployeeDao ed=new EmployeeDao();
		List<Employee> employeeList=ed.viewEmployee();
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>Employee ID</th>");
		out.print("<th>Employee NAME</th>");
		out.print("<th>Employee PHONE</th>");
		out.print("<th>Employee EMAIL</th>");
		out.print("<th>Employee PASSWORD</th>");
		out.print("<th>Employee ADDRESS</th>");
		out.print("<th>EDIT</th>");
		out.print("<th>DELETE</th>");
		out.print("</tr>");
		
		int i=0;

		for(Employee e:employeeList) {
			out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td>"+e.getEadd()+"</td>");
			out.print("<td>"+e.getEname()+"</td>");
			out.print("<td>"+e.getEphone()+"</td>");
			out.print("<td>"+e.getEemail()+"</td>");
			out.print("<td>"+e.getEphone()+"</td>");
			out.print("<td>"+e.getEpass()+"</td>");
			out.print("<td>Edit</td>");
			out.print("<td><a href='employeedelete?eid="+e.getEid()+"'>Delete</a></td>");
			out.print("</tr>");
			i++;
		}
		out.print("</table >");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
