package com.biswa.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.biswa.entity.Employee;
import com.biswa.util.DbConnection;

public class EmployeeDao {
	public int saveEmployee(Employee e) {
		int status=0; 
		try {
			Connection con=DbConnection.getcon();
			String query="insert into employee(empName,empEmail,empAdd,empPass,empPhone)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getEemail());
			ps.setString(3, e.getEadd());
			ps.setString(4, e.getEpass());
			ps.setString(5, e.getEphone());
			status=ps.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}	
	public List<Employee> viewEmployee() {
		ArrayList<Employee> listemp=new ArrayList<Employee>();
		try {
			Connection con=DbConnection.getcon();
			String query="select empId,empName,empEmail,empAdd,empPass,empPhone from employee";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEemail(rs.getString(3));
				e.setEadd(rs.getString(4));
				e.setEpass(rs.getString(5));
				e.setEphone(rs.getString(6));

				listemp.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listemp;
	}
	public int deleteEmployee(int eid) {
		int status=0;
		try {
			Connection con =DbConnection.getcon();
			String query="delete from employee where empId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, eid);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}