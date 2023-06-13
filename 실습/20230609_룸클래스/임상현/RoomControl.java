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
		ad.listCheck(list);
		
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
					ad.RoomSet(list);
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
				break;
				
			default:
				System.out.println("잘못된 입력입니다.");
				break;
				
			}
		}
	}	
}
