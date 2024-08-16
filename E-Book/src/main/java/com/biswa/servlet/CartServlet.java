package com.biswa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biswa.dao.BookDAOimpl;
import com.biswa.dao.CartDAOImpl;
import com.biswa.entity.BookDtls;
import com.biswa.entity.Cart;
import com.biswa.util.DbConnection;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int bid=Integer.parseInt(request.getParameter("bid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			
			BookDAOimpl dao=new BookDAOimpl(DbConnection.getcon());
			BookDtls b=dao.getBookById(bid);
			
			Cart c=new Cart();
			c.setBid(bid);
			c.setUserId(uid);
			c.setBookname(b.getBookName());
			c.setAuthor(b.getAuthor());
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotalprice(Double.parseDouble(b.getPrice()));
			
			CartDAOImpl dao2 =new CartDAOImpl(DbConnection.getcon());
			boolean f=dao2.addCart(c);
			
			if(f) {
				
				System.out.println("add cart");
			}else {
				System.out.println("failed");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
