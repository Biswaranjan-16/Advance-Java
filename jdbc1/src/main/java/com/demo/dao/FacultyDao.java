package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Faculty;
import com.demo.util.DbConnection;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.Statement;

public class FacultyDao {
	public int saveFaculty(Faculty f) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into faculty (fname,femail,fpass,fadd)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,f.getFname());
			ps.setString(2,f.getFemail());
			ps.setString(3,f.getFpass());
			ps.setString(4,f.getFadd());
			status=ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List <Faculty> viewFaculty(){
		ArrayList<Faculty> FacultyList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="Select fid,fname,femail,fpass,fadd from faculty";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Faculty obj=new Faculty();
				obj.setFid(rs.getInt(1));
				obj.setFname(rs.getString(2));
				obj.setFemail(rs.getString(3));
				obj.setFpass(rs.getString(4));
				obj.setFadd(rs.getString(5));
				FacultyList.add(obj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FacultyList;
	}
	public Faculty viewFacultyById(int fid) {
		Faculty obj=new Faculty();
		try {
			Connection con=DbConnection.getcon();
			String query="Select fid,fname,femail,fpass,fadd from faculty where fid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, fid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				obj.setFid(rs.getInt(1));
				obj.setFname(rs.getString(2));
				obj.setFemail(rs.getString(3));
				obj.setFpass(rs.getString(4));
				obj.setFadd(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public int updateFaculty(Faculty f) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="update faculty set fname=?,femail=?,fpass=?,fadd=? where fid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFemail());
			ps.setString(3, f.getFpass());
			ps.setString(4, f.getFadd());
			ps.setInt(5, f.getFid());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int deleteFaculty(int fid) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from faculty where fId="+fid;
			PreparedStatement ps=con.prepareStatement(query);
			 status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int checkFaculty(String femail,String fpass) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="select count(*) from faculty where femail=? and fpass=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, femail);
			ps.setString(2, fpass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				status=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public void test(Faculty f) {
		try {
			Connection con=DbConnection.getcon();
			con.setAutoCommit(false);
			String query1="insert into faculty (fname,femail,fpass,fadd)values(?,?,?,?)";
			String query2="select fid,fname,femail,fadd,fpass FROM FACULTY where fid=LAST_INSERT_ID()";
			PreparedStatement ps=con.prepareStatement(query1);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFemail());
			ps.setString(3, f.getFpass());
			ps.setString(4, f.getFadd());
			ps.executeUpdate();
			 ps=con.prepareStatement(query2);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("fid :"+rs.getInt(1));
				System.out.println("fname :"+rs.getString(2));
				System.out.println("femail :"+rs.getString(3));
				System.out.println("fadd :"+rs.getString(4));
				System.out.println("fpass :"+rs.getString(5));
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
