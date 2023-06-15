package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����

	// �ʱⰪ
	void init_a() {
		students.add(new Student("�踸��", "10", "230614", "��ǻ�Ͱ���"));
		students.add(new Student("������", "11", "220614", "��ǻ�ͳ�Ʈ��ũ"));
		students.add(new Student("�̸���", "13", "200614", "����Ʈ��������"));
		students.add(new Student("�ָ���", "15", "180614", "�������"));
		students.add(new Student("�ڸ���", "17", "160614", "����"));
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("�л� ���� �Ŵ���");
		System.out.println("1. �߰�, 2. ����, 3. ����, 4. ����, ��Ÿ. ����");

		return scan.next(); // �Էµ� �����͸� ����
	}

	void studentPlay(String sel) {
		// ȭ�� �޴���� 1. �߰� , 2. ����, 3. ����, 4. ����, ��Ÿ. ����
		switch (sel) {
		case "1": // �߰��޼ҵ�()
			addStudent(students);
			break;
		case "2": // �����޼ҵ�()
			updateView();
			break;
		case "3": // �����޼ҵ�()
			deleteStudent(studentExpel);
			break;
		case "4": // ����޼ҵ�()
			studentView();
			break;
		default:
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
	}

	// ���� �޼ҵ�
	void studentView() {
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		String input = "";
		System.out.println("1. ��ü����, 2. �й��˻�, 3. ��������, ��Ÿ. �޴�");
		input = scan.next();
		switch(input) {
		case "1":
			allView(students);
			break;
		case "2":
			StudentControl stu = new StudentControl();
			System.out.println("�й��� �Է����ּ��� : ");
			input = scan.next();
			int index = stu.searchStudents(input);
			if(index >= 0) {
				studentNumView(index);
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		case "3":
			System.out.println("���������Դϴ�.");
			for(int i=0; i<studentExpel.expelStudents.size(); i++) {
				System.out.println(studentExpel.expelStudents.get(i));				
			}
		case "4":
			return;
			default:
		}
	}

	private void studentNumView(int index) {
		System.out.println(students.get(index));
	}

	private void allView(List<Student> students) {
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

	// �߰� �޼ҵ�
	private void addStudent(List<Student> students) {
		String name = "";
		String age = "";
		String studentNum = "";
		String major = "";
		
		System.out.println("�л� ������ �߰��մϴ�");
		System.out.println("�л� ������ �Է����ּ���.");
		System.out.println("�л� �̸� : ");
		name = scan.next();
		System.out.println("�л� ���� : ");
		age = scan.next();
		System.out.println("�й� : ");
		studentNum = scan.next();
		System.out.println("���� : ");
		major = scan.next();
		students.add(new Student(name, age, studentNum, major));
		System.out.println("�л� ������ �߰��Ǿ����ϴ�.");
		// ������ �Է¹޾� students �迭�� �߰�
	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				if(updateStudent(index)) {
					System.out.println("������ �Ϸ�Ǿ����ϴ�");
					break;
				} else {
					System.out.println("������ �����Ͽ����ϴ�.");
				}
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getStudentNum().equals(studentNum)) {
				return i;
			}
		}
		return -1; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] 
		String input = "";
		boolean done = false;
		
		System.out.println("������ �׸� ����");
		System.out.println("[1. �̸�] [2. ����] [3. �й�] [4. ����]");
		input = scan.next();
		switch(input) {
		case "1":
			System.out.println("�л� �̸� : ");
			input = scan.next();
			students.get(index).setName(input);
			done = true;
			break;
		case "2":
			System.out.println("�л� ���� : ");
			input = scan.next();
			students.get(index).setAge(input);
			done = true;
			break;
		case "3":
			System.out.println("�й� : ");
			input = scan.next();
			students.get(index).setStudentNum(input);
			done = true;
			break;
		case "4":
			System.out.println("���� : ");
			input = scan.next();
			students.get(index).setMajor(input);
			done = true;
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			done = false;
		}
		return done;
	}


	// ���� �޼ҵ�
	void deleteStudent(StudentExpel studentExpel) {
		//[�л����� ����] �й��� �Է����ּ��� : 
		
		System.out.println("[�л����� ����] �й��� �Է����ּ��� : ");
		String input = scan.next();
		int index = searchStudents(input);
		if(index >= 0) {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
		} else {
			System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���.");
			deleteStudent(studentExpel);
		}
	}

}
