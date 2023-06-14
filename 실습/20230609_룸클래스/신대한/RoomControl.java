package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		ȣ�ڹ�(5��)�� ������ ���� -> List
//		
		List<Room> roomList = new ArrayList<Room>();
		boolean stop = false;
		List<Reservation> roomRes = new ArrayList<Reservation>();
		
		init(roomList);
		
		while (!stop) {
			int sel = menu();
			
			switch (sel) {
			case 1:				// �� �����ϱ�
				roomRev(roomList, roomRes);
				break;
			case 2:				// �� ���� ���
				roomCancel(roomList, roomRes);
				break;
			case 3:				// �� ��üȮ��/ ����Ȯ��
				showRoom(roomList);
				break;
			case 4:				// ������ ����Ȯ��
				showReservation(roomRes);
				break;
			case 5:
				
				stop = !stop;
			default:
				break;
			}
			
		}
	}
	
//	���� ��� �޼ҵ�
	private static void roomCancel(List<Room> roomList, List<Reservation> roomRes) {
		String name = stringChoice("��������Ͻôº��� ������ �Է����ּ���");
		int index = resIndex(roomRes, name);
		
		if(index != -1) {
			String revCode = stringChoice("�����ȣ�� �Է����ּ���");
			if(revCode.equals(roomRes.get(index).getRevCode())) {
				System.out.println("������ ��ҵǾ����ϴ�.");
				roomList.get(roomIndex(roomList, roomRes.get(index).getRoomNum())).setRoomCheck(false);;
				roomRes.remove(index);
			}else {
				System.out.println("�����ȣ�� �ٸ��ϴ� �ٽ� �Է����ּ���.");
			}
		}else {
			System.out.println("�Է��Ͻ� ���� �������ε� ������ �����ϴ�.");
		}
	}

//	�������� ������ �����ִ� �޼ҵ�
	private static void showReservation(List<Reservation> roomRes) {
		for (Reservation reservation : roomRes) {
			System.out.println(reservation.toString());
		}
		if(roomRes.size() == 0) {
			System.out.println("������ ����� �����ϴ�.");
		}
	}

//	���� �޼ҵ�
	private static void roomRev(List<Room> roomList, List<Reservation> roomRes) {
		showRoom(roomList);
		int num = choice("�����Ͻ� ȣ���� �������ּ���.");
		int index = roomIndex(roomList, num);
		if(index != -1) {
			if(roomList.get(index).isRoomCheck()) {
				System.out.println("�����Ͻ� ȣ���� �̹� ������ �Ǿ��ֽ��ϴ�.");
			}else {
				
				room(num, stringChoice("�����ں��� ������ �Է����ּ���"),ramNum() , roomRes);
				roomList.get(index).setRoomCheck(true);
				System.out.println("�����Ͻ� ȣ���� ����Ǽ̽��ϴ�.");
			}
		}else {
			System.out.println("�Է��Ͻ� ȣ���� ���� ȣ���Դϴ�.");
		}
		
	}

//	�޴� �޼ҵ�
	private static int menu() {
		System.out.println("1. �� �����ϱ� 2. �� ���� ��� 3. �� ��üȮ��/ ����Ȯ�� 4. ������ ����Ȯ��");
		return sc.nextInt();
	}

//	ȣ���� �����ִ� �޼ҵ�
	private static void showRoom(List<Room> roomList) {
		int sel = choice("1. ��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		
		if(sel == 1) {
			for (Room room : roomList) {
				System.out.println(room.toString());
			}
		}else if(sel == 2) {
			int num = choice("ȣ���� �������ּ���.");
			int index = -1;
			for (int i = 0; i < roomList.size(); i++) {
				if(num == roomList.get(i).getRoomNum()) {
					index = i;
				}
			}
			if(index != -1) {
				System.out.println(roomList.get(index));
			}else {
				System.out.println("�Է��Ͻ� ȣ���� ���� ȣ���Դϴ�.");
			}
		}else {
			System.out.println("1~2�� �������ּ���.");
			showRoom(roomList);
		}
	}

//	���� ����Ʈ�� �ʱ�ȭ ���ִ� �޼ҵ�
	private static void init(List<Room> roomList) {
		Room r1 = new Room(101, "�ҳ���", 20000, "��� ��");
		Room r2 = new Room(102, "������", 20000, "��� ��");
		Room r3 = new Room(103, "���鳪��", 20000, "��� ��");
		Room r4 = new Room(104, "������", 20000, "��� ��");
		Room r5 = new Room(105, "���೪��", 20000, "��� ��");
		
		roomList.add(r1);
		roomList.add(r2);
		roomList.add(r3);
		roomList.add(r4);
		roomList.add(r5);
	}
	
//	msg�� �����ְ� int�� ��ȯ�ϴ� �޼ҵ�
	private static int choice(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
//	msg�� �����ְ� String�� ��ȯ�ϴ� �޼ҵ�
	private static String stringChoice(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
//	�������� ������ ��� �޼ҵ�
	private static void room(int roomNum, String customer, String revCode, List<Reservation> roomRes) {
		roomRes.add(new Reservation(roomNum, customer, revCode));
	}
	
//	������ �����ȣ ������
	private static String ramNum() {
		String num = "";
		for(int i = 0; i < 6; i++) {
			num += (int)(Math.random()*10)+"";
		}
		return num;
	}
	
//	����� �Է��� ȣ���� �ִ��� �Ǵ��ϴ� �޼ҵ�
	private static int roomIndex(List<Room> roomlist, int roomNum) {
		int num = -1;
		for (int i = 0; i < roomlist.size(); i++) {
			if(roomNum == roomlist.get(i).getRoomNum()) {
				num = i;
			}
		}
		return num;
	}
	
//	������ҽ� �Է��� ����� ������ �ִ��� Ž���ϴ� �޼ҵ�
	private static int resIndex(List<Reservation> reslist, String name) {
		int index = -1;
		for(int i = 0; i < reslist.size(); i++) {
			if(name.equals(reslist.get(i).getCustomer())) {
				index = i;
			}
		}
		return index;
	}
}
