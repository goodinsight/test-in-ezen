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
		Student s1 = new Student("������", "26", "1622100197", "���");
		Student s2 = new Student("������", "27", "1622100198", "�İ�");
		Student s3 = new Student("������", "28", "1622100199", "��īƮ�δн�");
		Student s4 = new Student("������", "29", "1622100200", "������");
		Student s5 = new Student("������", "30", "1622100201", "ȯ��");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("=====�л������ý���=====");
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

//	msg�޾Ƽ� String��ȯ�ϴ� �޼ҵ�
	String strchoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	// ���� �޼ҵ�
	void studentView() {
		// 1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("1.��ü���� 2.�й��˻� 3.�������� ��Ÿ. �޴�");
		String sel = strchoice("��ȣ �Է� : ");
		
		if (sel.equals("1")) {
			for (Student s : students) {
				System.out.println(s);
			}
		} else if (sel.equals("2")) {
			String sNum = strchoice("�й� �Է� : ");
			int per = searchStudents(sNum);
			if (per == -1) {
				System.out.println("���� �й��Դϴ�.");
			} else if (!sNum.equals(students.get(per).getStudentNum())) {
				System.out.println("�й��� Ʋ���� �Է��߽��ϴ�.");
			}else {
				System.out.println(students.get(per));
			}
		} else if (sel.equals("3")) {
			if(studentExpel.expelStudents.size() == 0) {
				System.out.println("������ �л��� �����ϴ�.");
			}else {
				for(int i=0;i<studentExpel.expelStudents.size();i++) {
					System.out.println(studentExpel.expelStudents.get(i));
				}
			}
		} else {
			System.out.println("�޴��� ���ư��ϴ�.");
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		Student s1 = new Student(strchoice("�л� �̸� �Է� : "),strchoice("���� �Է� : ") ,strchoice("�й� �Է� : ") , strchoice("���� �Է� : "));
		
		students.add(s1);

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
				if(updateStudent(index) == true) {
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
		System.out.println("===������ �׸� ����===");
		System.out.println("1.�̸� 2.���� 3.�й� 4.���� 5.�޴�");
		String sel = strchoice("���ϴ� �׸� �Է� : ");
		boolean done = false;
		switch(sel) {
		case "1":
			String name = strchoice("������ �̸��� �Է� : ");
			students.get(index).setName(name);
			done = true;
			break;
		case "2":
			String age = strchoice("������ ���̸� �Է� : ");
			students.get(index).setAge(age);
			done = true;
			break;
		case "3":
			String studentNum = strchoice("������ �й��� �Է� : ");
			students.get(index).setStudentNum(studentNum);
			done = true;
			break;
		case "4":
			String major = strchoice("������ ������ �Է� : ");
			students.get(index).setMajor(major);
			done = true;
			break;
		case "5":
			System.out.println("�ڷ� �̵�");
			break;
			default :
				System.out.println("�߸� �Է��߽��ϴ�.");
				updateStudent(index);
		}
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		// [�л����� ����] �й��� �Է����ּ��� :
		String num = strchoice("[�л����� ����] �й��� �Է��ϼ��� : ");
		int per = searchStudents(num);
		if(per == -1) {
			System.out.println("���� �й��Դϴ�.");
		}else if(!num.equals(students.get(per).getStudentNum())) {
			System.out.println("�Է��� �й��� Ʋ�Ƚ��ϴ�.");
		}else {
			System.out.println("�л������� �����Ͽ����ϴ�.");
			studentExpel.addExpelStudents(students.get(per));
			students.remove(per);
		}
		
		

	}

}
