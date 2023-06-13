package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl3 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List		
		List<Room> list = new ArrayList<Room>(5);

		
		
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
			case 5:    // ������ ���� Ȯ��
				managerRoom(list);
				break;
			case 6:    // ����
				System.out.println("���α׷��� ����˴ϴ�.");
				stop = true;
				break;
			default:
				System.out.println("�߸������ϼ̽��ϴ�. \n");
			}
		}
	}

	private static void managerRoom(List<Room> list) {
		// ������� �̸� ����, ���ݺ���, �����ڸ� ����, ��� �����ϴ� class
		// ���� ���
		// ������ �α���
		// ��й�ȣ ����
		//
		boolean manageOnOff = false;

		String value = null;
		int changeValue = 0;
		
		while(!manageOnOff) {
			
			int mangaeMenunum = manageMenu();
			
			switch (mangaeMenunum) {

			case 1:
				boolean OnOff = false;
				while(!OnOff) {
					System.out.println("������ ���� �־��ּ��� 1. ��ȣ�� 2.���̸� 3. �����ڸ� 4. ����");
					changeValue = scan.nextInt();
					
						switch (changeValue) {
						case 1: // ��ȣ��					
							value = "��ȣ��"; // int
							changeValue(value, list);
							break;						
						case 2: // ���̸�
							value = "���̸�"; // String
							changeValue(value, list);
							break;
						case 3: // �����ڸ�
							value = "�����ڸ�"; // int
							changeValue(value, list);
							break;
						case 4: // ����
							System.out.println("�����带 �����մϴ�. ");
							OnOff = true;
							break;
						default:
							System.out.println("�˼����� ��ɾ� �Դϴ�. �ٽ� ��Ź�帳�ϴ�. ");
							break;
					}
				}
				break;
			case 2:
				calSales(list);
				break;
			case 3:
				changePass(list);
				break;
			case 4:
				manageOnOff = true;
				break;
			default:
				System.out.println("�߸������ϼ̽��ϴ�. \n");
				
				break;
			}
		}	
	}
	

//	�����ڸ�� ���� �κ� start
	private static void changeValue(String value, List<Room> list) {
		String baseTmp = null;
		String changeTmp = null;
		String resultTmp = null;
		
		System.out.println("������ ���� �Է����ּ��� >");
		baseTmp = scan.next();
//		�� ��Ƽ����
		System.out.println("�����ϰ� ���� ������ �Է����ּ��� >");	
		changeTmp = scan.next();
		
		if(value.equals("��ȣ��")) {
			resultTmp = findIndexRoomNum(list, baseTmp); // ���ȣ�� �ε��� ã��
			int idx = Integer.parseInt(resultTmp);	
			list.get(idx).setrNo(Integer.parseInt(changeTmp));
		}
		if(value.equals("���̸�")) {
			int idx = findIndexRName(list, baseTmp); // ���ȣ�� �ε��� ã��
			list.get(idx).setrName(changeTmp);
		}
		if(value.equals("�����ڸ�")) {
			int idx = findIndexName(list, baseTmp); // ���ȣ�� �ε��� ã��
			System.out.println(idx);
			list.get(idx).setCustomer(changeTmp);
		}
		

		
		System.out.printf("���ȣ�� %s���� %s�� ����Ǿ����ϴ�. ",baseTmp, changeTmp );
		
	}
	private static void calSales(List<Room> list) {
		// ���� ����� ��(���� list �����ؼ� ���ø��� ���� �� ���� ���� �ݿ��� ��)
		// �Էµ� �͵��� �� �����,������׵��� Ȯ���ϱ� ���� ������ sum ��� 
		
	}
	private static void changePass(List<Room> list) {
		// ������ �н����� ���� ������ �۾� ���غþ�� �غ���
		
	}

