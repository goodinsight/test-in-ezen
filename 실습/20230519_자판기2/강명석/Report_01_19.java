/*
 * 배열로 구현 이후 잔여 작업 
 * ver15 입력돈 for 문으로 줄임
 * ver16 잔돈출력 for 문으로 줄임
 * ver17 입력 가격 case 문을 while 문으로 줄임 
 * ver18 재고 변경 case에서 while 문으로 줄임
 */
package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_19 {
	public static void main(String[] args) {
//		선언
		int productCount = 3; // 판매 제품 수량 변경 시 사용 예정
		
		int power1 = 1; // 자판기 스위치	
		int power2 = 1; // 관리자 스위치
		
		String[] dName = null; // 제품명
			dName = new String[productCount];           // 나중에 변경
			dName[0] = "콜라";
			dName[1] = "소주";
			dName[2] = "생수";
		
		int[] dPrice = null; // 가격
			dPrice = new int[productCount];                // 제품 초기 가격
			dPrice[0] = 1000;
			dPrice[1] = 2000;
			dPrice[2] = 3000;
		
		int[] dAmount = null; // 수량
			dAmount = new int[productCount];                // 제품 수량 잔고
			dAmount[0] = 5;
			dAmount[1] = 5;
			dAmount[2] = 5;
		
		int[] sAmount = null; // 수량
			sAmount = new int[4];                // 자판기 내 잔돈 확보 수량
			sAmount[0] = 1; //50000원
			sAmount[1] = 1; //10000원
			sAmount[2] = 1; //5000원
			sAmount[3] = 1; //1000원

			int[] sMoney = null; // 잔돈 값
			sMoney = new int[4];                // 잔돈권 기본 가격
			sMoney[0] = 50000; //50000원
			sMoney[1] = 10000; //10000원
			sMoney[2] = 5000; //5000원
			sMoney[3] = 1000; //1000원
			
			int[] smAmount = null; // 수량
			smAmount = new int[4];                // 환불해줄 잔돈 수량
			smAmount[0] = 0; //50000원
			smAmount[1] = 0; //10000원
			smAmount[2] = 0; //5000원
			smAmount[3] = 0; //1000원
			
			int pass = 1234; // 관리자 초기 암호
			
		
		int[] sale = null;
		sale = new int[productCount];  // 판매수량 => 매출 검토
		
		int inCoin = 0; // 넣은 돈
		int inMenu = 0; // 메뉴 선택 버튼		
		
		Scanner scan = new Scanner(System.in); // 스캐너 호출
		
		while(power1!=0) { // 0이 아니면 계속 구동
			System.out.println("----------------------------- Menu -----------------------------");
			System.out.println("1. 돈 넣기        2. 돈 돌려받기        99. 종료         90. 관리자모드");
			System.out.println();
			System.out.println("--------------------------- 제품 선택 ---------------------------");
			System.out.printf("11. %s(잔여수량%d)      12. %s(잔여수량%d)         13. %s(잔여수량%d) \n", dName[0], dAmount[0],  dName[1], dAmount[1],  dName[2], dAmount[2]); //나중에 배열을넣을 것
			System.out.printf("    %d원                %d원                    %d원     \n", dPrice[0], dPrice[1], dPrice[2]);
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			
			System.out.print("고객님 선택해 주세요>"); // 프롬프터
			inMenu = scan.nextInt(); // 메뉴 입력			
			
			switch (inMenu) { // main switch
			
			case 1: // 돈 넣기
				int count = 0;
				count++;
				
				if (count == 1) {
					System.out.printf("최소 구입금액은 1000원 입니다. \n"); //최소 금액 확인 초기 출력 이후 안출력
				}
				else {
					System.out.printf(" \n");
				}

				while (true) {
					System.out.printf("돈을 넣어 주세요.> \n");
					inCoin = inCoin + scan.nextInt();
					
					if(inCoin <sMoney[3]) { // 최소 입력 금액 확인
						System.out.println("돈이 부족합니다. ");
						System.out.printf("현재 잔액은 %d 입니다. \n", inCoin);
					}	
					int inCoinTmp = 0;
					inCoinTmp = inCoin;
					
					if (inCoin>=sMoney[3]) { // 지폐 종류별 수량 증가  						
						if(inCoin <sMoney[2]) {   
							for(int i=3; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;			
							}
							inCoin = inCoinTmp;
						}                                               
						
						else if(inCoin >=sMoney[2] && inCoin <sMoney[1] ) { // 5000원 이상 1만원 미만
							for(int i=2; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						else if(inCoin >=sMoney[1] && inCoin <sMoney[0] ) { //1만원 이상 5만원 미만
							for(int i=1; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						else if(inCoin >sMoney[0]) { // 5만원 이상일때
							for(int i=0; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						inCoin = inCoinTmp; // 장수계산시 입력가격이 변경 되어 초기 값을 다시넣어줌
						break;
					}	
				}
				break;
		
			case 2: // 동전 찾기
				
				if(inCoin==0) {
					System.out.println("돌려받을 잔돈이 없습니다. 감사합니다. ");
					System.out.println("시스템 종료를원하시면 99번을 눌러주십시요. ");
				}
				
				System.out.println("잔돈은 = " + inCoin + "입니다. 감사합니다. ");
				
				if(inCoin<sMoney[2]) { // 5000원 미만
					for(int i=3; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("잔돈은 %d원 화폐 + %d장 입니다. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];
					}
				}					
				else if(inCoin>=sMoney[2] && inCoin <sMoney[1]) { // 5000원 이상 10000원 미만
					for(int i=2; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("잔돈은 %d원 화폐 + %d장 입니다. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];
					}
				}				
				else if(inCoin>=sMoney[1] && inCoin <sMoney[0]) { // 10000이상 50000원 미만		
					for(int i=1; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("잔돈은 %d원 화폐 + %d장 입니다. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];		
					}
				}				
				else if(inCoin>=sMoney[0]) { // 50000원 이상
					for(int i=0; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("잔돈은 %d원 화폐 + %d장 입니다. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];		
					}
				}				
				inCoin =0;
				break;		
				
				case 11: case 12: case 13:
					
				while(true) { 
					int choice = 0;
					choice = inMenu - 11;
					
					if(dAmount[0]>0) {
						if (inCoin >= dPrice[choice]) {
							System.out.printf("\n%s가 하단 취출구에 있습니다. 감사합니다. \n", dName[choice]);
							inCoin = inCoin - dPrice[choice];
							dAmount[choice] = dAmount[choice] - 1;
							sale[choice] = sale[choice] + 1;
							System.out.printf("잔액은 %d 입니다. \n", inCoin);
							break;
						} else {
							System.out.println("잔액이 부족합니다. ==> 1. 돈넣기를 눌러주세요");
							break;
						}				
					}
				}
				break;
		
			case 90: // 관리자 모드
				int tmp22 = 0;
				System.out.print("관리자 암호를 입력해주세요 : ");
				tmp22 = scan.nextInt();
				if (tmp22 == pass) {			
					int adminMenu =0;				
					while(power2 !=2) {
						System.out.println("-------------------------- admin Menu ---------------------------");
						System.out.println("1. 재고 수량확인     2. 현재 가격");
						System.out.println("3. 재고변경         4. 가격 변경");
						System.out.println("5. 잔돈 수량 확인    6. 판매내역");
						System.out.println("9. 패스워드 변경    10. 이전메뉴");
						System.out.println("-----------------------------------------------------------------");
						System.out.println();
						System.out.println("원하는 관리번호를 눌러주세요>");
				
						adminMenu = scan.nextInt();				
						switch (adminMenu) { // 관리자 스위치					
						case 1: // 재고 수량확인	
							for(int i=0; i<productCount; i++) {
								System.out.printf("%s (잔고수량 %d) \n", dName[i], dAmount[i]);
							}
							System.out.println();
							break;
						
						case 2: // 현재 가격	
							for(int i=0; i<productCount; i++) {
								System.out.printf("%s (잔고수량 %d) \n", dName[i], dPrice[i]);
							}
							break;
						
						case 3: // 재고변경
							int changeNum = 0;
							int changePlma = 0;
							int changeCount = 0;	
						
							for(int i=0; i<productCount; i++) {
								System.out.println((i+1) + dName[i]);
							}
							System.out.println("재고변경 제품 번호를 넣어주세요>");
							changeNum = scan.nextInt();
						
							System.out.println("증가는 1번 감소는 2번?");
							changePlma = scan.nextInt();
						
							System.out.println("변경 수량을 넣어주세요?");
							changeCount = scan.nextInt();
						
							while(true) {
								if(changePlma==1) {                           
								dAmount[changeNum-1] = dAmount[changeNum-1] + changeCount;
								}
								else if(changePlma!=1) {
									dAmount[changeNum-1] = dAmount[changeNum-1] - changeCount;	
								}		
							System.out.println("변경된 완료 : " + dName[changeNum-1] + ":" + dAmount[changeNum-1]);
							break;
								
							}
						
						case 4: // 가격 변경	
							int changeNum2 = 0;
							for(int i=0; i<productCount; i++) {
								System.out.println((i+1) + dName[i]);
							}
						
							System.out.println("가격을 변경한 제품번호를 알려주세요>");
							changeNum2 = scan.nextInt();
							
								while(true) {
									
									if(changeNum2>productCount) {
										System.out.println("잘못된 번호입니다. 다시 입력해 주세요>");
									}
									else {
									dPrice[changeNum2-1] = scan.nextInt();
									System.out.println("새 가격은 = " +  dPrice[changeNum2-1] +"로 변경되었습니다.");
									break;
									}
								}

						case 5: //잔돈 수량 확인	
							for(int i=0; i<sAmount.length; i++) {
								System.out.println(sMoney[i] + "원권 = " + sAmount[i] + "장" );
							}
							break;
						
						case 6: //판매 내역
							System.out.println("오늘 매출액은 아래와 같습니다. ");
							for(int i=0; i< productCount; i++) {
								System.out.println(dName[i] +" : " + dPrice[i] + "원 => " + sale[i] + "개 판매");					
							}
							System.out.println("     총판매금액 :" + (dPrice[0]*sale[0] + dPrice[1]*sale[1] + dPrice[2]*sale[2]) + "원");
							break;
							
						case 9: // 패스워드 변경
							System.out.println("기존 패스워드를 입력해 주세요>");
							tmp22 = scan.nextInt();
							if (tmp22 == pass) {
							System.out.println("변경할 새 암호를 입력해수세요. 숫자 4자리");
							tmp22 = scan.nextInt();	
							pass = tmp22; // 관리자 초기 암호
							}
							System.out.println("암호를 변경하였습니다. 잘기억하세요. \n 관리자페이지로 이동합니다. \n ");

							break;
							
						case 10: // 이전 메뉴
							power2 = 2;
							System.out.println("메인 구동화면으로 넘어 갑니다. ");
							break;
						default:
							System.out.println(" 잘못된 관리번호입니다. 다시 선택을 =>");
							break;
					}	
						} // end of 관리자 스위치
					} // end of while
					break;
				
				case 99: // 구매자 종료
					power1 = 0;
					System.out.println("\n 시스템을 종료합니다.");
				break;
				
				default:
					System.out.println(" 작동에 문제가 발생하였습니다. 다시 메뉴 선택을 부탁드립니다.");
				break;
			} //end of switch main
		} // end of while
	} // end of main
}
// end of class
