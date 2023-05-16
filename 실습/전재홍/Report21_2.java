package kr.co.dong;

import java.util.Scanner;

public class Report21_2 {

	public static void main(String[] args) {
		// 
		
		boolean power = false; // 전원
		
		int sel = 0; // 메뉴 선택 
		int item1p=1200, item2p=1500, item3p=2000,item4p=5000, coin=0; // 돈 관련
		int item1n=12, item2n=13, item3n=15, item4n=12; //재고 관련

		//항목들
		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		String item4="Jin tonic";
		
		System.out.println("Hi I'm vending machine :) ================ | 현재 제공중인");
		System.out.println("========================================== | 품목들 입니다");
		System.out.println("1. "+item1 + " : "  + item1p + " won ============ X " + item1n + " ===== | 사용을 원하시면");
		System.out.println("2. "+item2 + " : " + item2p + " won =========== X " + item2n + " ===== | 동전을 투입");
		System.out.println("3. "+item3 + " : " + item3p + " won ==== X " + item3n + " ===== | (입력)해주세요");
		System.out.println("4. "+item4 + " : " + item4p + " won ======= X " + item4n + " ===================");		
		System.out.println("========================================================");
		System.out.print("입력 = \r");
		
		
		Scanner sc = new Scanner(System.in);
		
		while(!power) {
			
			coin += sc.nextInt();
			
			if(item1n+item2n+item3n+item4n == 0){
				System.out.println("\r투입된 금액 + coin + 이 반환 됩니다.");
				coin-=coin;
				System.out.println("현재 기기에 투입 되어있는 금액은" + coin +"입니다.");
				System.out.println("재고 부족으로 기기 전원이 종료됩니다.");
				power = true;
			}else{
				System.out.println("투입 된 금액은 현재 " + coin + " won 입니다, 메뉴를 선택해주세요.\r");			
				System.out.println("① "+ item1 + " ② " + item2 + " ③ " + item3 + " ④ "+ item4 + " ⑤ 잔돈 반환");		
				
			}
			
			
			sel = sc.nextInt();
			
			switch(sel) {
						
				case 1:
								
					if (coin<item1p) {
						System.out.println("=================== 잔액이 부족합니다 ===================");
						System.out.println("=========== 투입한 금액" +coin+ "이 반환 됩니다.===========");
						
						coin-=coin;
						
									
					}else if(item1n == 0) {
						System.out.println("선택하신 음료의 재고가 없습니다.");
						System.out.println("투입 된 금액은 현재 " + coin + "입니다.");
						
					}else{
					item1n -= 1; coin-=item1p;
						System.out.println("선택하신 음료"+item1+"가 곧 제공됩니다. ===== - 재고 "+item1n);
						System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
					}
				
					break;
					
		
				case 2:
					
					if (coin<item2p) {
						System.out.println("=================== 잔액이 부족합니다 ===================");
						System.out.println("=========== 투입한 금액" +coin+ "이 반환 됩니다.===========");
									
					}else if(item2n <= 0) {
						System.out.println("선택하신 음료의 재고가 없습니다.");
						
					}else{
					item2n -= 1; coin-=item2p;
						System.out.println("선택하신 음료"+item2+"가 곧 제공됩니다. ===== - 재고 "+item2n);
						System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
					}
					
					break;
			case 3:
				if (coin<item3p) {
					System.out.println("=================== 잔액이 부족합니다 ===================");
					System.out.println("=========== 투입한 금액" +coin+ "이 반환 됩니다.===========");
									
					}else if(item3n <= 0) {
						System.out.println("선택하신 음료의 재고가 없습니다.");
						
					}else{
					item3n -= 1; coin-=item3p;
						System.out.println("선택하신 음료"+item3+"가 곧 제공됩니다. ===== - 재고 "+item3n);
						System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
					}
				break;
			case 4:
				if (coin<item4p) {
					System.out.println("=================== 잔액이 부족합니다 ===================");
					System.out.println("=========== 투입한 금액" +coin+ "이 반환 됩니다.===========");
									
					}else if(item4n <= 0) {
						System.out.println("선택하신 음료의 재고가 없습니다.");
						
					}else{
					item4n -= 1; coin-=item4p;
						System.out.println("선택하신 음료"+item4+"가 곧 제공됩니다. ===== - 재고 "+item4n);
						System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
					}
				
					break;
			case 5:
					System.out.println("금액 " + coin + " won 이 반환 됩니다.");
					System.out.println("=================================");
				coin-=coin;
					System.out.println("현재 금액은 "+ coin + " won 입니다." );
					System.out.println();
					// 거스름돈 반환
				break;
				
			case 77:// 관리자모드
				// 대충 수정하는 기능들
				
			case 99:
				power = true;
				System.out.println("기기 전원이 종료됩니다.");
					
				
					 
					 
				break;
			
			default:		
			
				System.out.println("잘못 누르셨습니다.");
				
			}	
			
				if (!power) {
				
					System.out.println("추가로 이용을 원하시면 동전을 투입 해주세요. 0 = 동전을 넣지 않는다." );
					System.out.print("입력 = " );		
				
			}
			
		}
		System.out.println("자판기 종료");
		
		
	}//main ed


}//class ed
