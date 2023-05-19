package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13_2 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격 , 재고수, 거스름돈 반환, 돈입력 등
//			99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
		boolean power = false; // 전원
//		메뉴입력값, 받은 돈, 음료이름1,2,3 가격1,2,3 , 거스름 돈
		Scanner scan = new Scanner(System.in);
		String drink1 = "아메리카노"; // 음료이름 1
		String drink2 = "밀크커피"; // 음료이름 2
		String drink3 = "믹스커피"; // 음료이름 3
		String slot = " ";	//바꿀 음료 이름
		int price1 = 700, price2 = 600, price3 = 500; // 음료 가격
		int cprice = 0;		//음료 가격 변경 금액
		int change = 100000; // 거스름돈
		int money = 0; // 돈
		int choice = 0; // 메뉴입력값
		int plus = 0; // 재고수 채우기
		int plusM= 0;	//돈 채우기
		int remain1 = 1, remain2 = 1, remain3 = 1; // 재고수
		while (!power) {
//			1. 메뉴
			System.out.println("[메뉴]");
			System.out.printf("1.돈 입금 2.%s %d원 3.%s %d원 4.%s 2%d원",drink1,price1,drink2,price2,drink3,price3);
			System.out.println("\n5.거스름돈 99.자판기 종료");
			System.out.print("선택하기 : ");
			choice = scan.nextInt();
//			2.버튼
			switch (choice) {
			case 1:
				System.out.println("돈줘");
				money = money + scan.nextInt();
				System.out.println("잔액 : " + money + "원");
				break;
			case 2:
				System.out.println("재고수 : " + remain1);
				if (remain1 == 0) {
					System.out.println("물건이 없어 ㅠㅠ");
				}
				if (money < price1) {
					System.out.println("돈 부족 " + (price1 - money) + "원");
					System.out.println("돈 더줘");
				}
				if (money >= price1 && remain1 > 0) {
					System.out.println("아메리카노");
					money = money - price1;
					remain1 = remain1 - 1;
					System.out.println("재고수 : " + remain1);
				}
				break;
			case 3:
				System.out.println("재고수 : " + remain2);
				if (remain2 == 0) {
					System.out.println("물건이 없어ㅠㅠ");
				}
				if (money < price2) {
					System.out.println("돈 부족 " + (price2 - money) + "원");
					System.out.println("돈 더줘");
				}
				if (money >= price2 && remain2 > 0) {
					System.out.println("밀크커피");
					money = money - price2;
					remain2--;
					System.out.println("재고수 : " + remain2);
				}
				break;
			case 4:
				System.out.println("재고수 : " + remain3);
				if (remain3 == 0) {
					System.out.println("물건이 없어ㅠㅠ");
				}
				if (money < price3) {
					System.out.println("돈 부족 " + (price3 - money) + "원");
					System.out.println("돈 더줘");
				}
				if (money >= price3 && remain3 > 0) {
					System.out.println("믹스커피");
					money = money - price3;
					remain3--;
					System.out.println("재고수 : " + remain3);
				}
				break;
			case 5:
				System.out.println(money + "원");
				if(change >= money) {					
				change = change - money;
				money = 0;
				}
				if(change < money) {
					System.out.println("잔돈이 부족해서 냠냠했어요. 관리자한테 전화해주세요");
				}
				break;
			case 77:
				System.out.println("관리자 모드");
				System.out.println("번호 선택");
				System.out.println("1.재고 채우기 2.거스름돈 채우기 3.음료 가격변경 4.메뉴 변경");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.printf("채울 물건선택 : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("채울 개수 : ");
					plus = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("현재 재고수 : " + remain1);
						remain1 = remain1 + plus;
						System.out.println("현재 재고수 : " + remain1);
						break;
					case 2:
						System.out.println("현재 재고수 : " + remain2);
						remain2 = remain2 + plus;
						System.out.println("현재 재고수 : " + remain2);
						break;
					case 3:
						System.out.println("현재 재고수 : " + remain3);
						remain3 = remain3 + plus;
						System.out.println("현재 재고수 : " + remain3);
						break;
					}
					break;
				case 2:
					System.out.print("얼마를 채울껴? : ");
					plusM = scan.nextInt();
					change = change + plusM;
					System.out.println(change + "원");
					break;
				case 3:
					System.out.printf("바꿀 음료 선택 : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("바꿀 음료 가격 입력 : ");
					cprice = scan.nextInt();
					switch(choice) {
					case 1:
						price1 = cprice;
						System.out.printf("%s 가격 - %d%n",drink1,price1);
						break;
					case 2:
						price2 = cprice;
						System.out.printf("%s 가격 - %d%n",drink2,price2);
						break;
					case 3:
						price3 = cprice;
						System.out.printf("%s 가격 - %d%n",drink3,price3);
						break;
					}
					break;
				case 4:
					System.out.printf("바꿀 음료 선택 : 1.%s 2.%s 3.%s",drink1,drink2,drink3);
					choice = scan.nextInt();
					System.out.print("바꿀 음료 이름 입력 : ");
					slot = scan.next();
					switch(choice) {
					case 1:
						System.out.printf("%s -> %s%n",drink1,slot);
						drink1 = slot;
						break;
					case 2:
						System.out.printf("%s -> %s%n",drink2,slot);
						drink2 = slot;
						break;
					case 3:
						System.out.printf("%s -> %s%n",drink3,slot);
						drink3 = slot;
						break;
					}

				}
				break;
				case 99:
					power = true;
					break;
				default:
					System.out.println("오류 - 다시 선택하시오.");
			}

		}
		System.out.println("자판기 종료!!");


	}
}