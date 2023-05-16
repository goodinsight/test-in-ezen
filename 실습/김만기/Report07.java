package kr.co.man;

import java.util.Scanner;

public class Report07 {
	
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈 입력 등
//			99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면매뉴 보여주기
		
		boolean power = false;  										// 전 원
		
//		매뉴입력값, 받은 돈, 음료 이름1, 2, 3 / 가격1, 2, 3 / 거스름돈
		
		Scanner scan = new Scanner(System.in);
		
		String a = "COLA";												// 메뉴 선택을 위한 문자열 변수
		String b = "CIDA";												
		String c = "COFFEE";											
		String insert = "";												// 메뉴 입력을 위한 변수
		final int cola = 500;											// 가격은 상수로 
		final int cida = 1000;
		final int coffee = 1500;
		
		
		System.out.println("\t자판기");
		while(!power) {
			int input = scan.nextInt();									// 돈 넣기
			if(input >= coffee) {										// 음료를 뽑기 위한 금액
				
				
				while(input > 0) {										//잔액을 모두 소진하거나 거스름돈 반환을 선택시 루프 종료
					System.out.println("     선택 가능 음료");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("■■■■\t" + "■■■■\t" + " ■■■■ ");
					System.out.println("잔액 : " + input);
					
					insert = scan.next();								//음료 선택
					insert = insert.toUpperCase();						//소문자로 입력했을 수 있으니 대문자로 변환								
				
					if(a.equals(insert) || insert.equals("콜라")) {		// 메뉴 입력
						System.out.println("주문하신 " + a + "입니다.");
						input -= cola;									// 메뉴 선택후 잔액 계산
						System.out.println("잔액 : " + input);
						System.out.println();
					
					}
					else if(b.equals(insert) || insert.equals("사이다")) {
						System.out.println("주문하신 " + b + "입니다.");
						input -= cida;
						System.out.println("잔액 : " + input);
						System.out.println();
						
					}
					else if(c.equals(insert) || insert.equals("커피")) {
						System.out.println("주문하신 " + c + "입니다.");
						input -= coffee;
						System.out.println("잔액 : " + input);
						System.out.println();
						
					}
					else if(insert.equals("돈")) {						// "돈" 입력시 거스름돈 반환
						System.out.println("거스름돈 " + input + "입니다");
						input = 0;
						System.out.println("잔액 : " + input);
						System.out.println();
						
					}
					else if(insert.indexOf('0') > 0) {
						input += Integer.parseInt(insert);
					}
					else if(input == 0) {								// 잔액 모두 소진시 루프 종료
						break;
					}
					else {
						System.out.println("다시 입력해주세요");
					}
				}
				
				
			}
			else if(input >= cida) {
	
				
				while(true) {
					System.out.println("     선택 가능 음료");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("■■■■\t" + "■■■■\t" + " □□□□ ");
					System.out.println("잔액 : " + input);
					
					insert = scan.next();
					insert = insert.toUpperCase();
				
					if(a.equals(insert) || insert.equals("콜라")) {
						System.out.println("주문하신 " + a + "입니다.");
						input -= cola;
						System.out.println("잔액 : " + input);
						System.out.println();
					}
					else if(b.equals(insert) || insert.equals("사이다")) {
						System.out.println("주문하신 " + b + "입니다.");
						input -= cida;
						System.out.println("잔액 : " + input);
						System.out.println();
					}
					else if(insert.equals("돈")) {
						System.out.println("거스름돈 " + input + "입니다");
						input = 0;
						System.out.println("잔액 : " + input);
						System.out.println();
						break;
					}
					else if(input == 0) {
						break;
					}
					else {
						System.out.println("다시 입력해주세요");
					}
				}
			}
			else if(input >= cola) {
	
				
				while(true) {
					System.out.println("     선택 가능 음료");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("■■■■\t" + "□□□□\t" + " □□□□ ");
					System.out.println("잔액 : " + input);
					
					insert = scan.next();
					insert = insert.toUpperCase();
					if(a.equals(insert) || insert.equals("콜라")) {
						System.out.println("주문하신 " + a + "입니다.");
						input -= cola;
						System.out.println("잔액 : " + input);
						System.out.println();
					}
					else if(insert.equals("돈")) {
						System.out.println("거스름돈 " + input + "입니다");
						input = 0;
						System.out.println("잔액 : " + input);
						System.out.println();
						break;
					}
					else if(input == 0) {
						break;
					}
					else {
						System.out.println("다시 입력해주세요");
					}
				}
				
			}
			else {
				System.out.println("금액이 부족합니다.");
				System.out.println("잔액 : " + input);
			}
//			power = true;			
		}
		System.out.println("자판기 종료!!");
	}

}
