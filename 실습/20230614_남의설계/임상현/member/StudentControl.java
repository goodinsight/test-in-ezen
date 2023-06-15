package member;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentControl {
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	List<Student> students = new ArrayList<>(); // �л������� ��� �ִ� ����Ʈ
	StudentExpel studentExpel = new StudentExpel(); // ������ ������ ����ִ� Ŭ������ ��ü ����

	// �ʱⰪ
	void init_a() {
		// �̸�, ����, �й�, ���� ��
		students.add(new Student("ȫ�浿", "5", "1", "������"));
	}

	// �⺻ �޴� ��¸޼ҵ�
	String menuView() {
		System.out.println("[1. �߰�] [2. ����] [3. ����] [4. ����] [��Ÿ. ����]");
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
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(����) \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
	}

	// ���� �޼ҵ�
	void studentView() {
	//1. ��ü����, 2. �й��˻�, 3.��������, ��Ÿ. �޴�");
		System.out.println("[1. ��ü����] [2. �й��˻�] [3. ��������] [��Ÿ. ����]");
		switch (scan.nextInt()) {	
		case 1:
			for(Student data : students) {
				System.out.println(data.toString());
			}
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(��ü ����) \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
		case 2:
			System.out.print("[�й� �˻�] : ");
			int result = searchStudents(scan.next());
			if(result == -1) {
				System.out.println("�й��� �ùٸ��� �ʽ��ϴ�.");
			}else {
				System.out.println(students.get(result).toString());
			}
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(�й� �˻�)" + students.get(result).toString() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
		case 3:
			if(studentExpel.expelStudents.size() != 0) {
				for(Student data : studentExpel.expelStudents) {
					System.out.println(data.toString());
				}
				try {
					fw = new FileWriter("memberLog.txt", true);
					fw.write("(���� ���) \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}else {
				System.out.println("������ �л� ������ �����ϴ�.");
			}
		default:
			break;
		}
	}

	// �߰� �޼ҵ�
	private void addStudent() {
		System.out.print("�̸� : ");
		String name = scan.next();
		System.out.print("���� : ");
		String age = scan.next();
		String studentNum = null;
		boolean power = false;
		while(!power) {
			System.out.print("�й� : ");
			studentNum = scan.next();
			for(Student data : students) {
				if(data.getStudentNum().equals(studentNum)) {
					System.out.println("�ߺ��� �й��Դϴ�.");
					break;
				}else if(students.get(students.size()-1).equals(data)) {
					power = true;
				}
			}
		}
		System.out.print("���� : ");
		String major = scan.next();
		students.add(new Student(name, age, studentNum, major));
		System.out.println("�̸� : " + name + " ���� : " + age + " �й� : " + studentNum + " ���� : " + major + " �߰��Ǿ����ϴ�.");
		try {
			fw = new FileWriter("memberLog.txt", true);
			fw.write("(�л� �߰�)" + "�̸� : " + name + " ���� : " + age + " �й� : " + studentNum + " ���� : " + major + " �߰��Ǿ����ϴ�." + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
				if(updateStudent(index)) {
					break;
				}else {
					continue;
				}
			} else {
				System.out.println("�Էµ� �й��� ã�� ���߽��ϴ�. �ٽ� �Է����ּ���."); // �Է¿����� ���Է�
			}
		}
	}

	// �˻� �޼ҵ�(�й� ����)
	int searchStudents(String studentNum) {
		int index = -1;
		for(int i = 0; i < students.size(); i++) {
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
		System.out.print("������ �׸� ���� [1. �̸�] [2. ����] [3. �й�] [4. ����] : ");
		int sel = scan.nextInt();
		switch (sel) {
		case 1:
			System.out.println("���� �̸� : " + students.get(index).getName());
			System.out.print("������ �̸� : ");
			String name = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(�л� ����)" + " ���� �̸� : " + students.get(index).getName() + "������ �̸� : " + name + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setName(name);
			done = true;
			break;
			
		case 2:
			System.out.println("���� ���� : " + students.get(index).getAge());
			System.out.print("������ ���� : ");
			String age = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(�л� ����)" + " ���� ���� : " + students.get(index).getAge() + "������ �̸� : " + age + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setAge(age);
			done = true;
			break;
			
		case 3:
			System.out.println("���� �й� : " + students.get(index).getStudentNum());
			System.out.print("������ �й� : ");
			String studentNum = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(�л� ����)" + " ���� �й� : " + students.get(index).getStudentNum() + "������ �й� : " + studentNum + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setStudentNum(studentNum);
			done = true;
			break;
			
		case 4:
			System.out.println("���� ���� : " + students.get(index).getMajor());
			System.out.print("������ ���� : ");
			String major = scan.next();
			try {
				fw = new FileWriter("memberLog.txt", true);
				fw.write("(�л� ����)" + " ���� ���� : " + students.get(index).getName() + "������ ���� : " + major + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			students.get(index).setMajor(major);
			done = true;
			break;
			
		default:
			break;
		}
		
		return done;
	}

	// ���� �޼ҵ�
	void deleteStudent() {
		//[�л����� ����] �й��� �Է����ּ��� : 
		System.out.print("[�л����� ����] �й��� �Է����ּ��� :");
		int index = searchStudents(scan.next());
		studentExpel.addExpelStudents(students.get(index));
		try {
			fw = new FileWriter("memberLog.txt", true);
			fw.write("(�л� ����)" + students.get(index).toString() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		students.remove(index);
		System.out.println("�����Ǿ����ϴ�.");
	}

}
