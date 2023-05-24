package reportt;

import java.util.Scanner;

public class Report12_room {
	public static void main(String[] args) {
		int[] room = new int[12];
		Scanner scan = new Scanner(System.in);
		boolean power = false;
		int tmp = 0, tmp2 = 0;

		while (!power) {
			System.out.println("1: 방 예약하기 /// 2: 방 예약 취소하기 /// 3: 호실 확인 /// 99: 종료");
			int menu = scan.nextInt();
			switch (menu) {
			case 99:
				System.out.println("시스템 종료");
				power = true;
				break;
			case 3:
				System.out.println("호실 확인하기");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.println((i + 1) + "호실은 예약되었습니다.");
					} else {
						System.out.println((i + 1) + "호실은 예약 가능");
					}
				}
				break;
			case 2:
				System.out.print("취소하실 호실 번호를 입력해주세요:");
				tmp = scan.nextInt();
				System.out.println(tmp+"호실은...");
				if (room[tmp-1] == 1) {
					System.out.println("취소 가능");
					System.out.println("취소하시겠습니까? (예약취소하기:1 돌아가기:0):");
					tmp2 = scan.nextInt();
					if (tmp2 == 1) {
						room[tmp-1] = 0;
						System.out.println(tmp + "호실의 예약을 취소했습니다");
					}
				} else {
					System.out.println("예약되지 않은 방입니다");
				}
				break;
			case 1:
				while (true) {
					System.out.print("호실 번호를 입력해주세요(0은 종료):");
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					} else if (room[tmp - 1] == 1) {
						System.out.println(tmp + "호실은 예약 불가능합니다");
					} else {
						room[tmp - 1] = 1;
						System.out.println(tmp + "호실이 예약되었습니다");
						break;
					}
				}
				break;
			}

		}
	}
}
