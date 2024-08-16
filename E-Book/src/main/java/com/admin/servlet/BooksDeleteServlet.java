package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biswa.dao.BookDAOimpl;
import com.biswa.util.DbConnection;

@WebServlet("/delete")
public class BooksDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			
			BookDAOimpl dao = new BookDAOimpl(DbConnection.getcon());
			
			boolean f=dao.deleteBooks(id);
			
HttpSession session = request.getSession();
			
			if(f) {
				
				session.setAttribute("succMsg", "Book Delete Successfully");
				response.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong On Server");
				response.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
