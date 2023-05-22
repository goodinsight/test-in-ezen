import java.util.Scanner;

public class Report22 {

	public static void main(String[] args) {
		
//		배열명 dName, dPrice, dAmount
//		음료의 종류는 우선 3가지입니다.
//		
//		ftp 서버에 올려주세요.
//		1. 음료 자판기를 구현하자
//		2. 음료 3종류 종류 / 가격 별도 / 재고수
//		3. 시작과 동시에 화면에 메뉴를 보여준다
//		3-1. 음료의 종류와 가격, 재고수, 거스름돈 반환, 돈 입력 등
//			99. 자판기 종료
//		4. 99 이외의 숫자인 경우 화면메뉴 보여주기
		
		boolean power = false; // 전원
//		메뉴입력값, 받은 돈, 음료이름123, 가격123 , 거스름돈
		
		int menu = 0; // 메뉴 입력값
		int money = 0; // 받은 돈
		int total_input = 0; // 받은 돈 합계
		
		int sel = 0; // 메뉴 선택
		
		String[] dname = new String[] {"콜라","사이다","오렌지쥬스"};
		int[] dPrice = new int[] {500,1200,2500};
		int[] dAmount = new int[] {10,15,20};
		
		int user_choice = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			
//			 1. 메뉴 보여주기
			 System.out.println("====== [ menu ] ========");
			 for(int i=0; i<dname.length; i++) {
				 System.out.print((i+1)+". 음료 이름 : "+dname[i]+" / ");
				 System.out.print("재고 : "+dAmount[i]+" / ");
				 System.out.println("가격 : "+dPrice[i]);
			 }
			 System.out.println("5. 거스름돈 반환 99. 종료");
			 System.out.println("현재 입금액 : "+money);
			 System.out.println();
			 
			 // 0. 돈 입력
			 System.out.print("투입 금액 : ");
			 money = money + scan.nextInt(); // money 누적 시키기
			 
//			 2. 메뉴 선택
			 System.out.print("Select : ");
			 sel = scan.nextInt();
			 
//			3. 선택에 대한 분기		 
			 switch (sel) {
				case 1: // 콜라 선택시
					user_choice = 0;
					break;
				case 2: // 사이다 선택시
					user_choice = 1;
					break;
				case 3: // 오렌지쥬스 선택시
					user_choice = 2;
					break;
				case 5: // 거스름돈 반환
					System.out.println("거스름돈 반환함");
					System.out.println("잔돈 : "+money);
					System.out.println();
					break;
				case 99:
					power = true;
					System.out.println("시스템 아웃!");
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
					break;
				}
			 
			 if(sel>0 && sel<4) {
				 if(dPrice[sel-1]<money) {
					 money -= dPrice[user_choice];
					 dAmount[user_choice]--;	 
					 System.out.println(dname[user_choice]+"가 나왔습니다.");
					 System.out.println();
				 }else {
					 System.out.println("투입금액이 부족합니다.");
					 System.out.println();
				 }
			 }
			 
			 
			 
		}
		
		System.out.println("자판기 종료!!");

	}

}
