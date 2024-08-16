package com.biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biswa.entity.Category;
import com.biswa.entity.Manufacture;
import com.biswa.util.DbConnection;

public class ManufactureDao {
	public int saveManufacture(String m) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into manufacture(mname) values(?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,m);		
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Manufacture> viewmanufacture(){
		ArrayList<Manufacture> manList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select mid,mname from manufacture";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Manufacture ms=new Manufacture();
				ms.setMid(rs.getInt(1));
				ms.setMname(rs.getString(2));
				manList.add(ms);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manList;
	}

	public int deleteManufacture(int mid) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from manufacture where mid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mid);
			status=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
		
	}
	
	public List<Manufacture> getManufactureById(int mid) {
		ArrayList<Manufacture> manList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="select mid,mname from manufacture where mid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, mid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Manufacture ms=new Manufacture();
				ms.setMid(rs.getInt(1));
				ms.setMname(rs.getString(2));
				
				manList.add(ms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manList;
	}
	
	public int updateManufacture(Manufacture m) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();				
			String query="update manufacture set mname=? where mid=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, m.getMname());
			ps.setInt(2, m.getMid());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}

}
