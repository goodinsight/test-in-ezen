package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_7 {
	public static void main(String[] args) {

		boolean power = false; // 자판기 스위치

		String drink1 = "콜라"; // 제품 이름
		String drink2 = "사이다";
		String drink3 = "환타";

		int value1 = 100; // 제품 가격
		int value2 = 200;
		int value3 = 300;
		
		int count1 = 2;  // 제품 수량
		int count2 = 2;
		int count3 = 2;
		
		int money1 = 100; // 100원 동전
		int money2 = 500; // 500원 동전
		int money3 = 1000; // 1000원 지폐
		
		int sumMoney1 = 1000; // 100원 잔량
		int sumMoney2 = 1000; // 500원 잔량
		int sumMoney3 = 1000; // 1000원 잔량	
		int totalMoney = 0;    // 자판기 총액

		int inCoin = 0; // 입력가격 넣는 돈
		int jandon = 0; // 환불전 잔돈확인
		int inputMenu = 0; // 메뉴 입력
		int count = 0; // 처음에만 최소가격 알림 나중에 미공개

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf(" ----------------------------- Menu ---------------------------- \n");
			System.out.printf(" 1. 동전넣기\n");
			// 재고에 따른 메뉴변경
			System.out.printf("11. %s(%d원)(잔량%d) 12. %s(%d원)(잔량%d)  13. %s(%d원)(잔량%d)\n", drink1, value1, count1, drink2, value2, count2, drink3, value3, count3);
			System.out.println();
			System.out.println("80. 환불(잔액찾기)            99. 종료                 90. 관리자 모드");
			System.out.printf(" --------------------------------------------------------------- \n");
			
			System.out.print("Select : ");
			inputMenu = scan.nextInt();
			
			switch (inputMenu) {
			case 1: // 동전넣기
				count++;
				if (count == 1)
					System.out.printf("최소 구입금액은 100원 입니다. \n");
				else
					System.out.printf(" \n");

				while (true) {
					System.out.printf("동전을 넣어 주세요.> \n");
					inCoin = inCoin + scan.nextInt();
					
					if(inCoin<500) { // 돈 금액별 저장
						sumMoney1 = sumMoney1 + inCoin;						
					}
					else if(inCoin >=500 && inCoin <1000) {
						sumMoney2 = sumMoney2 + inCoin;
					}
					else if(inCoin >=1000) {
						sumMoney3 = sumMoney3 + inCoin;
					}
					// 동전 구분 입력 종료 if, else if	
					
					
					if (inCoin >= 100) {
						System.out.printf("현재 잔액은 %d 입니다. \n", inCoin);
						System.out.println("보유하신 잔액으로 구입가능한 아래 메뉴를 선택해 주세요.>");
						System.out.println("환불은 구매>80  취소는 >  99을 눌러주세요");
						break;
					} // end of if 최소금액
					else {
						System.out.printf("동전이 부족합니다. 더 넣어 주세요 현재잔액 = %d \n", inCoin);
					} // end of else
				}
				break;

			case 11: // 제품1
				if(count1>0) { // 제품1 구매시 재고가 없으면 재고 없음 알리고, 잔액 및 메뉴 알림
					if (inCoin >= value1) {
						System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink1);
						inCoin = inCoin - value1;
						count1 = count1 - 1;
						System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
					} else {
						System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
						break;
					}
				} // end of if 재고가 있을때 case11
				else {
					System.out.println("재고가 없습니다. 다른 메뉴 선택해 주세요. \n");
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				} // end of else 재고가 없을 때 case11
				break;

			case 12: // 제품2
				if(count2>0) { // 제품2 구매시 재고가 없으면 재고 없음 알리고, 잔액 및 메뉴 알림
					if (inCoin >= value2) {
						System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink2);
						inCoin = inCoin - value2;
						count2 = count2 - 1;
						System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
					} else {
						System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
						break;
					}
				} // end of if 재고가 있을때 case12
				else {
					System.out.println("재고가 없습니다. 다른 메뉴 선택해 주세요. \n");
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);					
				} // end of else 재고가 없을 때 case12
				break;

			case 13: // 제품3
				if(count3>0) { // 제품3 구매시 재고가 없으면 재고 없음 알리고, 잔액 및 메뉴 알림
					if (inCoin >= value3) {
						System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink3);
						inCoin = inCoin - value3;
						count3 = count3 - 1;
						System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
					} else {
						System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
						break;
					}
				} // end of if 재고가 있을때 case13
				else {
					System.out.println("재고가 없습니다. 다른 메뉴 선택해 주세요. \n");
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);									
				} // end of else 재고가 없을 때 case13
				break;

			case 80: // 환불
				if (inCoin > 0) {
//					거스름돈 챙기기 -> 1천원1장 500원 100원 
					System.out.printf("\n 잔액 %d을 챙겨가세요. 감사합니다. \n ", inCoin);
					jandon = (inCoin%10000/1000);					
					System.out.printf("천원 %d 장이 나옵니다.\n", jandon);
						sumMoney3 = sumMoney3 - 1000*jandon;
					jandon = (inCoin%1000/500);					
					System.out.printf("오백원 %d 개가 나옵니다.", jandon);
						sumMoney2 = sumMoney2 - 500*jandon;
					jandon = (inCoin-500)%1000/100;
					System.out.printf(" 백원 %d 개가 나옵니다.\n", jandon);	
						sumMoney1 = sumMoney1 - 100*jandon;
					
					inCoin = 0;
					System.out.printf("\n잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				} else {
					System.out.println("돌려드릴 잔액이 없습니다. 감사합니다. \n ");
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
					inCoin = 0;
				}
				break;
				
			case 90: // 관리자 모드 제품 잔량 확인 및 거스름돈 잔량 확인
				System.out.println("------------재고 확인----------- \n");
				System.out.printf("제품 잔량은 %s = %d개, %s = %d, %s = %d개 입니다. \n", drink1, count1, drink2, count2, drink3, count3);
				System.out.println("------------거스름돈 확인--------- \n");
				totalMoney = sumMoney1 + sumMoney2 + sumMoney3;
				System.out.printf("자판기 전체 금액 : %5d \n", totalMoney);
				System.out.printf("1000원 거스름돈 : %5d, %d장 남았습니다. \n", sumMoney3, sumMoney3/1000 );
				System.out.printf(" 500원 거스름돈 : %5d, %d개 남았습니다. \n", sumMoney2, sumMoney2/500 );
				System.out.printf(" 100원 거스름돈 : %5d, %d개 남았습니다. \n", sumMoney1, sumMoney1/100 );

				break;				
			case 99: // 구매자 종료
				power = true;
				break;
			default:
				System.out.println(" 작동에 문제가 발생하였습니다. 다시 시작 부탁드립니다.");
				break;
			} // end of case

		} // end of while
		System.out.println("자판기 판매 종료. 다음에 또오세요~~~~");
	} // end of main
} // end of class
