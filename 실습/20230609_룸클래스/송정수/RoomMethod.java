package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoomMethod {
	static Scanner scan = new Scanner(System.in);

	// �� �����ϴ� �޼ҵ� �Դϴ�
	public void editRoom(List<Room> list) {
		for (Room r : list) {
			System.out.println(r);
		}
		int sel = choice("������ ȣ���� �Է��ϼ��� : ");
		int per = findRoomNum(sel, list);
		if (per == -1) {
			System.out.println("���� ȣ���Դϴ�.");
		} else if (sel == list.get(per).getrNo()) {
			list.get(per).setrNo(choice("���ο� ȣ�ǹ�ȣ��/�� �Է��ϼ��� : "));
			list.get(per).setrName(stringChoice("�� �̸��� �Է��ϼ��� : "));
			list.get(per).setRprice(choice("������ �Է��ϼ��� : "));
			list.get(per).setrdescription(stringChoice("������ �Է��ϼ��� : "));
		}

	}

	// �� �߰��ϴ� �޼ҵ� �Դϴ�
	public void addRoom(List<Room> list) {
		int num = choice("ȣ���� �Է��ϼ��� : ");
		String name = stringChoice("�� �̸��� �Է��ϼ��� : ");
		int price = choice("������ �Է��ϼ��� : ");
		String description = stringChoice("������ �Է��ϼ��� : ");
		list.add(new Room(num, name, price, description + ""));
	}

	// �� ����� �޼ҵ� �Դϴ�
	public void removeRoom(List<Room> list) {
		int sel = choice("����� ȣ���� �Է����ּ��� : ");
		System.out.println(list.size());
		int per = findRoomNum(sel, list);
		if (per == -1) {
			System.out.println("���� ȣ���Դϴ�.");
		} else if (list.get(per).getrNo() == sel) {
			list.remove(per);
			System.out.println("ȣ���� �����߽��ϴ�.");
			System.out.println(list.size());
		}
	}

	// ������ ����Ȯ�� �޼ҵ� �Դϴ�
	public void infoCheck(List<Room> list , List<Rcus> rcus) {
		int sel = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer() != null) {
				sel++;
				System.out.println("ȣ�� : " + list.get(i).getrNo() + " �����ڸ� : " + list.get(i).getCustomer() + " �����ȣ : "
						+ list.get(i).getRevCode());
			}
		}
		if (sel == 0) {
			System.out.println("������ ����� �����ϴ�.");
		}
	}

//	������� (�������̸�����) �޼ҵ� �Դϴ�
	public void cancelRoom(List<Room> list , List<Rcus> rcus) {
		String name = stringChoice("������ ������ �Է����ּ��� : ");
		int per = findRoomCus(name, list);

		if (per == -1) {
			System.out.println("���� ������ �����Դϴ�.");
		} else if (!name.equals(list.get(per).getCustomer())) {
			System.out.println("������ ������ ���� �ʽ��ϴ�.");
		} else {
			String num = stringChoice("�����ڵ带 �Է����ּ��� : ");
			if (per == -1) {
				System.out.println("���� �����ڵ��Դϴ�.");
			} else if (!num.equals(list.get(per).getRevCode())) {
				System.out.println("������ �ڵ尡 �����ʽ��ϴ�.");
			} else {
				System.out.println("������ ��ҵǾ����ϴ�.");
				rcus.add(new Rcus(name, list.get(per).getrNo(), num));
				rcus.get(per).setCheck(true);
				list.get(per).setCheck(false);
				list.get(per).setCustomer(null);
				list.get(per).setRevCode(null);
			}
		}
	}

//	������� �޼ҵ� �Դϴ�
//	public void cancelRoom(List<Room> list) {
//		// TODO Auto-generated method stub
//		int sel = choice("����� ȣ����/�� �Է��ϼ��� : ");
//		int per = findRoomNum(sel, list);
//		if (per == -1) {
//			System.out.println("���� ȣ���Դϴ�.");
//		} else if (list.get(per).isCheck() == false) {
//			System.out.println("�Է��Ͻ� ȣ���� ������ �Ǿ����� �ʽ��ϴ�.");
//		} else {
//			String name = stringChoice("������ ������ �Է��ϼ��� : ");
//			if (!list.get(per).getCustomer().equals(name)) {
//				System.out.println("������ ������ �ٽ� �ѹ� Ȯ�����ּ���.");
//			} else {
//				String num = stringChoice("���� �ڵ带 �Է����ּ��� : ");
//				if (!list.get(per).getRevCode().equals(num)) {
//					System.out.println("���� �ڵ尡 �ٸ��ϴ�. �ٽ� Ȯ�����ּ���.");
//				} else {
//					System.out.println("������ ��ҵǾ����ϴ�.");
//					list.get(per).setCheck(false);
//					list.get(per).setCustomer(null);
//					list.get(per).setRevCode(null);
//				}
//			}
//		}
//
//	}
//	������� ���
	public void cancelPeople(List<Rcus> rcus) {
		for(int i=0;i<rcus.size();i++) {
			if(rcus.get(i).isCheck() == true) {
				for(Rcus r : rcus) {
					System.out.println(r);
				}
			}
		}
	}
