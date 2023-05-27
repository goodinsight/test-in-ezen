package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest11 {
	public static void main(String[] args) {

		int[] room = new int[12]; // �� �迭
		String input = null; // �ܼ� �Է�
		int comm = 0; // �Է°� int ��ȯ
		boolean power = true; // ����

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < room.length; i++) {		// room �迭 0 �ʱ�ȭ
			room[i] = 0;
		}

		while (power) {		// ���� ȭ��
			System.out.println();
			System.out.println("[ �� ���� ���α׷� ]");
			System.out.println("(1)���� (2)���� ��� (3)���� Ȯ�� (99)����");
			System.out.print("����� �Է����ּ���. : ");
			input = scan.nextLine();
			comm = toint(input);

			if ((comm != 1 && comm != 2 && comm != 3 && comm != 99) || comm == -1) {
				System.out.println("***������ ���ڸ� �Է����ּ���.***");
				continue;
			}

			switch (comm) {
			case 1: 	// ����
				while (true) {
					System.out.println();
					System.out.print("������ ȣ���� �Է����ּ���. (1~12) : ");
					input = scan.nextLine();
					comm = toint(input) - 1;
					if (comm > 11 || comm < 0 || comm == -1) {
						System.out.println("***��Ȯ�� ȣ���� �Է����ּ���.***");
						continue;
					}
					if (room[comm] == 0) {
						System.out.println("��" + (comm + 1) + "ȣ���� �����߽��ϴ�.��");
						room[comm] = 1;
						break;
					} else if (room[comm] == 1) {
						System.out.println((comm + 1) + "ȣ���� �̹� ����Ǿ��ֽ��ϴ�.");
						break;
					}
				}

				break;

			case 2: 	// ���� ���
				while (true) {
					System.out.println();
					System.out.print("���� ����� ȣ���� �Է����ּ���. (1~12) : ");
					input = scan.nextLine();
					comm = toint(input) - 1;
					if (comm > 11 || comm < 0 || comm == -1) {
						System.out.println("***��Ȯ�� ȣ���� �Է����ּ���.***");
						continue;
					}
					if (room[comm] == 0) {
						System.out.println((comm + 1) + "ȣ���� ����Ǿ����� �ʽ��ϴ�.");
						break;
					} else if (room[comm] == 1) {
						room[comm] = 0;
						System.out.println("��" + (comm + 1) + "ȣ���� ������ ����߽��ϴ�.��");
						break;
					}
				}

				break;

			case 3: 	// ���� Ȯ��
				System.out.println("");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println((i + 1) + "ȣ�� : ���� ���� ��");
					} else if (room[i] == 1) {
						System.out.println((i + 1) + "ȣ�� : ����� ��");
					}
				}

				break;

			case 99: 	// ����
				System.out.println("�����մϴ�.");
				power = false;
				break;
			} // end of switch(comm)

		} // end of while(power)

	} // end of main

	private static int toint(String str) {		// int �Է� ����ó�� �޼ҵ�
		try {
			int result = Integer.parseInt(str);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

} // end of class

