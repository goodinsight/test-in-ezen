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
		
		Student s1 = new Student("����", "47", "1001", "����");
		Student s2 = new Student("������", "43", "1002", "����");
		Student s3 = new Student("���ٺ�", "8", "1003", "����");
		Student s4 = new Student("������", "13", "1004", "ü��");
		Student s5 = new Student("������", "12", "1005", "����");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("========= �л� ���� �������Դϴ�. =========");
		System.out.println("1. �߰�, 2. ����, 3. ����, 4. ����, 5. ����");
		System.out.println("-------------------------------------");
		return scan.next(); // �Էµ� �����͸� ����
	}

	void studentPlay(String sel) {
		switch (sel) {
		case "1": // �߰��޼ҵ�()
			addStudent();
			break;
		case "2": // �����޼ҵ�()
			updateView(students);
			break;
		case "3": // �����޼ҵ�()
			deleteStudent(studentExpel);
			break;
		case "4": // ����޼ҵ�()
			studentView();
			break;
		case "5": // ����޼ҵ�()
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
			break;			
		default:
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
	}

	// ���� �޼ҵ�
	void studentView() {
		int select = 0;
		
		System.out.println("1. ��ü���� 2.�й��˻� 3.�������� ");
		System.out.println("������ �ּ��� >");
		select = scan.nextInt();
		
		if(select == 1 || select == 2 || select == 3) {
			switch (select) {
			case 1:
				System.out.println("========== ��ü �л� ���� ��� ==========");
				for(int i=0; i<students.size(); i++) {
					System.out.printf("�̸�: %s  ����: %2s  �й�: %4s  ����: %s \n", students.get(i).getName(),
					         students.get(i).getAge(),  
					         students.get(i).getStudentNum(), 
					         students.get(i).getMajor());
				}
				break;
			case 2:
				int idx = -1;
				String studentNum = "111";
				System.out.println("�й����� �л��� ��ȸ�մϴ�.");
				System.out.println("�й� �Է�");
				studentNum = scan.next();
				
				idx = searchStudents(students, studentNum);
				System.out.println("========== ��ȸ �л� ���� ��� ==========");
				System.out.printf("�̸�: %s  ����: %2s  �й�: %4s  ����: %s \n", students.get(idx).getName(),
				         students.get(idx).getAge(),  
				         students.get(idx).getStudentNum(), 
				         students.get(idx).getMajor());
				System.out.println();				
				break;
			case 3:
				System.out.println("������ ������ ��µ˴ϴ�.");
				
				for(int i=0; i<studentExpel.expelStudents.size(); i++) {
					System.out.println("�̸� : " + studentExpel.expelStudents.get(i).getName()
					         + "���� : " + studentExpel.expelStudents.get(i).getAge() 
					         + "�й� : " + studentExpel.expelStudents.get(i).getStudentNum()
					         + "���� : " + studentExpel.expelStudents.get(i).major);
				}
				
				break;
			default:
				break;
			}	
		}
		else {
			System.out.println("�߸������ϼ̽��ϴ�. �ٽ� ������ �ּ���");
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		boolean OnOff = false;
		int select = 0;
		
		while(!OnOff) {
//			�л� 1�� ���� �ڷ� ����
			Student s = new Student(null, null, null, null);
			System.out.println("�л������� �Է��� �ּ���");
			System.out.println("�̸� �Է� >");
			s.setName(scan.next());
			System.out.println("���� �Է� >");
			s.setAge(scan.next());
			System.out.println("�й� �Է� >");
			s.setStudentNum(scan.next());
			System.out.println("���� �Է� >");
			s.setMajor(scan.next());
//			���忩�� Ȯ��	
			System.out.println("�Է��Ͻ� ������ �Ʒ��� �����ϴ�. �����Ͻðڽ��ϱ�?");
			System.out.println("���� 1��  �ٽ� �Է� 2��");
			select = scan.nextInt();
			if(select == 1) {
				students.add(s);
				System.out.println("�Է��Ͻ� ������ ����Ǿ����ϴ�. ");
				OnOff = true;
			} 
		}	

	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView(List<Student> students) {
		int index;
		String studentNum = "";

		while (true) {
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(students, studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				if(updateStudent(students ,index))
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(List<Student> students, String studentNum) {
		int index = -1;
		
		for(int i=0; i<students.size(); i++) {
			if(studentNum.equals(students.get(i).getStudentNum())) {
				index = i;				
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

	// ���� �޼ҵ�
	boolean updateStudent(List<Student> students, int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] 
		boolean done = false;
		System.out.println("�����Ͻ� �׺��� �������ּ���");
		System.out.println("[1. �̸�] [2. ����] [3. �й�] [4. ����]");

		int select = scan.nextInt();
		
		switch (select) {
		case 1:
			System.out.println("������ �̸��� " + students.get(index).getName() +" �Դϴ�.");
			System.out.println("������ �̸��� �־��ּ��� >");
			students.get(index).setName(scan.next());
			System.out.println("�̸��� " + students.get(index).getName() + " ���� ����Ǿ����ϴ�.");
			done = true;
			break;
		case 2:
			System.out.println("������ ������ " + students.get(index).getAge() +" �Դϴ�.");
			System.out.println("������ ���̸� �־��ּ��� >");
			students.get(index).setAge(scan.next());
			System.out.println("���̰� " + students.get(index).getAge() + " ���� ����Ǿ����ϴ�.");
			done = true;
			break;
		case 3:
			System.out.println("������ �й��� " + students.get(index).getStudentNum() + " �Դϴ�.");
			System.out.println("������ �й��� �־��ּ��� >");
			students.get(index).setStudentNum(scan.next());
			System.out.println("�й��� " + students.get(index).getStudentNum() + " ���� ����Ǿ����ϴ�.");
			done = true;
			break;
		case 4:
			System.out.println("������ ������ " + students.get(index).getMajor()+ " �Դϴ�.");
			System.out.println("������ ������ �־��ּ��� >");
			students.get(index).setMajor( scan.next() );
			System.out.println("������ " + students.get(index).getMajor() + " ���� ����Ǿ����ϴ�.");
			done = true;
			break;
		default:
			System.out.println("��û ������ Ȯ���Ҽ� �����ϴ�. ");
			done = false;
			break;
		}
		
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent(StudentExpel studentExpel) {
		//[�л����� ����] �й��� �Է����ּ��� : 
		System.out.println("�л������� �����ϰڽ��ϴ�.");
		System.out.println("�й��� �Է��� �ּ���");
		String tmpNum = scan.next();
		int idx = searchStudents(students, tmpNum);
		System.out.println(students.get(idx).getName() +"�� ������ �����Ϸ� �մϴ�. ");
		System.out.println("������ 1�� �̻����� �ƹ�Ű�� �����ּ���");
		int tmpidx = scan.nextInt();		
		
		if(tmpidx ==1) {
//			�ִ°���
			studentExpel.addExpelStudents(students.get(idx)); // �ٸ� Ŭ�������� �Լ��� ȣ��
			students.remove(idx);
			
		}
		else {
			System.out.println("���������� ���� �ʾҽ��ϴ�. ");
		}	
	}

}
