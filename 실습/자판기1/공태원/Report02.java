package kr.co.Test;

import java.util.Scanner;

public class Report02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 		// 1.음료 자판기를 구현하자
				// 2.음료 3종류 종류 / 가격 / 별도 /재고수
				//3.시작과 동시에 화면에 메뉴를 보여준다.
				// 3-1. 음료의 종류와 가격
				// 99 자판기 종료
				//4. 99 이외의 숫자인 경우 화면메뉴 보여주기 
				
				
			// 콜라, 사이다, 쥬스 
			//2000  1500  1000 
			
//				int coke_p =2000 ,cider_p = 1500,juice_p = 1000;// 가격
//				int money = 0; //받은돈 
//				int choice = 0; //메뉴선택
//				int change = 0;// 잔돈
//				
//		
//				boolean power = false; // 전원
////				메뉴 입력값, 받은 돈 , 음료이름 1 , 2 , 3 ,가격1,2,3, 거스름돈
//				Scanner scan = new Scanner(System.in);
//				
//				System.out.println("1.콜라: 2000 , 2.사이다 : 1500 , 3.쥬스 : 1000");
//				choice =scan.nextInt();
//				System.out.println("금액을 입력하세요");
//				money= scan.nextInt();
//				
//				if(choice==1 && money>= coke_p) {
//					change = money - coke_p;
//					System.out.println("잔돈은"+change+ "원 입니다.");
//				}else if(choice == 2 && money>=cider_p) {
//					change = money - cider_p;
//					System.out.println("잔돈은 "+ change+"원 입니다.");
//				}else if(choice == 3 && money >= juice_p) {
//					change = money - juice_p;
//					System.out.println("잔돈은 "+ change+"원 입니다.");
//				}else if(choice==1 && money<coke_p) {
//					change = money;
//					System.out.println("금액이"+ change+ "원 부족합니다!");
//				}else if(choice==2 && money<cider_p) {
//					change = money;
//					System.out.println("금액이"+ change+ "원 부족합니다!");
//				}else if(choice==3 && money<juice_p) {
//					change = money;
//					System.out.println("금액이"+ change+ "원 부족합니다!");
//				
//				
//				
//					
//					
//				
//			
//			
//			
//			System.out.println("자판기 종료!!");
			}
			

	
	// 1.음료 자판기를 구현하자
	// 2.음료 3종류 종류 / 가격 / 별도 /재고수
	//3.시작과 동시에 화면에 메뉴를 보여준다.
	// 3-1. 음료의 종류와 가격
	// 99 자판기 종료
	//4. 99 이외의 숫자인 경우 화면메뉴 보여주기 
	
	
	

				int coke_p =2000 ,cider_p = 1500,juice_p = 1000;// 가격
				int money = 0; //받은돈 
				int choice = 0; //메뉴선택
				int change = 0;// 잔돈
				
		
				boolean power = false; // 전원
//				메뉴 입력값, 받은 돈 , 음료이름 1 , 2 , 3 ,가격1,2,3, 거스름돈
				Scanner scan = new Scanner(System.in);
				
				int sel = 0; // 메뉴선택
				String name1 = "아이스크림";
				String name2 = "수박";
				String name3 = "얼음";
				


				
			while(!power) {
//				
//				0.돈입력
				
				System.out.println("투입 금액 :");
//				money = money + scan.nextInt()
				
//				1. 메뉴보여주기
				System.out.println("=======[메뉴]==========");
				System.out.println("1.아이스크림 2. 수박 3.얼음");
				System.out.println("5. 거스름돈반환 99 종료");
				System.out.println("현재 입금액"+money);
//				2.메뉴선택
				
				System.out.println("Select : ");
				sel = scan.nextInt();
				
//				3. 선택에 대한 분기
				switch(sel) {
				case 1://아이스크림 선택시
					System.out.println("아이스크림");
					break;
				case 2://
					System.out.println("수박");
					break;
				case 3://
				System.out.println("얼음");
					break;
				case 4://
					System.out.println("거스름돈");
					break;
				case 5://거스름돈 반환
				case 99:
					power = true;
					System.out.println("시스템 아웃");
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
				}
				}
				
				
				
				
				
				
							
	}
