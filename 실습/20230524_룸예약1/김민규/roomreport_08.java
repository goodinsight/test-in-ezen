package kr.co.doing;

import java.util.Scanner;

public class roomreport_08 {
	public static void main(String[] args) {
		int roomnum = 12, roomin = 0, markin = 0;
		boolean power = true;
		int[] room = new int[12];
		for (int i = 0; i < roomnum; i++) {
			room[i] = 0;
		}
		Scanner scan = new Scanner(System.in);

		while (power == true) {
			System.out.print("\n==========[MENU]==========\n1. ��������	2. �������	3. ����Ȯ��"
							+ "\n99. ���α׷� ����\n\n�޴� ���� : ");
			markin = scan.nextInt();
			roomin = 0;
			switch (markin) {
			case 1:
//				��������
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 0) {
					room[roomin] = 1;
					System.out.println("\n����Ϸ�");
				} else {
					System.out.println("\n����Ұ�(�����)");
				}
				break;
			case 2:
//				�������
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 1) {
					room[roomin] = 0;
					System.out.println("\n������� �Ϸ�");
				} else {
					System.out.println("\n������� �Ұ�(����ȵ�)");
				}
				break;
			case 3:
//				����Ȯ��
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 0) {
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
