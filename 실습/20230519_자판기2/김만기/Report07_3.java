package kr.co.man.array;

import java.util.Scanner;

public class Report07_3 {

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
		int[] coinType = { 100, 500, 1000, 5000, 10000, 50000 }; // 100��, 500��, 1000��, 5000��, 10000��, 50000��
		int password_Count = 1;
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
			case 1: case 2: case 3: // �޴������� ��ǰ����
				if (money >= dPrice[input-1]) {
					if (dAmount[input-1] >= 0) {
						System.out.println(dName[input-1] + " ���Խ��ϴ�.");
						money -= dPrice[input-1];
						dAmount[input-1]--;
						dCount[input-1]++;
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
											} else if (input == 99) {
												break;
											} else {
												System.out.println("�߸��� �Է��Դϴ�.");
											}
									} // ��� �߰� ���� ��
									break;
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
					} else { //��й�ȣ 3ȸ Ʋ���� ����
						System.out.println("��й�ȣ��" + password_Count + "ȸ Ʋ�Ƚ��ϴ�.");
						password_Count++;
						if (password_Count > 3) {
							System.out.println("���� �����մϴ�");
							power = true;
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
			case 100: case 500: case 1000: case 5000: case 10000: case 50000: // �ݾ� ����
				money += input; // �ܵ� ����
				for(int j=0; j<coinType.length;j++) { // �ܵ� ���� ����
					if(input == coinType[j]) {
						coin[j]++;
						break;
					}
				}
				break; // �ݾ� ���� ��
			default: // �׿� ������������ �Է�
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			} // �޴����� Ȥ�� �ݾ����� ���� ��
		} // ���Ǳ� ���� ��
	}
}
