package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_6 {
	public static void main(String[] args) {

		boolean power = false; // 전원
		Scanner scan = new Scanner(System.in);
		
		int vendingMachineSize = 5;	// 음료 종류 수
		Beverage b = new Beverage(vendingMachineSize); //Beverage 객체 생성
		
		b.dName = new String[]{"물","사이다","콜라","제로콜라","커피"}; // 음료 이름 초기화 
		b.dPrice = new int[]{1000, 1500, 2000, 2000, 2500}; // 음료 가격 초기화
		b.dAmount = new int[]{5, 5, 5, 5, 5};	// 음료 재고 초기화
		
		String drink = "음료재고";
		String money = "잔돈재고";
		String drinkName = "음료이름 및 가격";
		
		String[] message = new String[2];
		message[0] = ""; // 안내 메세지 초기값 null 안보이게
		message[1] = "";

		int coin = 0;	// 잔액
		int[] moneyName = new int[] {50000, 10000, 5000, 1000, 500, 100};
//		잔돈 보유현황
		int[] moneyCount = new int[6];
		int[] moneyChangeCount = new int[6];	//거스름돈 계산시 필요 변수
		moneyCount = new int[] {1, 2, 2, 2, 2, 10}; // 잔돈 금액권별 갯수 초기화
		
		int beverage = 0;

		int adminPw = 1234;	// 관리자 모드 출입 비번 -> 메인 화면에서만 가능
		int adminOff = 77;
		int sysOff = 99;
		int adminMode = 0;	// 재고 모두 소진시 빠져나올때
		int totalIncome = 0;	// 총 매출액
		
		int[] drinkSoldCount = new int[vendingMachineSize];	// 음료별 판매 갯수
		
		sys:
		while (!power) {

//			남은 재고 중 가장 가격이 낮은 음료보다 금액이 적을 경우 다시 처음 메뉴로
			boolean possible = possible(vendingMachineSize, b, coin);
	
			if (possible) {
				
				message[0] = "coin을 (더)넣어주세요";
//			메뉴화면
				showMenu(vendingMachineSize, b, coin, message);
				
//				input coin
			
				System.out.println("얼마를 넣으시겠습니까?(현행 화폐와 동전만 사용 가능) :");
				int tmp = scan.nextInt();

				//				return of change
				if (tmp == vendingMachineSize+1) {
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
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
									message[1] += ", "+num+"원권 부족";
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
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					거스름돈 지급후 리셋
					for (int i = 0 ; i <= 5; i++) {
						moneyChangeCount[i] = 0;
					}
					tmp = 0;
					//return of change end
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					거스름돈을 위한 수량 체크
					for (int i =0; i<=5; i++) {
						if(tmp == moneyName[i]) {
							moneyCount[i]++;
						}
					}
					totalIncome += tmp;
				} else {
					System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
				} 
				
//				관리자 모드
				if (tmp == adminPw) {
					admin:
					while (true) {

						while (true) {
//							message , 지우기
							message[1] = message[1].replace(',',' '); 
							
							System.out.println("====================================================================================");
							System.out.println();
							System.out.println("                                     <관리자 모드>                                    ");
							System.out.println();
							System.out.printf("                                                     현재까지 총 수입은 :  %d원%n", totalIncome);
							System.out.println();
							System.out.println("                       <음료별 판매현황>                      ");
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d개     ",i+1,b.dName[i],drinkSoldCount[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <음료별 판매수익>                    ");
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d원     ",i+1,b.dName[i],drinkSoldCount[i]*b.dPrice[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <음료별 남은 재고>                    ");
							for (int i = 0; i < vendingMachineSize; i++) {
								System.out.printf("  %d. %s : %d개     ",i+1,b.dName[i],b.dAmount[i]);
								if(i % 3 == 2) {
									System.out.println();
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("                       <잔돈 관리>                      ");
							System.out.printf("  50000원: %d장, 10000원: %d장, 5000원: %d장, 1000원: %d장, 500원: %d개, 100원: %d개%n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);
							System.out.println();
							System.out.println();
							System.out.printf("<안내> " + message[1] + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.printf("어떤 것을 추가하거나 수정(인출)하시겠습니까? (관리자 모드 종료:%d, 자판기 전원off:%d)%n", adminOff, sysOff);
							System.out.printf("  1. %s      2. %s      3. %s%n", drink, money, drinkName);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.printf("어떤 음료를 추가/수정 하시겠습니까? (관리자 모드 종료:%d, 자판기 전원off:%d)%n", adminOff, sysOff);
								for (int i = 0; i < vendingMachineSize; i++) {
									System.out.printf("  %d. %s          ",i+1,b.dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachineSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s 를 몇개 추가하시겠습니까? 감소를 원하면 음수로 입력하세요 : %n", b.dName[i]);
										b.dAmount[i] += scan.nextInt();
										System.out.printf("%s 가 추가(수정)되어 재고가 %d가 되었습니다.%n", b.dName[i], b.dAmount[i]);
										beverage = 0;
//										message , 매진 안내 지우기
										message[1] = message[1].replace(" "+b.dName[i]+" 매진","");
									}
								}
								if(beverage == adminOff){
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								}
								if(beverage == sysOff) {
									power = true;
									break sys;
								}
								if(beverage < 0 && beverage != adminOff && beverage != sysOff || beverage > vendingMachineSize && beverage != adminOff && beverage != sysOff) {
									System.out.printf("잘못 입력하셨습니다. 1~%d번 중 하나를 고르세요%n", vendingMachineSize);
								}
								break;

							case 2:
								System.out.printf("어떤 잔돈을 추가 수정하시겠습니까? 금액을 입력하세요. (관리자 모드 종료:%d, 자판기 전원off:%d)%n", adminOff, sysOff);
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
										System.out.printf(num+"원을 얼마나 추가하시겠습니까?  감소를 원하면 음수로 입력하세요: %n");
										moneyCount[i] += scan.nextInt();
										System.out.printf(num+"원권이 수정되어 재고가 %d가 되었습니다.%n", moneyCount[i]);
										message[1] = message[1].replace(" "+num+"원권 부족","");
										break;
									}
								}
								if (change == adminOff) {
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								}
								if (change == sysOff) {
									power = true;
									break sys;
								}
								System.out.printf("잘못 입력하셨습니다. %n");
								break;
							case 3:
								System.out.printf("어떤 음료를 변경 하시겠습니까? (관리자 모드 종료:%d, 자판기 전원off:%d)%n", adminOff, sysOff);
								for (int i = 0; i < vendingMachineSize; i++) {
									System.out.printf("  %d. %s          ",i+1,b.dName[i]); 
								}
								System.out.println();
								beverage = scan.nextInt();
								for (int i = 0; i < vendingMachineSize; i++) {
									if (beverage == (i+1)) {
										System.out.printf("%s 에서 바꾸고 싶은 이름을 입력하세요 : %n", b.dName[i]);
										String tmp1 = b.dName[i];
										b.dName[i] = scan.next();
										System.out.printf("%s 가 %s로 이름이 변경 되었습니다.%n", tmp1, b.dName[i]);
										System.out.printf("%d원 에서 바꾸고 싶은 가격을 입력하세요 : %n", b.dPrice[i]);
										int tmp2 = b.dPrice[i];
										b.dPrice[i] = scan.nextInt();
										System.out.printf("%d원 에서 %d원으로 가격이 변경 되었습니다.%n", tmp2, b.dPrice[i]);
										
										beverage = 0;
										break;
									}
								}
								if(beverage == adminOff){
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								}
								if(beverage == sysOff) {
									power = true;
									break sys;
								}
								if(beverage < 0 && beverage != adminOff && beverage != sysOff || beverage > vendingMachineSize && beverage != adminOff && beverage != sysOff) {
									System.out.printf("잘못 입력하셨습니다. 1~%d번 중 하나를 고르세요%n", vendingMachineSize);
									break;
								}
							default:
								if (choice == adminOff) {
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								}
								if (choice == sysOff) {
									power = true;
									break sys;
								}
								System.out.println("잘못 입력하셨습니다. 1~3번 중 하나를 고르세요");
								break;
							}
							System.out.println();
						}// while end
					}
				}
//				관리자 모드 end
			} else {
//		메뉴화면 choice
				message[0] = "음료를 고르세요";
				showMenu(vendingMachineSize, b, coin, message);

				if (beverage < 1 || beverage > vendingMachineSize) {
					System.out.printf("무엇을 고르시겠습니까(1~%d)? : %n",vendingMachineSize);
					beverage = scan.nextInt();
					for (int i = 0; i < vendingMachineSize ; i++) {
						if(beverage == i+1) {
							if (b.dAmount[i] <= 0) {
								System.out.printf("%s 매진입니다. 다른메뉴를 선택하세요.%n",b.dName[i]);
								break;
							}
//							음료 선택시 잔액 감소
							coin -= b.dPrice[i];
//							잔액이 모자랄 경우
							if (coin < 0) {
								coin += b.dPrice[i];
								System.out.println("잔액이 모자랍니다.");
//								코인을 추가할 것인지 물어보고 아니면 잔돈을 반환을 하도록 유도
								while (true) {
									System.out.printf("얼마를 넣으시겠습니까? : (잔돈 반환은 %d번)%n",vendingMachineSize+1);
									int tmp = scan.nextInt();
//							return of change
									if (tmp == vendingMachineSize+1) {
										System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
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
														message[1] += ", "+num+"원권 부족";
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
										System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//										거스름돈 지급후 리셋
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
//										거스름돈을 위한 수량 체크
										for (int j =0; j<=5; j++) {
											if(tmp == moneyName[j]) {
												moneyCount[j]++;
											}
										}
										totalIncome += tmp;

										break;
									} else {
										System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
									}
								}
								break;
							}
//							음료가 나왔을 경우 재고 수량 조정
							System.out.printf("**%s**가 나왔습니다.%n",b.dName[i]);
							System.out.println();
							b.dAmount[i]--;
							drinkSoldCount[i]++;
//							매진시 매진 안내
							if (b.dAmount[i] <= 0) {
								message[1] += ", "+b.dName[i]+" 매진";
							}
							break;
						}
					}
					if (beverage == vendingMachineSize+1) {
						System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
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
										message[1] += ", "+num+"원권 부족";
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
						System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//						거스름돈 지급후 리셋
						for (int j = 0 ; j <= 5; j++) {
							moneyChangeCount[j] = 0;
						}
					}
					if (beverage < 1 || beverage > vendingMachineSize) {
						System.out.printf("잘못 입력하셨습니다. 1~%d번 중 하나를 고르세요%n", vendingMachineSize);
					}
				}
				beverage = 0;
//				모든 재고 소진시 거스름돈 모두 반환 유도
				int sumOfAmount = 0;
				for (int i = 0; i < vendingMachineSize; i++) {
					sumOfAmount += b.dAmount[i];
				}
				if (sumOfAmount == 0) {
					System.out.println("모든 재고가 소진되었습니다. 자판기를 이용하실 수 없습니다.");
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
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
									message[1] += ", "+num+"원권 부족";
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
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					거스름돈 지급후 리셋
					for (int i = 0 ; i <= 5; i++) {
						moneyChangeCount[i] = 0;
					}
					adminMode = 0;
				}
			}
//			모든 재고 소진시 이용불가
			able:
			while(true) {
				for (int i = 0; i<vendingMachineSize; i++) {
					if(b.dAmount[i] == 0 && adminMode == 0) {
						continue;
					}else {
						break able;
					}
				}
				System.out.println("재고가 모두 소진되었으니 관리자에게 연락하세요.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}


	private static void showMenu(int vendingMachineSize, Beverage b, int coin, String[] message) {
		// 메인 메뉴 화면
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("                                   <음료 자판기>                                       ");
		System.out.println();
		System.out.printf("                                                               현재 잔액은 :  %d원", coin);
		System.out.println();
		System.out.println();
		for (int i = 0; i < vendingMachineSize; i++) {
			System.out.printf("  %d. %s : %d원(수량:%d)     ",i+1,b.dName[i],b.dPrice[i],b.dAmount[i]);
			if(i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
		System.out.printf("                                                          잔액 반환을 원하시면 %d번을 누르세요%n",vendingMachineSize+1);
		System.out.println();
		System.out.printf("<안내> " + message[0] + message[1] + "%n");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------");
		
	}

	private static boolean possible(int vendingMachineSize, Beverage b, int coin) {
		// 남은 재고 중 가장 가격이 낮은 음료보다 금액이 적을 경우 다시 처음 메뉴로
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

