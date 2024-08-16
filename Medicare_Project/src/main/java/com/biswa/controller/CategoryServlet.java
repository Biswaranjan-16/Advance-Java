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
import com.biswa.entity.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String event=request.getParameter("event");
		
		if(event.equals("addCategory")) {   
			String category_name=request.getParameter("cname");  
			
			Categorydao cd=new Categorydao();
			int status=cd.saveCategory(category_name);
			
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

		}else if(event.equals("viewCategory")) {
			Categorydao cd=new Categorydao();
			List<Category> catList=cd.viewcategory();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(catList);				
			out.print(JSONObject);
			
		}else if(event.equals("deleteCategory")) {
			int category_id=Integer.parseInt(request.getParameter("cid"));
			Categorydao cd=new Categorydao();
			int status=cd.deleteCategory(category_id);

			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

		}else if(event.equals("getCategoryById")) {
			int cid=Integer.parseInt(request.getParameter("cid"));
			Categorydao cd=new Categorydao();
			List<Category> c=cd.getCategoryById(cid);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson  gson = gsonBuilder.create();
			String JSONObject = gson.toJson(c);				
			out.print(JSONObject);
			
		}else if(event.equals("updatecategory")) {
			int cid=Integer.parseInt(request.getParameter("categoryid"));
			String cname=request.getParameter("cname");
			

			Category c=new Category();
			c.setCid(cid);
			c.setCname(cname);
		
			Categorydao cd=new Categorydao();
			int status=cd.updateCategory(c);
			
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
		}

	}

}






