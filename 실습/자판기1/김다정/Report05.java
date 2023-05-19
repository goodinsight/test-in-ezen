package kr.co.dong.Report;

import java.util.Scanner;

public class Report05 {

	public static void main(String[] args) {
//		자판기 
//		1. 음료자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1. 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈입력 등
//		   99. 자판기 종류
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기.
		
		boolean power = false;     // 전원
//		메뉴입력값, 받은 돈, 음료이름 1,2,3, 가격 1,2,3, 거스름돈
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int money = 0;
		int change = 0;
		int price1 = 1000, price2 = 2000, price3 = 3000;
		
		
//		price[1번] = 이름 선언 : "콜라"
//		price[2번] = 이름 선언 : "사이다"	
//		price[3번] = 이름 선언 : "환타"
		
		while(!power) {
			System.out.println("상품을 선택해주세요.");
			System.out.println("1. 콜라 (1000원), 2. 사이다(2000원), 3. 환타(3000원)");
			menu = scan.nextInt();
			
			System.out.println("돈을 넣어주세요.");
			money = scan.nextInt();
			
			if (menu == 1) {
				if (money >= price1) {
					System.out.println("콜라가 나옵니다.");
					if (money > price1) {
						System.out.println("잔돈을 반환합니다. ");
						System.out.println("잔돈은 "+(money-price1)+"입니다");
				}else {
					System.out.println("돈을 더 넣으세요.");
				}break;
			}
			}
			
			else if (menu == 2) {
				if (money >= price2) {
					System.out.println("사이다가 나옵니다.");
					if (money > price2) {
						System.out.println("잔돈을 반환합니다. ");
						System.out.println("잔돈은 "+(money-price2)+"입니다");
				}else {
					System.out.println("돈을 더 넣으세요.");
				}break;
			}
			}
			
			else if (menu == 3){
				if (money >= price3) {
					System.out.println("환타가 나옵니다.");
					if (money > price3) {
						System.out.println("잔돈을 반환합니다. ");
						System.out.println("잔돈은 "+(money-price3)+"입니다");
				}else {
					System.out.println("돈을 더 넣으세요.");
				}break;
			}
			}
			
			else if (menu == 99) {
				System.out.println("자판기 종료!!");
				break;
			}
		}
		
	}
}
	
		
			


