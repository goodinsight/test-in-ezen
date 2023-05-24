package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {
	public static void main(String[] args) {
		int[] room = new int [12];
		for(int i = 0; i < room.length; i++) {
			room[i] = 0;
		}
		boolean power = false;
		String reservation = null;
		while(!power) {
			int choice = 0;
			Scanner scan = new Scanner(System.in);
			System.out.print("(1)호실선택 (2)예약취소 (3)호실확인 (99)종료 : ");
			choice = scan.nextInt();
	
			switch(choice) {
			case 1:
				int roomNum = 0;
				System.out.print("호실번호 선택 : ");
				roomNum = scan.nextInt();
				
				if(roomNum >= 1 && roomNum <= 12) {
					int tmp = roomNum - 1;
					if(room[tmp] != 0) {
						System.out.println("예약이 불가능합니다.");
					} else {
						System.out.println("예약이 가능합니다.");
						while(true) {
							System.out.println("(1)예약 (0)돌아가기");
							int sel = scan.nextInt();
							if(sel == 0) {
								break;
							} else if(sel == 1) {
								System.out.println(roomNum + "번 방이 예약되었습니다.");
								room[tmp] = 1;
								break;
							} else {
								System.out.println("잘못된 입력입니다.");
							}

						}
						
					}
				}
				break;
			// case 1 end
				
			case 2:
				while(true){
					System.out.print("예약을 취소할 방 번호를 입력해주세요((0)돌아가기) :");
					int sel = scan.nextInt();
					if(sel >= 1 && sel <= 12) {
						int seltmp = sel - 1;
						if(room[seltmp] == 0) {
							System.out.println("예약되지 않은 방입니다.");
						} else {
							System.out.println(sel + "번 방 예약이 취소되었습니다.");
							room[seltmp] = 0;
							break;
						}
					}else if(sel == 0){
						break;
					}else {
						System.out.println("잘못된 입력입니다.");
					}
				}
				break;
			// case 2 end
				
			case 3:
				for(int i = 0; i < room.length; i++) {
					if(room[i] == 0) {
						reservation = "예약가능";
					} else {
						reservation = "예약됨";
					}
					System.out.println(i+1 +"번 방(" + reservation + ") ");
				}
				break;
			// case 3 end
			case 99:
				System.out.println("종료");
				power = true;
				break;
			}
		}
	}
}
