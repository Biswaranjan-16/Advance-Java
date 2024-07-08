package com.demo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Student;
import com.demo.util.DbConnection;

public class StudentDao {

	//insert 
	public int savestudent(Student s) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="insert into student (sname,semail,snumber,sadd)values(?,?,?,?) ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getSname());
			ps.setString(2, s.getSemail());
			ps.setString(3, s.getSnumber());
			ps.setString(4, s.getSadd());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	//view
	public List<Student> viewStudent(){
		ArrayList<Student> StudentList=new ArrayList<>();
		try {
			Connection con=DbConnection.getcon();
			String query="Select sid,sname,snumber,semail,sadd from Student";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student obj=new Student();
				obj.setSid(rs.getInt(1));
				obj.setSname(rs.getString(2));
				obj.setSnumber(rs.getString(3));
				obj.setSemail(rs.getString(4));
				obj.setSadd(rs.getString(5));
				StudentList.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StudentList;
	}

	//view by id
	public Student viewStudentById(int sid) {
		Student obj=new Student();
		try {
			Connection con=DbConnection.getcon();
			String query="select sid,sname,snumber,semail,sadd from student  where sid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, sid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				obj.setSid(rs.getInt(1));
				obj.setSname(rs.getString(2));
				obj.setSnumber(rs.getString(3));
				obj.setSemail(rs.getString(4));
				obj.setSadd(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	//update
	public int updateStudent(Student s) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="update student set sname=?,semail=?,snumber=?,sadd=? where sid=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s.getSname());
			ps.setString(2, s.getSemail());
			ps.setString(3, s.getSnumber());
			ps.setString(4, s.getSadd());
			ps.setInt(5, s.getSid());
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	//delete
	public int deleteStudent(int i) {
		int status=0;
		try {
			Connection con=DbConnection.getcon();
			String query="delete from student where sid=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,i);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
