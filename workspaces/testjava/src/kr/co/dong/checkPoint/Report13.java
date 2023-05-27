package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13 {

	public static void main(String[] args) {
//		dName,  dPrice, dAmount
//		음료는 3가지
		boolean power = false;
		String[] dName = {"콜라","사이다","물"};	//음료 이름
		int[] coin = {1000,500,100,50,10};		//동전 이름
		int[] dPrice = {700, 500, 300};		//음료 가격
		int[] dAmount = {1, 1, 1};		//음료 재고수
		int pay = 0;		//사용자 금액
		int change = 10000;		//자판기 거스름돈
		int sel = 0;		//자판기 번호 선택
		int password = 1019;	//관리자 모드 비밀번호
		int dChange = 0;	//거스름돈 채우기
		Scanner scan = new Scanner(System.in);
		
		
		while(!power) {		//자판기 시작
			System.out.println("==========Menu==========");
			System.out.println("1.결제 금액투입 2."+dName[0] + dPrice[0]+ " 남은개수:"+dAmount[0]+ " 3."+dName[1] + dPrice[1] +" 남은개수:"+dAmount[1]+ " 4." +dName[2] + dPrice[2]+" 남은개수:"+dAmount[2]+ "\n5.거스름돈 99.자판기종료" );
			System.out.println("남은 금액 : "+pay+"원");
			System.out.print("원하시는 서비스 번호를 입력하세요 : ");
			sel = scan.nextInt();
			switch(sel) {
			case 1:		//금액 입력
				System.out.print("원하시는 금액을 투입하세요 : ");
				pay += scan.nextInt();
				System.out.println("남은 금액 : "+pay+"원");
				break;
			case 2:		//첫번째 음료
				if(dAmount[0] == 0) {
					System.out.println("해당 음료는 재고가 없습니다.\n다른 음료를 선택해주세요.");
				}
				if(pay >= dPrice[0] && dAmount[0] > 0) {
					System.out.println("***"+dName[0]+"***");
					pay -= dPrice[0];
					dAmount[0]--;
					}else if(pay < dPrice[0]) {
					System.out.println("금액이 "+(dPrice[0]-pay)+"원 부족합니다. \n자판기의 1번을 눌러 추가 금액을 넣어주세요.");
					}
				break;
			case 3:		//두번째 음료
				if(dAmount[1] == 0) {
					System.out.println("해당 음료는 재고가 없습니다.\n다른 음료를 선택해주세요.");
				}
				if(pay >= dPrice[1] && dAmount[1] > 0) {
					System.out.println("***"+dName[1]+"***");
					pay -= dPrice[1];
					dAmount[1]--;
					}else if(pay < dPrice[1]) {
					System.out.println("금액이 "+(dPrice[1]-pay)+"원 부족합니다. \n자판기의 1번을 눌러 추가 금액을 넣어주세요.");
					}
				break;
			case 4:		//세번째 음료
				if(dAmount[2] == 0) {
					System.out.println("해당 음료는 재고가 없습니다.\n다른 음료를 선택해주세요.");
				}
				if(pay >= dPrice[2] && dAmount[2] > 0) {
					System.out.println("***"+dName[2]+"***");
					pay -= dPrice[2];
					dAmount[2]--;
					}else if(pay < dPrice[2]) {
					System.out.println("금액이 "+(dPrice[2]-pay)+"원 부족합니다. \n자판기의 1번을 눌러 추가 금액을 넣어주세요.");
					}
				break;
			case 5:		//거스름돈
				if(change >= pay) {
					change -= pay;
					System.out.println("거스름돈 : " + pay+"원");
					for(int i=0;i<coin.length;i++) {	//동전
						int tmp = 0;
						tmp = pay/coin[i];
						pay -= coin[i] * tmp; 
						System.out.println(coin[i]+"원:"+tmp+"개");
					}	//for문 끝
					pay = 0;
				}
				break;
			case 77:	//관리자 모드
				System.out.print("비밀번호 입력 : ");
				password = scan.nextInt();
				if(password == 1019) {
					while(sel != 5) {
						System.out.println("=====관리자 메뉴=====");
						System.out.println("1.재고수 변경 2.음료가격 변경 3.음료 변경 4.잔돈 충전 5.관리자 모드 종료");
						System.out.print("원하는 작업 번호를 입력하세요 : ");
						sel = scan.nextInt();
						switch(sel) {
						case 1:		//재고수 변경
							System.out.println("===재고수 변경===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.뒤로가기");
							System.out.print("재고수 변경할 음료수 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {	//재고수 변경(음료선택)
							case 1:
								System.out.print("변경할 개수 입력 : ");
								dAmount[0] = scan.nextInt();
								System.out.println("변경된 재고수 : "+dAmount[0]);
								break;
							case 2:
								System.out.print("변경할 개수 입력 : ");
								dAmount[1] = scan.nextInt();
								System.out.println("변경된 재고수 : "+dAmount[1]);
								break;
							case 3:
								System.out.print("변경할 개수 입력 : ");
								dAmount[2] = scan.nextInt();
								System.out.println("변경된 재고수 : "+dAmount[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 2:	//음료가격 변경
							System.out.println("===음료가격 변경===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.뒤로가기");
							System.out.print("가격을 변경할 음료수 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {//음료가격 변경(음료선택)
							case 1:
								System.out.print("변경할 금액 입력 : ");
								dPrice[0] = scan.nextInt();
								System.out.println("변경된 금액 : "+dPrice[0]);
								break;
							case 2:
								System.out.print("변경할 금액 입력 : ");
								dPrice[1] = scan.nextInt();
								System.out.println("변경된 금액 : "+dPrice[1]);
								break;
							case 3:
								System.out.print("변경할 금액 입력 : ");
								dPrice[2] = scan.nextInt();
								System.out.println("변경된 금액 : "+dPrice[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 3:		//음료 교체
							System.out.println("===음료 변경===");
							System.out.println("1."+dName[0]+ " 2."+dName[1]+ " 3."+dName[2]+ " 4.뒤로가기");
							System.out.print("교체할 음료수 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {	//음료 교체(음료 선택)
							case 1:
								System.out.print("교체할 음료이름 입력 : ");
								scan.nextLine();
								dName[0] = scan.nextLine();
								System.out.println("교체된 음료 : "+dName[0]);
								break;
							case 2:
								System.out.print("교체할 음료이름 입력 : ");
								scan.nextLine();
								dName[1] = scan.nextLine();
								System.out.println("교체된 음료 : "+dName[1]);
								break;
							case 3:
								System.out.print("교체할 음료이름 입력 : ");
								scan.nextLine();
								dName[2] = scan.nextLine();
								System.out.println("교체된 음료 : "+dName[2]);
								break;
							case 4:
								System.out.println();
								break;
							}
							break;
						case 4:
							System.out.println("===잔돈 충전===");
							System.out.println("현재 잔액 : "+change);
							System.out.print("충전할 금액 입력 : ");
							dChange = scan.nextInt();
							change += dChange;
							System.out.println("총 잔돈 : "+change+"원");
						case 5:
							System.out.println("관리자 모드 종료");
							break;
						}	//관리자 switch문 끝
					}	//관리자 while문 끝
				}//관리자 if문 끝
				break;
			case 99:	//자판기 종료
				power = true;
				break;
			default :	//없는 번호 입력
				System.out.println("=====잘못된 접근=====\n다시 선택해주세요.");
			
			}	//스위치문 끝
			
		}	//while문 끝
		System.out.println("자판기 종료");
	}
}
