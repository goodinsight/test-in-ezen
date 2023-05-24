package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel04 {

	public static void main(String[] args) {
//		방 12개가 있고 배열 room[12]
//		입력구성에서 menu변수 : 1,2,3,99를 입력받음
//		1.방 예약
//		1을 누른 경우는 방의 예약 => room[방번호]의 값이 1이면 예약상태
//		1-> 호실번호 선택(1~12) -> 예약상태여부 확인
//		->예약가능상태 -> 예약실시 -> 호실확인 => 메뉴로 복귀
		
//		2.예약 취소
//		2를 누를 경우 예약 취소(예약-> 공실) -> room[방번호]의 값이 0이면 공실
//		2-> 호실번호 선택(1~12) -> 취소가능여부
//		-> 최소가능 : 해당호실의 값을 0으로 => 메뉴 복귀
//		-> 취소불가 : 예약되지않은 방이라고 표시 => 메뉴복귀
		
//		3. 호실확인
//		1번-> "예약됨:★" 0번-> "예약가능☆"
//		99 누르면 프로그램 종료

		boolean power = false;
		int[] room = {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0}; // 방 번호
		int roomN = -1;
		String[] menu = {"룸 예약", "예약 취소","호실 확인","종료"}; // 메뉴번호 => 순서대로 1,2,3,99
		int menu1 = 0; // 메뉴선택
	    Scanner scan = new Scanner(System.in);
	    
	    while(!power) {
	    	System.out.println("================================================");
	    	System.out.println("                    Menu                        ");
	    	
//	    	for(int i=0;i<menu.length;i++) {
	    		System.out.println("▶ 1. 룸 예약 2. 예약 취소 3. 호실 확인 99. 종료");
	    		System.out.println("================================================");
	    		System.out.println("▶원하는 메뉴를 선택해주세요.");
	    	
	    menu1 = scan.nextInt();
	    switch(menu1) {
//		room 이 0일때 = 예약 가능, room 이 1일때 = 예약 불가능
	    case 1: //예약
	    	System.out.println("※"+menu[menu1-1]+"※을 선택하셨습니다.");
	    	System.out.println("▶원하시는 Room을 선택해주세요(1~12): ");
	    	roomN = scan.nextInt();
	    	if(roomN > 0 && roomN <= room.length && room[roomN-1] == 0) {
				room[roomN-1] = 1;
	    			System.out.println("선택하신 "+ roomN + "번 방은 예약 가능합니다.");
	    	} else if (roomN > 0 && roomN <= room.length && room[roomN-1] == 1){
	    		System.out.println("선택하신 "+ roomN + "번 방은 이미 예약된 방입니다.");
	    	} else {
	    		System.out.println("확인되지 않는 방입니다. 다시 선택해주세요.");
	    	}
	    	break;
	    case 2: // 예약취소
	    	System.out.println("※"+menu[menu1-1]+"※을 선택하셨습니다.");
	    	System.out.println("▶취소하실 Room 번호를 입력하세요(1~12) : ");
	    	roomN = scan.nextInt();
	    	if(roomN > 0 && roomN <= room.length && room[roomN-1] == 1) {
				room[roomN-1] = 0;
				System.out.println("선택하신 "+ roomN + "번 방이 정상적으로 취소되었습니다.");
	    	} else if (roomN > 0 && roomN <= room.length && room[roomN-1] == 0){
	    		System.out.println("선택하신 "+ roomN + "번 방은 예약 되지 않은 방입니다.");
	    	} else {
	    		System.out.println("번호를 다시 입력해주세요.");
	    	}
	    	break;
	    case 3: // 호실확인
	    	for(int j = 0; j < room.length; j++) {
	    		System.out.println(j+1+"번 방");
	    		if(room[j] == 1) {
	    		System.out.println("★★이미 예약된 방입니다★★");
	    	} else if(room[j] == 0) {
	    		System.out.println("☆예약이 가능합니다☆");
	    	}
	    	
	    	}
	    	break;
	    case 99: // 종료
	    	power = true;
			System.out.println("==== 예약창이 종료됩니다:) ====");
			break;
							
		default :
			System.out.println("잘못 누르셨습니다. 다시 선택해주세요.");
	      }
//	     }  	
	   }
	}
}


