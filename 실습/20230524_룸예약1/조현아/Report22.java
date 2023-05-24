package JaPanGi;

import java.util.Scanner;

public class Report22 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다
//		3-1. 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈 입력 등
//			99. 자판기 종료
//		4. 99 이외의 숫자인 경우 화면메뉴 보여주기
		
		boolean power = false; // 전원
//		메뉴입력값, 받은 돈, 음료이름123, 가격123 , 거스름돈
		
		int menu = 0; // 메뉴 입력값
		int money = 0; // 받은 돈
		int total_input = 0; // 받은 돈 합계
		int sel = 0; // 메뉴 선택
		String name1 = "콜라";
		String name2 = "사이다";
		String name3 = "오렌지쥬스";
		int price1 = 500;
		int price2 = 1200;
		int price3 = 2500;
		
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			// 0. 돈 입력
			System.out.print("투입 금액 : ");
			money = money + scan.nextInt(); // money 누적 시키기
			
//			 1. 메뉴 보여주기
			 System.out.println("====== [ menu ] ========");
			 System.out.println("1. 콜라(500원) 2. 사이다(1200원) 3. 오렌지쥬스(2500원)");
			 System.out.println("5. 거스름돈 반환 99. 종료");
			 System.out.println("현재 입금액 : "+money);
			 
//			 2. 메뉴 선택
			 System.out.print("Select : ");
			 sel = scan.nextInt();
//			3. 선택에 대한 분기
			 switch (sel) {
				case 1: // 콜라 선택시
					System.out.println("콜라 나옴");
					break;
				case 2: // 사이다 선택시
					System.out.println("사이다 나옴");
					break;
				case 3: // 오렌지쥬스 선택시
					System.out.println("오렌지쥬스 나옴");
					break;
				case 5: // 거스름돈 반환
					System.out.println("거스름돈 반환함");
					break;
				case 99:
					power = true;
					System.out.println("시스템 아웃!");
					break;
	
				default:
					break;
				}
			 
			 
			 
			 
		}
		
		System.out.println("자판기 종료!!");

	}

}
