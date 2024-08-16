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
import com.biswa.dao.ProductDao;
import com.biswa.dao.SlideshowDao;
import com.biswa.entity.Admin;
import com.biswa.entity.Product;
import com.biswa.entity.Slideshow;
import com.biswa.util.DbConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/Product")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)

public class ProductServlet extends HttpServlet {

	private boolean validateImage1(String imageName1) {
		String fileExt1 = imageName1.substring(imageName1.length() - 3);
		if ("jpg".equals(fileExt1) || "png".equals(fileExt1) || "gif".equals(fileExt1)) {
			return true;
		}
		return false;
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out=response.getWriter();

		String event=request.getParameter("event");

		if (event.equals("addproduct")) { 

			String Product_name = request.getParameter("pname");
			String Product_url  = request.getParameter("curl");		
			String Product_price = request.getParameter("pprice");
			String Product_discount = request.getParameter("pdiscount");
			int mid =Integer.parseInt(request.getParameter("Manufacture")) ;
			int cid = Integer.parseInt(request.getParameter("Catagory"));
			String Product_keyword = request.getParameter("pkeyword");
			String Product_availability = request.getParameter("pavailability");
			String Product_expire = request.getParameter("pexpire");
			String Product_stock = request.getParameter("pstock");


			/* image coding start */
			Part p1 = request.getPart("pimg");  
			String Path = DbConnection.Path();
			String appPath = Path + "/product";   
			String imagePath = appPath + "";
			File fileDir = new File(imagePath);
			if (!fileDir.exists())
				fileDir.mkdirs();
			// Get Image Name
			String imageName1 = p1.getSubmittedFileName();
			String fileExt1 = imageName1.substring(imageName1.length() - 3);
			String imgname1 = new Date().getTime() + "1" + "." + fileExt1;
			String finalImgPath1 = "product" + "/" + imgname1;
			if (validateImage1(imageName1)) {
				try {
					p1.write(imagePath + "/" + imgname1);
				} catch (Exception ex) {
				}
			} else {
				out.print("<script> alert('Invalid Image Format')</script>");
			}
			/* image coding end */

			Product p=new Product();			
			p.setProduct_name(Product_name);
			p.setCustom_url(Product_url);
			p.setProduct_price(Product_price);
			p.setProduct_discount(Product_discount);
			p.setProduct_img(imgname1);			
			p.setMid(mid);
			p.setCid(cid);
			p.setKeyword(Product_keyword);
			p.setAvailability(Product_availability);
			p.setExpire_date(Product_expire);
			p.setStock(Product_stock);

			ProductDao pd=new ProductDao();
			int status=pd.saveProduct(p);


			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}


		}else if (event.equals("viewproduct")) {
			ProductDao pd = new ProductDao();
			List<Product> proList = pd.viewProduct();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(proList);
			out.print(JSONObject);

		}else if (event.equals("deleteproduct")) {
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			ProductDao pd = new ProductDao();
			int status = pd.deleteProduct(product_id);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
			}

		}else if (event.equals("getProductId")) {
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			ProductDao pd = new ProductDao();
			List<Product> a = pd.getProductById(product_id);
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			String JSONObject = gson.toJson(a);
			out.print(JSONObject);


		}	else if (event.equals("updateproduct")) {

			int Product_id = Integer.parseInt(request.getParameter("pid"));

			String Product_name = request.getParameter("pname");
			String Product_url  = request.getParameter("curl");		
			String Product_price = request.getParameter("pprice");
			String Product_discount = request.getParameter("pdiscount");
			int mid =Integer.parseInt(request.getParameter("Manufacture")) ;
			int cid = Integer.parseInt(request.getParameter("Catagory"));
			String Product_keyword = request.getParameter("pkeyword");
			String Product_availability = request.getParameter("pavailability");
			String Product_expire = request.getParameter("pexpire");
			String Product_stock = request.getParameter("pstock");
			
			Product p=new Product();
			p.setProduct_id(Product_id);
			p.setProduct_name(Product_name);
			p.setCustom_url(Product_url);
			p.setProduct_price(Product_price);
			p.setProduct_discount(Product_discount);
			p.setMid(mid);
			p.setCid(cid);
			p.setKeyword(Product_keyword);
			p.setAvailability(Product_availability);
			p.setExpire_date(Product_expire);
			p.setStock(Product_stock);
			
			ProductDao pd = new ProductDao();
			int status = pd.updateProduct(p);

			if (status > 0) {
				out.print("done");
			} else {
				out.print("failed");
	
			}
		}	
		
	}
}