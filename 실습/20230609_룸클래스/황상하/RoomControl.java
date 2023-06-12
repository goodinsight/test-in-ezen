package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);
	static int sel = 0;

	public static void main(String[] args) {

		// ȣ�ڷ�(5��)�� ������ ���� -> List
		List<Room> rList = new ArrayList<Room>();
		List<Reserve> revList = new ArrayList<Reserve>();
		boolean power = false;
		String revName = null;
		int revNo = 0;

		// ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		init(rList);
		while (!power) {
			sel = menu();

			switch (sel) {
			case 1: // �濹���ϱ�
				revRoom(revList, rList);
				break;
			case 2: // �濹�����
				canRoom(revList, rList);
				break;
			case 3: // �� ��üȮ�� / ���� Ȯ��
				printRoom(rList);
				break;
			case 4: // ������ ���� Ȯ��
				printRev(revList);
				break;
			case 99: // ����
				power = true;
				break;
			default:

			}
		}
	}

	// �� ����
	private static void revRoom(List<Reserve> revList, List<Room> rList) {
		for (int i = 0; i < rList.size(); i++) {
			System.out.println(i + 1 + ". " + rList.get(i).getrNo() + "ȣ (" + rList.get(i).isrCheck() + ")");
		}
		sel = inputMD("������ ���� �������ּ���");
		if ((rList.get(sel - 1).isrCheck()).equals("���డ��")) {
			revList.add(new Reserve(rList.get(sel - 1).getrNo(), inputMS("������ �̸� �Է�"), inputMD("������ �ڵ� ����")));
			rList.get(sel - 1).setrCheck(true);
		} else {
			System.out.println("�̹� ����� ���Դϴ�.");
		}

	}

	// ���� ���
	private static void canRoom(List<Reserve> revList, List<Room> rList) {
		int revCode = inputMD("�����ڵ带 �Է����ּ���");
		int count = 0; // ��ϵ��� ���� �����ڵ� �޽��� ��¿�
		for (int i = 0; i < revList.size(); i++) {
			if (revList.get(i).getRevCode() == revCode) { // �Է��� �����ڵ尡 ������ �� �������
				System.out.println(revList.get(i));
				if (inputMS("���� ����Ͻðڽ��ϱ�?(Y/N)").toUpperCase().equals("Y")) {
					for (int j = 0; j < rList.size(); j++) {
						if (revList.get(i).getrNo() == rList.get(j).getrNo()) {
							rList.get(j).setrCheck(false);
						}
					}
					revList.remove(i);
					count = -1; // ������ҽ� revList����� 0�̵� ��� ī��Ʈ�� revList ����� �������� ���� ����
				}
			} else { // �Է��� �����ڵ�� ���������� ī��Ʈ ����
				count++;
			}
		}
		if (count == revList.size()) { // ��ü ���ฮ��Ʈ�� �񱳸� �������� �Է��� �����ڵ尡 ������
			System.out.println("��ϵ������� �����ڵ��Դϴ�.");
		}
	}

	// �� ����Ȯ��
	private static void printRoom(List<Room> rList) {
		System.out.println("1. ��üȣ�� Ȯ�� 2. ����ȣ��Ȯ��");
		sel = inputMD("�޴��� �������ּ���");

		if (sel == 1) {
			System.out.println("===========================================");
			for (Room r : rList) {
				System.out.println(r);
			}
			System.out.println("===========================================");
		} else if (sel == 2) {
			for (int i = 0; i < rList.size(); i++) {
				System.out.println(i + 1 + ". " + rList.get(i).getrNo() + "ȣ");
			}
			System.out.println(rList.get(inputMD("���� �������ּ���") - 1));

		}

	}

	// �������� Ȯ��
	private static void printRev(List<Reserve> revList) {
		for (Reserve r : revList) {
			System.out.println(r);
		}
	}

	private static int inputMD(String msg) { // ��ǲ�޼��� ����:int
		System.out.print(msg + " : ");
		return scan.nextInt();
	}

	private static String inputMS(String msg) { // ��ǲ�޼��� ����:String
		System.out.print(msg + " : ");
		return scan.next();
	}

	private static int menu() {
		System.out.println("1. �濹�� 2. ����� 3. ������Ȯ�� 4. ������Ȯ�� 99. ����");
		return inputMD("�޴��� �������ּ���");
	}

	private static void init(List<Room> rList) {
		rList.add(new Room(101, "�Ϲ�", 20000, "�ִ��ο� 2��"));
		rList.add(new Room(102, "����Ʈ", 30000, "�ִ��ο� 2��"));
		rList.add(new Room(103, "�����̾�", 40000, "�ִ��ο� 2��"));
		rList.add(new Room(104, "�йи�", 50000, "�ִ��ο� 4��"));
		rList.add(new Room(105, "��������Ʈ", 60000, "�ִ��ο� 6��"));
	}
}
