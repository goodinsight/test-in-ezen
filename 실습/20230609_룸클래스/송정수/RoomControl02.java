package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl02 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List

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
			case 2: // �� �������
				cancelRoom(list);
				break;
			case 3: // �� ��üȮ�� / ����Ȯ��
				printRoom(list);
				break;
			case 4: // ������ ����Ȯ��
				infoCheck(list);
				break;
			default:

			}
		}
	}
//	������ ����Ȯ�� �޼ҵ� �Դϴ�
	private static void infoCheck(List<Room> list) {
		List<Integer> indexlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCustomer() != null) {
				System.out.println("ȣ�� : "+list.get(i).getrNo()+" �����ڸ� : "+list.get(i).getCustomer()+" �����ȣ : "+list.get(i).getRevCode());
				indexlist.add(i);
			}
		}
		if(indexlist.size() == 0) {
			System.out.println("�����Ͻ� ����� �����");
		}
	}
//	������� �޼ҵ� �Դϴ�
	private static void cancelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		int sel = choice("����� ȣ���� �Է��ϼ��� : ");
		if(list.size() < sel%10) {
			System.out.println("���� ȣ���Դϴ�.");
		}
		if(list.get(sel%10-1).getrNo() != sel) {
			System.out.println("�Է��Ͻ� ȣ���� �ٸ��ϴ�.");
		}else {
			String name = stringChoice("������ ������ �Է��ϼ��� : ");
			if(!list.get(sel%10-1).getCustomer().equals(name)) {
				System.out.println("������ ������ �ٽ� �ѹ� Ȯ�����ּ���.");
			}else {
				String num = stringChoice("���� �ڵ带 �Է����ּ��� : ");
				if(!list.get(sel%10-1).getRevCode().equals(num)) {
					System.out.println("���� �ڵ尡 �ٸ��ϴ�. �ٽ� Ȯ�����ּ���.");
				}else {
					System.out.println("������ ��ҵǾ����ϴ�.");
					list.get(sel%10-1).setCheck(false);
					list.get(sel%10-1).setCustomer(null);;
					list.get(sel%10-1).setRevCode(null);;
				}
			}
		}
		
		
	}
//	�����ϴ� �޼ҵ� �Դϴ�
	private static void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
//		printRoom(list);
		for(Room r : list) {
			System.out.println(r);
		}
		int sel = choice("���ϴ� ȣ���� �Է��ϼ��� : ");
		if(list.size() < sel%10) {
			System.out.println("���� ȣ���Դϴ�.");
		}else {
			if(list.get(sel%10-1).getrNo() != sel || list.get(sel%10-1).isCheck() == true) {
				System.out.println("�̹� ����� ȣ���̰ų� �߸��� ȣ���� �Է��ϼ̽��ϴ�.");
			}else {
				String name = stringChoice("������ ������ �Է����ּ��� : ");
				list.get(sel%10-1).setCustomer(name);
				int num = (int)(Math.random() *100) +1;
				System.out.println("�����ڵ� : "+num);
				list.get(sel%10-1).setRevCode(num+"");
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				list.get(sel%10-1).setCheck(true);
			}
			
		}
	}

	//	�� ��üȮ�� �޼ҵ��Դϴ�
	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		int sel = choice("���ϴ� ��ȣ�� �Է��ϼ��� : ");
		if(sel == 1) {
			for(Room r : list) {
				System.out.println(r);
			}
		}else if(sel == 2) {
			sel = choice("Ȯ���Ͻ� ȣ���� �Է��ϼ��� : ");
			if(sel%10 > list.size()) {
				System.out.println("���� ȣ���Դϴ�.");
			}
			if(list.get(sel%10-1).getrNo() == sel) {
				String mark = "";
				if(list.get(sel%10-1).isCheck() == false) {
					mark = "���డ��";
				}else {
					mark = "���� �Ұ���";
				}
				System.out.println("ȣ�� : "+list.get(sel%10-1).getrNo()+" ���̸� : "+list.get(sel%10-1).getrName()+" ���� : "+list.get(sel%10-1).getRprice()+" ���࿩�� : "+mark);
			}
		}
	}

//	msg ������ int.scan���� ��ȯ
	private static int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//	msg ������ String.scan���� ��ȯ
	private static String stringChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("=====ȣ�� �޴�=====");
		System.out.println("1.�����ϱ� 2.������� 3.���࿩��Ȯ�� 4.����������Ȯ��");
		return choice("���ϴ� ��ȣ�� �Է��ϼ��� : ");
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101, "�ҳ���", 20000, "ħ��1��");
		Room r2 = new Room(102, "������", 20000, "ħ��1��");
		Room r3 = new Room(103, "���鳪��", 40000, "ħ��2��");
		Room r4 = new Room(104, "������", 40000, "ħ��2��");
		Room r5 = new Room(105, "���೪��", 50000, "ħ��3��");

//		�� ����
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

}
