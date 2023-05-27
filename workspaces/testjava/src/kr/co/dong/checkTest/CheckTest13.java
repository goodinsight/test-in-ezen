package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13 {
	public static void main(String[] args) {
//		키보드에 의한 입력작성
//		방12개가 있고 =>변수?배열? => 배열 예약room[12]
//		입력구성에서	//menu변수:1,2,3,99를 입력받음
//		1을 누른경우는 방의 예약,	//room[방번호]의 값이 1이면 예약상태
//			1->호실번호 선택(1~12) -> 예약상태여부 확인
//		->예약가능상태 -> 에약실시 ->호실확인 => 메뉴로 복귀
//		2를 누른 경우 예약취소(예약->공실),	//room[방번호]의 값이 0이면 공실
//				2-> 호실번호선택(1~12)->취소가능여부
//			->취소가능: 해당호실의 값을 0으로 =>메뉴복귀
//			->취소불가: 예약되지않은 방이라고 표시. =>메뉴복귀
//		3을 누른 경우는 호실 확인,	//1인 경우는 "예약됨:★"0인경우는 "예약가능☆"
//		99를 누른 경우는 프로그램종료.
		boolean power = false; // 프로그램 전원
		int[] reserve = new int[12]; // 예약 방 개수
		int sel = 0; // 메뉴선택
		String[] ch = { "불가능", "가능" };
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < reserve.length; i++) {
			reserve[i] = 0; // 호실 초기화
		}
		while (!power) {
			System.out.println("=====호텔 메뉴=====");
			System.out.println("1.호실예약 2.예약취소 3.호실확인 99.종료");
			System.out.println("원하시는 메뉴번호를 입력해주세요 : ");
			sel = scan.nextInt();
			switch (sel) {
			case 1:
				System.out.print("===현재 호실예약 상황입니다.===");
				for (int i = 0; i < reserve.length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (reserve[i] == 0) {
						System.out.print(i + 1 + "호실 : " + ch[1] + " ");
					} else {
						System.out.print(i + 1 + "호실 : " + ch[0] + "");
					}
				}
					System.out.println("\n원하시는 호실 번호를 입력해주세요 : ");
					sel = scan.nextInt();
					if(sel > reserve.length) {
						System.out.println("잘못된 접근");
						break;
					}
					if (reserve[sel - 1] == 0) {
						reserve[sel - 1] = 1;
						System.out.println(sel + "호실을 예약하였습니다.");
					}else {
						System.out.println("이미 예약이 된 호실입니다.\n다른 호실을 선택해주세요.");
					}
				break;
			case 2:	//호실 예약취소
				System.out.println("===예약취소===");
				System.out.println("예약취소할 호실을 입력해주세요 : ");
				sel = scan.nextInt();
				if(sel > reserve.length) {
					System.out.println("잘못된 접근");
					break;
				}
				if(reserve[sel-1] == 0) {
					System.out.println("그 호실은 이미 비어있습니다.");
				}else {
					reserve[sel-1] = 0;
				}
				System.out.println("예약이 취소되었습니다.");
				break;
			case 3:
				System.out.print("===호실확인===");
				for (int i = 0; i < reserve.length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (reserve[i] == 0) {
						System.out.print(i + 1 + "호실 : " + ch[1] + " ");
					} else {
						System.out.print(i + 1 + "호실 : " + ch[0] + " ");
					}
				}
				System.out.println();
				break;
			case 99: // 프로그램 종료
				System.out.println("종료종료종료종료");
				power = true;
				break;
			}// switch 문 끝
		} // while 문 끝

	}

}
