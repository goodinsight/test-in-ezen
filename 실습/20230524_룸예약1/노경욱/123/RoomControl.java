package room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		ȣ���� �� ������ �ʱ�ȭ �ϰ� ����
		init(list);

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
				break;

			default:
				break;

			}
		}
//		ȣ���� �� ������ �ʱ�ȭ
		Room r1 = new Room(101, "�ҳ���", 20000, "1�� ��� ��");
		Room r2 = new Room(102, "������", 20000, "2�� ��� ��");
		Room r3 = new Room(103, "���鳪��", 20000, "3�� ��� ��");
		Room r4 = new Room(104, "������", 20000, "4�� ��� ��");
		Room r5 = new Room(105, "���೪��", 20000, "5�� ��� ��");

//		�� ����
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1. �濹�� 2. �� ������� 3. ����üȮ��, ����Ȯ��, ������ ���� Ȯ�� 0. ����");
		int sel = scan.nextInt();
		return sel;
	}

	private static void roomRev(List<Room> list) {
		// TODO Auto-generated method stub

	}

	private static void censelRoom(List<Room> list) {
		// TODO Auto-generated method stub

	}

	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1. ��üȣ��Ȯ�� 2. ����ȣ��Ȯ��");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			System.out.print("������ ȣ���� �Է��� �ּ���");
			int takeho = scan.nextInt();
			if (takeho == 1) {
			} else if (takeho == 2) {

			} else if (takeho == 3) {

			} else if (takeho == 4) {

			} else {

			}

		}

	}
}
