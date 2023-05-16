package kr.co.dong;

import java.util.Scanner;

public class Report14 {
	
	public static void main(String[] args) {
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도/ 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다.
//		3-1 음료의 종류 와 가격, 재고수, 거스름돈 반환, 돈입력 등
//			99. 자판기 종료
//		4. 99이외의 숫자인 경우 화면메뉴 보여주기
		
		boolean power = false;	//전원
//		메뉴입력값, 받은 돈, 가격1,2,3 , 거스름돈
		Scanner sc = new Scanner(System.in);
		
		String choice = "";	// 재고수 여부
		
		String menu1 = "스프라이트";
		String menu2 = "코카콜라";
		String menu3 = "닥터페퍼";
		
		int menu1pay = 2000;
		int menu2pay = 2500;
		int menu3pay = 1500;
		
		int payment = 0;	// 결제액
		int payment1 = 0;	// 추가결제
		
		int change = 0;		// 잔돈
		
		String menuchoice = "";	// 매뉴고르기
		while(!power) {
			System.out.println("음료를 선택하세요.\n1. 스프라이트, 2. 코카콜라, 3. 닥터페퍼");
			
			menuchoice = sc.next();
			
			if(menuchoice.equals("1")||menuchoice.equals("스프라이트")) {
				System.out.println(menu1+"를 선택하셨습니다 가격은 " + menu1pay+"원 입니다.");
				System.out.print("결제하실 금액을 넣어주세요");
				payment = sc.nextInt();
				if(payment >= menu1pay) {
					change = payment - menu1pay;
					System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
				}else {
					while(true) {
						System.out.println("금액이 부족합니다.\n"+(menu1pay - payment)+"원 추가결제 하시겠습니까??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("추가결제하실 금액을 입력해주세요.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("추가 결제하신 금액은 "+ payment1+"원이고 누적금액은" + payment+"원입니다.");
							if(payment >= menu1pay) {
								change = payment - menu1pay;
								System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("결제를 종료합니다 결제하신 금액을 환불해드리겠습니다." + payment+"원");
							break;
						}else {
							System.out.println("y/n중에서만 입력해주세요.");
						}
						
					}
				}
			}else if(menuchoice.equals("2")||menuchoice.equals("코카콜라")) {
				System.out.println(menu2+"를 선택하셨습니다 가격은 " + menu2pay+"원 입니다.");
				System.out.print("결제하실 금액을 넣어주세요");
				payment = sc.nextInt();
				if(payment >= menu2pay) {
					change = payment - menu2pay;
					System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
				}else {
					while(true) {
						System.out.println("금액이 부족합니다.\n"+(menu2pay - payment)+"원 추가결제 하시겠습니까??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("추가결제하실 금액을 입력해주세요.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("추가 결제하신 금액은 "+ payment1+"원이고 누적금액은" + payment+"원입니다.");
							if(payment >= menu2pay) {
								change = payment - menu2pay;
								System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("결제를 종료합니다 결제하신 금액을 환불해드리겠습니다." + payment+"원");
							break;
						}else {
							System.out.println("y/n만 입력해주세요.");
						}
						
					}
				}
			}else if(menuchoice.equals("3")||menuchoice.equals("닥터페퍼")) {
				System.out.println(menu3+"를 선택하셨습니다 가격은 " + menu3pay+"원 입니다.");
				System.out.print("결제하실 금액을 넣어주세요");
				payment = sc.nextInt();
				if(payment >= menu3pay) {
					change = payment - menu3pay;
					System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
				}else {
					while(true) {
						System.out.println("금액이 부족합니다.\n"+(menu3pay - payment)+"원 추가결제 하시겠습니까??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("추가결제하실 금액을 입력해주세요.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("추가 결제하신 금액은 "+ payment1+"원이고 누적금액은" + payment+"원입니다.");
							if(payment >= menu3pay) {
								change = payment - menu3pay;
								System.out.println("결제액은 "+payment+"거스름돈은 "+change+" 원입니다.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("결제를 종료합니다 결제하신 금액을 환불해드리겠습니다." + payment+"원");
							break;
						}else {
							System.out.println("y/n만 입력해주세요.");
						}
						
					}
				}
			}else if(!menuchoice.equals("99")){		// 예외처리
				System.out.println("다른 매뉴는 개발중입니다.");
			}else {
				power = true;
			}
			
		}// 자판기 종료
		
		System.out.println("자판기 종료!!");
		sc.close();
	}
	
}
