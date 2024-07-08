package com.biswa.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.biswa.entity.Employee;
import com.biswa.util.DbConnection;

public class EmployeeDao {

	public int saveEmployee(Employee e) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into employee (empname;empemail,emppass,empadd,empphone)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getEemail());
			ps.setString(3, e.getEpass());
			ps.setString(4, e.getEadd());
			ps.setString(5, e.getEphone());
			status=ps.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}
}
