package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.biswa.dao.BookDAOimpl;
import com.biswa.entity.BookDtls;
import com.biswa.util.DbConnection;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String bookname = request.getParameter("bookName");
			String author = request.getParameter("authorName");
			String price = request.getParameter("bookPrice");
			String category = request.getParameter("bCategory");
			String status = request.getParameter("bStatus");
			Part part = request.getPart("bImage");
			String fileName = part.getSubmittedFileName();

			BookDtls b = new BookDtls(bookname, author, price, category, status, fileName, "admin");

			BookDAOimpl dao = new BookDAOimpl(DbConnection.getcon());

			boolean f = dao.addbooks(b);

			HttpSession session = request.getSession();

			if (f) {

				String path = getServletContext().getRealPath("" + "book");
				File file = new File(path);
				part.write(path + File.separator + fileName);

				session.setAttribute("succMsg", "Book Add Successfully");
				response.sendRedirect("admin/add_books.jsp");
			} else {
				session.setAttribute("failedMsg", "Something Wrong ON Server");
				response.sendRedirect("admin/add_books.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
