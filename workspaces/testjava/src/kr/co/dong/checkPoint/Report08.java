package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report08 {
	public static void main(String[] args) {
//		- 3���� ���� / ������ ���� / ���
//		- ȭ�鿡 �޴� ���
//		- ����, ����, ���, �Ž�����, �Աݾ� ��

		boolean power = true; // ����
//		�޴��Է�, ��, ��ǰ��1.2.3, ����1.2.3, �Ž�����
		int pr1 = 1000, pr2 = 2000, pr3 = 3000,
			st1 = 999, st2 = 999, st3 = 999,
			wal = 99999, in = 0, ch = 0;
		String na1 = "water", na2 = "coffee", na3 = "coke";
		Scanner scan = new Scanner(System.in);

		while (power) {
			System.out.print("=====[MENU]=====\n1." + na1 + ": " + pr1 + "w	"
					+ "2." + na2 + ": " + pr2 + "w	" + "3." + na3 + ": " + pr3 + "w" 
					+ "\n(5 �Է½� �ܵ���ȯ, 99 �Է½� ����)\n\n");

			if (wal <= 0) {
				System.out.println("�ܵ� ����");
				break;
			}
			if (st1 <= 0 || st2 <= 0 || st3 <= 0) {
				System.out.println("��� ����");
				break;
			}

			System.out.print("���� ���� : ");
			in += scan.nextInt();
			wal += in;

			System.out.print("��ǰ ���� : ");
			ch = scan.nextInt();

			switch (ch) {
			case 1:
				if (in >= pr1) {
					System.out.println("\n" + na1 + " out");
					System.out.println("�Ž����� : " + (in -= pr1) + "w");
					wal -= (in -= pr1);
					st1--;
					break;
				} else {
					System.out.println("�ݾ׺���");
					System.out.println("��ȯ�� : " + in + "w");
					wal -= in;
					break;
				}
			case 2:
				if (in >= pr2) {
					System.out.println("\n" + na2 + " out");
					System.out.println("�Ž����� : " + (in -= pr2) + "w");
					wal -= (in -= pr2);
					st2--;
					break;
				} else {
					System.out.println("�ݾ׺���");
					System.out.println("��ȯ�� : " + in + "w");
					wal -= in;
					break;
				}
			case 3:
				if (in >= pr3) {
					System.out.println("\n" + na3 + " out");
					System.out.println("�Ž����� : " + (in -= pr3) + "w");
					wal -= (in -= pr3);
					st3--;
					break;
				} else {
					System.out.println("�ݾ׺���");
					System.out.println("��ȯ�� : " + in + "w");
					wal -= in;
					break;
				}
			case 5:
				System.out.println("��ȯ�� : " + in + "w");
				in = 0;
				break;
			case 99:
				power = false;
				break;
			default:
				System.out.println("�ٸ� ��ǰ�� �����ϼ���");
				break;
			}
		}
		System.out.println("\noff");
	}
}
