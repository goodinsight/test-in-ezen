package kr.co.dong.checkPoint;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CheckTest13_5 {
	public static void main(String[] args) {
//		키보드에 의한 입력작성
//		방12개가 있고 =>변수?배열? => 배열 예약room[12]
//		입력구성에서	//menu변수:1,2,3,99를 입력받음
//		1을 누른경우는 방의 예약,	//room[방번호]의 값이 1이면 예약상태
//			1->호실번호 선택(1~12) -> 예약상태여부 확인
//		->예약가능상태 -> 에약실시 ->호실확인 => 메뉴로 복귀
//		->예약불가상태 -> 호실번호 선택(1~12) or 메뉴로 복귀
//		2를 누른 경우 예약취소(예약->공실),	//room[방번호]의 값이 0이면 공실
//				2-> 호실번호선택(1~12)->취소가능여부
//			->취소가능: 해당호실의 값을 0으로 =>메뉴복귀
//			->취소불가: 예약되지않은 방이라고 표시. =>메뉴복귀
//		3을 누른 경우는 호실 확인,	//1인 경우는 "예약됨:★"0인경우는 "예약가능☆"
//		99를 누른 경우는 프로그램종료.
//		=> 추가사항 : 1.객실규모(크기)는 시작과 동시에 입력함  호텔 총 방개수
//				    2.호텔방번호/호텔방명(예-로얄/참나무 등)/객실인원/가격
//					3.예약시 예약자명/예약번호(취소시 필요) 등
//					4.기타 필요한 기능(관리자모드)
		Scanner scan = new Scanner(System.in);
		boolean power = false; // 프로그램 전원
		String name = "";		//예약자 이름 확인
		int num = 0;			//예약번호 확인
		int person = 0;			//투숙인원 확인
		int roomnum = 0;		//호실 입력	
		int pay = 0;			//결제 금액
		int tmp = 0;			//결제 금액 복사
		int count = 0;			
		int sel = 0; // 선택
		int[][] room = new int[3][]; // 객실 개수
		String[][] preorder = new String[50][3];	//예약자 데이터	(호실-이름-번호)
		String[][] sweet = new String[3][3];	//호실표
		sweet[0][0] = "이코노미";
		sweet[0][1] = "45000";
		sweet[0][2] = "2";
		sweet[1][0] = "비지니스";
		sweet[1][1] = "60000";
		sweet[1][2] = "3";
		sweet[2][0] = "로얄";
		sweet[2][1] = "80000";
		sweet[2][2] = "4";
		String possible = ""; // 예약가능 불가능 표시
		for (int i = 0; i < room.length; i++) {
			System.out.println(i + 1 + "층 객실 개수 입력 : ");
			sel = scan.nextInt();
			room[i] = new int[sel+1];
		}
		room[0][0] = 1; // 층
		room[1][0] = 2; // 층
		room[2][0] = 3; // 층
		
		
		while (!power) {// 호텔메뉴 시작
			System.out.println("=====호텔 메뉴=====");
			System.out.println("1.호실예약 2.예약취소 3.호실확인 4.결제금액 충전 99.종료");
			System.out.println("원하시는 서비스 번호를 입력하세요 : ");
			System.out.println("남은금액 : "+pay);
			sel = scan.nextInt();

			switch (sel) {
			case 1: // 호실 예약
				System.out.println("===호실 예약 메뉴===");
				for (int i = 0; i < sweet.length; i++) {
					System.out.println(i + 1 + "층 : " + sweet[i][0] + "(객실최대인원:" + sweet[i][2] + ")" + "금액:" + sweet[i][1] + "원");
				}
				System.out.println("원하시는 층을 입력해주세요 : ");
				sel = scan.nextInt();
				if(pay < Integer.parseInt(sweet[sel-1][1])) {
					System.out.println("금액이 부족합니다.");
				}else {
					for (int i = 1; i < room[sel-1].length; i++) {
						if (i % 5 == 0) {
							System.out.println();
						}
						if (room[sel-1][i] == 0) {
							possible = "예약 가능";
						} else {
							possible = "이미 예약되었음";
						}
						System.out.print((sel*100+ i) + "호실  " + possible + "   ");
					}
					System.out.println();
					System.out.println("원하시는 호실(맨뒤숫자만)을 입력해주세요 : ");
					roomnum = scan.nextInt();
					if (room[sel-1][roomnum] == 1) {
						System.out.println("이미 예약된 호실입니다.\n다른호실을 선택해주세요.");
					} else {
						System.out.println("투숙인원을 입력해주세요 : ");
						person = scan.nextInt();
						if(Integer.parseInt(sweet[sel-1][2]) < person) {
							System.out.println("객실 최대인원수를 넘습니다.");
							break;
						}else {
						System.out.println("예약하시는분의 성함을 입력해주세요 : ");
						scan.nextLine();
						preorder[count][0] = sel*100+roomnum+"";
						preorder[count][1] = scan.nextLine();
						preorder[count][2] = (int) (Math.random() * 999) + 1+"";
						System.out.println("예약번호 : " + preorder[count][2] + "입니다.\n예약취소할때 필요하니 꼭 기억해주세요.");
						room[sel-1][roomnum] = 1;
						pay -= Integer.parseInt(sweet[sel-1][1]);
						count++;
						}
					}
				}
				break;
			case 2: // 호실 예약취소
				System.out.println("===예약 취소 메뉴===");
				System.out.println("예약한 호실을 입력해주세요 : ");
				roomnum = scan.nextInt();
				for (int i = 0; i < preorder.length; i++) {
					if(roomnum == Integer.parseInt(preorder[i][0])) {
						System.out.println("예약번호를 입력해주세요 : ");
						num = scan.nextInt();
						if(num == Integer.parseInt(preorder[i][2])) {
							System.out.println("예약이 취소되었습니다.");
							if((roomnum/10)%10 != 0) {
							room[roomnum/100-1][roomnum%10+10] = 0;
							pay += Integer.parseInt(sweet[roomnum/100-1][1]);
							System.out.println(Integer.parseInt(sweet[roomnum/100-1][1]));
							
							}else {
								room[roomnum/100-1][roomnum%10] = 0;
								pay += Integer.parseInt(sweet[roomnum/100-1][1]);
								System.out.println(Integer.parseInt(sweet[roomnum/100-1][1]));
								break;
							}
						}else {
							System.out.println("예약 번호가 틀립니다.");
							break;
						}
					}else {
						System.out.println("예약한 호실이 틀립니다.");
						break;
					}
				}
				break;
			case 3: // 호실 예약상황
				System.out.println("===호실 예약 상황 확인 메뉴===");
				System.out.println("원하시는 층을 입력해주세요 : ");
				sel = scan.nextInt();
				System.out.println(room[sel-1][0]+"층 : "+sweet[sel-1][0]);
				for (int i = 1; i < room[sel-1].length; i++) {
					if (i % 5 == 0) {
						System.out.println();
					}
					if (room[sel-1][i] == 0) {
						possible = "예약 가능";
					} else {
						possible = "이미 예약되었음";
					}
					System.out.print((sel*100+ i) + "호실  " + possible + "   ");
				}
				System.out.println();
				break;
			case 4:	//결제금액 충전
				System.out.println("넣으실 금액을 입력하세요 : ");
				pay += scan.nextInt();
				tmp = pay;
				break;
			case 99:
				System.out.println("종료");
				power = true;
				break;
				default :
					System.out.println("다시 입력하십시오.");
			}// switch문끝
		} // while문끝

	}

}
