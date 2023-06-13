package kr.co.dong.checkPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List		
		List<Room> list = new ArrayList<Room>();

		boolean stop = false;		
		init(list); // ������ list �ּҸ� �����ְ� �ʱ�ȭ �ؼ� ���� (���� �ʿ����-�������� �ƹ����� ���������ϴ�)
		
//		���� �κ�
		while(!stop) {
			int sel = menu();
			
			switch(sel) {
			case 1:    // �� ����
				revRoom(list);
				break;
			case 2:    // �� ���� ���
				cancelRoom(list);
				break;
			case 3:    // �� ��ü Ȯ��, ����Ȯ��
				printRoom(list);
				break;
			case 4:    // ������ ���� Ȯ��
				checkRoom(list);
				break;
			default:
				System.out.println("�߸������ϼ̽��ϴ�. \n");
			}
		}
	}

	private static void revRoom(List<Room> list) {
		System.out.println("�����ϰ� ���� ���� ������ �ּ��� >");
		System.out.println("���� ������ ���Դϴ�.>");
		for(Room r:list) {
			if(r.getCheck()==false) {
			System.out.print(r.getrNo() + "ȣ  ");
			}
		}
		int selRoom = scan.nextInt(); // ��ȣ�� ����   // �Է°��� �ѱ��̸� �ٽ� �Է� �ޱ�
		
		
//		if(�Է°��� ture �ٲ�� �ִ� �ε��� ���ȣ�� ������ )
//		else(�ٽ��Է�)
//		check ���ɹ� ��ȣ 
		int count =0;
		
		List<Integer> tmpList = new ArrayList<>(); // �ӽ÷� ���డ���� ȣ���� ������
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCheck() == false) {
				tmpList.add(list.get(i).getrNo());
//				System.out.println(tmpList.get(i)); // �߳������� ����غ�
			}
		}
		
		if(tmpList.contains(selRoom)) { // �Է°� �̿��� ���� 
	
			int start = 0; //����Ʈ ���� index
			int end = list.size()-1; //����Ʈ ������ index
			if( selRoom>= list.get(start).getrNo() && selRoom <= list.get(end).getrNo()) {
			
				System.out.printf("%d ȣ�� �����ϼ̽��ϴ�. �̸��� �Է��� �ּ��� >",selRoom);
			
				int idx = findIndexRoomNum(list, selRoom); // ���ȣ�� �ε��� ã��
		
				String tmpStr = scan.next(); // ������ �̸� �ֱ�
				list.get(idx).setCustomer(tmpStr);
				// �����ȣ ���� = room ��ȣ + 1004
				list.get(idx).setRevCode((Integer.toString(selRoom)+ "1004")); 
		
				System.out.printf("%s�� �����ȣ�� %s �Դϴ�. �߱���ϼſ�. \n", list.get(idx).getCustomer(), list.get(idx).getRevCode() );
				System.out.println("�����մϴ�. \n");
				list.get(idx).setCheck(true); // true ����� ��, false ���
			} else {
				System.out.println("���� ������ ���ȣ�� �ƴմϴ�. �ٽ� �޴��� �������ּ���. \n");
			}
		} else {
			System.out.println("�Է��� ȣ���� ���డ������ �ʽ��ϴ�. ");
		}
			
			
	}
	
	private static void cancelRoom(List<Room> list) {
		System.out.println("����ϱ� ���� ���ȣ�� �����ּ���>");

		int selRoom = scan.nextInt();		
		int idx = findIndexRoomNum(list, selRoom); // ���ȣ�� �ε��� ã��
	
		if(list.get(idx).getCheck() == true) {  		
			System.out.println("�̸� ID, �н����� : �����ȣ �Դϴ�.");
			System.out.println("ID(�̸�)�� �����ּ��� >");
			String name = scan.next();
			System.out.println("�н�����(�����ȣ)�� �����ּ��� >");
			String resNum = scan.next();
			if( (list.get(idx).getCustomer().equals(name)) && (list.get(idx).getRevCode().equals(resNum)) ) {
				System.out.println("���������� ������� �Ǿ����ϴ�. \n");
				list.get(idx).setCheck(false);		
				list.get(idx).setCustomer(null);
				list.get(idx).setRevCode(null);
			} else {
				System.out.println("���̵�� �̸��� ���� �ʽ��ϴ�. �ٽú�Ź�帳�ϴ�. ");
			}	
		} else {
			System.out.println("���� ��Ұ� ������ ���ȣ�� �ƴմϴ�. �ٽ� �޴��� �������ּ���. \n");
		}
	}
	
	private static void checkRoom(List<Room> list) {
		System.out.println("���࿩�θ� Ȯ���ϰڽ��ϴ�. ");
		System.out.println("�̸��� �Է��� �ּ���");
		System.out.println("�Է� >");
		String nameName = scan.next();
		
//		�ε��� ���� // ���̸����� �ε��� ����
		int idx = findIndexName(list, nameName);
		
			System.out.println("������ Ȯ���Ͽ����ϴ�. ");
			System.out.println("������ ����� �����Դϴ�. ");
			System.out.println("���� : " + list.get(idx).getCustomer());
			System.out.println("����ȣ�� : " + list.get(idx).getrNo());
			System.out.println("����� : " + list.get(idx).getrPrice());
	}
	

//	int findRoom(String name, List<Room> list ) {
//		
//	}
	
	private static int findIndexRoomNum(List<Room> list, int selRoom) {
		// TODO Auto-generated method stub
		int idx = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getrNo() == selRoom)
				idx = i;
        	}
		return idx;
	}
	
	private static int findIndexName(List<Room> list, String str) {
		// TODO Auto-generated method stub
		int idx = -1; 
		
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getCustomer());
            if(list.get(i).getCustomer().equals(str)) {
            	idx = i;
            	break;
            }
        }
        return idx;
	}
	
	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("�Ŵ��� �����ϼ���");
		System.out.println("1. �濹�� ");
		System.out.println("2. �濹�� ���" );
		System.out.println("3. �濹�� Ȯ��(1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��)" );
		System.out.println("4. �������� Ȯ�� ");
		return scan.nextInt();
	}

	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1. ��üȣ��Ȯ�� 2. ����ȣ�� Ȯ��");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			for(Room r:list) {
				System.out.println(r);
			}
		} else if(sel==2) {
			System.out.println("���ϴ� ȣ���� �Է��ϼ���");
			int selTemp = scan.nextInt();
			selTemp = (selTemp % 100) -1;
			System.out.println(list.get(selTemp));
		}
		
	}
	
	private static void init(List<Room> list) { //���߿� �� �и�
		// TODO Auto-generated method stub
//		ȣ���� �� ������ �ʱ�ȭ
		Room r1 = new Room(101, "�ҳ���", 20000, "�ູ ��� ��");
		Room r2 = new Room(102, "������", 20000, "��� ��� ��");
		Room r3 = new Room(103, "���鳪��", 20000, " ��ſ��� ��");
		Room r4 = new Room(104, "������", 20000, "�̻��� ��� ��");
		Room r5 = new Room(105, "���೪��", 20000, "�׳� ��� ��");
		
//		������
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}
}
