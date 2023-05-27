package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest11 {
	public static void main(String[] args) {

		int[] room = new int[12]; // 방 배열
		String input = null; // 콘솔 입력
		int comm = 0; // 입력값 int 변환
		boolean power = true; // 전원

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < room.length; i++) {		// room 배열 0 초기화
			room[i] = 0;
		}

		while (power) {		// 메인 화면
			System.out.println();
			System.out.println("[ 방 예약 프로그램 ]");
			System.out.println("(1)예약 (2)예약 취소 (3)예약 확인 (99)종료");
			System.out.print("명령을 입력해주세요. : ");
			input = scan.nextLine();
			comm = toint(input);

			if ((comm != 1 && comm != 2 && comm != 3 && comm != 99) || comm == -1) {
				System.out.println("***선택지 숫자를 입력해주세요.***");
				continue;
			}

			switch (comm) {
			case 1: 	// 예약
				while (true) {
					System.out.println();
					System.out.print("예약할 호실을 입력해주세요. (1~12) : ");
					input = scan.nextLine();
					comm = toint(input) - 1;
					if (comm > 11 || comm < 0 || comm == -1) {
						System.out.println("***정확한 호실을 입력해주세요.***");
						continue;
					}
					if (room[comm] == 0) {
						System.out.println("★" + (comm + 1) + "호실을 예약했습니다.★");
						room[comm] = 1;
						break;
					} else if (room[comm] == 1) {
						System.out.println((comm + 1) + "호실은 이미 예약되어있습니다.");
						break;
					}
				}

				break;

			case 2: 	// 예약 취소
				while (true) {
					System.out.println();
					System.out.print("예약 취소할 호실을 입력해주세요. (1~12) : ");
					input = scan.nextLine();
					comm = toint(input) - 1;
					if (comm > 11 || comm < 0 || comm == -1) {
						System.out.println("***정확한 호실을 입력해주세요.***");
						continue;
					}
					if (room[comm] == 0) {
						System.out.println((comm + 1) + "호실은 예약되어있지 않습니다.");
						break;
					} else if (room[comm] == 1) {
						room[comm] = 0;
						System.out.println("☆" + (comm + 1) + "호실의 예약을 취소했습니다.☆");
						break;
					}
				}

				break;

			case 3: 	// 예약 확인
				System.out.println("");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println((i + 1) + "호실 : 예약 가능 ☆");
					} else if (room[i] == 1) {
						System.out.println((i + 1) + "호실 : 예약됨 ★");
					}
				}

				break;

			case 99: 	// 종료
				System.out.println("종료합니다.");
				power = false;
				break;
			} // end of switch(comm)

		} // end of while(power)

	} // end of main

	private static int toint(String str) {		// int 입력 예외처리 메소드
		try {
			int result = Integer.parseInt(str);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

} // end of class

