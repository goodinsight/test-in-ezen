/*
 * 1. 음료 자판기를 구현하자
 * 2. 음료 3종료 종류 / 가격 별도 / 재고수
 * 3. 시작과 동시에 화면에 메뉴를 보여준다.
 *  3_1 음료의 종류, 가격, 재고수, 거스름돈 반환,ㅡ 돈입력 
 *  3_2 99. 자판기 종료
 * 4. 99이외의 숫자인 경우 화면 메뉴 보여주기  
 */
package kr.co.dong;

import java.util.Scanner;

public class report_01_2 {
	public static void main(String[] args) {
		
		boolean power = false;  // 전원
//		메뉴입력값, 받은 돈, 음료 이름1, 2, 3, 가격1, 2, 3, 거스름돈
		int inMoney = 0;
		int plusMoney = 0;
		
		int outMoney = 0;
		int menu = 0;
		int remain = 0;
		int conButton = 0;
		
		int whanta = 0, coke = 0, cida =0;
		int value1 = 500, value2= 1000, value3= 1500;
		
		whanta = value1;
		coke = value2;
		cida = value3;
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
					
			System.out.printf("=====원하는 메뉴를 선택해주세요=====\n");
			System.out.printf("1.whanta(%d원)\n2.coke(%d원) \n3.cida(%d원) \n", value1, value2, value3 );
			System.out.printf("=========돈을 넣어 주세요========\n");
			inMoney = scan.nextInt();
			remain = inMoney;
			
			while (remain<value1) {
				remain = inMoney;
				System.out.printf("금액이 부족합니다. 더 넣어 주세요 \n");
				inMoney = scan.nextInt();
				remain = remain + inMoney;
					if(remain >= 500)
						break;
			    }		
			
				System.out.printf("총 주신 금액은 %d 입니다. \n", remain);
					
				if(remain>=value1)
				{
					System.out.printf("=====원하는 메뉴를 선택해주세요=====\n");
					System.out.printf("1.whanta(%d원)\n2.coke(%d원) \n3.cida(%d원) \n", value1, value2, value3 );
				
					menu = scan.nextInt();					
					
					switch (menu) 
					{
					case 1:
						if(remain>=value1) {
							System.out.printf("whanta를 선택하셨습니다.\n \n");
							remain = remain - value1;	
							if(remain<=0)
								break;
						}
						else {
							break;
						}

					case 2:
						if(remain>=value2) {
							System.out.printf("coke를 선택하셨습니다.\n \n");
							remain = remain - value2;
							if(remain<=0)
								break;
						}
						else {
							break;
						}
				
					case 3:
						if(remain>=value3) {
							System.out.printf("cida를 선택하셨습니다.\n \n");
							remain = remain - value3;
							if(remain<=0)
								break;
						}
						else {
							break;
						};
			
					default :
						
						break;
					
					} //end of if(remain>=value1)	
					
					
					System.out.printf("구매해주셔서 감사합니다. 토출구에 음료수를 가져가셔요. \n");				
					System.out.printf("현재 남은 잔액은 %d원입니다. \n \n", remain);
					
					System.out.printf("종료는 99번을 누르시고, 추가 구입은 편한 숫자를 눌러주세요.\n");
						
					conButton = scan.nextInt();
					if(conButton==99) {
						break;
					}
				}
				
				
			}
			
		System.out.printf("종료를 누르셨습니다. 잔돈 %d이 나옵니다. 가져가셔요.\n", remain);
		System.out.println("자판기 종료");
		
	}
}
