package kss.co.kr.array;

import java.util.Scanner;

public class Report03 {
	public static void main(String[] args) {

		boolean power = false;

		String[] dName = { "���̴�", "�ݶ�", "����" };
		int[] dPrice = { 2000, 3000, 5000 };
		int[] dAmount = { 10, 5, 7 };
		int money = 0;
		int num = 0;
		String xy = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("���Ǳ⸦ �����Ͻðڽ��ϱ� ( y, x )");
		System.out.print("���� >> ");
		xy = sc.next();

		switch (xy) {
		case "y":

			while (!power) {

				System.out.println("=======================���� ����=======================");
				System.out.println("1) " + dName[0] + " " + dPrice[0] + "�� ��� �� " + dAmount[0]);
				System.out.println("2) " + dName[1] + " " + dPrice[1] + "�� ��� �� " + dAmount[1]);
				System.out.println("3) " + dName[2] + " " + dPrice[2] + "�� ��� �� " + dAmount[2]);
				System.out.println("4) ����");
				System.out.print("���� �Է� >> ");
				money += sc.nextInt();
				System.out.println("���� ���� �ݾ� " + money + "��");
				System.out.print("���� ���� ��ȣ�� ���� or ���� >>");
				num = sc.nextInt();

				switch (num) {
				case 1:

					if (money >= dPrice[0] && dAmount[0] > 0) {
						System.out.println(dName[0] + "�� ����");
						dAmount[0] -= 1;
						money -= dPrice[0];
						System.out.println(dPrice[0] + "�� ����");
						System.out.println(dAmount[0] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
					} else if (money < dPrice[0]) {
						System.out.println("====���� ����====");
					} else if (dAmount[0] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 2:

					if (money >= dPrice[1] && dAmount[1] > 0) {
						System.out.println(dName[1] + "�� ����");
						dAmount[1] -= 1;
						money -= dPrice[1];
						System.out.println(dPrice[1] + "�� ����");
						System.out.println(dAmount[1] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
					} else if (money < dPrice[1]) {
						System.out.println("====���� ����====");
					} else if (dAmount[1] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 3:

					if (money >= dPrice[2] && dAmount[2] > 0) {
						System.out.println(dName[2] + "�� ����");
						dAmount[2] -= 1;
						money -= dPrice[2];
						System.out.println(dPrice[2] + "�� ����");
						System.out.println(dAmount[2] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
					} else if (money < dPrice[2]) {
						System.out.println("====���� ����====");
					} else if (dAmount[2] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 4:

					power = true;
					System.out.println("����");
					System.out.println(money + "�� �ܵ��Դϴ�");
					break;

				default:

					break;

				}
			}

			break;

		case "x":

			power = true;

			System.out.println("����");

			break;

		}
	}
}
