package kr.co.man.array;

import java.util.Scanner;

public class Report07_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean power = false; // ����
		String[] dName = { "�ݶ�", "���̴�", "Ŀ��" }; // ��ǰ �̸�
		String pass1 = "0927"; // ���� ��й�ȣ
		String pass2 = "";	// �Է¹޴� ��й�ȣ
		int[] dPrice = { 600, 700, 800 }; // ��ǰ ����
		int[] dAmount = { 10, 10, 10 }; // ��ǰ ����
		int[] dCount = { 0, 0, 0 };
		int[] coin = { 10, 10, 10, 10, 10, 10 }; // 100��, 500��, 1000��, 5000��, 10000��, 50000�� �ܵ� ��
		int[] coinType = { 100, 500, 1000, 5000, 10000, 50000 };
		int input = 0; // �Է¹ޱ�
		int money = 0; // �ܾ�

		while (!power) { // ���Ǳ� ���� on
			System.out.println(
					"==============================================================================================");
			System.out.println("                                            ���Ǳ�"); // �޴� ���� ����
			for (int i = 0; i < 3; i++) {
				System.out.print(+(i + 1) + "." + dName[i] + " " + dPrice[i] + "�� ����:" + dAmount[i] + "��\t"); // �޴�
			}
			System.out.print("7.�ܵ���ȯ \t55.������ \t99.����");
			System.out.println();
			System.out.println("�޴��� �Է��ϰų� �ݾ��� �������ּ���");
			System.out.println("�ܾ� : " + money); // �ܾ�
			input = scan.nextInt(); // �Է¹ޱ�
			switch (input) { // �޴����� Ȥ�� �ݾ����� ����
			case 1: // �޴������� ��ǰ����
				if (money >= dPrice[0]) {
					if (dAmount[0] >= 0) {
						System.out.println(dName[0] + " ���Խ��ϴ�.");
						money -= dPrice[0];
						dAmount[0]--;
						dCount[0]++;
					} else {
						System.out.println("ǰ���Դϴ�");
					}
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 2:
				if (money >= dPrice[1]) {
					if (dAmount[0] >= 0) {
						System.out.println(dName[1] + " ���Խ��ϴ�.");
						money -= dPrice[1];
						dAmount[1]--;
						dCount[1]++;
					} else {
						System.out.println("ǰ���Դϴ�");
					}
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 3:
				if (money >= dPrice[2]) {
					if (dAmount[2] >= 0) {
						System.out.println(dName[2] + " ���Խ��ϴ�.");
						money -= dPrice[2];
						dAmount[2]--;
						dCount[2]++;
					} else {
						System.out.println("ǰ���Դϴ�");
					}
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 7:
				for(int j=coin.length-1; j>=0; j--) {
					if (money>=coinType[j]) {
						int temp =  money / coinType[j];
						System.out.println(coinType[j]+"�� : " + temp + "��");
						coin[j] -= temp;
						money %= coinType[j];
					}
				}
				break;
			case 55: // �����ڸ�� ����
				int i = 1;
				while (true) {
					System.out.println("��й�ȣ : ");
					pass2 = scan.next();
					if (pass1.equals(pass2)) {
						System.out.println("������ ����Դϴ�.");
						System.out.println("1.����� 2.ǰ�񺯰� 3.���ݺ��� 4.�Ա�/��� 5.�Ǹ���Ȳ 6.��й�ȣ���� 99.����");
						input = scan.nextInt();
						while (true) {
							switch (input) {
							case 1:
								System.out.println("����� �޴��Դϴ�.");
								System.out.println("1.�������߰� 2.���������� 3.���������� 99.����");
								input = scan.nextInt();
								switch (input) {
								case 1: // ��� �߰� ���� ����
									while (true) {
										System.out.println("�߰��Ͻ� ǰ���� �Է����ּ���.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.����");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "�� �߰��Ͻ� ������ �Է����ּ���");
												int amountCount = scan.nextInt();
												dAmount[input - 1] += amountCount;
												System.out.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
									} // ��� �߰� ���� ��
								continue ;
								case 2: // ��� ���� ���� ����
									while (true) {
										System.out.println("���� ǰ���� �Է����ּ���.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.����");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out
														.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "�� ���� ������ �Է����ּ���");
												int amountCount = scan.nextInt();
												dAmount[input - 1] -= amountCount;
												System.out.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
									} // ��� ���� ���� 
									break;
								case 3: // ��� ���� ���� ����
									while (true) {
										System.out.println("�����Ͻ� ǰ���� �Է����ּ���.");
										for (int j = 0; j < dName.length; j++) {
											System.out.print((j + 1) + "." + dName[j] + "\t");
										}
										System.out.println("99.����");
										input = scan.nextInt();
											if (input >= 0 && input <= 3) {
												System.out
														.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1]);
												System.out.println(dName[input - 1] + "�� �����Ͻ� ������ �Է����ּ���");
												int amountCount = scan.nextInt();
												dAmount[input - 1] = amountCount;
												System.out.println(dName[input - 1] + "�� ���� ���� : " + dAmount[input - 1] + "\n");
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
									}
									break;
								case 99:
									break;
								default:
									System.out.println("�߸��� �Է��Դϴ�.");
								} // ��� ���� ���� ��
								break;
							case 2: // ǰ�� ���� ����
								while (true) {
									System.out.println("ǰ�񺯰��Դϴ�");
									System.out.println("�����ϰ��� �ϴ� ǰ���� �������ּ���");
									for (int j = 0; j < dName.length; j++) {
										System.out.print((j + 1) + "." + dName[j] + "\t");
									}
									System.out.println("99.����");
									input = scan.nextInt();
									while (true) {
										if (input >= 0 && input <= 3) {
											System.out.println("�����ϰ��� �ϴ� ǰ���� �Է����ּ���");
											dName[input - 1] = scan.next();
											System.out.println("���� ǰ�񿡼� " + dName[input - 1] + "���� ����Ǿ����ϴ�");
											break;
										} else if (input == 99) {
											break;
										} else {
											System.out.println("�߸��� �Է��Դϴ�.");
										}
									}
									break;
								}
								break;
							case 3: // ��ǰ�� ������ ����
								while (true) {
									System.out.println("���ݺ����Դϴ�");
									System.out.println("�����ϰ��� �ϴ� ǰ���� �������ּ���");
									for (int j = 0; j < dName.length; j++) {
										System.out.print((j + 1) + "." + dName[j] + "\t");
									}
									System.out.println("99.����");
									input = scan.nextInt();
									while (true) {
										if (input >= 0 && input <= 3) {
											System.out.println("�����ϰ��� �ϴ� ������ �Է����ּ���");
											dPrice[input - 1] = scan.nextInt();
											System.out.println("���� ���ݿ��� " + dPrice[input - 1] + "���� ����Ǿ����ϴ�");
											break;
										} else if (input == 99) {
											break;
										} else {
											System.out.println("�߸��� �Է��Դϴ�.");
										}
									}
									break;
								}
								break;
							case 4: // ��/��� �޴�
								while (true) {
									System.out.println("�Ա�/��� �Դϴ�");
									System.out.println("���Ͻô� �޴��� �������ּ���");
									System.out.println("1.�Ա� 2.��� 3.��ȸ 99.����");
									input = scan.nextInt();
									switch (input) {
									case 1: // �Ա� �޴� ���ý�
										System.out.println("�Ա��ϰ��� �ϴ� �ݾ��� ��ȣ�� �Է����ּ���  99.����");
										for (int j = 0; j < coinType.length; j++) {
											System.out.print((j + 1) + "." + coinType[j] + "��     ");
										}
										input = scan.nextInt();
										while (true) {
											if (input >= 0 && input < coinType.length) {
												System.out.println("�Ա��ϰ��� �ϴ� ������ �Է����ּ���");
												int coinCount = scan.nextInt();
												coin[input-1] += coinCount;
												System.out.println("���� " + coinType[input - 1] + "���� ���� : " + coin[input - 1]);
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
										}
										break;
									case 2: // ��� �޴� ���ý�
										System.out.println("����ϰ��� �ϴ� �ݾ��� ��ȣ�� �Է����ּ���  99.����");
										for(int j=0; j<coinType.length; j++) {
											System.out.print((j + 1) + "." + coinType[j] + "��     ");
										}
										input = scan.nextInt();
										while (true) {
											if (input >= 0 && input < coinType.length) {
												System.out.println("����ϰ��� �ϴ� ������ �Է����ּ���");
												int coinCount = scan.nextInt();
												coin[input-1] -= coinCount;
												System.out.println("���� " + coinType[input - 1] + "���� ���� : " + coin[input - 1]);
												break;
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
										}
										break;
									case 3: // �ݰ� ���� �ִ� �ܵ��� ������ ��ȸ
										System.out.println("���� �ܵ��� ��ȸ�մϴ�");
										for(int j=0; j<coinType.length; j++) {
											System.out.println(coinType[j]+"�� : "+ coin[j]);
										}
										break;
									case 99:
										break;
									default:
										System.out.println("�߸��� �Է��Դϴ�.");
									}
									break;
								}
								break;
							case 5:	// �Ǹ� ��Ȳ
								System.out.println("�Ǹ� ��Ȳ�Դϴ�");
								for (int j = 0; j < dName.length; j++) {
									System.out.println(dName[j] + " �Ǹż��� : " + dCount[j] + " ���� : " + (dCount[j] * dPrice[j]));
								}
								break;
							case 6: // ��й�ȣ ����
								System.out.println("��й�ȣ �����Դϴ�");
								System.out.println("���� ��й�ȣ�� �Է����ּ���");
								pass2 = scan.next();
								if (pass1.equals(pass2)) {
									System.out.println("�����ϰ��� �ϴ� ��й�ȣ�� �Է����ּ���");
									pass1 = scan.next();
								} else {
									System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
								}
								break;
							case 99:
								break;
							default:
								System.out.println("�߸��� �Է��Դϴ�.");
							}
							break;
						}
						break;
					} else { //��й�ȣ 3ȸ Ʋ���� ó������
						System.out.println("��й�ȣ��" + i + "ȸ Ʋ�Ƚ��ϴ�.");
						i++;
						if (i > 3) {
							break;
						}
					}
				}
				break; // �����ڸ�� ��
			case 99: // ���Ǳ� ����
				System.out.println("���Ǳ� ����");
				for(int j=coin.length-1; j>=0; j--) { // ���� �ܾ��� ��� ��ȯ
					if (money>=coinType[j]) {
						int temp =  money / coinType[j];
						System.out.println(coinType[j]+"�� : " + temp + "��");
						coin[j] -= temp;
						money %= coinType[j];
					}
				}
				power = true;
				break; // �޴����� ��
			case 100: // �ݾ� ����
				money += input; // �ܵ� ����
				coin[0]++;	// �ܵ� ���� ����
				break;
			case 500:
				money += input;
				coin[1]++;
				break;
			case 1000:
				money += input;
				coin[2]++;
				break;
			case 5000:
				money += input;
				coin[3]++;
				break;
			case 10000:
				money += input;
				coin[4]++;
				break;
			case 50000:
				money += input;
				coin[5]++;
				break; // �ݾ� ���� ��
			default: // �׿� ������������ �Է�
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			} // �޴����� Ȥ�� �ݾ����� ���� ��
		} // ���Ǳ� ���� ��
	}
}
