package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_3 {
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈입력 등
//			99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기

		boolean power = false; // 전원
//		메뉴 입력값, 받은 돈, 가격1,2, 3, 거스름돈
		Scanner scan = new Scanner(System.in);

		int vendingMachingSize = 3;
		
		String drink = "음료";
		String money = "잔돈";
		String[] drinkList = new String[vendingMachingSize];
		drinkList[0] = "콜라"; // 음료 이름 초기 세팅
		drinkList[1] = "커피";
		drinkList[2] = "물";
		
		String[] message = new String[2];
		message[0] = ""; // 안내 메세지 초기값 null 안보이게
		message[1] = "";

		int[] drinkPrice = new int[vendingMachingSize];
		drinkPrice[0] = 1500; // 음료 가격 초기 세팅
		drinkPrice[1] = 2000;
		drinkPrice[2] = 1000;

		int[] drinkCount = new int[vendingMachingSize];
		drinkCount[0] = 10;	// 음료 재고 초기 세팅
		drinkCount[1] = 10;
		drinkCount[2] = 10;

		int coin = 0;	// 잔액
//		잔돈 보유현황
		
		String[] moneyList = {"5만원권", "1만원권", "5천원권", "1천원권", "5백원", "백원"};
		int[] moneyCount = new int[6];
		int[] moneyChangeCount = new int[6];	//거스름돈 계산시 필요 변수
		moneyCount[0] = 0; // 잔돈 금액권별 초기 세팅
		moneyCount[1] = 2;
		moneyCount[2] = 2;
		moneyCount[3] = 4;
		moneyCount[4] = 2;
		moneyCount[5] = 10;

		
		int beverage = 0;

		int adminPw = 1234;	// 관리자 모드 출입 비번 -> 메인 화면에서만 가능
		int adminMode = 0;	// 재고 모두 소진시 빠져나올때
		int totalIncome = 0;	// 총 매출액
		
		int[] drinkSoldCount = new int[vendingMachingSize];	// 음료별 판매 갯수
		
		sys:
		while (!power) {
//			모든 재고 소진시 이용불가
			if (drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0 && adminMode == 0) {
				System.out.println("재고가 모두 소진되었으니 관리자에게 연락하세요.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}
//			남은 재고 중 가장 가격이 낮은 음료보다 금액이 적을 경우 다시 처음 메뉴로
			boolean possible = drinkCount[2] != 0 && coin < drinkPrice[2] || drinkCount[2] == 0 && drinkCount[0] != 0 && coin < drinkPrice[0]
					|| drinkCount[0] == 0 && drinkCount[2] == 0 && drinkCount[1] != 0 && coin < drinkPrice[1] || drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0;
			if (possible) {
				message[0] = "coin을 (더)넣어주세요";
//		메뉴화면 coin
				System.out.println("====================================================================================");
				System.out.println();
				System.out.println("                                   <음료 자판기>                      ");
				System.out.println();
				System.out.printf("                                                               현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3. %s : %d원(수량:%d)%n", drinkList[0], drinkPrice[0],
						drinkCount[0], drinkList[1], drinkPrice[1], drinkCount[1], drinkList[2], drinkPrice[2], drinkCount[2]);
				System.out.println();
				System.out.println("                                                          잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");
//				input coin
				System.out.println("얼마를 넣으시겠습니까?(현행 화폐와 동전만 사용 가능) :");
				int tmp = scan.nextInt();
//				return of change
				if (tmp == 4) {
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					totalIncome -= coin;
//					거스름돈 잔돈 환산
					if (coin / 50000 > 0) {
						moneyChangeCount[0] = coin / 50000;
						if (moneyChangeCount[0]>=moneyCount[0]) {
							moneyChangeCount[0] = moneyCount[0];
							coin -= moneyChangeCount[0]*50000;
							if (moneyCount[0] != 0) {
								message[1] += ", 5만원권 부족";
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
								message[1] += ", 1만원권 부족";
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
								message[1] += ", 5천원권 부족";
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
								message[1] += ", 1천원권 부족";
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
								message[1] += ", 500원 동전 부족";
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
							System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
							moneyChangeCount[5] = moneyCount[5];
							coin -= moneyChangeCount[5]*100;
							if (moneyCount[5] != 0) {
								message[1] += ", 100원 동전 부족";
							}
							moneyCount[5] = 0;
						}else {
							coin = coin % 100;
							moneyCount[5] -=moneyChangeCount[5];
							coin = 0;
						}
					}
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
//					거스름돈 지급후 리셋
					moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
					tmp = 0;
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					거스름돈을 위한 수량 체크
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
					System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
				}
//				관리자 모드(재고 추가)
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
							System.out.printf("  1. %s : %d개     2. %s : %d개    3. %s : %d개%n", drinkList[0], drinkSoldCount[0], drinkList[1],
									drinkSoldCount[1], drinkList[2], drinkSoldCount[2]);
							System.out.println();
							System.out.println("                       <음료별 판매수익>                    ");
							System.out.printf("  1. %s : %d원     2. %s : %d원    3. %s : %d원%n", drinkList[0], drinkSoldCount[0] * drinkPrice[0],
									drinkList[1], drinkSoldCount[1] * drinkPrice[1], drinkList[2], drinkSoldCount[2] * drinkPrice[2]);
							System.out.println();
							System.out.println("                       <음료별 남은 재고>                    ");
							System.out.printf("  1. %s : %d개     2. %s : %d개    3. %s : %d개%n", drinkList[0], drinkCount[0], drinkList[1],
									drinkCount[1], drinkList[2], drinkCount[2]);
							System.out.println();
							System.out.println("                       <잔돈 관리>                      ");
							System.out.printf("  50000원: %d장, 10000원: %d장, 5000원: %d장, 1000원: %d장, 500원: %d개, 100원: %d개%n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);
							System.out.println();
							System.out.printf("안내 : " + message[1] + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println("어떤 것을 추가하거나 수정(인출)하시겠습니까? (관리자 모드 종료:4, 자판기 전원off:5)");
							System.out.printf("1. %s      2. %s%n", drink, money);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.println("어떤 음료를 추가/수정 하시겠습니까? (관리자 모드 종료:4, 자판기 전원off:5)");
								System.out.printf("1. %s      2. %s      3. %s%n", drinkList[0], drinkList[1], drinkList[2]);
								System.out.println();
								beverage = scan.nextInt();
								switch (beverage) {
								case 1:
									System.out.printf("%s 를 몇개 추가하시겠습니까? 감소를 원하면 음수로 입력하세요 : %n", drinkList[0]);
									drinkCount[0] += scan.nextInt();
									System.out.printf("%s 가 추가(수정)되어 재고가 %d가 되었습니다.%n", drinkList[0], drinkCount[0]);
									beverage = 0;
//									message , 매진 안내 지우기
									message[1] = message[1].replace(" 콜라 매진","");
									break;
								case 2:
									System.out.printf("%s 를 몇개 추가하시겠습니까? 감소를 원하면 음수로 입력하세요 : %n", drinkList[1]);
									drinkCount[1] += scan.nextInt();
									System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", drinkList[1], drinkCount[1]);
									beverage = 0;
//									message , 매진 안내 지우기
									message[1] = message[1].replace(" 커피 매진","");
									break;
								case 3:
									System.out.printf("%s 를 몇개 추가하시겠습니까? 감소를 원하면 음수로 입력하세요 : %n", drinkList[2]);
									drinkCount[2] += scan.nextInt();
									System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", drinkList[2], drinkCount[2]);
									beverage = 0;
//									message , 매진 안내 지우기
									message[1] = message[1].replace(" 물 매진","");
									break;
								case 4:
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								case 5:
									power = true;
									break sys;
								
								default:
									System.out.println("잘못 입력하셨습니다. 1~4번 중 하나를 고르세요");
									break;
								}// switch beverage end
								break;
							case 2:
								System.out.println("어떤 잔돈을 추가하시겠습니까? 금액을 입력하세요. (관리자 모드 종료:4, 자판기 전원off:5)");
								System.out.printf("50000, 10000, 5000, 1000, 500, 100%n");
								System.out.println();
								int change = scan.nextInt();
								switch (change) {
								case 50000:
									System.out.printf("50000원권을 몇장 추가하시겠습니까? : %n");
									moneyCount[0] += scan.nextInt();
									System.out.printf("50000원권이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[0]);
									message[1] = message[1].replace(" 5만원권 부족","");
									break;
								case 10000:
									System.out.printf("10000원권을 몇장 추가하시겠습니까? : %n");
									moneyCount[1] += scan.nextInt();
									System.out.printf("10000원권이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[1]);
									message[1] = message[1].replace(" 1만원권 부족","");
									break;
								case 5000:
									System.out.printf("5000원권을 몇장 추가하시겠습니까? : %n");
									moneyCount[2] += scan.nextInt();
									System.out.printf("5000원권이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[2]);
									message[1] = message[1].replace(" 5천원권 부족","");
									break;
								case 1000:
									System.out.printf("1000원권을 몇장 추가하시겠습니까? : %n");
									moneyCount[3] += scan.nextInt();
									System.out.printf("1000원권이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[3]);
									message[1] = message[1].replace(" 1천원권 부족","");
									break;
								case 500:
									System.out.printf("500원 동전을 몇개 추가하시겠습니까? : %n");
									moneyCount[4] += scan.nextInt();
									System.out.printf("500원 동전이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[4]);
									message[1] = message[1].replace(" 500원 동전 부족","");
									break;
								case 100:
									System.out.printf("100원 동전을 몇개 추가하시겠습니까? : %n");
									moneyCount[5] += scan.nextInt();
									System.out.printf("100원 동전이 추가되어 재고가 %d가 되었습니다.%n", moneyCount[5]);
									message[1] = message[1].replace(" 100원 동전 부족","");
									break;
								
								case 4:
									System.out.println("관리자 모드를 종료합니다.");
									break admin;
								case 5:
									power = true;
									break sys;
								
								default:
									System.out.println("잘못 입력하셨습니다. 1~4번 중 하나를 고르세요");
									break;
								}// switch beverage end
								break;
							case 4:
								System.out.println("관리자 모드를 종료합니다.");
								break admin;
							case 5:
								power = true;
								break sys;
							
							default:
								System.out.println("잘못 입력하셨습니다. 1~2번 중 하나를 고르세요");
								break;

							}
							System.out.println();
							
						}// while end
					}
				}
			} else {
//		메뉴화면 choice
				message[0] = "음료를 고르세요";
				System.out.println("====================================================================================");
				System.out.println(); 
				System.out.println("                                       <음료 자판기>                                    ");
				System.out.println();
				System.out.printf("                                                                 현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3 %s : %d원(수량:%d)%n", drinkList[0], drinkPrice[0],
						drinkCount[0], drinkList[1], drinkPrice[1], drinkCount[1], drinkList[2], drinkPrice[2], drinkCount[2]);
				System.out.println();
				System.out.println("                                                           잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 : " + message[0] + message[1] + "%n");
				System.out.println("------------------------------------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("무엇을 고르시겠습니까(1~3)? : ");
					beverage = scan.nextInt();

					switch (beverage) {
					case 1:
						if (drinkCount[0] <= 0) {
							System.out.println("콜라 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
//						음료 선택시 잔액 감소
						coin -= drinkPrice[0];
//						잔액이 모자랄 경우
						if (coin < 0) {
							coin += drinkPrice[0];
							System.out.println("잔액이 모자랍니다.");
//							코인을 추가할 것인지 물어보고 아니면 잔돈을 반환을 하도록 유도
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5만원권 부족";
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
												message[1] += ", 1만원권 부족";
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
												message[1] += ", 5천원권 부족";
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
												message[1] += ", 1천원권 부족";
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
												message[1] += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100원 동전 부족";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
//						음료가 나왔을 경우 재고 수량 조정
						System.out.println("**콜라**가 나왔습니다.");
						System.out.println();
						drinkCount[0]--;
						drinkSoldCount[0]++;
//						매진시 매진 안내
						if (drinkCount[0] <= 0) {
							message[1] += ", 콜라 매진";
						}
						break;
					case 2:
						if (drinkCount[1] <= 0) {
							System.out.println("커피 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= drinkPrice[1];
						if (coin < 0) {
							coin += drinkPrice[1];
							System.out.println("잔액이 모자랍니다.");
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5만원권 부족";
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
												message[1] += ", 1만원권 부족";
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
												message[1] += ", 5천원권 부족";
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
												message[1] += ", 1천원권 부족";
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
												message[1] += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100원 동전 부족";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
						System.out.println("**커피**가 나왔습니다.");
						System.out.println();
						drinkCount[1]--;
						drinkSoldCount[1]++;
						if (drinkCount[1] <= 0) {
							message[1] += ", 커피 매진";
						}
						break;
					case 3:
						if (drinkCount[2] <= 0) {
							System.out.println("물 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= drinkPrice[2];
						if (coin < 0) {
							coin += drinkPrice[2];
							System.out.println("잔액이 모자랍니다.");
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										moneyChangeCount[0] = coin / 50000;
										if (moneyChangeCount[0]>=moneyCount[0]) {
											moneyChangeCount[0] = moneyCount[0];
											coin -= moneyChangeCount[0]*50000;
											if (moneyCount[0] != 0) {
												message[1] += ", 5만원권 부족";
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
												message[1] += ", 1만원권 부족";
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
												message[1] += ", 5천원권 부족";
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
												message[1] += ", 1천원권 부족";
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
												message[1] += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											moneyChangeCount[5] = moneyCount[5];
											coin -= moneyChangeCount[5]*100;
											if (moneyCount[5] != 0) {
												message[1] += ", 100원 동전 부족";
											}
											moneyCount[5] = 0;
										}else {
											coin = coin % 100;
											moneyCount[5] -=moneyChangeCount[5];
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
						System.out.println("**물**이 나왔습니다.");
						System.out.println();
						drinkCount[2]--;
						drinkSoldCount[2]++;
						if (drinkCount[2] <= 0) {
							message[1] += ", 물 매진";
						}
						break;
					case 4:
						System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
						totalIncome -= coin;
						if (coin / 50000 > 0) {
							moneyChangeCount[0] = coin / 50000;
							if (moneyChangeCount[0]>=moneyCount[0]) {
								moneyChangeCount[0] = moneyCount[0];
								coin -= moneyChangeCount[0]*50000;
								if (moneyCount[0] != 0) {
									message[1] += ", 5만원권 부족";
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
									message[1] += ", 1만원권 부족";
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
									message[1] += ", 5천원권 부족";
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
									message[1] += ", 1천원권 부족";
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
									message[1] += ", 500원 동전 부족";
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
								System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
								moneyChangeCount[5] = moneyCount[5];
								coin -= moneyChangeCount[5]*100;
								if (moneyCount[5] != 0) {
									message[1] += ", 100원 동전 부족";
								}
								moneyCount[5] = 0;
							}else {
								coin = coin % 100;
								moneyCount[5] -=moneyChangeCount[5];
								coin = 0;
							}
						}
						System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
						moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 1~4번 중 하나를 고르세요");
						break;
					}
				}

				beverage = 0;
//				모든 재고 소진시 거스름돈 모두 반환 유도
				if (drinkCount[0] == 0 && drinkCount[1] == 0 && drinkCount[2] == 0) {
					System.out.println("모든 재고가 소진되었습니다. 자판기를 이용하실 수 없습니다.");
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					totalIncome -= coin;
					if (coin / 50000 > 0) {
						moneyChangeCount[0] = coin / 50000;
						if (moneyChangeCount[0]>=moneyCount[0]) {
							moneyChangeCount[0] = moneyCount[0];
							coin -= moneyChangeCount[0]*50000;
							if (moneyCount[0] != 0) {
								message[1] += ", 5만원권 부족";
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
								message[1] += ", 1만원권 부족";
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
								message[1] += ", 5천원권 부족";
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
								message[1] += ", 1천원권 부족";
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
								message[1] += ", 500원 동전 부족";
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
							System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
							moneyChangeCount[5] = moneyCount[5];
							coin -= moneyChangeCount[5]*100;
							if (moneyCount[5] != 0) {
								message[1] += ", 100원 동전 부족";
							}
							moneyCount[5] = 0;
						}else {
							coin = coin % 100;
							moneyCount[5] -=moneyChangeCount[5];
							coin = 0;
						}
					}
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyChangeCount[0], moneyChangeCount[1], moneyChangeCount[2], moneyChangeCount[3], moneyChangeCount[4], moneyChangeCount[5]);
					moneyChangeCount[0] = 0; moneyChangeCount[1] = 0; moneyChangeCount[2] = 0; moneyChangeCount[3] = 0; moneyChangeCount[4] = 0; moneyChangeCount[5] = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}
}
