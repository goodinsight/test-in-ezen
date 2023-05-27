package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report05 {

	public static void main(String[] args) {
//		 자판기 만들기
		
		boolean power = false;     //전원
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;   // 메뉴선택
		int money = 0;
		int change = 0;
		
		String name1 = "환타";       //메뉴 이름
		String name2 = "사이다";
		String name3 = "제로콜라";
		
		int price1 = 1000;
		int price2 = 1200;
		int price3 = 1500;
		
		
		while(!power) {
//			0. 메뉴 보여주기
			System.out.println("==================[ Menu ]=======================");
			System.out.println("【   1. 환타(1000) 2. 사이다(1200) 3. 제로콜라(1500)   】");
			System.out.println("=================================================");
			System.out.println("=================================================");
			System.out.println("【       5. 거스름돈 반환        99. 종료             】");
			System.out.println("=================================================");
			
//			1. 돈입력
			System.out.print("▶투입 금액◀ : ");
			money = money + scan.nextInt();          //그냥 입력만 받고 money +를 안해주면 넣은 금액에 대한 누적이 안된다.
			
			System.out.println("▶현재 입금액◀ : " + money);
			
//			2. 메뉴선택
			System.out.print("메뉴를 선택해주세요. : ");
			menu = scan.nextInt();
			
//			3. 선택에 대한 분기
			switch (menu) {
			case 1:   // 환타 선택시
				System.out.println("> 환타!");
				System.out.println("> 잔돈 반환 하시겠습니까? (반환시 5번을 눌러주세요)");
				menu = scan.nextInt();
				break;
				
			case 2:   // 사이다 선택시
				System.out.println("> 사이다!");
				System.out.println("> 잔돈 반환 하시겠습니까? (반환시 5번을 눌러주세요)");
				menu = scan.nextInt();
				break;
				
			case 3:   // 제로콜라 선택시
				System.out.println("> 제로콜라!");
				System.out.println("> 잔돈 반환 하시겠습니까? (반환시 5번을 눌러주세요)");
				menu = scan.nextInt();
				break;
				
			case 5:   // 거스름돈 반환
				System.out.println("거스름돈 : ");
				switch (change) {
				case 1:
					
					break;

				default:
					break;
				}
				break;
			case 99:  // 종료
				power = true;
				System.out.println("시스템을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
			}
		}
}

