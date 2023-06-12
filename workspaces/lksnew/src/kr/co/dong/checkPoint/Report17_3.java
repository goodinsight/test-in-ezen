package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_3 {
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

		int vendingMachingSize = 3;
		
		String drink = "����";
		String money = "�ܵ�";
		String[] drinkList = new String[vendingMachingSize];
		drinkList[0] = "�ݶ�"; // ���� �̸� �ʱ� ����
		drinkList[1] = "Ŀ��";
		drinkList[2] = "��";
		
		String[] message = new String[2];
		message[0] = ""; // �ȳ� �޼��� �ʱⰪ null �Ⱥ��̰�
		message[1] = "";

		int[] drinkPrice = new int[vendingMachingSize];
		drinkPrice[0] = 1500; // ���� ���� �ʱ� ����
		drinkPrice[1] = 2000;
		drinkPrice[2] = 1000;

		int[] drinkCount = new int[vendingMachingSize];
		drinkCount[0] = 10;	// ���� ��� �ʱ� ����
		drinkCount[1] = 10;
		drinkCount[2] = 10;

		int coin = 0;	// �ܾ�
//		�ܵ� ������Ȳ
		
		String[] moneyList = {"5������", "1������", "5õ����", "1õ����", "5���", "���"};
		int[] moneyCount = new int[6];
		int[] moneyChangeCount = new int[6];	//�Ž����� ���� �ʿ� ����
		moneyCount[0] = 0; // �ܵ� �ݾױǺ� �ʱ� ����
		moneyCount[1] = 2;
		moneyCount[2] = 2;
		moneyCount[3] = 4;
		moneyCount[4] = 2;
		moneyCount[5] = 10;

		
		int beverage = 0;

		int adminPw = 1234;	// ������ ��� ���� ��� -> ���� ȭ�鿡���� ����
		int adminMode = 0;	// ��� ��� ������ �������ö�
		int totalIncome = 0;	// �� �����
		
		int[] drinkSoldCount = new int[vendingMachingSize];	// ���Ằ �Ǹ� ����
		
		sys:
		while (!power) {
//			��� ��� ������ �̿�Ұ�
			if (drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0 && adminMode == 0) {
				System.out.println("��� ��� �����Ǿ����� �����ڿ��� �����ϼ���.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}
//			���� ��� �� ���� ������ ���� ���Ẹ�� �ݾ��� ���� ��� �ٽ� ó�� �޴���
			boolean possible = drinkCount[2] != 0 && coin < drinkPrice[2] || drinkCount[2] == 0 && drinkCount[0] != 0 && coin < drinkPrice[0]
					|| drinkCount[0] == 0 && drinkCount[2] == 0 && drinkCount[1] != 0 && coin < drinkPrice[1] || drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0;
			if (possible) {
				message[0] = "coin�� (��)�־��ּ���";
//		�޴�ȭ�� coin
				System.out.println("====================================================================================");
				System.out.println();
				System.out.println("                                   <���� ���Ǳ�>                      ");
				System.out.println();
				System.out.printf("                                                               ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3. %s : %d��(����:%d)%n", drinkList[0], drinkPrice[0],
						drinkCount[0], drinkList[1], drinkPrice[1], drinkCount[1], drinkList[2], drinkPrice[2], drinkCount[2]);
				System.out.println();
				System.out.println("                                                          �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");
//				input coin
				System.out.println("�󸶸� �����ðڽ��ϱ�?(���� ȭ��� ������ ��� ����) :");
				int tmp = scan.nextInt();
//				return of change
				if (tmp == 4) {
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					totalIncome -= coin;
//					�Ž����� �ܵ� ȯ��
					if (coin / 50000 > 0) {
						moneyChangeCount[0] = coin / 50000;
						if (moneyChangeCount[0]>=moneyCount[0]) {
							moneyChangeCount[0] = moneyCount[0];
							coin -= moneyChangeCount[0]*50000;
							if (moneyCount[0] != 0) {
								message[1] += ", 5������ ����";
							}
							moneyCount[0] = 0;
						}else {
							coin = coin % 50000;
							moneyCount[0] -=moneyChangeCount[0];
						}
					}
					if (coin / 10000 > 0) {
						moneyChangeCount[1] = coin / 10000;
						if (moneyChangeCount[1]>=moneyCount[1]) {
							moneyChangeCount[1] = moneyCount[1];
							coin -= moneyChangeCount[1]*10000;
							if (moneyCount[1] != 0) {
								message[1] += ", 1������ ����";
							}
							moneyCount[1] = 0;
						}else {
							coin = coin % 10000;
							moneyCount[1] -=moneyChangeCount[1];
						}
					}
					if (coin / 5000 > 0) {
						moneyChangeCount[2] = coin / 5000;
						if (moneyChangeCount[2]>=moneyCount[2]) {
							moneyChangeCount[2] = moneyCount[2];
							coin -= moneyChangeCount[2]*5000;
							if (moneyCount[2] != 0) {
								message[1] += ", 5õ���� ����";
							}
							moneyCount[2] = 0;
						}else {
							coin = coin % 5000;
							moneyCount[2] -=moneyChangeCount[2];
						}
					}
					if (coin / 1000 > 0) {
						moneyChangeCount[3] = coin / 1000;
						if (moneyChangeCount[3]>=moneyCount[3]) {
							moneyChangeCount[3] = moneyCount[3];
							coin -= moneyChangeCount[3]*1000;
							if (moneyCount[3] != 0) {
								message[1] += ", 1õ���� ����";
							}
							moneyCount[3] = 0;
						}else {
							coin = coin % 1000;
							moneyCount[3] -=moneyChangeCount[3];
						}
					}
					if (coin / 500 > 0) {
						moneyChangeCount[4] = coin / 500;
						if (moneyChangeCount[4]>=moneyCount[4]) {
							moneyChangeCount[4] = moneyCount[4];
							coin -= moneyChangeCount[4]*500;
							if (moneyCount[4] != 0) {
								message[1] += ", 500�� ���� ����";
							}
							moneyCount[4] = 0;
						}else {
							coin = coin % 500;
							moneyCount[4] -=moneyChangeCount[4];
						}
					}
					if (coin / 100 > 0) {
						moneyChangeCount[5] = coin / 100;
						if (moneyChangeCount[5]>=moneyCount[5]) {
							System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
							moneyChangeCount[5] = moneyCount[5];
							coin -= moneyChangeCount[5]*100;
							if (moneyCount[5] != 0) {
								message[1] += ", 100�� ���� ����";
							}
							moneyCount[5] = 0;
						}else {
							coin = coin % 100;
							moneyCount[5] -=moneyChangeCount[5];
							coin = 0;
						}
					}
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					�Ž����� ������ ����
					moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
					tmp = 0;
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					�Ž������� ���� ���� üũ
					switch (tmp) {
					case 100:
						moneyCount[5]++;
						break;
					case 500:
						moneyCount[4]++;
						break;
					case 1000:
						moneyCount[3]++;
						break;
					case 5000:
						moneyCount[2]++;
						break;
					case 10000:
						moneyCount[1]++;
						break;
					case 50000:
						moneyCount[0]++;
						break;
					default:
						break;
					}
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
							message[1] = message[1].replace(',',' '); 
							
							System.out.println("====================================================================================");
							System.out.println();
							System.out.println("                                     <������ ���>                                    ");
							System.out.println();
							System.out.printf("                                                     ������� �� ������ :  %d��%n", totalIncome);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹ���Ȳ>                      ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", drinkList[0], drinkSoldCount[0], drinkList[1],
									drinkSoldCount[1], drinkList[2], drinkSoldCount[2]);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹż���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", drinkList[0], drinkSoldCount[0] * drinkPrice[0],
									drinkList[1], drinkSoldCount[1] * drinkPrice[1], drinkList[2], drinkSoldCount[2] * drinkPrice[2]);
							System.out.println();
							System.out.println("                       <���Ằ ���� ���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", drinkList[0], drinkCount[0], drinkList[1],
									drinkCount[1], drinkList[2], drinkCount[2]);
							System.out.println();
							System.out.println("                       <�ܵ� ����>                      ");
							System.out.printf("  50000��: %d��, 10000��: %d��, 5000��: %d��, 1000��: %d��, 500��: %d��, 100��: %d��%n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);
							System.out.println();
							System.out.printf("�ȳ� : " + message[1] + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println("� ���� �߰��ϰų� ����(����)�Ͻðڽ��ϱ�? (������ ��� ����:4, ���Ǳ� ����off:5)");
							System.out.printf("1. %s      2. %s%n", drink, money);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.println("� ���Ḧ �߰�/���� �Ͻðڽ��ϱ�? (������ ��� ����:4, ���Ǳ� ����off:5)");
								System.out.printf("1. %s      2. %s      3. %s%n", drinkList[0], drinkList[1], drinkList[2]);
								System.out.println();
								beverage = scan.nextInt();
								switch (beverage) {
								case 1:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? ���Ҹ� ���ϸ� ������ �Է��ϼ��� : %n", drinkList[0]);
									drinkCount[0] += scan.nextInt();
									System.out.printf("%s �� �߰�(����)�Ǿ� ��� %d�� �Ǿ����ϴ�.%n", drinkList[0], drinkCount[0]);
									beverage = 0;
//									message , ���� �ȳ� �����
									message[1] = message[1].replace(" �ݶ� ����","");
									break;
								case 2:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? ���Ҹ� ���ϸ� ������ �Է��ϼ��� : %n", drinkList[1]);
									drinkCount[1] += scan.nextInt();
									System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", drinkList[1], drinkCount[1]);
									beverage = 0;
//									message , ���� �ȳ� �����
									message[1] = message[1].replace(" Ŀ�� ����","");
									break;
								case 3:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? ���Ҹ� ���ϸ� ������ �Է��ϼ��� : %n", drinkList[2]);
									drinkCount[2] += scan.nextInt();
									System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", drinkList[2], drinkCount[2]);
									beverage = 0;
//									message , ���� �ȳ� �����
									message[1] = message[1].replace(" �� ����","");
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
								}// switch beverage end
								break;
							case 2:
								System.out.println("� �ܵ��� �߰��Ͻðڽ��ϱ�? �ݾ��� �Է��ϼ���. (������ ��� ����:4, ���Ǳ� ����off:5)");
								System.out.printf("50000, 10000, 5000, 1000, 500, 100%n");
								System.out.println();
								int change = scan.nextInt();
								switch (change) {
								case 50000:
									System.out.printf("50000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[0] += scan.nextInt();
									System.out.printf("50000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[0]);
									message[1] = message[1].replace(" 5������ ����","");
									break;
								case 10000:
									System.out.printf("10000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[1] += scan.nextInt();
									System.out.printf("10000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[1]);
									message[1] = message[1].replace(" 1������ ����","");
									break;
								case 5000:
									System.out.printf("5000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[2] += scan.nextInt();
									System.out.printf("5000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[2]);
									message[1] = message[1].replace(" 5õ���� ����","");
									break;
								case 1000:
									System.out.printf("1000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[3] += scan.nextInt();
									System.out.printf("1000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[3]);
									message[1] = message[1].replace(" 1õ���� ����","");
									break;
								case 500:
									System.out.printf("500�� ������ � �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[4] += scan.nextInt();
									System.out.printf("500�� ������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[4]);
									message[1] = message[1].replace(" 500�� ���� ����","");
									break;
								case 100:
									System.out.printf("100�� ������ � �߰��Ͻðڽ��ϱ�? : %n");
									moneyCount[5] += scan.nextInt();
									System.out.printf("100�� ������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[5]);
									message[1] = message[1].replace(" 100�� ���� ����","");
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
								}// switch beverage end
								break;
							case 4:
								System.out.println("������ ��带 �����մϴ�.");
								break admin;
							case 5:
								power = true;
								break sys;
							
							default:
								System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~2�� �� �ϳ��� ������");
								break;

							}
							System.out.println();
							
						}// while end
					}
				}
			} else {
//		�޴�ȭ�� choice
				message[0] = "���Ḧ ������";
				System.out.println("====================================================================================");
				System.out.println(); 
				System.out.println("                                       <���� ���Ǳ�>                                    ");
				System.out.println();
				System.out.printf("                                                                 ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3 %s : %d��(����:%d)%n", drinkList[0], drinkPrice[0],
						drinkCount[0], drinkList[1], drinkPrice[1], drinkCount[1], drinkList[2], drinkPrice[2], drinkCount[2]);
				System.out.println();
				System.out.println("                                                           �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� : " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("������ ���ðڽ��ϱ�(1~3)? : ");
					beverage = scan.nextInt();

					switch (beverage) {
					case 1:
						if (drinkCount[0] <= 0) {
							System.out.println("�ݶ� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
//						���� ���ý� �ܾ� ����
						coin -= drinkPrice[0];
//						�ܾ��� ���ڶ� ���
						if (coin < 0) {
							coin += drinkPrice[0];
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
//							������ �߰��� ������ ����� �ƴϸ� �ܵ��� ��ȯ�� �ϵ��� ����
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5������ ����";
											}
											moneyCount[0] = 0;
										}else {
											coin = coin % 50000;
											moneyCount[0] -=moneyChangeCount[0];
										}
									}
									if (coin / 10000 > 0) {
										moneyChangeCount[1] = coin / 10000;
										if (moneyChangeCount[1]>=moneyCount[1]) {
											moneyChangeCount[1] = moneyCount[1];
											coin -= moneyChangeCount[1]*10000;
											if (moneyCount[1] != 0) {
												message[1] += ", 1������ ����";
											}
											moneyCount[1] = 0;
										}else {
											coin = coin % 10000;
											moneyCount[1] -=moneyChangeCount[1];
										}
									}
									if (coin / 5000 > 0) {
										moneyChangeCount[2] = coin / 5000;
										if (moneyChangeCount[2]>=moneyCount[2]) {
											moneyChangeCount[2] = moneyCount[2];
											coin -= moneyChangeCount[2]*5000;
											if (moneyCount[2] != 0) {
												message[1] += ", 5õ���� ����";
											}
											moneyCount[2] = 0;
										}else {
											coin = coin % 5000;
											moneyCount[2] -=moneyChangeCount[2];
										}
									}
									if (coin / 1000 > 0) {
										moneyChangeCount[3] = coin / 1000;
										if (moneyChangeCount[3]>=moneyCount[3]) {
											moneyChangeCount[3] = moneyCount[3];
											coin -= moneyChangeCount[3]*1000;
											if (moneyCount[3] != 0) {
												message[1] += ", 1õ���� ����";
											}
											moneyCount[3] = 0;
										}else {
											coin = coin % 1000;
											moneyCount[3] -=moneyChangeCount[3];
										}
									}
									if (coin / 500 > 0) {
										moneyChangeCount[4] = coin / 500;
										if (moneyChangeCount[4]>=moneyCount[4]) {
											moneyChangeCount[4] = moneyCount[4];
											coin -= moneyChangeCount[4]*500;
											if (moneyCount[4] != 0) {
												message[1] += ", 500�� ���� ����";
											}
											moneyCount[4] = 0;
										}else {
											coin = coin % 500;
											moneyCount[4] -=moneyChangeCount[4];
										}
									}
									if (coin / 100 > 0) {
										moneyChangeCount[5] = coin / 100;
										if (moneyChangeCount[5]>=moneyCount[5]) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100�� ���� ����";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
									moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										moneyCount[5]++;
										break;
									case 500:
										moneyCount[4]++;
										break;
									case 1000:
										moneyCount[3]++;
										break;
									case 5000:
										moneyCount[2]++;
										break;
									case 10000:
										moneyCount[1]++;
										break;
									case 50000:
										moneyCount[0]++;
										break;
									default:
										break;
									}
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
						drinkCount[0]--;
						drinkSoldCount[0]++;
//						������ ���� �ȳ�
						if (drinkCount[0] <= 0) {
							message[1] += ", �ݶ� ����";
						}
						break;
					case 2:
						if (drinkCount[1] <= 0) {
							System.out.println("Ŀ�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= drinkPrice[1];
						if (coin < 0) {
							coin += drinkPrice[1];
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5������ ����";
											}
											moneyCount[0] = 0;
										}else {
											coin = coin % 50000;
											moneyCount[0] -=moneyChangeCount[0];
										}
									}
									if (coin / 10000 > 0) {
										moneyChangeCount[1] = coin / 10000;
										if (moneyChangeCount[1]>=moneyCount[1]) {
											moneyChangeCount[1] = moneyCount[1];
											coin -= moneyChangeCount[1]*10000;
											if (moneyCount[1] != 0) {
												message[1] += ", 1������ ����";
											}
											moneyCount[1] = 0;
										}else {
											coin = coin % 10000;
											moneyCount[1] -=moneyChangeCount[1];
										}
									}
									if (coin / 5000 > 0) {
										moneyChangeCount[2] = coin / 5000;
										if (moneyChangeCount[2]>=moneyCount[2]) {
											moneyChangeCount[2] = moneyCount[2];
											coin -= moneyChangeCount[2]*5000;
											if (moneyCount[2] != 0) {
												message[1] += ", 5õ���� ����";
											}
											moneyCount[2] = 0;
										}else {
											coin = coin % 5000;
											moneyCount[2] -=moneyChangeCount[2];
										}
									}
									if (coin / 1000 > 0) {
										moneyChangeCount[3] = coin / 1000;
										if (moneyChangeCount[3]>=moneyCount[3]) {
											moneyChangeCount[3] = moneyCount[3];
											coin -= moneyChangeCount[3]*1000;
											if (moneyCount[3] != 0) {
												message[1] += ", 1õ���� ����";
											}
											moneyCount[3] = 0;
										}else {
											coin = coin % 1000;
											moneyCount[3] -=moneyChangeCount[3];
										}
									}
									if (coin / 500 > 0) {
										moneyChangeCount[4] = coin / 500;
										if (moneyChangeCount[4]>=moneyCount[4]) {
											moneyChangeCount[4] = moneyCount[4];
											coin -= moneyChangeCount[4]*500;
											if (moneyCount[4] != 0) {
												message[1] += ", 500�� ���� ����";
											}
											moneyCount[4] = 0;
										}else {
											coin = coin % 500;
											moneyCount[4] -=moneyChangeCount[4];
										}
									}
									if (coin / 100 > 0) {
										moneyChangeCount[5] = coin / 100;
										if (moneyChangeCount[5]>=moneyCount[5]) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100�� ���� ����";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
									moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										moneyCount[5]++;
										break;
									case 500:
										moneyCount[4]++;
										break;
									case 1000:
										moneyCount[3]++;
										break;
									case 5000:
										moneyCount[2]++;
										break;
									case 10000:
										moneyCount[1]++;
										break;
									case 50000:
										moneyCount[0]++;
										break;
									default:
										break;
									}
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
						drinkCount[1]--;
						drinkSoldCount[1]++;
						if (drinkCount[1] <= 0) {
							message[1] += ", Ŀ�� ����";
						}
						break;
					case 3:
						if (drinkCount[2] <= 0) {
							System.out.println("�� �����Դϴ�. �ٸ��޴��� �����ϼ���.");
							break;
						}
						coin -= drinkPrice[2];
						if (coin < 0) {
							coin += drinkPrice[2];
							System.out.println("�ܾ��� ���ڶ��ϴ�.");
							while (true) {
								System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5������ ����";
											}
											moneyCount[0] = 0;
										}else {
											coin = coin % 50000;
											moneyCount[0] -=moneyChangeCount[0];
										}
									}
									if (coin / 10000 > 0) {
										moneyChangeCount[1] = coin / 10000;
										if (moneyChangeCount[1]>=moneyCount[1]) {
											moneyChangeCount[1] = moneyCount[1];
											coin -= moneyChangeCount[1]*10000;
											if (moneyCount[1] != 0) {
												message[1] += ", 1������ ����";
											}
											moneyCount[1] = 0;
										}else {
											coin = coin % 10000;
											moneyCount[1] -=moneyChangeCount[1];
										}
									}
									if (coin / 5000 > 0) {
										moneyChangeCount[2] = coin / 5000;
										if (moneyChangeCount[2]>=moneyCount[2]) {
											moneyChangeCount[2] = moneyCount[2];
											coin -= moneyChangeCount[2]*5000;
											if (moneyCount[2] != 0) {
												message[1] += ", 5õ���� ����";
											}
											moneyCount[2] = 0;
										}else {
											coin = coin % 5000;
											moneyCount[2] -=moneyChangeCount[2];
										}
									}
									if (coin / 1000 > 0) {
										moneyChangeCount[3] = coin / 1000;
										if (moneyChangeCount[3]>=moneyCount[3]) {
											moneyChangeCount[3] = moneyCount[3];
											coin -= moneyChangeCount[3]*1000;
											if (moneyCount[3] != 0) {
												message[1] += ", 1õ���� ����";
											}
											moneyCount[3] = 0;
										}else {
											coin = coin % 1000;
											moneyCount[3] -=moneyChangeCount[3];
										}
									}
									if (coin / 500 > 0) {
										moneyChangeCount[4] = coin / 500;
										if (moneyChangeCount[4]>=moneyCount[4]) {
											moneyChangeCount[4] = moneyCount[4];
											coin -= moneyChangeCount[4]*500;
											if (moneyCount[4] != 0) {
												message[1] += ", 500�� ���� ����";
											}
											moneyCount[4] = 0;
										}else {
											coin = coin % 500;
											moneyCount[4] -=moneyChangeCount[4];
										}
									}
									if (coin / 100 > 0) {
										moneyChangeCount[5] = coin / 100;
										if (moneyChangeCount[5]>=moneyCount[5]) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100�� ���� ����";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
									moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										moneyCount[5]++;
										break;
									case 500:
										moneyCount[4]++;
										break;
									case 1000:
										moneyCount[3]++;
										break;
									case 5000:
										moneyCount[2]++;
										break;
									case 10000:
										moneyCount[1]++;
										break;
									case 50000:
										moneyCount[0]++;
										break;
									default:
										break;
									}
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
						drinkCount[2]--;
						drinkSoldCount[2]++;
						if (drinkCount[2] <= 0) {
							message[1] += ", �� ����";
						}
						break;
					case 4:
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						totalIncome -= coin;
						if (coin / 50000 > 0) {
							moneyChangeCount[0] = coin / 50000;
							if (moneyChangeCount[0]>=moneyCount[0]) {
								moneyChangeCount[0] = moneyCount[0];
								coin -= moneyChangeCount[0]*50000;
								if (moneyCount[0] != 0) {
									message[1] += ", 5������ ����";
								}
								moneyCount[0] = 0;
							}else {
								coin = coin % 50000;
								moneyCount[0] -=moneyChangeCount[0];
							}
						}
						if (coin / 10000 > 0) {
							moneyChangeCount[1] = coin / 10000;
							if (moneyChangeCount[1]>=moneyCount[1]) {
								moneyChangeCount[1] = moneyCount[1];
								coin -= moneyChangeCount[1]*10000;
								if (moneyCount[1] != 0) {
									message[1] += ", 1������ ����";
								}
								moneyCount[1] = 0;
							}else {
								coin = coin % 10000;
								moneyCount[1] -=moneyChangeCount[1];
							}
						}
						if (coin / 5000 > 0) {
							moneyChangeCount[2] = coin / 5000;
							if (moneyChangeCount[2]>=moneyCount[2]) {
								moneyChangeCount[2] = moneyCount[2];
								coin -= moneyChangeCount[2]*5000;
								if (moneyCount[2] != 0) {
									message[1] += ", 5õ���� ����";
								}
								moneyCount[2] = 0;
							}else {
								coin = coin % 5000;
								moneyCount[2] -=moneyChangeCount[2];
							}
						}
						if (coin / 1000 > 0) {
							moneyChangeCount[3] = coin / 1000;
							if (moneyChangeCount[3]>=moneyCount[3]) {
								moneyChangeCount[3] = moneyCount[3];
								coin -= moneyChangeCount[3]*1000;
								if (moneyCount[3] != 0) {
									message[1] += ", 1õ���� ����";
								}
								moneyCount[3] = 0;
							}else {
								coin = coin % 1000;
								moneyCount[3] -=moneyChangeCount[3];
							}
						}
						if (coin / 500 > 0) {
							moneyChangeCount[4] = coin / 500;
							if (moneyChangeCount[4]>=moneyCount[4]) {
								moneyChangeCount[4] = moneyCount[4];
								coin -= moneyChangeCount[4]*500;
								if (moneyCount[4] != 0) {
									message[1] += ", 500�� ���� ����";
								}
								moneyCount[4] = 0;
							}else {
								coin = coin % 500;
								moneyCount[4] -=moneyChangeCount[4];
							}
						}
						if (coin / 100 > 0) {
							moneyChangeCount[5] = coin / 100;
							if (moneyChangeCount[5]>=moneyCount[5]) {
								System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
								moneyChangeCount[5] = moneyCount[5];
								coin -= moneyChangeCount[5]*100;
								if (moneyCount[5] != 0) {
									message[1] += ", 100�� ���� ����";
								}
								moneyCount[5] = 0;
							}else {
								coin = coin % 100;
								moneyCount[5] -=moneyChangeCount[5];
								coin = 0;
							}
						}
						System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
						moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
						break;
					default:
						System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~4�� �� �ϳ��� ������");
						break;
					}
				}

				beverage = 0;
//				��� ��� ������ �Ž����� ��� ��ȯ ����
				if (drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0) {
					System.out.println("��� ��� �����Ǿ����ϴ�. ���Ǳ⸦ �̿��Ͻ� �� �����ϴ�.");
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					totalIncome -= coin;
					if (coin / 50000 > 0) {
						moneyChangeCount[0] = coin / 50000;
						if (moneyChangeCount[0]>=moneyCount[0]) {
							moneyChangeCount[0] = moneyCount[0];
							coin -= moneyChangeCount[0]*50000;
							if (moneyCount[0] != 0) {
								message[1] += ", 5������ ����";
							}
							moneyCount[0] = 0;
						}else {
							coin = coin % 50000;
							moneyCount[0] -=moneyChangeCount[0];
						}
					}
					if (coin / 10000 > 0) {
						moneyChangeCount[1] = coin / 10000;
						if (moneyChangeCount[1]>=moneyCount[1]) {
							moneyChangeCount[1] = moneyCount[1];
							coin -= moneyChangeCount[1]*10000;
							if (moneyCount[1] != 0) {
								message[1] += ", 1������ ����";
							}
							moneyCount[1] = 0;
						}else {
							coin = coin % 10000;
							moneyCount[1] -=moneyChangeCount[1];
						}
					}
					if (coin / 5000 > 0) {
						moneyChangeCount[2] = coin / 5000;
						if (moneyChangeCount[2]>=moneyCount[2]) {
							moneyChangeCount[2] = moneyCount[2];
							coin -= moneyChangeCount[2]*5000;
							if (moneyCount[2] != 0) {
								message[1] += ", 5õ���� ����";
							}
							moneyCount[2] = 0;
						}else {
							coin = coin % 5000;
							moneyCount[2] -=moneyChangeCount[2];
						}
					}
					if (coin / 1000 > 0) {
						moneyChangeCount[3] = coin / 1000;
						if (moneyChangeCount[3]>=moneyCount[3]) {
							moneyChangeCount[3] = moneyCount[3];
							coin -= moneyChangeCount[3]*1000;
							if (moneyCount[3] != 0) {
								message[1] += ", 1õ���� ����";
							}
							moneyCount[3] = 0;
						}else {
							coin = coin % 1000;
							moneyCount[3] -=moneyChangeCount[3];
						}
					}
					if (coin / 500 > 0) {
						moneyChangeCount[4] = coin / 500;
						if (moneyChangeCount[4]>=moneyCount[4]) {
							moneyChangeCount[4] = moneyCount[4];
							coin -= moneyChangeCount[4]*500;
							if (moneyCount[4] != 0) {
								message[1] += ", 500�� ���� ����";
							}
							moneyCount[4] = 0;
						}else {
							coin = coin % 500;
							moneyCount[4] -=moneyChangeCount[4];
						}
					}
					if (coin / 100 > 0) {
						moneyChangeCount[5] = coin / 100;
						if (moneyChangeCount[5]>=moneyCount[5]) {
							System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
							moneyChangeCount[5] = moneyCount[5];
							coin -= moneyChangeCount[5]*100;
							if (moneyCount[5] != 0) {
								message[1] += ", 100�� ���� ����";
							}
							moneyCount[5] = 0;
						}else {
							coin = coin % 100;
							moneyCount[5] -=moneyChangeCount[5];
							coin = 0;
						}
					}
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
					moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