//	�����ڸ�� ���� �κ� end
	
	public static boolean isNumeric(String str) {
	    return str.matches("\\d+");
	}
	
	
	private static int manageMenu() {
	System.out.println("������ ��忡 ��� ���̽��ϴ�. ");
	System.out.println("1. �̸� �� �� ����");
	System.out.println("2. ���� ���");
	System.out.println("3. ������ ��й�ȣ ����");
	System.out.println("4. �����ڸ�� ����");
	return scan.nextInt();
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
			}
		}
		
		if(tmpList.contains(selRoom)) { // �Է°� �̿��� ���� 
	
			int start = 0; //����Ʈ ���� index
			int end = list.size()-1; //����Ʈ ������ index
			if( selRoom>= list.get(start).getrNo() && selRoom <= list.get(end).getrNo()) {
			
				System.out.printf("%d ȣ�� �����ϼ̽��ϴ�. �̸��� �Է��� �ּ��� >",selRoom);
				
				String tmpStr2 = Integer.toString(selRoom);
				String idx = findIndexRoomNum(list, tmpStr2); // ���ȣ�� �ε��� ã��
				int idx1= Integer.parseInt(idx);
				String tmpStr = scan.next(); // ������ �̸� �ֱ�
				list.get(idx1).setCustomer(tmpStr);
				// �����ȣ ���� = room ��ȣ + 1004
				list.get(idx1).setRevCode((Integer.toString(selRoom)+ "1004")); 
		
				System.out.printf("%s�� �����ȣ�� %s �Դϴ�. �߱���ϼſ�. \n", list.get(idx1).getCustomer(), list.get(idx1).getRevCode() );
				System.out.println("�����մϴ�. \n");
				list.get(idx1).setCheck(true); // true ����� ��, false ���
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
		String tmpStr2 = Integer.toString(selRoom);
		String idx2 = findIndexRoomNum(list, tmpStr2); // ���ȣ�� �ε��� ã��
		int idx1 = Integer.parseInt(idx2);
		if(list.get(idx1).getCheck() == true) {  		
			System.out.println("�̸� ID, �н����� : �����ȣ �Դϴ�.");
			System.out.println("ID(�̸�)�� �����ּ��� >");
			String name = scan.next();
			System.out.println("�н�����(�����ȣ)�� �����ּ��� >");
			String resNum = scan.next();
			if( (list.get(idx1).getCustomer().equals(name)) && (list.get(idx1).getRevCode().equals(resNum)) ) {
				System.out.println("���������� ������� �Ǿ����ϴ�. \n");
				list.get(idx1).setCheck(false);		
				list.get(idx1).setCustomer(null);
				list.get(idx1).setRevCode(null);
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
	
// ����� ���
//	int findRoom(String name, List<Room> list ) {
//	int index = -1;
//		
//		for(int i = 0; i<list.size(); i++) {
////			list.get(i).getName() => ����Ʈ���� ���̸�
//			if(name.equals(list.get(i).getrName())) {
//				index = i;
//				break;
//				return index;
//			}
//		}
//	}
	
	private static String findIndexRoomNum(List<Room> list, String selRoom) {
		int idx = -1;
		String returnStr = null;
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getrNo() == Integer.parseInt(selRoom))
				idx = i;
        	}
		returnStr = Integer.toString(idx);
		return returnStr;
	}
	
	private static int findIndexName(List<Room> list, String str) {
		int idx = -1; 
		
        for (int i = 0; i < list.size(); i++) {
//        	System.out.println(list.get(i).getCustomer());
            if(list.get(i).getCustomer().equals(str)) {
            	idx = i;
            	System.out.println(idx);
     
            	break;
            }
        }
		return idx;
	}
	
	private static int findIndexRName(List<Room> list, String str) {
		int idx = -1; 	
		
        for (int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i).getrName());
            if(list.get(i).getrName().equals(str)) {
            	idx = i;
            	break;
            }
        }

		return idx;
	}
		
	private static int menu() {
		System.out.println("�Ŵ��� �����ϼ���");
		System.out.println("1. �濹�� ");
		System.out.println("2. �濹�� ���" );
		System.out.println("3. �濹�� Ȯ��(1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��)" );
		System.out.println("4. �������� Ȯ��");
		System.out.println("5. �����ڸ��");
		System.out.println("6. ���α׷� ����");
		
		return scan.nextInt();
	}

	private static void printRoom(List<Room> list) {
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
//		ȣ���� �� ������ �ʱ�ȭ
		Room r1 = new Room(101, "�ҳ���", 20000, "�ູ ��� ��", "��");
		Room r2 = new Room(102, "������", 20000, "��� ��� ��", "��");
		Room r3 = new Room(103, "���鳪��", 20000, " ��ſ��� ��", "��");
		Room r4 = new Room(104, "������", 20000, "�̻��� ��� ��", "��");
		Room r5 = new Room(105, "���೪��", 20000, "�׳� ��� ��", "��");
		
//		������
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}
}
