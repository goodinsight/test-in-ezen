package kr.co.dong.Array;

import java.util.Scanner;

public class ArrayTest9_1 {

	public static void main(String[] args) {
		// 배열명 dName, dPrice, dAmount 음료의 종류는 3가지인 자판기만들기.
		
//		1. 선언
		boolean power = false;
		
		String [] dName = null;
		int [] dPrice = null;
		int [] dAmount = null;  // 재고의 갯수
		
		int money = 0;             // 받은 돈
		int sel = 0;               // 처음 메뉴고르기 
		int menu = 0;              // 음료메뉴 고르기
		int manage = 0;            // 관리자모드 고르기
		
//		2. 생성
		dName = new String [3];
		dPrice = new int [3];
		dAmount = new int [3];
			
		dName[0] = "콜라";
		dName[1] = "사이다";
		dName[2] = "환타";
		
		dPrice[0] = 500;
		dPrice[1] = 1000;
		dPrice[2] = 1500;
		
		dAmount[0] = 10;
		dAmount[1] = 10;
		dAmount[2] = 10;

		Scanner scan = new Scanner(System.in);
		
		while (!power) {
//			1. 돈 입력 받기
			System.out.println("          ☆ 원하는 메뉴의 버튼을 눌러주세요. ☆         ");
			System.out.println("=================[  MENU  ]=====================");
			System.out.println("                 1. 음료 구매                      ");
			System.out.println("================================================");
			System.out.println("55. 잔돈 반환   66. 재고 확인   77. 관리자모드   99. 종료 " );
			System.out.println("================================================");
			sel = scan.nextInt();
			
			switch (sel) {
			case 1:    // 음료 구매할 때
				System.out.println("음료를 골라주세요.");
				System.out.println("1.콜라구매(500원)  2.사이다구매(1000원)  3.환타구매(1500원)");
				menu = scan.nextInt();
				
				switch (menu) {
				case 1:
					System.out.print("▶ 돈을 넣어주세요. ");
					money = money + scan.nextInt();
					System.out.println("▷ 현재 투입 금액 : " +money);          // 남은 돈 표시

					System.out.println(dName[0]+"를 선택하였습니다.");
					System.out.println(dName[0]+"의 가격은 "+dPrice[0]+"원 입니다.");
					System.out.println("남은 금액은 : "+(money-dPrice[0])+"원 입니다");
					money = money - dPrice[0];
					stock1--;
					break;
				
				case 2:
					System.out.print("▶ 돈을 넣어주세요. ");
					money = money + scan.nextInt();
					System.out.println("▷ 현재 투입 금액 : " + money); 
					
					System.out.println(dName[1] + "를 선택하였습니다.");
					System.out.println(dName[1] + "의 가격은 " + dPrice[1] + "원 입니다.");
					System.out.println("남은 금액은 : " + (money - dPrice[1]) + "원 입니다");
					money = money - dPrice[1];
					stock2--;
					break;
	
				case 3:
					System.out.print("▶ 돈을 넣어주세요. ");
					money = money + scan.nextInt();
					System.out.println("▷ 현재 투입 금액 : " + money);
					
					System.out.println(dName[2]+"를 선택하였습니다.");
					System.out.println(dName[2]+"의 가격은 "+dPrice[2]+"원 입니다.");
					System.out.println("남은 금액은 : "+(money-dPrice[2])+"원 입니다");
					money = money - dPrice[2];
					stock3--;
					break;

				default:
					System.out.println("음료를 다시 골라주세요.");
					break;
				}
				break;
				
		    case 55:    // 잔돈 반환
		    	System.out.println("잔돈 : "+money+"를 반환합니다.");
		    	money = 0;
				break;
				
			case 66:    // 재고
				System.out.println("> 콜라의 재고는 현재" + dAmount[0] +" 개 입니다.");
				System.out.println("> 사이다의 재고는 현재" + dAmount[1] +" 개 입니다.");
				System.out.println("> 환타의 재고는 현재" + dAmount[2] +" 개 입니다.");
				break;
				
			case 77:    // 관리자
				System.out.println("●        관리자 모드입니다.        ●");
				System.out.println("●    원하는 메뉴의 버튼을 눌러주세요   ●");
				System.out.println();
				System.out.println("1. 재고 수정, 2. 제품 변경, 3. 가격 변경");
				manage = scan.nextInt();
				
				switch (manage) {
				case 1:
					System.out.println("어떤 제품의 재고를 수정하시겠습니까?");
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;

				default:
					break;
				}
				
				
				break;
				
			case 99:   // 종료
				power = true;
				System.out.println("시스템을 종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
	
		}
	}
}