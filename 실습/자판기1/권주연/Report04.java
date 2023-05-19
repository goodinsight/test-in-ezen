package kr.co.dong;

import java.util.Scanner;

public class Report04 {

	public static void main(String[] args) {
//		1. 음료 자판기 구현
//		2. 음료 3종류 종류 / 가격 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1.  음료의 종류와 가격,  재고수, 거스름돈 반환, 돈 입력 등~
//		      99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면 메뉴 보여주기
		
		boolean power = false; // 전원
//		메뉴입력, 받은 돈, 음료이름1,2,3, ,가격1,2,3 ,거스름 돈
		int sel =0; //메뉴 선택
		int money = 0;
		Scanner scan = new Scanner(System.in);
		
		String name1 = "사이다" ;
		String name2 = "콜라";
		String name3 = "제로";
		
		int sprit = 1000;
		int coke = 1000;
		int zero = 1200;  //메뉴 이름 & 가격
		
		
		while(!power) { 
//			0. 돈 입력
		    System.out.println("투입금액 : ");
		    money = money + scan.nextInt(); // 이렇게해야 입금된 금액이 누적 됨.scan.nextInt만 했을때 금액 누적 x
		    
//			1. 메뉴 보여주기
			
			System.out.println("============ [ Menu ] ============");
			System.out.println("1. 사이다(1000) 2. 콜라(1000) 3. 제로(1200)");
			System.out.println("5. 거스름돈 반환 99. 종료");
			System.out.println("현재 입금액 : " + money);
			
//			2. 메뉴선택
//			sane.next(); 하면 투입한 금액까지 나오는거 확인 가능
			System.out.println("select number : ");
			sel = scan.nextInt();
//			3. 선택에 대한 분기
			switch(sel) {
			case 1 : // 사이다 선택
					System.out.println("사이다");			
				break;
			case 2 : // 콜라 선택
				System.out.println("콜라");
				break;
			case 3 : // 제로 선택
				System.out.println("제로");
				break;
			case 5 : // 거스름 돈 반환
				if(sprit<=money) {
					System.out.println("거스름돈 : " + (sprit-money));
				} else if(coke<=money) {
					System.out.println("거스름돈 : " + (coke-money));
				} else if(zero<=money) {
					System.out.println("거스름돈 : " + (zero-money));
				}else {
					System.out.println("금액이 부족합니다");
				}
							
			case 99 : // 정지
				power = true;
				System.out.println("시스템 아웃");
				break;
				default :
					System.out.println("잘못된 선택입니다. 다시 선택하세요.");
				
			}
		}
		System.out.println("★자판기 종료★");
	}

}

