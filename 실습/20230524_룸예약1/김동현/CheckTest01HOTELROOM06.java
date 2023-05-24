package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01HOTELROOM06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 방12개가 있다 변수?배열? 배열은 room[12]
		// 메뉴변수는 1,2,3,99를 압력받자
		// 1을 누르면 방을 예약함
		// 호실번호 선택(1~12) +>예약상태여부를 홗인하자
		// 예약가능상태 ->예약실시->호실 홗인 => 메뉴복귀
		// 예약불가면 호실번호를 선택 또는 메뉴로 복귀지
		// 2를 누른경우 예약취소(예약->공실) 룸번호가 0이면 공백
		// 3를 누른경우는 호실확인 , 1이면 예약된거임 0이면 예약가능하대
		// 99를 누르면 종료하자
		Scanner scan = new Scanner(System.in);

		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };// 12개의 방호수들
		boolean power = false;
		int menu;// 메뉴 1 ,2 ,3 ,99

		int num1;//방번호 , 호실 0또는 1 을 구현해주는?!?!?!?!

		while (!power) {//블리언 파워가 실행되는 동안 와일드문을 진행하다
			System.out.println("언제어디로어떻게예약하실건가요?");
			System.out.println("1. 방예약");
			System.out.println("2. 예약취소");
			System.out.println("3. 호실확인합니다");
			System.out.println("99.시스템종료합니당");
			System.out.println("번호를 입력해주세요");
			menu = scan.nextInt();//메뉴 값을 받자
			switch (menu) {
			case 1:// 방을예약할조건은???방이비어잇고, 예약할코스가 잇어야지
				System.out.println("방번호를 입력하세여");
				num1 = scan.nextInt();
				if (room[num1 - 1] == 0) {
					room[num1 - 1] = 1;// 예약됐음
				} else if (room[num1 - 1] == 1) {
					System.out.println("이미예약된방입니다");
				}
				break;
			case 2:// 예약취소 , 공백 과 취소가능 여부 등등
				System.out.println("취소와 공백여부를 확인");
				System.out.println("방번호를 입력하세여");
				num1 = scan.nextInt();
				if (room[num1 - 1] == 1) {//0과 1로 판단과 출력과 구현이 가능
					room[num1 - 1] = 0;
				} else if (room[num1 - 1] == 0) {//0이면 예약이NONO이지
					System.out.println("예약이안된방입니다");
				}
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.println(i + 1 + "번 방 : 예약됨 ");
					} else if (room[i] == 0) {//0이면 예약가능이지
						System.out.println(i + 1 + "번방 : 예약가능합니다");
					}
				}
				break;
			case 99://앤드 파워를 끄자
				power=true;
				System.out.println("END");
			default:
				break;
			}
		}
	}

}
