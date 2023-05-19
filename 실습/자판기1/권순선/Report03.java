package kss.co.kr;

import java.util.Scanner;

public class Report03 {
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고 수
//		3. 시작과 동시에 화면에 메뉴를 보여준다
//		3-1. 음료의 재고와 가격, 재고 수, 거스름돈 반환, 돈입력
//			 99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기

		boolean power = false; // 전원
//		메뉴입력, 받은 돈, 음료이름1,2,3 , 가격1,2,3 , 잔돈
		int menu = 0;
		int money = 0;
		int coin = 0;

		String a = "사이다";
		String b = "커피";
		String c = "제로콜라";

		int moneya = 1000;
		int moneyb = 1500;
		int moneyc = 2000;

		Scanner sc = new Scanner(System.in);

		while (!power) {

			System.out.print("돈 >>>>> ");
			money += sc.nextInt();
			System.out.println(money);
			
			System.out.println("메뉴 선택");
			System.out.println("1) 사이다 3000원, 2) 커피 3500원, 3) 콜라 2000원, 5) 잔돈, 99) 종료");
			System.out.println("현재 입금액 " + money);
			
			System.out.print("메뉴 >>>>> ");
			menu = sc.nextInt();

			switch (menu) {
			
			case 1:
				System.out.println("사이다");
				break;

			case 2:
				System.out.println("커피");

				break;

			case 3:
				System.out.println("콜라");

				break;
				
			case 5:
				System.out.println("잔돈");
				
				break;

			case 99:
				power = true;
				System.out.println("잔돈 " + money);
				break;

			default:
				System.out.println("다시 입력");
				break;
			}

		}
		System.out.println("자판기 종료");

	}

}