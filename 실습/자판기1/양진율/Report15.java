/*
 *  작성자 : 양진율				
 *  날짜 : 2023.05.15
 */

package kr.co.dong;

import java.util.Scanner;

public class Report15 {

	public static void main(String[] args) {
		
//		1. 음료 자판기 구현
//		2. 음료 3종류 종류 / 가격 별도/ 재고 수
//		3. 시작과 동시에 화면에 메뉴 출력
//		3-1. 음료의 종류와 가격, 재고 수, 잔액, 돈 입력 등
//				99입력시 자판기 종료.
//		4. 99 이외의 숫자인 경우 화면메뉴 보여주기
		
		boolean power = false; //전원
//		메뉴 입력값, 받은 돈, 음료이름1, 2, 3/가격1, 2, 3, 거스름 돈
		Scanner scan = new Scanner(System.in);
		
		int input;
		int balance = 0;
		int mode = 0; 
//			0 : 초기 화면, 1 : 투입 금액 입력, 2: 구입처리(실패시, 실패 원인 출력. 금액 부족, 재고 부족)
//			3 : 잔액 반환, 4: 종료
		
		
		String drink1name = "커피";
		int drink1price = 1200, drink1stock = 3;
		
		String drink2name = "몬스터";
		int drink2price = 2900, drink2stock = 5;
		
		String drink3name = "레드불";
		int drink3price = 2500, drink3stock = 7;
		
		int targetDrink = 0, targetPrice = 0, targetStock = 0;
		String targetName = "";
		
		while(!power) {
			
			switch(mode) 
			{
				case 0://초기 화면
					System.out.println("\n\n--자판기-----------------------");//대충 화면 출력문
					System.out.printf("번호\t이름\t가격\t재고\n");
					System.out.printf("1\t%s\t%d\t%d\n", drink1name, drink1price, drink1stock);
					System.out.printf("2\t%s\t%d\t%d\n", drink2name, drink2price, drink2stock);
					System.out.printf("3\t%s\t%d\t%d\n", drink3name, drink3price, drink3stock);
					System.out.println("잔액 : "+ balance);
					System.out.println("-----------------------------");
					
					System.out.println("입력 안내"
							+ "\n 0\t: 금액 투입 "
							+ "\n 1~3\t: 해당 음료 구입"
							+ "\n 4\t: 잔액 회수 "
							+ "\n 99\t: 종료\n");//대충 명령어 설명문
					
					System.out.print("실행하시고 싶은 행동을 입력해주세요.\n>>");
					input = scan.nextInt();
					
					switch(input) 
					{
						case 0:
							mode = 1;
							break;
						case 1: case 2: case 3:
							targetDrink = input;
							mode = 2;
							break;
						case 4:
							mode = 3;
							break;
						case 99:
							mode = 4;
							break;
						default :
							System.out.println("잘못된 입력입니다.");
					}
					
					break;
					
					
				case 1://금액 투입
					System.out.print("투입 금액을 입력해주세요. \n>>");
					input = scan.nextInt();
					
					if(input >= 0)
					{
						balance += input;
					}
					else
					{
						System.out.println("잘못된 입력입니다.");
					}
							
					mode = 0;
					break;
					
					
				case 2://구매 진행
					//타겟 설정
					switch(targetDrink) 
					{
						case 1:
							targetPrice = drink1price;
							targetStock = drink1stock;
							targetName = drink1name;
							break;
						case 2:
							targetPrice = drink2price;
							targetStock = drink2stock;
							targetName = drink2name;
							break;
						case 3:
							targetPrice = drink3price;
							targetStock = drink3stock;
							targetName = drink3name;
					}
					
					//예외 및 계산 진행
					if(balance < targetPrice)
					{
						System.out.println("잔액이 부족합니다.");
						mode = 0;
						break;
					}
					else if(targetStock == 0)
					{
						System.out.println("재고가 부족합니다.");
						mode = 0;
						break;
					}
					else
					{
						balance -= targetPrice;
					}
					
					//재고 감소 및 구입문 출력
					switch(targetDrink) 
					{
						case 1:
							drink1stock--;
							break;
						case 2:
							drink2stock--;
							break;
						case 3:
							drink3stock--;
					}
					System.out.printf("%s을(를) 구입합니다.\n", targetName);
					System.out.printf("잔액 : %d -> %d\n", balance+targetPrice, balance);
					
					mode = 0;
					break;
					
					
				case 3://잔액 회수
					System.out.printf("잔액 %d원을 회수합니다.", balance);//잔액 출력 및 종료 선언문
					balance = 0;
					mode = 0;
					break;
				
					
				case 4://종료
					System.out.println("거래를 종료합니다.");
					power = true;
			}
			
		}
		
		
	}

}
