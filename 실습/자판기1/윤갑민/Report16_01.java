package kr.co.dong;

import java.util.Scanner;

public class Report16_01 {

	public static void main(String[] args) {

		boolean power = false;

//				���� ����
		int cokePrice = 500; // coke ����
		int ciderPrice = 600; // cider����
		int coffeePrice = 700; // coffee ����
		int cokeNum = 10, ciderNum = 20, coffeeNum = 30; // ���
		int reTurnCoin = 0; // �Ž�����
		int finish = 0; // ����
		int coke = 0, cider = 0, coffee = 0;
		int insertCoin = 0; // ���Աݾ�
		int selectMenu = 0; // �޴�����
		int menuNum = 0;
		int coke1 = 0, cider1 = 0, coffee1 = 0;

		coke1 = cokeNum; // ���� ���
		cider1 = ciderNum;
		coffee1 = coffeeNum;

		coke = cokePrice; // ���� ����
		cider = ciderPrice;
		coffee = coffeePrice;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println();
			System.out.println("=========Menu===========");
			System.out.println("1.coke = 500 2.cider = 600 3.coffee = 700");
			selectMenu = scan.nextInt();
			System.out.println("��� Ȯ��");
			menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
				if (coke1 > 0) {
					coke1 = coke1 - 1;
					System.out.println("coke ���� ������" + coke1);
				}else {
					System.out.println("��� ����");
				}
				break;
			case 2:
				if (cider1 > 0) {
					cider = cider1 -1;
					System.out.println("cider ���� ������" + cider1);
				}
				break;
			case 3:
				if (coffee > 0) {
					coffee -= 1;
					System.out.println("coffee ���� ������" + coffee1);
				}
				break;
			default:
				break;
			}
			System.out.println("���Աݾ�");
			insertCoin = scan.nextInt();
			System.out.println("���Աݾ��� " + insertCoin + "�Դϴ�.");

			switch (selectMenu) {
			case 1:
				if (insertCoin >= coke) {
					reTurnCoin = insertCoin - coke;
					System.out.printf("coke ���� �Ž������� %d �Դϴ�.", reTurnCoin);

				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 2:
				if (insertCoin >= cider) {
					reTurnCoin = insertCoin - cider;
					System.out.printf("cider ���� �Ž������� %d �Դϴ�." + reTurnCoin);
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 3:
				if (insertCoin >= coffee) {
					reTurnCoin = insertCoin - coffee;
					System.out.printf("coffee ����" + reTurnCoin);
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;

			default:
				break;
			}

			System.out.println("\n ��� ���� �ƹ� ��ư�̳� ��������");
			System.out.println(" \n ����� 99�� ��������");
			finish = scan.nextInt();
			if (finish == 99) {
				break;
			}
		}

	}

}
