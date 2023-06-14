package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����
	Student student;

	// �ʱⰪ
	void init_a() {
		students.add(new Student("Ȳ����", "28", "18", "����"));
		students.add(new Student("���ֿ�", "29", "17", "����"));
		students.add(new Student("�赿��", "30", "16", "����"));
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("1. �߰�, 2. ����, 3. ����, 4. ����, ��Ÿ. ����");

		return scan.next();
	}

	// ȭ�� �޴���� 1. �߰� , 2. ����, 3. ����, 4. ����, ��Ÿ. ����
	void studentPlay(String sel) {
		switch (sel) {
		case "1": // �߰�
			addStudent();
			break;
		case "2": // ����
			updateView();
			break;
		case "3": // ����
			deleteView();
			break;
		case "4": // ����
			studentView();
			break;
		default:
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		System.out.println("�̸��� �Է����ּ���.");
		String name = scan.next();
		System.out.println("���̸� �Է����ּ���.");
		String age = scan.next();
		System.out.println("�й��� �Է����ּ���.");
		String sNum = scan.next();
		System.out.println("������ �Է����ּ���.");
		String major = scan.next();
		students.add(new Student(name, age, sNum, major));
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
				if (updateStudent(index) == true) {
					System.out.println("���� �Ǿ����ϴ�.");
				} else {
					System.out.println("��� �ϼ̽��ϴ�.");
				}
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		System.out.println(students.get(index));
		System.out.println("[1. �̸�] [2. ����] [3. �й�] [4. ����] [��Ÿ. ���]");
		System.out.println("������ �׸��� �������ּ��� .");
		int sel = scan.nextInt();
		switch (sel) {
		case 1: // �̸�����
			System.out.println("�����Ͻ� �̸��� �Է��� �ּ���.");
			String name = scan.next();
			students.get(index).setName(name);
			return true;
		case 2: // ���̼���
			System.out.println("�����Ͻ� ���̸� �Է��� �ּ���.");
			String age = scan.next();
			students.get(index).setAge(age);
			return true;
		case 3: // �й�����
			System.out.println("�����Ͻ� �й��� �Է��� �ּ���.");
			String sNum = scan.next();
			students.get(index).setStudentNum(sNum);
			return true;
		case 4: // ��������
			System.out.println("�����Ͻ� ������ �Է��� �ּ���.");
			String major = scan.next();
			students.get(index).setMajor(major);
			return true;
		default:
			return false;
		}
	}

	// ���� ���� �޼ҵ�
	void deleteView() {
		int index;
		String studentNum = "";
		
		System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
		studentNum = scan.next();
		index = searchStudents(studentNum); // �й����� �˻�
		if (index >= 0) { // �ε������� �ִٸ�
			if (deleteStudents(index) == true) {
				studentExpel.addExpelStudents(students.get(index)); // ���������� ����Ʈ�� �߰�
				students.remove(index); // ����
			} else {
				System.out.println("������ ����մϴ�.");
			}
		} else {
			System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�."); // �Է¿����� ���Է�
		}
	}

	// �����޼ҵ�
	boolean deleteStudents(int index) {
		System.out.println(students.get(index));
		while (true) {
			System.out.println("�����Ͻðڽ��ϱ�? (Y/N)");
			String sel = scan.next().toUpperCase();
			if (sel.equals("Y")) {
				return true;
			} else if (sel.equals("N")) {
				return false;
			} else {
				System.out.println("�߸��� �Է��Դϴ�."); // �߸��� �Է½� �ٽ� �Է¹���
			}
		}
	}

	// ���� �޼ҵ�
	void studentView() {
		System.out.println("1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		int sel = scan.nextInt();
		switch (sel) {
		case 1: // ��ü����
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			}
			break;
		case 2: // �й��˻�
			System.out.println("�й��� �Է����ּ���.");
			String sNum = scan.next();
			int idx = searchStudents(sNum);
			if (idx == -1) {
				System.out.println("�������� �ʴ� �й��Դϴ�.");
			} else {
				System.out.println(students.get(idx));
			}
			break;
		case 3: // ��������
			if (studentExpel.expelStudents.size() != 0) {
				System.out.println("[ ���� ���� ]");
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					studentExpel.expelView(i);
				}
			} else {
				System.out.println("���� ������ �����ϴ�.");
			}
			break;
		default: // �޴��ε��ư�
			System.out.println("�޴��� ���ư��ϴ�.");
			break;
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNum().equals(studentNum)) {
				index = i;
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}
}
