package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Admin;
import com.biswa.entity.Slideshow;
import com.biswa.util.DbConnection;

public class AdminDao {

	
	public int saveAdmin(Admin a) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into admin (admin_name,admin_email,admin_password,admin_con_password,admin_phone,admin_image)values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, a.getAdmin_name());
			ps.setString(2, a.getAdmin_email());
			ps.setString(3, a.getAdmin_password());
			ps.setString(4, a.getAdmin_con_password());
			ps.setString(5, a.getAdmin_phone());
			ps.setString(6, a.getAdmin_image());
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Admin> viewAdmin(){
		ArrayList<Admin> AdminList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select admin_id,admin_name,admin_email,admin_password,admin_con_password,admin_phone,admin_image from admin";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Admin aa=new Admin();
				aa.setAdmin_id(rs.getInt(1));
				aa.setAdmin_name(rs.getString(2));
				aa.setAdmin_email(rs.getString(3));
				aa.setAdmin_password(rs.getString(4));
				aa.setAdmin_con_password(rs.getString(5));
				aa.setAdmin_phone(rs.getString(6));
				aa.setAdmin_image(rs.getString(7));
				
				AdminList.add(aa);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AdminList;
	}
	public int deleteAdmin(int admin_id) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from admin where admin_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, admin_id);
			status=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}
	
	public List<Admin> getAdminById(int admin_id) {  
		ArrayList<Admin> AdmList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select admin_id,admin_name,admin_email,admin_password,admin_con_password,admin_phone,admin_image from admin where admin_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, admin_id); 
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Admin aa=new Admin();
				aa.setAdmin_id(rs.getInt(1));
				aa.setAdmin_name(rs.getString(2));
				aa.setAdmin_email(rs.getString(3));
				aa.setAdmin_password(rs.getString(4));
				aa.setAdmin_con_password(rs.getString(5));
				aa.setAdmin_phone(rs.getString(6));
				aa.setAdmin_image(rs.getString(7));
				
				AdmList.add(aa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AdmList;
	}
	
public int updateAdmin(Admin a ) {
		
		int status=0;
		try {
			Connection con=DbConnection.getcon();				
			String query="update admin set admin_name=?,admin_email=?,admin_password=?,admin_con_password=?,admin_phone=?,admin_image=? where admin_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, a.getAdmin_name());
			ps.setString(2, a.getAdmin_email());
			ps.setString(3, a.getAdmin_password());
			ps.setString(4, a.getAdmin_con_password());
			ps.setString(5, a.getAdmin_phone());
			ps.setString(6, a.getAdmin_image());
			ps.setInt(7, a.getAdmin_id());
			
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}
}
