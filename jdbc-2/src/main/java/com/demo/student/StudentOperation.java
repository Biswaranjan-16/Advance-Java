package com.demo.student;
import java.util.List;

import com.demo.Dao.StudentDao;
import com.demo.model.Student;

public class StudentOperation {
public static void main(String args[]) {
	Student s1=new Student();
	s1.setSname("Biswajit Biswal");
	s1.setSemail("biswajit@gmail.com");
	s1.setSnumber("7865430912");
	s1.setSadd("bbsr");
	StudentDao sd=new StudentDao();
	int status=sd.savestudent(s1);
	
	if(status>0) {
		System.out.println("inserted succesfully");
	}else {
		System.out.println("inserted failed");
	}
	

//StudentDao sd1=new StudentDao();
//List<Student> studentList=sd1.viewStudent();
//for(Student s:studentList) {
//	System.out.println(s.toString());
//}
	
//	StudentDao sd2=new StudentDao();
//	Student s=sd2.viewStudentById(3);
//	System.out.println(s.toString());
	
//	Student s2=new Student();
//	s2.setSname("bijay biswal");
//	s2.setSemail("bijay@gmail.com");
//	s2.setSnumber("7653409125");
//	s2.setSadd("bls");
//	s2.setSid(3);
//	
//	StudentDao sd3=new StudentDao();
//	int status=sd3.updateStudent(s2);
//	
//	if(status>0) {
//		System.out.println("update succesfully");
//	}else {
//		System.out.println("update failed");
//	}
	
//	StudentDao sd4=new StudentDao();
//	int status=sd4.deleteStudent(5);
//	
//	 if(status>0) {
//		System.out.println("delete succesfully");
//	}else {
//		System.out.println("delete failed");
//	} 
}}

