package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report23_3 {

	public static void main(String[] args) {
		// �Է�
		Scanner scan = new Scanner(System.in);
		// ����
		boolean power = false;
		// �޴� ��ư
		int button = 0;
		int button2 = 0;
		// ����� ���� (�̸�, ����, ���)
		String[] dName = null;
		int[] dPrice = null;
		int[] dAmount = null;
		dName = new String[] { "�����ݶ�", "���λ��̴�", "����ȯŸ" };
		dPrice = new int[] { 1000, 2000, 3000 };
		dAmount = new int[] { 4, 3, 2 };
		// �� ����(�ܵ� ����)
		int money = 0;
		// �Ž����� ����
		int[] mChange = null;
		mChange = new int[] { 10000, 5000, 1000, 500, 100, 50, 10 };
		// �����ڸ��
		int password = 4444;
		int pass = 0;
		// ��ǰ ���� ����
		String[] n_dName = new String[dName.length];
		int[] n_dPrice = new int[dPrice.length];
		int[] n_dAmount = new int[dAmount.length];

		while (!power) {
			System.out.println("======================");
			System.out.println("         ���Ǳ�         ");
			System.out.println("======================");
			System.out.println("     1. �մ� ��塡    �� ");
			System.out.println("     2. ������ ��塡����  ");
			System.out.println("     99. �����ϱ⡡�������� ");
			System.out.println("======================");
			System.out.print("   ��ȣ�� �Է��� �ּ��� : ");
			button = scan.nextInt();
			switch (button) {
			case 1: // �մԸ��
				while (button != 88) { // 88��(ó������) �Է����� ������ ȭ�� �ٽ� ���
					System.out.println("======================");
					System.out.printf("   ���� �ܾ� : %d��\n", money);
					System.out.println("======================");
					for (int i = 0; i < dName.length; i++) {
						System.out.printf(" %d. %s �̱�(%d��)(%d��)\n", (i + 1), dName[i], dPrice[i], dAmount[i]);
					}
					System.out.println(" 4. �ݾ� �����ϱ�");
					System.out.println(" 5. �Ž����� ��ȯ�ϱ�");
					System.out.println(" 88. ó������");
					System.out.println("======================");
					System.out.print("  ��ȣ�� �Է��� �ּ��� :");
					button = scan.nextInt();
					switch (button) {
					case 1: // 1�� ���� �̱�
						if (money >= dPrice[0] && dAmount[0] != 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.printf("  %s�� ���Խ��ϴ�.\n", dName[0]);
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							money -= dPrice[0];
							dAmount[0] -= 1;
						} else if (money < dPrice[0]) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     �ܾ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						} else if (dAmount[0] == 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						}
						break;
					case 2: // 2�� ���� �̱�
						if (money >= dPrice[1] && dAmount[1] != 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.printf("  %s�� ���Խ��ϴ�.\n", dName[1]);
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							money -= dPrice[1];
							dAmount[1] -= 1;
						} else if (money < dPrice[1]) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     �ܾ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						} else if (dAmount[1] == 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						}
						break;
					case 3: // 3�� ���� �̱�
						if (money >= dPrice[2] && dAmount[2] != 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.printf("  %s�� ���Խ��ϴ�.\n", dName[2]);
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							money -= dPrice[2];
							dAmount[2] -= 1;
						} else if (money < dPrice[2]) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     �ܾ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						} else if (dAmount[2] == 0) {
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
							System.out.println("     ��� �����մϴ�.");
							System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						}
						break;
					case 4: // �ݾ� ����
						System.out.println("======================");
						System.out.print(" �����Ͻ� �ݾ��� �Է��� �ּ��� :");
						money += scan.nextInt();
						break;
					case 5: // �ܵ� ��ȯ
						System.out.println("======================");
						System.out.printf(" %d���� �ݳ��Ǿ����ϴ�.\n", money);
						System.out.print("( ");
						for (int i = 0; i < mChange.length; i++) { // �ܵ� �������
							if (money / mChange[i] != 0) {
								System.out.print(mChange[i] + "�� " + money / mChange[i]);
								if (mChange[i] >= 1000) {
									System.out.print("�� ");
								} else {
									System.out.print("�� ");
								}
								money = money % mChange[i];
							}
						}
						System.out.println(")");
						money = 0;
						break;
					case 88: // ó������
						break;
					default: // �־��� ��ȣ �� �ٸ� ��ȣ���ý�
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						break;
					}
				}
				break;
			case 2: // �����ڸ��
				while (button != 88) {
					System.out.println("======================");
					System.out.println("     1. ��й�ȣ �Է� ");
					System.out.println("     88. ó������ ");
					System.out.println("======================");
					System.out.print("   ��ȣ�� �Է��� �ּ��� : ");
					button = scan.nextInt();
					switch (button) {
					case 1: // ��й�ȣ �Է�
						System.out.println("======================");
						System.out.print("   ��й�ȣ�� �Է����ּ��� : ");
						pass = scan.nextInt();
						while (button != 88) {
							if (pass == password) { // ��й�ȣ�� ������ 
								System.out.println("======================");
								System.out.println("     1. ��ǰ ����");
								System.out.println("     2. ��ǰ���� ����");
								System.out.println("     3. ��ǰ��� ����");
								System.out.println("     88. ó������");
								System.out.println("======================");
								System.out.print("  ��ȣ�� �Է��� �ּ��� : ");
								button = scan.nextInt();
								switch (button) {
								case 1: // ��ǰ ����
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println("     " + (i + 1) + ". " + dName[i]);
										}
										System.out.println("     77. ����ȭ������");
										System.out.println("======================");
										System.out.print(" �����Ͻ� ��ǰ�� �������ּ��� : ");
										button = scan.nextInt();
										switch (button) {
										case 1: // 1�� ��ǰ ����(��ǰ����)
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ���ο� ��ǰ�� �Է��� �ּ��� : ");
											n_dName[button - 1] = scan.next();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("  %s�� %s�� ����Ǿ����ϴ�.\n", dName[button - 1],
													n_dName[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dName[button - 1] = n_dName[button - 1];
											break;
										case 2: // 2�� ��ǰ ����(��ǰ����)
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ���ο� ��ǰ�� �Է��� �ּ��� : ");
											n_dName[button - 1] = scan.next();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("  %s�� %s�� ����Ǿ����ϴ�.\n", dName[button - 1],
													n_dName[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dName[button - 1] = n_dName[button - 1];
											break;
										case 3: //3�� ��ǰ ����(��ǰ����)
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ���ο� ��ǰ�� �Է��� �ּ��� : ");
											n_dName[button - 1] = scan.next();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("  %s�� %s�� ����Ǿ����ϴ�.\n", dName[button - 1],
													n_dName[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dName[button - 1] = n_dName[button - 1];
											break;
										case 77: // ���ư���
											break;
										default: // �־��� ��ȣ �� ����
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											break;
										}
									}
									break;
								case 2: // ��ǰ ���ݺ���
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println(
													"     " + (i + 1) + ". " + dName[i] + "(" + dPrice[i] + "��)");
										}
										System.out.println("     77. ����ȭ������");
										System.out.println("======================");
										System.out.print(" ������ �����Ͻ� ��ǰ�� �������ּ��� : ");
										button = scan.nextInt();
										switch (button) {
										case 1: // 1�� ��ǰ ���ݺ���
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "("
													+ dPrice[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ������ ������ �Է��� �ּ��� : ");
											n_dPrice[button - 1] = scan.nextInt();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("%d������ %d������ ����Ǿ����ϴ�.\n", dPrice[button - 1],
													n_dPrice[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dPrice[button - 1] = n_dPrice[button - 1];
											break;
										case 2: // 2�� ��ǰ ���� ����
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "("
													+ dPrice[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ������ ������ �Է��� �ּ��� : ");
											n_dPrice[button - 1] = scan.nextInt();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("%d������ %d������ ����Ǿ����ϴ�.\n", dPrice[button - 1],
													n_dPrice[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dPrice[button - 1] = n_dPrice[button - 1];
											break;
										case 3: // 3�� ��ǰ ���� ����
											System.out.println("======================");
											System.out.println(button + ". " + dName[button - 1] + "("
													+ dPrice[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
											System.out.println("======================");
											System.out.print(" ������ ������ �Է��� �ּ��� : ");
											n_dPrice[button - 1] = scan.nextInt();
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.printf("%d������ %d������ ����Ǿ����ϴ�.\n", dPrice[button - 1],
													n_dPrice[button - 1]);
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											dPrice[button - 1] = n_dPrice[button - 1];
											break;
										case 77: // ���ư���
											break;
										default: // �־��� ��ȣ�� ����
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											break;
										}
									}
									break;
								case 3: // ��ǰ ��� ����
									while (button != 77) {
										System.out.println("======================");
										for (int i = 0; i < dName.length; i++) {
											System.out.println(
													"     " + (i + 1) + ". " + dName[i] + "(" + dAmount[i] + "��)");
										}
										System.out.println("     77. ����ȭ������");
										System.out.println("======================");
										System.out.print("��� �����Ͻ� ��ǰ�� �������ּ��� : ");
										button = scan.nextInt();
										switch (button) {
										case 1: // 1����ǰ ��� ����
											while (button != 77) {
												System.out.println("======================");
												System.out.println(button + ". " + dName[button - 1] + "("
														+ dAmount[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
												System.out.println("======================");
												System.out.println("     1. ��� �߰�");
												System.out.println("     2. ��� ����");
												System.out.println("     77. ��������");
												System.out.println("======================");
												System.out.print(" ��ȣ�� ������ �ּ���. : ");
												button2 = scan.nextInt();
												switch (button2) {
												case 1: // ��� �߰�
													System.out.println("======================");
													System.out.println("       ��� �߰�");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] + scan.nextInt();
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
															n_dAmount[button - 1]);
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													dAmount[button - 1] = n_dAmount[button - 1];
													button = 77;
													break;
												case 2: // ��� ����
													System.out.println("======================");
													System.out.println("       ��� ����");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] - scan.nextInt();
													if (n_dAmount[button - 1] >= 0) {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
																n_dAmount[button - 1]);
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														dAmount[button - 1] = n_dAmount[button - 1];
													} else {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.println("���� 0������ �۾����� �����ϴ�.");
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													}
													button = 77;
													break;
												case 77: // ���ư���
													break;
												default: // �־��� ��ȣ �� ����
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													break;
												}
											}
											button = 3; // ���� �� 3�� ȭ������ ���ư�
											break;
										case 2: // 2�� ��ǰ ��� ����
											while (button != 77) {
												System.out.println("======================");
												System.out.println(button + ". " + dName[button - 1] + "("
														+ dAmount[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
												System.out.println("======================");
												System.out.println("     1. ��� �߰�");
												System.out.println("     2. ��� ����");
												System.out.println("     77. ��������");
												System.out.println("======================");
												System.out.print(" ��ȣ�� ������ �ּ���. : ");
												button2 = scan.nextInt();
												switch (button2) {
												case 1: // ��� �߰�
													System.out.println("======================");
													System.out.println("       ��� �߰�");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] + scan.nextInt();
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
															n_dAmount[button - 1]);
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													dAmount[button - 1] = n_dAmount[button - 1];
													button = 77;
													break;
												case 2: // ��� ����
													System.out.println("======================");
													System.out.println("       ��� ����");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] - scan.nextInt();
													if (n_dAmount[button - 1] >= 0) {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
																n_dAmount[button - 1]);
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														dAmount[button - 1] = n_dAmount[button - 1];
													} else {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.println("���� 0������ �۾����� �����ϴ�.");
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													}
													button = 77;
													break;
												case 77: // ��� ���� �� ���� ȭ������ (�ݺ��� ����)
													break;
												default: // ��ȣ �� ���ý�
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													break;
												}
											}
											button = 3; // �Ϸ� �� 3�� ȭ������ ���ư�
											break;
										case 3: // 3����ǰ �����
											while (button != 77) {
												System.out.println("======================");
												System.out.println(button + ". " + dName[button - 1] + "("
														+ dAmount[button - 1] + "��)" + "�� ���� �ϼ̽��ϴ�.");
												System.out.println("======================");
												System.out.println("     1. ��� �߰�");
												System.out.println("     2. ��� ����");
												System.out.println("     77. ��������");
												System.out.println("======================");
												System.out.print(" ��ȣ�� ������ �ּ���. : ");
												button2 = scan.nextInt();
												switch (button2) {
												case 1: // ��� �߰�
													System.out.println("======================");
													System.out.println("       ��� �߰�");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] + scan.nextInt();
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
															n_dAmount[button - 1]);
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													dAmount[button - 1] = n_dAmount[button - 1];
													button = 77;
													break;
												case 2: // ��� ����
													System.out.println("======================");
													System.out.println("       ��� ����");
													System.out.println("======================");
													System.out.print(" ������ ��ġ�� �Է��� �ּ��� : ");
													n_dAmount[button - 1] = dAmount[button - 1] - scan.nextInt();
													if (n_dAmount[button - 1] >= 0) {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.printf("%d������ %d���� ����Ǿ����ϴ�.\n", dAmount[button - 1],
																n_dAmount[button - 1]);
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														dAmount[button - 1] = n_dAmount[button - 1];
													} else {
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
														System.out.println("���� 0������ �۾����� �����ϴ�.");
														System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													}
													button = 77; //  ����� �� ���ư���
													break;
												case 77: // ���ư���(�ݺ��� ����)
													break;
												default: // �־��� ��ȣ �� ����
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
													System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
													break;
												}
											}
											button = 3; // ��� ���� ù ȭ������
											break;
										case 77: // ���ư��� (�ݺ��� ����)
											break;
										default: // �־��� ��ȣ �� ����
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											System.out.println("  �ùٸ� ��ȣ�� �Է��� �ּ���.");
											System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
											break;
										}
									}
									break;
								case 88: // ù ȭ������ ( �ݺ��� ����) 
									break;
								default: // �־��� ��ȣ �� ����
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
									System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���");
									System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
								}
							} else { // �Է��� ��й�ȣ�� Ʋ����
								System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
								System.out.println("    �߸��� ��й�ȣ�Դϴ�. ");
								System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
								break;
							}
						}
					case 88: // ó������ (�ݺ��� ���� )
						break;
					default: // �־��� ��ȣ  �� ����
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���");
						System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						break;
					}
				}
				break;
			case 99: // ���Ǳ� ���� (�ݺ��� ����)
				power = true;
				break;
			default: // �־��� ��ȣ �� ���ý�
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���");
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				break;
			}
		}
		System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
		System.out.println("        ���Ǳ� ����");
		System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
	}
}
