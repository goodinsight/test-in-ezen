package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class RoomControl {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 호텔룸 정보를 우선 5개로 가정햐쟈 보관하자 ==> List
		//
		//
		//
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {

			case 1:// 방 예약하기
				revRoom(list);
				break;

			case 2:// 방 예약 취소
				canselRoom(list);
				break;

			case 3:// 방 전체 확인
				printRoom(list);
				break;

			case 4:// 예약자 정보확인
				break;
			default:

			}

		}
		
	}

	private static int menu() {// 메뉴보여주기라 리턴하자 없으면 안될 조건으로 우선 가정하기
		System.out.println("메뉴를보여주자");
		System.out.println("1.방예약정보 , 2.예약취소여부 , 3.전체여부등등 4. 예약자정보여부확인");

		return scan.nextInt();
	}

	private static void revRoom(List<Room> list) {// 방 예약 하기
		// TODO Auto-generated method stub

		System.out.println("예약정보시스템입니당");
		int rNo = scan.nextInt();

		for (Room r : list) {
			if (rNo == 0) {
				System.out.println("예약가능하다네요  " + list.get(rNo));
			} else if (rNo != 0) {// 1이면 이미 있는거니까 안되지
				System.out.println("이미 예약된상태임!!");
				// r=sel.room(revRoom(list.get(sel));
				System.out.println(list.add(r));

			}

		}
		
		
		
	}

	private static void canselRoom(List<Room> list) {// 방예약취소
		// TODO Auto-generated method stub
		System.out.println("방예약취소시스템");
		
		System.out.println("취소여부를 확인하자");
		String revcode = scan.nextLine();
		int sel = 0;// 임시변수로 지정해자
		if (sel == 1) {
			
			System.out.println("만석이니 다시확인바람 "+  (list));
		}else if(list==null){
			
			System.out.println("없음");
		}
	}

	private static void printRoom(List<Room> list) {// 방 전체 확인
		// TODO Auto-generated method stub

		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = scan.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				System.out.println(r);
			}
		} else if (sel == 2) {
			System.out.println("호실을 받습니다");
			int roomname = scan.nextInt();
			System.out.println(list.get(roomname - 1));

		}
	}

	private static void init(List<Room> list) {// 지우면 안되는 요소
		
		Room r1 = new Room(101, "커리어", 10000, "동해");
		Room r2 = new Room(201, "크리스탈", 20000, "쾌청");
		Room r3 = new Room(301, "빅토리아", 30000, "맑음");
		Room r4 = new Room(401, "만현마을", 40000, "가을");
		Room r5 = new Room(501, "숲속마을", 50000, "따뜻");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}

}
