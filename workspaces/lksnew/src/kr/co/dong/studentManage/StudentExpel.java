package kr.co.dong.studentManage;

import java.util.ArrayList;

public class StudentExpel {
	ArrayList<Student> studentExpel;
	
	public StudentExpel() {
		studentExpel = new ArrayList<Student>();
	}
	
	public void addStudentExpel(String studentName, int studentNum, int studentAge, String studentMajor) {
		studentExpel.add(new Student(studentName, studentNum,studentAge, studentMajor));
		System.out.println(studentName + "학생이 등록됨");
	}
}
