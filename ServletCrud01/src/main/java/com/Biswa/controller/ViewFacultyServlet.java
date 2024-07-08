package com.Biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.Biswa.dao.FacultyDao;
import com.Biswa.entity.Faculty;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ViewFaculty")
public class ViewFacultyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();


		FacultyDao fd=new FacultyDao();
		List<Faculty> facultyList=fd.viewFaculty();
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>FACULTY ID</th>");
		out.print("<th>FACULTY NAME</th>");
		out.print("<th>FACULTY EMAIL</th>");
		out.print("<th>FACULTY PASSWORD</th>");
		out.print("<th>FACULTY ADDRESS</th>");
		out.print("<th>EDIT</th>");
		out.print("<th>DELETE</th>");
		out.print("</tr>");
		int i=0;

		for(Faculty f:facultyList) {
			out.print("<tr>");
			out.print("<td>"+i+"</td>");
			out.print("<td>"+f.getFname()+"</td>");
			out.print("<td>"+f.getFemail()+"</td>");
			out.print("<td>"+f.getFpass()+"</td>");
			out.print("<td>"+f.getFadd()+"</td>");
			out.print("<td>Edit</td>");
			out.print("<td><a href='facultydelete?fid="+f.getFid()+"'>Delete</a></td>");
			out.print("</tr>");
			i++;
		}
		out.print("</table >");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
