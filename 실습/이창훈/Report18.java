package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report18 {
	/*
	 * �������� 1. ������ ����� 
	 * 2. �� 10,50,100,500,1000���� �ν��ϰ� �ϱ�
	 * 3.
	 */

	public static void main(String[] args) {
		boolean power = false; // ����
//		�޴��Է�, ��, �����̸� ����1,2,3, �Ž�����
		int icetea = 1000, cider = 1700, coke = 1800;
		int iceteainv = 2, ciderinv = 0, cokeinv = 0;
		int money = 0;
//		int invselect = 0;

		Scanner scan = new Scanner(System.in);
		while (!power) {

			int select = 0;
			System.out.printf("���� �ܾ�: %d\n", money);
			System.out.println("����: 1)���̽�Ƽ 2)���̴� 3)�ݶ� 90)�� �ֱ� 99)���Ǳ� ����");
			select = scan.nextInt();

			switch (select) { // ���ἱ�� �� ���� ���� or ����
			case 1:
				if (icetea > money) {
					System.out.println("�ܾ��� �����մϴ�!");
					continue;
				} else if (iceteainv == 0) {
					System.out.println("��� �����մϴ�!");
					continue;
				} else {
					System.out.println("���̽�Ƽ�� ���Խ��ϴ�.");
					money -= 1000;
					iceteainv--;
					break;
				}
			case 2:
				if (cider > money) {
					System.out.println("�ܾ��� �����մϴ�!");
					continue;
				} else if (ciderinv == 0) {
					System.out.println("��� �����մϴ�!");
					continue;
				} else {
					System.out.println("���̴ٰ� ���Խ��ϴ�.");
					money -= 1700;
					ciderinv--;
					break;
				}
			case 3:
				if (coke > money) {
					System.out.println("�ܾ��� �����մϴ�!");
					continue;
				} else if (cokeinv == 0) {
					System.out.println("��� �����մϴ�!");
					continue;
				} else {
					System.out.println("�ݶ� ���Խ��ϴ�.");
					money -= 1800;
					cokeinv--;
					break;
				}
			case 90:
				System.out.print("���� �־��ּ���."); // �ӽ�: ���߿��� 10,50,100,500,1000�� ���ڸ� �����ϰ� ����.
				money += scan.nextInt();
				continue;

			case 99:
				if (money != 0) {
					System.out.println("�Ž����� " + money + "�� �Դϴ�.");
					money = 0;
				}
				power = true;
			}

		}

		System.out.println("���Ǳ� ����!!");
		scan.close();
	}

}