package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest18 {
	// �迭�ȿ� ���ڰ� 1�̸� ����Ϸ� , 0�̸� ������
	public static void main(String[] args) {
		int[] roomN = { 301, 302, 303, 401, 402, 403, 404, 501, 502, 503, 504, 601, 602 };
		int[] bookcheck = new int[roomN.length]; // 0,1�� ���࿩�� Ȯ��
		String[] roomtype = { "�̱�", "�̱�", "�̱�", "����", "����", "����", "����", "����", "����", "����", "����", "�𷰽�", "�𷰽�" };
		int[] pw = new int[roomN.length];
		String[] id = new String[roomN.length];
		int guest = 0; // �ӽ�
		boolean case1 = false;
		boolean power = false;
		Scanner scan = new Scanner(System.in);

		while (!power) {
			case1 = false;
			System.out.println("============================================");
			System.out.println("���ϴ� �޴��� �����ϼ���.");
			System.out.println("1: �����ϱ� 2: ��������ϱ� 3: ������º���");
			int select = scan.nextInt();

			switch (select) {

			case 1:
				while (!case1) {
					System.out.println("���� �ο����� �Է��ϼ��� (1~3) (ó������: 0��)");
					guest = scan.nextInt();

					// ����ó��
					if (guest == 0) {
						break;
					} else if (guest < 1 || guest > 3) {
						System.out.println("1~3 �߿��� �Է��ϼ���."); // 4���̻� #*($# ���� �ʿ�
						continue;
					}

					// �溸���ֱ�
					for (int i = 0; i < roomN.length; i++) {

						if (guest == 1 || guest == 2 || guest == 3) {
							if (i == 0) {
								System.out.println("������ ���ȣ�� �Է����ּ���. (���డ��:��) (ó������: 0��)");
							}
							if (roomtype[i].equals("�𷰽�") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							} else if (roomtype[i].equals("�𷰽�") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							}
						}
						if (guest == 1 || guest == 2) {
							if (roomtype[i].equals("����") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							} else if (roomtype[i].equals("����") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							}
						}
						if (guest == 1) {
							if (roomtype[i].equals("�̱�") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							} else if (roomtype[i].equals("�̱�") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "ȣ: " + roomtype[i] + "��");
							}
						}
					}
					// ���⼭ �Խ�Ʈ�� 2�� �����ص� �̱۷��� ���� �ִ� ��������

					int selectroom = scan.nextInt();
					if (selectroom == 0) {
						break;
					}

					for (int i = 0; i < roomN.length; i++) {
						if (roomN[i] == selectroom) {
							System.out.println("������ҿ� ��й�ȣ�� �Է��ϼ���. (0001~9999 ����)");
							String scanpw = scan.next();
							pw[i] = Integer.parseInt(scanpw);

							if (Integer.parseInt(scanpw) < 10000 && Integer.parseInt(scanpw) > 0) {
								System.out.println(roomN[i] + "ȣ�� ���� �Ϸ�");
								bookcheck[i] = 1;
								pw[i] = Integer.parseInt(scanpw);
								case1 = true;
							} else {
								System.out.println("0000~9999�� ��й�ȣ�� ������ּ���.");
							}
						}
					}
				}
				continue;

			case 2:
				System.out.println("��������� ȣ���� �Է����ּ���. (ó������: 0��)");
				select = scan.nextInt();

				for (int i = 0; i < roomN.length; i++) {
					if (roomN[i] == select && bookcheck[i] == 1) {
						System.out.println("���� ��й�ȣ�� �Է��ϼ���.");
						String scanpw = scan.next();

						if (pw[i] == Integer.parseInt(scanpw)) {
							System.out.println("������ ����߽��ϴ�.");
							roomN[i] = 0;
							pw[i] = 0;
							break;
						} else {
							System.out.println("��й�ȣ�� Ʋ���ϴ�.");
							break;
						}
					}
				}
				// ������ �ȵǾ��ִ� ���� ����Ϸ������� ���� �ʿ�
				continue;

			case 3:
				System.out.println("���� ���� ��Ȳ�Դϴ�. (���డ��: ��)");
				for (int i = 0; i < roomN.length; i++) {
					System.out.print(roomN[i] + "ȣ: " + roomtype[i] + "�� ");
					if ((i + 1) % 6 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				continue;

			case 99:
				power = true;
				break;
			}
		}
		System.out.println("����~");
		scan.close();
	}
}
