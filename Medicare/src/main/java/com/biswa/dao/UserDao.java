package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.connector.Response;

import com.biswa.entity.user;
import com.biswa.util.DbConnection;

public class UserDao {
	public int saveUser(user u) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into user(uname,uemail,uphone,upassword)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,u.getUname());
			ps.setString(2, u.getUemail());
			ps.setString(3, u.getUphone());
			ps.setString(4, u.getUpassword());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int loginuser(user u) {
		int status=0;
		
		try {
			Connection con=DbConnection.getcon();
			PreparedStatement ps=con.prepareStatement("select uemail from user login where uname=? and upassword=?");
		ps.setString(1,u.getUemail());
		ps.setString(2, u.getUpassword());
	
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	public static boolean isValidUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
