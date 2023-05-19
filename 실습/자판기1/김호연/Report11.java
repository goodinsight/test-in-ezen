package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11 {
	
	public static void main(String[] args) {
//		1 음료 자판기 구현
//		2 음료 3종류 / 가격 별도 / 재고 구현
//		3 시작과 동시에 화면에 메뉴 표시
//		3-1	음료의 종류 와 가격, 재고, 거스름반환, 돈입력 등
//			99.자판기 종료
//		4. 99 이외의 숫자인 경우 화면 메뉴 표시
		
		
//		관리자모드 구현, 구입 가능 제품 점등
		
		
		boolean power=false; // 전원
		int mInput=-1;
		int dInput=-1;
		
		int money=0;
		int cha=0;
		
		int rem1=5;
		int rem2=5;
		int rem3=5;
		
		int cost1=1200;
		int cost2=1000;
		int cost3=800;
		
		String menu1 ="콜라";
		String menu2 ="커피";
		String menu3 ="생수";
		
		Scanner scan=new Scanner(System.in);
		
		while(!power) {
			System.out.println();
			System.out.println("[ 음료 자판기 ]");
			System.out.printf("%s / %4d원 / 재고 : %d%n", menu1, cost1, rem1);
			System.out.printf("%s / %4d원 / 재고 : %d%n", menu2, cost2, rem2);
			System.out.printf("%s / %4d원 / 재고 : %d%n", menu3, cost3, rem3);
			System.out.printf("남은 돈 : %d원%n", money);
			System.out.printf("(1)돈 투입 (2)음료 구입 (3)거스름 반환 (99)자판기 종료%n");
			System.out.print("명령을 입력해주세요 : ");
			mInput=scan.nextInt();
			
			input1:
			switch (mInput) {
			case 1:
				int tmp=0;
				while(!power) {
					System.out.print("얼마나 넣겠습니까? : ");
					tmp=scan.nextInt();
					if(tmp<0) {
						System.out.println("올바른 금액을 입력해주세요.");
					}
					else {
						money+=tmp;
						break;
					}
				}	// end of while(!power) in case 1
				break;
			
			case 2:
				while(!power){
					System.out.println();
					System.out.printf("(1)%s / %4d원 / %d%n(2)%s / %4d원 / %d%n(3)%s / %4d원 / %d%n", menu1, cost1, rem1, menu2, cost2, rem2, menu3, cost3, rem3);
					System.out.printf("남은 돈 : %d%n", money);
					System.out.printf("음료를 선택해주세요 (99=처음으로) : ");
					dInput=scan.nextInt();
					switch (dInput) {
					case 1:
						if(money<cost1) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break input1;
						}
						else if(rem1<=0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu1);
							break;
						}
						else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu1);
							money-=cost1;
							rem1--;
						}
						break;
					case 2:
						if(money<cost2) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break input1;
						}
						else if(rem2<=0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu2);
							break;
						}
						else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu2);
							money-=cost2;
							rem2--;
						}
						break;
					case 3:
						if(money<cost3) {
							System.out.printf("%n***돈이 부족합니다.***%n");
							break input1;
						}
						else if(rem3<=0) {
							System.out.printf("%n***%s 재고가 없습니다.***%n", menu3);
							break;
						}
						else {
							System.out.printf("%s를 1개 구입했습니다.%n", menu3);
							money-=cost3;
							rem3--;
						}
						break;
					case 99:
						break input1;
	
					default:
						System.out.printf("%n올바른 숫자를 입력해주세요.%n");
						continue;
					}	// end of switch(dInput)
					
				}	// end of while(!power) in case 2
			
			case 3:	
				cha=money;
				money=0;
				System.out.printf("거스름 %d원을 반환합니다.%n", cha);
				break;
			
			case 99:
				power=true;
				break;

			default:
				System.out.printf("%n올바른 숫자를 입력해주세요.%n");
				break;
			}	// end of switch(mInput)
			
		}	// end of while(!power)
		
		scan.close();
		System.out.println("자판기 종료");
		
		
	}	// end of main

}	// end of class
