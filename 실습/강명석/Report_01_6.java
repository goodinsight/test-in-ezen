package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_6 {
	public static void main(String[] args) {

		boolean power = false; // 자판기 스위치

		String drink1 = "콜라"; // 제품 이름
		String drink2 = "사이다";
		String drink3 = "환타";

		int value1 = 100; // 제품 가격
		int value2 = 200;
		int value3 = 300;

		int inCoin = 0; // 입력가격 넣는 돈
		int inputMenu = 0; // 메뉴 입력
		int count = 0; // 처음에만 최소가격 알림 나중에 미공개

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.printf(" ------------------- Menu ------------------ \n");
			System.out.printf(" 1. 동전넣기\t80. 환불(잔액찾기)    99. 종료\n");
			System.out.printf("11. %s(%d원) 12. %s(%d원)  13. %s(%d원)\n", drink1, value1, drink2, value2, drink3, value3);
			
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
				if (inCoin >= value1) {
					System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink1);
					inCoin = inCoin - value1;
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				} else {
					System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
					break;
				}
				break;

			case 12: // 제품2
				if (inCoin >= value2) {
					System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink2);
					inCoin = inCoin - value2;
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				} else {
					System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
					break;
				}
				break;

			case 13: // 제품3
				if (inCoin >= value3) {
					System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", drink3);
					inCoin = inCoin - value3;
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				} else {
					System.out.println("잔액이 부족합니다. ==> 1. 동전넣기를 눌러주세요");
					break;
				}
				break;

			case 80: // 환불
				if (inCoin > 0) {
//					거스름돈 챙기기 -> 5천원1장 천원?장 오백원개 
					
					System.out.printf("잔액 %d을 챙겨가세요. 감사합니다. \n ", inCoin);
					inCoin = 0;
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
					inCoin = 0;
				} else {
					System.out.println("돌려드릴 잔액이 없습니다. 감사합니다. \n ");
					System.out.printf("잔액은 %d 입니다. \n추가입금(1), 잔액찾기(80), 종료(99)을 눌러주세요 \n\n", inCoin);
				}
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
