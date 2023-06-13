package kr.co.dong.roomsy;

import java.util.ArrayList;
import java.util.List;

public class RoomMix {
	
	RoomControl04 rc = new RoomControl04();
	List<Room> list = null;
	boolean done = false;
	
	public void rMix() {
		list = new ArrayList<Room>();
		
//		rc.init(list);
		rc.init2(list);
		
		while(!done) {
			rc.printRoom();
			switch (rc.scan.nextInt()) {
			case 1:
				rc.revRoom(list);
				break;
			case 2:
				rc.cancelRev(list);
				break;
			case 3:
				rc.checkRoom(list);
				break;
			case 4:
				rc.checkCustomer(list);
				break;
			case 99:
				done = !done;
				System.out.println("프로그램을 종료합니다.");
			default:
				System.out.println("번호를 다시 입력하세요.");
				break;
			}
		}
	}
	
}
