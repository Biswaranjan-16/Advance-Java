package com.biswa.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.biswa.entity.Faculty;
import com.biswa.util.DbConnection;

public class FacultyDao {
	public int saveFaculty(Faculty f) {
		int status=0;
		try {
			Connection con=DbConnection.getconnection();
			String query="insert into faculty(fName,fEmail,fPass,fAdd) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, f.getfName());
			ps.setString(2, f.getfEmail());
			ps.setString(3, f.getfPass());
			ps.setString(4, f.getfAdd());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
