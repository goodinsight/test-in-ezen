package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_1 {
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ����, ����, �Ž����� ��ȯ, ���Է� ��
//			99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�

		boolean power = false; // ����
//		�޴� �Է°�, ���� ��, ����1,2, 3, �Ž�����
		Scanner scan = new Scanner(System.in);

		String cola = "�ݶ�";
		String coffee = "Ŀ��";
		String water = "��";
		String message1 = "", message2 = "";

		int colaPrice = 1500;
		int coffeePrice = 2000;
		int waterPrice = 1000;

		int colaNum = 10;
		int coffeeNum = 10;
		int waterNum = 10;

		int coin = 0;
		int beverage = 0;

		int adminPw = 1234;
		int adminMode = 0;
		int totalIncome = 0;
		int colaSel = 0;
		int coffeeSel = 0;
		int waterSel = 0;

		sys:
		while (!power) {
//			��� ��� ������ �̿�Ұ�
			if (colaNum == 0 && coffeeNum == 0 && waterNum == 0 && adminMode == 0) {
				System.out.println("��� ��� �����Ǿ����� �����ڿ��� �����ϼ���.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}
//			���� ��� �� ���� ������ ���� ���Ẹ�� �ݾ��� ���� ��� �ٽ� ó�� �޴���
			boolean possible = waterNum != 0 && coin < waterPrice || waterNum == 0 && colaNum != 0 && coin < colaPrice
					|| colaNum == 0 && waterNum == 0 && coffeeNum != 0 && coin < coffeePrice || colaNum == 0 && coffeeNum == 0 && waterNum == 0;
			if (possible) {
				message1 = "coin�� (��)�־��ּ���";
//		�޴�ȭ�� coin
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <���� ���Ǳ�>                      ");
				System.out.println();
				System.out.printf("                                   ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3 %s : %d��(����:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                              �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� " + message1 + message2 + "%n");
				System.out.println("-------------------------------------------------------");
//				input coin
				System.out.println("�󸶸� �����ðڽ��ϱ�? :");
				int tmp = scan.nextInt();
//				return of change
				if (tmp == 4) {
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					totalIncome -= coin;
					coin = 0;
					tmp = 0;
				} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
					totalIncome += tmp;
				} else {
					System.out.println("�����̳� ���� �ƴմϴ�. �ٽ� ��������.");
				}
//				������ ���(��� �߰�)
				if (tmp == adminPw) {
					admin:
					while (true) {

						while (true) {
//							message , �����
							message2 = message2.replace(',',' '); 
							
							System.out.println("=======================================================");
							System.out.println();
							System.out.println("                       <������ ���>                      ");
							System.out.println();
							System.out.printf("                               ������� �� ������ :  %d��%n", totalIncome);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹ���Ȳ>                      ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3 %s : %d��%n", cola, colaSel, coffee,
									coffeeSel, water, waterSel);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹż���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3 %s : %d��%n", cola, colaSel * colaPrice,
									coffee, coffeeSel * coffeePrice, water, waterSel * waterPrice);
							System.out.println();
							System.out.println("                       <���Ằ ���� ���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3 %s : %d��%n", cola, colaNum, coffee,
									coffeeNum, water, waterNum);
							System.out.println();
							System.out.printf("�ȳ� : " + message2 + "%n");
							System.out.println("-------------------------------------------------------");
							System.out.println("� ���Ḧ �߰��Ͻðڽ��ϱ�? (������ ��� ����:4, ���Ǳ� ����off:5)");
							System.out.printf("1. %s      2. %s      3. %s%n", cola, coffee, water);

							beverage = scan.nextInt();
							switch (beverage) {
							case 1:
								System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", cola);
								colaNum += scan.nextInt();
								System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", cola, colaNum);
								beverage = 0;
//								message , ���� �ȳ� �����
								message2 = message2.replace(" �ݶ� ����","");
								break;
							case 2:
								System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", coffee);
								coffeeNum += scan.nextInt();
								System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coffee, coffeeNum);
								beverage = 0;
//								message , ���� �ȳ� �����
								message2 = message2.replace(" Ŀ�� ����","");
								break;
							case 3:
								System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", water);
								waterNum += scan.nextInt();
								System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", water, waterNum);
								beverage = 0;
//								message , ���� �ȳ� �����
								message2 = message2.replace(" �� ����","");
								break;
							case 4:
								System.out.println("������ ��带 �����մϴ�.");
								break admin;
							case 5:
								power = true;
								break sys;
							
							default:
								System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~4�� �� �ϳ��� ������");
								break;
							}// switch end
						}// while end
					}
				}
			} else {
//		�޴�ȭ�� choice
				message1 = "���Ḧ ������";
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <���� ���Ǳ�>                      ");
				System.out.println();
				System.out.printf("                                   ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3 %s : %d��(����:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                              �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� : " + message1 + message2 + "%n");
				System.out.println("-------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("������ ���ðڽ��ϱ�(1~3)? : ");
					beverage = scan.nextInt();

					switch (beverage) {
					case 1:
						if (colaNum <= 0) {
							System.out.println("�ݶ� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
//						���� ���ý� �ܾ� ����
						coin -= colaPrice;
//						�ܾ��� ���ڶ� ���
						if (coin < 0) {
							coin += colaPrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
//							������ �߰��� ������ ����� �ƴϸ� �ܵ��� ��ȯ�� �ϵ��� ����
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									totalIncome += tmp;
									break;
								} else {
									System.out.println("�����̳� ���� �ƴմϴ�. �ٽ� ��������.");
								}
							}
							break;
						}
//						���ᰡ ������ ��� ��� ���� ����
						System.out.println("**�ݶ�**�� ���Խ��ϴ�.");
						System.out.println();
						colaNum--;
						colaSel++;
//						������ ���� �ȳ�
						if (colaNum <= 0) {
							message2 += ", �ݶ� ����";
						}
						break;
					case 2:
						if (coffeeNum <= 0) {
							System.out.println("Ŀ�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= coffeePrice;
						if (coin < 0) {
							coin += coffeePrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									totalIncome += tmp;
									break;
								} else {
									System.out.println("�����̳� ���� �ƴմϴ�. �ٽ� ��������.");
								}
							}
							break;
						}
						System.out.println("**Ŀ��**�� ���Խ��ϴ�.");
						System.out.println();
						coffeeNum--;
						coffeeSel++;
						if (coffeeNum <= 0) {
							message2 += ", Ŀ�� ����";
						}
						break;
					case 3:
						if (waterNum <= 0) {
							System.out.println("�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= waterPrice;
						if (coin < 0) {
							coin += waterPrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									totalIncome += tmp;
									break;
								} else {
									System.out.println("�����̳� ���� �ƴմϴ�. �ٽ� ��������.");
								}
							}
							break;
						}
						System.out.println("**��**�� ���Խ��ϴ�.");
						System.out.println();
						waterNum--;
						waterSel++;
						if (waterNum <= 0) {
							message2 += ", �� ����";
						}
						break;
					case 4:
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						totalIncome -= coin;
						coin = 0;
						break;
					default:

					}
				}

				beverage = 0;
//				��� ��� ������ �Ž����� ��� ��ȯ ����
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("��� ��� �����Ǿ����ϴ�. ���Ǳ⸦ �̿��Ͻ� �� �����ϴ�.");
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					totalIncome -= coin;
					coin = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
