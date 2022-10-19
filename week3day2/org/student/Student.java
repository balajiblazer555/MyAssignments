package org.student;

import org.department.Department;

public class Student extends Department  {
	
	public void studentName() {
		System.out.println("Name: Balaji");
	}
	
	public void studentDept() {
		System.out.println("Department: Mechanical");
	}
	
	public void studentId() {
		System.out.println("ID: BE17MECH");
	}
	
	public static void main(String[] args) {
		
		Student call=new Student();
		call.collegeName();
		call.collegeCode();
		call.collegeRank();
		call.deptName();
		call.studentName();
		call.studentDept();
		call.studentId();
		
	}
}
