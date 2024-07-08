package com.demo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.demo.util.DbConnection;

public class FacultyDao {
//save operation
	
	public int saveFaculty(String fname,String femail,String fpass,String fadd) {
		 int status=0;
		 try {
			Connection con=DbConnection.getcon();
			String query ="insert into faculty (fname,femail,fpass,fadd)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, femail);
			ps.setString(3, fpass);
			ps.setString(4, fadd);
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return status;
	}
}
