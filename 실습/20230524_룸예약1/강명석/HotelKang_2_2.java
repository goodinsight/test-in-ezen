package kr.co.dong.checkpoint // 새로운 설계 제작 호텔 예약 ver2

import java.util.Scanner;

public class HotelKang_2_2 {
	public static void main(String[] args) {
		
		int[] romNum = new int[7];   // romNum[0] 20형 romNum[1] 40형 romNum[2] 룸합 
		                             // romNum[3] 20형 층수 1층 4방  romNum[4] 40형 층수 2방 
		                             // romNum[5] 예약가능20평형 romNum[6] 예약가능 40평형 

		String[][] rom20 = null;     // 소형평수 20평
		String[][] rom40 = null;     // 중형평수 40평
		
		Scanner scan = new Scanner(System.in);
		
		// 형입력                                       // 정상적인 값이 들어 올때까지 while 문으로 작성할 것 - 시간상 대기 0이하만 1회 걸름
		System.out.println("호텔 운영 프로그램을 시작합니다. 운영할 평형 수치를 입력해 주세요");
		System.out.println("입력 20형>");
		romNum[0] = scan.nextInt();
		if(romNum[0]<=0) {
			System.out.println("최소 1개 이상 생성하셔야 합니다. "); // 초기 방 생성 범위 확인 오타 확인겸
			System.out.println("입력 20형>");
			romNum[0] = scan.nextInt();
		}

		System.out.println("입력 40형>");
		romNum[1] = scan.nextInt();
		if(romNum[1]<=0) {
			System.out.println("최소 1개 이상 생성하셔야 합니다. "); // 초기 방 생성 범위 확인 오타 확인겸
			System.out.println("입력 40형>");
			romNum[1] = scan.nextInt();
		}
		
		romNum[2] = romNum[0] + romNum[1];	// romNum[2]
		
		//건물 층수 계산 심플 함수
		romNum[3] = romNum[0] / 4;
		if(romNum[0]%4!=0)
			romNum[3] = romNum[3] + 1; 	   // 20형 romNum[3] 생성되는 층의 수
		
		romNum[4] = romNum[1] / 2;		
		if(romNum[1]%2!=0)
			romNum[4] = romNum[4] + 1;	   // 40형 romNum[4] 생성되는 층의 수
		
//		System.out.println(romNum[3]);    // 층 개수 출력 확인
//		System.out.println(romNum[4]);
		
					
		// 20형 배열 생성                    // 행(아래, 값)길이 전체 romNum[2]                 스티링을 int로  intValue1 = Integer.parseInt(str1)
									       // 형별 행(아래, 값)길이 전체 rom20.length                            str1 = Integer.toString(intValue1)
		                                   // 열(옆, 항목)길이 rom20[0].length
		
		rom20 = new String[romNum[0]][8];  // rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
				                           // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                                           // rom20[0][6] 생성번호	, rom20[0][7]형저장 		                 
		// 40형 배열 생성
       	rom40 = new String[romNum[1]][8];  // rom40[0][0] count, rom40[0][1] 호수, rom40[0][2] 사용여부
       			                           // rom40[0][3] 방이름, rom40[0][4] 가격, rom40[0][5] 사용자이름
                                           // rom40[0][6] 생성번호, rom40[0][7]형저장      

//		System.out.println(rom20.length);
//		System.out.println(rom20[0].length); // 열 개수 확인	
       	
     // 초기화 입력 
// 1. rom20, rom40 [0][0] count
       	for(int i=0; i<rom20.length; i++)
       		rom20[i][0] = Integer.toString(i+1); // rom20[i][0]의 카운트가 0부터가 아니라 1부터 시작하게 i+1 함  단순입력 괄호 생략 주의       	
       	for(int i=0; i<rom40.length; i++)
       		rom40[i][0] = Integer.toString(i+1); // rom40[i][0]의 카운트가 0부터가 아니라 1부터 시작하게 i+1 함  단순출력 괄호 생략 주의     	
       	
// * 출력확인 *
//       	for(int i=0; i<rom20.length; i++)  // 열개수 0을 1부터 증가하는 것으로 입력확인
//       		System.out.println(rom20[i][0]);  
//       	for(int i=0; i<rom40.length; i++)  // 열개수 0을 1부터 증가하는 것으로 
//       		System.out.println(rom40[i][0]); 
     
// 2. 방호수 초기화 rom20
       	int romTmp = 100;
       	int floor20 = 4;
       	int floor40 = 2;
       	int floorCounter = 0;

       	for(int i=1; i<=rom20.length; i++) {        			
  			rom20[i-1][1] = Integer.toString(romTmp+i- floor20*floorCounter); // rom20[i][1]의 갚을 1층에 4개방 20평은 한층에 4개
  				if(i%floor20==0) {
  					romTmp = romTmp + 100;
 				    floorCounter++;
 				   rom20[i-1][7]="20";
  				}
       		}
			romTmp = romTmp + 100;      		
       	for(int i=1; i<=rom40.length; i++) {  
       		floorCounter = (i-1)/floor40;
  			rom40[i-1][1] = Integer.toString(romTmp + i - floor40*floorCounter); // rom20[i][1]의 갚을 1층에 2개방 40평은 한층에 방 2개
  				if(i%floor40==0) {
  					romTmp = romTmp + 100;
  				    floorCounter++;
  				   rom40[i-1][7]="40";
  				}
       		}    		
// * 출력확인 *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][1]);  
//       	for(int i=0; i<rom40.length; i++)  // 
//       		System.out.println(rom40[i][1]);       	
       	
// 3. 방 예약 정보 초기화 	 rom20[0][2] rom40[0][2]사용여부
        for(int i=0; i<rom20.length; i++)
        	rom20[i][2] = "O"; // rom20[i][0]의 사용 O, 미사용 X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][2] = "O"; // rom40[i][0]의 사용 O, 미사용 X  
           	
// * 출력확인 *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][2]);  
//       	for(int i=0; i<rom40.length; i++)  //  
//       		System.out.println(rom40[i][2]); 

// 4. 방이름	rom20[0][3]                           // 일단 크기별 1개씩만 소형 골드, 대형 VVIP
        for(int i=0; i<rom20.length; i++)
        	rom20[i][3] = "Gold"; // rom20[i][0]의 사용 O, 미사용 X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][3] = "VVIP"; // rom40[i][0]의 사용 O, 미사용 X  
           	
// 5. 방가격 rom20[0][4] 가격                       // 일단 크기별 1개씩만 소형 4만, 대형 8만     
        for(int i=0; i<rom20.length; i++)
        	rom20[i][4] = "40,000원"; // rom20[i][0]의 사용 O, 미사용 X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][4] = "80,000원"; // rom40[i][0]의 사용 O, 미사용 X  
 
           	
// 6. 사용자이름 초기 세팅 미등록            rom20[0][5] 사용자이름
        for(int i=0; i<rom20.length; i++)
        	rom20[i][5] = "미등록";        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][5] = "미등록";
// * 출력확인 *
//           	for(int i=0; i<rom20.length; i++)  // 
//           		System.out.println(rom20[i][5]);  
//           	for(int i=0; i<rom40.length; i++)  //  
//           		System.out.println(rom40[i][5]); 
           	
// 7. 룸의 발행번호 => 비번으로 사용예정 rom20[0][6] 생성번호   => 예약번호 생성원리 룸번호 + 1004
        for(int i=0; i<rom20.length; i++)
        	rom20[i][6] = rom20[i][1] + Integer.toString(1002); // rom20[i][0]의 카운트가 0부터가 아니라 1부터 시작하게 i+1 함  단순입력 괄호 생략 주의
        														// 방사용여부 구분 예약번호 1002면 20형
        for(int i=0; i<rom40.length; i++)
        	rom40[i][6] = rom40[i][1] + Integer.toString(1004); // rom40[i][0]의 카운트가 0부터가 아니라 1부터 시작하게 i+1 함  단순출력 괄호 생략 주의 
		                                                        // 방사용여부 구분 예약번호 1004면 40형       
// * 출력확인 *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][6]);  
//       	for(int i=0; i<rom40.length; i++)  //  
//       		System.out.println(rom40[i][6]); 
       	
// 7. 시스템 구동 부
        boolean power = false;
        int menu = 0;
        
