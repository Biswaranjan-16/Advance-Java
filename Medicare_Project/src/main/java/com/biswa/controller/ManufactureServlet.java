package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biswa.dao.Categorydao;
import com.biswa.dao.ManufactureDao;
import com.biswa.entity.Category;
import com.biswa.entity.Manufacture;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/manufacture")
public class ManufactureServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String event=request.getParameter("event");

		if(event.equals("addmanufacture")) {
			String manufacture_name=request.getParameter("mname");
			ManufactureDao md=new ManufactureDao();
			int status=md.saveManufacture(manufacture_name);

			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

		} else if (event.equals("viewManufacture")) {
			ManufactureDao md = new ManufactureDao();
			List<Manufacture> manList = md.viewmanufacture();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(manList);
			out.print(JSONObject);

		}else if(event.equals("deleteManufacture")) {
     		int mid=Integer.parseInt(request.getParameter("mid"));
			ManufactureDao md=new ManufactureDao();
			int status=md.deleteManufacture(mid);

			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
				
			}
		}else if(event.equals("getManufactureById")) {
			int mid=Integer.parseInt(request.getParameter("mid"));
			ManufactureDao md=new ManufactureDao();
			List<Manufacture> m=md.getManufactureById(mid);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(m);				
			out.print(JSONObject);

	}else if(event.equals("updatemanufacture")) {
		int mid=Integer.parseInt(request.getParameter("manufactureid"));
		String mname=request.getParameter("mname");
		

		Manufacture m=new Manufacture();
		m.setMid(mid);
		m.setMname(mname);
	
		ManufactureDao md=new ManufactureDao();
		int status=md.updateManufacture(m);
		
		if(status>0) {
			out.print("done");
		}else {
			out.print("failed");
		}
	}
}
	}
