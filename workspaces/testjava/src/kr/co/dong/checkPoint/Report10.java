/*
 * _1 ���� ����
 * �����ڸ�� �߰�
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean power = false; // ����
		String[] dName = null; // �����̸�
		dName = new String[4];
		int[] dPrice = null; // ����
		dPrice = new int[4];
		int[] dAmount = null; // ��� ��
		dAmount = new int[4];
		int money = 0; // ��
		int choose = 0;
		int select = 0;

		dName[0] = "��";
		dName[1] = "�ݶ�";
		dName[2] = "Ŀ��";

		dPrice[0] = 1000;
		dPrice[1] = 1500;
		dPrice[2] = 2000;

		dAmount[0] = 7;
		dAmount[1] = 7;
		dAmount[2] = 7;
		while (!power) {
//			0. �� �Է�
			System.out.print("�� ���Ա��� ���� �־��ּ��� : ");
			money = money + scan.nextInt();

// 			1. ������ ������ ����
			System.out.println("==========[MENU]==========");
			System.out.print("1. ������ ����, ������ ����, ������ ��� �� | 2. ���� ����");
			System.out.println();
			System.out.println("5 . �� ��ȯ  |  90.������ ���  |  99. ���Ǳ�����");
			System.out.println("�� �ܾ� : " + money);
			while (!power) {
//			2. �޴� ����
				System.out.println("MENU�� ������ �ּ���.");
				choose = scan.nextInt();

//			3. �޴� �� �� ���� �� ���� �ܾ�
				switch (choose) {
				case 1:
					for (int i = 0; i < 3; i++) {
						System.out.println(dName[i] + " �Դϴ�.");
						System.out.println(dPrice[i] + "�� �Դϴ�.");
						System.out.println("���� ����" + dAmount[i] + "�� �Դϴ�.");
					}
					continue;
				case 2:
					System.out.println(
							"1. �� (" + dPrice[0] + ")" + "2.�ݶ� (" + dPrice[1] + ")" + "3.Ŀ�� (" + dPrice[2] + ")");
					select = scan.nextInt();
					if (select == 1) {
						System.out.println(dName[0] + "�Դϴ�." + "\n" + dPrice[0] + "�� �Դϴ�" + "\n���� ������"
								+ (dAmount[0] - 1) + "�� �Դϴ�.");
						money = money - dPrice[0];
						System.out.println("���� �ܾ��� : " + money);
						if (dAmount[0]-- == 1) {
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
					} else if (select == 2) {
						System.out.println(dName[1] + "�Դϴ�." + "\n" + dPrice[1] + "�� �Դϴ�" + "\n���� ������"
								+ (dAmount[1] - 1) + "�� �Դϴ�.");
						money = money - dPrice[1];
						System.out.println("���� �ܾ��� : " + money);
						if (dAmount[1]-- == 1) {
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
					} else if (select == 3) {
						System.out.println(dName[2] + "�Դϴ�." + "\n" + dPrice[2] + "�� �Դϴ�" + "\n���� ������"
								+ (dAmount[2] - 1) + "�� �Դϴ�.");
						money = money - dPrice[2];
						System.out.println("���� �ܾ��� : " + money);
						if (dAmount[2]-- == 1) {
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
					} else if (select == 4) {
						System.out.println(dName[3] + "�Դϴ�." + "\n" + dPrice[3] + "�� �Դϴ�" + "\n���� ������"
								+ (dAmount[3] - 1) + "�� �Դϴ�.");
						money = money - dPrice[3];
						System.out.println("���� �ܾ��� : " + money);
						if (dAmount[3]-- == 1) {
							System.out.println("�����Ǿ����ϴ�.");
							break;
						}
					}
					continue;
				case 5:
					System.out.println("�Ž��� �� ��ȯ");
					System.out.println("�Ž�����  : " + money + "�� ��ȯ�մϴ�  ");
					money = 0;
					System.out.println(money);

					continue;
				case 90:
					System.out.println("1. ��ǰ Ȯ��  2. ��� Ȯ��  3. ���ݺ���  4. ����߰�  5.��ǰ�߰� ");
					select = scan.nextInt();
					if (select == 1) {
						System.out.println("1. ��ǰ Ȯ��");
						System.out.println(dName[0] + " " + dName[1] + " " + dName[2]);
					} else if (select == 2) {
						System.out.println("2. ��� Ȯ��");
						System.out.println(dAmount[0] + " " + dAmount[1] + " " + dAmount[2]);
					} else if (select == 3) {
						System.out.println("3. ���ݺ���");
						System.out.print("���� ���� : ");
						dPrice[0] = scan.nextInt();
						System.out.print("���� ���� : ");
						dPrice[1] = scan.nextInt();
						System.out.print("���� ���� : ");
						dPrice[2] = scan.nextInt();
						System.out.print("���� ���� : ");
						dPrice[3] = scan.nextInt();
					} else if (select == 4) {
						System.out.print("��� �߰� ����: ");
						dAmount[0] = scan.nextInt();
						System.out.println(dAmount[0]);
						System.out.print("��� �߰� ����: ");
						dAmount[1] = scan.nextInt();
						System.out.println(dAmount[1]);
						System.out.print("��� �߰� ����: ");
						dAmount[2] = scan.nextInt();
						System.out.println(dAmount[2]);
						System.out.print("��� �߰� ����: ");
						dAmount[3] = scan.nextInt();
						System.out.println(dAmount[3]);
					} else if (select == 5) {
						System.out.print("��ǰ�߰� : ");
						dName[3] = scan.next();
						System.out.println(dName[3]);
					}
					continue;

				case 99:
					power = true;
					System.out.println("���Ǳ� ����!!");
					break;
				default:
					System.out.println("�޴��� �ٽ� ������ �ּ���");
					break;
				}
			}
		}
	}
}
