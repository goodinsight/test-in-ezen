package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report14 {

	public static void main(String[] args){
//		자판기 작동여부
		boolean power = false;
//		관리자 모드 작동여부
		boolean admin = false;
		
		Scanner sc = new Scanner(System.in);
//		자판기에 넣는 금액
		int money = 0;
//		음료명
		String[] dNameStrings = {"제로팹시","밀키스","포카리스웨트","사이다"};
//		음료명 복사본
		String[] dNameStringsclone;
//		음료 가격 복사본
		int[] dPriceclone;
//		음료 재고개수 복사본
		int[] dAmountclone;
//		음료 팔린개수 복사본
		int[] dCountclone;
//		음료 가격
		int[] dPrice = {2000,1500,1000,500};
//		음료 재고
		int[] dAmount = {10,10,10,10};
//		자판기 안의 잔액
		int charge = 100000;
//		음료 선택번호
		int dChoice = 0;
		int choice = 0;
//		관리자 매뉴 선택
		int adminchoice = 0;
//		관리자 매뉴 비밀번호 == admin01
		String adminPass = "";
//		금일 매출
		int todayTotal = 0;
//		금일 음료의 판매 개수
		int[] dCount = {0,0,0,0};
//		매뉴 추가
		String newmenu = "";
//		자판기 금액 추가
		int chargeplus = 0;
		while (!power) {
			System.out.println("매뉴를 선택해주세요");
			System.out.println("0. 자판기에 돈넣기\t 1.음료결제 \t 2. 잔돈반환  99.종료");
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
					System.out.println(i+1+"번 "+dNameStrings[i]+"("+dPrice[i]+"원)재고 : "+dAmount[i]+"개   ");
				}
				dChoice = sc.nextInt();
						if(dChoice > dNameStrings.length) {
							System.out.println("해당 매뉴는 아직 없는매뉴입니다.");
						}else if(dPrice[dChoice-1]<=money && dAmount[dChoice-1] != 0) {
							System.out.println("주문하신 "+ dNameStrings[dChoice-1]+" 나왔습니다.");
							charge += dPrice[dChoice-1];
							money -= dPrice[dChoice-1];
							dAmount[dChoice-1]--;
							dCount[dChoice-1]++;
							System.out.println("잔액은 "+money+"원 입니다.");
						}else if(dAmount[dChoice-1] == 0) {
							System.out.println("선택해주신 음료는 재고가 없습니다 다음에 이용해주세요.");
						}else if(money<dPrice[dChoice-1]){
							System.out.println("결제금액이 부족합니다 자판기에 돈을 더 넣어주세요 : "+(dPrice[dChoice-1] - money)+"원");
						}
			break;
			case 2 :
				if(charge == 0) {
					System.out.println("자판기안의 잔액이 없습니다 관리자에게 문의해주세요.");
				}else if(money != 0) {
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
						System.out.println("1. 재고수정  2. 재품변경  3. 금일매출  4. 가격변경  5. 재고확인\n6. 매뉴추가   7. 자판기 금액 조회   8. 자판기 금액 충전   9. 종료");
						adminchoice = sc.nextInt();
						switch(adminchoice) {
							case 1:
								System.out.println("재고를 수정하실 재품의 번호를 입력해주세요.");
								System.out.print("0. 취소  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"(재고 : "+ dAmount[i]+")  ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice > dAmount.length) {
									System.out.println("매뉴얼의 숫자는 1~"+dAmount.length+"번만 눌러주세요.\n관리자모드로 돌아갑니다.");
									break;
								}else if(adminchoice == 0) {
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
								if(adminchoice > dNameStrings.length) {
									System.out.println("매뉴얼의 숫자는 1~"+dNameStrings.length+"번만 눌러주세요.\n관리자모드로 돌아갑니다.");
									break;
								}
								System.out.println("변경하실 재품의 이름을 입력해주세요.");
								sc.nextLine();
								if(adminchoice == 0) {
									System.out.println("변경을 취소합니다.");
									break;
								}
								dNameStrings[adminchoice-1] = sc.nextLine();
								System.out.println("재품이 변경되었습니다 재고를 다시 채워주세요. --> 매뉴얼 1번");
								dAmount[adminchoice-1] = 0;
								break;
							case 3:
								for (int i = 0; i < dCount.length; i++) {
									todayTotal = dCount[i] * dPrice[i];
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
								if(adminchoice > dPrice.length) {
									System.out.println("매뉴얼의 숫자는 1~"+dPrice.length+"번만 눌러주세요.\n관리자모드로 돌아갑니다.");
									break;
								}else if(adminchoice == 0) {
									System.out.println("변경을 취소합니다.");
									break;
								}
								System.out.println("변경하실 금액을 입력해주세요. ");
								dPrice[adminchoice-1] = sc.nextInt();
								System.out.println("변경이 완료됬습니다.");
								break;
							case 5:
								for (int i = 0; i < dAmount.length; i++) {
									System.out.print(i+1+"."+dNameStrings[i]+"(재고개수 : "+dAmount[i]+"개)   ");
								}
								System.out.println("\n");
								break;
							case 6:
								
								System.out.println("추가하실 매뉴를 입력해주세요.\n매뉴추가를 취소하고 싶으시면 0번을 눌러주세요.");
								sc.nextLine();
								newmenu = sc.nextLine();
								if(newmenu.equals("0")) {
									System.out.println("관리자매뉴로 돌아갑니다.");
									break;
								}
								dNameStringsclone = dNameStrings.clone();
								dPriceclone = dPrice.clone();
								dAmountclone = dAmount.clone();
								dCountclone = dCount.clone();
								dNameStrings = new String[dNameStrings.length+1];
								dAmount = new int[dAmount.length+1];
								dCount = new int[dCount.length+1];
								dPrice = new int[dPrice.length+1];
								for (int i = 0; i < dNameStringsclone.length; i++) {
									dNameStrings[i] = dNameStringsclone[i];
									dAmount[i] = dAmountclone[i];
									dPrice[i] = dPriceclone[i];
									dCount[i] = dCountclone[i];
								}
								dNameStrings[dNameStringsclone.length] = newmenu;
								System.out.println("추가하신 매뉴의 가격을 설정해주세요.");
								dPrice[dPriceclone.length] = sc.nextInt();
								System.out.println("매뉴가 추가되었습니다 해당매뉴의 재고를 추가해주세요. -->1");
								break;
								
							case 7:
								System.out.println("현재 자판기 안에 잔액은 "+charge+"원 입니다.");
								break;
							case 8:
								System.out.print("충전하실 금액을 입력해주세요 : ");
								chargeplus = sc.nextInt();
								charge += chargeplus;
								System.out.println("충전이 완료됬습니다 현재 자판기안에 잔액은 "+charge+"원입니다.");
								break;
							case 9:
								admin = !admin;
								System.out.println("관리자 모드를 종료합니다.");
								System.out.println("==========================================================");
								break;
							default: 
								System.out.println("해당 매뉴얼은 개발중입니다.");
						}	// 관리자 switch 종료
					}		// 관리자 while 종료
					admin = false;
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
		sc.close();
	}
}