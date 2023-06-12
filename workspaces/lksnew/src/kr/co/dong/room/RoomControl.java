package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		List<Room> list = new ArrayList<>();
		boolean stop = false;
		
		
		
//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		init(list);
		
		while(!stop) {
			int sel = menu();
			
			switch (sel) {
			case 1:	// �� �����ϱ�
				revRoom(list);
				break;
			case 2:	// �� ���� ���
				cancelRoom(list);
				break;
			case 3:	// �� ��üȮ�� / ����Ȯ��
				printRoom(list);
				break;
			case 4: // ������ ����Ȯ��
				inforCustomer(list);
				break;

			default:
				
				break;
			}
		}
	}

	private static void inforCustomer(List<Room> list) {
		try {
			int sel = inpuM("������ ������ ���Ͻô� �� ȣ���� �Է��ϼ��� : ");
			System.out.println(sel+"ȣ���� �����ڸ� : " + list.get(sel-101).getCustomer() + ", �����ڵ� : " + list.get(sel-101).getRevCode() + " �Դϴ�.");
		}catch(Exception e){
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
		
	}

	private static void cancelRoom(List<Room> list) {
		try {
			int sel = inpuM("������� �ϰ��� �ϴ� �� ȣ���� �Է��ϼ��� : ");
			if(list.get(sel-101).isCheck() == true) {
				System.out.println(sel+"ȣ���� ������Ұ� �����մϴ�.");
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				if(list.get(sel-101).getCustomer().equals(scan.next())) {
					System.out.println("���� �ڵ带 �Է��ϼ��� : ");
					if(list.get(sel-101).getRevCode().equals(scan.next())) {
						list.get(sel-101).setCheck(false);
						System.out.println(sel+"ȣ���� ������ ��ҵǾ����ϴ�.");
					}else {
						System.out.println("�����ڵ尡 Ʋ���ϴ�.");
					}
					
				}else {
					System.out.println("������ ���� Ʋ���ϴ�.");
				}
					
			}else {
				System.out.println("������ �Ǿ����� �ʾ� ������Ұ� �Ұ��մϴ�.");
			}
		}catch(Exception e){
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
		
	}

	private static void revRoom(List<Room> list) {
		try {
			int sel = inpuM("�����ϰ��� �ϴ� �� ȣ���� �Է��ϼ��� : ");
			if(list.get(sel-101).isCheck() == false) {
				System.out.println(sel+"ȣ���� ������ �����մϴ�.");
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				list.get(sel-101).setCustomer(scan.next());
				System.out.println("���� �ڵ带 �Է��ϼ���(������ҽ� �ʿ�) : ");
				list.get(sel-101).setRevCode(scan.next());
				list.get(sel-101).setCheck(true);
				System.out.println(sel+"ȣ���� ������ : "+list.get(sel-101).getCustomer()+", ���� �ڵ� : "+list.get(sel-101).getRevCode()+" ��  ���� �Ǿ����ϴ�.");
			}else {
				System.out.println("������ �Ұ��մϴ�.");
			}
		}catch(Exception e){
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
		
	}

	private static int menu() {
		System.out.println("========================================================");
		System.out.println("1. �濹���ϱ� 2. �� ���� ��� 3. �� ��üȮ��/����Ȯ�� 4. ������ ����Ȯ��");
		System.out.println("========================================================");
		int sel;
		try {
			sel = inpuM("�޴��� �����ϼ��� : ");
			return sel;
		}catch(Exception e) {
			System.out.println("�޴��� ����� �Է��ϼ���");
			scan.nextLine();
			return 0;
		}
	}

	private static int inpuM(String string) {
		System.out.println(string);
		try{
			int r = scan.nextInt();
			return r;
		}catch(Exception e) {
			System.out.println("���ڷ� �Է��ϼ���");
			scan.nextLine();
			return 0;
		}
		
	}

	private static void printRoom(List<Room> list) {
		try {
			int sel = inpuM("1. ��üȣ�� Ȯ�� 2. ����ȣ�� Ȯ��");
		
			if(sel == 1) {
				for(Room r : list) {
					System.out.println(r);
				}
			}else if(sel == 2) {
				int r = inpuM("Ȯ���Ͻ� ���� ȣ���� �Է��ϼ��� : ");
				System.out.println(list.get(r-101));
			}else {
				System.out.println("�޴��� ����� �Է��ϼ���");
			}
		}catch(Exception e) {
			System.out.println("�޴��� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		list.add(new Room(101, "�ҳ��� ", 20000, "��� ��"));
		list.add(new Room(102, "������ ", 20000, "��� ��"));
		list.add(new Room(103, "���鳪��", 20000, "��� ��"));
		list.add(new Room(104, "������ ", 20000, "��� ��"));
		list.add(new Room(105, "���೪��", 20000, "��� ��"));
	}
}
