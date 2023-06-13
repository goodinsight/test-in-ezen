package kr.co.dong.room;

import java.util.List;
import java.util.Scanner;

public class RoomControl3 {
	static Scanner scan = new Scanner(System.in);   // static �޸𸮷� ������ (static / stack / heap)

	public static void menu() { // public void�� ��𼭵� �����ְ�
		System.out.println("����������������������������������[menu]����������������������������������");
		System.out.println("1. ���� ��ȸ");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� ���� ���");
		System.out.println("4. ������ ��ȸ");
		System.out.println("��������������������������������������������������������������������������������");

	}

//	1. ���� ��ȸ
	public void hotel(List<Room1> list) {
		System.out.println("����������������������������������[menu]����������������������������������");
		System.out.println("1. ��ü ��ȸ");
		System.out.println("2. �� �̸����� ���� ��ȸ ");
		System.out.println("3. �� ȣ���� ���� ��ȸ ");
		System.out.println("��������������������������������������������������������������������������������");
		int sel = scan.nextInt();
		if (sel == 1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print("  �� ��ȣ : " + list.get(i).getrNo() + "  �� �̸� : " + list.get(i).getrName() + "�� ���� :  "
						+ list.get(i).getrPrice());
				if (list.get(i).isCheck() == false) {
					System.out.println("  ���� ���� : ������ �����մϴ�.");
				} else {
					System.out.println("  ���� ���� : ������ �Ұ����մϴ�.");
				}
			}
		} else if (sel == 2) {
//			System.out.println("�� �̸��� �����ּ���.");
//			String name = scan.next();
			String name = inputMS("�� �̸��� �����ּ���.");
			if (rname(list, name) == -1) {
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			} else {
				System.out.println(list.get(rname(list, name)));
			}

		} else if (sel == 3) {
			System.out.println("�� ȣ���� �����ּ���.");
			int hosu = scan.nextInt();
			if (nname(list, hosu) == -1) {
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			} else {
				System.out.println(list.get(nname(list, hosu)));
			}
		}
	}

//	2. ���� ���� (���ȣ)
	public void revRoom(List<Room1> list) { // hosu�� �ִ��� ������ ���Ϸ���
		System.out.println("���Ͻô� ȣ���� �Է����ּ���.");
		int hosu = scan.nextInt();
		int index = nname(list, hosu);
		if (index == -1) {
			System.out.println("���� ȣ���Դϴ�.");
		} else {
			System.out.println("������ �����մϴ�.");
			System.out.println("������ ������ �Է����ּ���.");
			String revName = scan.next();
			list.get(index).setCustomer(revName);
//				System.out.println(list.get(i).getCustomer()); // �³� �׽�Ʈ�Ѱ�
			String revNo = "230612" + hosu;
			System.out.println("�����ȣ�� " + revNo);
			list.get(index).setRevCode(revNo);
			list.get(index).setCheck(true);

		}
//		ȣ���� �ִ��� Ȯ���ؾ��Ѵ�
//			if (list.get(index).getrNo()==hosu) {
//			}

	}

//	3. ���� ���
	public void cancelRoom(List<Room1> list) {
		System.out.println("������ ������ �Է����ּ���.");
		String canName = scan.next();
		int index = nname(list, canName);
		if (index == -1) { // �ε������� �������� ����
			System.out.println("������� ���� �̸��Դϴ�. ");
		} else {
			if (list.get(index).getCustomer().equals(canName)) {
				System.out.println("������ Ȯ�εǾ����ϴ�. ");
				System.out.println("�����ȣ�� �Է����ּ���.");
				String canNo = scan.next();
				if (!list.get(index).getRevCode().equals(canNo)) { // �������̶� ! equals�� �ؾ��� ==�ȵ�.
					System.out.println("Ʋ�ȴ�.���ư���");
				} else {
					System.out.println("���� ��� �Ǿ����ϴ�. ");
					list.get(index).setCustomer(null);
					list.get(index).setRevCode("");
					list.get(index).setCheck(false);
				}
			}
		}
	}

// 4. ������ ��ȸ
	public void look(List<Room1> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer() != null) {
				System.out.println("������ : " + list.get(i).getCustomer() + "  �����ȣ : " + list.get(i).getRevCode());
			}
		}
	}

	public void init(List<Room1> list) {
		Room1 r1 = new Room1(101, "�ҳ���", 20000, "��� ��");
		Room1 r2 = new Room1(102, "������", 20000, "��� ��");
		Room1 r3 = new Room1(103, "���鳪��", 20000, "��� ��");
		Room1 r4 = new Room1(104, "������", 20000, "��� ��");
		Room1 r5 = new Room1(105, "���೪��", 20000, "��� ��");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

//	'ȣ��' �ε��� �������� �޼ҵ�
	public int nname(List<Room1> list, int hosu) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (hosu == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

//	'������ �̸�' �ε��� �������� �޼ҵ�
	public int nname(List<Room1> list, String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

//	'�� �̸�' �ε��� �������� �޼ҵ�
	public int rname(List<Room1> list, String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	 static int intputMD(String msg) {    // ���� , static���̴� ������ scan�޴� Scanner�� static�̶�.
		System.out.println(msg + ": ");
		return scan.nextInt();
	}
	
	 static String inputMS(String msg) {   
		 System.out.println(msg + ": ");
		 return scan.next();
	 }
//	===================>>>>
//	 ���ڿ� , msg�� "���ϴ� ȣ���� �Է����ּ���.���" => scan���� ���� 
//		System.out.println("�� �̸��� �����ּ���.");
//		String name = scan.next();
//		=====> �� String name = inputMS("�� �̸��� �����ּ���."); �ٿ��� ���� ����
	



	public int choice() {
		return scan.nextInt();
	}

}