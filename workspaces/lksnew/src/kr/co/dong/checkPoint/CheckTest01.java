/*
설계 -> 소스작성 -> 디버그
키보드에 의한 입력작성
방 12개가 있고 => 변수? 배열? => 배열 room[12]
입력 구성에서 // menu변수 : 1,2,3,99를 입력받음
1을 누른경우는 방의 예약, // room[방번호]의 값이 1이면 예약상태
	1-> 호실번호 선택(1~12) -> 예약상태여부 확인
	-> 예약 가능상태 -> 예약 실시-> 호실확인 => 메뉴로 복귀
	-> 예약 불가상태 -> 호실번호 선택(1~12) or 메뉴로 복귀
2를 누른경우는 예약 취소(예약->공실), // room[방번호]의 값이 0이면 공실
	2-> 호실번호 선택(1~12) -> 취소가능여부
	-> 취소가능 : 해당호실의 값을 0으로 => 메뉴복귀
	-> 취소불가 : 예약되지않은 방이라고 표시. => 메뉴복귀
3을 누른경우는 호실 확인, // 1인 경우는 "예약됨:★" 0인 경우는 "예약가능☆"

99를 누른 경우는 프로그램 종료

*/
package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {
	public static void main(String[] args) {
// 변수 선언
		boolean sysoff = true;
		int roomNum = 12; // 방의 갯수
		int option = 2; // 방의 상태(옵션)
		int power = 99; // menu 변수로 99 입력시 프로그램 종료
		
		String[] menu = { "방의 예약", "예약 취소", "호실 확인"};
		String[] message = { "예약가능☆", "예약됨:★" }; // 예약 가능 상태에 따른 메세지 표시
		String[][] room = new String[roomNum][option]; // 방 배열로 정리
// 방 이름 예약상태 옵션 초기화
		for(int i = 0; i<room.length; i++) {
			room[i][0] = Integer.toString(i+1)+"호실";
			room[i][1] = Integer.toString(0);
//			room[i][2] = "스위트룸";
		}
		
// main stream
		while (true) {
			showMenu(menu, power);
			int result = firstMenuNumber(menu, power);
			if (result == power) {
				break;
			}
			sysoff = moveToNextMenu(result, room, message);
			if(sysoff == false) {
				break;
			}
		}// main stream end
		
		System.out.println("시스템을 종료합니다.");
	}

	
	
/* 메소드	*/
	
	private static boolean moveToNextMenu(int result, String[][] room,String[] message) {
		// 메뉴 선택 결과에 따라 다음 메뉴 화면(showNextMenu)으로 이동
		boolean tmp = true;
		switch(result) {
		case 1: 
			showReservationMenu(room);
			break;
		case 2:
			showCancelMenu(room);
			break;
		case 3:
			showRoomStateMenu(room, message);
			break;
		case 4:
			break;
		case 99:
			tmp = false;
			break;
		}
		return tmp;
	}

	private static void showRoomStateMenu(String[][] room, String[] message) {
		// 룸 상태 화면
		while(true) {
			System.out.println("=======================================");
			System.out.println("          <room 상태 화면>            ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
			}
			System.out.println("=======================================");

			System.out.printf("호실 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = stateRoom(result, room, message);
			if (res==false)
				break;
		}
	}

	
	private static void showCancelMenu(String[][] room) {
		/// 예약 취소 화면
		while(true) {
			System.out.println("=======================================");
			System.out.println("          <room 예약 취소 화면>            ");
			System.out.println();
			
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
			}
			System.out.println("=======================================");

			System.out.printf("호실 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = cancelRoom(result, room);
			if (res==false)
				break;
		}
	}

	private static void showReservationMenu(String[][] room) {
		// 예약 메뉴화면
		while(true) {
			System.out.println("=======================================");
			System.out.println("            <room 예약 화면>              ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i%3 == 2)
					System.out.println();
	//			System.out.printf("예약 상태는 %s 입니다.%n", room[i][1]);
			}
			System.out.println("=======================================");
	//		String[] reservMenu = {"호실번호 선택"};
	//		for (int i = 0; i < reservMenu.length; i++) {
	//			System.out.printf("%d. %s   ", i + 1, reservMenu[i]);
	//		}
			System.out.printf("호실 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n",room.length,room.length+1);
			
			String[] reservMenu = new String[room.length+1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			
			int result = inputMenuNumber(reservMenu);
			boolean res = reserveRoom(result, room);
			if (res==false)
				break;
		}
	}

	private static boolean reserveRoom(int result, String[][] room) {
		// 방 예약하기
		if (result == room.length+1) {
			return false;
		}else {
//			System.out.println(room[result-1][0]+"의 예약 상태는" +room[result-1][1]+ "입니다.");
			if (room[result-1][1].equals("0")) {
				System.out.println("현재"+room[result-1][0]+"은 예약 가능 상태입니다.");
				System.out.println("예약을 진행하겠습니다.");
				System.out.println(room[result-1][0]+"을 예약하였습니다.");
				room[result-1][1] = "1";
			}else {
				System.out.println("현재"+room[result-1][0]+"은 예약 불가능 상태입니다.");
			}
			return true;
		}
			
	}
	private static boolean cancelRoom(int result, String[][] room) {
		// 방 취소하기
		if (result == room.length+1) {
			return false;
		}else {
//			System.out.println(room[result-1][0]+"의 예약 상태는" +room[result-1][1]+ "입니다.");
			if (room[result-1][1].equals("1")) {
				System.out.println("현재"+room[result-1][0]+"은 예약상태입니다.");
				System.out.println("예약취소를 진행하겠습니다.");
				System.out.println(room[result-1][0]+"를 취소하였습니다.");
				room[result-1][1] = "0";
			}else {
				System.out.println("현재"+room[result-1][0]+"은 미예약 상태입니다.");
			}
			return true;
		}
	}
	private static boolean stateRoom(int result, String[][] room, String[] message) {
		// 방 상태 확인하기
				if (result == room.length+1) {
					return false;
				}else {
					if (room[result-1][1].equals("1")) {
						System.out.println("현재"+room[result-1][0]+" : "+message[1]);
					}else {
						System.out.println("현재"+room[result-1][0]+" : "+message[0]);
					}
					return true;
				}
	}
	private static int inputMenuNumber(String[] menu) {
		// 메뉴를 선택하면 이를 받아서 int로 return
		int result = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				}
				else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요. :");
				}
			} catch(Exception e){ // 예외처리 정수 이외의 값이 들어올 경우 다시 입력 받음
				System.out.println("정수만 입력하실수 있습니다. 다시 입력하세요.");
			}
		}
		return result;
	}
	private static int firstMenuNumber(String[] menu, int power) {
		// power 입력시 프로그램 종료를 위해 추가함
		int result = 0;
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				}else if(choice == power){
					result = power;
					break;
				}else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요. :");
				}
			} catch(Exception e){ // 예외처리 정수 이외의 값이 들어올 경우 다시 입력 받음
				System.out.println("정수만 입력하실수 있습니다. 다시 입력하세요.");
			}
		}
		return result;
	}
	private static void showMenu(String[] menu, int power) {
		// 처음 메뉴화면
		System.out.println("=======================================");
		System.out.println("           <** 호텔 예약 시스템>            ");
		System.out.println();
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, menu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    시스템을 종료 (%d)입력%n", power);
		System.out.println("=======================================");

		System.out.printf("메뉴를 고르세요:(1~%d) %n", menu.length);
		
	}
}
