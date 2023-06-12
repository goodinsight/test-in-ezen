package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		호텔방(5개)의 정보를 보관 -> List
//		
		List<Room> roomList = new ArrayList<Room>();
		boolean stop = false;
		List<Reservation> roomRes = new ArrayList<Reservation>();
		
		init(roomList);
		
		while (!stop) {
			int sel = menu();
			
			switch (sel) {
			case 1:				// 방 예약하기
				roomRev(roomList, roomRes);
				break;
			case 2:				// 방 예약 취소
				roomCancel(roomList, roomRes);
				break;
			case 3:				// 방 전체확인/ 선택확인
				showRoom(roomList);
				break;
			case 4:				// 예약자 정보확인
				showReservation(roomRes);
				break;
			case 5:
				
				stop = !stop;
			default:
				break;
			}
			
		}
	}
	
//	예약 취소 메소드
	private static void roomCancel(List<Room> roomList, List<Reservation> roomRes) {
		String name = stringChoice("예약취소하시는분의 성함을 입력해주세요");
		int index = resIndex(roomRes, name);
		
		if(index != -1) {
			String revCode = stringChoice("예약번호를 입력해주세요");
			if(revCode.equals(roomRes.get(index).getRevCode())) {
				System.out.println("예약이 취소되었습니다.");
				roomList.get(roomIndex(roomList, roomRes.get(index).getRoomNum())).setRoomCheck(false);;
				roomRes.remove(index);
			}else {
				System.out.println("예약번호가 다릅니다 다시 입력해주세요.");
			}
		}else {
			System.out.println("입력하신 분의 성함으로된 예약이 없습니다.");
		}
	}

//	예약자의 정보를 보여주는 메소드
	private static void showReservation(List<Reservation> roomRes) {
		for (Reservation reservation : roomRes) {
			System.out.println(reservation.toString());
		}
		if(roomRes.size() == 0) {
			System.out.println("예약한 사람이 없습니다.");
		}
	}

//	예약 메소드
	private static void roomRev(List<Room> roomList, List<Reservation> roomRes) {
		showRoom(roomList);
		int num = choice("예약하실 호실을 선택해주세요.");
		int index = roomIndex(roomList, num);
		if(index != -1) {
			if(roomList.get(index).isRoomCheck()) {
				System.out.println("선택하신 호실은 이미 예약이 되어있습니다.");
			}else {
				
				room(num, stringChoice("예약자분의 성함을 입력해주세요"),ramNum() , roomRes);
				roomList.get(index).setRoomCheck(true);
				System.out.println("선택하신 호실이 예약되셨습니다.");
			}
		}else {
			System.out.println("입력하신 호실은 없는 호실입니다.");
		}
		
	}

//	메뉴 메소드
	private static int menu() {
		System.out.println("1. 방 예약하기 2. 방 예약 취소 3. 방 전체확인/ 선택확인 4. 예약자 정보확인");
		return sc.nextInt();
	}

//	호실을 보여주는 메소드
	private static void showRoom(List<Room> roomList) {
		int sel = choice("1. 전체호실확인 2.선택호실확인");
		
		if(sel == 1) {
			for (Room room : roomList) {
				System.out.println(room.toString());
			}
		}else if(sel == 2) {
			int num = choice("호실을 선택해주세요.");
			int index = -1;
			for (int i = 0; i < roomList.size(); i++) {
				if(num == roomList.get(i).getRoomNum()) {
					index = i;
				}
			}
			if(index != -1) {
				System.out.println(roomList.get(index));
			}else {
				System.out.println("입력하신 호실은 없는 호실입니다.");
			}
		}else {
			System.out.println("1~2만 선택해주세요.");
			showRoom(roomList);
		}
	}

//	방의 리스트를 초기화 해주는 메소드
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
	
//	msg를 던져주고 int를 반환하는 메소드
	private static int choice(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
//	msg를 던져주고 String를 반환하는 메소드
	private static String stringChoice(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
//	예약자의 정보를 담는 메소드
	private static void room(int roomNum, String customer, String revCode, List<Reservation> roomRes) {
		roomRes.add(new Reservation(roomNum, customer, revCode));
	}
	
//	랜덤한 예약번호 생성기
	private static String ramNum() {
		String num = "";
		for(int i = 0; i < 6; i++) {
			num += (int)(Math.random()*10)+"";
		}
		return num;
	}
	
//	예약시 입력한 호실이 있는지 판단하는 메소드
	private static int roomIndex(List<Room> roomlist, int roomNum) {
		int num = -1;
		for (int i = 0; i < roomlist.size(); i++) {
			if(roomNum == roomlist.get(i).getRoomNum()) {
				num = i;
			}
		}
		return num;
	}
	
//	예약취소시 입력한 사람의 정보가 있는지 탐색하는 메소드
	private static int resIndex(List<Reservation> reslist, String name) {
		int index = -1;
		for(int i = 0; i < reslist.size(); i++) {
			if(name.equals(reslist.get(i).getCustomer())) {
				index = i;
			}
		}
		return index;
	}
}
