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

import com.biswa.dao.CustomerDao;
import com.biswa.dao.ManufactureDao;
import com.biswa.dao.SlideshowDao;
import com.biswa.entity.Customer;
import com.biswa.entity.Manufacture;
import com.biswa.entity.Slideshow;
import com.biswa.util.DbConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/Slideshow")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)  //img size
public class SlideshowServlet extends HttpServlet {

	private boolean validateImage1(String imageName1) {
		String fileExt1 = imageName1.substring(imageName1.length() - 3);
		if ("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1)) {
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String event = request.getParameter("event");  //hidden field event

		if (event.equals("addSlide")) { // add page hidden field value  
			String Slide_name = request.getParameter("sname");   // sname input field name
			/* image coding start */
			Part p1 = request.getPart("simg"); // simg img input field name 
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
			Slideshow ss = new Slideshow();
			ss.setSlide_name(Slide_name);
			ss.setSlide_image(imgname1);
			SlideshowDao sd = new SlideshowDao();
			int status = sd.saveSlideshow(ss);
			
			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		} else if (event.equals("viewSlideshow")) {
			SlideshowDao md = new SlideshowDao();
			List<Slideshow> sliList = md.viewSlideshow();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(sliList);
			out.print(JSONObject);

		} else if (event.equals("deleteSlideshow")) {
			int Slide_id = Integer.parseInt(request.getParameter("Slide_id"));
			SlideshowDao md = new SlideshowDao();
			int status = md.deleteSlide(Slide_id);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		} else if (event.equals("getSlideId")) {

			int Slide_id = Integer.parseInt(request.getParameter("slide_id"));
			SlideshowDao md = new SlideshowDao();
			List<Slideshow> s = md.getSlideById(Slide_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(s);
			out.print(JSONObject);

		} else if (event.equals("updateslide")) {

			int Slide_id = Integer.parseInt(request.getParameter("sid"));

			String Slide_name = request.getParameter("sname");

			Slideshow ss = new Slideshow();
			ss.setSlide_id(Slide_id);
			ss.setSlide_name(Slide_name);

			SlideshowDao sd = new SlideshowDao();
			int status = sd.updateslide(ss);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		}

	}
}