package kr.co.dong.checkPoint;

import java.util.Scanner;

import javax.naming.CompoundName;

public class Report09 {
	public static void main(String[] args) {
//		배열명 : dName, dPrice, dAmount 
//		음료의 종류 : 3가지
		
//		1. 선언
		
		String[] dName = {"아메리카노", "라떼", "밀크티"};
		int[] dPrice = {1500, 2000, 1000};
		int[] dAmount = {1, 10, 5};
	
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
			System.out.println("=============< MENU >=============");
			System.out.println(" 	 0.결제 1.음료 선택");
			System.out.println("----------------------------------");
			System.out.println(" 10.거스름돈 반환  11.재고  99.종료");	//관리자모드 : 77
			System.out.println("==================================");
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
				
			case 1:
				boolean beverageMenu = false; 
				int choiceBeverage = 0;
				
					while(!beverageMenu) {
						System.out.println();
						System.out.println("=========================<BEVERAGE>=========================");
						System.out.println("0.취소");
						System.out.println("1." + dName[0] + "(" + dPrice[0] + "원, " + dAmount[0] + "개) 2." + dName[1] + "(" + dPrice[1] + "원, " + dAmount[1] + "개) 3." + dName[2] + "(" + dPrice[2] + "원, " + dAmount[2] + "개)");
						
//						for(int i=0; i<dName.length; i++) {
//						System.out.println((i+1) + "." + dName[i] + "(" + dPrice[i] + ") " + "(재고: " + dAmount[i] + ")");
//						}
						System.out.println("============================================================ ");
						System.out.println();
						System.out.println("음료를 선택하세요. > ");
						choiceBeverage = scan.nextInt();
						
						switch (choiceBeverage) {
							
						case 0 :
							beverageMenu = true;
							System.out.println("이전화면으로 돌아갑니다.");
							break;
							
						case 1: case 2: case 3:
							if(dAmount[choiceBeverage-1] ==0) {
								System.out.println("재고가 부족합니다.");
								break;
							}
							
							else if(inputMoney<dPrice[choiceBeverage-1]) {
								System.out.println("금액이 부족합니다. > 0.결제");
								
							} else if(inputMoney>dPrice[choiceBeverage-1] && dAmount[choiceBeverage-1]!=0) {		//dAmount[0]>0
								System.out.println("선택하신 음료가 나옵니다.");
								dAmount[choiceBeverage-1]--;
								inputMoney = inputMoney-dPrice[choiceBeverage-1];
								System.out.println("현재 자판기 안의 금액은 " + inputMoney + "원 입니다.");
								beverageMenu = true;
								break;
							}
							
							break;
						
						default:
							System.out.println("번호를 다시 선택하세요.");
							break;
							
						}
					}
					
					break;
				
			case 10:	
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
				String setUp1 = "음료 변경", setUp2 = "가격 변경", setUp3 = "재고수량 변경";
				
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
							int menuSetup = 0;
								
							System.out.println();
							System.out.println("< 음료 변경 >------------------------------");
							System.out.println("0.취소 1." + dName[0] + " 2." + dName[1] + " 3." + dName[2]);
							System.out.println("-----------------------------------------");
							System.out.print("변경할 음료를 선택하세요. > ");
							menuSetup = scan.nextInt();
							
							boolean Change1 = false;
							while(!Change1) {
								switch (menuSetup) {
								case 0:
									System.out.println("> 이전 화면으로 돌아갑니다.");
									Change1 = true;
									
									break;
									
								case 1: case 2: case 3:
										System.out.print(menuSetup + ". " + dName[menuSetup-1] + "를 변경하세요. > ");
										dName[menuSetup-1] = scan.next();
										System.out.println();
										System.out.println("변경된 " +menuSetup + "번 음료는 " + dName[menuSetup-1] + "입니다.");
										
										dAmount[menuSetup-1] = 0;
										System.out.print("변경된 음료의 재고를 설정하세요. > ");
										dAmount[menuSetup-1] = scan.nextInt();
										System.out.println("현재 " + dName[menuSetup-1] + "의 재고수량은 " + dAmount[menuSetup-1] + "개 입니다.");

										System.out.println();
										System.out.println("> 이전 화면으로 돌아갑니다.");
										Change1 = true;
										
										break;
//								
								default:
									System.out.println("번호를 다시 입력하세요.");
									break;

								}
							}
							break;
							
						case 2:
							int priceSetup = 0;
							
							System.out.println();
							System.out.println("< 음료 가격 변경 >-----------------------------------------------");
							System.out.println("0.취소 1." + dName[0] + "(" + dPrice[0] + "원) 2." + dName[1] + "(" + dPrice[1] + "원) 3." + dName[2] + "(" + dPrice[2] + "원)");
							System.out.println("--------------------------------------------------------------");
							System.out.print("가격을 변경 할 음료를 선택하세요. > ");
							priceSetup = scan.nextInt();

							boolean change2 = false;
							while(!change2) {
								switch (priceSetup) {
								case 0:
									System.out.println("> 이전 화면으로 돌아갑니다.");
									change2 = true;
									break;
							
								case 1: case 2: case 3:
									System.out.print(dName[priceSetup-1] + "(" + dPrice[priceSetup-1] + "원)의 가격을 설정하세요. > ");
									dPrice[priceSetup-1] = scan.nextInt();
									System.out.println();
									System.out.println(dName[priceSetup-1] + "의 변경된 가격은 " + dPrice[priceSetup-1] + "입니다.");
									
									System.out.println("> 이전 화면으로 돌아갑니다.");
									change2 = true;
									
									break;

								default:
									System.out.println("번호를 다시 입력하세요.");
									break;
								}
							}
							
							break;
							
						case 3:
							int amountSetup = 0;
							
							System.out.println();
							System.out.println("< 재고수량 변경 >-----------------------------------------------");
							System.out.println("0.취소 1." + dName[0] + "(" + dAmount[0] + "개) 2." + dName[1] + "(" + dAmount[1] + "개) 3." + dName[2] + "(" + dAmount[2] + "개)");
							System.out.println("-------------------------------------------------------------");
							System.out.print("재고수량을 변경 할 음료를 선택하세요. > ");
							amountSetup = scan.nextInt();
							
							boolean change3 = false;
							while(!change3) {
								switch (amountSetup) {
								case 0:
									System.out.println("> 이전 화면으로 돌아갑니다.");
									change3 = true;
									break;
									
								case 1: case 2: case 3:
									System.out.print(dName[amountSetup-1] + "(" + dAmount[amountSetup-1] + "개)의 재고를 설정하세요. > ");
									dAmount[amountSetup-1] = scan.nextInt();
									System.out.println();
									System.out.println(dName[amountSetup-1] + "의 변경된 재고수량은 " + dAmount[amountSetup-1] + "입니다.");
									
									System.out.println("이전 화면으로 돌아갑니다.");
									change3 = true;
									
									break;
									
								default:
									System.out.println("번호를 다시 입력하세요.");
									break;
								}
								
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
				break;
				

			default:
				System.out.println("메뉴를 다시 선택해 주세요.");
				break;
			}
		}
			System.out.println("자판기를 종료합니다.");
	}
}
