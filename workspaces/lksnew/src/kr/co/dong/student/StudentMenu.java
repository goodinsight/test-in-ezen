package kr.co.dong.student;

import java.util.Scanner;

public class StudentMenu {
	Scanner scan = new Scanner(System.in);
	StudentControl sc = new StudentControl();

	public String menuView() {
		System.out.println("========== �л� ���� ���� ==========");
		System.out.println("1.�л���ü���  2.�л��߰� 3.�л���ȸ  4.�л����� 5.�л����� 999.���� ");
		System.out.println("�޴��� ������ : ");
		return scan.nextLine();
	}

	public void menuPlay() {
		while (true) {
			String select = menuView();
			switch (select) {
			case "1":
				sc.listAll();
				break;
			case "2":
				sc.insert(add());
				break;
			case "3":
				System.out.println("1.�л����� ��ȸ 2.�л��̸� ��ȸ");
				switch (scan.nextLine()) {
				case "1":
					sc.selectOne(studentId());
					break;
				case "2":
					sc.selectOne(studentName());
					break;
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					break;
				}
				break;
			case "4":
				sc.update(studentId(), add());
				break;
			case "5":
				sc.delete(studentId());
				break;
			case "999":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("�ٽ� ��� �ּ���. ");
				break;
			}
		}
	}

	private StudentBean add() {
//		�л� ���� �߰�/���� �Է¹޴� �޼ҵ�
		System.out.println("�л� �̸��� �Է� :");
		String name = scan.nextLine();
		System.out.println("�л� ���̸� �Է� :");
		int age = Integer.parseInt(scan.nextLine());
		System.out.println("�л� �й��� �Է� : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println("�л� ������ �Է� : ");
		String major = scan.nextLine();

		StudentBean sb = new StudentBean(name, age, num, major);

		return sb;
	}

	private int studentId() {
		System.out.println("��ȸ/�����Ͻ� �л� ������ �Է� : ");
		return Integer.parseInt(scan.nextLine());
	}

	private String studentName() {
		System.out.println("��ȸ�Ͻ� �л� �̸��� �Է� : ");
		return scan.nextLine();
	}
}
