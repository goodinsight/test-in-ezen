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
			System.out.println("\n1.?Έμ€? ν 2.?μ½μ·¨μ 99.?λ‘κ·Έλ¨ μ’λ£");
			menu = scan.nextInt();
			switch (menu) {
			case 1:// ?μ½
				System.out.println("?Έμ€??? ν?΄μ£Ό?Έμ (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 1) {
					System.out.println("?μ½??λΆκ??©λ??");
				} else {
					room[roomnum - 1] = 1;
					System.out.println("?μ½?μ?΅λ??");
				}
				break;

			case 2:// ?μ½μ·¨μ
				System.out.println("?Έμ€??? ν?΄μ£Ό?Έμ (1~12)");
				roomnum = scan.nextInt();
				if (room[roomnum - 1] == 0) {
					System.out.println("?μΈ???μ½???μ΅?λ€.");
				} else {
					room[roomnum - 1] = 0;
					System.out.println("?μ½??μ·¨μ?μ?΅λ??");
				}
				break;
			case 99: // ?λ‘κ·Έλ¨ μ’λ£
				stop = true;
				System.out.println("?λ‘κ·Έλ¨??μ’λ£?©λ??");
			}

		}

	}
}
