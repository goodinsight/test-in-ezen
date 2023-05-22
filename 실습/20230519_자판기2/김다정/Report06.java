package kr.co.dong.CheckPoint;

import java.util.Scanner;

public class Report06 {

	public static void main(String[] args) {
		// 배열명 dName, dPrice, dAmount 음료의 종류는 3가지인 자판기만들기.
		
//		1. 선언
		boolean power = false;
		
		String [] dName = null;
		int [] dPrice = null;
		int [] dAmount = null;     // 재고의 갯수
		
		int money = 0;             // 받은 돈
		int sel = 0;               // 처음 메뉴고르기 
		int menu = 0;              // 음료메뉴 고르기
		int manage = 0;            // 관리자모드 고르기
		
		int stock = 0;             // 재고 수정하기
		int cokestock = 0;         // 1번자리 재고변경
		int ciderstock = 0;        // 2번자리 재고변경
		int fantastock = 0;        // 3번자리 재고변경
		
		int price = 0;                // 상품 가격변경하기
		int cokeprice = 0;            // 1번자리 가격변경
		int ciderprice = 0;           // 2번자리 가격변경
		int fantaprice = 0;           // 3번자리 가격변경
		
		int change = 0;               // 음료 변경
		String cokechange = " ";      // 1번자리 음료 변경
		String ciderchange = " ";     // 2번자리 음료 변경
		String fantachange = " ";     // 3번자리 음료 변경

				
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
			System.out.println("55. 잔돈 반환          66. 재고 확인         99. 종료 " );
			System.out.println("================================================");
			sel = scan.nextInt();
			
			switch (sel) {
			case 1:    // 음료 구매할 때
				System.out.println("음료를 골라주세요.");
				System.out.println("1."+dName[0]+"구매("+dPrice[0]+"원)  2."+dName[1]+"구매("+dPrice[1]+"원)  3."+dName[2]+"구매("+dPrice[2]+"원)");
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
					dAmount[0]--;
					break;
				
				case 2:
					System.out.print("▶ 돈을 넣어주세요. ");
					money = money + scan.nextInt();
					System.out.println("▷ 현재 투입 금액 : " + money); 
					
					System.out.println(dName[1] + "를 선택하였습니다.");
					System.out.println(dName[1] + "의 가격은 " + dPrice[1] + "원 입니다.");
					System.out.println("남은 금액은 : " + (money - dPrice[1]) + "원 입니다");
					money = money - dPrice[1];
					dAmount[1]--;
					break;
	
				case 3:
					System.out.print("▶ 돈을 넣어주세요. ");
					money = money + scan.nextInt();
					System.out.println("▷ 현재 투입 금액 : " + money);
					
					System.out.println(dName[2]+"를 선택하였습니다.");
					System.out.println(dName[2]+"의 가격은 "+dPrice[2]+"원 입니다.");
					System.out.println("남은 금액은 : "+(money-dPrice[2])+"원 입니다");
					money = money - dPrice[2];
					dAmount[2]--;
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
				System.out.println("> "+dName[0]+"의 재고는 현재" + dAmount[0] +" 개 입니다.");
				System.out.println("> "+dName[1]+"의 재고는 현재" + dAmount[1] +" 개 입니다.");
				System.out.println("> "+dName[2]+"의 재고는 현재" + dAmount[2] +" 개 입니다.");
				break;
				
			case 77:    // 관리자
				System.out.println("●        관리자 모드입니다.        ●");
				System.out.println("●    원하는 메뉴의 버튼을 눌러주세요   ●");
				System.out.println();
				System.out.println("1. 재고 수량 수정  2. 제품 가격 변경  3. 제품 이름 변경");
				manage = scan.nextInt();
				
				switch (manage) {
				case 1:
					System.out.println("어떤 제품의 재고수량을 수정하시겠습니까?");
					System.out.println("1. "+dName[0]+" 2. "+dName[1]+" 3. "+dName[2]);
					stock = scan.nextInt();
					if (stock ==1) {
						System.out.println(dName[0]+"의 재고수량을 변경합니다.");
						System.out.println("재고의 수량을 입력해주세요.");
						cokestock = scan.nextInt();
						dAmount[0] = cokestock;
						System.out.println("현재 "+dName[0]+"의 재고수량은 : "+cokestock+"개 입니다.");
					}
					else if (stock ==2) {
						System.out.println(dName[1]+"의 재고수량을 변경합니다.");
						System.out.println("재고의 수량을 입력해주세요.");
						ciderstock = scan.nextInt();
						dAmount[1] = ciderstock;
						System.out.println("현재 "+dName[1]+"의 재고수량은 : "+ciderstock+"개 입니다.");
					}
					else if (stock ==3) {
						System.out.println(dName[2]+"의 재고수량을 변경합니다.");
						System.out.println("재고의 수량을 입력해주세요.");
						fantastock = scan.nextInt();
						dAmount[2] = fantastock;
						System.out.println("현재 "+dName[2]+"의 재고수량은 : "+fantastock+"개 입니다.");
					}
					break;
				case 2:
					System.out.println("어떤 제품의 가격을 변경하겠습니까?");
					System.out.println("1."+dName[0]+  " 2." +dName[1]+ " 3."+dName[2]);
					price = scan.nextInt();
					if (price ==1) {
						System.out.println(dName[0]+"의 가격을 변경합니다.");
						System.out.println("변경 할 가격을 입력해주세요.");
						cokeprice = scan.nextInt();
						System.out.println("현재 "+dName[0]+"의 가격은 : "+cokeprice+"원 입니다");
						dPrice[0] = cokeprice;
					}
					else if (price ==2) {
						System.out.println(dName[1]+"의 가격을 변경합니다.");
						System.out.println("변경 할 가격을 입력해주세요.");
						ciderprice = scan.nextInt();
						System.out.println("현재 "+dName[1]+"의 가격은 : "+ciderprice+"원 입니다");
						dPrice[1] = ciderprice;
					}
					else if (price ==3) {
						System.out.println(dName[2]+"의 가격을 변경합니다.");
						System.out.println("변경 할 가격을 입력해주세요.");
						fantaprice = scan.nextInt();
						System.out.println("현재 "+dName[2]+"의 가격은 : "+fantaprice+"원 입니다");
						dPrice[2] = fantaprice;
					}
					break;
				case 3:
					System.out.println("어떤 제품을 변경하겠습니까?");
					System.out.println("1."+dName[0]+  " 2." +dName[1]+ " 3."+dName[2]);
					change = scan.nextInt();
					if (change ==1) {
						System.out.println(dName[0]+"의 상품이름을 변경합니다.");
						System.out.println("변경 할 상품이름을 입력해주세요.");
						cokechange = scan.next();
						System.out.println(dName[0]+"가 "+cokechange+"로 변경되었습니다.");
						dName[0] = cokechange;
						dAmount[0] = 0;
						System.out.println("재고 수량확인으로 가서 재고를 넣어주세요. ");
					}
					else if (change ==2) {
						System.out.println(dName[1]+"의 상품이름을 변경합니다.");
						System.out.println("변경 할 상품이름을 입력해주세요.");
						ciderchange = scan.next();
						System.out.println(dName[1]+"가 "+ciderchange+"로 변경되었습니다.");
						dName[1] = ciderchange;
						dAmount[1] = 0;
						System.out.println("재고 수량확인으로 가서 재고를 넣어주세요. ");
					}
					if (change ==3) {
						System.out.println(dName[2]+"의 상품이름을 변경합니다.");
						System.out.println("변경 할 상품이름을 입력해주세요.");
						fantachange = scan.next();
						System.out.println(dName[2]+"가 "+fantachange+"로 변경되었습니다.");
						dName[2] = fantachange;
						dAmount[2] = 0;
						System.out.println("재고 수량확인으로 가서 재고를 넣어주세요. ");
					}
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