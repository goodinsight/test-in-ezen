/*
 *  작성자 : 양진율	 날짜 : 2023.05.24
 *  
 *  
 */

package kr.co.dong.checkPoint;

import java.util.Arrays;
import java.util.Scanner;

public class Hotel_1 {

	public static void main(String[] args) {

		final int MAX_ROOM = 12;
		
		boolean[] room = null;
		
		int menu;
		
		int input;
		
		boolean power;
		
		Scanner scan;
		
		//초기화
		room = new boolean[MAX_ROOM];
		Arrays.fill(room, false);
		
		menu = 0;
		
		power = false;
		
		scan = new Scanner(System.in);
		
		/*
		 * 방이 많아지면 초기화면에는 출력하지 않는다거나
		 * 
		 * 예약 가능한 방만, 예약 취소가 가능한 방만 보여준다거나
		 * 
		 * 아예 예약 가능한 방 중에서 랜덤으로 배정해준다거나
		 * 
		 * 예약 취소시 비밀번호 같은거는?
		 * 
		 */
		
		while(!power) {
			switch(menu) {
			case 0://초기화면
				
				//현재 예약상태
				// 3번 호실 확인 추가시 삭제
				System.out.println("\n\n== 현재 예약 상태 ======================");
				
				String tmp = "";
				for(int i = 0; i < MAX_ROOM; i++) {
					
					String star = room[i] ? "★":"☆";
					tmp += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmp += "\n";
				}
				System.out.println(tmp);
				
				System.out.println("====================================");
				System.out.println("★ : 예약 불가, ☆ : 예약 가능");
				
				//메뉴 안내
				System.out.println("\n입력 안내\n"
						+ "1\t: 예약\n"
						+ "2\t: 예약 취소\n"
//						+ "3\t: 예약 현황 확인\n"
						+ "99\t: 종료");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 : case 2: case 99:
							menu = input;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 1://예약

				System.out.println("예약하시고 싶은 방 번호를 입력해주세요.(취소 : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {
						menu = 0;
					}else if(room[input-1]) {
						System.out.println("이미 예약되어있는 방입니다.");
					}else {
						room[input-1] = true;
						menu = 0;
						System.out.println("예약되었습니다.");
					}
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			case 2://예약취소
				
				System.out.println("예약을 취소하시고 싶은 방 번호를 입력해주세요.(취소 : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {
						menu = 0;
					}else if(!room[input-1]) {
						System.out.println("예약이 되어있지 않은 방입니다.");
					}else {
						room[input-1] = false;
						menu = 0;
						System.out.println("예약이 취소되었습니다.");
					}
					
				} catch (Exception e) {
					System.out.println("잘못된 입력입니다.");
					scan.nextLine();
				}
				
				break;
				
			/*
			case 3 : //호실 확인
				System.out.println("\n\n== 현재 예약 상태 ======================");
				
				String tmp = "";
				for(int i = 0; i < MAX_ROOM; i++) {
					
					String star = room[i] ? "V":"_";
					tmp += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmp += "\n";
				}
				System.out.println(tmp);
				
				System.out.println("====================================");
				System.out.println("V : 예약 불가, _ : 예약 가능");
				
				menu = 0;
				break;
			
			 */
				
			case 99://종료
				System.out.println("프로그램을 종료합니다.");
				power = true;
				break;
				
			}
		}
		
		scan.close();
		
	}

}
