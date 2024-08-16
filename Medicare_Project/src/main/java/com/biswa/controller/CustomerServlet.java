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

import com.biswa.dao.CustomerDao;
import com.biswa.entity.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/Customer")
public class CustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String event = request.getParameter("event");   //hidden field name

		if (event.equals("addCustomer")) {      // add page hidden field value

			String Customer_name = request.getParameter("customerName");     //add page inputfield name
			String Customer_email = request.getParameter("customerEmail");   //add page inputfield name
			String Customer_address = request.getParameter("customerAddress");  //add page inputfield name
			String Customer_city = request.getParameter("customerCity");        //add page inputfield name
			String Customer_phone = request.getParameter("customerPhone");      //add page inputfield name
			String Customer_Password = request.getParameter("customerPass"); 
			
			Customer cu = new Customer();
			cu.setCustomer_name(Customer_name);    
			cu.setCustomer_email(Customer_email);
			cu.setCustomer_address(Customer_address);
			cu.setCustomer_city(Customer_city);
			cu.setCustomer_phone(Customer_phone);
			cu.setCustomer_password(Customer_Password);

			CustomerDao cd = new CustomerDao();
			int status = cd.saveCustomer(cu);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}
			
			
		} else if (event.equals("viewCustomer")) {    //for call view ajax event
			CustomerDao cd = new CustomerDao();
			List<Customer> catList = cd.viewcustomer();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(catList);
			out.print(JSONObject);

		} else if (event.equals("deleteCustomer")) {    //for call delete ajax event
			int Customer_id = Integer.parseInt(request.getParameter("Customer_id"));  // ajax 'Customer_id'
			CustomerDao cd = new CustomerDao();
			int status = cd.deleteCustomer(Customer_id);   //deleteCustomer from dao

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		} else if (event.equals("getCustomerById")) {    //getCustomerById for ajax event
	
			int Customer_id = Integer.parseInt(request.getParameter("customer_id")); //customer_id for ajax 
			CustomerDao cd = new CustomerDao();
			List<Customer> c = cd.getCustomerById(Customer_id);   //getCustomerById from dao method
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(c);
			out.print(JSONObject);

		}else if(event.equals("updatecustomer")) {
			int Customer_id = Integer.parseInt(request.getParameter("cuid")); //jsp hiddenfield name
			String Customer_name = request.getParameter("cuname"); // jsp input field name name
			String Customer_email = request.getParameter("cuemail"); // jsp input field mail name
			String Customer_address = request.getParameter("cuadd");// jsp input field address
			String Customer_city = request.getParameter("cucity"); // jsp input field city
			String Customer_phone = request.getParameter("cuphone"); // jsp input field phone

			Customer cu = new Customer();
			cu.setCustomer_id(Customer_id);
			cu.setCustomer_name(Customer_name);
			cu.setCustomer_email(Customer_email);
			cu.setCustomer_address(Customer_address);
			cu.setCustomer_city(Customer_city);
			cu.setCustomer_phone(Customer_phone);
		
			CustomerDao cd = new CustomerDao();
			int status=cd.updateCustomer(cu);
			
			if(status>0) {
				out.print("done");
			}else {
				out.print("failed");
			}

	}else if(event.equals("logincustomer")) {
		String Customer_email = request.getParameter("lmail");
		String Customer_Password = request.getParameter("lpass"); 
		
		CustomerDao cd = new CustomerDao();
		int x =  cd.checkpassword(Customer_Password, Customer_email);
		if (x>0) {
			
			Customer cu = cd.getDataEmailPassword(Customer_Password, Customer_email);
			 HttpSession session=request.getSession();  
		     session.setAttribute("custName",cu.getCustomer_name());  
		     session.setAttribute("cid",cu.getCustomer_id());
		     response.sendRedirect("product.jsp");
		} else {
            response.sendRedirect("userlogin.jsp");
		}
		
	}
}
}