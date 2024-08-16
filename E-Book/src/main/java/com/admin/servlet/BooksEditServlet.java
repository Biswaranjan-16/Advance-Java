package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biswa.dao.BookDAOimpl;
import com.biswa.entity.BookDtls;
import com.biswa.util.DbConnection;

@WebServlet("/editbooks")
public class BooksEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String bookname = request.getParameter("bookName");
			String author = request.getParameter("authorName");
			String price = request.getParameter("bookPrice");
			String status = request.getParameter("bStatus");
			
			BookDtls b=new BookDtls();
			b.setBookId(id);
			b.setBookName(bookname);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			
			BookDAOimpl dao = new BookDAOimpl(DbConnection.getcon());
			boolean f=dao.updateEditBooks(b);
			
			HttpSession session = request.getSession();
			
			if(f) {
				
				session.setAttribute("succMsg", "Book Update Successfully");
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
