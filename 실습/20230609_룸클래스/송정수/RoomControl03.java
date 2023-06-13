package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RoomControl03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List
		
		List<Rcus> Rcus = new ArrayList<Rcus>();
		List<Room> list = new ArrayList<Room>();
		RoomMethod method = new RoomMethod();
		boolean stop = false;

//		호텔의 룸 정보를 초기화하고 저장
		method.init(list);

		while (!stop) {
			int sel = method.menu();

			switch (sel) {
			case 1: // 방 예약하기
				method.revRoom(list);
				break;
			case 2: // 방 예약취소
				method.cancelRoom(list,Rcus);
				break;
			case 3: // 방 전체확인 / 선택확인
				method.printRoom(list);
				break;
			case 4: // 예약자 정보확인
				method.infoCheck(list,Rcus);
				break;
			case 5: // 방 지우기
				method.removeRoom(list);
				break;
			case 6: // 방 추가하기
				method.addRoom(list);
				break;
			case 7: // 방 수정하기
				method.editRoom(list);
				break;
			case 8:	// 예약취소한 사람보기
				method.cancelPeople(Rcus);
				break;
			default:

			}
		}
	}
}
