package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_2 {
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

		String drink = "음료";
		String money = "잔돈";
		String cola = "콜라";
		String coffee = "커피";
		String water = "물";
		String message1 = "", message2 = "";

		int colaPrice = 1500;	
		int coffeePrice = 2000;
		int waterPrice = 1000;

		int colaNum = 10;	// 콜라 초기 재고
		int coffeeNum = 10;
		int waterNum = 10;

		int coin = 0;	// 잔액
//		잔돈 보유현황
		int coin50000 = 0; // 5만원권
		int coin10000 = 2;
		int coin5000 = 2;
		int coin1000 = 4;
		int coin500 = 2;
		int coin100 = 10;
		int change50000 = 0;	//거스름돈 계산시 필요 변수
		int change10000 = 0;
		int change5000 = 0;
		int change1000 = 0;
		int change500 = 0;
		int change100 = 0;
		

		
		int beverage = 0;

		int adminPw = 1234;	// 관리자 모드 출입 비번 -> 메인 화면에서만 가능
		int adminMode = 0;	// 재고 모두 소진시 빠져나올때
		int totalIncome = 0;	// 총 매출액
		int colaSel = 0;	// 콜라 판매 갯수
		int coffeeSel = 0;
		int waterSel = 0;

		sys:
		while (!power) {
//			모든 재고 소진시 이용불가
			if (colaNum == 0 && coffeeNum == 0 && waterNum == 0 && adminMode == 0) {
				System.out.println("재고가 모두 소진되었으니 관리자에게 연락하세요.");
				int tmp = scan.nextInt();
				if (tmp == adminPw) {
					adminMode = 1;
				}
			}
//			남은 재고 중 가장 가격이 낮은 음료보다 금액이 적을 경우 다시 처음 메뉴로
			boolean possible = waterNum != 0 && coin < waterPrice || waterNum == 0 && colaNum != 0 && coin < colaPrice
					|| colaNum == 0 && waterNum == 0 && coffeeNum != 0 && coin < coffeePrice || colaNum == 0 && coffeeNum == 0 && waterNum == 0;
			if (possible) {
				message1 = "coin을 (더)넣어주세요";
//		메뉴화면 coin
				System.out.println("====================================================================================");
				System.out.println();
				System.out.println("                                   <음료 자판기>                      ");
				System.out.println();
				System.out.printf("                                                               현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3. %s : %d원(수량:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                                                          잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 " + message1 + message2 + "%n");
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
						change50000 = coin / 50000;
						if (change50000>=coin50000) {
							change50000 = coin50000;
							coin -= change50000*50000;
							if (coin50000 != 0) {
								message2 += ", 5만원권 부족";
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
								message2 += ", 1만원권 부족";
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
								message2 += ", 5천원권 부족";
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
								message2 += ", 1천원권 부족";
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
								message2 += ", 500원 동전 부족";
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
							System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
							change100 = coin100;
							coin -= change100*100;
							if (coin100 != 0) {
								message2 += ", 100원 동전 부족";
							}
							coin100 = 0;
						}else {
							coin = coin % 100;
							coin100 -=change100;
							coin = 0;
						}
					}
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
//					거스름돈 지급후 리셋
					change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
					tmp = 0;
				} else if (tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
//					거스름돈을 위한 수량 체크
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
					System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
				}
//				관리자 모드(재고 추가)
				if (tmp == adminPw) {
					admin:
					while (true) {

						while (true) {
//							message , 지우기
							message2 = message2.replace(',',' '); 
							
							System.out.println("====================================================================================");
							System.out.println();
							System.out.println("                                     <관리자 모드>                                    ");
							System.out.println();
							System.out.printf("                                                     현재까지 총 수입은 :  %d원%n", totalIncome);
							System.out.println();
							System.out.println("                       <음료별 판매현황>                      ");
							System.out.printf("  1. %s : %d개     2. %s : %d개    3. %s : %d개%n", cola, colaSel, coffee,
									coffeeSel, water, waterSel);
							System.out.println();
							System.out.println("                       <음료별 판매수익>                    ");
							System.out.printf("  1. %s : %d원     2. %s : %d원    3. %s : %d원%n", cola, colaSel * colaPrice,
									coffee, coffeeSel * coffeePrice, water, waterSel * waterPrice);
							System.out.println();
							System.out.println("                       <음료별 남은 재고>                    ");
							System.out.printf("  1. %s : %d개     2. %s : %d개    3. %s : %d개%n", cola, colaNum, coffee,
									coffeeNum, water, waterNum);
							System.out.println();
							System.out.println("                       <잔돈 관리>                      ");
							System.out.printf("  50000원: %d장, 10000원: %d장, 5000원: %d장, 1000원: %d장, 500원: %d개, 100원: %d개%n", coin50000, coin10000, coin5000, coin1000, coin500, coin100);
							System.out.println();
							System.out.printf("안내 : " + message2 + "%n");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println("어떤 것을 추가하시겠습니까? (관리자 모드 종료:4, 자판기 전원off:5)");
							System.out.printf("1. %s      2. %s%n", drink, money);
							int choice = scan.nextInt();
							switch (choice) {
							case 1:
								System.out.println("어떤 음료를 추가하시겠습니까? (관리자 모드 종료:4, 자판기 전원off:5)");
								System.out.printf("1. %s      2. %s      3. %s%n", cola, coffee, water);
								System.out.println();
								beverage = scan.nextInt();
								switch (beverage) {
								case 1:
									System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", cola);
									colaNum += scan.nextInt();
									System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", cola, colaNum);
									beverage = 0;
//									message , 매진 안내 지우기
									message2 = message2.replace(" 콜라 매진","");
									break;
								case 2:
									System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", coffee);
									coffeeNum += scan.nextInt();
									System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", coffee, coffeeNum);
									beverage = 0;
//									message , 매진 안내 지우기
									message2 = message2.replace(" 커피 매진","");
									break;
								case 3:
									System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", water);
									waterNum += scan.nextInt();
									System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", water, waterNum);
									beverage = 0;
//									message , 매진 안내 지우기
									message2 = message2.replace(" 물 매진","");
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
									coin50000 += scan.nextInt();
									System.out.printf("50000원권이 추가되어 재고가 %d가 되었습니다.%n", coin50000);
									message2 = message2.replace(" 5만원권 부족","");
									break;
								case 10000:
									System.out.printf("10000원권을 몇장 추가하시겠습니까? : %n");
									coin10000 += scan.nextInt();
									System.out.printf("10000원권이 추가되어 재고가 %d가 되었습니다.%n", coin10000);
									message2 = message2.replace(" 1만원권 부족","");
									break;
								case 5000:
									System.out.printf("5000원권을 몇장 추가하시겠습니까? : %n");
									coin5000 += scan.nextInt();
									System.out.printf("5000원권이 추가되어 재고가 %d가 되었습니다.%n", coin5000);
									message2 = message2.replace(" 5천원권 부족","");
									break;
								case 1000:
									System.out.printf("1000원권을 몇장 추가하시겠습니까? : %n");
									coin1000 += scan.nextInt();
									System.out.printf("1000원권이 추가되어 재고가 %d가 되었습니다.%n", coin1000);
									message2 = message2.replace(" 1천원권 부족","");
									break;
								case 500:
									System.out.printf("500원 동전을 몇개 추가하시겠습니까? : %n");
									coin500 += scan.nextInt();
									System.out.printf("500원 동전이 추가되어 재고가 %d가 되었습니다.%n", coin500);
									message2 = message2.replace(" 500원 동전 부족","");
									break;
								case 100:
									System.out.printf("100원 동전을 몇개 추가하시겠습니까? : %n");
									coin100 += scan.nextInt();
									System.out.printf("100원 동전이 추가되어 재고가 %d가 되었습니다.%n", coin100);
									message2 = message2.replace(" 100원 동전 부족","");
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
				message1 = "음료를 고르세요";
				System.out.println("====================================================================================");
				System.out.println(); 
				System.out.println("                                       <음료 자판기>                                    ");
				System.out.println();
				System.out.printf("                                                                 현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3 %s : %d원(수량:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                                                           잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 : " + message1 + message2 + "%n");
				System.out.println("------------------------------------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("무엇을 고르시겠습니까(1~3)? : ");
					beverage = scan.nextInt();

					switch (beverage) {
					case 1:
						if (colaNum <= 0) {
							System.out.println("콜라 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
//						음료 선택시 잔액 감소
						coin -= colaPrice;
//						잔액이 모자랄 경우
						if (coin < 0) {
							coin += colaPrice;
							System.out.println("잔액이 모자랍니다.");
//							코인을 추가할 것인지 물어보고 아니면 잔돈을 반환을 하도록 유도
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5만원권 부족";
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
												message2 += ", 1만원권 부족";
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
												message2 += ", 5천원권 부족";
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
												message2 += ", 1천원권 부족";
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
												message2 += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100원 동전 부족";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
//						음료가 나왔을 경우 재고 수량 조정
						System.out.println("**콜라**가 나왔습니다.");
						System.out.println();
						colaNum--;
						colaSel++;
//						매진시 매진 안내
						if (colaNum <= 0) {
							message2 += ", 콜라 매진";
						}
						break;
					case 2:
						if (coffeeNum <= 0) {
							System.out.println("커피 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= coffeePrice;
						if (coin < 0) {
							coin += coffeePrice;
							System.out.println("잔액이 모자랍니다.");
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5만원권 부족";
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
												message2 += ", 1만원권 부족";
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
												message2 += ", 5천원권 부족";
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
												message2 += ", 1천원권 부족";
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
												message2 += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100원 동전 부족";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
						System.out.println("**커피**가 나왔습니다.");
						System.out.println();
						coffeeNum--;
						coffeeSel++;
						if (coffeeNum <= 0) {
							message2 += ", 커피 매진";
						}
						break;
					case 3:
						if (waterNum <= 0) {
							System.out.println("물 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= waterPrice;
						if (coin < 0) {
							coin += waterPrice;
							System.out.println("잔액이 모자랍니다.");
							while (true) {
								System.out.println("얼마를 넣으시겠습니까? : (잔돈 반환은 4번)");
								int tmp = scan.nextInt();
								if (tmp == 4) {
									System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
									totalIncome -= coin;
									if (coin / 50000 > 0) {
										change50000 = coin / 50000;
										if (change50000>=coin50000) {
											change50000 = coin50000;
											coin -= change50000*50000;
											if (coin50000 != 0) {
												message2 += ", 5만원권 부족";
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
												message2 += ", 1만원권 부족";
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
												message2 += ", 5천원권 부족";
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
												message2 += ", 1천원권 부족";
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
												message2 += ", 500원 동전 부족";
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
											System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
											change100 = coin100;
											coin -= change100*100;
											if (coin100 != 0) {
												message2 += ", 100원 동전 부족";
											}
											coin100 = 0;
										}else {
											coin = coin % 100;
											coin100 -=change100;
											coin = 0;
										}
									}
									System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
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
									System.out.println("동전이나 지폐가 아닙니다. 다시 넣으세요.");
								}
							}
							break;
						}
						System.out.println("**물**이 나왔습니다.");
						System.out.println();
						waterNum--;
						waterSel++;
						if (waterNum <= 0) {
							message2 += ", 물 매진";
						}
						break;
					case 4:
						System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
						totalIncome -= coin;
						if (coin / 50000 > 0) {
							change50000 = coin / 50000;
							if (change50000>=coin50000) {
								change50000 = coin50000;
								coin -= change50000*50000;
								if (coin50000 != 0) {
									message2 += ", 5만원권 부족";
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
									message2 += ", 1만원권 부족";
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
									message2 += ", 5천원권 부족";
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
									message2 += ", 1천원권 부족";
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
									message2 += ", 500원 동전 부족";
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
								System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
								change100 = coin100;
								coin -= change100*100;
								if (coin100 != 0) {
									message2 += ", 100원 동전 부족";
								}
								coin100 = 0;
							}else {
								coin = coin % 100;
								coin100 -=change100;
								coin = 0;
							}
						}
						System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
						change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
						break;
					default:
						System.out.println("잘못 입력하셨습니다. 1~4번 중 하나를 고르세요");
						break;
					}
				}

				beverage = 0;
//				모든 재고 소진시 거스름돈 모두 반환 유도
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("모든 재고가 소진되었습니다. 자판기를 이용하실 수 없습니다.");
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					totalIncome -= coin;
					if (coin / 50000 > 0) {
						change50000 = coin / 50000;
						if (change50000>=coin50000) {
							change50000 = coin50000;
							coin -= change50000*50000;
							if (coin50000 != 0) {
								message2 += ", 5만원권 부족";
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
								message2 += ", 1만원권 부족";
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
								message2 += ", 5천원권 부족";
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
								message2 += ", 1천원권 부족";
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
								message2 += ", 500원 동전 부족";
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
							System.out.println("잔돈이 부족하여 거스름돈을 드릴수 없습니다.");
							change100 = coin100;
							coin -= change100*100;
							if (coin100 != 0) {
								message2 += ", 100원 동전 부족";
							}
							coin100 = 0;
						}else {
							coin = coin % 100;
							coin100 -=change100;
							coin = 0;
						}
					}
					System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", change50000, change10000, change5000, change1000, change500, change100);
					change50000 = 0; change10000 = 0; change5000 = 0; change1000 = 0; change500 = 0; change100 = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}
}
