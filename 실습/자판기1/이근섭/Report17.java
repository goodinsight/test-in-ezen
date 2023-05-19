package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report17 {
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

		int colaNum = 3;
		int coffeeNum = 3;
		int waterNum = 3;

		int coin = 0;
		int beverage = 0;
		
//		boolean possible = waterNum!=0 && coin<waterPrice || waterNum==0 && colaNum!=0 && coin<colaPrice || colaNum==0 && waterNum==0 && coffeeNum!=0 && coin<coffeePrice;
		
		sys:
		while (!power) {
			if (waterNum!=0 && coin<waterPrice || waterNum==0 && colaNum!=0 && coin<colaPrice || colaNum==0 && waterNum==0 && coffeeNum!=0 && coin<coffeePrice) {
				message1 = "coin을 (더)넣어주세요";
//		메뉴화면 coin
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <음료 자판기>                      ");
				System.out.println(); 
				System.out.printf("                                   현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d원     2. %s : %d원    3 %s : %d원%n", cola, colaPrice, coffee, coffeePrice,
						water, waterPrice);
				System.out.println();
				System.out.println("                              잔액 반환을 원하시면 4번을 누르세요");
				System.out.println(); 
				System.out.printf("안내 " + message1 + message2 +"%n");
				System.out.println("-------------------------------------------------------");
//				input coin
				System.out.println("얼마를 넣으시겠습니까? : (poweroff: 99)");
				int tmp = scan.nextInt();
				if (tmp == 99) {
					if (coin != 0) {
						System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
						coin = 0;
						tmp = 0;
					}
					break sys;
//				거스름돈 반환
				}else if (tmp == 4) {
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					coin = 0;
					tmp = 0;
				}
				coin += tmp;
			}else {
//		메뉴화면 choice
				message1 = "음료를 고르세요";
				System.out.println("=======================================================");
				System.out.println();
				System.out.println("                       <음료 자판기>                      ");
				System.out.println(); 
				System.out.printf("                                   현재 잔액은 :  %d원", coin);
				System.out.println();
				System.out.println();
				System.out.printf("  1. %s : %d     2. %s : %d    3 %s : %d%n", cola, colaPrice, coffee, coffeePrice,
						water, waterPrice);
				System.out.println();
				System.out.println("                              잔액 반환을 원하시면 4번을 누르세요");
				System.out.println(); 
				System.out.printf("안내 : " + message1 + message2+"%n");
				System.out.println("-------------------------------------------------------");

				if (beverage != 1 && beverage != 2 && beverage != 3) {
					System.out.println("무엇을 고르시겠습니까(1~3)? : ");
					beverage = scan.nextInt();
					
					switch (beverage) {
					case 1:
						if(colaNum <= 0) {
							System.out.println("콜라 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= colaPrice;
						if (coin < 0) {
							coin += colaPrice;
							System.out.println("잔액이 모자랍니다.");
							break;
						}
						System.out.println("**콜라**가 나왔습니다.");
						System.out.println();
						colaNum--;
						if(colaNum <= 0) {
							message2 += ", 콜라 매진";
						}
						break;
					case 2:
						if(coffeeNum <= 0) {
							System.out.println("커피 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= coffeePrice;
						if (coin < 0) {
							coin += coffeePrice;
							System.out.println("잔액이 모자랍니다.");
							break;
						}
						System.out.println("**커피**가 나왔습니다.");
						System.out.println();
						coffeeNum--;
						if(coffeeNum <= 0) {
							message2 += ", 커피 매진";
						}
						break;
					case 3:
						if(waterNum <= 0) {
							System.out.println("물 매진입니다. 다른메뉴를 선택하세요.");
							break;
						}
						coin -= waterPrice;
						if (coin < 0) {
							coin += waterPrice;
							System.out.println("잔액이 모자랍니다.");
							break;
						}
						System.out.println("**물**이 나왔습니다.");
						System.out.println();
						waterNum--;
						if(waterNum <= 0) {
							message2 += ", 물 매진";
						}
						break;
					case 4:
						System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
						coin = 0;
						break;
					default:

					}
				}
				
				beverage = 0;
				
				if (colaNum == 0 && coffeeNum == 0 && waterNum == 0) {
					System.out.println("모든 재고가 소진되었습니다. 자판기를 이용하실 수 없습니다.");
					System.out.printf("잔액(거스름돈) %d원을 반환합니다.%n", coin);
					coin = 0;
					power = true;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}
}
