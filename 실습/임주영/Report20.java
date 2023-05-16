package kr.co.dong;

import java.util.Scanner;

public class Report20 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 메뉴를 보여준다.
//		3-1 	1. 음료의 종류 와 가격 , 재고수 , 거스름돈 반환, 돈입력 등
//				99. 자판기 종류
//				4. 99이외의 숫자인 경우 화면메누 보여주기

		boolean power = false; // 전원
//		메뉴입력, 돈, 음료이름1,2,3, 가격1,2,3, 거스름돈	
		int menu = 0; // (메뉴)
//		String d1 ="콜라";	
//		String d2 ="사이다";
//		String d3 ="제로";	// 제로음료
//		String msg =" ";
		int money = 0; // 돈
		int price = 0; // 가격
		int m1 = 300, m2 = 500, m3 = 200;
		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("=====================");
			System.out.println("    돈을 투입해주세요!   ");
			System.out.println("=====================");
			money = money + scan.nextInt();
			System.out.println("메뉴를 고르시오 ");
			System.out.println("1. 콜라(1000) 2. 스프라이트(1200) 3. 제로 사이다(1500) ");
			System.out.println("99 종료 ");
			System.out.println("현재 입금액 " + money);

			menu = scan.nextInt();

			switch (menu) {
			case 1:
				price = m1;
				System.out.println("콜라를 선택하셨습니다. ");
				if (money < price)
					System.out.println("돈이 부족합니다.");
				break;
				
			case 2:
				price = m2;
				System.out.println("스프라이트를 선택하셨습니다. ");
				if (money < price)
					System.out.println("돈이 부족합니다.");
				break;
				
			case 3:
				
				price = m3;
				System.out.println("제로 사이다를 선택하셨습니다. "); 
				if (money < price)
					System.out.println("돈이 부족합니다.");
				break;
				
			case 99:
				power = true;
				System.out.println("자판기 종료!!");
				break;
				
			default:
				System.out.println(" 해당 메뉴는 없습니다.");
				break;
			}

		}

	}

}
