package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Coupons;
import com.biswa.entity.Customer;
import com.biswa.util.DbConnection;

public class CouponsDao {

	
	public int saveCoupons(Coupons c) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into coupons(coupons_title,coupons_code,coupons_price,coupons_product,coupons_amount)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, c.getCoupons_title());
			ps.setString(2, c.getCoupons_code());	
			ps.setString(3, c.getCoupons_price());
			ps.setString(4, c.getCoupons_product());
			ps.setString(5, c.getCoupons_amount());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Coupons> viewCoupons(){
		ArrayList<Coupons> couList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select coupons_id,coupons_title,coupons_code,coupons_price,coupons_product,coupons_amount from coupons";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Coupons co=new Coupons();
				co.setCoupons_id(rs.getInt(1));
				co.setCoupons_title(rs.getString(2));
				co.setCoupons_code(rs.getString(3));
				co.setCoupons_price(rs.getString(4));
				co.setCoupons_product(rs.getString(5));
				co.setCoupons_amount(rs.getString(6));
			
				couList.add(co);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return couList;
}
	
	public int deleteCoupons(int coupons_id) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from coupons where coupons_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, coupons_id);
			status=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}

	public List<Coupons> getCouponsById(int coupons_id) { 
		ArrayList<Coupons> copList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select coupons_id,coupons_title,coupons_code,coupons_price,coupons_product,coupons_amount from coupons where coupons_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, coupons_id); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Coupons co=new Coupons();
				co.setCoupons_id(rs.getInt(1));
				co.setCoupons_title(rs.getString(2));
				co.setCoupons_code(rs.getString(3));
				co.setCoupons_price(rs.getString(4));
				co.setCoupons_product(rs.getString(5));
				co.setCoupons_amount(rs.getString(6));
				
				copList.add(co);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return copList;

	}

	public int updateCoupons(Coupons c) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();				
			String query="update coupons set coupons_title=?,coupons_code=?,coupons_price=?,coupons_product=?,coupons_amount=? where coupons_id=?";
			PreparedStatement ps=con.prepareStatement(query);

			
			ps.setString(1, c.getCoupons_title());
			ps.setString(2, c.getCoupons_code());	
			ps.setString(3, c.getCoupons_price());
			ps.setString(4, c.getCoupons_product());
			ps.setString(5, c.getCoupons_amount());
			ps.setInt(6, c.getCoupons_id());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}









}
