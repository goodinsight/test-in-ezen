package kr.co.dong.ArrayCheckPoint;

import java.util.Scanner;

import javax.naming.CompoundName;

public class ArrayReport09_05 {
	public static void main(String[] args) {
//		배열명 : dName, dPrice, dAmount 
//		음료의 종류 : 3가지
		
//		1. 선언
		
		String[] dName = {"홍차", "녹차", "흑차"};
		int[] dPrice = {1500, 1000, 2000};
		int[] dAmount = {10, 20, 5};
	
		Scanner scan = null;
		
//		2. 생성
		
		scan = new Scanner(System.in);
//		scan을 받을 변수
		int choiceMenu = 0;		//메뉴선택 변수
		int inputMoney = 0;		//돈 입력
		int Amount = 0;			//재고 수정
		
		boolean power = false;		//전원 변수 선언
		int change = 0;				//잔돈 변수
		
//		2-1 값 설정

//		3. 입력
		
		while(!power) {				//power가 true
			// 메뉴 생성
			System.out.println();
			System.out.println("==============< MENU >==============");
			System.out.println("0.결제 10.거스름돈 반환 11.재고 99.종료");	//관리자모드 : 77
			System.out.println("------------------------------------");
			for(int i=0; i<dName.length; i++) {
				System.out.print((i+1) + "." + dName[i] + "(" + dPrice[i] + ") ");
			}
			System.out.println();
			System.out.println("====================================");
			System.out.print("메뉴를 선택하세요 > ");
			choiceMenu = scan.nextInt();
		
//		4. 메뉴에 대한 분기		//배열-for문을 이용하여 간소화
			switch (choiceMenu) {
			case 0:
				System.out.print("돈을 넣어주세요. > ");
				inputMoney = inputMoney + scan.nextInt();
				System.out.println();
				System.out.println("현재 자판기 안의 금액은 " + inputMoney + "원 입니다.");
				
				break;
			case 1:	//만약에 홍차를 선택했다면 투입금액은 1500원보다 비싸야하고, 1500원보다 적으면 -> 돈이 부족합니다. 재고가 없으면 -> 재고가 부족합니다. 
//				(재고는 dAmount--;)
				if(inputMoney<dPrice[0]) {
					System.out.println("금액이 부족합니다. > 0.결제");
					
				} else if(inputMoney>dPrice[0] && dAmount[0]!=0) {		//dAmount[0]>0
					System.out.println("선택하신 음료가 나옵니다.");
					dAmount[0]--;
					inputMoney = inputMoney-dPrice[0];
					System.out.println("현재 자판기 안의 금액은 " + inputMoney + "원 입니다.");
					
//				} else if(dAmount[0]==0) {
				} else {
					System.out.println("재고가 부족합니다.");
				}
				
				
				break;
			case 2:
				if(inputMoney<dPrice[1]) {
					System.out.println("금액이 부족합니다. > 0.결제");
					
				} else if(inputMoney>dPrice[1] && dAmount[1]!=0) {		//dAmount[1]>0
					System.out.println("선택하신 음료가 나옵니다.");
					dAmount[1]--;
					inputMoney = inputMoney-dPrice[1];
					System.out.println("현재 자판기 안의 금액은 " + inputMoney + "원 입니다.");
					
				} else {
					System.out.println("재고가 부족합니다.");
				}
				
				break;
				
			case 3:
				if(inputMoney<dPrice[2]) {
					System.out.println("금액이 부족합니다. > 0.결제");
					
				} else if(inputMoney>dPrice[2] && dAmount[2]!=0) {		//dAmount[0]>0
					System.out.println("선택하신 음료가 나옵니다.");
					dAmount[2]--;
					inputMoney = inputMoney-dPrice[2];
					System.out.println("현재 자판기 안의 금액은 " + inputMoney + "원 입니다.");
					
				} else {
					System.out.println("재고가 부족합니다.");
				}
				break;
				
			case 10:	//만약에 자판기 안의 금액이 음료 선택금액보다 더 크다면 -> 잔돈 반환
				System.out.println("잔돈이 반환됩니다.");
				change = inputMoney;
				System.out.println("반환된 금액은 " + change + "원 입니다.");
				inputMoney = 0;
				
				break;
				
			case 11:	//재고
				for(int i=0; i<dAmount.length; i++) {
					System.out.println(dName[i] + "의 재고수량은 " + dAmount[i] + "입니다.");
				}
				
				break;
				
			case 77:	//관리자모드
				boolean admin = false;
				int choiceSetup = 0;
				String setUp1 = "음료변경", setUp2 = "가격변경", setUp3 = "재고수량변경";
				
				String pw = "룡룡";
//				System.out.print("비밀번호를 입력하세요. > ");
				pw = scan.next();
				
				if(pw.equals("룡룡")) {
					while(!admin) {
						System.out.println();
						System.out.println("관리자모드로 전환합니다.");
						System.out.println("--------------------------------------------");
						System.out.println("1."+setUp1+" 2."+setUp2+" 3."+setUp3+" 4.종료");		//종료 후 다시 초기 메뉴로
						System.out.println("--------------------------------------------");
						System.out.println("번호를 선택하세요. > ");
						choiceSetup = scan.nextInt();
						
						switch (choiceSetup) {
						case 1:
							for(int i=0; i<dName.length; i++) {
								System.out.println("현재 " + (i+1) + "번 음료의 이름은 " + dName[i] + "입니다.");
								System.out.print((i+1) + "번 음료를 설정하세요. > ");
								dName[i] = scan.next();
								System.out.println("변경된 " + (i+1) + "번 음료는 " + dName[i] + "입니다.");
								System.out.println();
							}
							break;
							
						case 2:
							for(int i=0; i<dPrice.length; i++) {
								System.out.println("현재 " + (i+1) + "번 음료의 가격은 " + dPrice[i] + "입니다.");
								System.out.print("변경할 " + (i+1) + "번 음료의 가격을 설정하세요. > ");
								dPrice[i] = scan.nextInt();
								System.out.println("변경된 " + (i+1) + "번 음료의 가격은 " + dPrice[i] + "입니다.");
								System.out.println();
							}
							break;
							
						case 3:
							for(int i=0; i<dAmount.length; i++) {
								System.out.println("현재 " + (i+1) + "번 음료의 재고수량은 " + dAmount[i] + "입니다.");
								System.out.print((i+1)+"번 음료의 재고를 설정하세요. > ");
								dAmount[i] = scan.nextInt();
								System.out.println((i+1)+"번 음료의 재고는 " + dAmount[i] + "입니다.");
								
							}
					
							break;
						case 4:
							admin = true;
							System.out.println("관리자모드를 종료합니다.");
							break;

						default:
							System.out.println("번호를 다시 입력하세요.");
							break;
						}
					}
					System.out.println("관리자모드 종료.");
//				} else {
//					System.out.println("비밀번호를 다시 입력하세요.");
				}
				
				break;
				
			case 99:	//PowerOff
				power = true;
				System.out.println("자판기를 종료합니다.");
				break;
				

			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
				break;
			}
		}
			System.out.println("자판기를 종료합니다.");
	}
}
