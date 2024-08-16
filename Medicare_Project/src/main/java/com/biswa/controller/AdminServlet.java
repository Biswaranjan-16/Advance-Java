package com.biswa.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.biswa.dao.AdminDao;
import com.biswa.dao.SlideshowDao;
import com.biswa.entity.Admin;
import com.biswa.entity.Slideshow;
import com.biswa.util.DbConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/Admin")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class AdminServlet extends HttpServlet {
	
	private boolean validateImage1(String imageName1) {
		String fileExt1 = imageName1.substring(imageName1.length() - 3);
		if ("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1)) {
			return true;
		}
		return false;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String event = request.getParameter("event");  //hidden field event

		if (event.equals("addadmin")) { // add page hidden field value  
			String Admin_name = request.getParameter("aname"); // sname input field name
			String Admin_email = request.getParameter("aemail");
			String Admin_password = request.getParameter("apassword");
			String Admin_confirm_password = request.getParameter("aconfirmpassword");
			String Admin_phone = request.getParameter("aphone");
			
			
			/* image coding start */
			Part p1 = request.getPart("aimg"); // simg img input field name 
			String Path = DbConnection.Path();
			String appPath = Path + "/slide";   // slide image store path
			String imagePath = appPath + "";
			File fileDir = new File(imagePath);
			if (!fileDir.exists())
				fileDir.mkdirs();
			// Get Image Name
			String imageName1 = p1.getSubmittedFileName();
			String fileExt1 = imageName1.substring(imageName1.length() - 3);
			String imgname1 = new Date().getTime() + "1" + "." + fileExt1;
			String finalImgPath1 = "adminImg" + "/" + imgname1;
			if (validateImage1(imageName1)) {
				try {
					p1.write(imagePath + "/" + imgname1);
				} catch (Exception ex) {
				}
			} else {
				out.print("<script> alert('Invalid Image Format')</script>");
			}
			/* image coding end */
			Admin aa=new Admin();
			aa.setAdmin_name(Admin_name);
			aa.setAdmin_email(Admin_email);
			aa.setAdmin_password(Admin_password);
			aa.setAdmin_con_password(Admin_password);
			aa.setAdmin_phone(Admin_phone);
			
			aa.setAdmin_image(imgname1);
			
			AdminDao ad=new AdminDao();
			int status=ad.saveAdmin(aa);
			
			
			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		} else if (event.equals("viewadmin")) {
			
			AdminDao ad = new AdminDao();
			List<Admin> admList = ad.viewAdmin();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(admList);
			out.print(JSONObject);

		}else if (event.equals("deleteadmin")) {
			int admin_id = Integer.parseInt(request.getParameter("Admin_id"));
			AdminDao ad = new AdminDao();
			int status = ad.deleteAdmin(admin_id);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		}else if (event.equals("getAdminId")) {

			int admin_id = Integer.parseInt(request.getParameter("admin_id"));
			AdminDao ad = new AdminDao();
			List<Admin> a = ad.getAdminById(admin_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(a);
			out.print(JSONObject);

		
		
		}else if (event.equals("updateadmin")) {
			Admin aa=new Admin();
			int Admin_id = Integer.parseInt(request.getParameter("aid"));
			
			String Admin_name = request.getParameter("aname"); // sname input field name
			String Admin_email = request.getParameter("aemail");
			String Admin_password = request.getParameter("apassword");
			String Admin_confirm_password = request.getParameter("aconfirmpassword");
			String Admin_phone = request.getParameter("aphone");
			String Admin_image = request.getParameter("aimg");
			
			String old_image = request.getParameter("old_image");
            String admin_phone = request.getParameter("aphone");
            /* image coding start */
      Part p1 = request.getPart("flu_admin_image"); // simg img input field name 
      if(p1.getSize() > 0) {
        //process the image and update into database
        String Path = DbConnection.Path();
        String appPath = Path + "/slide";   // slide image store path
        String imagePath = appPath + "";
        File fileDir = new File(imagePath);
        if (!fileDir.exists())
          fileDir.mkdirs();
        // Get Image Name
        String imageName1 = p1.getSubmittedFileName();
        String fileExt1 = imageName1.substring(imageName1.length() - 3);
        String imgname1 = new Date().getTime() + "1" + "." + fileExt1;
        String finalImgPath1 = "adminImg" + "/" + imgname1;
        if (validateImage1(imageName1)) {
          try {
            p1.write(imagePath + "/" + imgname1);
          } catch (Exception ex) {
          }
        } else {
          out.print("<script> alert('Invalid Image Format')</script>");
        }
        /* image coding end */
        aa.setAdmin_image(imgname1);
        
      }else {
        //keep the old image
        aa.setAdmin_image(old_image);
      }
			
			
			aa.setAdmin_id(Admin_id);
			aa.setAdmin_name(Admin_name);
			aa.setAdmin_email(Admin_email);
			aa.setAdmin_password(Admin_password);
			aa.setAdmin_con_password(Admin_password);
			aa.setAdmin_phone(Admin_phone);
			
		
			
			AdminDao ad = new AdminDao();
			int status =ad.updateAdmin(aa);
			

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}
	}

}}
