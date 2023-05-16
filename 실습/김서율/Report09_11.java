package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report09_11 {
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1		음료의 종류와 가격, 재고수, 거스름돈 반환, 돈 입력 등
//				99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
		
//		1. 변수 선언 -> 필요한 변수 : 음료 1,2,3 가격 1,2,3 거스름돈
		boolean power = false;	//전원
		String beverage1 = "물";
		String beverage2 = "커피";
		String beverage3 = "이온음료";
//		String option1 = "얼음";
//		String option2 = "우유";
		
		int price1 = 1000;
		int price2 = 2000;
		int price3 = 1500;
		
		int amount1 = 10;
		int amount2 = 10;
		int amount3 = 10;
		
		int choiceMenu = 0;
		int inputMoney = 0;
		int change = 0;
		
//		메뉴입력값, 받은 돈, 음료이름 1,2,3, 가격1,2,3 , 거스름돈
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
//			1. 메뉴 보여주기
			System.out.println();
			System.out.println("==================<<  MENU  >>===================");
			System.out.println("0. 결제  1. "+beverage1+"("+price1+") 2. "+beverage2+"("+price2+")  3. "+beverage3+"("+price3+")");
			System.out.println("-------------------------------------------------");
			System.out.println("10. 거스름돈 반환 11. 재고확인 99. 자판기 종료	");
			System.out.println("=================================================");
			
//			2. 메뉴 선택
			System.out.print("메뉴를 선택하세요. > ");
			choiceMenu = scan.nextInt();
//			System.out.println();

//			3. 돈 입력
//			if(choiceMenu==1 || choiceMenu==2 || choiceMenu==3) {
//				System.out.print("돈을 넣어주세요. > ");
//				inputMoney = inputMoney + scan.nextInt();
//			}
			
//			4. 메뉴에 대한 분기
			switch(choiceMenu) {
			
			case 0:
				System.out.print("금액을 넣어주세요. > ");
				inputMoney += scan.nextInt();
				System.out.println("> 현재 자판기 안의 금액은 "+ inputMoney +"원입니다.");
				break;
				
			case 1:
				System.out.printf("> 투입된 금액은 %d원 입니다. %n", inputMoney);
				System.out.println("> 선택하신 음료의 가격은 " + price1 + "원 입니다.");
				
				if(inputMoney<price1) {
					System.out.print("돈이 부족합니다. 돈을 더 넣어주세요. --> 0. 결제");
					System.out.println();
					
				} else if(inputMoney>price1) {
					System.out.println("> 선택하신 음료가 나옵니다.");
//					System.out.println("잔돈을 반환하세요. --> 10. 거스름돈 반환");
					inputMoney -= price1;
					amount1--;
				}
			
				break;
			
			case 2:
				System.out.printf("> 투입된 금액은 %d원 입니다. %n", inputMoney);
				System.out.println("> 선택하신 음료의 가격은 " + price2 + "원 입니다.");

				if(inputMoney<price2) {
					System.out.print("돈이 부족합니다. 돈을 더 넣어주세요. --> 0. 결제");
					System.out.println();
					
				} else if(inputMoney>price2 && amount2 != 0) {
					System.out.println("> 선택하신 음료가 나옵니다.");
					inputMoney -= price2;
					amount2--;
				}
			
				break;
			
			case 3:
				System.out.printf("> 투입된 금액은 %d원 입니다. %n", inputMoney);
				System.out.println("> 선택하신 음료의 가격은 " + price3 + "원 입니다.");

				if(inputMoney<price3) {
				System.out.print("돈이 부족합니다. 돈을 더 넣어주세요. --> 0. 결제");
				System.out.println();
				
				}else if(inputMoney>price3 && amount3 != 0) {
				System.out.println("> 선택하신 음료가 나옵니다.");
				inputMoney -= price3;
				amount3--;
				}
				
				break;
				
			case 10:
				System.out.println("> 잔돈이 반환됩니다.");
				change = inputMoney;
				System.out.println(change);
				inputMoney=0;
				
				break;
			case 11:
				System.out.printf("> 현재 1.물의 재고수량은 %d개 입니다. %n", amount1);
				System.out.println();
				System.out.printf("> 현재 2.커피의 재고수량은 %d개 입니다. %n", amount2);
				System.out.println();
				System.out.printf("> 현재 3.이온음료의 재고수량은 %d개 입니다. %n", amount3);
				System.out.println();
				break;
			case 99:
				power = true;
				System.out.println("자판기를 종료합니다.");
				
				break;
				
			default:
				System.out.println("메뉴를 다시 선택하세요.");
				
			}
			
		}
		System.out.println("POWER OFF");
	}
}
