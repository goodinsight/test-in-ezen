package kr.co.dong;

import java.util.Scanner;

public class Report16_01 {

	public static void main(String[] args) {

		boolean power = false;

//				변수 선언
		int cokePrice = 500; // coke 가격
		int ciderPrice = 600; // cider가격
		int coffeePrice = 700; // coffee 가격
		int cokeNum = 10, ciderNum = 20, coffeeNum = 30; // 재고
		int reTurnCoin = 0; // 거스름돈
		int finish = 0; // 종료
		int coke = 0, cider = 0, coffee = 0;
		int insertCoin = 0; // 투입금액
		int selectMenu = 0; // 메뉴선택
		int menuNum = 0;
		int coke1 = 0, cider1 = 0, coffee1 = 0;

		coke1 = cokeNum; // 음료 재고
		cider1 = ciderNum;
		coffee1 = coffeeNum;

		coke = cokePrice; // 음료 가격
		cider = ciderPrice;
		coffee = coffeePrice;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println();
			System.out.println("=========Menu===========");
			System.out.println("1.coke = 500 2.cider = 600 3.coffee = 700");
			selectMenu = scan.nextInt();
			System.out.println("재고 확인");
			menuNum = scan.nextInt();
			switch (menuNum) {
			case 1:
				if (coke1 > 0) {
					coke1 = coke1 - 1;
					System.out.println("coke 남은 수량은" + coke1);
				}else {
					System.out.println("재고 부족");
				}
				break;
			case 2:
				if (cider1 > 0) {
					cider = cider1 -1;
					System.out.println("cider 남은 수량은" + cider1);
				}
				break;
			case 3:
				if (coffee > 0) {
					coffee -= 1;
					System.out.println("coffee 남은 수량은" + coffee1);
				}
				break;
			default:
				break;
			}
			System.out.println("투입금액");
			insertCoin = scan.nextInt();
			System.out.println("투입금액은 " + insertCoin + "입니다.");

			switch (selectMenu) {
			case 1:
				if (insertCoin >= coke) {
					reTurnCoin = insertCoin - coke;
					System.out.printf("coke 선택 거스름돈은 %d 입니다.", reTurnCoin);

				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 2:
				if (insertCoin >= cider) {
					reTurnCoin = insertCoin - cider;
					System.out.printf("cider 선택 거스름돈은 %d 입니다." + reTurnCoin);
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 3:
				if (insertCoin >= coffee) {
					reTurnCoin = insertCoin - coffee;
					System.out.printf("coffee 선택" + reTurnCoin);
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;

			default:
				break;
			}

			System.out.println("\n 계속 사용시 아무 버튼이나 누르세요");
			System.out.println(" \n 종료시 99를 누르세요");
			finish = scan.nextInt();
			if (finish == 99) {
				break;
			}
		}

	}

}
