package member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����
	
	

	// �ʱⰪ
	void init_a() {
		students.add(new Student("��", "21", "1111", "AB"));
		students.add(new Student("��", "22", "2222", "CD"));
		students.add(new Student("��", "23", "3333", "EF"));
		students.add(new Student("��", "24", "4444", "GH"));
		
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("1. �߰�, 2. ����, 3. ����, 4. ����, ��Ÿ. ����");
		
		return scan.next(); // �Էµ� �����͸� ����
	}

	void studentPlay(String sel) {
		// ȭ�� �޴���� 1. �߰� , 2. ����, 3. ����, 4. ����, ��Ÿ. ����
		sel=menuView();
		
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
			sel="5";
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
		
	}

	// ���� �޼ҵ�
	void studentView() {
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		String sel=scan.next();
		switch(sel) {
		case "1":	// 1. ��ü����
			Iterator<Student> iterS=students.iterator();
			while(iterS.hasNext()) {
				System.out.println(iterS.next());
			}
			return;
		case "2":	// 2. �й��˻�
			System.out.print("�й� �Է� : ");
			int index=0;
			index=searchStudents(scan.next());
			if(index==-1) {
				System.out.println("�ش� �й� ����");
				return;
			}
			System.out.println(students.get(index));
			return;
		case "3":	// 3. ��������
			Iterator<Student> iterE=studentExpel.expelStudents.iterator();
			if(!iterE.hasNext()) {
				System.out.println("���� ���� ����");
				return;
			}
			while(iterE.hasNext()) {
				System.out.println(iterE.next());
			}
			return;
		default:
			System.out.println("�ʱ� �޴��� ���ư��ϴ�");
			return;	
		}

	}

	// �߰� �޼ҵ�
	private void addStudent() {
		// ������ �Է¹޾� students �迭�� �߰�
		String name, age, num, major;
		System.out.print("�й� : ");
		num=scan.next();
		if(searchStudents(num)!=-1) {
			System.out.println("�ߺ� �й�");
			return;
		}
		System.out.print("�̸� : ");
		name=scan.next();
		System.out.print("���� : ");
		age=scan.next();
		System.out.print("���� : ");
		major=scan.next();
		students.add(new Student(name, age, num, major));
		
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
				if(updateStudent(index)) {
					System.out.println("�����Ǿ����ϴ�");
				}
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
				continue;
			}
		}
		
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index=-1;
		for(int i=0; i<students.size(); i++) {
			if(Objects.equals(studentNum, students.get(i).getStudentNum())) {
				index=i;
				break;
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
		
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] 
		boolean done=false;
		System.out.println("������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����]");
		String sel=scan.next();
		switch(sel) {
		case "1":
			System.out.print("������ �̸� : ");
			students.get(index).setName(scan.next());
			done=true;
			break;
		case "2":
			System.out.print("������ ���� : ");
			students.get(index).setAge(scan.next());
			done=true;
			break;
		case "3":
			System.out.print("������ �й� : ");
			String num=scan.next();
			if(searchStudents(num)!=-1) {
				System.out.println("�ߺ� �й�");
				break;
			}
			students.get(index).setStudentNum(num);
			done=true;
			break;
		case "4":
			System.out.print("������ ���� : ");
			students.get(index).setMajor(scan.next());
			done=true;
			break;
		default:
			break;
		}
		return done;
		
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		//[�л����� ����] �й��� �Է����ּ��� :
		System.out.print("[�л����� ����] �й��� �Է����ּ��� : ");
		int index=-1;
		index=searchStudents(scan.next());
		if(index==-1) {
			System.out.println("�ش� �й� ����");
			return;
		}
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
		
	}

	
}
