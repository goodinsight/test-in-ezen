package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����
	FileInputOutput fileInputOutput = new FileInputOutput(); // ���Ϸ� �л����� �ʱ�ȭ �� ���� ����
	// �ʱⰪ
	void init_a() {
		students = fileInputOutput.init();	
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("<�л� ���� �ý��� v1.0>");
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
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		String sel;
		String studentNum = "";
		menu:
		while (true) {
			System.out.println("1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
			System.out.print("���Ͻô� �޴��� �Է��ϼ��� : ");
			sel = scan.next();
			switch (sel) {
			case "1":// �л� ��ü ����
				fileInputOutput.readFile("student.txt");
				break;
			case "2":// �й����� �л����� �˻�
				while (true) {
					System.out.println("������ ������� �л��� �й��� �Է��ϼ��� : ");
					studentNum = scan.next();
					int index = searchStudents(studentNum); // �й����� �˻�
					if (index >= 0) { // �ε������� �ִٸ�
						System.out.println(students.get(index).toString());
						break;
					} else {
						System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�.");
						break;
					}
				}
				break;
			case "3":// ������ �л�����
				fileInputOutput.readFile("studentExpel.txt");
				break;

			default:
				System.out.println("�����޴��� ���ư��ϴ�.");
				break menu;
			}
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		Student s1 = new Student();
		System.out.println("�л��� �̸��� �Է��ϼ��� : ");
		s1.setName(scan.next());
		System.out.println("�л��� ���̸� �Է��ϼ��� : ");
		s1.setAge(scan.next());
		System.out.println("�л��� �й��� �Է��ϼ��� : ");
		s1.setStudentNum(scan.next());
		System.out.println("�л��� ������ �Է��ϼ��� : ");
		s1.setMajor(scan.next());
		fileInputOutput.addStudentInfor(s1);
		students.add(s1);
	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.println("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				updateStudent(index); // ����
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�."); // �Է¿����� ���Է�
				break;
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index = -1;
		for(int i = 0; i< students.size(); i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
				index = i;
				break;
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] 
		boolean done = false;
		
		while(!done) {
			System.out.println("[�л����� ����] ������ �׸��� ������ : ");
			System.out.println("[1. �̸�] [2. ����] [3. �й�] [4. ����] ");
			switch (scan.next()) {
			case "1":
				System.out.println("[�л� �̸� ����]");
				System.out.println("�ٲٽ� �̸��� �Է��ϼ��� : ");
				String tmp1 = scan.next();
				students.get(index).setName(tmp1);
				System.out.println("�̸��� " + tmp1 + "(��)�� �����Ǿ����ϴ�.");
				done = true;
				break;
			case "2":
				System.out.println("[�л� ���� ����]");
				System.out.println("�ٲٽ� ���̸� �Է��ϼ��� : ");
				String tmp2 = scan.next();
				students.get(index).setAge(tmp2);
				System.out.println("���̰� " + tmp2 + "���� �����Ǿ����ϴ�.");
				done = true;
				break;
			case "3":
				System.out.println("[�л� �й� ����]");
				System.out.println("�ٲٽ� �й��� �Է��ϼ��� : ");
				String tmp3 = scan.next();
				students.get(index).setStudentNum(tmp3);
				System.out.println("�й��� " + tmp3 + "�� �����Ǿ����ϴ�.");
				done = true;
				break;
			case "4":
				System.out.println("[�л� ���� ����]");
				System.out.println("�ٲٽ� ������ �Է��ϼ��� : ");
				String tmp4 = scan.next();
				students.get(index).setName(tmp4);
				System.out.println("������ " + tmp4 + "�� �����Ǿ����ϴ�.");
				done = true;
				break;

			default:
				System.out.println("�޴��� �ٽ� ������.");
				break;
			}	
		}
		fileInputOutput.saveStudentInfor(students); // ������ ���� ����
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		//[�л����� ����] �й��� �Է����ּ��� : 
		int index;
		String studentNum = "";
		
		while(true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				studentExpel.addExpelStudents(students.get(index));
				fileInputOutput.removeStudentInfor(students.get(index));
				students.remove(index);
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�."); // �Է¿����� ���Է�
				break;
			}
		}	
	}
}
