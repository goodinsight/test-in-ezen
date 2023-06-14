package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl7 {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����

	// �ʱⰪ
	void init_a() {
//		�л����� ����Ʈ�� ���̴� �������� ����. -> list.size() �� ����
		Student s1 = new Student("�輭��", "24", "20230614", "�濵");
		Student s2 = new Student("�赿��", "23", "20230615", "����");
		Student s3 = new Student("�����", "22", "20230616", "���");
		Student s4 = new Student("�賲��", "21", "20230617", "�İ�");
		Student s5 = new Student("������", "20", "20230618", "��ġ");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("--------------");
		System.out.println("1. �л����� �߰�");
		System.out.println("2. �л����� ����");
		System.out.println("3. �л����� ����");
		System.out.println("4. �л����� ����");
		System.out.println("��Ÿ. ����");
		System.out.println("--------------");
		System.out.print("��ȣ�� �Է��ϼ���.> ");

		return scan.next(); // �Էµ� �����͸� ����
	}

	void studentPlay(String sel) {
		// ȭ�� �޴���� 1. �߰� , 2. ����, 3. ����, 4. ����, ��Ÿ. ����`
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
		System.out.println("1.��ü���� 2.�й��˻� 3.��������");
		System.out.println("��Ÿ��ȣ. �޴�");
		System.out.print("��ȣ �Է�> ");
		int sel = scan.nextInt();

		switch (sel) {
		case 1:
			// ��ü����
			for (int i = 0; i < students.size(); i++) {
				System.out.println("�̸�: " + students.get(i).getName() + " ����: " + students.get(i).getAge() + " �й�: "
						+ students.get(i).getStudentNum() + " ����: " + students.get(i).getMajor());
			}
			break;

		case 2:
			// �й��˻�
			System.out.print("�й��� �Է��ϼ���. > ");
			String studentNum = scan.next();

			int index = searchStudents(studentNum);
			if (index == -1) {
				System.out.println("> ���� ��ȣ�Դϴ�.");
			} else {
				System.out.println(students.get(index));
			}

			break;

		case 3:
			// ��������
			System.out.println("������ �л� ����");
			if(studentExpel.expelStudents.size()==0) {
				System.out.println("> ������ �л� ������ �����ϴ�.");
			} else {
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					System.out.println(studentExpel.expelStudents.get(i));
				}
				
			}
			break;

		default:
//			�޴�
			
			break;
		}

	}

//	msg �޾Ƽ� String���� ��ȯ�ϴ� �޼ҵ�
	private String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	// �߰� �޼ҵ� ->add
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�

//		list���� StudentŬ������ �ʵ� ������ �Է�. (�̸�, ����, �й�, ����)
//		���࿡ -> �迭�� �о ���� ������ �� �ڸ��� �߰� or index+1���ڸ��� �߰�?
		System.out.println("> �л������� �߰��մϴ�.");
		Student s1 = new Student(strChoice("�̸� �Է�: "), strChoice("���� �Է�: "), strChoice("�й� �Է�: "),
				strChoice("���� �Է�: "));
		students.add(s1);

	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է� ->set
	public void updateView() {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				
				if(updateStudent(index) == false) {
					
//					updateStudent(index);
//					break;
				} else {
					break;
				}

			} else {
				System.out.println("> �Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����) //�й����� index ã��
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

	// ���� �޼ҵ� ->set
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]
//		�л��� ������ �Է¹޾Ƽ� -> �� ������ ��� index�� ������ �̸�,����,�й�,���� ����

		boolean done = false;
		
		while (!done) {

				System.out.println("�����׸�: [1. �̸�] [2. ����] [3. �й�] [4. ����]");
				System.out.print("������ �׸��� �����ϼ���.> ");
				int sel = scan.nextInt();

				switch (sel) {
				case 1: // �̸�����
					System.out.println("������ �̸��� �Է��ϼ���.> ");
					String name = scan.next();
					students.get(index).setName(name);
					System.out.println("> �̸��� " + name + "���� ����Ǿ����ϴ�.");
					done = true;
					break;
				case 2: // ���̼���
					System.out.println("������ ���̸� �Է��ϼ���.> ");
					String age = scan.next();
					students.get(index).setAge(age);
					System.out.println("> ���̰� " + age + "��� ����Ǿ����ϴ�.");
					done = true;
					break;
				case 3: // �й�����
					System.out.println("������ �й��� �Է��ϼ���.> ");
					String sNum = scan.next();
					students.get(index).setStudentNum(sNum);
					System.out.println("> �й��� " + sNum + "���� ����Ǿ����ϴ�.");
					done = true;
					break;

				case 4: // ��������
					System.out.println("������ ������ �Է��ϼ���.> ");
					String major = scan.next();
					students.get(index).setMajor(major);
					System.out.println("> ������ " + major + "���� ����Ǿ����ϴ�.");
					done = true;
					break;

				default :
					System.out.println("> �߸��� ��ȣ �Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}		

				return done;
	}

	// ���� �޼ҵ� ->remove
	void deleteStudent() {
		// [�л����� ����] �й��� �Է����ּ��� :
		System.out.print("������ �л��� �й��� �Է��ϼ���.> ");
		String studentNum = scan.next();
		int index = searchStudents(studentNum);
		if (index >= 0) {
			studentExpel.addExpelStudents(students.get(index));
//			System.out.println(students.get(index));
			//studentExpel�� �ִ� expelStudents ����Ʈ�� �߰��Ѵ� -> students����Ʈ�� �ִ� index��ġ�� ������ �߰�.
			students.remove(index);
		} else {
			System.out.println("> ���� �й��Դϴ�. �ٽ� �Է��ϼ���.");
		}

	}

}
