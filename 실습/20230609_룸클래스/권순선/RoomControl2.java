package kr.co.dong.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

//		호텔룸의 정보를 보관 > list

		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		호텔의 룸 정보를 초기화
		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1:// 방 예약
				revRoom(list);
				break;
			case 2:// 방 예약취소
				canselRoom(list);
				break;
			case 3:// 방 전체확인
				printRoom(list);
				break;
			case 4:// 예약자 정보확인
				person(list);
				break;

			default:
				System.out.println("다시 입력하세요");
				break;
			}

		}

	}

//	list내에 해당 내용이 저장되어 있는 index를 찾는 메소드
//	방번호
	private static int selRoom(int roomNum, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrNo(); > 리스트내에 방번호
			if (roomNum == list.get(i).getrNo()) {
				index = i;
				break;
//				return index;
			}
		}
		return index;
	}

	private static int selName(String roomName, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (roomName.equals(list.get(i).getCustomer())) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void person(List<Room> list) { // 예약확인
		// TODO Auto-generated method stub
		System.out.print("예약자 이름을 적어주세요 : ");
		String name = sc.next();

		int name2 = selName(name, list);
		if (name2 != -1) {
			Room r = list.get(name2);
			System.out.println(r.getCustomer() + "님으로 " + r.getrNo() + "호 " + r.getrName() + " 예약되어 있습니다");
		}
	}

	private static void revRoom(List<Room> list) { // 방 예약
		// TODO Auto-generated method stub

		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		for (Room r : list) {
			System.out.println(r.getrNo() + "호 " + r.getrName() + " " + r.getrPrince() + "원");
		}
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆");

		System.out.print("번호 선택 : ");
		int num = sc.nextInt();
		System.out.print("예약자명 입력 : ");
		String name = sc.next();

		int num2 = selRoom(num, list);
		if (num2 != -1 && list.get(num2).isCheck() == true) {
			System.out.println(num + "호는 예약되어있습니다");
		} else if (num2 != -1) {
			list.get(num2).setCheck(true);
			list.get(num2).setCustomer(name);
			System.out
					.println(list.get(num2).getCustomer() + "님 " + num + "호 " + list.get(num2).getrName() + " 예약되었습니다");
		} else if (num2 == -1) {
			System.out.println(num + "호 번호가 없음 다시 확인");
		}

	}

	private static void canselRoom(List<Room> list) { // 방 예약취소
		// TODO Auto-generated method stub
		System.out.println("예약 취소할 방 번호 입력");
		System.out.print("번호 선택 : ");
		int num = sc.nextInt();

		int num2 = selRoom(num, list);
		if (num2 != -1) {
			list.get(num2).setCheck(false);
			System.out.println(num + "호 선택 예약 취소");
		} else if (num2 == -1) {
			System.out.println(num + "예약된 방이 없음 다시 확인");
		}
	}

	private static void printRoom(List<Room> list) { // 방 확인
		// TODO Auto-generated method stub
		System.out.println("1) 전체 호실확인");
		System.out.println("2) 선택 호실확인");
		System.out.print("Choice : ");
		int sel = sc.nextInt();

		if (sel == 1) {
			for (Room r : list) {
				if (r.isCheck() == true) {
					System.out.println(r.getrNo() + "호 " + r.getrName() + " ☆예약 불가☆");
				} else if (r.isCheck() == false) {
					System.out.println(r.getrNo() + "호 " + r.getrName() + " ★예약 가능★");
				}
			}
		} else if (sel == 2) {
			System.out.print("정보를 확인하고 싶은 방 번호를 입력 : ");
			int sel2 = sc.nextInt();

			int roomnum = selRoom(sel2, list);
			if (roomnum != -1) {
				Room r = list.get(roomnum);
				System.out.println(r.getrName() + " " + r.getrContent());
			} else if (roomnum == -1) {
				System.out.println("방 정보를 확인할 수 없음");
			}

		} else {
			System.out.println("다시 선택해주세요");
		}

	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1) 방 예약하기");
		System.out.println("2) 방 예약취소");
		System.out.println("3) 방 전체확인");
		System.out.println("4) 예약자 정보확인");
		System.out.print("Choice : ");
		return sc.nextInt();
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r = new Room(101, "소나무룸", 50000, "1 방");
		Room r2 = new Room(102, "참나무룸", 100000, "2 방");
		Room r3 = new Room(103, "동백나무룸", 70000, "3 방");
		Room r4 = new Room(104, "벚나무룸", 60000, "4 방");
		Room r5 = new Room(105, "은행나무룸", 40000, "5 방");

//		방 저장

//		list.add(new Room(101, "소나무룸", 50000, "1 방"));
		list.add(r);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);

	}
}
