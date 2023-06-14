package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import room.Room;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����

	// �ʱⰪ
	void init_a() {
		Student stu1 = new Student("��", "21", "2121", "����");
		Student stu2 = new Student("��", "22", "2222", "����");
		Student stu3 = new Student("��", "23", "2323", "�ٴ�");
		Student stu4 = new Student("��", "24", "2424", "���");
		Student stu5 = new Student("��", "25", "2525", "����");

		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		students.add(stu4);
		students.add(stu5);

	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("1. �߰�, 2. ����, 3. ����, 4. ����, ��Ÿ. ����");

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
		System.out.println("1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		int sel = scan.nextInt();
		switch (sel) {
		case 1:
			for (Student stu : students) {
				System.out.println("����: " + stu.getName() + " /// ����: " + stu.getAge() + " /// �й�: "
						+ stu.getStudentNum() + " /// ����: " + stu.getMajor());
			}
			break;
		case 2:
			System.out.print("�й��� �Է��ϼ���: ");
			Student stu = students.get(searchStudents(scan.next()));
			System.out.println("����: " + stu.getName() + " /// ����: " + stu.getAge() + " /// �й�: " + stu.getStudentNum()
					+ " /// ����: " + stu.getMajor());

			break;
		case 3:
			System.out.println("������ ����");
			if (studentExpel.expelStudents.size() != 0) {
				for (Student student : studentExpel.expelStudents) {
					System.out.println("����: " + student.getName() + " /// ����: " + student.getAge() + " /// �й�: "
							+ student.getStudentNum() + " /// ����: " + student.getMajor());
				}
			} else {
				System.out.println("������ ������ �����ϴ�");
				break;
			}
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		System.out.println("�л��� �߰��մϴ�");
		System.out.println("���: (�̸�,����,�й�,����))");
		String add = scan.next();
		String[] ad = add.split(",");
		String Name = ad[0];
		String Age = ad[1];
		String StudentNum = ad[2];
		String Major = ad[3];
		Student newPerson = new Student(Name, Age, StudentNum, Major);
		// ������ �Է¹޾� students �迭�� �߰�
		students.add(newPerson);
	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ���(99: ����): ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				updateStudent(index); // ����
				break;
			} else if (studentNum == "99") {
				System.out.println("�����մϴ�");
				break;
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
		System.out.println("������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]");
		int sel = scan.nextInt();
		String tmp = "";
		switch (sel) {
		case 1:
			System.out.println("������ �̸��� �Է��� �ּ���");
			tmp = scan.next();
			students.get(index).setName(tmp);
			break;
		case 2:
			System.out.println("������ ������ �Է��� �ּ���");
			tmp = scan.next();
			students.get(index).setAge(tmp);
			break;
		case 3:
			System.out.println("������ �й��� �Է��� �ּ���");
			tmp = scan.next();
			students.get(index).setStudentNum(tmp);
			break;
		case 4:
			System.out.println("������ ������ �Է��� �ּ���");
			tmp = scan.next();
			students.get(index).setMajor(tmp);
			break;
		}
		return true;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		System.out.println("[�л����� ����] �й��� �Է����ּ��� :");
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
//		int index = searchStudents(scan.next());
//		studentExpel.addExpelStudents(students.get(index));
//		students.remove(index);
	}

}
