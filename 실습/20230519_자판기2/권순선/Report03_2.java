package kss.co.kr.array;

import java.util.Scanner;

public class Report03_2 {
	public static void main(String[] args) {

		boolean power = false;

		String id = "root";
		String pw = "a1234";

		String id2 = "";
		String pw2 = "";

		String[] dName = { "���̴�", "�ݶ�", "����" };

		int[] dPrice = { 2000, 3000, 5000 };

		int[] dAmount = { 10, 5, 7 };
		int money = 0;

		int num = 0;

		int pay = 0;
		int pay2 = 0;
		int pay3 = 0;
		int pay4 = 0;

		int count = 0;
		int count2 = 0;
		int count3 = 0;

		String xy = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("���Ǳ⸦ �����Ͻðڽ��ϱ� ( y, x )");
		System.out.print("���� >> ");
		xy = sc.next();

		switch (xy) {
		case "y":

			while (!power) {

				System.out.println("=======================���� ����=======================");
				System.out.println("1) " + dName[0] + " " + dPrice[0] + "�� ������ " + dAmount[0] + "��");
				System.out.println("2) " + dName[1] + " " + dPrice[1] + "�� ������ " + dAmount[1] + "��");
				System.out.println("3) " + dName[2] + " " + dPrice[2] + "�� ������ " + dAmount[2] + "��");
				System.out.println("4) ����");
				System.out.println("99) ������ ���");
				System.out.print("���� �Է� >> ");
				money += sc.nextInt();
				System.out.println("���� ���� �ݾ� " + money + "��");
				System.out.print("���� ���� ��ȣ�� ���� or ���� >>");
				num = sc.nextInt();

				switch (num) {
				case 1: // 1�� ���ý� ���� / ��� -1 / ���� ����� ���� ī��Ʈ

					if (money >= dPrice[0]) {
						System.out.println(dName[0] + "�� ����");
						dAmount[0] -= 1;
						money -= dPrice[0];
						System.out.println(dPrice[0] + "�� ����");
						System.out.println(dAmount[0] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
						count++;
					} else if (money < dPrice[0]) {
						System.out.println("====���� ����====");
					} else if (dAmount[0] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 2: // 2�� ���ý� ���� / ��� -1 / ���� ����� ���� ī��Ʈ

					if (money >= dPrice[1]) {
						System.out.println(dName[1] + "�� ����");
						dAmount[1] -= 1;
						money -= dPrice[1];
						System.out.println(dPrice[1] + "�� ����");
						System.out.println(dAmount[1] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
						count2++;
					} else if (money < dPrice[1]) {
						System.out.println("====���� ����====");
					} else if (dAmount[1] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 3: // 3�� ���ý� ���� / ��� -1 / ���� ����� ���� ī��Ʈ

					if (money >= dPrice[2]) {
						System.out.println(dName[2] + "�� ����");
						dAmount[2] -= 1;
						money -= dPrice[2];
						System.out.println(dPrice[2] + "�� ����");
						System.out.println(dAmount[2] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
						count3++;
					} else if (money < dPrice[2]) {
						System.out.println("====���� ����====");
					} else if (dAmount[2] == 0) {
						System.out.println("====��� ����====");
					}

					break;

				case 4: // ����� �ܵ� ����

					power = true;
					System.out.println(money + "�� �ܵ��Դϴ�");
					System.out.println("����");
					break;

				case 99: // ������

					System.out.println("���̵�� ��й�ȣ �Է�");
					System.out.print("���̵� >> ");
					id2 = sc.next();
					System.out.println();
					System.out.print("��й�ȣ >> ");
					pw2 = sc.next();
										
					if (id != id2 && pw != pw2) {

						while (num != 9) {

							System.out.println("1) ������, 2) ��ǰ����, 3) ���ݺ��� 4) ���� Ȯ�� 9) �ڷΰ���");
							System.out.print("��ȣ ���� >> ");
							num = sc.nextInt();

							switch (num) {
							case 1: // ���Ȯ�� �� ����

								while (num != 44) {

									for (int i = 0; i < dAmount.length; i++) {
										System.out.println("���� ��� " + dName[i] + " " + dAmount[i] + "��");
									}

									System.out.println();
									System.out.println("����� �Ͻ�?");
									System.out.println("1) OK, 44) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1�� ��� ���� >> ");
										dAmount[0] = sc.nextInt();
										dAmount[0] = dAmount[0];
										System.out.println("2�� ��� ���� >> ");
										dAmount[1] = sc.nextInt();
										dAmount[1] = dAmount[1];
										System.out.println("3�� ��� ���� >> ");
										dAmount[2] = sc.nextInt();
										dAmount[2] = dAmount[2];

										System.out.println("1�� " + dAmount[0] + "��");
										System.out.println("2�� " + dAmount[1] + "��");
										System.out.println("3�� " + dAmount[2] + "��");

										break;

									case 44:

										System.out.println("�ڷΰ���");

										break;
									}

								}

								break;

							case 2: // ��ǰ����

								while (num != 55) {

									for (int i = 0; i < dName.length; i++) {
										System.out.println("���� ��ǰ " + dName[i]);
									}

									System.out.println();
									System.out.println("��ǰ���� �Ͻ�?");
									System.out.println("1) OK, 55) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1�� ��ǰ ���� >> ");
										dName[0] = sc.next();
										dName[0] = dName[0];

										System.out.println("2�� ��ǰ ���� >> ");
										dName[1] = sc.next();
										dName[1] = dName[1];

										System.out.println("3�� ��ǰ ���� >> ");
										dName[2] = sc.next();
										dName[2] = dName[2];

										System.out.println("1�� " + dName[0]);
										System.out.println("2�� " + dName[1]);
										System.out.println("3�� " + dName[2]);

										break;

									case 55:

										System.out.println("�ڷΰ���");

										break;
									}

								}

								break;

							case 3: // ���ݺ���

								while (num != 66) {

									for (int i = 0; i < dPrice.length; i++) {
										System.out.println("���� ���� " + dName[i] + " " + dPrice[i]);
									}

									System.out.println();
									System.out.println("���ݺ��� �Ͻ�?");
									System.out.println("1) OK, 66) NO");
									num = sc.nextInt();

									switch (num) {
									case 1:

										System.out.println("1�� ���� ���� >> ");
										dPrice[0] = sc.nextInt();
										dPrice[0] = dPrice[0];
										System.out.println("2�� ���� ���� >> ");
										dPrice[1] = sc.nextInt();
										dPrice[1] = dPrice[1];
										System.out.println("3�� ���� ���� >> ");
										dPrice[2] = sc.nextInt();
										dPrice[2] = dPrice[2];

										System.out.println("1�� " + dPrice[0] + "��");
										System.out.println("2�� " + dPrice[1] + "��");
										System.out.println("3�� " + dPrice[2] + "��");

										break;

									case 66:

										System.out.println("�ڷΰ���");

										break;
									}

								}

								break;

							case 4: // �Ѹ��� Ȯ��

								pay = count * dPrice[0];
								pay2 = count2 * dPrice[1];
								pay3 = count3 * dPrice[2];
								System.out.println(dName[0] + " " + dPrice[0] + "�� " + count + "�� �Ǹ�");
								System.out.println(dName[1] + " " + dPrice[1] + "�� " + count2 + "�� �Ǹ�");
								System.out.println(dName[2] + " " + dPrice[2] + "�� " + count3 + "�� �Ǹ�");
								pay4 = pay + pay2 + pay3;
								System.out.println("�� ���� " + pay4 + "�� �Դϴ�");
								System.out.println();

								break;

							case 9:

								System.out.println("�ڷΰ���");

								break;

							}

						}

					} else {

						System.out.println("���̵� ��й�ȣ�� Ʋ���ϴ�");
						System.out.println("�ٽ� �Է��ϼ���");

					}

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
