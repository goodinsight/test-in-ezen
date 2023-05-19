package kr.co.dong;

import java.util.Scanner;

public class Report10 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2.음료 3종류 종류/ 가격 별도 /재고수
//		3.시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈입력 등
//		 	99. 자판기 종료
//		4.99이외의 숫자인 경우 화면메뉴 보여주기

		boolean power = false; // 전원
//		메뉴입력 , 받은 돈, 음료 이름1,2,3/가격1,2,3, 거스름돈
		Scanner scan = new Scanner(System.in);


		String water = "물";
		String coffee = "커피";
		String ade = "에이드";
		String menu;

		int waterprice = 1000;
		int coffeeprice = 800;
		int adeprice = 500;

		int waterinventory = 7;
		int adeinventory = 7;
		int coffeeinventory = 7;

		while (!power) {
			System.out.println("=========================메뉴===========================");
			System.out.println("물 의 가겨은: " + waterprice + "원 이고," + " 남은 수량은 " + waterinventory + "개 입니다.");
			System.out.println("커피의 가격은 : " + coffeeprice + "원 이고," + " 남은 수량은 " + coffeeinventory + "개 입니다.");
			System.out.println("에이드의 가격은 : " + adeprice + "원이고," + " 남은 수량은 " + adeinventory + "개 입니다.");
			System.out.print("받은 돈은 : ");
			int money = scan.nextInt();
			int change1 = money - waterprice;
			int change2 = money - coffeeprice;
			int change3 = money - adeprice;
			System.out.println("메뉴를 선택해 주세요");

			if (money >= waterprice) {
				System.out.println(water + "이 나왓습니다");
			} else if (money >= coffeeprice) {
				System.out.println(coffee + "가 나왓습니다");
			} else if (money >= adeprice) {
				System.out.println(ade + "가 나왓습니다");
			}
			if (waterprice <= money) {
				System.out.println("거스름돈은  : " + change1 + "원 입니다");
			} else if (coffeeprice <= money) {
				System.out.println("거스름돈은  : " + change2 + "원 입니다");
			} else if (adeprice <= money) {
				System.out.println("거스름돈은 :  " + change3 + "원 입니다");
			} else {
				System.out.println();
			}

			break;

		}
		System.out.println("자판기 종료!!");

	}

}
