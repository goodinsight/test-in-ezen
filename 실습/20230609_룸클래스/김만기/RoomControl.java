package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List
//		
		List<Room> list = new ArrayList<Room>(5);
		boolean stop = false;

//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		init(list);
		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1: // �� �����ϱ�
				revRoom(list);
				break;
			case 2: // �� ���� ���
				canselRoom(list);
				break;
			case 3: // �� ��üȮ�� / ����Ȯ��
				printRoom(list);
				break;
			case 4: // ������ ����Ȯ��
				revInformation(list);
				break;
			case 99: // ���α׷� ����
				System.out.println("���α׷��� �����մϴ�.");
				stop = !stop;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	static int findRoom(String name, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

	static int findRoom(int rNo, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (rNo == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void revInformation(List<Room> list) {
		System.out.println("������ �Է����ּ���.");
		String input = scan.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer().equals(input)) {
				System.out.println("�����ȣ�� �Է����ּ���");
				for (int j = 0; j < list.size(); j++) {
					input = scan.next();
					if (list.get(j).getRevCode().equals(input)) {
						System.out.println("���������Դϴ�");
						System.out.println(list.get(j));
						return;
					} else {
						System.out.println("�����ȣ�� Ʋ�Ƚ��ϴ�.");
						return;
					}
				}
			} else {
				System.out.println("����� ���� �����ϴ�.");
				return;
			}
		}
	}

	private static int menu() {
		System.out.println("�޴�");
		System.out.println("ȣ�� ���� ���α׷�");
		System.out.println("1.�����ϱ� 2.��������ϱ� 3.����üȮ��/����Ȯ�� 4.����������Ȯ�� 99.���α׷� ����");
		return scan.nextInt();
	}

	private static void revRoom(List<Room> list) {
		int i = revOrCansel(list, "����");
		String name = scan.next();
		list.get(i).setCustomer(name);
		String revNum = String.valueOf((int) (Math.random() * 888888) + 111111);
		list.get(i).setRevCode(revNum);
		list.get(i).setCheck(true);
		System.out.println(list.get(i) + "\n������ �Ϸ�Ǿ����ϴ�");
	}

	private static void canselRoom(List<Room> list) {
		int i = revOrCansel(list, "�������");
		String input = scan.next();
		if (list.get(i).getCustomer().equals(input)) {
			System.out.println("�����ȣ�� �Է����ּ���.");
			input = scan.next();
			if (list.get(i).getRevCode().equals(input)) {
				System.out.println(list.get(i) + "\n������ ��ҵǾ����ϴ�");
				list.get(i).setCustomer(null);
				list.get(i).setCheck(false);
			} else {
				System.out.println("�����ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		} else {
			System.out.println("����� ���� �����ϴ�.");
		}
	}

	private static int revOrCansel(List<Room> list, String string) {
		System.out.println(string + "�Ͻ� ȣ���� �Է����ּ���");
		int sel = scan.nextInt();
		int i = findRoom(sel, list);
		if (i > 4) {
			System.out.println("�߸��� �Է��Դϴ�.");
			revOrCansel(list, string);
		} else {
			System.out.println("������ �Է����ּ���.");
		}
		return i;
	}

	private static void printRoom(List<Room> list) {
		System.out.println("1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			System.out.println("ȣ���� �������ּ���.");
			sel = scan.nextInt();
			int i = findRoom(sel, list);
			if (i > 4) {
				System.out.println("�߸��� �Է��Դϴ�.");
			} else {
				System.out.println(list.get(i));
			}

		}

	}

	private static void init(List<Room> list) {
		Room r1 = new Room(101, "������", 20000, "���� ��");
		Room r2 = new Room(102, "��������", 20000, "���� ���� ��");
		Room r3 = new Room(103, "�ſ�������", 20000, "�ſ� ���� ��");
		Room r4 = new Room(104, "��������", 20000, "�� ���� ��");
		Room r5 = new Room(105, "¯������", 20000, "¯ ���� ��");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}

}
