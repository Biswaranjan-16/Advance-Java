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

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String name=request.getParameter("fname");
			String email=request.getParameter("email");
			String phno=request.getParameter("phone");
			String password=request.getParameter("password");
			String check=request.getParameter("check");
			
			User us=new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			
			 HttpSession session=request.getSession();  
		       
			
			if(check!=null) {
				UserDAOImpl dao=new UserDAOImpl(DbConnection.getcon());
				boolean f=dao.UserRegister(us);
				
				
				
				if(f) {
					
					//System.out.println("data inserted successfully");
					 session.setAttribute("succMsg","Registration Successfully..."); 
					 response.sendRedirect("register.jsp");
				}else {
					//System.out.println("something on server");
					session.setAttribute("failedMsg","Something on server"); 
					 response.sendRedirect("register.jsp");
					
				}
			}else {
				//System.out.println("please check agree");
				session.setAttribute("failedMsg","Please Agree in Term & Condition"); 
				 response.sendRedirect("register.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
