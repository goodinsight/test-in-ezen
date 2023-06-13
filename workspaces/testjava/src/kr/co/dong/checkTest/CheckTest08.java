package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest08 {
	public static void main(String[] args) {
		int roomin = 0, markin = 0;
		boolean power = true;
		Scanner scan = new Scanner(System.in);
		int[][] room = { { 101, 2, 50000, 0 }, { 102, 2, 50000, 0 }, { 103, 2, 50000, 0 }, { 104, 2, 50000, 0 },
				{ 201, 2, 100000, 0 }, { 202, 2, 100000, 0 }, { 203, 2, 100000, 0 }, { 204, 2, 100000, 0 },
				{ 301, 4, 150000, 0 }, { 302, 4, 150000, 0 }, { 303, 4, 200000, 0 }, { 304, 6, 300000, 0 } };

		while (power == true) {
			System.out.print("\n==========[MENU]==========\n1. 룸 정보	2. 예약진행\n3. 예약취소	4. 예약확인"
							+ "\n99. 프로그램 종료\n\n메뉴 선택 : ");
			markin = scan.nextInt();
			roomin = -1;

			switch (markin) {
			case 1:
//				룸 정보
				for (int i = 1; i < 4; i++) {
					System.out.print("\n==================================================================\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						j++;
						System.out.print("    room" + j + "	||");
						j--;
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						System.out.print("  " + room[j][0] + "호, " + room[j][1] + "인실	||");
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						System.out.print("  " + room[j][2] + "w	||");
					}
					System.out.print("\n||");
					for (int j = i * 4 - 4; j < i * 4; j++) {
						if (room[j][3] == 0) {
							System.out.print("  예약안됨	||");
						} else {
							System.out.print("  예약됨	||");
						}
					}
				}
				System.out.println("\n==================================================================");
				break;
			case 2:
//				예약진행
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 0) {
					room[roomin][3] = 1;
					System.out.println("\n예약완료");
				} else {
					System.out.println("\n예약불가(예약됨)");
				}
				break;
			case 3:
//				예약취소
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 1) {
					room[roomin][3] = 0;
					System.out.println("\n예약취소 완료");
				} else {
					System.out.println("\n예약취소 불가(예약안됨)");
				}
				break;
			case 4:
//				에약확인
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin][3] == 0) {
					System.out.println("\n예약가능");
				} else {
					System.out.println("\n예약됨");
				}
				break;
			case 99:
//				프로그램 종료
				power = false;
				System.out.println("\n시스템 종료");
				break;
			default:
				System.out.println("\n재입력");
				break;
			}
		}
	}
}
