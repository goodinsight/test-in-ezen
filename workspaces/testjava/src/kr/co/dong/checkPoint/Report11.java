/*
 * [_1 ���� ����]
 * 1.�����ڸ�� �߰�
 * 
 * 
 * [_1_1 ���� ����]
 * 1.���� while ���� ���� - ������ true�� �κ��� �׳� true�� ó��
 * 
 * 2.switch�� ����ȭ - �߸��� �Է°� �޴� ���Ḧ do-while�� if�� �������� ����
 * (���� �� �����ڸ�� input=99�� ������ �޴� ���� input=99�� ���� �����ڸ�尡 ����Ǵ� ��Ȳ -> �޴� ���� '��������' ����� 99���� 9�� ����)
 * 
 * 3.if�� ����ȭ - ���� ������ �켱 ��ġ
 * 
 * 4.���� ������ �� �󸶰� �������� ǥ��
 * 
 * 5.�����ڸ���� 'ǰ�� ����' �Է¿� ���Ⱑ �����ϰ� ����
 * (�Է��� nextLine���� ����, ��� �Էºκ��� nextLine���� �����ϴ� ��� 'ǰ�� ����'�� input ���Ŀ� nextLine�� ��ġ�� ���� ����)
 * 
 * 6.�����ڸ���� '��� ����'�� '���� ����' �Է¿� ���� �Է� �Ұ�
 * (�ӽ� �Է¿� ����ϴ� tmp ������ ������ �ٷ� �Էµż� ���������ϱ� ���� ������ �� ���� ��, ��ȣ ���涧ó�� �ӽ� ������ �ٷ� ������ ����� ���� ����)
 * 
 * 
 * [_2 ���� ����]
 * 1.������ �迭�� ó��
 * (�迭 ���̰� �� ����� ���� ����� �����ڸ�� ���� �޴��� '��������' ����� 9���� 99�� ����)
 * 
 * 2.�ݺ����� ���� switch���� �迭�� Ȱ���� for������ ����
 * (����� �κ��� ���� do-while���� ���� ����� if������ ���ϰ� ó���ϱ� ���� while������ ����)
 * 
 * 3.�Ž����� ȭ��� ��ȯ�ϵ��� ����
 * 
 * 4.�����ڸ�忡 '���� Ȯ��' �߰�
 * 
 * 5.��ǰ�� ���� ����� �ش� ������ �Ǹ� ���� �ʱ�ȭ�ǵ��� ����
 * 
 * 6.'��� ����'�� �ű� �Է� ����� �ƴ� ���� ���� ������� ����
 * 
 * 7.'���� ����' �޴����� ���� ������ ��ǰ�� ǥ���ϵ��� ����
 * 
 * 8.�����ڸ�忡 '��ü �缳��' �߰�
 * 
 * 
 * [_2_1 ���� ����]
 * 9.�ڵ尡 ���ؼ� input==99 �ߺ��� �Ͼ�� �ʾұ⿡ �����ڸ�� ������ '��������' ����� 99�� �ٽ� ����
 * 
 * 10.'���� Ȯ��'�� �Ѹ��� ������ �߸��Ǿ��־� ����
 * (���Ž� ���� ������ �����ϴ� dGain �迭�� �߰��ؼ� ���� Ȯ�� ���� �� ���� �Ѹ���� ǥ���ϵ��� ����)
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11 {

	public static void main(String[] args) {
//		1 ���� ���Ǳ� ����
//		2 ���� 3���� / ���� ���� / ��� ����
//		3 ���۰� ���ÿ� ȭ�鿡 �޴� ǥ��
//		3-1	������ ���� �� ����, ���, �Ž�����ȯ, ���Է� ��
//			99.���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ�� �޴� ǥ��
//
//		���ڿ� �Է� ��Ȳ�� ����ؼ� ó������ nextLine�� ����ϴ� ���� ��õ

		boolean power = false; // ����
		int input = 0; // �׸� ���� �Է�
		int tmp = 0; // ��ġ �Է°� �ӽ� ����
		int idx = 0; // �׸� ���ÿ��� ����Ǵ� �ε���

		int money = 0; // �����ִ� ��
		int money2 = 0; // �����ִ� ���� �����ڸ� �̸� ���� (�Ž��� �Ѿ�)
		int cha = 0; // �Ž��� ��� ����
		int moreNeed = 0; // ���Խ� ������ �ݾ�
		int tGain = 0; // �� ����

		String[] dName = null; // ���� �̸� �迭
		int[] dAmount = null; // ���� ��� �迭
		int[] dPrice = null; // ���� ���� �迭

		dName = new String[] { "�ݶ�", "Ŀ��", "����" }; // ���� �̸� �ʱⰪ
		dAmount = new int[] { 5, 5, 5 }; // ���� ��� �ʱⰪ
		dPrice = new int[] { 1500, 1800, 1000 }; // ���� ���� �ʱⰪ

		int[] dSell = new int[dName.length]; // ���� �Ǹ� �� �迭
		int[] dGain = new int[dName.length]; // ���� ���� �迭
		int[] dCoin = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // �Ž��� ȭ�� ���� ��
		int[] dCoinCount = new int[dCoin.length]; // �Ž��� ȭ�� ����
		String[] dCoinName = { "5����", "1����", "5õ��", "1õ��", "5���", "1���", "5�ʿ�", "1�ʿ�" }; // �Ž��� ȭ�� �̸�

		int pass = 1111; // ������ ��ȣ

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf("%n[ ���� ���Ǳ� ]%n"); // ���Ǳ� �ʱ� ȭ��
			for (int i = 0; i < dName.length; i++) {
				System.out.printf("%s / %d�� / ��� : %d%n", dName[i], dPrice[i], dAmount[i]);
			}

			System.out.printf("���� �� : %d��%n", money);
			System.out.println("(1)�� ���� (2)���� ���� (3)�Ž��� ��ȯ (66)������ ��� (99)���Ǳ� ����");

//					�Է� ����ó�� (���� �� �κи� �غ�)
//			-------------------------------------------------------------------------------

			while (true) { // ������ �߻����� �ʰ� ����Ǹ� break�� ����
				try {
					System.out.print("����� �Է����ּ��� : ");
					input = scan.nextInt(); // int�� �Է¸� ����
					break;
				} catch (Exception e) { // int�� �Է��� �ƴϾ��� �� catch
					System.out.println("***���ڸ� �Է����ּ���.***");
					scan = new Scanner(System.in); //
				}
			}

//			--------------------------------------------------------------------------------

			switch (input) {
			case 1: // �� ����
				while (true) {
					System.out.print("�󸶳� �ְڽ��ϱ�? : ");
					tmp = scan.nextInt();
					if (tmp < 0) {
						System.out.printf("%n***�ùٸ� �ݾ��� �Է����ּ���.***%n%n");
						continue;
					}
					money += tmp;
					break;
				}

				break; // case1 ������ -> case2 ���ᱸ������ �ٷ� ���� �Ϸ��� case1�� break ���ֵ� ��

			case 2: // ���� ����
				while (true) {
					System.out.println();
					tmp = 0;
					for (int i = 0; i < dName.length; i++) {
						if (money >= dPrice[i] && dAmount[i] != 0) {
							System.out.printf("(%d)%s / %d�� / ��� : %d%n", i + 1, dName[i], dPrice[i], dAmount[i]);
							tmp += 1;
						}
					}
					if (tmp == 0) {
						System.out.println("***������ �� �ִ� ��ǰ�� �����ϴ�.***");
						System.out.println("***��� Ȯ���ϰų� ����� ���� �������ּ���.***");
						break;
					}

					System.out.printf("���� �� : %d%n", money);
					System.out.print("���Ḧ �������ּ��� (99=ó������) : ");
					input = scan.nextInt();
					if ((input < 1 || input > dName.length) && input != 99) {
						System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
						continue;
					} else if (input == 99) {
						break;
					}

					idx = input - 1;

					if (money < dPrice[idx]) {
						moreNeed = dPrice[idx] - money;
						System.out.printf("%n***���� %d�� �����մϴ�.***%n", moreNeed);
						continue;
					} else if (dAmount[idx] <= 0) {
						System.out.printf("%n***%s ��� �����ϴ�.***%n", dName[idx]);
						continue;
					} else {
						System.out.printf("%s�� 1�� �����߽��ϴ�.%n", dName[idx]);
						money -= dPrice[idx];
						dAmount[idx]--;
						dSell[idx]++;
						dGain[idx] += dPrice[idx];
					}

				}
				break;

			case 3: // �Ž��� ��ȯ

				cha = money;
				money2 = money / 10 * 10;

				for (int i = 0; i < dCoin.length; i++) {
					if (cha >= dCoin[i]) {
						dCoinCount[i] = cha / dCoin[i];
						cha -= dCoinCount[i] * dCoin[i];
					}
				}
				System.out.println();
				for (int i = 0; i < dCoin.length; i++) {
					if (dCoinCount[i] >= 1) {
						System.out.printf("%s %d��, ", dCoinName[i], dCoinCount[i]);
					}
				}
				System.out.printf("%n�� %d�� ��ȯ�˴ϴ�. 10�� �̸��� ��ȯ���� �ʽ��ϴ�.%n", money2);

				money -= money2;

				break;

			case 66: // ������ ���
				System.out.print("������ ��ȣ�� �Է����ּ��� : ");
				tmp = scan.nextInt();
				if (tmp != pass) {
					System.out.printf("%n***��ȣ�� Ʋ�Ƚ��ϴ�***%n");
					break;
				}
				while (true) {
					System.out.printf("%n[ ������ ��� ]%n");
					System.out.printf("(1)��� ���� (2)ǰ�� ���� (3)���� ���� (4)���� Ȯ�� (5)��ü �缳�� (6)��ȣ ���� (99)������ ��� ����%n");
					System.out.print("����� �Է����ּ��� : ");
					input = scan.nextInt();
					if ((input < 1 || input > 6) && input != 99) {
						System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
						continue;
					} else if (input == 99)
						break;

					switch (input) {
					case 1: // ������ ��� - ��� ����
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("%s [%d]��%n", dName[i], dAmount[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)%s ��� ���� ", i + 1, dName[i]);
							}
							System.out.print("(99)��������");
							System.out.printf("%n����� �Է����ּ��� : ");
							input = scan.nextInt();
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("(1)%s ��� ���� (2)%s ��� ���� (99)��������", dName[idx], dName[idx]);
							System.out.printf("%n����� �Է����ּ��� : ");
							input = scan.nextInt();

							switch (input) {
							case 1: // ������ ��� - ��� ���� - ��� ����
								System.out.printf("������ų %s�� ���� �Է� : ", dName[idx]);
								tmp = scan.nextInt();
								if (tmp < 0) {
									System.out.printf("%n***0�� �̻��� ������ �Է����ּ���.***%n");
									continue;
								}
								dAmount[idx] += tmp;

								break;

							case 2: // ������ ��� - ��� ���� - ��� ����
								System.out.printf("���ҽ�ų %s�� ���� �Է� : ", dName[idx]);
								tmp = scan.nextInt();
								if (tmp < 0) {
									System.out.printf("%n***0�� �̻��� ������ �Է����ּ���.***%n");
									continue;
								} else if (tmp > dAmount[idx]) {
									dAmount[idx] = 0;
									break;
								}
								dAmount[idx] -= tmp;

								break;

							case 99:

								break;

							default:
								System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
								continue;

							}

						}
						break;

					case 2: // ������ ��� - ǰ�� ����
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("����%d : [%s]%n", i + 1, dName[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)����%d ���� ", i + 1, i + 1);
							}
							System.out.printf("(99)��������%n");
							System.out.printf("%n***ǰ�� ����� ���� ��ǰ�� �Ǹ� ���� �ʱ�ȭ�˴ϴ�.***%n");
							System.out.printf("����� �Է����ּ��� : ");
							input = scan.nextInt();
							String tmp99 = scan.nextLine(); // nextLine���� �����ؾ� �� �κ��� �ʹ� ���Ƽ� �׳� ���͸� ������� nextLine�ϳ��� �߰�����
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("%s�� �Ǹ� ���� �ʱ�ȭ�ƽ��ϴ�.%n", dName[idx]);
							dSell[idx] = 0;
							System.out.printf("����%d ������ ��ǰ �Է� : ", input);
							dName[idx] = scan.nextLine();
							System.out.printf("��ǰ�� ����Ǿ����ϴ�. %s�� ��� ���� �߰����ּ���.%n", dName[idx]);
							dAmount[idx] = 0;
							continue;

						}
						break;

					case 3: // ������ ��� - ���� ����
						while (true) {
							System.out.println();
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("%s [%d]��%n", dName[i], dPrice[i]);
							}
							for (int i = 0; i < dName.length; i++) {
								System.out.printf("(%d)%s ���� ���� ", i + 1, dName[i]);
							}
							System.out.printf("(99)��������%n");
							System.out.printf("%n***���� ����� �ش� ��ǰ�� �Ǹ� ���� �ʱ�ȭ�˴ϴ�.***%n");
							System.out.printf("����� �Է����ּ��� : ");
							input = scan.nextInt();
							if ((input < 1 || input > dName.length) && input != 99) {
								System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
								continue;
							} else if (input == 99) {
								break;
							}

							idx = input - 1;

							System.out.printf("%s�� �Ǹ� ���� �ʱ�ȭ�ƽ��ϴ�.%n", dName[idx]);
							dSell[idx] = 0;
							System.out.printf("%s ������ ���� �Է� : ", dName[idx]);
							tmp = scan.nextInt();
							if (tmp < 0) {
								System.out.printf("%n***0�� �̻��� ������ �Է����ּ���.***%n");
								continue;
							}
							dPrice[idx] = tmp;
							continue;

						}
						break;

					case 4: // ������ ��� - ���� Ȯ��
						for (int i = 0; i < dName.length; i++) {
							if (dSell[i] > 0) {
								System.out.printf("%s �Ǹ� �� : %d, ���� : %d��%n", dName[i], dSell[i], dGain[i]);
							}
						}
						tGain = 0;
						for (int i = 0; i < dName.length; i++) {
							tGain += dGain[i];
						}
						System.out.printf("�� ���� (ǰ�� �� ���� ������ ���� ����): %d��%n", tGain);
						break;

					case 5: // ������ ��� - ��ü �缳��
						System.out.printf("%n***�缳���� ��� ��ǰ�� �Ǹ� ���� �ʱ�ȭ�˴ϴ�.***%n");
						System.out.print("��� �׸��� �缳���ϰڽ��ϱ�? (666)�ű� �缳�� (777)�ʱ� ���� ���� (�׿� ����)��� : ");
						input = scan.nextInt();
						if (input != 666 && input != 777) {
							System.out.printf("%n***��ҵǾ����ϴ�.***%n");
							break;
						}

						for (int i = 0; i < dName.length; i++) {
							dSell[i] = 0;
						}

						if (input == 777) {
							dName = new String[] { "�ݶ�", "Ŀ��", "����" };
							dAmount = new int[] { 5, 5, 5 };
							dPrice = new int[] { 1500, 1800, 1000 };
							System.out.println("�ʱ� �������� �����Ǿ����ϴ�.");
							break;
						}

						System.out.println("1. ���� ���� �ܰ�");

						while (true) {
							System.out.print("���Ǳ� ������ ������ �Է����ּ���. : ");
							input = scan.nextInt();
							String tmp99 = scan.nextLine();
							if (input <= 0) {
								System.out.printf("%n***1�� �̻��� ������ �Է����ּ���.***%n%n");
								continue;
							}
							break;
						}

						dName = new String[input];
						dPrice = new int[input];
						dAmount = new int[input];

						System.out.println("2. ��ǰ ��� �ܰ�");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("[%d��] ���� ��ǰ�� �̸� �Է�: ", i + 1);
							dName[i] = scan.nextLine();
						}

						System.out.println("3. ���� ���� �ܰ�");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("%d�� ���� [%s]�� ���� �Է�: ", i + 1, dName[i]);
							input = scan.nextInt();
							if (input <= 0) {
								System.out.printf("%n***0���� ū ������ �Է����ּ���.***%n%n");
								i--;
							}
							dPrice[i] = input;
						}

						System.out.println("4. ��� ���� �ܰ�");
						for (int i = 0; i < dName.length; i++) {
							System.out.printf("%d�� ���� [%s]�� ��� �Է� : ", i + 1, dName[i]);
							input = scan.nextInt();
							if (input <= 0) {
								System.out.printf("%n***0���� ū ������ �Է����ּ���***%n%n");
								i--;
							}
							dAmount[i] = input;
						}
						System.out.println("�ű� �缳���� �Ϸ�Ǿ����ϴ�.");

						break;

					case 6: // ������ ��� - ��ȣ ����
						System.out.printf("%n������ ��ȣ�� �ѹ� �� �Է����ּ��� : ");
						tmp = scan.nextInt();
						if (tmp != pass) {
							System.out.printf("%n***��ȣ�� Ʋ�Ƚ��ϴ�.***%n");
							break;
						}
						System.out.print("������ ��ȣ �Է� : ");
						int tmp1 = scan.nextInt();
						System.out.print("������ ��ȣ ���Է� : ");
						int tmp2 = scan.nextInt();
						if (tmp1 != tmp2) {
							System.out.printf("%n***���Է��� ���� �ʽ��ϴ�.***%n");
							break;
						}
						pass = tmp;
						System.out.println("������ ��ȣ�� �����߽��ϴ�.");
						break;

					}

				}
				break;

			case 99: // ���Ǳ� ����
				power = true;
				break;

			default:
				System.out.printf("%n***�ùٸ� ���ڸ� �Է����ּ���.***%n");
				break;
			}

		}

		scan.close();
		System.out.println("���Ǳ� ����");

	} // end of main

} // end of class
