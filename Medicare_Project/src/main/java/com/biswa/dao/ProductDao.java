package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Admin;
import com.biswa.entity.Product;
import com.biswa.util.DbConnection;

public class ProductDao {
	public int saveProduct(Product p) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="INSERT INTO product(date, product_name, custom_url, product_img, product_price, product_discount, cid, mid, keyword, availability, expire_date, stock)VALUES(now(),?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);

			ps.setString(1, p.getProduct_name());
			ps.setString(2, p.getCustom_url());
			ps.setString(3, p.getProduct_img());
			ps.setString(4, p.getProduct_price());
			ps.setString(5, p.getProduct_discount());
			ps.setInt(6, p.getCid());
			ps.setInt(7, p.getMid());
			ps.setString(8, p.getKeyword());
			ps.setString(9, p.getAvailability());
			ps.setString(10, p.getExpire_date());
			ps.setString(11, p.getStock());

			status=ps.executeUpdate();
			con.close();  
		}  catch (SQLException e) {		
			e.printStackTrace();
		}	
		return status;
	} 

	public List<Product> viewProduct(){
		ArrayList<Product> ProList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select p.product_id, p.date, p.product_name, p.custom_url, p.product_img, p.product_price, p.product_discount, p.keyword, p.availability, p.expire_date, p.stock,c.cid,c.cname,m.mid,m.mname from medicare.product p inner join medicare.category c on p.cid=c.cid inner join medicare.manufacture m on p.mid=m.mid";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Product p=new Product();
				p.setProduct_id(rs.getInt(1));
				p.setDate(rs.getString(2));
				p.setProduct_name(rs.getString(3));
				p.setCustom_url(rs.getString(4));
				p.setProduct_img(rs.getString(5));
				p.setProduct_price(rs.getString(6));
				p.setProduct_discount(rs.getString(7));
				p.setKeyword(rs.getString(8));
				p.setAvailability(rs.getString(9));				
				p.setExpire_date(rs.getString(10));
				p.setStock(rs.getString(11));
				p.setCid(rs.getInt(12));;
				p.setCname(rs.getString(13));
				p.setMid(rs.getInt(14));
				p.setMname(rs.getString(15));



				ProList.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProList;
	}
	public int deleteProduct(int product_id) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from product where product_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, product_id);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<Product> getProductById(int product_id) {  
		ArrayList<Product> ProList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select product_id,date, product_name, custom_url, product_img, product_price, product_discount,  keyword, availability, expire_date, stock,cid, mid from product where product_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, product_id); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Product p=new Product();
				p.setProduct_id(rs.getInt(1));
				p.setDate(rs.getString(2));
				p.setProduct_name(rs.getString(3));
				p.setCustom_url(rs.getString(4));
				p.setProduct_img(rs.getString(5));
				p.setProduct_price(rs.getString(6));
				p.setProduct_discount(rs.getString(7));
				p.setKeyword(rs.getString(8));
				p.setAvailability(rs.getString(9));
				p.setExpire_date(rs.getString(10));
				p.setStock(rs.getString(11));
				p.setCid(rs.getInt(12));
				p.setMid(rs.getInt(13));

				ProList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ProList;

	}
	public int updateProduct(Product p ) {

		int status=0;
		try {
			Connection con=DbConnection.getcon();				
			String query="update product set  date=?, product_name=?, custom_url=?, product_img=?, product_price=?, product_discount=?, keyword=?, availability=?, expire_date=?, stock=?, cid=?, mid=? where product_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getDate());
			ps.setString(2, p.getProduct_name());
			ps.setString(3, p.getCustom_url());
			ps.setString(4, p.getProduct_img());
			ps.setString(5, p.getProduct_price());
			ps.setString(6, p.getProduct_discount());
			ps.setString(7, p.getKeyword());
			ps.setString(8, p.getAvailability());
			ps.setString(9, p.getExpire_date());
			ps.setString(10, p.getStock());
			ps.setInt(11, p.getCid());
			ps.setInt(12, p.getMid());
			ps.setInt(13, p.getProduct_id());
			status=ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}

}
