package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report21 {
	
	public static void main(String[] args) {
		
//	Report21_d item1 = new Report21_d(); // 자판기 아이템 생성을 함
//	Report21_d item2 = new Report21_d(); 
//	Report21_d item3 = new Report21_d(); 
//	Report21_d item4 = new Report21_d(); 
	
//	item1.dName ="Coke";
//	item1.dAmount = 15;
//	item1.dPrice = 1200;
//			
//	item2.dName ="Juice";
//	item2.dAmount = 20;
//	item2.dPrice = 1500;
//		
//	item3.dName = "Energy Drink";
//	item3.dAmount = 20;
//	item3.dPrice = 2000;
//		
//	item4.dName = "Jin Tonic"; // 원래는 음료 종류 3개를 하라고 하셨지만 내가 손에 익을때까지 쳐봐야 되는거 같아서 항목을 4개로 찍음
//	item4.dAmount = 15;
//	item4.dPrice = 5000; // 이건 짝한테 물어보니까 배열로 표현해야한다고 함 복습했다고 치면 좋을듯
		
		
	String[] dName = { "Coke", "Juice", "Energy Drink", "Jin Tonic"};
	String[] dNum = { "①", "②", "③", "④"}; // 이건 내가 출력할 때 편의성을 가지려고 선언한 품목임
	int[] dAmount = { 15, 20, 20, 15};
	int[] dPrice = { 1200, 1500, 2000, 5000};
	int vCash = 100000; // 시재 개념을 탑재 하는것도 생각해두자
	int coin = 0; // 동전은 일단 선언
	int sel = 0; // 메뉴 선택
	boolean power = false; // 전원 조건부
	
	System.out.println("Hi I'm vending machine :) ================ | 현재 제공중인");
	System.out.println("========================================== | 품목들 입니다");
	System.out.println(dNum[0]+". "+dName[0] + " : "  + dPrice[0] + " won ============ X " + dAmount[0] + " ===== | 사용을 원하시면");
	System.out.println(dNum[1]+". "+dName[1] + " : " + dPrice[1] + " won =========== X " + dAmount[1] + " ===== | 동전을 투입");
	System.out.println(dNum[2]+". "+dName[2] + " : " + dPrice[2] + " won ==== X " + dAmount[2] + " ===== | (입력)해주세요");
	System.out.println(dNum[3]+". "+dName[3] + " : " + dPrice[3] + " won ======= X " + dAmount[3] + " ===================");		
	System.out.println("========================================================");
	System.out.print("입력 = \r");
	
	// _4 버전 업데이트 사항 - 선언을 통해서 입력하는 방식에서 배열에다가 값을 넣는 방식으로 변경 됨
	
	// 어제 조퇴해가지고 살짝 밀린 진도가 있어서 시간이 부족했는데 Ctrl + 2 ,r 로 선언 한 것을 쉽게 교체를 할 수 있었음
	
	Scanner sc = new Scanner(System.in);
	
	while(!power) {
		
		coin += sc.nextInt();
		
		if((dAmount[0]+dAmount[1]+dAmount[2]+dAmount[3])==0){
			System.out.println("======= 투입된 금액 " + coin + "won 이 반환 됩니다. =======");
			coin-=coin;
			System.out.println("현재 기기에 투입 되어있는 금액은" + coin +"입니다.");
			System.out.println("재고 부족으로 기기 전원이 종료됩니다.");
			power = true;
		}else if(coin>=10){
			System.out.println("투입 된 금액은 현재 " + coin + " won 입니다.\r");			
			System.out.println("해당 기기는 투입한 금액에 해당되는 제품이 표시됩니다.\r");			
			
				for(int i=0; i<dName.length; i++) {
					
					if(coin >= dPrice[i]){
						System.out.print(dNum[i] + " "+ dName[i]+" ");
						
					}
					
					
				
		}
		
		
//			System.out.println("① "+ dName[0] + " ② " + dName[1] + " ③ " + dName[2] + " ④ "+ dName[3] + " ⑤ 잔돈 반환 ");
		
		}
		
		
		sel = sc.nextInt();
		
		switch(sel) {
					
			case 1:
							
				if (coin<dPrice[0]) {
					System.out.println("=================== 잔액이 부족합니다 ===================");
					System.out.println("============= 투입한 금액" +coin+ " won 이 반환 됩니다.=============");
					
					coin-=coin;
					
								
				}else if(dAmount[0] == 0) {
					System.out.println("선택하신 음료의 재고가 없습니다.");
					System.out.println("투입 된 금액은 현재 " + coin + "입니다.");
					
				}else{
				dAmount[0] -= 1; coin-=dPrice[0];
					System.out.println("선택하신 음료"+dName[0]+"가 곧 제공됩니다. ===== - 재고 "+dAmount[0]);
					System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
				}
			
				break;
				
	
			case 2:
				
				if (coin<dPrice[1]) {
					System.out.println("=================== 잔액이 부족합니다 ===================");
					System.out.println("============= 투입한 금액 " +coin+ " won 이 반환 됩니다.=============");
								
				}else if(dAmount[1] <= 0) {
					System.out.println("선택하신 음료의 재고가 없습니다.");
					
				}else{
				dAmount[1] -= 1; coin-=dPrice[1];
					System.out.println("선택하신 음료"+dName[1]+"가 곧 제공됩니다. ===== - 재고 "+dAmount[1]);
					System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
				}
				
				break;
		case 3:
			if (coin<dPrice[2]) {
				System.out.println("=================== 잔액이 부족합니다 ===================");
				System.out.println("============= 투입한 금액 " +coin+ " won 이 반환 됩니다.=============");
								
				}else if(dAmount[2] <= 0) {
					System.out.println("선택하신 음료의 재고가 없습니다.");
					
				}else{
				dAmount[2] -= 1; coin-=dPrice[2];
					System.out.println("선택하신 음료"+dName[2]+"가 곧 제공됩니다. ===== - 재고 "+dAmount[2]);
					System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
				}
			break;
		case 4:
			if (coin<dPrice[3]) {
				System.out.println("=================== 잔액이 부족합니다 ===================");
				System.out.println("============= 투입한 금액 " +coin+ " won 이 반환 됩니다.=============");
								
				}else if(dAmount[3] <= 0) {
					System.out.println("선택하신 음료의 재고가 없습니다.");
					
				}else{
				dAmount[3] -= 1; coin-=dPrice[3];
					System.out.println("선택하신 음료"+dName[3]+"가 곧 제공됩니다. ===== - 재고 "+dAmount[3]);
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
			
		case 6: 
				sel =0;
				System.out.println("추가 투입 할 금액을 입력 하세요");
				System.out.print("입력 = ");
				coin += sc.nextInt();
				
			break;
		
			
//			
		case 77:// 관리자 모드
			
			System.out.println("관리자 모드에 진입합니다.");
			System.out.println("Password를 입력해주세요.");
			String pswd = sc.next();
			
			if("3002".equals(pswd)) {
				
					boolean adminpower = false; // 관리자 모드 전원
					int tmpNum = 0, swNum = 0;
					String sw = null, tmp = null;
				
				while(!adminpower) {
					
					System.out.println("===============================================");
					System.out.println("==========Administrator Mode Activate==========");
					System.out.println("===============================================");
					System.out.println("1.품목 이름 바꾸기 2.재고 조정. 3. 가격조정 4.관리자모드 나가기");
				
						int admin=sc.nextInt();
				
						switch(admin) { // 어드민 메뉴 접근
				 					 	
						case 1:
					
						System.out.println("품목 이름을 변경합니다. 변경 할 품목을 선택하세요");
						System.out.println("① "+ dName[0] + " ② " + dName[1] + " ③ " + dName[2] + " ④ "+ dName[3]);
									
							int	menu=sc.nextInt();		
							
							switch(menu) { // 어드민 하위 메뉴 1234 접근
					
							case 1: 
								
								System.out.println("품목"+ dName[0]+ "을/를 변경 할 품목명을 입력해주세요.");
								sw = sc.next();
																
								tmp=dName[0];
								dName[0]=sw;
								sw = tmp;
								break;
						
							case 2:
								
								System.out.println("품목"+ dName[1]+ "을/를 변경 할 품목명을 입력해주세요.");
								sw = sc.next();
																	
								tmp=dName[1];
								dName[1]=sw;
								sw = tmp;
								break;
								
							case 3: 
								
								System.out.println("품목"+ dName[2]+ "을/를 변경 할 품목명을 입력해주세요.");
								sw = sc.next();
															
								tmp=dName[2];
								dName[2]=sw;
								sw = tmp;
								break;
								
							case 4:	
								
								System.out.println("품목"+ dName[3]+ "을/를 변경 할 품목명을 입력해주세요.");
								sw = sc.next();
															
								tmp=dName[3];
								dName[3]=sw;
								sw = tmp;
								break;
								
							default:
								break;
							}
							break;
							
						case 2:
							
							System.out.println("품목 재고를 변경합니다. 변경 할 품목의 재고를 선택하세요");
							System.out.println("① "+ dName[0] + " X " + dAmount[0] + " ② " + dName[1] + " X " + dAmount[1] + " ③ " + dName[2] + " X " + dAmount[2] + " ④ "+ dName[3] +" X " + dAmount[3]);
							
							menu=sc.nextInt();	
							
							switch(menu) {
																																						
							case 1:
								
								System.out.println(dName[0] + "의 재고를 변경 할 수량을 입력해주세요. 현재 재고 : "+ dAmount[0]);
								sw = sc.next();
																
								tmpNum =dAmount[0];
								dAmount[0] = swNum;
								swNum = tmpNum;
								break;
								
							case 2:
								
								System.out.println(dName[1] + "의 재고를 변경 할 수량을 입력해주세요. 현재 재고 : "+ dAmount[1]);
								sw = sc.next();
																
								tmpNum =dAmount[1];
								dAmount[1] = swNum;
								swNum = tmpNum;
								break;
								
							case 3:
								
								System.out.println(dName[2] + "의 재고를 변경 할 수량을 입력해주세요. 현재 재고 : "+ dAmount[2]);
								sw = sc.next();
																
								tmpNum =dAmount[2];
								dAmount[2] = swNum;
								swNum = tmpNum;
								break;
								
							case 4:
								
								System.out.println(dName[3] + "의 재고를 변경 할 수량을 입력해주세요. 현재 재고 : "+ dAmount[3]);
								sw = sc.next();
																
								tmpNum =dAmount[3];
								dAmount[3] = swNum;
								swNum = tmpNum;
								break;
						
							default:
								break;
							}
							break;	
							
						case 3:
							
							System.out.println("품목 당 가격을 변경합니다. 변경 할 품목을 선택하세요");
							System.out.println("① "+ dName[0] + " ② " + dName[1] + " ③ " + dName[2] + " ④ "+ dName[3]);
										
							
							menu=sc.nextInt();	
							switch(menu) {
							
								case 1:
								
									System.out.println(dName[0] + "의 변경 할 가격을 입력해주세요. 현재 가격 : "+ dPrice[0]);
									sw = sc.next();
																
									tmpNum =dPrice[0];
									dPrice[0] = swNum;
									swNum = tmpNum;
									break;
									
								case 2:
									
									System.out.println(dName[1] + "의 변경 할 가격을 입력해주세요. 현재 가격 : "+ dPrice[1]);
									sw = sc.next();
																
									tmpNum =dPrice[1];
									dPrice[1] = swNum;
									swNum = tmpNum;
									break;
									
								case 3:
									
									System.out.println(dName[2] + "의 변경 할 가격을 입력해주세요. 현재 가격 : "+ dPrice[2]);
									sw = sc.next();
																
									tmpNum =dPrice[2];
									dPrice[2] = swNum;
									swNum = tmpNum;
									break;
									
								case 4:
									
									System.out.println(dName[3] + "의 변경 할 가격을 입력해주세요. 현재 가격 : "+ dPrice[3]);
									sw = sc.next();
																
									tmpNum =dPrice[3];
									dPrice[3] = swNum;
									swNum = tmpNum;
									break;
									
								default:
									break;
							}
							break;
							
						
						case 4:
							adminpower = true;
							System.out.println("관리자 모드가 종료됩니다.");
							
							break;
					
					}
					break;
							
			}
				
						
					
					
					
				
				// 대충 수정하는 기능들
				
			}else {
				
				System.out.println("Password가 틀렸습니다..!");
				System.out.println("기기 보안을 위하여");
				
				
		}
			System.out.println("관리자 모드가 종료되고 변경사항이 적용됩니다.");
			break;// 관리자 모드의 break;
			
			
		case 99:
			power = true;
			System.out.println("기기 전원이 종료됩니다.");
			
				 
			break;
		
		default:
			System.out.println("잘못 누르셨습니다.");
			break;
		
			
		}	
		
			if (!power) {
			
				System.out.println("이용을 계속 하시려면 동전을 투입 해주세요. 0 = 동전을 넣지 않는다." );
				System.out.print("입력 = " );		
			
			}else if(coin<dPrice[0]) {
				
			
				
			}
			
	}
	System.out.println("자판기 종료");
	
	}

}

