package kr.co.dong.report;

import java.util.Scanner;

public class Report21_5 {
	
	public static void main(String[] args) {
		
		String[] dName = { "Coke", "Sprite", "Coke zero", "Sprite zero","Monster", "Redbull", "Tonic Water","Ginger ale", "Banana Milk","Straw Berry"};
		int[] dAmount = { 15, 20, 20, 15, 15, 20, 15, 15, 20, 15}; 		// 재고 갯수
		int[] dPrice = { 1200, 1200, 1200, 1200, 2000, 2000, 1500, 1500, 1200, 1200,};
//		int vCash = 100000; // 시재 개념을 탑재 하는것도 생각해두자
		int coin = 0; // 투입금액 선언
		int sel = 0; // 메뉴 선택
		boolean power = false; // 전원 조건부
		
		System.out.println("Hi I'm vending machine :) ================================");
		System.out.println("| 현재 제공중인 품목들 입니다 사용을 원하시면 동전을 투입 (입력)해주세요|");
		
			for(int i=0; i<dName.length; i++) {
				System.out.println((char)(9312+i) +". "+ dAmount[i] + " * "+dName[i] + " : "  + dPrice[i] + " won  ");
			}//조교 짝꿍센세의 조언에 따라 char 아스키코드로 특수문자를 입력해봄
		
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
			}else if(coin>=dPrice[0]){ // 가장 낮은 품목의 가격을 넣어야함 현재 가장 최저가 중 앞순은 [0]
				System.out.println("투입 된 금액은 현재 " + coin + " won 입니다.\r");			
				System.out.println("해당 기기는 투입한 금액 상당의 제공 가능한 제품만 표시됩니다.");	
				System.out.println("메뉴를 선택해주세요.");	
				
					for(int i=0; i<dName.length; i++) {
						
						if(coin >= dPrice[i]){
							System.out.print((char)(9312+i) + " "+ dName[i]+" ");
						}
											
					}
						
			}else {
				
				System.out.println("투입 된 금액은 현재 " + coin + " won 입니다.\r");			
				System.out.println("해당 기기는 투입한 금액 상당의 제공 가능한 제품만 표시됩니다.");	
				System.out.println("메뉴를 선택해주세요.");	
				System.out.println((char)(9312) +""+ (char)(9313) + " Insert Coin " + (char)(9312+8) + (char)(9312+8) + " Vender Power Off" + "\r입력 = ");	
				// 추후에 왜그런지 화인해봐야할듯
					for(int i=0; i<dName.length; i++) {
						
						if(coin >= dPrice[i]){
							System.out.print((char)(9312+i) + " "+ dName[i]+" ");
						}
										
					}
			}
						
			sel = sc.nextInt();
			
			switch(sel) {
						
				case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
								
					sel--;
					
					if (coin<dPrice[sel]) {
						System.out.println("=================== 잔액이 부족합니다 ===================");
						System.out.println("============= 투입한 금액" +coin+ " won 이 반환 됩니다.=============");
						
						coin-=coin;
															
					}else if(dAmount[sel] == 0) {
						System.out.println("선택하신 음료의 재고가 없습니다.");
						System.out.println("투입 된 금액은 현재 " + coin + "입니다.");
						
					}else{
					dAmount[sel] -= 1; coin-=dPrice[sel];
						System.out.println("선택하신 음료"+dName[sel]+"가 곧 제공됩니다. ===== - 재고 "+dAmount[sel]);
						System.out.println("===================== 현재 남은 금액은 " + coin + " 입니다. \r");
					}
				
					break;
					
			case 11:
					System.out.println("금액 " + coin + " won 이 반환 됩니다.");
					System.out.println("=================================");
				coin-=coin;
					System.out.println("현재 금액은 "+ coin + " won 입니다." );
					System.out.println();
					// 거스름돈 반환
				break;
				
			case 12: 
				
					System.out.println("추가 투입 할 금액을 입력 하세요");
										
				break;
						
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
								
								for(int i=0; i<dName.length; i++) {
								System.out.println((char)(9312+i)+". "+ dName[i]+ " ");
								}
										
								int	menu=sc.nextInt();		
									menu--;
								
								switch(menu) { // 어드민 하위 메뉴 1234 접근
									
								case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:							
									
									System.out.println("품목"+ dName[menu]+ "을/를 변경 할 품목명을 입력해주세요.");
									sw = sc.next();
																	
									tmp=dName[0];
									dName[0]=sw;
									sw = tmp;
									break;							
															
								default:
									break;
								}
								break;
								
							case 2:
								
								System.out.println("품목 재고를 변경합니다. 변경 할 품목의 재고를 선택하세요");
								
								for(int i=0; i<dName.length; i++) {
									System.out.println((char)(9312+i)+". "+ dName[i] +" * "+ dAmount[i]+ " ");
									}
																
								menu=sc.nextInt();	
								menu--;
								switch(menu) {
																																							
								case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:
									
									System.out.println(dName[menu] + "의 재고를 변경 할 수량을 입력해주세요. 현재 재고 : "+ dAmount[menu]);
									sw = sc.next();
																	
									tmpNum =dAmount[menu];
									dAmount[menu] = swNum;
									swNum = tmpNum;
									break;
																								
								default:
									break;
								}
								break;	
								
							case 3:
								
								System.out.println("품목 당 가격을 변경합니다. 변경 할 품목을 선택하세요");
								for(int i=0; i<dName.length; i++) {
									System.out.println((char)(9312+i)+". "+ dName[i] +" : "+ dPrice[i]+ " won");
									}
								
								menu=sc.nextInt();	
								menu--;
								switch(menu) {
								
									case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:
									
										System.out.println(dName[menu] + "의 변경 할 가격을 입력해주세요. 현재 가격 : "+ dPrice[menu]);
										sw = sc.next();
																	
										tmpNum =dPrice[menu];
										dPrice[menu] = swNum;
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
						
							default:
								break;
						}
							
							if(adminpower != true){
								System.out.println("기기를 재시작하기 전까지 변경사항이 저장됩니다.");
								
							}
							
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
				}
			
			}
		sc.close();
		System.out.println("자판기 종료");
		
	} //Main ed
}//Class ed