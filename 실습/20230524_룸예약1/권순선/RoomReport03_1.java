package kss.co.kr.array;

import java.util.Scanner;

public class RoomReport03_1 {
	public static void main(String[] args) {

		boolean moon = false;

		Scanner sc = new Scanner(System.in);
		String[] roomName = { "일반룸", "일반룸", "일반룸", "일반룸", "PC룸", "PC룸", "영화룸", "영화룸", "vip스위트룸", "vip스위트룸", "vvip룸",
				"vvip룸" };
		int[] pay = { 20000, 20000, 20000, 20000, 40000, 40000, 60000, 60000, 80000, 80000, 100000, 100000 };
		int[] roomNum = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112 };
		int[] person = { 2, 2, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10 };
		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int money = 0;
		String[] name = new String[12];

		int num = 0;

		while (!moon) {

			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("★☆★☆★ 객실 확인 필수必로 확인 부탁드립니다 ☆★☆★☆");
			System.out.println("1) 방 예약");
			System.out.println("2) 객실 확인");
			System.out.println("3) 예약 취소");
			System.out.println("4) 금액 입금");
			System.out.println("99) 종료");
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.print("번호 선택 >> ");
			num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:

				while (num != 55) {

					System.out.print("예약자 이름 >> ");
					name[0] = sc.next();
					System.out.print("호실 번호 선택(1 ~ 12) 종료) : 55 >> ");
					num = sc.nextInt();

					if (num < 1 || num > 12) {
						System.out.println("다시 입력");
						continue;
					} else if (room[num - 1] == 1) {
						System.out.println("★ 예약되어있는 방 ★");
						continue;
					}

					if (num >= 1 && num <= 12) {
						System.out.print(roomName[num - 1] + " " + roomNum[num - 1] + "호의 금액은 " + pay[num - 1]
								+ "원 입니다 입금 하세요 >> ");
						money = sc.nextInt();
						if (money == pay[num - 1]) {
							room[num - 1] = 1;
							System.out.println(name[0] + "님 " + roomName[num - 1] + " " + roomNum[num - 1] + "호 예약됨");
						} else {
							System.out.println("금액이 맞지 않습니다 다시 입금하세요");
							continue;
						}
						System.out.println();

						break;
					}

					System.out.println();

				}

				break;

			case 2:

				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
						System.out.println("=======================================");
						System.out.println();
						System.out.println(roomNum[i] + "호 " + roomName[i] + " " + person[i] + "명 " + pay[i] + "원" + " ☆ 예약 가능 ☆");
					}
					System.out.println();
				}

				break;

			case 3:

				while (num != 77) {

					System.out.println("예약되어있는 방 리스트");

					System.out.println(name[0] + "님으로 예약");
					System.out.println(roomNum[0] + "호 " + roomName[0] + " " + person[0] + "명 ");

					System.out.print("1) 예약 취소하기, 77) 뒤로가기 >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:

						break;

					}

				}

				break;

			case 4:

				break;

			case 99:

				moon = true;
				System.out.println("프로그램 종료");

				break;

			}

		}

	}
}
