package kr.co.dong;

import java.util.Scanner;

public class Report21 {

	public static void main(String[] args) {
		// 
		
		boolean power = false; // 전원
		
		int sel = 0; // 메뉴 선택 
		int item1p=1200, item2p=1500, item3p=2000,item4p=5000, charge=0, coin=0;
		int item1n=99, item2n=99, item3n=99, intem4n=99;

		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		String item4="Jin tonic";
		
		System.out.println("Hi 난 자판기임 :)=========== 현재 제공중인 품목은 ");
		System.out.println("1"+item1 + " : "  + item1p + " won");
		System.out.println("2"+item2 + " : " + item2p + " won");
		System.out.println("3"+item3 + " : " + item3p + " won");
		System.out.println("4"+item4 + " : " + item4p + " won");		
		System.out.println("===================== 입니다. 사용을 원하시면 동전을 투입(입력)해주세요.");
		System.out.print("입력 = ");
		
		Scanner sc = new Scanner(System.in);
		
		while(!power) {
			
			coin += sc.nextInt();
			System.out.println("투입 된 금액은 현재 " + coin + "입니다.");
			
//			System.out.println("메뉴를 선택해주세요");
//			sel = sc.nextInt();
			
			switch(sel) {
			
			case 1:
				System.out.println(item1);
				
				break;
		
			case 2:
				System.out.println(item2);
				break;
			case 3:
				System.out.println(item3);
				break;
			case 4:
				System.out.println(item4);
				break;
			case 5:
				System.out.println("현재 금액이" + "반환 됩니다.");
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
			
			
		}
		System.out.println("자판기 종료");
		

	}//main ed


}//class ed
