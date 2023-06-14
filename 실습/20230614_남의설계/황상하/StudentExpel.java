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
		System.out.println(student.getName() + "님의 학생정보가 제거되었습니다");
	}

	public void expelView(int i) {
		System.out.println(
				"[이름 : " + expelStudents.get(i).getName() + " / 나이 : " + expelStudents.get(i).getAge() + " / 학번 : "
						+ expelStudents.get(i).getStudentNum() + " / 전공 : " + expelStudents.get(i).getMajor() + "]");
	}

}
