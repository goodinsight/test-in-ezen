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

=> 추가사항 :  1. 객실규모(갯수)는 시작과 동시에 입력함
			2. 호텔방번호/ 호텔방명(예-로얄/참나무 등)/ 객실인원/ 가격
			3. 예약시 예약자명 / 예약번호(취소시 필요) 등
			4. 기타 필요한 기능(관리자 모드)

=> 보완해야할 사항
	1. method를 더욱 세분화 시켜야 함
	2. 입력은 무조건 String으로 받아서 상황에 따라 이를 int나 다른 type으로 변경시켜는게 더 효율적일듯
		-> 입력 method 앞으로 여러가지 만들어놓고 시작할것
	3. class 변수로 선언하여 method parameter를 줄일것
	4. 1번과 이어지는 얘기지만 하나의 class에서 다 하려고 하지말고 class를 추가하고, 추가한 class를 호출하여 사용하도록 연습할 것.
	5. 메뉴화면 규격을 처음에 만들어서 이를 세분화 시켜놓고 합쳐쓰는 방법(?)을 생각해보자.......

*/

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest17_3 {
	static int roomNum = 12; // 방의 갯수
	static int option = 7; // 방의 상태(옵션) 갯수
	static int power = 99; // menu 변수로 99 입력시 프로그램 종료
	static int password = 1234; // 관리자 메뉴 비밀번호
	static boolean sysoff = true;
	static String[][] room;
	static String[] reserveInfo = { "예약자명", "예약번호" };

	public static void main(String[] args) {
// 변수 선언
		String[] menu = { "방 정보", "방의 예약", "예약 취소", "호실 확인" }; // , "방 옵션별 검색"};
		String[] initMenu = { "객실규모", "객실정보입력", "객실정보default로 세팅" };
		String[] adminMenu = { "객실정보수정", "예약현황" }; // , "날짜별 관리 메뉴" };
		String[] roomOption = { "방번호", "호텔방명", "객실인원", "가격", "예약가능상태", "예약자명", "예약번호" }; // 예약가능상태,예약자명,예약번호 위치는 끝에서
																									// 3번째부터로 변경불가
		String[] message = { "예약가능☆", "예약됨:★" }; // 예약 가능 상태에 따른 메세지 표시
//		시작과 동시에 관리자 모드에서 객실규모 입력을 받음		
		while (true) {
			showInit(initMenu, power);
			int result = firstMenuNumber(initMenu, power); // power 입력시 관리자 모드 밖으로 나옴
			if (result == power) {
				break;
			}
			sysoff = moveToNextInitMenu(result, roomOption);
			if (sysoff == false) {
				break;
			}
		}

// main stream
		while (true) {
			showMenu(menu, power); // 메인 뷰
			int result = firstMenuNumber(menu, power);
			if (result == power) {
				break;
			}
			if (result == password) { // 관리자모드 비번 입력시 동작
				while (true) {
					showAdmin(adminMenu, power);
					result = firstMenuNumber(adminMenu, power); // power 입력시 관리자 모드 밖으로 나옴
					if (result == power) {
						break;
					}
					boolean res = moveToNextAdminMenu(result, roomOption);
					if (res == false) {
						break;
					}
				}
				result = 0;
			} // 관리자모드 끝
			sysoff = moveToNextMenu(result, room, message);
			if (sysoff == false) { // 프로그램 종료
				break;
			}
		} // main stream end
		System.out.println("시스템을 종료합니다.");
	} // main end
// 메소드

	private static boolean moveToNextAdminMenu(int result, String[] roomOption) {
		// 관리자 메뉴 선택 결과에 따라 다음 메뉴 화면(showNextMenu)으로 이동
		boolean tmp = true;
		switch (result) {
		case 1:
			modifyRoomInfor(roomOption);
			break;
		case 2:
			reservationStatus();
			break;
		case 3:
			reserve();
			break;
		case 99:
			tmp = false;
			break;
		default:
			System.out.println("다시 입력하세요.");
		}
		return tmp;
	}

	private static void reserve() {
		// 날짜별 정보를 한눈에 볼수 있음
		System.out.println("아직 구현 전임");
	}

	private static void reservationStatus() {
		// 룸별 예약 현황을 한눈에 보고 이를 취소하거나 예약을 잡아줄 수 있음
		while (true) {
			System.out.println("==================================================");
			System.out.println("                 <Reservation Status>               ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s -예약자명: %5s, -예약번호: %5s ", i + 1, room[i][0], room[i][room[0].length - 2],
						room[i][room[0].length - 1]);
				System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("예약정보를 수정하고 싶은 방 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n", room.length, room.length + 1);

			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = modifyReservation(result);
			if (res == false)
				break;
		}
	}

	private static boolean modifyReservation(int num) {
		//
		if (num == room.length + 1) {
			return false;
		} else {
			if (room[num - 1][room[0].length - 3].equals("0")) {
				System.out.println("선택하신 방은 예약이 되어있지 않습니다.");
				while (true) {
					System.out.println("예약을 하시겠습니까?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("예약자명: ");
						room[num - 1][room[0].length - 2] = reserveInfo[0] = scan.next(); // 룸 정보에 예약자명과 예약번호 저장
						System.out.println("예약번호: ");
						room[num - 1][room[0].length - 1] = reserveInfo[1] = scan.next();
						System.out.println(room[num - 1][0] + "을 예약하였습니다.");
						System.out.println("예약자명은 " + reserveInfo[0] + "이고, 예약번호: " + reserveInfo[1] + "으로 예약되었습니다.");
						room[num - 1][room[0].length - 3] = "1";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("정보가 변경되지 않았습니다.");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
					}
				}
			} else if (room[num - 1][room[0].length - 3].equals("1")) {
				System.out.println("선택하신 방은 예약이 되어있습니다.");
				while (true) {
					System.out.println("예약을 취소 시키겠습니까?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("예약자명은 " + room[num - 1][room[0].length - 1] + "이고, 예약번호: "
								+ room[num - 1][room[0].length - 2] + "인");
						System.out.println(room[num - 1][0] + "을 예약취소하였습니다.");
						room[num - 1][room[0].length - 2] = reserveInfo[0] = ""; // 룸 정보에 예약자명과 예약번호 지움
						room[num - 1][room[0].length - 1] = reserveInfo[1] = "";
						room[num - 1][room[0].length - 3] = "0";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("정보가 변경되지 않았습니다.");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
					}
				}
			}
			return true;
		}
	}

	private static void modifyRoomInfor(String[] roomOption) {
		// 룸 번호를 선택하고 하나씩 정보를 수정할수 있는 화면
		while (true) {
			showRoomInfor();
			System.out.printf("수정하고 싶은 방 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int tmp3 = inputMenuNumber(reservMenu);
			if (tmp3 == reservMenu.length) {
				break;
			}
			System.out.println(
					roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3] + "를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String tmp = scan.next();
			String[] tmp2 = tmp.split(",");
			for (int j = 0; j < tmp2.length; j++) {
				room[tmp3 - 1][j] = tmp2[j];
			}
			System.out.println("다음과 같이 수정되었습니다.");
			System.out.printf("%2d. %4s -등급: %3s, -객실인원: %s, -가격/1일: %9s %n", tmp3, room[tmp3 - 1][0],
					room[tmp3 - 1][1], room[tmp3 - 1][2], room[tmp3 - 1][3]);
		}
	}

	private static boolean moveToNextInitMenu(int result, String[] roomOption) {
		// 초기화 메뉴 선택 결과에 따라 다음 메뉴 화면(showNextMenu)으로 이동
		boolean tmp = true;
		switch (result) {
		case 1:
			setRoomSize(roomNum, option);
			break;
		case 2:
			setRoom(roomNum, option, roomOption);
			break;
		case 3:
			setRoomDefault(roomNum, option);
			break;
		case 99:
			tmp = false;
			break;
		default:
			System.out.println("다시 입력하세요.");
		}
		return tmp;
	}

	private static void setRoomDefault(int roomNum2, int option2) {
		// 기본값 자동 세팅
		room = new String[roomNum2][option2];
		for (int i = 0; i < room.length; i++) {
			room[i][0] = Integer.toString(i / 3 + 1) + "0" + Integer.toString(i % 3 + 1) + "호";
			if (i % 3 == 0) {
				room[i][1] = "로얄";
				room[i][2] = "2인실";
				room[i][3] = "100,000원";
			}
			if (i % 3 == 1) {
				room[i][1] = "스위트";
				room[i][2] = "3인실";
				room[i][3] = "150,000원";
			}
			if (i % 3 == 2) {
				room[i][1] = "VIP";
				room[i][2] = "4인실";
				room[i][3] = "200,000원";
			}
			room[i][4] = Integer.toString(0);
			room[i][5] = "";
			room[i][6] = "";

		}
	}

	private static void setRoom(int roomNum2, int option2, String[] roomOption) {
		// 객실 옵션 세팅
		System.out.println("방 순서대로" + roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3]
				+ "를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < room.length; i++) {
			System.out.println(
					roomOption[0] + ", " + roomOption[1] + ", " + roomOption[2] + ", " + roomOption[3] + "를 입력하세요.");
			String tmp = scan.nextLine();
			String[] tmp2 = tmp.split(",");
			for (int j = 0; j < tmp2.length; j++) {
				room[i][j] = tmp2[j];
			}
			room[i][room[0].length - 3] = "0"; // 객실 예약정보 "0"로 세팅
			room[i][room[0].length - 2] = ""; // 객실 예약자 정보 ""로 세팅
			room[i][room[0].length - 1] = ""; // 개실 예약번호 정보 ""로 세팅
		}
	}

	private static void setRoomSize(int Num, int option) {
		// 객실 규모 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("객실의 크기를 입력하세요:");
		Num = scan.nextInt();
		roomNum = Num;
		room = new String[Num][option]; // 방 배열로 정리
		System.out.println("객실 크기가 " + Num + "개로 세팅되었습니다.");
		for (int i = 0; i < room.length; i++) {
			room[i][0] = Integer.toString(i / 3 + 1) + "0" + Integer.toString(i % 3 + 1) + "호";
			if (i % 3 == 0) {
				room[i][1] = "로얄";
				room[i][2] = "2인실";
				room[i][3] = "100,000원";
			}
			if (i % 3 == 1) {
				room[i][1] = "스위트";
				room[i][2] = "3인실";
				room[i][3] = "150,000원";
			}
			if (i % 3 == 2) {
				room[i][1] = "VIP";
				room[i][2] = "4인실";
				room[i][3] = "200,000원";
			}
			room[i][4] = Integer.toString(0);
		}
	}

	private static void showInit(String[] initMenu, int power) {
		// 관리자 모드 실행
		System.out.println("==================================================");
		System.out.println("               <초기 세팅 메뉴>              ");
		System.out.println();
		for (int i = 0; i < initMenu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, initMenu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    초기 세팅 메뉴를 종료 (%d)입력%n", power);
		System.out.println("==================================================");
		System.out.println();
		System.out.printf("메뉴를 고르세요:(1~%d) %n", initMenu.length);
	}

	private static void showAdmin(String[] initMenu, int power) {
		// 관리자 모드 실행
		System.out.println("==================================================");
		System.out.println("               <관리자 메뉴>              ");
		System.out.println();
		for (int i = 0; i < initMenu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, initMenu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    관리자메뉴를 종료 (%d)입력%n", power);
		System.out.println("==================================================");
		System.out.println();
		System.out.printf("메뉴를 고르세요:(1~%d) %n", initMenu.length);
	}

	private static boolean moveToNextMenu(int result, String[][] room, String[] message) {
		// 메뉴 선택 결과에 따라 다음 메뉴 화면(showNextMenu)으로 이동
		boolean tmp = true;
		switch (result) {
		case 1:
			showRoomInfor();
			break;
		case 2:
			showReservationMenu(room);
			break;
		case 3:
			showCancelMenu(room);
			break;
		case 4:
			showRoomStateMenu(room, message);
			break;
		case 5:
			searchRoomInfor();
		case 99:
			tmp = false;
			break;
		}
		return tmp;
	}

	private static void searchRoomInfor() {
		// 옵션별 선택시 해당하는 방 정보만 표시해 줌
		System.out.println("옵션별 선택시 해당하는 방 정보만 표시해 줌");
		System.out.println("아직 구현 전임");
	}

	private static void showRoomInfor() {
		// 룸 정보를 전체적으로 보여준다.
		while (true) {
			System.out.println("==================================================");
			System.out.println("                 <room Information>               ");
			System.out.println(" 안내 - 예약 가능한 방 정보만 표시됩니다.                    ");
			for (int i = 0; i < room.length; i++) {
				if (room[i][room[0].length - 3].equals("0")) { // 예약 가능한 방 정보만 표시
					System.out.printf("%2d. %4s -등급: %3s, -객실인원: %s, -가격/1일: %9s ", i + 1, room[i][0], room[i][1],
							room[i][2], room[i][3]);
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("예약을 원하시면 이전메뉴에서 room예약메뉴를 이용하세요(이전 메뉴 :%d 입력)%n", room.length + 1);
			Scanner scan = new Scanner(System.in);
			int res = scan.nextInt();
			if (res == room.length + 1) {
				break;
			}
		}
	}

	private static void showRoomStateMenu(String[][] room, String[] message) {
		// 룸 상태 화면
		while (true) {
			System.out.println("==================================================");
			System.out.println("                   <room 상태 화면>                  ");
			System.out.println();
			String state;
			for (int i = 0; i < room.length; i++) {
				if (room[i][room[0].length - 3].equals("0")) {
					state = "예약가능☆";
				} else {
					state = "예약불가★";
				}
				System.out.printf("%2d. %4s-%s  ", i + 1, room[i][0], state);
				if (i % 3 == 2) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("예약을 원하시면 이전메뉴에서 room예약메뉴를 이용하세요(이전 메뉴 :%d 입력)%n", room.length + 1);
			Scanner scan = new Scanner(System.in);
			int res = scan.nextInt();
			if (res == room.length + 1) {
				break;
			}
		}
	}

	private static void showCancelMenu(String[][] room) {
		/// 예약 취소 화면
		while (true) {
			System.out.println("==================================================");
			System.out.println("                <room 예약 취소 화면>                  ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. %4s   ", i + 1, room[i][0]);
				if (i % 3 == 2)
					System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("호실 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = cancelRoom(result, room);
			if (res == false)
				break;
		}
	}

	private static void showReservationMenu(String[][] room) {
		// 예약 메뉴화면
		while (true) {
			System.out.println("==================================================");
			System.out.println("                   <room 예약 화면>                   ");
			System.out.println();
			for (int i = 0; i < room.length; i++) {
				System.out.printf("%2d. [%4s %s]  ", i + 1, room[i][0], room[i][1]);
				if (i % 3 == 2)
					System.out.println();
			}
			System.out.println();
			System.out.println("==================================================");
			System.out.printf("호실 번호를 고르세요:(1~%d)(이전 메뉴 :%d 입력)%n", room.length, room.length + 1);
			String[] reservMenu = new String[room.length + 1];
			for (int i = 0; i < room.length; i++) {
				reservMenu[i] = room[i][0];
			}
			int result = inputMenuNumber(reservMenu);
			boolean res = reserveRoom(result, room);
			if (res == false)
				break;
		}
	}

	private static boolean reserveRoom(int result, String[][] room) {
		// 방 예약하기
		if (result == room.length + 1) {
			return false;
		} else {
//			System.out.println(room[result-1][0]+"의 예약 상태는" +room[result-1][1]+ "입니다.");
			if (room[result - 1][room[0].length - 3].equals("0")) {
				System.out.println("현재" + room[result - 1][0] + "은 예약 가능 상태입니다.");
				System.out.println("예약을 진행하겠습니다. 예약자명,예약번호를 입력하세요.");
				Scanner scan = new Scanner(System.in);
				System.out.println("예약자명: ");
				room[result - 1][room[0].length - 2] = reserveInfo[0] = scan.next(); // 룸 정보에 예약자명과 예약번호 저장
				System.out.println("예약번호:(예약취소시 필요) ");
				room[result - 1][room[0].length - 1] = reserveInfo[1] = scan.next();
				System.out.println(room[result - 1][0] + "을 예약하였습니다.");
				System.out.println("예약자명은 " + reserveInfo[0] + "이고, 예약번호: " + reserveInfo[1] + "으로 예약되었습니다.");
				room[result - 1][room[0].length - 3] = "1";
			} else {
				System.out.println("현재" + room[result - 1][0] + "은 예약 불가능 상태입니다.");
			}
			return true;
		}
	}

	private static boolean cancelRoom(int result, String[][] room) {
		// 방 취소하기
		if (result == room.length + 1) {
			return false;
		} else {
//			System.out.println(room[result-1][0]+"의 예약 상태는" +room[result-1][1]+ "입니다.");
			if (room[result - 1][room[0].length - 3].equals("1")) {
				System.out.println("현재" + room[result - 1][0] + "은 예약상태입니다.");
				while (true) {
					System.out.println("예약취소를 진행하겠습니까?(y/n)");
					Scanner scan = new Scanner(System.in);
					String tmp = scan.next();
					if (tmp.equals("y")) {
						System.out.println("예약자명,예약번호를 입력하세요.");
						System.out.println("예약자명: ");
						reserveInfo[0] = scan.next(); // 룸 정보에 예약자명과 예약번호 저장
						if (!room[result - 1][room[0].length - 2].equals(reserveInfo[0])) {
							System.out.println("예약자명이 일치하지 않습니다. 처음부터 다시 진행하세요.");
							continue;
						}
						System.out.println("예약번호:(예약취소시 필요) ");
						reserveInfo[1] = scan.next(); // 룸 정보에 예약자명과 예약번호 저장
						if (!room[result - 1][room[0].length - 1].equals(reserveInfo[1])) {
							System.out.println("예약번호가 일치하지 않습니다. 처음부터 다시 진행하세요.");
							continue;
						}
						System.out.println(room[result - 1][0] + "가 취소되었습니다.");
						room[result - 1][room[0].length - 3] = "0";
						break;
					} else if (tmp.equals("n")) {
						System.out.println("예약취소를 진행하지 않았습니다.");
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
					}
				}
			} else {
				System.out.println("현재" + room[result - 1][0] + "은 미예약 상태입니다.");
			}
			return true;
		}
	}

	private static int inputMenuNumber(String[] menu) {
		// 메뉴를 선택하면 이를 받아서 int로 return
		int result = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요. :");
				}
			} catch (Exception e) { // 예외처리 정수 이외의 값이 들어올 경우 다시 입력 받음
				System.out.println("정수만 입력하실수 있습니다. 다시 입력하세요.");
			}
		}
		return result;
	}

	private static int firstMenuNumber(String[] menu, int power) {
		// power 입력시 프로그램 종료를 위해 추가함
		int result = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				int choice = scan.nextInt();
				if (choice >= 1 && choice <= menu.length) {
					result = choice;
					break;
				} else if (choice == power) {
					result = power;
					break;
				} else if (choice == password) {
					result = password;
					break;
				} else {
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요. :");
				}
			} catch (Exception e) { // 예외처리 정수 이외의 값이 들어올 경우 다시 입력 받음
				System.out.println("정수만 입력하실수 있습니다. 다시 입력하세요.");
			}
		}
		return result;
	}

	private static void showMenu(String[] menu, int power) {
		// 처음 메뉴화면
		System.out.println("==================================================");
		System.out.println("                   <** 호텔 예약 시스템>            ");
		System.out.println();
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s   ", i + 1, menu[i]);
		}
		System.out.println();
		System.out.println();
		System.out.printf("                    시스템을 종료 (%d)입력%n", power);
		System.out.println("==================================================");
		System.out.printf("메뉴를 고르세요:(1~%d) %n", menu.length);
	}
}
