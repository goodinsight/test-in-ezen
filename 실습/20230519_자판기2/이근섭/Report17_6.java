package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_6 {
	public static void main(String[] args) {

		boolean power = false; // ����
		Scanner scan = new Scanner(System.in);
		
		int vendingMachineSize = 5;	// ���� ���� ��
		Beverage b = new Beverage(vendingMachineSize); //Beverage ��ü ����
		
		b.dName = new String[]{"��","���̴�","�ݶ�","�����ݶ�","Ŀ��"}; // ���� �̸� �ʱ�ȭ 
		b.dPrice = new int[]{1000, 1500, 2000, 2000, 2500}; // ���� ���� �ʱ�ȭ
		b.dAmount = new int[]{5, 5, 5, 5, 5};	// ���� ��� �ʱ�ȭ
		
		String drink = "�������";
		String money = "�ܵ����";
		String drinkName = "�����̸� �� ����";
		
		String[] message = new String[2];
		message[0] = ""; // �ȳ� �޼��� �ʱⰪ null �Ⱥ��̰�
		message[1] = "";

		int coin = 0;	// �ܾ�
		int[] moneyName = new int[] {50000, 10000, 5000, 1000, 500, 100};
//		�ܵ� ������Ȳ
		int[] moneyCount = new int[6];
		int[] moneyChangeCount = new int[6];	//�Ž����� ���� �ʿ� ����
		moneyCount = new int[] {1, 2, 2, 2, 2, 10}; // �ܵ� �ݾױǺ� ���� �ʱ�ȭ
		
		int beverage = 0;

		int adminPw = 1234;	// ������ ��� ���� ��� -> ���� ȭ�鿡���� ����
		int adminOff = 77;
		int sysOff = 99;
		int adminMode = 0;	// ��� ��� ������ �������ö�
		int totalIncome = 0;	// �� �����
		
		int[] drinkSoldCount = new int[vendingMachineSize];	// ���Ằ �Ǹ� ����
		
		sys:
		while (!power) {

//			���� ��� �� ���� ������ ���� ���Ẹ�� �ݾ��� ���� ��� �ٽ� ó�� �޴���
			boolean possible = possible(vendingMachineSize, b, coin);
	
			if (possible) {
				
				message[0] = "coin�� (��)�־��ּ���";
//			�޴�ȭ��
				showMenu(vendingMachineSize, b, coin, message);
				
//				input coin
			
				System.out.println("�󸶸� �����ðڽ��ϱ�?(���� ȭ��� ������ ��� ����) :");
				int tmp = scan.nextInt();

				//				return of change
				if (tmp == vendingMachineSize+1) {
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					int num = 100000;
					for (int i = 0; i <= 5; i++) {
						if (i % 2 == 0) {
							num /= 2;
						} else {
							num /= 5;
						}
						if (coin / num > 0) {
							moneyChangeCount[i] = coin / num;
							if (moneyChangeCount[i]>=moneyCount[i]) {
								moneyChangeCount[i] = moneyCount[i];
								coin -= moneyChangeCount[i]*num;
								if (moneyCount[i] != 0) {
									message[1] += ", "+num+"���� ����";
								}
								moneyCount[i] = 0;
							}else {
								coin = coin % num;
								moneyCount[i] -=moneyChangeCount[i];
								if(num == 100) {
									coin = 0;
								}
							}
						}
					}
					for (int i =0; i<=5;i++) totalIncome -= moneyChangeCount[i]*moneyName[i];
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					�Ž����� ������ ����
					for (int i = 0 ; i <= 5; i++) {
						moneyChangeCount[i] = 0;
					}
					tmp = 0;
					//return of change end
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					�Ž������� ���� ���� üũ
					for (int i =0; i<=5; i++) {
						if(tmp == moneyName[i]) {
							moneyCount[i]++;
						}
					}
					totalIncome += tmp;
				} else {
					System.out.println("�����̳� ���� �ƴմϴ�. �ٽ� ��������.");
				} 
				
//				������ ���
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
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,b.dName[i],drinkSoldCount[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <���Ằ �Ǹż���>                    ");
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,b.dName[i],drinkSoldCount[i]*b.dPrice[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <���Ằ ���� ���>                    ");
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d��     ",i+1,b.dName[i],b.dAmount[i]);
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
							System.out.printf("<�ȳ�> " + message[1] + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.printf("� ���� �߰��ϰų� ����(����)�Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n", adminOff, sysOff);
							System.out.printf("  1. %s      2. %s      3. %s%n", drink, money, drinkName);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.printf("� ���Ḧ �߰�/���� �Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n", adminOff, sysOff);
								for (int i = 0; i < vendingMachineSize; i++) {
									System.out.printf("  %d. %s          ",i+1,b.dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachineSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s �� � �߰��Ͻðڽ��ϱ�? ���Ҹ� ���ϸ� ������ �Է��ϼ��� : %n", b.dName[i]);
										b.dAmount[i] += scan.nextInt();
										System.out.printf("%s �� �߰�(����)�Ǿ� ��� %d�� �Ǿ����ϴ�.%n", b.dName[i], b.dAmount[i]);
										beverage = 0;
//										message , ���� �ȳ� �����
										message[1] = message[1].replace(" "+b.dName[i]+" ����","");
									}
								}
								if(beverage == adminOff){
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if(beverage == sysOff) {
									power = true;
									break sys;
								}
								if(beverage < 0 && beverage != adminOff && beverage != sysOff || beverage > vendingMachineSize && beverage != adminOff && beverage != sysOff) {
									System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachineSize);
								}
								break;

							case 2:
								System.out.printf("� �ܵ��� �߰� �����Ͻðڽ��ϱ�? �ݾ��� �Է��ϼ���. (������ ��� ����:%d, ���Ǳ� ����off:%d)%n", adminOff, sysOff);
								System.out.printf("50000, 10000, 5000, 1000, 500, 100%n");
								System.out.println();
								int change = scan.nextInt();
								int num = 100000;
								for (int i = 0; i <= 5; i++) {
									if (i % 2 == 0) {
										num /= 2;
									} else {
										num /= 5;
									}
									if(change == num) {
										System.out.printf(num+"���� �󸶳� �߰��Ͻðڽ��ϱ�?  ���Ҹ� ���ϸ� ������ �Է��ϼ���: %n");
										moneyCount[i] += scan.nextInt();
										System.out.printf(num+"������ �����Ǿ� ��� %d�� �Ǿ����ϴ�.%n", moneyCount[i]);
										message[1] = message[1].replace(" "+num+"���� ����","");
										break;
									}
								}
								if (change == adminOff) {
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if (change == sysOff) {
									power = true;
									break sys;
								}
								System.out.printf("�߸� �Է��ϼ̽��ϴ�. %n");
								break;
							case 3:
								System.out.printf("� ���Ḧ ���� �Ͻðڽ��ϱ�? (������ ��� ����:%d, ���Ǳ� ����off:%d)%n", adminOff, sysOff);
								for (int i = 0; i < vendingMachineSize; i++) {
									System.out.printf("  %d. %s          ",i+1,b.dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachineSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s ���� �ٲٰ� ���� �̸��� �Է��ϼ��� : %n", b.dName[i]);
										String tmp1 = b.dName[i];
										b.dName[i] = scan.next();
										System.out.printf("%s �� %s�� �̸��� ���� �Ǿ����ϴ�.%n", tmp1, b.dName[i]);
										System.out.printf("%d�� ���� �ٲٰ� ���� ������ �Է��ϼ��� : %n", b.dPrice[i]);
										int tmp2 = b.dPrice[i];
										b.dPrice[i] = scan.nextInt();
										System.out.printf("%d�� ���� %d������ ������ ���� �Ǿ����ϴ�.%n", tmp2, b.dPrice[i]);
										
										beverage = 0;
										break;
									}
								}
								if(beverage == adminOff){
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if(beverage == sysOff) {
									power = true;
									break sys;
								}
								if(beverage < 0 && beverage != adminOff && beverage != sysOff || beverage > vendingMachineSize && beverage != adminOff && beverage != sysOff) {
									System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachineSize);
									break;
								}
							default:
								if (choice == adminOff) {
									System.out.println("������ ��带 �����մϴ�.");
									break admin;
								}
								if (choice == sysOff) {
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
//				������ ��� end
			} else {
//		�޴�ȭ�� choice
				message[0] = "���Ḧ ������";
				showMenu(vendingMachineSize, b, coin, message);

				if (beverage < 1 || beverage > vendingMachineSize) {
					System.out.printf("������ ���ðڽ��ϱ�(1~%d)? : %n",vendingMachineSize);
					beverage = scan.nextInt();
					for (int i = 0; i < vendingMachineSize ; i++) {
						if(beverage == i+1) {
							if (b.dAmount[i] <= 0) {
								System.out.printf("%s �����Դϴ�. �ٸ��޴��� �����ϼ���.%n",b.dName[i]);
								break;
							}
//							���� ���ý� �ܾ� ����
							coin -= b.dPrice[i];
//							�ܾ��� ���ڶ� ���
							if (coin < 0) {
								coin += b.dPrice[i];
								System.out.println("�ܾ��� ���ڶ��ϴ�.");
//								������ �߰��� ������ ����� �ƴϸ� �ܵ��� ��ȯ�� �ϵ��� ����
								while (true) {
									System.out.printf("�󸶸� �����ðڽ��ϱ�? : (�ܵ� ��ȯ�� %d��)%n",vendingMachineSize+1);
									int tmp = scan.nextInt();
//							return of change
									if (tmp == vendingMachineSize+1) {
										System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
										int num = 100000;
										for (int j = 0; j <= 5; j++) {
											if (j % 2 == 0) {
												num /= 2;
											} else {
												num /= 5;
											}
											if (coin / num > 0) {
												moneyChangeCount[j] = coin / num;
												if (moneyChangeCount[j]>=moneyCount[j]) {
													moneyChangeCount[j] = moneyCount[j];
													coin -= moneyChangeCount[j]*num;
													if (moneyCount[j] != 0) {
														message[1] += ", "+num+"���� ����";
													}
													moneyCount[j] = 0;
												}else {
													coin = coin % num;
													moneyCount[j] -=moneyChangeCount[j];
													if(num == 100) {
														coin = 0;
													}
												}
											}
										}
										for (int k =0; k<=5;k++) totalIncome -= moneyChangeCount[k]*moneyName[k];
										System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//										�Ž����� ������ ����
										for (int j = 0 ; j <= 5; j++) {
											moneyChangeCount[j] = 0;
										}
										tmp = 0;
										beverage = 0;
										break;
//								    return of change end
									}else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
											|| tmp == 10000 || tmp == 50000) {
										coin += tmp;
//										�Ž������� ���� ���� üũ
										for (int j =0; j<=5; j++) {
											if(tmp == moneyName[j]) {
												moneyCount[j]++;
											}
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
							System.out.printf("**%s**�� ���Խ��ϴ�.%n",b.dName[i]);
							System.out.println();
							b.dAmount[i]--;
							drinkSoldCount[i]++;
//							������ ���� �ȳ�
							if (b.dAmount[i] <= 0) {
								message[1] += ", "+b.dName[i]+" ����";
							}
							break;
						}
					}
					if (beverage == vendingMachineSize+1) {
						System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
						int num = 100000;
						for (int j = 0; j <= 5; j++) {
							if (j % 2 == 0) {
								num /= 2;
							} else {
								num /= 5;
							}
							if (coin / num > 0) {
								moneyChangeCount[j] = coin / num;
								if (moneyChangeCount[j]>=moneyCount[j]) {
									moneyChangeCount[j] = moneyCount[j];
									coin -= moneyChangeCount[j]*num;
									if (moneyCount[j] != 0) {
										message[1] += ", "+num+"���� ����";
									}
									moneyCount[j] = 0;
								}else {
									coin = coin % num;
									moneyCount[j] -=moneyChangeCount[j];
									if(num == 100) {
										coin = 0;
									}
								}
							}
						}
						for (int k =0; k<=5;k++) totalIncome -= moneyChangeCount[k]*moneyName[k];
						System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//						�Ž����� ������ ����
						for (int j = 0 ; j <= 5; j++) {
							moneyChangeCount[j] = 0;
						}
					}
					if (beverage < 1 || beverage > vendingMachineSize) {
						System.out.printf("�߸� �Է��ϼ̽��ϴ�. 1~%d�� �� �ϳ��� ������%n", vendingMachineSize);
					}
				}
				beverage = 0;
//				��� ��� ������ �Ž����� ��� ��ȯ ����
				int sumOfAmount = 0;
				for (int i = 0; i < vendingMachineSize; i++) {
					sumOfAmount += b.dAmount[i];
				}
				if (sumOfAmount == 0) {
					System.out.println("��� ��� �����Ǿ����ϴ�. ���Ǳ⸦ �̿��Ͻ� �� �����ϴ�.");
					System.out.printf("�ܾ�(�Ž�����) %d���� ��ȯ�մϴ�.%n", coin);
					int num = 100000;
					for (int i = 0; i <= 5; i++) {
						if (i % 2 == 0) {
							num /= 2;
						} else {
							num /= 5;
						}
						if (coin / num > 0) {
							moneyChangeCount[i] = coin / num;
							if (moneyChangeCount[i]>=moneyCount[i]) {
								moneyChangeCount[i] = moneyCount[i];
								coin -= moneyChangeCount[i]*num;
								if (moneyCount[i] != 0) {
									message[1] += ", "+num+"���� ����";
								}
								moneyCount[i] = 0;
							}else {
								coin = coin % num;
								moneyCount[i] -=moneyChangeCount[i];
								if(num == 100) {
									coin = 0;
								}
							}
						}
					}
					for (int k =0; k<=5;k++) totalIncome -= moneyChangeCount[k]*moneyName[k];
					System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					�Ž����� ������ ����
					for (int i = 0 ; i <= 5; i++) {
						moneyChangeCount[i] = 0;
					}
					adminMode = 0;
				}
			}
//			��� ��� ������ �̿�Ұ�
			able:
			while(true) {
				for (int i = 0; i<vendingMachineSize; i++) {
					if(b.dAmount[i] == 0 && adminMode == 0) {
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
		}
		System.out.println("���Ǳ� ����!!");
	}


	private static void showMenu(int vendingMachineSize, Beverage b, int coin, String[] message) {
		// ���� �޴� ȭ��
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("                                   <���� ���Ǳ�>                                       ");
		System.out.println();
		System.out.printf("                                                               ���� �ܾ��� :  %d��", coin);
		System.out.println();
		System.out.println();
		for (int i = 0; i < vendingMachineSize; i++) {
			System.out.printf("  %d. %s : %d��(����:%d)     ",i+1,b.dName[i],b.dPrice[i],b.dAmount[i]);
			if(i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
		System.out.printf("                                                          �ܾ� ��ȯ�� ���Ͻø� %d���� ��������%n",vendingMachineSize+1);
		System.out.println();
		System.out.printf("<�ȳ�> " + message[0] + message[1] + "%n");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------");
		
	}

	private static boolean possible(int vendingMachineSize, Beverage b, int coin) {
		// ���� ��� �� ���� ������ ���� ���Ẹ�� �ݾ��� ���� ��� �ٽ� ó�� �޴���
		for (int i = 0; i < vendingMachineSize; i++) {
			int drinkPriceMin = 50000;
			int countNum=0;
			for (int j =0; j< vendingMachineSize; j++) {
				if (b.dAmount[j] !=0 && (b.dPrice[j] < drinkPriceMin)) {
					drinkPriceMin = b.dPrice[j];
					countNum=j;
				}
			}
			if(coin >= b.dPrice[countNum])
				return false;
		}
		return true;
		
	}
}
class Beverage{
	int vendingMachineSize;
	
	String[] dName;
	int[] dPrice;
	int[] dAmount;
	
	public Beverage() {
	}
	
	public Beverage(int Size){
		dName = new String[Size];
		dPrice = new int[Size];
		dAmount = new int[Size];
	}
	
	void setVendingMachingSize(int Size) {
		this.vendingMachineSize = Size;
		dName = new String[this.vendingMachineSize];
		dPrice = new int[this.vendingMachineSize];
		dAmount = new int[this.vendingMachineSize];
	}
}

