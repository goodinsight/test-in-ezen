package kr.co.dong.checkPoint;

import java.util.Arrays;
import java.util.Scanner;

public class Report_1_14_1 {

	public static void main(String[] args) {
//		자판기 작동여부
		boolean power = false;
		
		boolean admin = false;
		
		Scanner sc = new Scanner(System.in);
//		자판기에 넣는 금액
		int money = 0;
//		음료명
		String[] dNameStrings = {"제로팹시","밀키스","포카리스웨트"};
//		음료 가격
		int[] dPrice = {2000,1500,1000};
//		음료 재고
		int[] dAmount = {10,10,10};
//		금일 음료의 판매 개수
		int[] dCount = {0,0,0};
//		자판기 안의 잔액
		int charge = 100000;
//		음료 선택번호
		int dChoice = 0;
//		매뉴 선택
		int choice = 0;
//		관리자 매뉴 선택
		int adminchoice = 0;
//		관리자 매뉴 비밀번호
		String adminPass = "";
//		금일 매출
		int todayTotal = 0;
		while (!power) {
			admin = false;
			System.out.println("\n매뉴를 선택해주세요");
			System.out.println("0. 자판기에 돈넣기\t 1.음료결제\t 2. 잔돈반환  99.종료");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.print("자판기 안에 돈을 넣어주세요. : ");
				money += sc.nextInt();
				System.out.println("\n현제 자판기 안에 돈은 "+ money+"원입니다.");
				break;
			
			case 1 :
				System.out.println("\n결제하실 음료를 선택해주세요.");
				for (int i = 0; i < dNameStrings.length; i++) {
					System.out.print(i+1+"번 "+dNameStrings[i]+"("+dPrice[i]+"원) ");
				}
				dChoice = sc.nextInt();
				switch (dChoice) {
				case 1:
					if(dAmount[0] != 0 && dPrice[0] <= money) {
						System.out.println(dNameStrings[0]+"한개 결제되었습니다.");
						charge += dPrice[0];
						money -= dPrice[0];
						dAmount[0]--;
						dCount[0]++;
						System.out.println("잔액은 "+ money+"원 입니다.");
					}else if(dAmount[0] == 0) {
						System.out.println("재고가 떨어졌습니다 다음에 이용해주세요.");
					}else {
						System.out.println("결제 금액이 부족합니다. 추가결제 해주세요 -->0\n부족한 금액 : "+(dPrice[0]-money)+"원");
					}
					
					break;
				case 2:
					if(dAmount[1] != 0 && dPrice[1] <= money) {
						System.out.println(dNameStrings[1]+"한개 결제되었습니다.");
						charge += dPrice[1];
						money -= dPrice[1];
						dAmount[1]--;
						dCount[1]++;
						System.out.println("잔액은 "+ money+"원 입니다.");
					}else if(dAmount[1] == 0) {
						System.out.println("재고가 떨어졌습니다 다음에 이용해주세요.");
					}else {
						System.out.println("결제 금액이 부족합니다. 추가결제 해주세요 -->0\n부족한 금액 : "+(dPrice[1]-money)+"원");
					}
					
					break;
				case 3:
					if(dAmount[2] != 0 && dPrice[2] <= money) {
						System.out.println(dNameStrings[2]+"한개 결제되었습니다.");
						charge += dPrice[2];
						money -= dPrice[2];
						dAmount[2]--;
						dCount[2]++;
						System.out.println("잔액은 "+ money+"원 입니다.");
					}else if(dAmount[2] == 0) {
						System.out.println("재고가 떨어졌습니다 다음에 이용해주세요.");
					}else {
						System.out.println("결제 금액이 부족합니다. 추가결제 해주세요 -->0\n부족한 금액 : "+(dPrice[2]-money)+"원");
					}
					break;
				default:
					break;
				}
				break;
			case 2 :
				if(money != 0) {
					System.out.println("이용해주셔서 감사합니다. 잔돈은 "+money+"원 입니다.");
					charge -= money;
					money = 0;
				}else {
					System.out.println("잔액이 없습니다. 이용해주셔서 감사합니다.");
				}
				break;
				
			case 77 :
				adminPass = sc.next();
				if(adminPass.equals("admin01")) {
					System.out.println("========================================");
					System.out.println("관리자모드로 변경합니다.");
					while (!admin) {
						System.out.println("1. 재고수정  2. 재품변경  3. 금일매출  4. 가격변경  5. 종료");
						adminchoice = sc.nextInt();
						switch(adminchoice) {
							case 1:
								System.out.println("재고를 수정하실 재품의 번호를 입력해주세요.");
								System.out.print("0. 취소  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"(재고 : "+ dAmount[i]+")  ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice == 0) {
									System.out.println("수정을 취소합니다.");
									break;
								}
								System.out.println("수정하실 재고개수를 입력해주세요.");
								dAmount[adminchoice-1] =  sc.nextInt();
								System.out.println("재고가 수정되었습니다.");
								break;
							case 2:
								System.out.println("변경하실 재품의 번호를 입력해주세요.");
								System.out.print("0. 취소  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"   ");
								}
								adminchoice = sc.nextInt();
								System.out.println("변경하실 재품의 이름을 입력해주세요.");
								sc.nextLine();
								if(adminchoice == 0) {
									System.out.println("변경을 취소합니다.");
									break;
								}
								dNameStrings[adminchoice-1] = sc.nextLine();
								System.out.println("재품의 이름이 수정되었습니다 재고를 다시 채워주세요.");
								break;
							case 3:
								for (int i = 0; i < dCount.length; i++) {
									todayTotal += dCount[i] * dPrice[i];
									System.out.print(dNameStrings[i]+"팔린개수 : "+dCount[i]+"   ");
								}
								System.out.println("\n금일 매출액은 "+todayTotal+"원 입니다.");
								
								todayTotal = 0;
								break;
							case 4:
								System.out.println("변경하실 재품의 번호를 입력해주세요.");
								System.out.print("0. 취소  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"("+dPrice[i]+"원)   ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice == 0) {
									System.out.println("변경을 취소합니다.");
								}
								System.out.println("변경하실 금액을 입력해주세요. ");
								dPrice[adminchoice-1] = sc.nextInt();
								System.out.println("변경이 완료됬습니다.");
								break;
							case 5:
								admin = !admin;
								System.out.println("관리자 모드를 종료합니다.");
								break;
							default: 
								System.out.println("해당 매뉴얼은 개발중입니다.");
						}	// 관리자 switch 종료
					}		// 관리자 while 종료
				}
				break;
			case 99 :
				power = !power;
				break;
			default:
				System.out.println("다른 매뉴는 개발중입니다.");
				break;
			}		//사용자 switch종료
		}			//자판기 종료
		
		System.out.println("작동을 정지합니다.");
	}
}