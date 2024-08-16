package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biswa.dao.CartDao;
import com.biswa.entity.Cart;
import com.biswa.entity.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/cartservlet")
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String event=request.getParameter("event");
		
		if(event.equals("addtocart")) {   
			int qty=Integer.parseInt(request.getParameter("productquantity"));  
			double unitprice=Double.parseDouble(request.getParameter("unitprice"));  
			double totalamount=qty * unitprice ;  
			int productid=Integer.parseInt(request.getParameter("pid"));
		//	int productid=Integer.parseInt(request.getParameter("pid"));  
			HttpSession session=request.getSession(false);  
	        int customerid=(int)session.getAttribute("cid");
			
	       Cart c=new Cart();
	       c.setCart_qty(qty);
	       c.setUntprice(unitprice);
	       c.setCustomer_id(customerid);
	       c.setProduct_id(productid);
	       c.setTotal_amount(totalamount);
	        

	       CartDao cd=new CartDao();
	      int status= cd.saveCart(c);
			
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

		}else if(event.equals("viewcart")) {
			HttpSession session=request.getSession(false);  
	        int customerid=(int)session.getAttribute("cid");
	        CartDao cd=new CartDao();
	        List<Cart> catList = cd.viewCart(customerid);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(catList);
			out.print(JSONObject);
			
		}else if(event.equals("deletefromcart")) {
			HttpSession session=request.getSession(false);  
	        int customerid=(int)session.getAttribute("cid");
	        String productid=request.getParameter("product_id");
	        CartDao cd=new CartDao();
	        int status =cd.deleteCart(productid, customerid);

	        if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}
	}
	}
}
