/*
설계 -> 소스작성 
-> 디버그
키보드에 의한 입력 작성
방12개가 있고 => 변수? 배열? => 배열 room[12]
입력구성에서 menu변수: 1,2,3, 99를 입력받음
1을 느른경우는 방의 예약 방번호의 값이 1이면 예약상태
	1 -> 호실번호 선택(1~12) => 예약상태여부 확인
	-> 예약가능상태 -> 예약실시 -> 호실확인 => 메뉴로 복귀
	-> 예약불가상태 -> 호실번호 선택(1~12) or 메뉴로 북귀
2를 누른 경우 예약취소(예약 -> 공실) 방번호 0이면 공실
	2 -> 호실번호선택(1~12) -> 취소가능여부
	-> 취소가능 : 해당호실의 값을 0으로 -> 메뉴 복귀
	-> 취소불가 : 예약되지않은 방이라고 표시 => 메뉴복귀
3를 누른 경우는 호실 화긴 // 1인 경우 "예약됨:*" 0인경우 "예약가능*"
99를 누른 경우는 프로그램 종료
 */
package kr.co.dong.checkpoint;

import java.util.Scanner;

public class ArrayTest03 {
	public static void main(String[] args) {
		// 선언
		int[] room = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0}; // 예약 상태초기 테이블
		int[] reserRoom = new int [12];
		int input =0;
		int roomNum = 0;
		int checkNum = 0;
		
		boolean power = false;
		
		// 입력
		Scanner scan = new Scanner(System.in); // 스캐너 호출
		
		// 디스플레이
		System.out.println("========== 딜라이트 호텔 방 예약 ==========");
		System.out.println("   1호    2호   3호   4호    5호    6호");
		for(int i=0; i<room.length/2; i++) { // room 전체 빈것으로 초기화
			System.out.printf("   %2d ", room[i] );
		}
		System.out.println();
		System.out.println("   7호    8호   9호  10호   11호   12호");
		for(int i=6; i<room.length; i++) { // room 전체 빈것으로 초기화
			System.out.printf("   %2d ", room[i] );
		}
		System.out.println();
		
		System.out.println();
		System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
		System.out.println("1. 방예약      2. 예약 취소     3. 호실확인");
		System.out.println("                            99. 종료");
		
//		구동부
	
		while(!power) {
			
			System.out.println("기능선택 => "); // 기능선택
			input = scan.nextInt();
			
			for(int i=0; i<room.length; i++) { // 예약 반영
				reserRoom[i] = room[i];
			}

			switch (input) {
			
			case 1: // 예약
				System.out.println("예약하고 싶은 방을 번호 선택 => (예약완료1표기, 빈방 0표기) ");
				roomNum = scan.nextInt();
				
				if(roomNum >12) {
					System.out.println("방번호는 1~12번방입니다. 다시 부탁드립니다.");
					System.out.println("예약하고 싶은 방을 번호 선택 => (예약완료1표기, 빈방 0표기) ");	
					roomNum = scan.nextInt();
				}	
								
					if(reserRoom[roomNum-1] ==0 && roomNum <=12 && roomNum >0) {						
						System.out.printf("선택하신 방은 %d 입니다. 감사합니다. \n", roomNum);
						System.out.println("예약하신 방번호는 예약상태 1로 변경됩니다.");	
						System.out.println();
						room[roomNum-1] = 1; // 변경 방번호 확인
						// 예약된 저장 룸 배열로 값 반영
						for(int i=0; i<room.length; i++) {
							reserRoom[i] = room[i];
						}
											
						//resen
						System.out.println("========== 딜라이트 호텔 방 예약 ==========");
						System.out.println("   1호    2호   3호   4호    5호    6호");				
						for(int i=0; i<room.length/2; i++) { // room 전체 빈것으로 초기화
							System.out.printf("   %2d ", reserRoom[i] );
						}
						System.out.println();
						System.out.println("   7호    8호   9호  10호   11호   12호");
						for(int i=6; i<room.length; i++) { // room 전체 빈것으로 초기화
							System.out.printf("   %2d ", reserRoom[i]);
						}
						System.out.println();

						System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
						System.out.println("1. 방예약      2. 예약 취소     3. 호실확인");
						System.out.println("                            99. 종료");
						// resen 종료
						
					} // end of if
					else {
						System.out.println("예약이 완료된 방입니다. 0으로 표기된 방을 선택해 주세요");
						break;
					}
				
				break;

			case 2: // 예약취소
				System.out.println("예약을 취소하고 싶은 방번호 =>");
				checkNum = scan.nextInt();
				
				if(reserRoom[checkNum-1] == 0 ) { // 입력값확인
					System.out.println("빈 방입니다. 다른 호수를 선택하신거 같습니다.");
					System.out.println("확인후 정확한 방번호를 선택하세요>");
					
					checkNum = scan.nextInt();
				}
	
				if(reserRoom[checkNum-1] ==1 && checkNum <=12 && checkNum >0) {
					System.out.printf("예약 취소 방은 %d 입니다. 감사합니다. \n", checkNum);
					System.out.println("예약하신 방은 취소상태 0으로 변경됩니다.");
					System.out.println();
					reserRoom[checkNum-1] = 0; // 변경 방번호 확인	
					
					//resen
					System.out.println("========== 딜라이트 호텔 방 예약 ==========");
					System.out.println("   1호    2호   3호   4호    5호    6호");				
					for(int i=0; i<room.length/2; i++) { // room 전체 빈것으로 초기화
						System.out.printf("   %2d ", reserRoom[i] );
					}
					System.out.println();
					System.out.println("   7호    8호   9호  10호   11호   12호");
					for(int i=6; i<room.length; i++) { // room 전체 빈것으로 초기화
						System.out.printf("   %2d ", reserRoom[i]);
					}
					System.out.println();

					System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
					System.out.println("1. 방예약      2. 예약 취소     3. 호실확인");
					System.out.println("                            99. 종료");
					// resen 종료
				}
			
				break;				
				
			case 3: // 확인
				System.out.println("각 호실 예약 상태");
				for(int i=1; i<=reserRoom.length; i++) {
					if(reserRoom[i-1]==1) {
						System.out.printf("%4d호 : 예약됨   ★", i );				
					}
					else {
						System.out.printf("%4d호 : 예약가능 ☆", i );						
					}
					if(i%4==0)
						System.out.println();
				}
				System.out.println();
				
				//resen
				System.out.println("========== 딜라이트 호텔 방 예약 ==========");
				System.out.println("   1호    2호   3호   4호    5호    6호");				
				for(int i=0; i<room.length/2; i++) { // room 전체 빈것으로 초기화
					System.out.printf("   %2d ", reserRoom[i] );
				}
				System.out.println();
				System.out.println("   7호    8호   9호  10호   11호   12호");
				for(int i=6; i<room.length; i++) { // room 전체 빈것으로 초기화
					System.out.printf("   %2d ", reserRoom[i]);
				}
				System.out.println();

				System.out.println("====== 아래 메뉴를 통해서 진행해주세요 ======");
				System.out.println("1. 방예약      2. 예약 취소     3. 호실확인");
				System.out.println("                            99. 종료");
				// resen 종료
				
				break;
				
			case 99: //종료
				power = true;
				System.out.println("모든 요청사항이 마무리 되었습니다. 감사합니다.");	
				break;

			default:
				System.out.println("정상적인 동작이 아닙니다. 다시 진행해 주세요 ");
				break;
			}
			
		} // end of while
	System.out.println("예약 시스템 종료.");
} // end of main
} // end of class
