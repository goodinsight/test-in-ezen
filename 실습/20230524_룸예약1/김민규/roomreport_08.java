package kr.co.doing;

import java.util.Scanner;

public class roomreport_08 {
	public static void main(String[] args) {
		int roomnum = 12, roomin = 0, markin = 0;
		boolean power = true;
		int[] room = new int[12];
		for (int i = 0; i < roomnum; i++) {
			room[i] = 0;
		}
		Scanner scan = new Scanner(System.in);

		while (power == true) {
			System.out.print("\n==========[MENU]==========\n1. 예약진행	2. 예약취소	3. 예약확인"
							+ "\n99. 프로그램 종료\n\n메뉴 선택 : ");
			markin = scan.nextInt();
			roomin = 0;
			switch (markin) {
			case 1:
//				예약진행
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 0) {
					room[roomin] = 1;
					System.out.println("\n예약완료");
				} else {
					System.out.println("\n예약불가(예약됨)");
				}
				break;
			case 2:
//				예약취소
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 1) {
					room[roomin] = 0;
					System.out.println("\n예약취소 완료");
				} else {
					System.out.println("\n예약취소 불가(예약안됨)");
				}
				break;
			case 3:
//				에약확인
				System.out.print("room number : ");
				roomin += scan.nextInt();
				if (room[roomin] == 0) {
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
