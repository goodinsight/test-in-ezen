package da_5_15;

import java.util.Scanner;

public class Report13 {

	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격 , 재고수, 거스름돈 반환, 돈입력 등
//			99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
		boolean power = false;	//전원
//		메뉴입력값, 받은 돈, 음료이름1,2,3 가격1,2,3 , 거스름 돈
		Scanner scan = new Scanner(System.in);
		String drink1 = "아메리카노";
		String drink2 = "밀크커피";
		String drink3 = "믹스커피";
		int price1 = 700, price2 = 600, price3 = 500;
		int change = 0;
		int money = 0;
		while(!power) {
			System.out.print("음료 종류\n1.아메리카노(700) - 2.밀크커피(600) - 3.믹스커피(500)");
			System.out.println("\n돈을 넣어라");
			money = money + scan.nextInt();
			System.out.println("1번,2번,3번 중 골라라");
			int choice = scan.nextInt();
			if(choice == 1) {
				if(money >= price1) {
					change = money - price1;
					System.out.println("거스름돈" + change+"원");
				}else if(money < price1){
					System.out.println("부족한 돈 :"+ (price1 - money+"원"));
				}
				System.out.println(drink1 +"700원");
		
			}
			else if(choice == 2) {
				if(money >= price2) {	
					change = money - price2;
					System.out.println("거스름돈" + change+"원");
				}else {
					System.out.println("부족한 돈 :"+ (price2 - money+"원"));
				}
				System.out.println(drink2 + "600원");
		
			}
			else if(choice == 3) {
				if(money >= price3) {
					change = money - price3;
					System.out.println("거스름돈" + change+"원");
				}else {
					System.out.println("부족한 돈 :"+ (price3 - money+"원"));
				}
				System.out.println(drink3 + "500원");
			}
			if(choice == 99) {
				power = true;
			}
		}
		
		
		System.out.println("자판기 종료!!");
		
		

	}

}
