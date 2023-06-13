package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest08 {
	public static void main(String[] args) {
		int roomin = 0, markin = 0;
		boolean power = true;
		Scanner scan = new Scanner(System.in);
		int[][] room = { { 101, 2, 50000, 0 }, { 102, 2, 50000, 0 }, { 103, 2, 50000, 0 }, { 104, 2, 50000, 0 },
				{ 201, 2, 100000, 0 }, { 202, 2, 100000, 0 }, { 203, 2, 100000, 0 }, { 204, 2, 100000, 0 },
				{ 301, 4, 150000, 0 }, { 302, 4, 150000, 0 }, { 303, 4, 200000, 0 }, { 304, 6, 300000, 0 } };

		while (power == true) {
			System.out.print("\n==========[MENU]==========\n1. �� ����	2. ��������\n3. �������	4. ����Ȯ��"
							+ "\n99. ���α׷� ����\n\n�޴� ���� : ");
			markin = scan.nextInt();
			roomin = -1;

			switch (markin) {
			case 1:
//				�� ����
				for (int i = 1; i < 4; i++) {
					System.out.print("\n==================================================================\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						j++;
						System.out.print("    room" + j + "	||");
						j--;
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						System.out.print("  " + room[j][0] + "ȣ, " + room[j][1] + "�ν�	||");
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						System.out.print("  " + room[j][2] + "w	||");
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						if (room[j][3] == 0) {
							System.out.print("  ����ȵ�	||");
						} else {
							System.out.print("  �����	||");
						}
					}
				}
				System.out.println("\n==================================================================");
				break;
			case 2:
//				��������
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 0) {
					room[roomin][3] = 1;
					System.out.println("\n����Ϸ�");
				} else {
					System.out.println("\n����Ұ�(�����)");
				}
				break;
			case 3:
//				�������
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 1) {
					room[roomin][3] = 0;
					System.out.println("\n������� �Ϸ�");
				} else {
					System.out.println("\n������� �Ұ�(����ȵ�)");
				}
				break;
			case 4:
//				����Ȯ��
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 0) {
					System.out.println("\n���డ��");
				} else {
					System.out.println("\n�����");
				}
				break;
			case 99:
//				���α׷� ����
				power = false;
				System.out.println("\n�ý��� ����");
				break;
			default:
				System.out.println("\n���Է�");
				break;
			}
		}
	}
}
