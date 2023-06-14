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
		students.add(new Student ("�����", "29", "202310", "�̰�"));
		students.add(new Student ("�輭��", "31", "202309", "����"));
		students.add(new Student ("�Ŵ���", "28", "202304", "����"));
		students.add(new Student ("������", "27", "202303", "�̰�"));
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("���������������Ͻô� �޴��� �����ּ���.������������");
		System.out.println("1. �л� [�߰�]");
		System.out.println("2. �л� [����]");
		System.out.println("3. �л� [����]");
		System.out.println("4. �л� [��ȸ]");
		System.out.println("5. ���α׷� ����");
		System.out.println("����������������������������������������������������������������");

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
		System.out.println("����[�л���ȸ] �޴��Դϴ�.���Ͻô� �޴��� �������ּ���.����");
		System.out.println("1. ��ü����");
		System.out.println("2. �й��˻�");
		System.out.println("3. ��������");
		System.out.println("����������������������������������������������������������������������������������");
		
		switch (scan.nextInt()) {
		case 1:
			System.out.println("[��ü����] �Դϴ�.");
			for (int i = 0; i < students.size(); i++) {
//				System.out.println(students);  // ��ü ��������
				System.out.println(students.get(i));
			}
			break;
		case 2:
			System.out.println("[�й��˻�] �Դϴ�.");
			System.out.println("�й��� �Է����ּ���.");
			String no = scan.next();
			int idx = searchStudents(no);
			if(idx==-1) {
				System.out.println("���� �����Դϴ�.");
			}else {
				System.out.println(students.get(idx));
			}
			break;
		case 3:
			System.out.println("[��������] �Դϴ�.");
			if(studentExpel.expelStudents.size()==0) {
				System.out.println("������ ������ �����ϴ�.");
			}else {
				for (int i = 0; i < studentExpel.expelStudents.size(); i++) {
					System.out.println(studentExpel.expelStudents.get(i));	
				}
			}
			break;
		default:
			break;
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		System.out.println("�߰��Ϸ��� �л��� [�̸�]�� �Է����ּ���.");
		String name = scan.next();
		System.out.println("�߰��Ϸ��� �л��� [����]�� �Է����ּ���.");
		String age = scan.next();
		System.out.println("�߰��Ϸ��� �л��� [�й�]�� �Է����ּ���.");
		String num = scan.next();
		System.out.println("�߰��Ϸ��� �л��� [����]�� �Է����ּ���.");
		String major = scan.next();
	
		Student s1 = new Student(name, age, num, major);
		students.add(s1);
	}

	// ���� ���� �޼ҵ� : �й����� �˻��ϰ� ������ �����޼ҵ�ȣ�� ������ ���Է�
	public void updateView() {
		int index;
		String studentNum = "";
		boolean b = false;
		while (true) {
			System.out.print("[�л����� ����]�Դϴ�. �й��� �Է��ϼ��� : ");
			studentNum = scan.next();
			index = searchStudents(studentNum); // �й����� �˻�
			if (index >= 0) { // �ε������� �ִٸ�
				b = updateStudent(index); // ����
				if(b==true) {   // true�� ���߱�. false�� �ȸ��߱�
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
		
		System.out.println("������ ���Ͻô� �޴��� �������ּ���.");
		System.out.println("[1. �̸�] [2. ����] [3. �й�] [4. ����] ");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("[�̸�] ���� �Դϴ�.");
			System.out.println("������ �л��� �̸��� �Է����ּ���.");
			String name = scan.next();
			students.get(index).setName(name);
			done = true;
			break;
			
		case 2:
			System.out.println("[����] ���� �Դϴ�.");
			System.out.println("������ �л��� ���̸� �Է����ּ���.");
			String age = scan.next();
			students.get(index).setAge(age);
			done = true;
			break;
			
		case 3:
			System.out.println("[�й�] ���� �Դϴ�.");
			System.out.println("������ �л��� �й��� �Է����ּ���.");
			String num = scan.next();
			students.get(index).setStudentNum(num);
			done = true;
			break;
			
		case 4:
			System.out.println("[����] ���� �Դϴ�.");
			System.out.println("������ �л��� ������ �Է����ּ���.");
			String major = scan.next();
			students.get(index).setMajor(major);
			done = true;
			break;
			
		default:
			System.out.println("�߸������̽��ϴ�. �ٽ� �����ּ���.");
			updateStudent(index);
			break;
		}
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		//[�л����� ����] �й��� �Է����ּ��� : 
		System.out.println("[�л����� ����] �й��� �Է����ּ��� :");
		int index = searchStudents(scan.next());
		if (index==-1) {
			System.out.println("���� �л��Դϴ�.");
		}else {
			studentExpel.addExpelStudents(students.get(index));
			students.remove(index);
			System.out.println("�л� ������ �����Ǿ����ϴ�.");
		}
		
	}

}
