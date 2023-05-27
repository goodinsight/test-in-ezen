package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest07 {
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] room = { 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0 }; // 현재 호실 예약상태 0 -> 예약 가능, 1 -> 예약 불가능
//		int mainMenu = 0;	// 메뉴의 번호를 선택하기위한 변수
//		int subMenu = 0;	// 다음 화면에서 메뉴를 선택하기 위한 변수
		int selectMenu = 0;
		
		String[] reservationStatus = { "☆예약 가능☆", "★예약불가능★" }; // room[]의 값에 따라 예약의 가능여부를 보여주기 위한 문자열 배열
		String answer = null;	// 최종 선택에 대한 답변을 문자로 입력받는 변수
		
		// 프로그램을 종료하기 전까지 반복해서 메인 메뉴를 불러주기위해 while문 사용
		hotel:
		while(true) {
			System.out.println("========================================================================================");
			
			// 배열을 반복문에 적용하여 메인 메뉴를 출력
			for(int i=1; i<=room.length; i++) {
				
				// room[]의 값은 0 과 1로 이루어져 있기 때문에 예약상태를 보여주는 reservationStatus[]에 이용
				System.out.printf("[%2d호%s ] \t", i, reservationStatus[room[i-1]]);
				if(i % 4 == 0) {
					System.out.println();
					System.out.println("========================================================================================");
				}
			}
			System.out.println();
			System.out.println("원하시는 메뉴의 번호를 선택해주세요");
			System.out.println("[1.예약] [2.예약취소] [3.호실확인] [99.종료]");
			selectMenu = scan.nextInt();
			
			// 메인메뉴에서 넘어온 두번째 메뉴화면
			switch(selectMenu) {
			
			//예약하는 메뉴
			case 1:
				System.out.print("호실을 선택해주세요. : ");
				selectMenu = scan.nextInt();
				
				// room[]의 값은 0 과 1로 이루어져 있기 때문에 예약상태를 보여주는 reservationStatus[]에 이용
				System.out.println("선택하신 호실은 "+reservationStatus[room[selectMenu-1]]+"입니다."); 
				
				if(room[selectMenu-1] == 0) {
					System.out.println(selectMenu+"호로 예약 하시겠습니까?");
					System.out.println("네 / 아니오");
					answer = scan.next();
					
					// 최종확인을 위한 답변을 받는 answer가 "네" / "아니오"중 맞는지 확인
					// "아니오" 입력시 초기 메인화면으로 이동
					if(answer.equals("네")) {
						room[selectMenu-1] = 1;
						System.out.println(selectMenu+"호로 예약 되었습니다.");
					}
					else if(answer.equals("아니오")){
						break;
					}
					else {
						System.out.println("잘못된 입력입니다.");
						break;
					}
					
				}
				else if(room[selectMenu-1] == 1) {
					break;
				}
				break;
				
			//예약을 취소하는 메뉴
			case 2:
				System.out.print("호실을 선택해주세요. : ");
				selectMenu = scan.nextInt();
				
				if(room[selectMenu] == 0) {
					System.out.println("예약되지 않은 방입니다.");
				}
				else if(room[selectMenu] == 1) {
					System.out.println(selectMenu+"호의 예약을 취소하시겠습니까?");
					System.out.println("네 / 아니오");
					answer = scan.next();
					
					if(answer.equals("네")) {
						room[selectMenu-1] = 0;
						System.out.println(selectMenu+"호의 예약을 취소하였습니다.");
					}
					
					// "아니오" 입력시 초기 메인화면으로 이동
					else if(answer.equals("아니오")){
						break;
					}
					else {
						System.out.println("잘못된 입력입니다.");
						break;
					}
				}
			case 3:
				break;
				
			// 99 입력시 hotel : while문 break 프로그램 종료
			case 99:
				System.out.println("[예약프로그램을 종료합니다]");
				break hotel;
			default:
				System.out.println("[잘못된 입력입니다.]");
			}
		}
	}

}
