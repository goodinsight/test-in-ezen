package kr.co.dong.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RoomControl {
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

	private static void person(List<Room> list) { // 예약확인
		// TODO Auto-generated method stub
		
		System.out.println("예약 정보를 확인 합니다");
		System.out.print("예약자 이름을 입력하세요 : ");
		String name = sc.next();

		for (int i = 0; i < list.size(); i++) {
			Room r = list.get(i);
			if (name.equals(r.getCustomer())) {
				System.out.println(r.getCustomer() + "님으로 " + r.getrNo() + "호 " + r.getrName() + " 예약되어있습니다");
				System.out.println("예약번호는 " + r.getRevCode() + " 입니다");
				break;
			} else if (!name.equals(r.getCustomer())) {
				System.out.println("예약자명을 다시 입력하세요");
				break;
			}
		}
	}

	private static void revRoom(List<Room> list) { // 방 예약
		// TODO Auto-generated method stub
//		for (int i = 0; i < list.size(); i++) {
//			Room r = list.get(i);
//			System.out.println(r.getrNo() + "호 " + r.getrName() + " " + r.getrPrince() + "원 ");
//		}
		
		for(Room r : list) {
			System.out.println(r);
		}

		System.out.println("예약할 방 번호를 선택해주세요");
		System.out.print("Choice : ");
		int sel = sc.nextInt();
		System.out.print("예약자명을 입력해주세요 : ");
		String name = sc.next();

		switch (sel) {
		case 101:
		case 102:
		case 103:
		case 104:
		case 105:
			for (int i = 0; i < list.size(); i++) {
				Room r = list.get(i);
				if (r.getrNo() == sel && r.isCheck() == false) {
					int rd = ((int) (Math.random() * 9999) + 1000);
					r.setCheck(true);
					r.setCustomer(name);
					r.setRevCode(Integer.toString(rd));
					System.out.println("예약코드 " + r.getRevCode() + " " + r.getrNo() + "호 " + r.getrName() + " 예약되었습니다");
					System.out.println(r.getCustomer() + "님 감사합니다");
//					System.out.println(r.isCheck());
				} else if (r.getrNo() == sel && r.isCheck() == true) {
					System.out.println(r.getrNo() + "호 " + r.getrName() + " 예약 불가입니다");
				}
			}
			break;

		default:
			System.out.println("방 번호를 다시 입력하세요");
			break;
		}

	}

	private static void canselRoom(List<Room> list) { // 방 예약취소
		// TODO Auto-generated method stub
		System.out.println("예약 취소할 방 번호를 선택해주세요");
		System.out.print("Choice : ");
		int sel = sc.nextInt();
		System.out.print("예약자명을 입력해주세요 : ");
		String name = sc.next();

		for (int i = 0; i < list.size(); i++) {
			Room r = list.get(i);
			if (r.getrNo() == sel && r.isCheck() == true && r.getCustomer() == name) {
				r.setCheck(false);
				r.setCustomer(null);
				r.setRevCode(null);
				System.out.println(r.getrNo() + "호 " + r.getrName() + " 예약 취소되었습니다");
//				System.out.println(r.isCheck());
			} else if (r.getrNo() == sel && r.isCheck() == false && r.getCustomer() == name) {
				System.out.println("이미 예약 취소되었거나 확인할 수 없습니다");
			}
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
				} else {
					System.out.println(r.getrNo() + "호 " + r.getrName() + " ★예약 가능★");
				}
			}
		} else if (sel == 2) {

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
