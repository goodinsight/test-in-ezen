package kss.co.kr.array;

import java.util.Scanner;

public class Report03_4 {
	public static void main(String[] args) {

		boolean power = false;

		String id = "root";
		String pw = "1111";

		String id2 = "";
		String pw2 = "";

		String[] dName = { "���̴�", "�ݶ�", "����" };

		int[] dPrice = { 2000, 3000, 5000 };

		int[] dAmount = { 10, 5, 7 };
		int money = 0;

		int num = 0;

		int pay = 0;

		int[] count = { 0, 0, 0 };

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
				System.out.println();

				switch (num) {
				case 1: // 1�� ���ý� ���� / ��� -1 / ���� ����� ���� ī��Ʈ

					if (money >= dPrice[0]) {
						System.out.println(dName[0] + "�� ����");
						dAmount[0] -= 1;
						money -= dPrice[0];
						System.out.println(dPrice[0] + "�� ����");
						System.out.println(dAmount[0] + "�� ����");
						System.out.println(money + "�� ���ҽ��ϴ�");
						count[0]++;
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
						count[1]++;
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
						count[2]++;
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
					System.out.println(id2);
					System.out.println();
					System.out.print("��й�ȣ >> ");
					pw2 = sc.next();
					System.out.println(pw2);

					System.out.println(id + " " + id2);
					System.out.println(pw + " " + pw2);
					
					
					
					if (id.equals(id2) && pw.equals(pw2)) {
						
						System.out.println(id + " " + id2);
						System.out.println(pw + " " + pw2);
						System.out.println();
						

					} else if (!(id.equals(id2)) || !(pw.equals(pw2))) {
	
						System.out.println(id + " " + id2);
						System.out.println(pw + " " + pw2);
						System.out.println("���̵� ��й�ȣ�� Ʋ���ϴ�");
						System.out.println();
						
						break;

					} 
					while (num != 9) {

						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("1) ������, 2) ��ǰ����, 3) ���ݺ���, 4) ���� Ȯ��");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("5) ������ ���̵� ����, 6) ������ ��й�ȣ ����, 9) �ڷΰ���");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
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
								System.out.print("1) OK, 44) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dAmount.length; i++) {

										System.out.print(dName[i] + " ����� >> ");
										dAmount[i] = sc.nextInt();
										dAmount[i] = dAmount[i];

										System.out.println();

										System.out.println(dName[i] + " " + dAmount[i] + "�� ��� ����Ǿ����ϴ�");

									}

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
								System.out.print("1) OK, 55) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dName.length; i++) {

										System.out.print(dName[i] + " ��ǰ���� >> ");
										dName[i] = sc.next();
										dName[i] = dName[i];

										System.out.println();

										System.out.println(dName[i] + " ��ǰ�� ����Ǿ����ϴ�");

									}

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
								System.out.print("1) OK, 66) NO >>");
								num = sc.nextInt();

								switch (num) {
								case 1:

									for (int i = 0; i < dPrice.length; i++) {

										System.out.print(dName[i] + " " + dPrice[i] + " ���ݺ��� >> ");
										dPrice[i] = sc.nextInt();
										dPrice[i] = dPrice[i];

										System.out.println();

										System.out.println(dName[i] + " " + dPrice[i] + "�� ������ ����Ǿ����ϴ�");

									}

									break;

								case 66:

									System.out.println("�ڷΰ���");

									break;
								}

							}

							break;

						case 4: // �Ѹ��� Ȯ��

							for (int i = 0; i < count.length; i++) {

								pay += count[i] * dPrice[i];
								System.out.println(dName[i] + " " + dPrice[i] + "�� " + count[i] + "�� �Ǹ�");

							}

							System.out.println("�� ���� " + pay + "�� �Դϴ�");
							System.out.println();

							break;

						case 5: // ������ ���̵� ����

							while (num != 77) {

								System.out.println(id);
								System.out.println("������ ���̵� ���� �Ͻ�?");
								System.out.print("1) OK, 77) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									System.out.print("������ ���̵� ���� >> ");
									id2 = sc.next();
									id = id2;
									System.out.println(id);

									break;

								case 77:

									System.out.println("�ڷΰ���");

									break;
								}

							}

							break;

						case 6: // ������ ��й�ȣ ����

							while (num != 88) {

								System.out.println(pw);
								System.out.println("������ ��й�ȣ ���� �Ͻ�?");
								System.out.print("1) OK, 88) NO >> ");
								num = sc.nextInt();

								switch (num) {
								case 1:

									System.out.print("������ ��й�ȣ ���� >> ");
									pw2 = sc.next();
									pw = pw2;
									System.out.println(pw);

									break;

								case 77:

									System.out.println("�ڷΰ���");

									break;
								}

							}

							break;

						case 9:

							System.out.println("�ڷΰ���");

							break;

						}

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
