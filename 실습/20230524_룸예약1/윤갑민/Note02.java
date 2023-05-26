package kr.co.dong.note;

import java.util.Scanner;

public class Note02 {

	public static void main(String[] args) {

		/*
		 * 키보드에 의한 입력 작성 방 12개가 있고 => 변수/배열 => 배열 room[12] 입력 구성에서 // 메뉴 변수 : 1.2.3.99를
		 * 입력받음 1을 누른 경우는 방의 예약 // 룸[방번호]의 값이 1이면 예약상태 -> 호실 번호 선택 (1~12) -> 예약상태 여부 확인
		 * -> 예약가능 상태 -> 예약 실시 -> 호실 확인 => 메뉴로 복귀 예약 불가 상태 -> 호실번호 선택 (12) or 메뉴로 복귀 2를
		 * 누른 경우 예약 취소(예약-> 공실) // 룸[방번호]의 값이 0이면 공실 2-> 호실번호선택(1~12) -> 취소가능 여부 -> 취소가능
		 * : 해당호실의 값을 0으로 => 메뉴복귀 -> 취소불가 : 예약되지 않은 방이라고 표시 => 메뉴복귀 3을 누른 경우는 호실 확인 //
		 * 
		 * 1인 경우는 "예약됨 : ★" 0인 경우 "예약가능☆" 99 프로그램 종료 // 내가 만들어야 하는 프로그램.
		 * 
		 * 2023/05/24 3번 호실확인(12개의 방) 만든 후 1번 예약 -> 2번 예약 취소 호실 확인은 예약가능 및 예약 불가능 확인만
		 * 가능하면 됨. 1번을 눌러서 예약이 되는 호실은 예약을 하고, 3번 호실 확인에서 예약이 완료 된 것을 확인 가능 2번 예약 취소는 1번
		 * 예약을 한 이후 예약을 취소함. 예약을 취소한 이후 3. 호실 확인에서 예약이 취소 된 것을 확인 해야 함. 3번은 자판기 메뉴 화면
		 * 3번에서 호실 확인이 되면 -> 1. 예약 하시겠습니까? 2. 종료 3번 -> 예약 하시겠습니까 선택시 1번 예약 화면으로 3번 ->
		 * 페이지 종료 버튼
		 *
		 * 2023/05/25 추가 사항 => 1. 객실 규모는 시작과 동시에 입력 2. 호텔 방번호/ 호텔방명(ex : 로얄
		 * /스텐다드....등등)/객실 인원/ 가격 3. 예약시 예약자명/ 예약 번호 (취소시 필요) 등 4. 기타 필요한 기능 (관리자 모드)
		 *
		 * 1) 객실 규모 변경. 2) 호실 화면에서 => 호텔 방 번호 및 인원(0인실) 가격 등등 보여주기 3) 예약 화면에서 예약자 이름 및
		 * 전화번호 입력 => 예약 취소시 모두 삭제 & 빈방으로 변경 4) 관리자 모드 => 예약자 확인 및 예약일 및 예약 기간(0일) 추가 인원
		 * 발생시 추가요금까지 할수 있을ㄲㅏ........
		 *
		 * 로얄 size %3 ==0 프리미엄 size %3 == 1 스텐다드 else
		 */

		int guestRoom = 101;
		boolean res = false;
		int[] num = null;
		num = new int[guestRoom];

		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}
		int choice = 0;
		Scanner scan = new Scanner(System.in);

		int size = 0;

		System.out.println("전체 객실의 수를 설정해주세요 : ");
		size = scan.nextInt();
		int[] room = new int[size];
		for (int i = 0; i < room.length; i++)
			System.out.println((i + 1) + "개의 객실이 설정 되었습니다.");

		while (!res) {

			System.out.println("1. 예약 2. 예약 취소 3. 호실 확인 99. 종료");
			choice = scan.nextInt();

			switch (choice) {
			case 99:
				System.out.println("이용해 주셔서 감사합니다.");
				res = true;
				break;

			case 3:
				String reserve = null;

				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						reserve = " 예약 가능 ";
					} else {
						reserve = "예약 불가";
					}
					System.out.println((i + 1) + "호실 : " + reserve); // reserve 예약 확인
				}
				break;

			case 1:
				int roomNum = 0; // 객실 num
				String[] roomName = { "로얄", "프리미엄", "스텐다드" };

				System.out.println("예약 하실 호실을 선택해주세요 : ");
				roomNum = scan.nextInt();
				if (roomNum >= 1 && roomNum <= size) {
					if (size % 3 == 0) {
						System.out.println(roomName[0] + " 방을 예약 하시겠습니까?");
					} else if (size % 3 == 1) {
						System.out.println(roomName[1] + " 방을 예약 하시겠습니까?");
					} else {
						System.out.println(roomName[2] + " 방을 예약 하시겠습니까?");
					}

					int temp = roomNum - 1;
					if (room[temp] != 0) {
						System.out.println("예약 할 수 없습니다.");
					} else
						System.out.println("예약 하시겠습니까? 1. 예약 2.종료");
					int choiceNum = 0;
					choiceNum = scan.nextInt();
					switch (choiceNum) {
					case 1:
						if (choiceNum == 1) {
							System.out.println(roomNum  + "예약 되었습니다.");
							room[temp] = 1;
						}
					case 2:
						if (choiceNum == 2) {
							break;
						}
					}
				}
				break;
			case 2:
				int cancle = 0;
				System.out.println("예약 취소 호실을 선택해주세요. 0. 돌아가기");
				cancle = scan.nextInt();
				if (cancle >= 1 && cancle <= size) {
					int temp = cancle - 1;
					if (room[temp] == 0) {
						System.out.println(" 예약되지 않은 방입니다.");
					} else {
						System.out.println(cancle + "호실이 예약 취소 되었습니다.");
						room[temp] = 0;
						break;
					}
				} else {
					System.out.println("잘못 입력 되었습니다.");
					break;
				}
			} // switch(choice)종료
		} // while 종료
	}
}
