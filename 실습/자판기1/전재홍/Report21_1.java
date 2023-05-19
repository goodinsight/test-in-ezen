package kr.co.dong;

import java.util.Scanner;

public class Report21_1{
	
	public static void main(String[] args) {
		
		boolean power = false; // 전원
				
		int item1p=1200, item2p=1500, item3p=2000, charge=0; 
		int item1n=99, item2n=99, item3n=99;

		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		
		
		System.out.println("Hi 난 자판기임 현재 제공중인 품목은 ");
		
		System.out.println(item1 + " : "  + item1p + " won");
		System.out.println(item2 + " : " + item2p + " won");
		System.out.println(item3 + " : " + item3p + " won");
		
		System.out.println("입니다. 사용을 원하시면 동전을 투입해주세요.");
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(!power) { // 1200 1500 2000
	
			int coin = sc.nextInt();
			System.out.println("투입 된 금액은 현재 " + coin + "입니다.");
			
			
			
			if (coin >= 1200) {
				System.out.print("선택 가능 한 음료는 " + item1 + "입니다.\r");
				System.out.println("0 = 뽑는다. 1 = 뽑지 않는다. 2 = 동전을 더 넣는다.");
				
				Scanner sel = new Scanner(System.in);
				int ch = sel.nextInt();
					
					if(0 == ch) {
						
						item1n -= 1;
						charge = coin - item1p;
						coin -= 1200;
						System.out.println(item1 + "가/이 제공됩니다." );
						System.out.println("남은 금액은 "+ charge + "입니다.");
						System.out.println(item1 + "의 재고는 현재 " + item1n + " 개 입니다.");
						
							if(0 >= coin) {
								System.out.println("잘못된 입력입니다. 올바른 동전을 투입해주세요.");
							
											
							}
					
					}else if(1 == ch) {
												
						System.out.println("금액이 반환됩니다.");
						charge = coin - coin; 
						System.out.println("남은 금액은 "+ charge + "입니다.");
			
			}else if (coin >=1500) {
				System.out.println(item2);
			}else if (coin >=2000) {
				System.out.println(item3);
			}
	
			}

		}
	
		System.out.println("자판기 종료");
		
		
	}//main ed

}//class ed
