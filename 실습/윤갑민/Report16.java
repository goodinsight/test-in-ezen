package kr.co.dong;

import java.util.Scanner;

public class Report16 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� / ���� ����/ ����
//		3.  ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1. ������ ������ ����, ����, �Ž����� ��ȯ, �� �Է� ��
//			99. ���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ�� �޴� �����ֱ�

		boolean power = false; // ����
//		�޴� �Է�, ��, �����̸� 1,2,3 / ���� 1,2,3 �Ž�����
		Scanner scan = new Scanner(System.in);

		int coke = 700, cider = 600, coffee = 500;
		int button1 = 0, button2 = 0, button3 = 0;
		int totalCoin = 0;
		int menu = 0;
		int coke1 = 0, cider1 = 0, coffee1 = 0;

		System.out.println("Menu : 1.Coke - 700 2.Cider - 600 3. Coffee - 500");
		System.out.println("������ �����ϼ���");
		totalCoin = totalCoin + scan.nextInt();
		System.out.println("���Ե� ������ " + totalCoin);
		while (!power) {
			System.out.println("�޴� ��ȣ�� �����ϼ���");
			menu = scan.nextInt();
			if (menu == 1) {
				button1 = totalCoin - coke;
				System.out.printf("coke ����, �Ž������� %d ", button1);
				if (button1 < coke) {
					System.out.println("�ݾ��� �����մϴ�.");
				}
			}

			if (menu == 2) {
				button2 = totalCoin - cider;
				System.out.printf("cider ����, �Ž������� %d " , button2);
				if (button2 < cider) {
					System.out.println("�ݾ��� �����մϴ�.");
				}
			}
			if (menu == 3) {
				button3 = totalCoin - coffee;
				System.out.printf("coffee ���� %d ", button3);
				if (button3 < coffee) {
					button3 = 0;
					System.out.println("�ݾ��� �����մϴ�.");

				}
				System.out.println("���Ǳ� ����!!");
			}
		}
	}
}
