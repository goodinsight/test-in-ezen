package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel23_1 {

	public static void main(String[] args) {
		// 비어있는 객실 = 0 , 예약된 객실 = 1
		Scanner scan = new Scanner(System.in);

		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int roomNumber = -1;
		int menu = 0;
		String check0 = "예약가능☆";
		String check1 = "예약불가능★";
		boolean power = false;

		while (!power) {
			System.out.println("=======================");
			System.out.println("       호텔예약서비스");
			System.out.println("=======================");
			System.out.println("      1. 예약하기");
			System.out.println("      2. 예약취소");
			System.out.println("      3. 예약상태 확인");
			System.out.println("      99. 종료하기");
			System.out.println("=======================");
			System.out.print("    메뉴를 입력해주세요 : ");
			menu = scan.nextInt();
			switch (menu) {
			case 1: // 호실 예약
				System.out.println("=======================");
				System.out.print(" 예약하실 방 번호를 입력해 주세요(1~12) : ");
				roomNumber = scan.nextInt();
				if(roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 0) {
					room[roomNumber-1] = 1;
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   "+roomNumber+"번 방이 예약 되었습니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}else if (roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 1) {
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   이미 예약이 된 방입니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}else {
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   존재하지않는 방 번호입니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}
				break;
			case 2: // 호실 예약취소
				System.out.println("=======================");
				System.out.print(" 취소하실 방 번호를 입력해 주세요(1~12) : ");
				roomNumber = scan.nextInt();
				if(roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 0) {
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   예약되지 않은 방입니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}else if (roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 1) {
					room[roomNumber-1] = 0;
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   "+roomNumber+"번 방이 취소 되었습니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}else {
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
					System.out.println("   존재하지않는 방 번호입니다.");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				}
				break;
			case 3: // 호실 상태확인
				System.out.println("=======================");
				for (int i=0 ; i<room.length; i++) {
					System.out.print(i+1+"번 방 : ");
					if(room[i] == 0) {
						System.out.println(check0);
					}else {
						System.out.println(check1);
					}			
				}
				break;
			case 99: // 프로그램 종료
				power = true;
				break;
			default: // 그 외 번호 입력시
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("   올바른 번호를 입력해주세요.");
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				break;
			}
		}
		System.out.println("이용해 주셔서 감사합니다.");
	}
}
