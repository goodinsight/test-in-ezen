package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		List<Room> list = new ArrayList<>();
		boolean stop = false;
		
		
		
//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		list = init();
		
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
//	list ���� �ش� ������ ����Ǿ� �ִ� index�� ã�� �޼ҵ�
//	���ȣ�� ã��? ���̸����� ã��?
	private static int findRoom(String name, List<Room> list) {
		int index = -1;
		for(Room r : list) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if(r.getrName().equals(name)) {
				
//				index = r;
				break;
			}	
		}
		return index;
	}
	
	private static int findRoom(int rNumber, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if(list.get(i).getrNumber() == rNumber) {
				index = i;
				break;
			}	
		}
		return index;
	}
	private static int searchRoom(int rPrice, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if(list.get(i).getrPrice() == rPrice) {
				index = i;
				break;
			}	
		}
		return index;
	}
	private static int searchRoom(String rName, List<Room> list) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if(list.get(i).getrName().equals(rName)) {
				index = i;
				break;
			}	
		}
		return index;
	}
	
	private static void inforCustomer(List<Room> list) {
		try {
			int sel = inpuM("������ ������ ���Ͻô� �� ȣ���� �Է��ϼ��� : ");
			System.out.println(sel+"ȣ���� �����ڸ� : " + list.get(findRoom(sel,list)).getCustomer() + ", �����ڵ� : " + list.get(findRoom(sel,list)).getRevCode() + " �Դϴ�.");
		}catch(Exception e){
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static void cancelRoom(List<Room> list) {
		try {
			int sel = inpuM("������� �ϰ��� �ϴ� �� ȣ���� �Է��ϼ��� : ");
			if(list.get(findRoom(sel,list)).isCheck() == true) {
				System.out.println(sel+"ȣ���� ������Ұ� �����մϴ�.");
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				if(list.get(findRoom(sel,list)).getCustomer().equals(scan.next())) {
					System.out.println("���� �ڵ带 �Է��ϼ��� : ");
					if(list.get(findRoom(sel,list)).getRevCode().equals(scan.next())) {
						list.get(findRoom(sel,list)).setCheck(false);
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
			if(list.get(findRoom(sel,list)).isCheck() == false) {
				System.out.println(sel+"ȣ���� ������ �����մϴ�.");
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				list.get(findRoom(sel,list)).setCustomer(scan.next());
				System.out.println("���� �ڵ带 �Է��ϼ���(������ҽ� �ʿ�) : ");
				list.get(findRoom(sel,list)).setRevCode(scan.next());
				list.get(findRoom(sel,list)).setCheck(true);
				System.out.println(sel+"ȣ���� ������ : "+list.get(findRoom(sel,list)).getCustomer()+", ���� �ڵ� : "+list.get(findRoom(sel,list)).getRevCode()+" ��  ���� �Ǿ����ϴ�.");
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

	private static List init() {
		// TODO Auto-generated method stub
		List<Room> list = new ArrayList<>();
		String fileName = "roomInfor.txt";
		BufferedReader br;
		Room r;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while(true) {
				String data = br.readLine();
				if(data==null)
					break;
				String[] tmp = data.split(", ");
				r = new Room(Integer.parseInt(tmp[0]),tmp[1],Integer.parseInt(tmp[2]),tmp[3]);
				list.add(r);
			}		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return list;
	}
}
