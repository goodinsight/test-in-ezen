package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest05 {
	public static void main(String[] args) {
//		* 설계 -> 소스작성 -> 디버그
//		* 키보드에 의한 입력작성
//		* 방12개가 있고 ==> 변수?배열? ==> 배열 room[12] (reserve 예약여부가 데이터에 들어있음)

//		* 입력구성에서                                //menu변수 : 1,2,3,99를 입력받음
//		* 1을 누른경우는 방의 예약,                     // room[방번호]의 값이 1이면 예약상태
//		*     1 -> 호실번호 선택(1~12) -> 예약 상태여부 확인
//		*       -> 예약가능상태 -> 예약실시 -> 호실확인 -> 메뉴로 복귀

//		* 2를 누른 경우 예약취소(예약->공실),             // room[방번호]의 값이 0이면 공실
//		*        2  -> 호실번호 선택(1~12) -> 취소가능 여부
//		*     -> 취소가능 : 해당호실의 값을 0으로 -> 메뉴복귀
//		*   -> 취소불가 : 예약되지 않은 방이라고 표시 -> 메뉴복귀

//		* 3을 누른경우는 호실확인, //1인 경우는 "예약됨☆" 0인경우는 "예약가능☆"
//		* 99를 누른 경우는 프로그램 종료.

		boolean power = false;
		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // 방 호실 인덱스
		int menu = 0; // 메뉴 번호 고르기
		int select = 0; // 호실 고르기
		int cancel = 0; // 취소 할 호실 고르기

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("                                          ");
			System.out.println("                 ※예약※                    ");
			System.out.println("           이용하실 메뉴를 눌러주세요.            ");
			System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
			System.out.println("           ⑴. 방 예약 하기");
			System.out.println("           ⑵. 방 예약 취소");
			System.out.println("           ⑶. 호실 확인 ");
			System.out.println("           ⑼⑼.  종료   ");
			System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.println("> 방 예약 하기 입니다.");
				System.out.println("> 예약하실 호수를 눌러주세요.");
				select = scan.nextInt();
				System.out.println(select + "호실을 선택 하였습니다.");
				if (room[select - 1] == 1) {
					System.out.println(select + "호실은 예약이 불가능합니다");
					System.out.println("메뉴로 돌아갑니다. 메뉴를 다시 선택해주세요");
					System.out.println();
					break;
				}
				System.out.println(select + "호실이 예약이 가능합니다.");
				System.out.println(select + "호실이 예약되었습니다.");
				room[select - 1] = 1;
				System.out.println();

				break;
			case 2:
				System.out.println("> 방 예약 취소 입니다.");
				System.out.println("> 예약 취소하실 호수를 눌러주세요.");
				cancel = scan.nextInt();
				System.out.println(cancel + "호실을 선택 하였습니다.");
				if (room[cancel - 1] == 1) {
					System.out.println(cancel + "호실의 취소가 가능합니다.");
					System.out.println(cancel + "호실이 취소되었습니다.");
					room[cancel - 1] = 0;
					System.out.println();
					break;
				}
				System.out.println("예약이 되어있지 않아 취소가 불가합니다.");
				System.out.println();
				break;
			case 3:
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞ 현재 호실 예약현황입니다.∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				for (int i = 0; i < room.length; i++) {
					System.out.print((i + 1) + "호실) : " + room[i]);
//					System.out.println();
					if (room[i] == 0) {
						System.out.println("  ▶ 예약가능 O");
					} else if (room[i] == 1) {
						System.out.println("  ▷ 예약불가능 X");
					}
				}
				break;

			case 99:
				power = true;
				System.out.println("시스템을 종료합니다.");
				break;
			}

		}

	}

}
