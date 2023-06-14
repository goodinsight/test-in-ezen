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
		Student s = new Student("���", "21", "11", "��ħ");
		Student s2 = new Student("�̼�", "22", "12", "����");
		Student s3 = new Student("�ϼ�", "23", "13", "����");

		students.add(s);
		students.add(s2);
		students.add(s3);
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.print("1. �߰�, 2. ����, 3. ����, 4. ����. ��Ÿ (�ƹ��ų� ������ ����) : ");
		return scan.next(); // �Էµ� �����͸� ����
	}

	void studentPlay(String sel) {
		// ȭ�� �޴���� 1. �߰� , 2. ����, 3. ����, 4. ����, ��Ÿ. ����
		switch (sel) {
		case "1": // �߰��޼ҵ�()
			addStudent();
			break;
		case "2": // �����޼ҵ�()
			updateView();
			break;
		case "3": // �����޼ҵ�()
			deleteStudent();
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
		// 1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("1) ��ü����, 2) �й��˻�, 3) ��������, ��Ÿ, �޴�");
		String num = input("��ȣ �Է�");
		switch (num) {
		case "1":
			for (Student s : students) {
				System.out.println(s);
			}
			break;
		case "2":
			String stname = input("�л��� �̸��� �Է�");
			for (int i = 0; i < students.size(); i++) {
				Student s = students.get(i);
				if (stname.equals(s.getName())) {
					System.out.println(s.getName() + " �л� �й��� " + s.getStudentNum() + "�Դϴ�");
					break;
				}
			}
			break;
		case "3":
			Iterator<Student> sd = studentExpel.expelStudents.iterator();
			while (sd.hasNext()) {
				System.out.println(sd.next());
			}
			break;
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {

		// ������ �Է¹޾� students �迭�� �߰�
		System.out.println("�л� ������ �߰��մϴ�");
		String name = input("�̸��� �����ּ���");
		String age = input("���̸� �����ּ���");
		String stnum = input("�й��� �����ּ���");
		String ma = input("�а��� �����ּ���");

		Student st = new Student(name, age, stnum, ma);

		students.add(st);
		System.out.println("������ �����Ͽ����ϴ�");

	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			studentNum = input("[�л����� ����] �й��� �Է��ϼ���");
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				if (updateStudent(index) == true) {
					System.out.println("�����Ǿ����ϴ�.");
					break;
				} else {
					System.out.println("�������� �ʾҽ��ϴ�.");// ����
					break;
				}
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (studentNum.equals(students.get(i).getStudentNum())) {
				index = i;
				break;
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]
		System.out.println("������ ���");
		System.out.println("1) �̸�, 2) ����, 3) �й�, 4) ����");
		String num = input("��ȣ ����");
		Student s = students.get(index);
		boolean done = false;

		switch (num) {
		case "1":
			System.out.println(s.getName() + " �л��� �̸��� �ٲߴϴ�");
			String name = input("�ٲ� �̸��� �Է�");
			s.setName(name);
			System.out.println(s.getName() + " �л����� �ٲ����ϴ�");
			done = true;

			break;
		case "2":
			System.out.println(s.getName() + " �л��� ������ �ٲߴϴ�");
			String age = input("�ٲ� ���̸� �Է�");
			s.setAge(age);
			System.out.println(s.getName() + " �л� ���̰� " + s.getAge() + "���� �ٲ����ϴ�");
			done = true;

			break;
		case "3":
			System.out.println(s.getName() + " �л��� �й��� �ٲߴϴ�");
			String Num = input("�ٲ� �й��� �Է�");
			s.setStudentNum(Num);
			System.out.println(s.getName() + " �л� �й��� " + s.getStudentNum() + "���� �ٲ����ϴ�");
			done = true;

			break;
		case "4":
			System.out.println(s.getName() + " �л��� �а��� �ٲߴϴ�");
			String ma = input("�ٲ� �а��� �Է�");
			s.setMajor(ma);
			System.out.println(s.getName() + " �л� �а��� " + s.getMajor() + "���� �ٲ����ϴ�");
			done = true;

			break;

		}

		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		// [�л����� ����] �й��� �Է����ּ��� :
		String delnum = input("������ �й��� �Է�");
		int num = searchStudents(delnum);
		if (num != -1) {
			studentExpel.addExpelStudents(students.remove(num));
		} else {
			System.out.println("�й��� ���� ����");
		}
	}

	String input(String msg) {
		System.out.print(msg + " : ");
		return scan.next();
	}

}
