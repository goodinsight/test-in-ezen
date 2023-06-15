package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import kr.co.dong.room.Room;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ����ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����

	// �ʱⰪ
	void init_a() {
		students.add(new Student ("��Ƹ�", "24","2020","�װ���"));
		students.add(new Student ("��������", "26","2018","���ǰ�ȣ��"));
		students.add(new Student ("������", "21","2023","����Ʈ�����"));
		students.add(new Student ("���ú�", "25","2019","�ǿ����ǰ�"));
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("      �� ���ϴ� �޴��� �Է��ϼ��� ��      ");
		System.out.println("=================================");
		System.out.println("1. �߰� 2. ���� 3. ���� 4. ���� 99. ����");

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

	// �߰� �޼ҵ�
	private void addStudent() {
		System.out.println("�߰��� �л��� �̸��� �Է��ϼ��� : ");
		String name = scan.next();
		System.out.println("�߰��� �л��� ���̸� �Է��ϼ��� : ");
		String age = scan.next();
		System.out.println("�߰��� �л��� �й��� �Է��ϼ��� : ");
		String Num = scan.next();
		System.out.println("�߰��� �л��� �а��� �Է��ϼ��� : ");
		String major = scan.next();
		students.add(new Student(name, age, Num, major));
		// ������ �Է¹޾� students �迭�� �߰�
		
		
	}
	
	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";
		
		while (true) { // ������ ȭ�鸸 �����ִ� �޼ҵ�
			System.out.print("[�л����� ����] �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				if(updateStudent(index) == true) {// ����
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					break;
				} else {
					System.out.println("��ҵǾ����ϴ�.");
					break;
				}
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}
	
	// ���� �޼ҵ�(���⼭ �����ϴ� �ڵ� �ۼ�)
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]
		System.out.println("    �� �����ϰ� ���� ��ȣ�� �Է��ϼ��� ��    ");
		System.out.println("=================================");
		System.out.println("1. �̸� 2. ���� 3. �й� 4. ����");
		int update = scan.nextInt();
		switch (update) {
		case 1:
			System.out.println("������ �̸��� �Է����ּ��� : ");
			String name = scan.next();
			students.get(index).setName(name);
			return true;
		case 2:
			System.out.println("������ ���̸� �Է����ּ��� : ");
			String age = scan.next();
			students.get(index).setAge(age);
			return true;
		case 3:
			System.out.println("������ �й��� �Է����ּ��� : ");
			String num = scan.next();
			students.get(index).setStudentNum(num);
			return true;
		case 4:
			System.out.println("������ ������ �Է����ּ��� : ");
			String jaor = scan.next();
			students.get(index).setMajaor(jaor);
			return true;
		default:
			return false;
		}
		
	}
	
	// ���� �޼ҵ� = remove( )
	void deleteStudent() { 
		//[�л����� ����] �й��� �Է����ּ��� : 
		System.out.println("������ �л��� �й��� �Է����ּ��� : ");
		String num = scan.next();
		searchStudents(num);
		int index = searchStudents(num);
		if(index == -1) {
			System.out.println("�й��� �ٽ� �Է����ּ���.");
		} else {
			System.out.println(students.get(index));
			System.out.println("���� �����Ͻðڽ��ϱ�? (Y/N)");
			String choice = scan.next().toUpperCase(); // toUpperCase() = ������ �빮�ڷ� ����
			if(choice.equals("Y")) {
				studentExpel.addExpelStudents(students.get(index));
				students.remove(index);
			} else {
				System.out.println("��Ҹ� �����ϼ̽��ϴ�.");
			}
//			equals
		}
		
	}
	
	// ���� �޼ҵ�
	private void studentView() {
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("    �� Ȯ���ϰ� ���� ��ȣ�� �Է��ϼ��� ��    ");
		System.out.println("=================================");
		System.out.println("1. ��ü���� 2. �й��˻� 3.�������� 4. ����");
		int sel = scan.nextInt();
		
		switch (sel) {
		case 1: // ��üȮ��
			for (int i = 0; i < students.size(); i++) {
				System.out.println(students.get(i));
			} 
			break;
		case 2: //�й��˻�
			System.out.println("�й��� �Է��ϼ��� : ");
			String sNum = scan.next();
			searchStudents(sNum);
			int index = searchStudents(sNum);
			if(index == -1) {
				System.out.println("�й��� �ٽ� �Է��ϼ���.");
			} else {
//				students.get(index);
				System.out.println(students.get(index));
			}
		
			break;
		case 3 : //��������
			if(studentExpel.expelStudents.size() == 0) {
				System.out.println("������ ������ �����ϴ�.");
			} else {
				for(int i = 0; i < studentExpel.expelStudents.size(); i++ ) {
					System.out.println(studentExpel.expelStudents.get(i));
					
				}
			}
			break;
		case 4: //����
			
		default:
			break;
		}	
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String sNum) {
		int index = -1;
		for(int i = 0 ; i < students.size(); i++) {
			if(students.get(i).getStudentNum().equals(sNum)) {
				index = i;
			} 
		}

		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

}
