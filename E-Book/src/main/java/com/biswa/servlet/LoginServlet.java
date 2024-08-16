package com.biswa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biswa.dao.UserDAOImpl;
import com.biswa.entity.User;
import com.biswa.util.DbConnection;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UserDAOImpl dao=new UserDAOImpl(DbConnection.getcon());
			 HttpSession session=request.getSession();  
			 
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			//System.out.println(email+" "+password+" ");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User us=new User();	
				us.setName("Admin");
				session.setAttribute("userobj","us"); 
				 response.sendRedirect("admin/home.jsp");
				 

			}else {
				
				User us=dao.login(email, password);
				
				if(us!=null) {
					
					session.setAttribute("userobj","us"); 
					 response.sendRedirect("home.jsp");
				}else {
					
					session.setAttribute("failedMsg","Email & Password are invalid"); 
					 response.sendRedirect("login.jsp");
				}

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
