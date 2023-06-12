package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoomControl {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		RoomFunc rf = new RoomFunc();
		Admin ad = new Admin();
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
		
		init(list);
		
		while(!stop) {
			int sel = rf.menu();
			
			switch(sel) {
			
			case 0:
				stop = true;
				System.out.println("종료합니다.");
			
			case 1: // 방 예약하기
				rf.Res(list);
				break;
				
			case 2: // 방 예약 취소
				rf.ResCancel(list);
				break;
				
			case 3: // 방 전체확인/선택확인
				rf.Check(list);
				break;
				
			case 4: // 예약자 정보확인
				rf.ResCheck(list);
				break;
				
			case 77: // 관리자 모드
				int admin_sel = ad.Pwd();
				
				switch(admin_sel) {
				case 0:
					break;
					
				case 1:
					ad.RoomAdd(list);
					break;
					
				case 2:
					ad.RoomDel(list);
					break;
					
				case 3:
					ad.RoomDel(list);
					break;
					
				case 4:
					ad.resCheck(list);
					break;
					
				case 5:
					ad.PwdSet();
					break;
					
				default:
					System.out.println("잘못된 입력입니다.");
					break;
					
				}
				
			default:
				System.out.println("잘못된 입력입니다.");
				break;
				
			}
		}
		

	}
	
	private static void init(List<Room> roomList) {
		Room r1 = new Room(101, "소나무", 20000, "사는 방");
		Room r2 = new Room(102, "참나무", 20000, "사는 방");
		Room r3 = new Room(103, "동백나무", 20000, "사는 방");
		Room r4 = new Room(104, "벚나무", 20000, "사는 방");
		Room r5 = new Room(105, "은행나무", 20000, "사는 방");
		
		roomList.add(r1);
		roomList.add(r2);
		roomList.add(r3);
		roomList.add(r4);
		roomList.add(r5);
	}

}
