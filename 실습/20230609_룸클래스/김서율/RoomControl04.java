package kr.co.dong.roomsy;

import java.beans.Customizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoomControl04 {
	Scanner scan = new Scanner(System.in);

//	Room(int rNo, String rName, int rPrice, String rContent)
	public void init(List<Room> list) {

//		Room r1 = new Room(101, "��1", 10000, "1����");
//		Room r2 = new Room(201, "��2", 10000, "2����");
//		Room r3 = new Room(301, "��3", 10000, "3����");
//		Room r4 = new Room(401, "��4", 10000, "4����");
//		Room r5 = new Room(501, "��5", 10000, "5����");
//
//		list.add(r1);
//		list.add(r2);
//		list.add(r3);
//		list.add(r4);
//		list.add(r5);
		
		list.add(new Room(101, "��1", 10000, "1����"));
		list.add(new Room(201, "��2", 10000, "2����"));
		list.add(new Room(301, "��3", 10000, "3����"));
		list.add(new Room(401, "��4", 10000, "4����"));
		list.add(new Room(501, "��5", 10000, "5����"));

	}
	public void init2(List<Room> list) {
		BufferedReader br = null;
		StringTokenizer strT = null;
		
		try {
			br = new BufferedReader(new FileReader("room.txt"));
			
			while(true) {
				String str = br.readLine();		//str�� ����� �� : room.txt�� �ִ� 5�� �߿� �� �� �о��� (101, ��1, 10000, 1����)
				if(str == null) {
					break;
				}
				
//				�� �� �о , �޸� �и�							//strT�� �� �ٿ��� ,�� �и���. 101/��1/10000/1����
				strT = new StringTokenizer(str, ",");
				
				Room r1 = new Room();
				r1.setrNo(Integer.parseInt(strT.nextToken()));
				r1.setrName(strT.nextToken().trim());
				r1.setrPrice(Integer.parseInt(strT.nextToken().trim()));
				r1.setrContent(strT.nextToken().trim());
				
				list.add(r1);
				
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

//	�޴��� �����ִ� ���
	public void printRoom() {
		System.out.println("======================================");
		System.out.println("1.�濹�� 2.������� 3.��Ȯ�� 4.����������Ȯ��");
		System.out.println("99.����");
		System.out.println("======================================");
		System.out.print("��ȣ�� �Է��ϼ���. > ");
	}

	// 3.��Ȯ�� -> 1��. ��ü��ȸ 2��. ������ȸ
	public void checkRoom(List<Room> list) {
		System.out.println("==============================");
		System.out.println("1.��ü �� ��ȸ 2.���� �� ��ȸ");
		System.out.println("==============================");
		System.out.print("��ȣ�� �����ϼ���. > ");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("�� ��ȣ: " + list.get(i).getrNo() + ", �̸�: " + list.get(i).getrName() + ", ����: "
						+ list.get(i).getrPrice() + " ����: " + list.get(i).getrContent() + " ���࿩��: "
						+ list.get(i).isrCheck());
			}
		}else if(sel == 2) {
			System.out.print("��ȸ�Ͻ� �� ��ȣ�� �Է��ϼ���.(101~501) > ");
			int rNo = scan.nextInt();
			
			int index = findRoom(list, rNo);
			System.out.println("�� ��ȣ: " + list.get(index).getrNo() + ", �̸�: " + list.get(index).getrName() + 
					", ����: " + list.get(index).getrPrice() + " ����: " + list.get(index).getrContent() + 
					" ���࿩��: "+ list.get(index).isrCheck());
		}

	}

	public void revRoom(List<Room> list) {
		System.out.print("�� ȣ���� �Է��ϼ���. (101~501)> ");
		int rNo = scan.nextInt();
		int index = findRoom(list, rNo);

		if (index == -1) {
			System.out.println("�� ������ �����ϴ�. �ٽ� �Է��ϼ���.");
			revRoom(list);
		} else {
			if (list.get(index).isrCheck() == true) {
				System.out.println("�̹� ����� ���Դϴ�. �ٽ� �Է��ϼ���.");
				revRoom(list);
			} else {
				System.out.println("������ �����մϴ�.");
				System.out.print("������ ������ �Է��ϼ���. > ");
				String cName = scan.next();
				list.get(index).setCustomer(cName);

				String revNo = "20230613" + list.get(index).getrNo();
				System.out.println("�����ȣ�� : " + revNo + "�Դϴ�.");
				list.get(index).setRevCode(revNo);

				list.get(index).setrCheck(true);
			}
		}

	}

	public void checkCustomer(List<Room> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("������ �̸�: " + list.get(i).getCustomer() + "������ �����ȣ : " + list.get(i).getRevCode());
		}
	}

//	cName���� index�� ã�� ���
	public int findRoom(List<Room> list, String cName) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer().equals(cName)) {
				index = i;
				break;
			}
		}
		return index;
	}

//	rNo�� index ã�� ���
	public int findRoom(List<Room> list, int rNo) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getrNo() == rNo) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void cancelRev(List<Room> list) {
		System.out.print("������ ������ �Է��ϼ���. > ");
		String cName = scan.next();

		if (cName.equals(list.get(0).getCustomer())) {
			checkRevNo(list);

		} else {
			System.out.println("���������� �����ϴ�. �ٽ� �Է��ϼ���.");
			cancelRev(list);
		}
	}

	public void checkRevNo(List<Room> list) {
		System.out.print("�����ȣ�� �Է��ϼ���. > ");
		String revNo = scan.next();

		if (revNo.equals(list.get(0).getRevCode())) {
			System.out.println("������ ��ҵǾ����ϴ�.");
			list.get(0).setrCheck(false);
			list.get(0).setCustomer(null);
			list.get(0).setRevCode(null);
		} else {
			System.out.println("���������� �����ϴ�. �ٽ� �Է��ϼ���.");
			checkRevNo(list);
		}
	}
	
	

}
