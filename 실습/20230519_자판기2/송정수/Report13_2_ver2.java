package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report13_2_ver2 {
	public static void main(String[] args) {
//		dName,  dPrice, dAmount
//		음료는 3가지
		boolean power = false;	//자판기 전원
		boolean admin = false;	//관리자 전원
		String[] dName = {"제로펩시","트래비","몬스터"};	//음료 이름
		int[] coin = {5000,1000,500,100,50,10};		//동전 이름
		int[] dPrice = {1500, 1000, 2500};		//음료 가격
		int[] dAmount = {3, 3, 3};		//음료 재고수
		int pay = 0;		//사용자 금액
		int change = 10000;		//자판기 거스름돈
		int sel = 0;		//자판기 번호 선택
		int password = 1019;	//관리자 모드 비밀번호
		int dChange = 0;	//거스름돈 채우기
		Scanner scan = new Scanner(System.in);
		
		while(!power) {		//자판기 시작
			admin = false;
			System.out.println("==========Menu==========");
			System.out.print("1.결제 금액투입 2.음료 메뉴 불러오기");
			System.out.println("\n5.거스름돈 99.자판기종료");
			System.out.println("남은 금액 : "+pay+"원");
			System.out.print("원하시는 서비스 번호를 입력하세요 : ");
			sel = scan.nextInt();
			switch(sel) {
			case 1:		//금액 입력
				System.out.print("원하시는 금액을 투입하세요 : ");
				pay += scan.nextInt();
				System.out.println("남은 금액 : "+pay+"원");
				break;
			case 2:		//음료메뉴
				for(int i=0;i<dName.length;i++) {
					System.out.println(i+1+"."+dName[i]+dPrice[i]+" 남은개수:"+dAmount[i]+" ");
				}
				System.out.println("뒤로 가실려면 음료번호 이외의 번호를 입력하세요.");
				System.out.print("원하시는 음료번호를 입력하세요 : ");
				sel = scan.nextInt();
				if(sel > dName.length) {
					System.out.println("뒤로 이동합니다.");
				break;
				}
				if(dAmount[sel-1] == 0) {
					System.out.println("해당 음료는 재고가 없습니다.\n다른 음료를 선택해주세요.");
				}
				 else if(dPrice[sel-1] <= pay && dAmount[sel-1] > 0) {
					System.out.println(dName[sel-1]);
					pay -= dPrice[sel-1];
					dAmount[sel-1]--;
				}else if(pay < dPrice[sel-1]) {
					System.out.println("금액이 "+(dPrice[sel-1]-pay)+"원 부족합니다. \n자판기의 1번을 눌러 추가 금액을 넣어주세요.");
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
				}	// if문 끝
				else if(change < pay) {
					System.out.println("자판기의 잔돈이 부족하여 거스름돈이 나오지 않습니다.\n붙어있는 번호에 문의해주세요.");
				}
				break;
			case 77:	//관리자 모드
				System.out.print("비밀번호 입력 : ");
				password = scan.nextInt();
				if(password == 1019) {
					while(!admin) {
						System.out.println("=====관리자 메뉴=====");
						System.out.println("1.재고수 변경 2.음료가격 변경 3.음료 변경 4.잔돈 충전 5.관리자 모드 종료");
						System.out.print("원하는 작업 번호를 입력하세요 : ");
						sel = scan.nextInt();
						switch(sel) {
						case 1:		//재고수 변경
							System.out.println("===재고수 변경===");
							System.out.println("1.음료 메뉴 불러오기 2~99.뒤로가기");
							System.out.print("원하는 작업 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {	
							case 1:		//음료메뉴
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.뒤로이동\n재고수 변경할 음료수 번호를 입력하세요 : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("뒤로 이동합니다.");
									break;
								}
								System.out.println("현재 재고수 : "+dAmount[sel-1]+"\n추가할 개수를 입력하세요 : ");
								dAmount[sel-1] += scan.nextInt();
								System.out.println("변경된 개수 : "+dAmount[sel-1]);
								break;
							}	//switch문 끝
							break;
						case 2:	//음료가격 변경
							System.out.println("===음료가격 변경===");
							System.out.println("1.음료 메뉴 불러오기 2~99.뒤로가기");
							System.out.print("원하는 작업 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {	
							case 1:		//음료메뉴
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.뒤로 이동\n가격을 변경할 음료수 번호를 입력하세요 : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("뒤로 이동합니다.");
									break;
								}
								System.out.println("변경할 가격을 입력하세요 : ");
								dPrice[sel-1] = scan.nextInt();
								System.out.println("변경된 가격 : "+dPrice[sel-1]);
								break;
							}	//switch문 끝
							break;
						case 3:		//음료 교체
							System.out.println("===음료 교체===");
							System.out.println("1.음료 메뉴 불러오기 2~99.뒤로가기");
							System.out.print("원하는 작업 번호를 입력하세요 : ");
							sel = scan.nextInt();
							switch(sel) {	//음료 교체(음료 선택)
							case 1:
								for(int i=0;i<dName.length;i++) {
									System.out.print(i+1+"."+dName[i]+" ");
								}
								System.out.print(dName.length+1+"~99.뒤로 이동\n교체할 음료수 번호를 입력하세요 : ");
								sel = scan.nextInt();
								if(sel > dName.length) {
									System.out.println("뒤로 이동합니다.");
									break;
								}
								System.out.println("교체할 음료이름을 입력하세요 : ");
								scan.nextLine();
								dName[sel-1] = scan.nextLine();
								System.out.println("변경된 음료이름 : "+dName[sel-1]);
								dAmount[sel-1] = 0;
								break;
							}	//switch문 끝
							
							break;
						case 4:		//잔돈 충전
							System.out.println("===잔돈 충전===");
							System.out.println("현재 잔액 : "+change+"원");
							System.out.println("뒤로 이동하실려면 0원을 넣으세요.");
							System.out.print("충전할 금액 입력 : ");
							dChange = scan.nextInt();
							change += dChange;
							System.out.println("총 잔돈 : "+change+"원");
							break;
						case 5:		//관리자 모드 종료
							if(sel == 5) {
								admin = true;
							System.out.println("관리자 모드 종료");
							}
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
			}	//메인 스위치문 끝
		}	//메인 while문 끝
		System.out.println("자판기 종료");
	}
}
