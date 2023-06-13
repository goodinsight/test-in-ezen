package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest18 {
	// 배열안에 숫자가 1이면 예약완료 , 0이면 예약대기
	public static void main(String[] args) {
		int[] roomN = { 301, 302, 303, 401, 402, 403, 404, 501, 502, 503, 504, 601, 602 };
		int[] bookcheck = new int[roomN.length]; // 0,1로 예약여부 확인
		String[] roomtype = { "싱글", "싱글", "싱글", "더블", "더블", "더블", "더블", "더블", "더블", "더블", "더블", "디럭스", "디럭스" };
		int[] pw = new int[roomN.length];
		String[] id = new String[roomN.length];
		int guest = 0; // 임시
		boolean case1 = false;
		boolean power = false;
		Scanner scan = new Scanner(System.in);

		while (!power) {
			case1 = false;
			System.out.println("============================================");
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println("1: 예약하기 2: 예약취소하기 3: 예약상태보기");
			int select = scan.nextInt();

			switch (select) {

			case 1:
				while (!case1) {
					System.out.println("객실 인원수를 입력하세요 (1~3) (처음으로: 0번)");
					guest = scan.nextInt();

					// 예외처리
					if (guest == 0) {
						break;
					} else if (guest < 1 || guest > 3) {
						System.out.println("1~3 중에서 입력하세요."); // 4인이상 #*($# 문구 필요
						continue;
					}

					// 방보여주기
					for (int i = 0; i < roomN.length; i++) {

						if (guest == 1 || guest == 2 || guest == 3) {
							if (i == 0) {
								System.out.println("예약할 방번호를 입력해주세요. (예약가능:☆) (처음으로: 0번)");
							}
							if (roomtype[i].equals("디럭스") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "☆");
							} else if (roomtype[i].equals("디럭스") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "★");
							}
						}
						if (guest == 1 || guest == 2) {
							if (roomtype[i].equals("더블") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "☆");
							} else if (roomtype[i].equals("더블") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "★");
							}
						}
						if (guest == 1) {
							if (roomtype[i].equals("싱글") && bookcheck[i] == 0) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "☆");
							} else if (roomtype[i].equals("싱글") && bookcheck[i] == 1) {
								System.out.println(roomN[i] + "호: " + roomtype[i] + "★");
							}
						}
					}
					// 여기서 게스트를 2명 선택해도 싱글룸을 고를수 있는 문제있음

					int selectroom = scan.nextInt();
					if (selectroom == 0) {
						break;
					}

					for (int i = 0; i < roomN.length; i++) {
						if (roomN[i] == selectroom) {
							System.out.println("예약취소용 비밀번호를 입력하세요. (0001~9999 가능)");
							String scanpw = scan.next();
							pw[i] = Integer.parseInt(scanpw);

							if (Integer.parseInt(scanpw) < 10000 && Integer.parseInt(scanpw) > 0) {
								System.out.println(roomN[i] + "호실 예약 완료");
								bookcheck[i] = 1;
								pw[i] = Integer.parseInt(scanpw);
								case1 = true;
							} else {
								System.out.println("0000~9999로 비밀번호를 만들어주세요.");
							}
						}
					}
				}
				continue;

			case 2:
				System.out.println("예약취소할 호실을 입력해주세요. (처음으로: 0번)");
				select = scan.nextInt();

				for (int i = 0; i < roomN.length; i++) {
					if (roomN[i] == select && bookcheck[i] == 1) {
						System.out.println("예약 비밀번호를 입력하세요.");
						String scanpw = scan.next();

						if (pw[i] == Integer.parseInt(scanpw)) {
							System.out.println("예약을 취소했습니다.");
							roomN[i] = 0;
							pw[i] = 0;
							break;
						} else {
							System.out.println("비밀번호가 틀립니다.");
							break;
						}
					}
				}
				// 예약이 안되어있는 방을 취소하려했을때 문구 필요
				continue;

			case 3:
				System.out.println("현재 예약 상황입니다. (예약가능: ☆)");
				for (int i = 0; i < roomN.length; i++) {
					System.out.print(roomN[i] + "호: " + roomtype[i] + "☆ ");
					if ((i + 1) % 6 == 0) {
						System.out.println();
					}
				}
				System.out.println();
				continue;

			case 99:
				power = true;
				break;
			}
		}
		System.out.println("종료~");
		scan.close();
	}
}
