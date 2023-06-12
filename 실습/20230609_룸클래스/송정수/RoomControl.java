package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List
		
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
		
//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		init(list);
		
		while(!stop) {
			int sel = menu();
			
			switch(sel) {
			case 1:		//�� �����ϱ�
				revRoom(list);
				break;
			case 2:		//�� �������
				cancelRoom(list);
				break;
			case 3:		//�� ��üȮ�� / ����Ȯ��
				printRoom(list);
				break;
			case 4:		//������ ����Ȯ��
				infoCheck(list);
				break;
			default :
					
			}
		}
		
		
//		list.add(new Room(101, "�ҳ���", 20000, "��� ��"));
		
	}

	private static void infoCheck(List<Room> list) {	//������ ����Ȯ��
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCustomer() != null) {
				System.out.println("ȣ�� : "+list.get(i).getrNo()+" ���� :"+list.get(i).getCustomer()+" �����ȣ :"+list.get(i).getRevCode());
				
			}
			
		}
		
	}

	private static void cancelRoom(List<Room> list) {	//�������
		// TODO Auto-generated method stub
		System.out.println("���� ����Ͻ� ȣ���� �Է����ּ��� : ");
		int sel = scan.nextInt();
		if(list.get(sel%10-1).getrNo() != sel || list.get(sel%10-1).isCheck() == false) {
			System.out.println("�Է��Ͻ� ȣ���� �ٸ��ų� ������ �Ǿ����� �ʽ��ϴ�.");
		}else {
			System.out.println("������ ������ �Է����ּ��� : ");
			scan.nextLine();
			String name = scan.nextLine();
			if(!list.get(sel%10-1).getCustomer().equals(name)) {
				System.out.println("������ ������ ���� �ʽ��ϴ�.");
			}else {
				System.out.println("���� �ڵ带 �Է����ּ��� : ");
				String num = scan.next();
				if(!list.get(sel%10-1).getRevCode().equals(num)) {
					System.out.println("�����ڵ尡 �����ʽ��ϴ�.");
				}else {
					System.out.println("������ ��ҵǾ����ϴ�.");
					list.get(sel%10-1).setCustomer(null);
					list.get(sel%10-1).setRevCode(null);;
					list.get(sel%10-1).setCheck(false);;
				}
			}
		}
		
	}

	private static void revRoom(List<Room> list) {	//�����ϱ�
		// TODO Auto-generated method stub
		printRoom(list);
		System.out.println("���ϴ� ȣ���� �Է��ϼ��� : ");
		int sel = scan.nextInt();
		if(list.size() < sel%10) {
			System.out.println("���� ȣ���Դϴ�.");
		}else {
			if(sel == list.get(sel%10-1).getrNo() ) {
				if(list.get(sel%10-1).isCheck() == true) {
					System.out.println("�̹� ����� ���Դϴ�.");
				}else {
					System.out.println("������ ������ �Է��ϼ��� : ");
					scan.nextLine();
					String name = scan.nextLine();
					list.get(sel%10-1).setCustomer(name);
					int num = (int)(Math.random() * 100) +1;
					System.out.println(num);
					System.out.println("�����ڵ� : "+num);
					list.get(sel%10-1).setRevCode(num+"");
					System.out.println("����Ϸ�");
					list.get(sel%10-1).setCheck(true);
				}
			}
		}
		
		
	}

	private static int menu() {	//ȣ�� �޴�
		// TODO Auto-generated method stub
		System.out.println("=====ȣ�� �޴�=====");
		System.out.println("1.�����ϱ� 2.������� 3.���࿩��Ȯ�� 4.������ ����Ȯ��");
		System.out.println("���ϴ� ��ȣ�� �Է��ϼ��� : ");
		return scan.nextInt();
	}

	private static void printRoom(List<Room> list) {	//���࿩��Ȯ��
		// TODO Auto-generated method stub
		System.out.println("1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			for(Room r : list) {
				System.out.println(r);
			}
		}else if(sel == 2) {
			System.out.println("Ȯ���� ȣ�� �Է� : ");
			sel = scan.nextInt();
			if(list.size() < sel%10) {
				System.out.println("���� ȣ���Դϴ�.");
			}
			else if(list.get(sel%10-1).getrNo() == sel ) {
				System.out.println("ȣ�� : "+list.get(sel%10-1).getrNo()+" �漳�� : "+list.get(sel%10-1).getrdescription()+" ���� : "+list.get(sel%10-1).getRprice()+" ���࿩�� : "+list.get(sel%10-1).isCheck());
			}
		}
	}

	private static void init(List<Room> list) {	//�� ����
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
