package kr.co.dong.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

//		ȣ�ڷ��� ������ ���� > list

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		ȣ���� �� ������ �ʱ�ȭ
		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1:// �� ����
				revRoom(list);
				break;
			case 2:// �� �������
				canselRoom(list);
				break;
			case 3:// �� ��üȮ��
				printRoom(list);
				break;
			case 4:// ������ ����Ȯ��
				person(list);
				break;

			default:
				System.out.println("�ٽ� �Է��ϼ���");
				break;
			}

		}

	}

	private static void person(List<Room> list) { // ����Ȯ��
		// TODO Auto-generated method stub
		
		System.out.println("���� ������ Ȯ�� �մϴ�");
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		String name = sc.next();

		for (int i = 0; i < list.size(); i++) {
			Room r = list.get(i);
			if (name.equals(r.getCustomer())) {
				System.out.println(r.getCustomer() + "������ " + r.getrNo() + "ȣ " + r.getrName() + " ����Ǿ��ֽ��ϴ�");
				System.out.println("�����ȣ�� " + r.getRevCode() + " �Դϴ�");
				break;
			} else if (!name.equals(r.getCustomer())) {
				System.out.println("�����ڸ��� �ٽ� �Է��ϼ���");
				break;
			}
		}
	}

	private static void revRoom(List<Room> list) { // �� ����
		// TODO Auto-generated method stub
//		for (int i = 0; i < list.size(); i++) {
//			Room r = list.get(i);
//			System.out.println(r.getrNo() + "ȣ " + r.getrName() + " " + r.getrPrince() + "�� ");
//		}
		
		for(Room r : list) {
			System.out.println(r);
		}

		System.out.println("������ �� ��ȣ�� �������ּ���");
		System.out.print("Choice : ");
		int sel = sc.nextInt();
		System.out.print("�����ڸ��� �Է����ּ��� : ");
		String name = sc.next();

		switch (sel) {
		case 101:
		case 102:
		case 103:
		case 104:
		case 105:
			for (int i = 0; i < list.size(); i++) {
				Room r = list.get(i);
				if (r.getrNo() == sel && r.isCheck() == false) {
					int rd = ((int) (Math.random() * 9999) + 1000);
					r.setCheck(true);
					r.setCustomer(name);
					r.setRevCode(Integer.toString(rd));
					System.out.println("�����ڵ� " + r.getRevCode() + " " + r.getrNo() + "ȣ " + r.getrName() + " ����Ǿ����ϴ�");
					System.out.println(r.getCustomer() + "�� �����մϴ�");
//					System.out.println(r.isCheck());
				} else if (r.getrNo() == sel && r.isCheck() == true) {
					System.out.println(r.getrNo() + "ȣ " + r.getrName() + " ���� �Ұ��Դϴ�");
				}
			}
			break;

		default:
			System.out.println("�� ��ȣ�� �ٽ� �Է��ϼ���");
			break;
		}

	}

	private static void canselRoom(List<Room> list) { // �� �������
		// TODO Auto-generated method stub
		System.out.println("���� ����� �� ��ȣ�� �������ּ���");
		System.out.print("Choice : ");
		int sel = sc.nextInt();
		System.out.print("�����ڸ��� �Է����ּ��� : ");
		String name = sc.next();

		for (int i = 0; i < list.size(); i++) {
			Room r = list.get(i);
			if (r.getrNo() == sel && r.isCheck() == true && r.getCustomer() == name) {
				r.setCheck(false);
				r.setCustomer(null);
				r.setRevCode(null);
				System.out.println(r.getrNo() + "ȣ " + r.getrName() + " ���� ��ҵǾ����ϴ�");
//				System.out.println(r.isCheck());
			} else if (r.getrNo() == sel && r.isCheck() == false && r.getCustomer() == name) {
				System.out.println("�̹� ���� ��ҵǾ��ų� Ȯ���� �� �����ϴ�");
			}
		}

	}

	private static void printRoom(List<Room> list) { // �� Ȯ��
		// TODO Auto-generated method stub
		System.out.println("1) ��ü ȣ��Ȯ��");
		System.out.println("2) ���� ȣ��Ȯ��");
		System.out.print("Choice : ");
		int sel = sc.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				if (r.isCheck() == true) {
					System.out.println(r.getrNo() + "ȣ " + r.getrName() + " �ٿ��� �Ұ���");
				} else {
					System.out.println(r.getrNo() + "ȣ " + r.getrName() + " �ڿ��� ���ɡ�");
				}
			}
		} else if (sel == 2) {

		} else {
			System.out.println("�ٽ� �������ּ���");
		}

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1) �� �����ϱ�");
		System.out.println("2) �� �������");
		System.out.println("3) �� ��üȮ��");
		System.out.println("4) ������ ����Ȯ��");
		System.out.print("Choice : ");
		return sc.nextInt();
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r = new Room(101, "�ҳ�����", 50000, "1 ��");
		Room r2 = new Room(102, "��������", 100000, "2 ��");
		Room r3 = new Room(103, "���鳪����", 70000, "3 ��");
		Room r4 = new Room(104, "��������", 60000, "4 ��");
		Room r5 = new Room(105, "���೪����", 40000, "5 ��");

//		�� ����

//		list.add(new Room(101, "�ҳ�����", 50000, "1 ��"));
		list.add(r);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}
}
