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
			System.out.println("\n1.?¸ì‹¤? íƒ 2.?ˆì•½ì·¨ì†Œ 99.?„ë¡œê·¸ëž¨ ì¢…ë£Œ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:// ?ˆì•½
				System.out.println("?¸ì‹¤??? íƒ?´ì£¼?¸ìš” (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 1) {
					System.out.println("?ˆì•½??ë¶ˆê??©ë‹ˆ??");
				} else {
					room[roomnum - 1] = 1;
					System.out.println("?ˆì•½?˜ì—ˆ?µë‹ˆ??");
				}
				break;

			case 2:// ?ˆì•½ì·¨ì†Œ
				System.out.println("?¸ì‹¤??? íƒ?´ì£¼?¸ìš” (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 0) {
					System.out.println("?•ì¸???ˆì•½???†ìŠµ?ˆë‹¤.");
				} else {
					room[roomnum - 1] = 0;
					System.out.println("?ˆì•½??ì·¨ì†Œ?˜ì—ˆ?µë‹ˆ??");
				}
				break;
			case 99: // ?„ë¡œê·¸ëž¨ ì¢…ë£Œ
				stop = true;
				System.out.println("?„ë¡œê·¸ëž¨??ì¢…ë£Œ?©ë‹ˆ??");
			}

		}

	}
}
