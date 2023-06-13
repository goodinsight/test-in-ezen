package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	
	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
//		ȣ�ڷ� ���� ���� -> List
		List<Room> list = new ArrayList<Room>();
		boolean stop=false;
		
//		ȣ���� ���� ���� �ʱ�ȭ
		init(list);
		
//		
		while(!stop) {
			int sel=menu();
			
			switch(sel) {
			case 1:			// ���� ����
				revRoom(list);
				break;
			case 2:			// ���� ���� ���
				canselRoom(list);
				break;
			case 3:			// ��ü Ȯ�� / ���� Ȯ��
				printRoom(list);
				break;
			case 4:			// ������ ���� Ȯ��
				viewCustm(list);
				break;
			default:
				stop=true;
			}
		}
		
	}	// end of main

	
	
	
	
	
	private static int viewCustm(List<Room> list) {	// ������ ���� Ȯ�� �޼ҵ�
		String revC=inputS("���� �ڵ� �Է� : ");
		for(int i=0; i<list.size(); i++) {
			if(revC.equals(list.get(i).getRevCode())) {
				System.out.println(list.get(i).revInfo());
				System.out.println(list.get(i));
				return i;
			}
			else if(i==list.size()-1){
				System.out.println("���� �ڵ� �Ҹ�");
			}
		}
		return -1;
		
	}


	private static void canselRoom(List<Room> list) {	// ���� ���� ��� �޼ҵ�
		int idx=viewCustm(list);
		String yn=inputS("���� ���? (y/n) : ");
			if(yn.equals("y")) {
				System.out.println("���� ��ҵ�");
				list.get(idx).setCheck(false);
				list.get(idx).setCustomer(null);
				list.get(idx).setRevCode(null);
			}
			else {
				return;
			}
			
	}


	private static void revRoom(List<Room> list) {		// ���� ���� �޼ҵ�
		for(int i=0; i<list.size(); i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
		while(true) {
			int sel=inputM("���� ���� ���� (1~"+list.size()+") : ");
			if(sel<0 || sel>list.size()) {
				continue;
			}
			else {
				int idx=sel-1;
				if(list.get(idx).isCheck()) {
					System.out.println("�̹� ����� ����");
					return;
				}
				list.get(idx).setCheck(true);
				String cust=inputS("������ �Է� : ");
				list.get(idx).setCustomer(cust);
				int revC=(int)(Math.random()*9000)+1000;
				list.get(idx).setRevCode(revC+"");
				System.out.println("���� �ڵ� : "+revC);
				break;
			}
		}
		
	}


	private static void printRoom(List<Room> list) {	// ���� Ȯ�� �޼ҵ�
		int sel=inputM("1.��ü ���� Ȯ�� 2.���� ���� Ȯ�� : ");
		if(sel==1) {
			for(Room r:list) {
				System.out.println(r);
			}
		}else if(sel==2) {
			sel=inputM("1.ȣ�� �˻� 2.���� �˻� 3.�̸� �˻�: ");
			if(sel==1) {
				int idx=findNo(inputS("Ȯ�� ȣ�� �Է� : "), list);
				if(idx==-1) {
					System.out.println("ȣ�� �Ҹ�");
				} else {
					System.out.println(list.get(idx));
				}
//				searchNo(list);
			}else if(sel==2) {
				searchPrice(list);
			}else if(sel==3) {
				findName(inputS("�̸� �Է� : "), list);
			}
		}
		
	}


	private static void init(List<Room> list) {			// ���� ���� �ʱ�ȭ �޼ҵ�
		list.add(new Room(101, "��1", 2000, "A"));
		list.add(new Room(102, "��2", 3000, "B"));
		list.add(new Room(103, "��1", 4000, "C"));
		list.add(new Room(104, "��2", 5000, "D"));
		list.add(new Room(105, "��3", 6000, "E"));
	
		
	}
	

	private static int menu() {							// �޴� ���� �޼ҵ�
		System.out.println("ȣ�� ���� ���α׷�");	
		int sel=inputM("1.���� 2.���� ��� 3.���� Ȯ�� 4.���� Ȯ�� : ");
		return sel;
		
	}
	
	
	private static int inputM(String txt) {				// int �Է¹� �޼ҵ�
		System.out.print(txt);
		return scan.nextInt();
		
	}
	
	
	private static String inputS(String txt) {			// String �Է¹� �޼ҵ�
		System.out.print(txt);
		return scan.next();
		
	}
	
	
	private static void searchNo(List<Room> list) {		// no �˻� �޼ҵ�
		String rNo=inputS("Ȯ�� ȣ�� �Է� : ");
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(rNo.equals(""+list.get(i).getrNo())) {
				System.out.println(list.get(i));
				count+=1;
				break;
			}
		}
		if(count==0){
			System.out.println("ȣ�� �Ҹ�");
		}
		
	}
	
	
	private static void searchPrice(List<Room> list) {	// price ���� �˻� �޼ҵ�
		int rPrice=inputM("�ִ� ���� �Է� : ");
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(rPrice>=list.get(i).getrPrice()) {
				System.out.println(list.get(i));
				count+=1;
			}
		}
		if(count==0) {
			System.out.println("���� "+rPrice+" ���� ���� ����");
		}
		
	}
	
	
//	list ���� �ش� ������ ����Ǿ��ִ� index �˻� �޼ҵ�
//	���ȣ or ���̸�
	
	private static int findNo(String rNo, List<Room> list) {
		int idx=-1;
		for(int i=0; i<list.size(); i++) {
			if(rNo.equals(""+list.get(i).getrNo())) {
				idx=i;
				break;
			}
		}
		return idx;
	}
	
	
	private static void findName(String rName, List<Room> list) {
		int count=0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getrName().contains(rName)) {
				System.out.println(list.get(i));
				count+=1;
			}
		}
		if(count==0) {
			System.out.println("�̸� �Ҹ�");
		}
	}
	
}
