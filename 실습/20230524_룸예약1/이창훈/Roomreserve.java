package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Roomreserve {
	// 배열안에 숫자가 1이면 예약완료 , 0이면 예약대기
	public static void main(String[] args) {
		int[] room = new int[12];
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("============================================");
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println("1: 예약하기 2: 예약취소하기 3:객실상태보기");
			int select = scan.nextInt();

			switch (select) {
			case 1:
				while (true) {
					System.out.println("예약할 방을 선택하세요. (예약가능:☆) (처음으로: 0번)");

					for (int i = 0; i < room.length; i++) { // 예약가능한 호실 보여주기
						if (room[i] == 1) {
							System.out.print(i + 1 + "호실: " + "★ ");
						} else {
							System.out.print(i + 1 + "호실: " + "☆ ");
						}
						if (i == room.length / 2) {
							System.out.println();
						}
					}

					select = scan.nextInt();
					if (select == 0) {
						break;
					} else if (select > 12 || select < 1) {
						System.out.println("없는 호실입니다.");
						break; // 부득이하게 사용.. 아래 if를 if안에 if로 바꾸면 제거할수 있을듯하다
					}

					if (room[select - 1] == 1) { // 예약처리과정
						System.out.println("이미 예약된 방입니다.");
					} else {
						System.out.println(select + "호실 예약 완료");
						room[select - 1] = 1;
						break;
					}
				}
				continue;

			case 2:
				System.out.println("예약취소할 호실을 입력해주세요. (처음으로: 0번)");

				select = scan.nextInt();

				if (select == 0) {
					continue;
				} else if (select > 12 || select < 1) {
					System.out.println("없는 호실입니다.");
					continue;
				}

				if (room[select - 1] == 1) { // 예약처리과정
					System.out.println("예약을 취소했습니다.");
					room[select - 1] = 0;
				} else {
					System.out.println("예약이 안되어있는 방입니다.");
					continue;
				}

			case 3:
				System.out.println("현재 호실 상황입니다. 예약가능:☆");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.print(i + 1 + "호실: " + "★ ");
					} else {
						System.out.print(i + 1 + "호실: " + "☆ ");
					}
					if (i == room.length / 2) {
						System.out.println();
					}
				}
				System.out.println();
				continue;

			case 99:
				break;
				
			default:
				continue;

			}
			scan.close();
			System.out.println("프로그램 종료~!~!~!");
			
		}

	}

}
