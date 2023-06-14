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

//		Student s1 = new Student("�۽ÿ�", "30", "2011-1", "������");
//		Student s2 = new Student("������", "25", "2018-2", "����");
//		Student s3 = new Student("������", "32", "2011-3", "������");
//		Student s4 = new Student("���쿹��", "29", "2011-5", "����");
//		Student s5 = new Student("�۹���", "31", "2011-7", "������");
		
		Student s1 = new Student("�۽ÿ�", "30", "2011-1", "������");
		Student s2 = new Student("������", "25", "2018-2", "����");
		Student s3 = new Student("������", "32", "2011-3", "������");
		Student s4 = new Student("���쿹��", "29", "2011-5", "����");
		Student s5 = new Student("�۹���", "31", "2011-7", "������");

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

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

//	private String name;//�̸�
//	private int age;//����
//	private String studentNum;//�й�
//	private String major;//�к�����??!!

	void studentView() {
		// 1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("1.��ü����,2.�й�,3.��������, ��Ÿ ���");
		int sel = scan.nextInt();
		
		if(sel==1) {
			for(Student s:students) {
				System.out.println(s);
			}
		}else if(sel==2) {
			System.out.println("�й��� �����ðԿ�");
			String studentNum =scan.next();
		if(searchStudents(studentNum, students)==-1) {
			System.out.println("�й������������ʽ��ϴ�");
			
		}else {
			System.out.println("�����ϴ��й��Դϴ�:   "+students.get(searchStudents(studentNum, students)));
		}
				
			}
		}
		
	

	// �߰� �޼ҵ�
	private void addStudent() {// ������ �Է¹޾� students �迭�� �߰�
		System.out.println("�������Է¹���");

		System.out.println("�̸�,����,�й�,���� �� �߰�����");
		String name = scan.next();
		System.out.println("�̸� �� �߰�");
		int age = scan.nextInt();
		System.out.println("���� �� �߰�");
		String studentNum = scan.next();
		System.out.println("�й� ��  �߰�");
		String major = scan.next();
		System.out.println("���� �� �߰�");

		students.add(new Student(name, name, studentNum, major));

		
		System.out.println("�̸� : " + name + " ���� : " + age + " �й� : " + studentNum + " ���� : " + major + "�� �߰��Ѿ ");	
	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {// �����ִɱ��?!?!
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum, students); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				updateStudent(index); // ����
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum, List<Student>students) {
		int index = -1;
		
		for(int i=0;i<students.size();i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
				index =i;
				break;
			}
		}
		
			 
		

		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]
		boolean done = false; // true
		//students.get(searchStudents(toString()));
		
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		// [�л����� ����] �й��� �Է����ּ��� :
		System.out.println("�л����� �����Դϴ� �й��� �Է�����");
		//int index=searchStudents(scan.next());
		//StudentExpel.addExpelStudents(students.get(index));
	}

}
