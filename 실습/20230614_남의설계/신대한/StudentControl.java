package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����
	
	// �ʱⰪ
	void init_a() {
		students.add(new Student("�Ŵ���", "27", "00001", "��ǻ��Ȱ��"));
		students.add(new Student("�Źα�", "26", "00002", "��Ʈ��ũ"));
		students.add(new Student("���ٿ�", "27", "00003", "ȸ��"));
		students.add(new Student("�ڻ���", "26", "00004", "ȣ�ڰ濵"));
		students.add(new Student("������", "26", "00005", "��ǻ��Ȱ��"));
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
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("1. ��ü���� 2. �й��˻� 3. ��������, ��Ÿ. �޴�");
		
		switch (scan.nextInt()) {
		case 1:
			for (Student student : students) {
				System.out.println(student);
			}
			break;
		case 2:
			int index = -1;
			System.out.println("�й��� �Է����ּ���.");
			String studentNum = scan.next();
			for (int i = 0; i < students.size(); i++) {
				if(students.get(i).getStudentNum().equals(studentNum)) {
					index = i;
				}
			}
			if(index == -1) {
				System.out.println("�Է��Ͻ� �й��� ��ȸ�����ʽ��ϴ�.");
			}else {
				System.out.println(students.get(index));
			}
			break;
		case 3:
			if(studentExpel.expelStudents.size() != 0) {
				for (Student student : studentExpel.expelStudents) {
					System.out.println(student);
				}
			}else {
				System.out.println("������ ������ �л��� �����ϴ�.");
			}
			break;
		default:
			System.out.println("�Ŵ��� ���ư��ϴ�.");
			break;
		}

	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		System.out.println("�л��� �̸��� �Է����ּ���.");
		String name = scan.next();
		System.out.println("�л��� ���̸� �Է����ּ���.");
		String age = scan.next();
		System.out.println("�л��� �й��� �Է����ּ���");
		String studentNum = scan.next();
		System.out.println("�л��� ������ �Է����ּ���");
		String major = scan.next();
		students.add(new Student(name, age, studentNum, major));
	
		
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
				if(updateStudent(index) == true) {// ����
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
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
			if(students.get(i).getStudentNum().equals(studentNum)) {
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
			System.out.println("������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("������ �̸��� �Է����ּ���.");
				String name = scan.next();
				students.get(index).setName(name);
				done = true;
				System.out.println("�Է��Ͻ� �̸����� �����Ǽ̽��ϴ�");
				break;
			case 2:
				System.out.println("�����Ͻ� ���̸� �Է����ּ���.");
				String age = scan.next();
				students.get(index).setAge(age);
				done = true;
				System.out.println("�Է��Ͻ� ���̷� �����Ǽ̽��ϴ�");
				break;
			case 3:
				System.out.println("�����Ͻ� �й��� �Է����ּ���.");
				String studentNum = scan.next();
				students.get(index).setStudentNum(studentNum);
				System.out.println("�Է��Ͻ� �й����� �����Ǽ̽��ϴ�");
				done = true;
				break;
			case 4:
				System.out.println("������ ������ �Է����ּ���.");
				String major = scan.next();
				students.get(index).setMajor(major);
				System.out.println("�Է��Ͻ� �������� �����Ǽ̽��ϴ�");
				done = true;
				break;
			default:
				System.out.println("1~4���� �Ŵ��� �������ּ���.");
				updateStudent(index);
				break;
			}
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		//[�л����� ����] �й��� �Է����ּ��� : 
		System.out.println("[�л����� ����] �й��� �Է����ּ��� : ");
		String studentNum = scan.next();
		int index = searchStudents(studentNum);
		if(index != -1) {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�Է��Ͻ� �й��� �����ϴ� �ٽ� �Է����ּ���.");
			deleteStudent();
		}
	}

}
