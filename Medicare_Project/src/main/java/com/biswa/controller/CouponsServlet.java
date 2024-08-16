package com.biswa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biswa.dao.CouponsDao;
import com.biswa.dao.CustomerDao;
import com.biswa.entity.Coupons;
import com.biswa.entity.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

 @WebServlet("/Coupons")
public class CouponsServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String event = request.getParameter("event");
		
		
		if (event.equals("addCoupons")) {    

			String Coupons_title = request.getParameter("Couponstitle");
			String Coupons_code = request.getParameter("Couponscode");
			String Coupons_price = request.getParameter("Couponsprice"); 
			String Coupons_product = request.getParameter("Couponsproduct");
			String Coupons_amount= request.getParameter("Couponsamount"); 

			Coupons co = new Coupons();
			co.setCoupons_title(Coupons_title);
			co.setCoupons_code(Coupons_code);
			co.setCoupons_price(Coupons_price);
			co.setCoupons_product(Coupons_product);
			co.setCoupons_amount(Coupons_amount);
			

			CouponsDao cd = new CouponsDao();
			int status = cd.saveCoupons(co);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}
			
			
		} else if (event.equals("viewCoupons")) { 
			CouponsDao cd = new CouponsDao();
			List<Coupons> couList = cd.viewCoupons();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(couList);
			out.print(JSONObject);

		} else if (event.equals("deleteCoupons")) {    
			int coupons_id = Integer.parseInt(request.getParameter("coupons_id"));   
			CouponsDao cd = new CouponsDao();
			int status = cd.deleteCoupons(coupons_id);    

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		}else if (event.equals("getCouponsById")) {    
			int Coupons_id = Integer.parseInt(request.getParameter("coupons_id")); 
			CouponsDao cd = new CouponsDao();
			List<Coupons> co = cd.getCouponsById(Coupons_id);   
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(co);
			out.print(JSONObject);

		}else if(event.equals("updatecoupons")) {
			
			int Coupons_id = Integer.parseInt(request.getParameter("coid")); //jsp hiddenfield name
			String Coupons_title = request.getParameter("cotitle");
			String Coupons_code = request.getParameter("cocode");
			String Coupons_price = request.getParameter("coprice"); 
			String Coupons_product = request.getParameter("coproduct");
			String Coupons_amount= request.getParameter("coamount"); 

			Coupons co = new Coupons();
			co.setCoupons_id(Coupons_id);
			co.setCoupons_title(Coupons_title);
			co.setCoupons_code(Coupons_code);
			co.setCoupons_price(Coupons_price);
			co.setCoupons_product(Coupons_product);
			co.setCoupons_amount(Coupons_amount);
		
			CouponsDao cd = new CouponsDao();
			int status=cd.updateCoupons(co);
			
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

		
		
	}
	
      	}	
	
}
