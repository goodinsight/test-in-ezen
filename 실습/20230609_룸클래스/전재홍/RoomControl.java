package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List

		RoomFunc rf = new RoomFunc();
		List<Room> list = new ArrayList<Room>();
		List<RoomFunc> func = new ArrayList<RoomFunc>();
		boolean stop = false;

//		ȣ���� �� ������ �ʱ�ȭ �ϰ� ����
		init(list);

		while (!stop) {
			int sel = rf.menu();

			switch (sel) {
			case 0:
				System.out.println("�����մϴ�");
				stop = true;
			case 1: // �濹��
				rf.roomRev(list);
				break;
			case 2: // �� ���� ���
				rf.roomCan(list);
				break;
			case 3: // �� ��ü Ȯ��, ����Ȯ��
				rf.roomChck(list);
				break;
			case 4: // ������ ���� Ȯ��
				rf.nameChck(list);
				break;

			default:
				break;

			}
		}

	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
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



}

