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
		// �л� ���� �Է�
		Student s1 = new Student ("�����", "31", "200914001", "Ʈ����"); // �ʱ� ȭ�鿡�� ���� ����� �ٷ� ��� �� �� �ֵ��� �л� ���� �Է�
		
		// �л� ����
		students.add(s1);
	}
	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println(" ����������������������������������������������������������������������������������������������������");
		System.out.println(" ��  1 �߰� ��  2 ���� ��  3 ���� ��  4 ���� �� ��Ÿ�Է� ���� ��");
		System.out.println(" ����������������������������������������������������������������������������������������������������");
		
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
		System.out.println(" ��������������������������������������������������������������������������������������������");
		System.out.println(" ��  1 ��ü���� ��  2 �й��˻� ��  3 �������� ��  4 ��Ÿ ��");
		System.out.println(" ��������������������������������������������������������������������������������������������");
		
		int sel = scan.nextInt();
		switch(sel) {
		case 1:  //��ü����
			
//			for(int i= 0; i<students.size(); i++) {
//				Student student = students.get(i);
			
			for(Student sData : students) {// ���� for��
				System.out.println(" �̸� :"+sData.getsName()+"/ ����:"+ sData.getsAge()+"/ �й�:"+ sData.getsNum()+"/ ����"+ sData.getsMajor());
			}
			break;			
			
		case 2: // �й��˻�
			System.out.println("ã������ �л� ������ �й��� �Է��ϼ���.");
			int index;
			index = searchStudents(scan.next());
			System.out.println(" �̸� :"+students.get(index).getsName()+"/ ����:"+ students.get(index).getsAge()+ "/ ����"+ students.get(index).getsMajor());
			break;
		case 3: // ��������
			
			for(Student dData : studentExpel.expelStudents) {
				System.out.println(" �̸� :"+dData.getsName()+"/ ����:"+ dData.getsAge()+"/ �й�:"+ dData.getsNum()+"/ ����"+ dData.getsMajor());
			}
			break;
		case 4: // ��Ÿ
			
			break;
		
		}

	}

	// �߰� �޼ҵ�
	private void addStudent() {
		System.out.println(" �л� ������ �߰��մϴ�.");
		System.out.print(" �̸� : ");
		String name = scan.next();
		System.out.print(" ���� : ");
		String age = scan.next();
		
		boolean Same = false;
		String num = null; 
		while(!Same){
			System.out.print(" �й� : ");
			num = scan.next();
			
			for(Student nData : students) {
				if(nData.getsNum().equals(num)) {
					System.out.println("�ߺ��� �й��Դϴ�. �ٸ� ���ڸ� �Է����ּ���.");
					break;
					
				}else if(students.get(students.size()-1).equals(nData)){
					Same = true;
				}
			}
		}
		System.out.print(" ���� : ");
		String major = scan.next();
		
		students.add(new Student(name, age, num, major));
		// ������ �Է¹޾� students �迭�� �߰�
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
				updateStudent(index); // ����
				break;
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}
	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index = -1;
		
		for(int i= 0; i<students.size(); i++) {
			if(students.get(i).getsNum().equals(studentNum)) {
				index = i;
				break;
			}
		}
		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

	// ���� �޼ҵ�
	boolean updateStudent(int index) {
		boolean done = false;
		// ������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] 
		int sels = scan.nextInt();// ������ �׸� ���� ����
		switch(sels) {
		
		case 1: // �̸� ����
			System.out.println(" ������ �̸��� �Է����ּ���.");
			students.get(index).setsName(scan.next());
			break;
		case 2: // ���� ����
			System.out.println(" ������ ���̸� �Է����ּ���.");
			students.get(index).setsAge(scan.next());
			break;
		case 3: // �й� ����
			System.out.println(" ������ �й��� �Է����ּ���.");
			students.get(index).setsNum(scan.next());
			break;
		case 4: // ���� ����
			System.out.println(" ������ ������ �Է����ּ���.");
			students.get(index).setsMajor(scan.next());
			break;
		}
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		System.out.println("[�л����� ����] �й��� �Է����ּ���.");
		//[�л����� ����] �й��� �Է����ּ��� : 
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		students.remove(index);
		}

}
