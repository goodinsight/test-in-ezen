package kr.co.dong;

import java.util.Scanner;

public class Report10 {

	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2.���� 3���� ����/ ���� ���� /����
//		3.���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ����, ����, �Ž����� ��ȯ, ���Է� ��
//		 	99. ���Ǳ� ����
//		4.99�̿��� ������ ��� ȭ��޴� �����ֱ�

		boolean power = false; // ����
//		�޴��Է� , ���� ��, ���� �̸�1,2,3/����1,2,3, �Ž�����
		Scanner scan = new Scanner(System.in);


		String water = "��";
		String coffee = "Ŀ��";
		String ade = "���̵�";
		String menu;

		int waterprice = 1000;
		int coffeeprice = 800;
		int adeprice = 500;

		int waterinventory = 7;
		int adeinventory = 7;
		int coffeeinventory = 7;

		while (!power) {
			System.out.println("=========================�޴�===========================");
			System.out.println("�� �� ������: " + waterprice + "�� �̰�," + " ���� ������ " + waterinventory + "�� �Դϴ�.");
			System.out.println("Ŀ���� ������ : " + coffeeprice + "�� �̰�," + " ���� ������ " + coffeeinventory + "�� �Դϴ�.");
			System.out.println("���̵��� ������ : " + adeprice + "���̰�," + " ���� ������ " + adeinventory + "�� �Դϴ�.");
			System.out.print("���� ���� : ");
			int money = scan.nextInt();
			int change1 = money - waterprice;
			int change2 = money - coffeeprice;
			int change3 = money - adeprice;
			System.out.println("�޴��� ������ �ּ���");

			if (money >= waterprice) {
				System.out.println(water + "�� ���ӽ��ϴ�");
			} else if (money >= coffeeprice) {
				System.out.println(coffee + "�� ���ӽ��ϴ�");
			} else if (money >= adeprice) {
				System.out.println(ade + "�� ���ӽ��ϴ�");
			}
			if (waterprice <= money) {
				System.out.println("�Ž�������  : " + change1 + "�� �Դϴ�");
			} else if (coffeeprice <= money) {
				System.out.println("�Ž�������  : " + change2 + "�� �Դϴ�");
			} else if (adeprice <= money) {
				System.out.println("�Ž������� :  " + change3 + "�� �Դϴ�");
			} else {
				System.out.println();
			}

			break;

		}
		System.out.println("���Ǳ� ����!!");

	}

}
