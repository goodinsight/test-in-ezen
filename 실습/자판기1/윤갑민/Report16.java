package kr.co.dong;

import java.util.Scanner;

public class Report16 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 / 가격 별도/ 재고수
//		3.  시작과 동시에 화면에 메뉴를 보여준다.
//		3-1. 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈 입력 등
//			99. 자판기 종료
//		4. 99 이외의 숫자인 경우 화면 메뉴 보여주기

		boolean power = false; // 전원
//		메뉴 입력, 돈, 음료이름 1,2,3 / 가격 1,2,3 거스름돈
		Scanner scan = new Scanner(System.in);

		int coke = 700, cider = 600, coffee = 500;
		int button1 = 0, button2 = 0, button3 = 0;
		int totalCoin = 0;
		int menu = 0;
		int coke1 = 0, cider1 = 0, coffee1 = 0;

		System.out.println("Menu : 1.Coke - 700 2.Cider - 600 3. Coffee - 500");
		System.out.println("코인을 투입하세요");
		totalCoin = totalCoin + scan.nextInt();
		System.out.println("투입된 코인은 " + totalCoin);
		while (!power) {
			System.out.println("메뉴 번호를 선택하세요");
			menu = scan.nextInt();
			if (menu == 1) {
				button1 = totalCoin - coke;
				System.out.printf("coke 선택, 거스름돈은 %d ", button1);
				if (button1 < coke) {
					System.out.println("금액이 부족합니다.");
				}
			}

			if (menu == 2) {
				button2 = totalCoin - cider;
				System.out.printf("cider 선택, 거스름돈은 %d " , button2);
				if (button2 < cider) {
					System.out.println("금액이 부족합니다.");
				}
			}
			if (menu == 3) {
				button3 = totalCoin - coffee;
				System.out.printf("coffee 선택 %d ", button3);
				if (button3 < coffee) {
					button3 = 0;
					System.out.println("금액이 부족합니다.");

				}
				System.out.println("자판기 종료!!");
			}
		}
	}
}
