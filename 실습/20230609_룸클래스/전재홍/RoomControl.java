package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List

		RoomFunc rf = new RoomFunc();
		List<Room> list = new ArrayList<Room>();
		List<RoomFunc> func = new ArrayList<RoomFunc>();
		boolean stop = false;

//		호텔의 룸 정보를 초기화 하고 저장
		init(list);

		while (!stop) {
			int sel = rf.menu();

			switch (sel) {
			case 0:
				System.out.println("종료합니다");
				stop = true;
			case 1: // 방예약
				rf.roomRev(list);
				break;
			case 2: // 방 예약 취소
				rf.roomCan(list);
				break;
			case 3: // 방 전체 확인, 선택확인
				rf.roomChck(list);
				break;
			case 4: // 예약자 정보 확인
				rf.nameChck(list);
				break;

			default:
				break;

			}
		}

	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
//		호텔의 룸 정보를 초기화
		Room r1 = new Room(101, "소나무", 20000, "1가 사는 방");
		Room r2 = new Room(102, "참나무", 20000, "2가 사는 방");
		Room r3 = new Room(103, "동백나무", 20000, "3가 사는 방");
		Room r4 = new Room(104, "벛나무", 20000, "4가 사는 방");
		Room r5 = new Room(105, "은행나무", 20000, "5가 사는 방");
		
//		방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}



}

