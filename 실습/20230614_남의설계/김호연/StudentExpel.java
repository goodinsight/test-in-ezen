package member;

import java.util.ArrayList;
import java.util.List;

public class StudentExpel {

	List<Student> expelStudents;

	public StudentExpel() {
		expelStudents = new ArrayList<Student>();
	}

	public void addExpelStudents(Student student) {
		expelStudents.add(new Student(student.getName(), student.getAge(), student.getStudentNum(), student.getMajor()));
		System.out.println(student.getName() + "���� �л������� ���ŵǾ����ϴ�");
	}
	
	
}