		// 현황판 리젠
		System.out.println("                예약현황판                    ");
		System.out.println("-----------------------------------------------");
		System.out.println("                     -- 20형 --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %s호(%s)예약(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
			
			if( (i+1)%2 == 0)
				System.out.println();
			
		}
		System.out.println("                     -- 40형 --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %s호(%s)예약(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
			
			if( (i+1)%2 == 0)
				System.out.println();
		}
		
		System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
		System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
		System.out.println("               8. 관리자        9. 종료");
		// 현황판 리젠
		
        while(!power) {   	
			System.out.println("기능선택 => "); // 기능선택
			menu = scan.nextInt();       	
        	
        	
        	
        	switch (menu) {
				case 1: // 예약 상태 확인
					System.out.println("20평형 현황");
					System.out.println("위치 방번호 예약   방이름   가격      고객명    취소번호  크기"  );
					for(int i=0; i<rom20.length; i++) {
						System.out.printf(" %s   %s   %s   %s  %s   %s    %s\n", rom20[i][0], rom20[i][1], rom20[i][2],
								rom20[i][3], rom20[i][4], rom20[i][5], rom20[i][6] , rom20[i][7]);
					}
					System.out.println("40평형 현황");
					System.out.println("위치 방번호 예약   방이름   가격      고객명    취소번호   크기"  );
					for(int i=0; i<rom40.length; i++) {
						System.out.printf(" %s   %s   %s   %s  %s   %s    %s\n", rom40[i][0], rom40[i][1], rom40[i][2],
					rom40[i][3], rom40[i][4], rom40[i][5], rom40[i][6], rom40[i][7]);
					}
					// rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
                    // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                    // rom20[0][6] 생성번호
					
				break; 
				
				case 2: // 방예약 => 보고
// 1. 예약 전 사전 체크 : 방여유 확인 + 예약 가능여부 알림
// 관련 변수 romNum[5] 예약가능20평형, romNum[6] 예약가능 40평형, rom20[i][2], rom40[i][2] 사용 O, 미사용 X
					for(int i=0; i<rom20.length; i++) // 20형 체크 // 1줄 for, if 괄호 생략
						if(rom20[i][2]=="O")
							romNum[5]++;
					
					for(int i=0; i<rom40.length; i++) //40형 체크 // 1줄 for, if 괄호 생략
						if(rom40[i][2]=="O")
							romNum[6]++;

					if(romNum[5]==0 && romNum[6]==0) 
						System.out.println("예약가능한 방이 없습니다. 호텔연락 Tel. 000-0000-000");	  //1줄 if 생략
					
// *확인 방 카운트됨	System.out.println(romNum[5]);
//					System.out.println(romNum[6]);
					
			
// 2. 선택화면 		// 화면 디스플레이 필요 // rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
                    // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                    // rom20[0][6] 생성번호 rom20[0][3] = "Gold"	 rom40[0][3] = "VVIP"
					
					// 현황판 리젠
					System.out.println("                예약현황판                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println();
					System.out.println("                     -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");					
		            // 현황판 리젠
			
// 3. 선택			20형 40형 크기를 선택함	
					// rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
                    // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                    // rom20[0][6] 생성번호  rom20.length    rom40.length
					String selectRom = null;
					String Recheck = null;
					String inputName = null;
					int chNum = 0;              // 방에 따른 idx 임시저장
					
					System.out.println("원하는 방 호수를 선택해 주세요 ex) 101> ");
					selectRom = scan.next();
					
					System.out.println("예약자 이름을 넣어 주시면 예약이 완료됩니다. ex) 홍길동> ");
					inputName = scan.next();
										
// * 입력확인  		System.out.println(selectRom);
//					System.out.println(inputName);
//					System.out.println(Recheck);					
//예약절차 진행함 // 방번호로 20형인지 40형인지 구분 변수 추가 ; 미사용하긴함
						
						for(int i=0; i<rom20.length; i++) {
							if(selectRom.equals(rom20[i][1])) {
								chNum = i;
								rom20[chNum][2] = "X";
								rom20[chNum][5] = inputName;
								System.out.println("예약한 방의 예약번호입니다. 잘기억하십시요. <취소 혹은 확인시 필요함>");
								System.out.printf("예약 예약번호는 < %s > 입니다. \n", rom20[chNum][6] );
							}
						}
	
						for(int i=0; i<rom40.length; i++) {
							if(selectRom.equals(rom40[i][1])) {
								chNum = i;
								rom40[chNum][2] = "X";
								rom40[chNum][5] = inputName;
								System.out.println("예약한 방의 예약번호입니다. 잘기억하십시요. <취소 혹은 확인시 필요함>");
								System.out.printf("예약 예약번호는 < %s > 입니다. \n", rom40[chNum][6] );
							}
						}	

					// 현황판 리젠
					System.out.println("                예약현황판                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                     -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");	
					System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
					System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
					System.out.println("               8. 관리자        9. 종료");
		            // 현황판 리젠
					
				break;  
				
				case 3: // 예약취소 
					//취소절차 : serch 이름 => idx확인 => 비번 idx의 값과 비교
					// rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
                    // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                    // rom20[0][6] 생성번호  rom20.length    rom40.length
					
					String checkName = null;
					int checkReNum = 0;
					String inputTmp = null;
					
					System.out.println("예약 취소를 선택하셨습니다. ");
					System.out.println("예약 취소절차는 ID는 이름, 패스워드는 예약번호 입니다.");	
					System.out.println("1. 취소 ID(이름) 입력 >");
					checkName = scan.next();
					System.out.println("2. 최소 PASS(예약번호) 입력 >");
					inputTmp = scan.nextLine();
										
					for(int i=0; i<rom20.length; i++) {	// 20평 체크		
						if( (rom20[i][5]==checkName)&& (rom20[checkReNum][6]==inputTmp) ) {
							checkReNum = i;
							System.out.printf("%s님의 %s호 예약이 취소되었습니다.", rom20[checkReNum][5], rom20[checkReNum][1] );
							rom20[checkReNum][5]="OOO";  // 예약 취소 이름 원복
							rom20[checkReNum][2]="0";      // 예약 취소 사용여부 
						}
					}	
					for(int j=0; j<rom40.length; j++) {	// 40평 체크		
						if(rom20[j][5]==checkName) {
							checkReNum = j;
							System.out.printf("%s님의 %s호 예약이 취소되었습니다.", rom40[checkReNum][5], rom40[checkReNum][1] );
							rom40[checkReNum][5]="OOO";  // 예약 취소 이름 원복
							rom40[checkReNum][2]="0";      // 예약 취소 사용여부 
						}
					}
					
					// 현황판 리젠
					System.out.println("                예약현황판                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                     -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호(%s)예약(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");	
					System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
					System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
					System.out.println("               8. 관리자        9. 종료");
		            // 현황판 리젠
					
			
				break;
				
				case 8: // 관리자

				break;
				
				case 9: // 예약종료
					power = true;
					System.out.println("모든 요청사항이 마무리 되었습니다. 감사합니다.");	
				break;

				default:
					System.out.println("정상적인 동작이 아닙니다. 다시 진행해 주세요 ");
				break;
				
			} //end of switch
	
        } //end of while
		System.out.println("예약 시스템 종료.");
	} // end of main
	
} // end of class
