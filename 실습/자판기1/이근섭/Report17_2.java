package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_2 {
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

		String drink = "����";
		String money = "�ܵ�";
		String cola = "�ݶ�";
		String coffee = "Ŀ��";
		String water = "��";
		String message1 = "", message2 = "";

		int colaPrice = 1500;	
		int coffeePrice = 2000;
		int waterPrice = 1000;

		int colaNum = 10;	// �ݶ� �ʱ� ���
		int coffeeNum = 10;
		int waterNum = 10;

		int coin = 0;	// �ܾ�
//		�ܵ� ������Ȳ
		int coin50000 = 0; // 5������
		int coin10000 = 2;
		int coin5000 = 2;
		int coin1000 = 4;
		int coin500 = 2;
		int coin100 = 10;
		int change50000 = 0;	//�Ž����� ���� �ʿ� ����
		int change10000 = 0;
		int change5000 = 0;
		int change1000 = 0;
		int change500 = 0;
		int change100 = 0;
		

		
		int beverage = 0;

		int adminPw = 1234;	// ������ ��� ���� ��� -> ���� ȭ�鿡���� ����
		int adminMode = 0;	// ��� ��� ������ �������ö�
		int totalIncome = 0;	// �� �����
		int colaSel = 0;	// �ݶ� �Ǹ� ����
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
				System.out.println("====================================================================================");
				System.out.println();
				System.out.println("                                   <���� ���Ǳ�>                      ");
				System.out.println();
				System.out.printf("                                                               ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3. %s : %d��(����:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                                                          �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� " + message1 + message2 + "%n");
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
						change50000 = coin / 50000;
						if (change50000>=coin50000) {
							change50000 = coin50000;
							coin -= change50000*50000;
							if (coin50000 != 0) {
								message2 += ", 5������ ����";
							}
							coin50000 = 0;
						}else {
							coin = coin % 50000;
							coin50000 -=change50000;
						}
					}
					if (coin / 10000 > 0) {
						change10000 = coin / 10000;
						if (change10000>=coin10000) {
							change10000 = coin10000;
							coin -= change10000*10000;
							if (coin10000 != 0) {
								message2 += ", 1������ ����";
							}
							coin10000 = 0;
						}else {
							coin = coin % 10000;
							coin10000 -=change10000;
						}
					}
					if (coin / 5000 > 0) {
						change5000 = coin / 5000;
						if (change5000>=coin5000) {
							change5000 = coin5000;
							coin -= change5000*5000;
							if (coin5000 != 0) {
								message2 += ", 5õ���� ����";
							}
							coin5000 = 0;
						}else {
							coin = coin % 5000;
							coin5000 -=change5000;
						}
					}
					if (coin / 1000 > 0) {
						change1000 = coin / 1000;
						if (change1000>=coin1000) {
							change1000 = coin1000;
							coin -= change1000*1000;
							if (coin1000 != 0) {
								message2 += ", 1õ���� ����";
							}
							coin1000 = 0;
						}else {
							coin = coin % 1000;
							coin1000 -=change1000;
						}
					}
					if (coin / 500 > 0) {
						change500 = coin / 500;
						if (change500>=coin500) {
							change500 = coin500;
							coin -= change500*500;
							if (coin500 != 0) {
								message2 += ", 500�� ���� ����";
							}
							coin500 = 0;
						}else {
							coin = coin % 500;
							coin500 -=change500;
						}
					}
					if (coin / 100 > 0) {
						change100 = coin / 100;
						if (change100>=coin100) {
							System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
							change100 = coin100;
							coin -= change100*100;
							if (coin100 != 0) {
								message2 += ", 100�� ���� ����";
							}
							coin100 = 0;
						}else {
							coin = coin % 100;
							coin100 -=change100;
							coin = 0;
						}
					}
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
//					�Ž����� ������ ����
					change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
					tmp = 0;
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					�Ž������� ���� ���� üũ
					switch (tmp) {
					case 100:
						coin100++;
						break;
					case 500:
						coin500++;
						break;
					case 1000:
						coin1000++;
						break;
					case 5000:
						coin5000++;
						break;
					case 10000:
						coin10000++;
						break;
					case 50000:
						coin50000++;
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
							message2 = message2.replace(',',' '); 
							
							System.out.println("====================================================================================");
							System.out.println();
							System.out.println("                                     <������ ���>                                    ");
							System.out.println();
							System.out.printf("                                                     ������� �� ������ :  %d��%n", totalIncome);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹ���Ȳ>                      ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", cola, colaSel, coffee,
									coffeeSel, water, waterSel);
							System.out.println();
							System.out.println("                       <���Ằ �Ǹż���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", cola, colaSel * colaPrice,
									coffee, coffeeSel * coffeePrice, water, waterSel * waterPrice);
							System.out.println();
							System.out.println("                       <���Ằ ���� ���>                    ");
							System.out.printf("  1. %s : %d��     2. %s : %d��    3. %s : %d��%n", cola, colaNum, coffee,
									coffeeNum, water, waterNum);
							System.out.println();
							System.out.println("                       <�ܵ� ����>                      ");
							System.out.printf("  50000��: %d��, 10000��: %d��, 5000��: %d��, 1000��: %d��, 500��: %d��, 100��: %d��%n", coin50000, coin10000, coin5000, coin1000, coin500, coin100);
							System.out.println();
							System.out.printf("�ȳ� : " + message2 + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println("� ���� �߰��Ͻðڽ��ϱ�? (������ ��� ����:4, ���Ǳ� ����off:5)");
							System.out.printf("1. %s      2. %s%n", drink, money);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.println("� ���Ḧ �߰��Ͻðڽ��ϱ�? (������ ��� ����:4, ���Ǳ� ����off:5)");
								System.out.printf("1. %s      2. %s      3. %s%n", cola, coffee, water);
								System.out.println();
								beverage = scan.nextInt();
								switch (beverage) {
								case 1:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", cola);
									colaNum += scan.nextInt();
									System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", cola, colaNum);
									beverage = 0;
//									message , ���� �ȳ� �����
									message2 = message2.replace(" �ݶ� ����","");
									break;
								case 2:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", coffee);
									coffeeNum += scan.nextInt();
									System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coffee, coffeeNum);
									beverage = 0;
//									message , ���� �ȳ� �����
									message2 = message2.replace(" Ŀ�� ����","");
									break;
								case 3:
									System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? : %n", water);
									waterNum += scan.nextInt();
									System.out.printf("%s �� �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", water, waterNum);
									beverage = 0;
//									message , ���� �ȳ� �����
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
									coin50000 += scan.nextInt();
									System.out.printf("50000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin50000);
									message2 = message2.replace(" 5������ ����","");
									break;
								case 10000:
									System.out.printf("10000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									coin10000 += scan.nextInt();
									System.out.printf("10000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin10000);
									message2 = message2.replace(" 1������ ����","");
									break;
								case 5000:
									System.out.printf("5000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									coin5000 += scan.nextInt();
									System.out.printf("5000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin5000);
									message2 = message2.replace(" 5õ���� ����","");
									break;
								case 1000:
									System.out.printf("1000������ ���� �߰��Ͻðڽ��ϱ�? : %n");
									coin1000 += scan.nextInt();
									System.out.printf("1000������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin1000);
									message2 = message2.replace(" 1õ���� ����","");
									break;
								case 500:
									System.out.printf("500�� ������ � �߰��Ͻðڽ��ϱ�? : %n");
									coin500 += scan.nextInt();
									System.out.printf("500�� ������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin500);
									message2 = message2.replace(" 500�� ���� ����","");
									break;
								case 100:
									System.out.printf("100�� ������ � �߰��Ͻðڽ��ϱ�? : %n");
									coin100 += scan.nextInt();
									System.out.printf("100�� ������ �߰��Ǿ� ��� %d�� �Ǿ����ϴ�.%n", coin100);
									message2 = message2.replace(" 100�� ���� ����","");
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
				message1 = "���Ḧ ������";
				System.out.println("====================================================================================");
				System.out.println(); 
				System.out.println("                                       <���� ���Ǳ�>                                    ");
				System.out.println();
				System.out.printf("                                                                 ���� �ܾ��� :  %d��", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d��(����:%d)     2. %s : %d��(����:%d)    3 %s : %d��(����:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                                                           �ܾ� ��ȯ�� ���Ͻø� 4���� ��������");
				System.out.println();
				System.out.printf("�ȳ� : " + message1 + message2 + "%n");
				System.out.println("------------------------------------------------------------------------------------");

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
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5������ ����";
											}
											coin50000 = 0;
										}else {
											coin = coin % 50000;
											coin50000 -=change50000;
										}
									}
									if (coin / 10000 > 0) {
										change10000 = coin / 10000;
										if (change10000>=coin10000) {
											change10000 = coin10000;
											coin -= change10000*10000;
											if (coin10000 != 0) {
												message2 += ", 1������ ����";
											}
											coin10000 = 0;
										}else {
											coin = coin % 10000;
											coin10000 -=change10000;
										}
									}
									if (coin / 5000 > 0) {
										change5000 = coin / 5000;
										if (change5000>=coin5000) {
											change5000 = coin5000;
											coin -= change5000*5000;
											if (coin5000 != 0) {
												message2 += ", 5õ���� ����";
											}
											coin5000 = 0;
										}else {
											coin = coin % 5000;
											coin5000 -=change5000;
										}
									}
									if (coin / 1000 > 0) {
										change1000 = coin / 1000;
										if (change1000>=coin1000) {
											change1000 = coin1000;
											coin -= change1000*1000;
											if (coin1000 != 0) {
												message2 += ", 1õ���� ����";
											}
											coin1000 = 0;
										}else {
											coin = coin % 1000;
											coin1000 -=change1000;
										}
									}
									if (coin / 500 > 0) {
										change500 = coin / 500;
										if (change500>=coin500) {
											change500 = coin500;
											coin -= change500*500;
											if (coin500 != 0) {
												message2 += ", 500�� ���� ����";
											}
											coin500 = 0;
										}else {
											coin = coin % 500;
											coin500 -=change500;
										}
									}
									if (coin / 100 > 0) {
										change100 = coin / 100;
										if (change100>=coin100) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100�� ���� ����";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
									change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										coin100++;
										break;
									case 500:
										coin500++;
										break;
									case 1000:
										coin1000++;
										break;
									case 5000:
										coin5000++;
										break;
									case 10000:
										coin10000++;
										break;
									case 50000:
										coin50000++;
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
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5������ ����";
											}
											coin50000 = 0;
										}else {
											coin = coin % 50000;
											coin50000 -=change50000;
										}
									}
									if (coin / 10000 > 0) {
										change10000 = coin / 10000;
										if (change10000>=coin10000) {
											change10000 = coin10000;
											coin -= change10000*10000;
											if (coin10000 != 0) {
												message2 += ", 1������ ����";
											}
											coin10000 = 0;
										}else {
											coin = coin % 10000;
											coin10000 -=change10000;
										}
									}
									if (coin / 5000 > 0) {
										change5000 = coin / 5000;
										if (change5000>=coin5000) {
											change5000 = coin5000;
											coin -= change5000*5000;
											if (coin5000 != 0) {
												message2 += ", 5õ���� ����";
											}
											coin5000 = 0;
										}else {
											coin = coin % 5000;
											coin5000 -=change5000;
										}
									}
									if (coin / 1000 > 0) {
										change1000 = coin / 1000;
										if (change1000>=coin1000) {
											change1000 = coin1000;
											coin -= change1000*1000;
											if (coin1000 != 0) {
												message2 += ", 1õ���� ����";
											}
											coin1000 = 0;
										}else {
											coin = coin % 1000;
											coin1000 -=change1000;
										}
									}
									if (coin / 500 > 0) {
										change500 = coin / 500;
										if (change500>=coin500) {
											change500 = coin500;
											coin -= change500*500;
											if (coin500 != 0) {
												message2 += ", 500�� ���� ����";
											}
											coin500 = 0;
										}else {
											coin = coin % 500;
											coin500 -=change500;
										}
									}
									if (coin / 100 > 0) {
										change100 = coin / 100;
										if (change100>=coin100) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100�� ���� ����";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
									change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										coin100++;
										break;
									case 500:
										coin500++;
										break;
									case 1000:
										coin1000++;
										break;
									case 5000:
										coin5000++;
										break;
									case 10000:
										coin10000++;
										break;
									case 50000:
										coin50000++;
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
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5������ ����";
											}
											coin50000 = 0;
										}else {
											coin = coin % 50000;
											coin50000 -=change50000;
										}
									}
									if (coin / 10000 > 0) {
										change10000 = coin / 10000;
										if (change10000>=coin10000) {
											change10000 = coin10000;
											coin -= change10000*10000;
											if (coin10000 != 0) {
												message2 += ", 1������ ����";
											}
											coin10000 = 0;
										}else {
											coin = coin % 10000;
											coin10000 -=change10000;
										}
									}
									if (coin / 5000 > 0) {
										change5000 = coin / 5000;
										if (change5000>=coin5000) {
											change5000 = coin5000;
											coin -= change5000*5000;
											if (coin5000 != 0) {
												message2 += ", 5õ���� ����";
											}
											coin5000 = 0;
										}else {
											coin = coin % 5000;
											coin5000 -=change5000;
										}
									}
									if (coin / 1000 > 0) {
										change1000 = coin / 1000;
										if (change1000>=coin1000) {
											change1000 = coin1000;
											coin -= change1000*1000;
											if (coin1000 != 0) {
												message2 += ", 1õ���� ����";
											}
											coin1000 = 0;
										}else {
											coin = coin % 1000;
											coin1000 -=change1000;
										}
									}
									if (coin / 500 > 0) {
										change500 = coin / 500;
										if (change500>=coin500) {
											change500 = coin500;
											coin -= change500*500;
											if (coin500 != 0) {
												message2 += ", 500�� ���� ����";
											}
											coin500 = 0;
										}else {
											coin = coin % 500;
											coin500 -=change500;
										}
									}
									if (coin / 100 > 0) {
										change100 = coin / 100;
										if (change100>=coin100) {
											System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100�� ���� ����";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
									change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
									break;
								} else if (tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
									switch (tmp) {
									case 100:
										coin100++;
										break;
									case 500:
										coin500++;
										break;
									case 1000:
										coin1000++;
										break;
									case 5000:
										coin5000++;
										break;
									case 10000:
										coin10000++;
										break;
									case 50000:
										coin50000++;
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
						waterNum--;
						waterSel++;
						if (waterNum <= 0) {
							message2 += ", �� ����";
						}
						break;
					case 4:
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						totalIncome -= coin;
						if (coin / 50000 > 0) {
							change50000 = coin / 50000;
							if (change50000>=coin50000) {
								change50000 = coin50000;
								coin -= change50000*50000;
								if (coin50000 != 0) {
									message2 += ", 5������ ����";
								}
								coin50000 = 0;
							}else {
								coin = coin % 50000;
								coin50000 -=change50000;
							}
						}
						if (coin / 10000 > 0) {
							change10000 = coin / 10000;
							if (change10000>=coin10000) {
								change10000 = coin10000;
								coin -= change10000*10000;
								if (coin10000 != 0) {
									message2 += ", 1������ ����";
								}
								coin10000 = 0;
							}else {
								coin = coin % 10000;
								coin10000 -=change10000;
							}
						}
						if (coin / 5000 > 0) {
							change5000 = coin / 5000;
							if (change5000>=coin5000) {
								change5000 = coin5000;
								coin -= change5000*5000;
								if (coin5000 != 0) {
									message2 += ", 5õ���� ����";
								}
								coin5000 = 0;
							}else {
								coin = coin % 5000;
								coin5000 -=change5000;
							}
						}
						if (coin / 1000 > 0) {
							change1000 = coin / 1000;
							if (change1000>=coin1000) {
								change1000 = coin1000;
								coin -= change1000*1000;
								if (coin1000 != 0) {
									message2 += ", 1õ���� ����";
								}
								coin1000 = 0;
							}else {
								coin = coin % 1000;
								coin1000 -=change1000;
							}
						}
						if (coin / 500 > 0) {
							change500 = coin / 500;
							if (change500>=coin500) {
								change500 = coin500;
								coin -= change500*500;
								if (coin500 != 0) {
									message2 += ", 500�� ���� ����";
								}
								coin500 = 0;
							}else {
								coin = coin % 500;
								coin500 -=change500;
							}
						}
						if (coin / 100 > 0) {
							change100 = coin / 100;
							if (change100>=coin100) {
								System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
								change100 = coin100;
								coin -= change100*100;
								if (coin100 != 0) {
									message2 += ", 100�� ���� ����";
								}
								coin100 = 0;
							}else {
								coin = coin % 100;
								coin100 -=change100;
								coin = 0;
							}
						}
						System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
						change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
						break;
					default:
						System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~4�� �� �ϳ��� ������");
						break;
					}
				}

				beverage = 0;
//				��� ��� ������ �Ž����� ��� ��ȯ ����
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("��� ��� �����Ǿ����ϴ�. ���Ǳ⸦ �̿��Ͻ� �� �����ϴ�.");
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					totalIncome -= coin;
					if (coin / 50000 > 0) {
						change50000 = coin / 50000;
						if (change50000>=coin50000) {
							change50000 = coin50000;
							coin -= change50000*50000;
							if (coin50000 != 0) {
								message2 += ", 5������ ����";
							}
							coin50000 = 0;
						}else {
							coin = coin % 50000;
							coin50000 -=change50000;
						}
					}
					if (coin / 10000 > 0) {
						change10000 = coin / 10000;
						if (change10000>=coin10000) {
							change10000 = coin10000;
							coin -= change10000*10000;
							if (coin10000 != 0) {
								message2 += ", 1������ ����";
							}
							coin10000 = 0;
						}else {
							coin = coin % 10000;
							coin10000 -=change10000;
						}
					}
					if (coin / 5000 > 0) {
						change5000 = coin / 5000;
						if (change5000>=coin5000) {
							change5000 = coin5000;
							coin -= change5000*5000;
							if (coin5000 != 0) {
								message2 += ", 5õ���� ����";
							}
							coin5000 = 0;
						}else {
							coin = coin % 5000;
							coin5000 -=change5000;
						}
					}
					if (coin / 1000 > 0) {
						change1000 = coin / 1000;
						if (change1000>=coin1000) {
							change1000 = coin1000;
							coin -= change1000*1000;
							if (coin1000 != 0) {
								message2 += ", 1õ���� ����";
							}
							coin1000 = 0;
						}else {
							coin = coin % 1000;
							coin1000 -=change1000;
						}
					}
					if (coin / 500 > 0) {
						change500 = coin / 500;
						if (change500>=coin500) {
							change500 = coin500;
							coin -= change500*500;
							if (coin500 != 0) {
								message2 += ", 500�� ���� ����";
							}
							coin500 = 0;
						}else {
							coin = coin % 500;
							coin500 -=change500;
						}
					}
					if (coin / 100 > 0) {
						change100 = coin / 100;
						if (change100>=coin100) {
							System.out.println("�ܵ��� �����Ͽ� �Ž������� �帱�� �����ϴ�.");
							change100 = coin100;
							coin -= change100*100;
							if (coin100 != 0) {
								message2 += ", 100�� ���� ����";
							}
							coin100 = 0;
						}else {
							coin = coin % 100;
							coin100 -=change100;
							coin = 0;
						}
					}
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", change50000, change10000, change5000, change1000, change500, change100);
					change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
