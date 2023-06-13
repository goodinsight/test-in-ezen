package kr.co.dong.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl2 {
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

//	list���� �ش� ������ ����Ǿ� �ִ� index�� ã�� �޼ҵ�
//	���ȣ
	private static int selRoom(int roomNum, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrNo(); > ����Ʈ���� ���ȣ
			if (roomNum == list.get(i).getrNo()) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

	private static int selName(String roomName, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (roomName.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void person(List<Room> list) { // ����Ȯ��
		// TODO Auto-generated method stub
		System.out.print("������ �̸��� �����ּ��� : ");
		String name = sc.next();

		int name2 = selName(name, list);
		if (name2 != -1) {
			Room r = list.get(name2);
			System.out.println(r.getCustomer() + "������ " + r.getrNo() + "ȣ " + r.getrName() + " ����Ǿ� �ֽ��ϴ�");
		}
	}

	private static void revRoom(List<Room> list) { // �� ����
		// TODO Auto-generated method stub

		System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
		for (Room r : list) {
			System.out.println(r.getrNo() + "ȣ " + r.getrName() + " " + r.getrPrince() + "��");
		}
		System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");

		System.out.print("��ȣ ���� : ");
		int num = sc.nextInt();
		System.out.print("�����ڸ� �Է� : ");
		String name = sc.next();

		int num2 = selRoom(num, list);
		if (num2 != -1 && list.get(num2).isCheck() == true) {
			System.out.println(num + "ȣ�� ����Ǿ��ֽ��ϴ�");
		} else if (num2 != -1) {
			list.get(num2).setCheck(true);
			list.get(num2).setCustomer(name);
			System.out
					.println(list.get(num2).getCustomer() + "�� " + num + "ȣ " + list.get(num2).getrName() + " ����Ǿ����ϴ�");
		} else if (num2 == -1) {
			System.out.println(num + "ȣ ��ȣ�� ���� �ٽ� Ȯ��");
		}

	}

	private static void canselRoom(List<Room> list) { // �� �������
		// TODO Auto-generated method stub
		System.out.println("���� ����� �� ��ȣ �Է�");
		System.out.print("��ȣ ���� : ");
		int num = sc.nextInt();

		int num2 = selRoom(num, list);
		if (num2 != -1) {
			list.get(num2).setCheck(false);
			System.out.println(num + "ȣ ���� ���� ���");
		} else if (num2 == -1) {
			System.out.println(num + "����� ���� ���� �ٽ� Ȯ��");
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
				} else if (r.isCheck() == false) {
					System.out.println(r.getrNo() + "ȣ " + r.getrName() + " �ڿ��� ���ɡ�");
				}
			}
		} else if (sel == 2) {
			System.out.print("������ Ȯ���ϰ� ���� �� ��ȣ�� �Է� : ");
			int sel2 = sc.nextInt();

			int roomnum = selRoom(sel2, list);
			if (roomnum != -1) {
				Room r = list.get(roomnum);
				System.out.println(r.getrName() + " " + r.getrContent());
			} else if (roomnum == -1) {
				System.out.println("�� ������ Ȯ���� �� ����");
			}

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
