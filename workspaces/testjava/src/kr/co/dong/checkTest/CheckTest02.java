package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest02 {

	public static void main(String[] args) {
		boolean stop = false;
		int[] room = new int[12];
		int roomnum = 0;
		int menu = 0;
		Scanner scan = new Scanner(System.in);

		while (!stop) {
			System.out.println(
					"==========================================================================================================================");
			for (int i = 0; i < room.length; i++) {
				System.out.print("  room" + (i + 1) + " :" + room[i]);
			}
			System.out.println("\n1.?�실?�택 2.?�약취소 99.?�로그램 종료");
			menu = scan.nextInt();
			switch (menu) {
			case 1:// ?�약
				System.out.println("?�실???�택?�주?�요 (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 1) {
					System.out.println("?�약??불�??�니??");
				} else {
					room[roomnum - 1] = 1;
					System.out.println("?�약?�었?�니??");
				}
				break;

			case 2:// ?�약취소
				System.out.println("?�실???�택?�주?�요 (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 0) {
					System.out.println("?�인???�약???�습?�다.");
				} else {
					room[roomnum - 1] = 0;
					System.out.println("?�약??취소?�었?�니??");
				}
				break;
			case 99: // ?�로그램 종료
				stop = true;
				System.out.println("?�로그램??종료?�니??");
			}

		}

	}
}
