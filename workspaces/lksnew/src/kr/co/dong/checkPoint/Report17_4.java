package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_4 {
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

		int vendingMachingSize = 4;	// ���� ���� ��
		
		String drink = "�������";
		String money = "�ܵ����";
		String drinkName = "�����̸� �� ����";
		String[] dName = new String[vendingMachingSize];
		dName[0] = "�ݶ�"; // ���� �̸� �ʱ� ����
		dName[1] = "Ŀ��";
		dName[2] = "��";
		dName[3] = "���̴�";

		
		String[] message = new String[2];
		message[0] = ""; // �ȳ� �޼��� �ʱⰪ null �Ⱥ��̰�
		message[1] = "";

		int[] dPrice = new int[vendingMachingSize];
		dPrice[0] = 1000; // ���� ���� �ʱ� ����
		dPrice[1] = 1500;
		dPrice[2] = 2000;
		dPrice[3] = 2500;


		int[] dAmount = new int[vendingMachingSize];
		dAmount[0] = 10;	// ���� ��� �ʱ� ����
		dAmount[1] = 10;
		dAmount[2] = 10;
		dAmount[3] = 10;


		int coin = 0;	// �ܾ�
//		�ܵ� ������Ȳ
		
		String[] moneyList = {"5������", "1������", "5õ����", "1õ����", "5���", "���"};
		int[] moneyCount = new int[6];
		int[] moneyChangeCount = new int[6];	//�Ž����� ���� �ʿ� ����
		moneyCount[0] = 1; // �ܵ� �ݾױǺ� �ʱ� ����
		moneyCount[1] = 5;
		moneyCount[2] = 5;
		moneyCount[3] = 5;
		moneyCount[4] = 5;
		moneyCount[5] = 10;

		
		int beverage = 0;

		int adminPw = 1234;	// ������ ��� ���� ��� -> ���� ȭ�鿡���� ����
		int adminMode = 0;	// ��� ��� ������ �������ö�
		int totalIncome = 0;	// �� �����
		
		int[] drinkSoldCount = new int[vendingMachingSize];	// ���Ằ �Ǹ� ����
		
		sys:
		while (!power) {
//			��� ��� ������ �̿�Ұ�
			able:
			while(true) {
				for (int i = 0; i<vendingMachingSize; i++) {
					if(dAmount[i] == 0 && adminMode == 0) {
						continue;
					}else {
						break able;
					}
				}
				System.out.println("��� ��� �����Ǿ����� �����ڿ��� �����ϼ���.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}

//			���� ��� �� ���� ������ ���� ���Ẹ�� �ݾ��� ���� ��� �ٽ� ó�� �޴���
			boolean possible = true;
			for (int i = 0; i < vendingMachingSize; i++) {
				int drinkCountMin = 100;
				int countNum=0;
				for (int j =0; j< vendingMachingSize; j++) {
					if (dAmount[j] !=0 && (dAmount[j] < drinkCountMin)) {
						drinkCountMin = dAmount[j];
						countNum=j;
					}
				}
				if(coin >= dPrice[countNum])
					possible = false;
			}
	
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
				for (int i = 0; i < vendingMachingSize; i++) {
					System.out.printf("  %d. %s : %d��(����:%d)     ",i+1,dName[i],dPrice[i],dAmount[i]);
					if(i % 3 == 2) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.println();
				System.out.printf("                                                          �ܾ� ��ȯ�� ���Ͻø� %d���� ��������%n",vendingMachingSize+1);
				System.out.println();
				System.out.printf("�ȳ� " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");
//				input coin
				System.out.println("�󸶸� �����ðڽ��ϱ�?(���� ȭ��� ������ ��� ����) :");
				int tmp = scan.nextInt();
//				return of change
//				if (tmp == vendingMachingSize+1) {
//					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
//					totalIncome -= coin;
//					int num = 100000;
//					for (int i = 0; i <= 5; i++) {
//						if (i % 2 == 0) {
//							num /= 2;
//						} else {
//							num /= 5;
//						}
//						if (coin / num > 0) {
//							moneyChangeCount[i] = coin / num;
//							if (moneyChangeCount[i]>=moneyCount[i]) {
//								moneyChangeCount[i] = moneyCount[i];
//								coin -= moneyChangeCount[i]*num;
//								if (moneyCount[i] != 0) {
//									message[1] += ", 5������ ����";
//								}
//								moneyCount[i] = 0;
//							}else {
//								coin = coin % num;
//								moneyCount[i] -=moneyChangeCount[i];
//								if(num == 100) {
//									coin = 0;
//								}
//							}
//						}
//					}
//					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
////					�Ž����� ������ ����
//					for (int i = 0 ; i <= 5; i++) {
//						moneyChangeCount[i] = 0;
//					}
//					tmp = 0;
				
		
				if (tmp == vendingMachingSize+1) {
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
					for (int i = 0 ; i <= 5; i++) {
						moneyChangeCount[i] = 0;
					}
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
							for (int i = 0; i < vendingMachingSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,dName[i],drinkSoldCount[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <���Ằ �Ǹż���>                    ");
							for (int i = 0; i < vendingMachingSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,dName[i],drinkSoldCount[i]*dPrice[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <���Ằ ���� ���>                    ");
							for (int i = 0; i < vendingMachingSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,dName[i],dAmount[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <�ܵ� ����>                      ");
							System.out.printf("  50000��: %d��, 10000��: %d��, 5000��: %d��, 1000��: %d��, 500��: %d��, 100��: %d��%n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);
							System.out.println();
							System.out.println();
							System.out.printf("�ȳ� : " + message[1] + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.printf("� ���� �߰��ϰų� ����(����)�Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n",vendingMachingSize+1,vendingMachingSize+2);
							System.out.printf("  1. %s      2. %s      3. %s%n", drink, money, drinkName);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.printf("� ���Ḧ �߰�/���� �Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n",vendingMachingSize+1,vendingMachingSize+2);
								for (int i = 0; i < vendingMachingSize; i++) {
									System.out.printf("  %d. %s          ",i+1,dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachingSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? ���Ҹ� ���ϸ� ������ �Է��ϼ��� : %n", dName[i]);
										dAmount[i] += scan.nextInt();
										System.out.printf("%s �� �߰�(����)�Ǿ� ��� %d�� �Ǿ����ϴ�.%n", dName[i], dAmount[i]);
										beverage = 0;
//										message , ���� �ȳ� �����
										message[1] = message[1].replace(" "+dName[i]+" ����","");
									}
								}
								if(beverage == vendingMachingSize+1){
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if(beverage == vendingMachingSize+2) {
									power = true;
									break sys;
								}
								if(beverage < 0 || beverage > vendingMachingSize+2) {
									System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachingSize+1);
								}
								break;

							case 2:
								System.out.printf("� �ܵ��� �߰� �����Ͻðڽ��ϱ�? �ݾ��� �Է��ϼ���. (������ ��� ����:%d, ���Ǳ� ����off:%d)%n",vendingMachingSize+1, vendingMachingSize+2);
								System.out.printf("50000, 10000, 5000, 1000, 500, 100%n");
								System.out.println();
								int change = scan.nextInt();
								switch (change) {
								case 50000:
									System.out.printf("50000������ ���� �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[0] += scan.nextInt();
									System.out.printf("50000������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[0]);
									message[1] = message[1].replace(" 5������ ����","");
									break;
								case 10000:
									System.out.printf("10000������ ���� �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[1] += scan.nextInt();
									System.out.printf("10000������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[1]);
									message[1] = message[1].replace(" 1������ ����","");
									break;
								case 5000:
									System.out.printf("5000������ ���� �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[2] += scan.nextInt();
									System.out.printf("5000������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[2]);
									message[1] = message[1].replace(" 5õ���� ����","");
									break;
								case 1000:
									System.out.printf("1000������ ���� �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[3] += scan.nextInt();
									System.out.printf("1000������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[3]);
									message[1] = message[1].replace(" 1õ���� ����","");
									break;
								case 500:
									System.out.printf("500�� ������ � �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[4] += scan.nextInt();
									System.out.printf("500�� ������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[4]);
									message[1] = message[1].replace(" 500�� ���� ����","");
									break;
								case 100:
									System.out.printf("100�� ������ � �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
									moneyCount[5] += scan.nextInt();
									System.out.printf("100�� ������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[5]);
									message[1] = message[1].replace(" 100�� ���� ����","");
									break;
								default:
									if (change == vendingMachingSize+1) {
										System.out.println("������ ��带 �����մϴ�.");
										break admin;
									}
									if (change == vendingMachingSize+2) {
										power = true;
										break sys;
									}
									System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n",vendingMachingSize+1);
									break;
								}// switch beverage end
								break;
							case 3:
								System.out.printf("� ���Ḧ ���� �Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n",vendingMachingSize+1,vendingMachingSize+2);
								for (int i = 0; i < vendingMachingSize; i++) {
									System.out.printf("  %d. %s          ",i+1,dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachingSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s ���� �ٲٰ� ���� �̸��� �Է��ϼ��� : %n", dName[i]);
										String tmp1 = dName[i];
										dName[i] = scan.next();
										System.out.printf("%s �� %s�� �̸��� ���� �Ǿ����ϴ�.%n", tmp1, dName[i]);
										System.out.printf("%d�� ���� �ٲٰ� ���� ������ �Է��ϼ��� : %n", dPrice[i]);
										int tmp2 = dPrice[i];
										dPrice[i] = scan.nextInt();
										System.out.printf("%d�� ���� %d������ ������ ���� �Ǿ����ϴ�.%n", tmp2, dPrice[i]);
										
										beverage = 0;
									}
								}
								if(beverage == vendingMachingSize+1){
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if(beverage == vendingMachingSize+2) {
									power = true;
									break sys;
								}
								if(beverage < 0 || beverage > vendingMachingSize+2) {
									System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachingSize+1);
								}

								
								
								break;
							default:
								if (choice == vendingMachingSize+1) {
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if (choice == vendingMachingSize+2) {
									power = true;
									break sys;
								}
								System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~3�� �� �ϳ��� ������");
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
				for (int i = 0; i < vendingMachingSize; i++) {
					System.out.printf("  %d. %s : %d��(����:%d)     ",i+1,dName[i],dPrice[i],dAmount[i]);
					if (i % 3 == 2) {
						System.out.println();
					}
				}
				System.out.println();
				System.out.printf("                                                          �ܾ� ��ȯ�� ���Ͻø� %d���� ��������%n",vendingMachingSize+1);
				System.out.println();
				System.out.printf("�ȳ� : " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");

				if (beverage < 1 || beverage > vendingMachingSize) {
					System.out.printf("������ ���ðڽ��ϱ�(1~%d)? : %n",vendingMachingSize);
					beverage = scan.nextInt();
					for (int i = 0; i < vendingMachingSize ; i++) {
						if(beverage == i+1) {
							if (dAmount[i] <= 0) {
								System.out.printf("%s �����Դϴ�. �ٸ��޴��� �����ϼ���.%n",dName[i]);
								break;
							}
//							���� ���ý� �ܾ� ����
							coin -= dPrice[i];
//							�ܾ��� ���ڶ� ���
							if (coin < 0) {
								coin += dPrice[i];
								System.out.println("�ܾ��� ���ڶ��ϴ�.");
//								������ �߰��� ������ ����� �ƴϸ� �ܵ��� ��ȯ�� �ϵ��� ����
								while (true) {
									System.out.println("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� 4��)");
									int tmp = scan.nextInt();
									if (tmp == vendingMachingSize+1) {
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
										for (int j =0 ; j<= 5; j++) {
											moneyChangeCount[j] = 0;
										}
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
//							���ᰡ ������ ��� ��� ���� ����
							System.out.printf("**%s**�� ���Խ��ϴ�.%n",dName[i]);
							System.out.println();
							dAmount[i]--;
							drinkSoldCount[i]++;
//							������ ���� �ȳ�
							if (dAmount[i] <= 0) {
								message[1] += ", "+dName[i]+" ����";
							}
							break;
						}
					}
					if (beverage == vendingMachingSize+1) {
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
						for (int j = 0; j<=5 ; j++) {
							moneyChangeCount[j] = 0;
						}
					}
					if (beverage == vendingMachingSize+2) {
						System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachingSize);
						break;
					}
				}
				beverage = 0;
//				��� ��� ������ �Ž����� ��� ��ȯ ����
				
				if (dAmount[0] == 0 && dAmount[1] == 0 && dAmount[2] == 0) {
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
					for (int j = 0; j<=5 ; j++) {
						moneyChangeCount[j] = 0;
					}
					adminMode = 0;
				}
			}
		}
		System.out.println("���Ǳ� ����!!");
	}
}
