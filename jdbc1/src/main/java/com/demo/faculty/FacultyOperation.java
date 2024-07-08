package com.demo.faculty;

import java.util.List;

import com.demo.dao.FacultyDao;
import com.demo.model.Faculty;

public class FacultyOperation {
	public static void main (String args[]) {

//		FacultyDao fd2=new FacultyDao();
//		List<Faculty> FacultyList=fd2.viewFaculty();
//		for(Faculty f:FacultyList) {
//			System.out.println(f.toString());
//		}
//		FacultyDao fd3=new FacultyDao();
//		Faculty f=fd3.viewFacultyById(3);
//		System.out.println(f.toString());
		
		
//		Faculty f2=new Faculty();
//		f2.setFname("rakesh nayak");
//		f2.setFemail("rakesh@gmail.com");
//		f2.setFpass("4343");
//		f2.setFadd("mbj");
//		f2.setFid(3);
//		
//		FacultyDao fd4=new FacultyDao();
//		int status =fd4.updateFaculty(f2);
//		
//		if(status>0) {
//			System.out.println("update successfully");
//		}else {
//				System.out.println("update failed");
//			}
//		FacultyDao fd5=new FacultyDao();
//		int status=fd5.deleteFaculty(1);
//		
//		if(status>0) {
//			System.out.println("delete successfully");
//		}else {
//				System.out.println("delete failed");
//			}
		
//		FacultyDao fd6=new FacultyDao();
//		int status =fd6.checkFaculty("ajay@gmail.com", "2222");
//		
//		if(status>0) {
//			System.out.println("login successful");
//		}else {
//			System.out.println("login failed");
//		}
		

		Faculty f=new Faculty();
		f.setFname("deba");
		f.setFemail("deba@gmail.com");
		f.setFpass("6565");
		f.setFadd("bdk");
		
		FacultyDao fd7=new FacultyDao();
		fd7.test(f);
		
		}
	}

