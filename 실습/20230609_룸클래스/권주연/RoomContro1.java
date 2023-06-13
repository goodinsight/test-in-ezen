package kr.co.dong.room;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.ListenerNotFoundException;

public class RoomContro1 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List
//		
		List<Room> list = new ArrayList<Room>();
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
				inforRoom(list);

				break;

			case 99: // ����
				break;

			default:
			}

		}

	}


	//	0�� �� �޴� �����ֱ�
	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("=========================================================");
		System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�  Menu  �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
		System.out.println("�� 1. �� ���� 2. ���� ��� 3. ȣ�� Ȯ�� 4. ������ ����Ȯ�� 99. ����");
		System.out.println("=========================================================");
		System.out.println("���Ͻô� �޴���ȣ�� �Է��ϼ��� : ");
		return scan.nextInt();
	}

//	list ���� �ش� ������ ����Ǿ� �ִ� index�� ã�� �޼ҵ�
//	�� ��ȣ�� ã����? �� �̸����� ã����?
//	1) ���̸����� ã�� ��
	static int findRoom(String name, List<Room> list) { // ã������ ���̸�, ã������ ����Ʈ
		int index = -1; // (���� ��ġ, ������ �𸦶���, ������ -1) �ε����� ������ 0~��������, -1�� ������ ���ϴ� ���� ������ ����������� ��

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if (name.equals(list.get(i).getrName())) {
				index = i; 
//				return index; �� ���⿡ ������ berak, �ؿ� return ��� ��.
				break;
			}
		}
		return index; // ��ã���� return
	}

//	2) �� ��ȣ�� ã�� ��
	static int findNo(int no, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (no == list.get(i).getrNo()) { // int = ���ڴϱ� equals �� �ƴ϶� ==�� ��
				index = i;
				break;
			}
		}
		return index;
	}

//	1�� �� �� �����ϱ�
	private static void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
		int revCode = 0;
		System.out.println("�����Ͻô� Room�� �������ּ��� (101~105) : ");
		int sel = scan.nextInt();
		if(findNo(sel, list) == -1) {
			System.out.println("���� ���Դϴ�.");
		}else {
			System.out.println(list.get(findNo(sel, list)));
			System.out.println("������ ������ ���Դϴ�. ");
			System.out.println("������ ������ �Է����ּ���. : ");
			String customer = scan.next();
			
			for(int i = 0 ; i < 1 ; i++) {
				revCode = (int)(Math.random() * 9999) + 1000;
				for(int j = 0; j <list.size(); j++) { // �����ȣ �ߺ� ����
					if(revCode == list.size()) {
						i--; // ��ȣ�� �ߺ��Ǹ� i-
						break; // �ߺ������� �� ���ư��� �ʰ� break
					}
				}
			}
			System.out.println("�� �����ȣ: " + revCode );		
		}
	}


//	2�� �� ���� ����ϱ� 
	private static void canselRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("�����Ͻ� ���� �Է����ּ��� : ");
		int sel = scan.nextInt();
		if(findNo(sel, list) == -1) {
			System.out.println("���� ���Դϴ�.");
		} break;
		
		for(int i = 0; i<list.size(); i++) {
			String revCode = null;
			String customer = null;
			if(customer == list.get(i).getCustomer()) {	
				System.out.println("������ �̸��� �Է����ּ��� : ");
				String check =scan.next();
				if(revCode == list.get(i).getRevCode()) {
					System.out.println("�����ȣ�� �Է����ּ���: ");
					String check1 = scan.next();
				} else if(revCode != list.get(i).getRevCode())
					System.out.println("Ȯ�ε��� �ʴ� �����ȣ�Դϴ�. �ٽ� �Է����ּ���"); 
			} else if(customer != list.get(i).getCustomer()){
				System.out.println("Ȯ�ε��� �ʴ� �������Դϴ�. �ٽ� �Է����ּ���.");
			}
			break;
		} System.out.println("������ ����մϴ�.");
	}


		



//	3�� �� ȣ��Ȯ��
	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("============================================================");
		System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�  Menu  �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
		System.out.println("�� 1.��üȣ�� Ȯ�� 2. ����ȣ�� ��ȣ�� Ȯ�� 3. ����ȣ�� ���̸����� Ȯ��" );
		System.out.println("============================================================");
		System.out.println("���Ͻô� �޴���ȣ�� �Է��ϼ��� : ");

		int sel = scan.nextInt();

		if (sel == 1) { // ��üȣ�� Ȯ��
			for (Room r : list) { // ���� for��
//				for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				System.out.println(r);
			}
			
		} else if (sel == 2) { // ���� ȣ�� ��ȣ�� Ȯ��
			System.out.println("�����Ͻ� ȣ�� ��ȣ�� �Է����ּ��� : ex)101~105");
			int check = scan.nextInt();
			
			if(findNo(check,list) == -1) { // �ε����� -1�̸� ���ϴ� ���� �����ϱ� ���¹�ȣ�� ���
				System.out.println("���� ��ȣ�Դϴ�.");
			}else{
				System.out.println(list.get(findNo(check,list))); // ���ϴ� ���� �ε��� ��ȣ�� ������ ���
			}
			
		} else if(sel == 3) { // ����ȣ�� ���̸����� Ȯ��
			System.out.println("���Ͻô� �� �̸��� �Է����ּ��� : ex) �ҳ���");
			String check = scan.next();
			
			if(findRoom(check, list) == -1) {
				System.out.println("���� ���Դϴ�.");
			}else {
				System.out.println(list.get(findRoom(check, list)));
			}
		}
	}

//	4�� �� ������ ���� Ȯ��	
	private static void inforRoom(List<Room> list) {
		// TODO Auto-generated method stub
		
	}
//	3�� ȣ��Ȯ�� �ڵ� ���̱� ��
//			int count = 0;
//
//			for (int i = 0; i < list.size(); i++) {
//				if (check == list.get(i).getrNo()) {
//					System.out.println(list.get(i));// list.size()=list.get(i)..?
//					break;
//				} else {
//					count++;
//				}
//				
//			}
//			if(count == list.size()) {
//				System.out.println("���� ��ȣ�Դϴ�.");
//			}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101, "�ҳ���", 20000, "��� ��");
		Room r2 = new Room(102, "������", 20000, "��� ��");
		Room r3 = new Room(103, "���鳪��", 20000, "��� ��");
		Room r4 = new Room(104, "������", 20000, "��� ��");
		Room r5 = new Room(105, "���೪��", 20000, "��� ��");

//		�� ����
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

}
