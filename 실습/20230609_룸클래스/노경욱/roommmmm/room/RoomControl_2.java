package room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import reportt.room_V2;

public class RoomControl_2 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
//		ȣ���� �� ������ �ʱ�ȭ �ϰ� ����
		init(list);

//		ȣ���� �� ������ �ʱ�ȭ
		Room r1 = new Room(101, "�ҳ���", 20000, "1��", false);
		Room r2 = new Room(102, "������", 20000, "2��", false);
		Room r3 = new Room(103, "���鳪��", 20000, "3��", false);
		Room r4 = new Room(104, "������", 20000, "4��", false);
		Room r5 = new Room(105, "���೪��", 20000, "5��", false);

//		�� ����
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

		while (!stop) {
			int sel = menu();
			switch (sel) {
			case 0:
				System.out.println("�����մϴ�");
				stop = true;
			case 1: // �濹��
				roomRev(list);
				break;
			case 2: // �� ���� ���
				censelRoom(list);
				break;
			case 3: // �� ��ü Ȯ��, ����Ȯ��
				printRoom(list);
				break;
			case 4: // ������ ���� Ȯ��
				checkPeople(list);
				break;
			case 77:
				godmodd(list);
				break;
			default:
				System.out.println("�ùٸ��� ���� ����Դϴ�.");
				break;
			}
		}

	}

	private static void godmodd(List<Room> list) {
		// TODO Auto-generated method stub
		boolean power = true;
		while (power) {
			System.out.println("�����ڸ�� ������");
			System.out.println("1. ȣ��Ȯ�� 2. ȣ���߰� 3. ȣ�ǻ���");
			int sel = scan.nextInt();
			switch (sel) {
			case 1:
				printRoom(list);
				break;
			case 2:
				addRoom(list);
				break;
			case 3:
				removeRoom(list);
				break;
			case 99:
				power = false;
				break;
			}
		}
	}

	private static void removeRoom(List<Room> list) {
		System.out.println("������ ���� �����մϴ�");

	}

	private static void addRoom(List<Room> list) {
		System.out.println("���� �߰��մϴ�");
		System.out.println("���: (101,\"�ҳ���\",20000,\"1��\",�����Ȳ(true,false))");
		String add = scan.next();
		String[] ad = add.split(",");
		for (int i = 0; i < ad.length; i++) {
			list.add(ad[i]);
		}

	}

	// list���� �ش� ������ ����Ǿ� �ִ� index�� ã�� �޼ҵ�
//	���̸����� �� ã��
	static int findRoom(List<Room> list) {
		String name = scan.next();
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ ���� ���̸�
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
			}
		}
		return index;
	}

//	��ѹ����� �� ã��
	static int findRoomNumber(List<Room> list) {
		System.out.print("Ȯ��/������ ȣ���� �Է��� �ּ��� (����: 101)\n");
		int roomNumber = scan.nextInt();
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (roomNumber == (list.get(i).getrNo())) {
				index = i;
				break;
			}
		}

		return index;
	}

	private static void checkPeople(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("Ȯ���� ���ȣ�� �Է��� �ּ��� (����: 101)");
		Room r = list.get(findRoomNumber(list));
		if (r.isRcheck() == true) {
			System.out.println(r.getCustomer() + "���� �����ϼ̽��ϴ�");
		} else if (r.isRcheck() == false) {
			System.out.println(r.getrNo() + "ȣ�� ����Ǿ������ʽ��ϴ�");
		} else {
			System.out.println("�ùٸ��� ���� ����Դϴ�.");
		}
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1. �濹�� 2. �� ������� 3. ����üȮ��, ����Ȯ��, 4. ������ ���� Ȯ�� 0. ����");
		int sel = scan.nextInt();
		return sel;
	}

	private static void roomRev(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("������ ���ȣ�Է��� �ּ��� (����: 101)");
		Room r = list.get(findRoomNumber(list));
		System.out.println("������ �Է��� �ּ���");
		String tmp2 = scan.next();
		r.setCustomer(tmp2);
		System.out.println(r.getrNo() + "ȣ ����Ǿ����ϴ�");
		r.setrcheck(true);
	}

	private static void censelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("��������� ���ȣ�Է��� �ּ��� (����: 101)");
		Room r = list.get(findRoomNumber(list));
		if (r.isRcheck() == true) {
			r.setrcheck(false);
			System.out.println(r.getrNo() + "ȣ ���� ��ҵǾ����ϴ�");
		} else if (r.isRcheck() == false) {
			System.out.println(r.getrNo() + "ȣ�� ����Ǿ������ʽ��ϴ�");
		} else {
			System.out.println("�ùٸ��� ���� ����Դϴ�.");
		}
	}

	private static void printRoom(List<Room> list) {
		System.out.println("1. ��üȣ��Ȯ�� 2. ����ȣ��Ȯ��");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(
						r.getrNo() + "ȣ\n�̸�: " + r.getrName() + "\n����: " + r.getrPrice() + "\nƯ¡: " + r.getrContent());
				if (r.isRcheck() == true) {
					System.out.println("����Ǿ����ϴ�");
					System.out.println("�����ڸ�: " + r.getCustomer());

				} else {
					System.out.println("����Ǿ������ʽ��ϴ�");
				}
				System.out.println();
			}
		} else if (sel == 2) {
			Room r = list.get(findRoomNumber(list));
//			              get(index��°�� �޾ƿ���)
			System.out.println(
					r.getrNo() + "ȣ\n�̸�: " + r.getrName() + "\n����: " + r.getrPrice() + "\nƯ¡: " + r.getrContent());
			if (r.isRcheck() == true) {
				System.out.println("����Ǿ����ϴ�");
				System.out.println("�����ڸ�: " + r.getCustomer());
			} else {
				System.out.println("����Ǿ������ʽ��ϴ�");
			}
		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
		}
	}
}
