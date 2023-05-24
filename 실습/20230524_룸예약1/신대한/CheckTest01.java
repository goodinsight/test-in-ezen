package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {

//		키보드에 의한 입력작성
//		방12개가 있고 => 변수?배열? => 배열 room[12]
//		입력구성에서			// menu변수 : 1,2,3,99를 입력받음
//		1을 누른경우 는 방의 예약	//room[방번호]의 값이 1이면 예약상태
//		1-> 호실번호 선택(1~12) -> 예약상태여부 확인
//		-> 예약가능상태 -> 예약실시 -> 호실확인 => 메뉴로 복귀
//		-> 예약불가상태 -> 호실번호 선택(1~12) or 메뉴로 복귀
//		2를 누른 경우 예약취소(예약->공실),	//room[방번호]의 값이 0이면 공실
//		2-> 호실번호선택(1~12) -> 취소가능여부
//		-> 취소가능 : 해당호실의 값을 0으로 => 메뉴복귀
//		-> 취소불가 : 예약되지않은 방이라고 표시. => 메뉴복귀
//		3를 누른 경우는 호실 확인,	// 1인 경우는 예약됨:★ "0인경우는 "예약가능☆"
//		99를 누른 경우는 프로그램종료
		boolean reserve = false;
		
		char[] room = new char[12];
		
		for (int i = 0; i < room.length; i++) {
			room[i] = '0';
		}
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		String judgment = "";
		int choice = 0;

		while (!reserve) {
			System.out.println("메뉴를 선택해주세요\n1. 호실예약    2. 예약취소    3. 호실확인    99. 종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				while (true) {
					System.out.println("예약하실 호실을 선택해주세요.");
					for (int i = 0; i < room.length; i++) {
						if(i%5 == 0) {
							System.out.println();
						}
						if(room[i] == '0') {
							judgment = "예약가능";
						}else if(room[i] == '1'){
							judgment = "예약불가능";
						}
						System.out.print(i+1+"번째 호실("+judgment+")   ");
					}
					System.out.println("99 뒤로가기");
					choice = sc.nextInt();
					if(choice == 99) {
						System.out.println("매뉴로 돌아갑니다.");
						break;
					}else if(room[choice-1] == '0') {
						System.out.println("선택하신 "+choice+"번째 호실을 예약했습니다.");
						room[choice-1] = '1';
						break;
					}else if(room[choice-1] == '1') {
						System.out.println("선택하신 "+choice+"번째 호실은 다른손님이 예약하셨습니다. 다른방을 골라주세요.");
					}
				}
				break;
			case 2:
				System.out.println("예약을 취소하실 호실을 선택해주세요.");
				choice = sc.nextInt();
				if(room[choice-1] == '0') {
					System.out.println("선택하신 "+choice+"번째 호실은 예약되어 있지 않습니다.");
				}else if(room[choice-1] == '1') {
					System.out.println("선택하신 "+choice+"번째 호실의 예약을 취소했습니다.");
					room[choice-1] = '0';
				}
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if(i%5 == 0) {
						System.out.println();
					}
					if(room[i] == '0') {
						judgment = "예약가능";
					}else {
						judgment = "예약불가능";
					}
					System.out.print(i+1+"번째 호실("+judgment+")   ");
				}
				System.out.println();
				break;
			case 99:
				reserve = true;
				break;
			default:
				System.out.println("다른 매뉴는 개발중입니다.");
				break;
			}
		}
		System.out.println("어플을 종료합니다.");
	}
}
