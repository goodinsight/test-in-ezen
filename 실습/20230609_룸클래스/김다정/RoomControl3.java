package kr.co.dong.room;

import java.util.List;
import java.util.Scanner;

public class RoomControl3 {
	static Scanner scan = new Scanner(System.in);   // static 메모리로 보내기 (static / stack / heap)

	public static void menu() { // public void는 어디서든 쓸수있게
		System.out.println("┌────────────────[menu]────────────────┐");
		System.out.println("1. 객실 조회");
		System.out.println("2. 객실 예약");
		System.out.println("3. 객실 예약 취소");
		System.out.println("4. 예약자 조회");
		System.out.println("└──────────────────────────────────────┘");

	}

//	1. 객실 조회
	public void hotel(List<Room1> list) {
		System.out.println("┌────────────────[menu]────────────────┐");
		System.out.println("1. 전체 조회");
		System.out.println("2. 방 이름으로 객실 조회 ");
		System.out.println("3. 방 호수로 객실 조회 ");
		System.out.println("└──────────────────────────────────────┘");
		int sel = scan.nextInt();
		if (sel == 1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print("  방 번호 : " + list.get(i).getrNo() + "  방 이름 : " + list.get(i).getrName() + "방 가격 :  "
						+ list.get(i).getrPrice());
				if (list.get(i).isCheck() == false) {
					System.out.println("  예약 여부 : 예약이 가능합니다.");
				} else {
					System.out.println("  예약 여부 : 예약이 불가능합니다.");
				}
			}
		} else if (sel == 2) {
//			System.out.println("방 이름을 적어주세요.");
//			String name = scan.next();
			String name = inputMS("방 이름을 적어주세요.");
			if (rname(list, name) == -1) {
				System.out.println("잘못입력하였습니다.");
			} else {
				System.out.println(list.get(rname(list, name)));
			}

		} else if (sel == 3) {
			System.out.println("방 호수를 적어주세요.");
			int hosu = scan.nextInt();
			if (nname(list, hosu) == -1) {
				System.out.println("잘못입력하였습니다.");
			} else {
				System.out.println(list.get(nname(list, hosu)));
			}
		}
	}

//	2. 객실 예약 (방번호)
	public void revRoom(List<Room1> list) { // hosu는 있는지 없는지 비교하려고
		System.out.println("원하시는 호수를 입력해주세요.");
		int hosu = scan.nextInt();
		int index = nname(list, hosu);
		if (index == -1) {
			System.out.println("없는 호수입니다.");
		} else {
			System.out.println("예약이 가능합니다.");
			System.out.println("예약자 성함을 입력해주세요.");
			String revName = scan.next();
			list.get(index).setCustomer(revName);
//				System.out.println(list.get(i).getCustomer()); // 맞나 테스트한것
			String revNo = "230612" + hosu;
			System.out.println("예약번호는 " + revNo);
			list.get(index).setRevCode(revNo);
			list.get(index).setCheck(true);

		}
//		호수가 있는지 확인해야한다
//			if (list.get(index).getrNo()==hosu) {
//			}

	}

//	3. 예약 취소
	public void cancelRoom(List<Room1> list) {
		System.out.println("예약자 성함을 입력해주세요.");
		String canName = scan.next();
		int index = nname(list, canName);
		if (index == -1) { // 인덱스값을 가져오는 아이
			System.out.println("예약되지 않은 이름입니다. ");
		} else {
			if (list.get(index).getCustomer().equals(canName)) {
				System.out.println("예약이 확인되었습니다. ");
				System.out.println("예약번호를 입력해주세요.");
				String canNo = scan.next();
				if (!list.get(index).getRevCode().equals(canNo)) { // 참조형이라 ! equals로 해야함 ==안됨.
					System.out.println("틀렸다.돌아가라");
				} else {
					System.out.println("예약 취소 되었습니다. ");
					list.get(index).setCustomer(null);
					list.get(index).setRevCode("");
					list.get(index).setCheck(false);
				}
			}
		}
	}

// 4. 예약자 조회
	public void look(List<Room1> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCustomer() != null) {
				System.out.println("예약자 : " + list.get(i).getCustomer() + "  예약번호 : " + list.get(i).getRevCode());
			}
		}
	}

	public void init(List<Room1> list) {
		Room1 r1 = new Room1(101, "소나무", 20000, "사는 방");
		Room1 r2 = new Room1(102, "참나무", 20000, "사는 방");
		Room1 r3 = new Room1(103, "동백나무", 20000, "사는 방");
		Room1 r4 = new Room1(104, "벚나무", 20000, "사는 방");
		Room1 r5 = new Room1(105, "은행나무", 20000, "사는 방");

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

//	'호수' 인덱스 가져오는 메소드
	public int nname(List<Room1> list, int hosu) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (hosu == list.get(i).getrNo()) {
				index = i;
				break;
			}
		}
		return index;
	}

//	'예약자 이름' 인덱스 가져오는 메소드
	public int nname(List<Room1> list, String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

//	'방 이름' 인덱스 가져오는 메소드
	public int rname(List<Room1> list, String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getrName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	 static int intputMD(String msg) {    // 정수 , static붙이는 이유는 scan받는 Scanner이 static이라서.
		System.out.println(msg + ": ");
		return scan.nextInt();
	}
	
	 static String inputMS(String msg) {   
		 System.out.println(msg + ": ");
		 return scan.next();
	 }
//	===================>>>>
//	 문자열 , msg에 "원하는 호수를 입력해주세요.등등" => scan받은 값이 
//		System.out.println("방 이름을 적어주세요.");
//		String name = scan.next();
//		=====> 로 String name = inputMS("방 이름을 적어주세요."); 줄여서 쓸수 있음
	



	public int choice() {
		return scan.nextInt();
	}

}