//	�����ϴ� �޼ҵ� �Դϴ�
	public void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
//		printRoom(list);
		for (Room r : list) {
			System.out.println(r);
		}
		boolean d = true;
		do {
			int sel = choice("���ϴ� ȣ����/�� �Է��ϼ��� : ");
			int per = findRoomNum(sel, list);

			if (per == -1) {
				System.out.println("���� ȣ���Դϴ�.");
			} else if (list.get(per).isCheck() == true) {
				System.out.println("�ش� ȣ���� �̹� ����Ǿ����ϴ�.");
			} else {
				String name = stringChoice("������ ������ �Է����ּ��� : ");
				list.get(per).setCustomer(name);
				int num = 0;
				for (int i = 0; i < 1; i++) {
					num = (int) (Math.random() * 50) + 1;
					for (int j = 0; j < list.size(); j++) {
						if ((num + "").equals(list.get(j).getRevCode())) {
							i--;
						}
					}
				}
				list.get(per).setRevCode(num + "");
				System.out.println("�����ڵ� : " + num);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				list.get(per).setCheck(true);
				d = false;
			}
		} while (d);
	}

	// �� ��üȮ�� �޼ҵ��Դϴ�
	public void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1.��üȣ��Ȯ�� 2.����ȣ��Ȯ��");
		int sel = choice("���ϴ� ��ȣ�� �Է��ϼ��� : ");
		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r.toString());
			}
		} else if (sel == 2) {
			sel = choice("Ȯ���Ͻ� ȣ����/�� �Է��ϼ��� : ");
			int per = findRoomNum(sel, list);
			if (per == -1) {
				System.out.println("���� ȣ���Դϴ�.");
			} else {
				String mark = "";
				if (list.get(per).isCheck() == false) {
					mark = "���డ��";
				} else {
					mark = "���� �Ұ���";
				}
				System.out.println("ȣ�� : " + list.get(per).getrNo() + " ���̸� : " + list.get(per).getrName() + " ���� : "
						+ list.get(per).getRprice() + " ���࿩�� : " + mark);
			}
		}
	}

// 	����� �Է��� ȣ���� ����Ǿ����� Ȯ���ϴ� �޼ҵ� �Դϴ�
//	�������̸����� ã��
	public int findRoomCus(String name, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

//	���̸����� ã��
	public int findRoomName(String name, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName()	=> ����Ʈ���� ���̸�
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

//	���ȣ�� ã��
	public int findRoomNum(int num, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (num == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

//	msg ������ int.scan���� ��ȯ
	public int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//	msg ������ String.scan���� ��ȯ
	public String stringChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}
//	�޴������ִ� �޼ҵ�
	public int menu() {
		// TODO Auto-generated method stub
		System.out.println("=====ȣ�� �޴�=====");
		System.out.println("1.�����ϱ� 2.������� 3.���࿩��Ȯ�� 4.����������Ȯ�� 5.�� ����� 6.�� �߰��ϱ� 7.�� �����ϱ�");
		return choice("���ϴ� ��ȣ�� �Է��ϼ��� : ");
	}

//	private static void init(List<Room> list) {
//		// TODO Auto-generated method stub
//		Room r1 = new Room(101, "�ҳ���", 20000, "ħ��1��");
//		Room r2 = new Room(102, "������", 20000, "ħ��1��");
//		Room r3 = new Room(103, "���鳪��", 40000, "ħ��2��");
//		Room r4 = new Room(104, "������", 40000, "ħ��2��");
//		Room r5 = new Room(105, "���೪��", 50000, "ħ��3��");
////		�� ����
//		list.add(r1);
//		list.add(r2);
//		list.add(r3);
//		list.add(r4);
//		list.add(r5);
//	}
//	���Ϸ� list �ʱ�ȭ�ϴ°�
	public void init(List<Room> list) {
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("Room.txt"));

			while (str != null) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				StringTokenizer tr = new StringTokenizer(str, ",");
				Room r1 = new Room(Integer.parseInt(tr.nextToken()), tr.nextToken(), Integer.parseInt(tr.nextToken()),
						tr.nextToken());
				list.add(r1);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
