package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17 {
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

		int colaNum = 3;
		int coffeeNum = 3;
		int waterNum = 3;

		int coin = 0;
		int beverage = 0;
		
//		boolean possible = waterNum!=0 && coin<waterPrice || waterNum==0 && colaNum!=0 && coin<colaPrice || colaNum==0 && waterNum==0 && coffeeNum!=0 && coin<coffeePrice;
		
		sys:
		while (!power) {
			if (waterNum!=0 && coin<waterPrice || waterNum==0 && colaNum!=0 && coin<colaPrice || colaNum==0 && waterNum==0 && coffeeNum!=0 && coin<coffeePrice) {
				message1 = "coin�� (��)�־��ּ���";
//		�޴�ȭ�� coin
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <���� ���Ǳ�>                      ");
				System.out.println(); 
				System.out.printf("                                   ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��     2. %s : %d��    3 %s : %d��%n", cola, colaPrice, coffee, coffeePrice,
						water, waterPrice);
				System.out.println();
				System.out.println("                              �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println(); 
				System.out.printf("�ȳ� " + message1 + message2 +"%n");
				System.out.println("-------------------------------------------------------");
//				input coin
				System.out.println("�󸶸� �����ðڽ��ϱ�? : (poweroff: 99)");
				int tmp = scan.nextInt();
				if (tmp == 99) {
					if (coin != 0) {
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						coin = 0;
						tmp = 0;
					}
					break sys;
//				�Ž����� ��ȯ
				}else if (tmp == 4) {
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					coin = 0;
					tmp = 0;
				}
				coin += tmp;
			}else {
//		�޴�ȭ�� choice
				message1 = "���Ḧ ������";
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <���� ���Ǳ�>                      ");
				System.out.println(); 
				System.out.printf("                                   ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d     2. %s : %d    3 %s : %d%n", cola, colaPrice, coffee, coffeePrice,
						water, waterPrice);
				System.out.println();
				System.out.println("                              �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println(); 
				System.out.printf("�ȳ� : " + message1 + message2+"%n");
				System.out.println("-------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("������ ���ðڽ��ϱ�(1~3)? : ");
					beverage = scan.nextInt();
					
					switch (beverage) {
					case 1:
						if(colaNum <= 0) {
							System.out.println("�ݶ� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= colaPrice;
						if (coin < 0) {
							coin += colaPrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							break;
						}
						System.out.println("**�ݶ�**�� ���Խ��ϴ�.");
						System.out.println();
						colaNum--;
						if(colaNum <= 0) {
							message2 += ", �ݶ� ����";
						}
						break;
					case 2:
						if(coffeeNum <= 0) {
							System.out.println("Ŀ�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= coffeePrice;
						if (coin < 0) {
							coin += coffeePrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							break;
						}
						System.out.println("**Ŀ��**�� ���Խ��ϴ�.");
						System.out.println();
						coffeeNum--;
						if(coffeeNum <= 0) {
							message2 += ", Ŀ�� ����";
						}
						break;
					case 3:
						if(waterNum <= 0) {
							System.out.println("�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= waterPrice;
						if (coin < 0) {
							coin += waterPrice;
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							break;
						}
						System.out.println("**��**�� ���Խ��ϴ�.");
						System.out.println();
						waterNum--;
						if(waterNum <= 0) {
							message2 += ", �� ����";
						}
						break;
					case 4:
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						coin = 0;
						break;
					default:

					}
				}
				
				beverage = 0;
				
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("��� ��� �����Ǿ����ϴ�. ���Ǳ⸦ �̿��Ͻ� �� �����ϴ�.");
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					coin = 0;
					power = true;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
