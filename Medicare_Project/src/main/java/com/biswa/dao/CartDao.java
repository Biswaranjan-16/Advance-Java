package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Cart;
import com.biswa.entity.Product;
import com.biswa.util.DbConnection;

public class CartDao {

	public int saveCart(Cart c) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into cart(cart_qty, untprice, total_amount, product_id, customer_id)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, c.getCart_qty());
			ps.setDouble(2, c.getUntprice());
			ps.setDouble(3, c.getTotal_amount());
			ps.setInt(4, c.getProduct_id());
			ps.setInt(5, c.getCustomer_id());
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public List<Cart> viewCart(int cid){
		ArrayList<Cart> CartList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select sum(A.untprice) as untprice,sum(A.total_amount) as total_amount, sum(A.cart_qty) as cart_qty,A.customer_id,B.product_id,B.product_img,B.product_name from cart A inner join product B on A.product_id=B.product_id and A.customer_id=? group by A.product_id";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Cart c=new Cart();
				c.setUntprice(rs.getDouble(1));
				c.setTotal_amount(rs.getDouble(2));
				c.setCart_qty(rs.getInt(3));
				c.setCustomer_id(rs.getInt(4));
				
				c.setProduct_id(rs.getInt(5));
				c.setProduct_image(rs.getString(6));
				c.setProduct_name(rs.getString(7));
				
				CartList.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CartList;
	}
	public int deleteCart(String product_id,int customer_id) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from cart where customer_id=? and product_id in ('"+product_id+"')";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, customer_id);
			status=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}
}
