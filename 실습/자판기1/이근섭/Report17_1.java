package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17_1 {
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

		String cola = "콜라";
		String coffee = "커피";
		String water = "물";
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
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <음료 자판기>                      ");
				System.out.println();
				System.out.printf("                                   현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3 %s : %d원(수량:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                              잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 " + message1 + message2 + "%n");
				System.out.println("-------------------------------------------------------");
//				input coin
				System.out.println("얼마를 넣으시겠습니까? :");
				int tmp = scan.nextInt();
//				return of change
				if (tmp == 4) {
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					totalIncome -= coin;
					coin = 0;
					tmp = 0;
				} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000 || tmp == 5000
						|| tmp == 10000 || tmp == 50000) {
					coin += tmp;
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
							
							System.out.println("=======================================================");
							System.out.println();
							System.out.println("                       <관리자 모드>                      ");
							System.out.println();
							System.out.printf("                               현재까지 총 수입은 :  %d원%n", totalIncome);
							System.out.println();
							System.out.println("                       <음료별 판매현황>                      ");
							System.out.printf("  1. %s : %d개     2. %s : %d개    3 %s : %d개%n", cola, colaSel, coffee,
									coffeeSel, water, waterSel);
							System.out.println();
							System.out.println("                       <음료별 판매수익>                    ");
							System.out.printf("  1. %s : %d원     2. %s : %d원    3 %s : %d원%n", cola, colaSel * colaPrice,
									coffee, coffeeSel * coffeePrice, water, waterSel * waterPrice);
							System.out.println();
							System.out.println("                       <음료별 남은 재고>                    ");
							System.out.printf("  1. %s : %d개     2. %s : %d개    3 %s : %d개%n", cola, colaNum, coffee,
									coffeeNum, water, waterNum);
							System.out.println();
							System.out.printf("안내 : " + message2 + "%n");
							System.out.println("-------------------------------------------------------");
							System.out.println("어떤 음료를 추가하시겠습니까? (관리자 모드 종료:4, 자판기 전원off:5)");
							System.out.printf("1. %s      2. %s      3. %s%n", cola, coffee, water);

							beverage = scan.nextInt();
							switch (beverage) {
							case 1:
								System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", cola);
								colaNum += scan.nextInt();
								System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", cola, colaNum);
								beverage = 0;
//								message , 매진 안내 지우기
								message2 = message2.replace(" 콜라 매진","");
								break;
							case 2:
								System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", coffee);
								coffeeNum += scan.nextInt();
								System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", coffee, coffeeNum);
								beverage = 0;
//								message , 매진 안내 지우기
								message2 = message2.replace(" 커피 매진","");
								break;
							case 3:
								System.out.printf("%s 를 몇개 추가하시겠습니까? : %n", water);
								waterNum += scan.nextInt();
								System.out.printf("%s 가 추가되어 재고가 %d가 되었습니다.%n", water, waterNum);
								beverage = 0;
//								message , 매진 안내 지우기
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
							}// switch end
						}// while end
					}
				}
			} else {
//		메뉴화면 choice
				message1 = "음료를 고르세요";
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <음료 자판기>                      ");
				System.out.println();
				System.out.printf("                                   현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원(수량:%d)     2. %s : %d원(수량:%d)    3 %s : %d원(수량:%d)%n", cola, colaPrice,
						colaNum, coffee, coffeePrice, coffeeNum, water, waterPrice, waterNum);
				System.out.println();
				System.out.println("                              잔액 반환을 원하시면 4번을 누르세요");
				System.out.println();
				System.out.printf("안내 : " + message1 + message2 + "%n");
				System.out.println("-------------------------------------------------------");

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
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
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
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
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
									coin = 0;
									break;
								} else if (tmp == 10 || tmp == 50 || tmp == 100 || tmp == 500 || tmp == 1000
										|| tmp == 5000 || tmp == 10000 || tmp == 50000) {
									coin += tmp;
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
						coin = 0;
						break;
					default:

					}
				}

				beverage = 0;
//				모든 재고 소진시 거스름돈 모두 반환 유도
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("모든 재고가 소진되었습니다. 자판기를 이용하실 수 없습니다.");
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					totalIncome -= coin;
					coin = 0;
					adminMode = 0;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}
}
