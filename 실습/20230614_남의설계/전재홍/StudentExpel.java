package member;

import java.util.ArrayList;
import java.util.List;

public class StudentExpel {

	List<Student> expelStudents;

	public StudentExpel() {
		expelStudents = new ArrayList<Student>();
	}

	public void addExpelStudents(Student student) {
		expelStudents.add(new Student(student.getsName(), student.getsAge(), student.getsNum(), student.getsMajor()));
		System.out.println(student.getsName() + "���� �л������� ���ŵǾ����ϴ�");
	}
	
}
