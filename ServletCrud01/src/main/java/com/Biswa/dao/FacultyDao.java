package com.Biswa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Biswa.entity.Faculty;
import com.Biswa.util.DbConnection;

public class FacultyDao {
	public int saveFaculty(Faculty f) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into faculty(fname,femail,fpass,fadd)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFemail());
			ps.setString(3, f.getFpass());
			ps.setString(4, f.getFadd());
			status=ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Faculty> viewFaculty() {
		ArrayList<Faculty> listfac=new ArrayList<Faculty>();
		try {
			Connection con=DbConnection.getcon();
			String query="select fid,fname,femail,fpass,fadd from faculty";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Faculty f=new Faculty();
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFemail(rs.getString(3));
				f.setFpass(rs.getString(4));
				f.setFadd(rs.getString(5));
				listfac.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listfac;
	}


	public int deleteFaculty(int fid) {
		int status=0;
		try {
			Connection con =DbConnection.getcon();
			String query="delete from faculty where fid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, fid);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
