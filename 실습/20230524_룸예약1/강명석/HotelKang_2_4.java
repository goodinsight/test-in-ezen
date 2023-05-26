package kr.co.dong.checkpoint // 새로운 설계 제작 호텔 예약 ver2
                    // ver2.1 포멧 설계 2차원 + 1차원 배열 5/25
                    // ver2.2 포멧 및 기능 구현 5/26 오전
                    // ver2.3 디스플레이 개선 및 기능점검 5/26 오전
                    // ver2.4 관리자 구성 5/26 오후

import java.util.Scanner;

public class HotelKang_2_4 {
	public static void main(String[] args) {
		
		int[] romNum = new int[9];   // romNum[0] 20형 romNum[1] 40형 romNum[2] 룸합 
		                             // romNum[3] 20형 층수 1층 4방  romNum[4] 40형 층수 2방 
		                             // romNum[5] 예약가능20평형 romNum[6] 예약가능 40평형 
									 // romNum[7] 예약한20형 romNum[8] 예약한40형
		
		for(int i=0; i<romNum.length; i++)           // 한줄 초기와
			romNum[i] = 0;

		String[][] rom20 = null;     // 소형평수 20평
		String[][] rom40 = null;     // 중형평수 40평
		final int PASS = 1004; 
		
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
                                           // rom20[0][6] 생성번호	, rom20[0][7]인원수 		                 
		// 40형 배열 생성
       	rom40 = new String[romNum[1]][8];  // rom40[0][0] count, rom40[0][1] 호수, rom40[0][2] 사용여부
       			                           // rom40[0][3] 방이름, rom40[0][4] 가격, rom40[0][5] 사용자이름
                                           // rom40[0][6] 생성번호, rom40[0][7] 인원수     
       	final String MAX20 = "4명"; // 20형 최대수용인원
       	final String MAX40 = "8명"; // 40형 최대수용인원   
       	
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
        
        // ** 방이름을 최대 미중복 랜덤으로 위치함
        String[] roomNameRand = { "Nice", "Good", "Like", "Need", "Time", 
        						  "Life", "Work", "Hope", "Fear", "Rain",
        						  "Fire", "Snow", "Love", "Mind", "Star",
        						  "Rain", "Song", "Wind", "Idea", "Game",
        						  "Team", "Luck", "Gift", "Book", "Home",
        						  "Tree", "Bird", "Hand", "Word", "Pick",
        						  "Gold", "VVIP", "Mine"
        };
        rom20[0][3]="Gift";
        rom40[0][3]="Good";
                
        for(int i=0; i<rom20.length; i++){
        	int ranNumRom1 = (int)(Math.random()*28) +1;
        	{for(int j=0; j<i; j++) {
        		rom20[i][3] = roomNameRand[ranNumRom1];  // 랜덤으로 방이름 배치 28개만 
        		if(rom20[i][3]==rom20[j][3]) {
        			ranNumRom1 = (int)(Math.random()*28) +1;
        			rom20[j][3] = roomNameRand[ranNumRom1];
        		}
        		
        	}  // 랜덤으로 방이름 배치 28개만
        		
        	}
        	ranNumRom1 = 0;
        }
        for(int i=0; i<rom40.length; i++) {
        	int ranNumRom2 = (int)(Math.random()*28) +1;
        	rom40[i][3] = roomNameRand[ranNumRom2]; // rom40[i][0]의 사용 O, 미사용 X    
    		ranNumRom2 = 0; //초기화  
        } // => 기존에 있는지 크로스 체크 하고 넣을 것	

           	
// 5. 방가격 rom20[0][4] 가격                       // 일단 크기별 1개씩만 소형 4만, 대형 8만     
        for(int i=0; i<rom20.length; i++)
        	rom20[i][4] = "40000"; // rom20[i][0]의 사용 O, 미사용 X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][4] = "80000"; // rom40[i][0]의 사용 O, 미사용 X  
 
           	
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
        
// 8. 인원수 확인 rom20[0][7] 생성번호  20형은 4명, 40형은 8명
        for(int i=0; i<rom20.length; i++)
        	rom20[i][7] = "4명"; // 단순입력 괄호 생략 주의
        for(int i=0; i<rom40.length; i++)
        	rom40[i][7] = "8명"; // 단순입력 괄호 생략 주의	 
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
		System.out.println("===============================================");
		System.out.println("                   -- 20형 --                      ");
		for(int i=0; i< rom20.length; i++) { // 인원수 // 
			System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
			if( (i+1)%2 == 0) {
				System.out.println();
				for(int j=0; j<2; j++) {
				System.out.printf("       가격 : %s원           ", rom20[i][4]);					
			   }
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("                   -- 40형 --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
			if( (i+1)%2 == 0) {
				System.out.println();
				for(int j=0; j<2; j++) {
				System.out.printf("       가격 : %s원           ", rom40[i][4]);	
			   }
				System.out.println();	
			}
		}
		System.out.println();                                            
		System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
		System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
		System.out.println("              8. 관리자        9. 종료");
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
					// 현황판 리젠
					System.out.println("                예약현황판                    "); 
					System.out.println("===============================================");
					System.out.println("                   -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) { // 인원수 // 
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                   -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println();                                            
					System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
					System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
					System.out.println("              8. 관리자        9. 종료");
					// 현황판 리젠
					
					
				break; 
				
				case 2: // 방예약
// 1. 예약 전 사전 체크 : 방여유 확인 + 예약 가능여부 알림
// 관련 변수 romNum[5] 예약가능20평형, romNum[6] 예약가능 40평형, rom20[i][2], rom40[i][2] 사용 O, 미사용 X
					for(int i=0; i<rom20.length; i++) // 20형 체크 // 1줄 for, if 괄호 생략
						if(rom20[i][2].equals("X"))
							romNum[5]++;
					
					for(int i=0; i<rom40.length; i++) //40형 체크 // 1줄 for, if 괄호 생략
						if(rom40[i][2].equals("X"))
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
					System.out.println("===============================================");
					System.out.println("                   -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) { // 인원수 // 
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       가격 : %s원           ", rom20[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println("                   -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("        가격 : %s원           ", rom40[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println();                                            
					System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
					System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
					System.out.println("              8. 관리자        9. 종료");
					// 현황판 리젠
			
// 3. 선택			20형 40형 크기를 선택함	
					// rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
                    // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                    // rom20[0][6] 생성번호  rom20.length    rom40.length
					String selectRom = null;
					String inputName = null;
					String inputMem = null;
					
					int chNum = 0;              // 방에 따른 idx 임시저장
					
					System.out.println("원하는 방 호수를 선택해 주세요 ex) 101> ");
					selectRom = scan.next();
					
					System.out.println("숙박하는 인원수를 (?)명 알려주세요 ex) 1명 or 1 > ");
					inputMem = scan.next();
// ==> 작업할것						// 조건 인원이 많아서 다른 방으로 이동 기능					

					
					System.out.println("예약자 이름을 넣어 주시면 예약이 완료됩니다. ex) 홍길동> ");
					inputName = scan.next();
					
										
// * 입력확인  		System.out.println(selectRom);
//					System.out.println(inputName);				
//예약절차 진행함 // 방번호로 20형인지 40형인지 구분 변수 추가 ; 미사용하긴함
						
						for(int i=0; i<rom20.length; i++) {
							if(selectRom.equals(rom20[i][1])) {
								chNum = i;
								rom20[chNum][2] = "X";
								rom20[chNum][5] = inputName;
								rom20[chNum][7] = inputMem;
								System.out.println("예약한 방의 예약번호입니다. 잘기억하십시요. <취소 혹은 확인시 필요함>");
								System.out.printf("예약 예약번호는 < %s > 입니다. \n", rom20[chNum][6] );
							}
						}
	
						for(int i=0; i<rom40.length; i++) {
							if(selectRom.equals(rom40[i][1])) {
								chNum = i;
								rom40[chNum][2] = "X";
								rom40[chNum][5] = inputName;
								rom40[chNum][7] = inputMem;
								System.out.println("예약한 방의 예약번호입니다. 잘기억하십시요. <취소 혹은 확인시 필요함>");
								System.out.printf("예약 예약번호는 < %s > 입니다. \n", rom40[chNum][6] );
							}
						}	

						// 현황판 리젠
						System.out.println("                예약현황판                    "); 
						System.out.println("===============================================");
						System.out.println("                   -- 20형 --                      ");
						for(int i=0; i< rom20.length; i++) { // 인원수 // 
							System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
							if( (i+1)%2 == 0) {
								System.out.println();
								for(int j=0; j<2; j++) {
								System.out.printf("       가격 : %s원           ", rom20[i][4]);					
							   }
								System.out.println();
							}
						}
						System.out.println("                   -- 40형 --                      ");
						for(int i=0; i< rom20.length; i++) {
							System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
							if( (i+1)%2 == 0) {
								System.out.println();
								for(int j=0; j<2; j++) {
								System.out.printf("       가격 : %s원           ", rom40[i][4]);					
							   }
								System.out.println();
							}
						}
						System.out.println();                                            
						System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
						System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
						System.out.println("              8. 관리자        9. 종료");
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
					inputTmp = scan.next();
										
					for(int i=0; i<rom20.length; i++) {	// 20평 체크		
						if( rom20[i][5].equals(checkName) && rom20[checkReNum][6].equals(inputTmp)) {
							checkReNum = i;
							System.out.printf("%s님의 %s호 예약이 취소되었습니다. \n", rom20[checkReNum][5], rom20[checkReNum][1] );
							System.out.println("감사합니다. 다음에 다시 만나요.");
							rom20[checkReNum][5]="미등록";  // 예약 취소 이름 원복
							rom20[checkReNum][2]="O";      // 예약 취소 사용여부 
							rom20[checkReNum][7]=MAX20;
						}
					}	
					for(int j=0; j<rom40.length; j++) {	// 40평 체크		
						if( rom40[j][5].equals(checkName) && rom40[checkReNum][6].equals(inputTmp)) {
							checkReNum = j;
							System.out.printf("%s님의 %s호 예약이 취소되었습니다.\n", rom40[checkReNum][5], rom40[checkReNum][1] );
							System.out.println("감사합니다. 다음에 다시 만나요.");
							rom40[checkReNum][5]="미등록";  // 예약 취소 이름 원복
							rom40[checkReNum][2]="O";      // 예약 취소 사용여부 
							rom40[checkReNum][7]=MAX40;
						}
					}
					
					
					// 예약 인원 리젠			
					for(int i=0; i<rom20.length; i++) {	// 20평 체크	
						if( rom20[i][2].equals("X")) {
							romNum[7]++;  // 한명 증가 - 예약자
						}
					}	
					
					for(int i=0; i<rom40.length; i++) {	// 40평 체크		
						if( rom40[i][2].equals("X")) {
							romNum[8]++;  // 한명 증가 - 예약자
						}
					}
					// 예약 인원 리젠						
					
					// 현황판 리젠
					System.out.println("                예약현황판                    "); 
					System.out.println("===============================================");
					System.out.println("                   -- 20형 --                      ");
					for(int i=0; i< rom20.length; i++) { // 인원수 // 
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       가격 : %s원           ", rom20[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println("                   -- 40형 --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       가격 : %s원           ", rom40[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println();                                            
					System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
					System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
					System.out.println("              8. 관리자        9. 종료");
					// 현황판 리젠
					
			
				break;
				
				case 8: // 관리자
					
					int inputPass = 0;
					int adminMenu = 0;		
					int adminOnOff = 1;
					System.out.print("관리자 암호를 입력해주세요 : ");
					inputPass = scan.nextInt();
					if (inputPass == PASS) {

						while(adminOnOff != 2) {

							System.out.println("=========== 아래 메뉴를 통해서 진행해주세요 ==========");
							System.out.println("1. 예약현황(계약호수 및 빈방)      2. 매출 현황");
							System.out.println("3. 가격변경     4. 이름 변경      9. 종료");
							System.out.println("===============================================");
							System.out.println("관리자 모드로 들어 오셨습니다.");
							System.out.println("메뉴 선택>");	
							
							adminMenu = scan.nextInt(); // 메뉴입력
							
							
							switch (adminMenu) {
							case 1:
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
								System.out.println();
								System.out.println("== 예약현황 ==");	
//관련 변수 romNum[5] 예약가능20평형, romNum[6], 20 예약인원 romNum[7], 40예약인원 romNum[8] 예약가능 40평형								
								// 예약 호수 이름 인원 표시 예약자가 있어면 숫번, 예약호수, 이름, 인원 표시								

								System.out.println(" 번호  방호수  사용자이름  인원수");
								for(int i=0; i<rom20.length; i++) {	// 20평 체크	
									if( rom20[i][2].equals("X")) {
										romNum[7]++;  // 한명 증가 - 예약자
										System.out.printf("  %d    %s      %s    %s \n",romNum[7], rom20[i][1], rom20[i][5], rom20[0][7]);								
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40평 체크		
									if( rom40[i][2].equals("X")) {
										romNum[8]++;  // 한명 증가 - 예약자
										System.out.printf(" %d %s %s %s",romNum[8], rom40[i][1], rom40[i][5], rom40[0][7]);								
									}
								}
								
								System.out.printf("1. 20평형 예약호수 : %s개 \n", romNum[7]);
								System.out.printf("2. 40평형 예약호수 : %s개 \n", romNum[8]);
								System.out.printf(" 전체 예약 호수 : 총 %d 실", (romNum[7]+romNum[8]));
								
								break;	
								
							case 2:
								// 예약 인원 리젠			
								for(int i=0; i<rom20.length; i++) {	// 20평 체크	
									if( rom20[i][2].equals("X")) {
										romNum[7]++;  // 한명 증가 - 예약자
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40평 체크		
									if( rom40[i][2].equals("X")) {
										romNum[8]++;  // 한명 증가 - 예약자
									}
								}
								// 예약 인원 리젠	
							
								// String => int : intValue1 = Integer.parseInt(str1)
								// int => String :  str1 = Integer.toString(intValue1)
										
								System.out.println("== 매출 현황 ==");
								System.out.printf("1. 20평형 > 예약 %d 건, 매출액 = %7d \n", romNum[7], romNum[7]*Integer.parseInt(rom20[0][4]) ); // 단일값이라 고정, 추후 변경
								System.out.printf("2. 40평형 > 예약 %d 건, 매출액 = %7d \n", romNum[8], romNum[8]*Integer.parseInt(rom40[0][4]) ); // 단일값이라 고정, 추후 변경
								System.out.printf(" 합계 매출은 = 총%d 입니다. \n", romNum[7]*Integer.parseInt(rom20[0][4])+ romNum[8]*Integer.parseInt(rom40[0][4]) ); // 단일값이라 고정, 추후 변경

								break;
		
							case 3:
								String changRom = null;
								int changeMoney = 0;
								
								System.out.println("== 가격 현황표 20평형 ==");
								for(int i=0; i<rom20.length; i++) 	// 20평 체크	
									System.out.printf("%s호 : %s원 \n", rom20[i][1], rom20[i][4]);   // 1줄이라 괄호 생략

								System.out.println("== 가격 현황표 40평형 ==");
								for(int i=0; i<rom40.length; i++) 	// 40평 체크		
									System.out.printf("%s호 : %s원 \n", rom40[i][1], rom40[i][4]);   // 1줄이라 괄호 생략

								System.out.println("가격을 변경할 호수를 선택해 주세요 ex) 101 >");
								changRom = scan.next();
								
								// 기존가격 피드백
								
								for(int i=0; i<rom20.length; i++) {	// 20평 체크	
									if( rom20[i][1].equals(changRom) ) {
										System.out.printf("현재의 가격은 %s 입니다. 변경가격을 입력하세요 >", rom20[i][4] );
										System.out.println("변경될 가격을 알려주세요. >");
										changeMoney = scan.nextInt();
										rom20[i][4] = Integer.toString(changeMoney);
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40평 체크		
									if( rom40[i][1].equals(changRom) ) {
										System.out.printf("현재의 가격은 %s 입니다. 변경가격을 입력하세요 >", rom40[i][4] );
										System.out.println("변경될 가격을 알려주세요. >");
										changeMoney = scan.nextInt();
										rom40[i][4] = Integer.toString(changeMoney);
									}
								}
								
								break;
								
								// rom20[0][0] count, rom20[0][1] 호수, rom20[0][2] 사용여부
		                        // rom20[0][3] 방이름, rom20[0][4] 가격, rom20[0][5] 사용자이름
                                // rom20[0][6] 생성번호	, rom20[0][7]인원수 	
								
							case 4:
								String changRomName = null;
								String chageName = null;
								
								System.out.println("== 20평형 룸 이름 ==");
								for(int i=0; i<rom20.length; i++) 	// 20평 체크	
									System.out.printf("%s %s", rom20[i][1], rom20[i][3]);   // 1줄이라 괄호 생략

								System.out.println("== 가격 현황표 40평형 ==");
								for(int i=0; i<rom40.length; i++) 	// 40평 체크		
									System.out.printf("%s %s", rom40[i][1], rom20[i][3]);   // 1줄이라 괄호 생략

								System.out.println("이름을 변경할 호수를 선택해 주세요 ex) 101 >");
								changRom = scan.next();
								
								// 기존가격 피드백
								
								for(int i=0; i<rom20.length; i++) {	// 20평 체크	
									if( rom20[i][1].equals(changRomName) ) {
										System.out.println("변경할 이름 입력 >");
										chageName = scan.next();
										rom20[i][3] = null;
										rom20[i][3] = chageName;
										System.out.printf("%s 호실 이름이 ★%s★로 변경되었습니다. \n", rom20[i][1], rom20[i][3] );
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40평 체크		
									if( rom40[i][1].equals(changRomName) ) {
										System.out.println("변경할 이름 입력 >");
										chageName = scan.next();
										rom40[i][3] = null;
										rom40[i][3] = chageName;
										System.out.printf("%s 호실 이름이 ★%s★로 변경되었습니다. \n", rom40[i][1], rom40[i][3] );
									}
								}								
								break;
								
							case 5:
								
								break;
								
							case 9:
								adminOnOff = 2;
								
								// 현황판 리젠
								System.out.println("                예약현황판                    "); 
								System.out.println("===============================================");
								System.out.println("                   -- 20형 --                      ");
								for(int i=0; i< rom20.length; i++) { // 인원수 // 
									System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
									if( (i+1)%2 == 0) {
										System.out.println();
										for(int j=0; j<2; j++) {
										System.out.printf("       가격 : %s원           ", rom20[i][4]);					
									   }
										System.out.println();
									}
								}
								System.out.println("                   -- 40형 --                      ");
								for(int i=0; i< rom20.length; i++) {
									System.out.printf(" %s호 (%s) 예약(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
									if( (i+1)%2 == 0) {
										System.out.println();
										for(int j=0; j<2; j++) {
										System.out.printf("       가격 : %s원           ", rom40[i][4]);					
									   }
										System.out.println();
									}
								}
								System.out.println();                                            
								System.out.println("     ====== 아래 메뉴를 통해서 진행해주세요 =====      ");
								System.out.println("1. 현황확인     2. 예약 하기     3. 예약 취소");
								System.out.println("              8. 관리자        9. 종료");
								// 현황판 리젠
								
								System.out.println("관리자 모드가 해제됩니다.. 감사합니다.");								
								break;

							default:
								System.out.println("정상적인 동작이 아닙니다. 다시 진행해 주세요 ");
								break;
							}
							
							
							
						} // end of 관리자
					} // emd of 관리자 암호 승인 if
					
					else {
						System.out.println("관리자 모드가 해제 됩니다.");
					}
					
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
