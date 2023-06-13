package kr.co.dong.room;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.ListenerNotFoundException;

public class RoomContro1 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List
//		
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;

//		호텔의 룸 정보를 초기화하고 저장
		init(list);

		while (!stop) {
			int sel = menu();

			switch (sel) {
			case 1: // 방 예약하기
				revRoom(list);
				break;

			case 2: // 방 예약 취소
				canselRoom(list);
				break;

			case 3: // 방 전체확인 / 선택확인
				printRoom(list);
				break;

			case 4: // 예약자 정보확인
				inforRoom(list);

				break;

			case 99: // 종료
				break;

			default:
			}

		}

	}


	//	0번 ▶ 메뉴 보여주기
	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("=========================================================");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★  Menu  ★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("▶ 1. 룸 예약 2. 예약 취소 3. 호실 확인 4. 예약자 정보확인 99. 종료");
		System.out.println("=========================================================");
		System.out.println("원하시는 메뉴번호를 입력하세요 : ");
		return scan.nextInt();
	}

//	list 내에 해당 내용이 저장되어 있는 index를 찾는 메소드
//	방 번호로 찾을지? 방 이름으로 찾을지?
//	1) 방이름으로 찾을 시
	static int findRoom(String name, List<Room> list) { // 찾으려는 방이름, 찾으려는 리스트
		int index = -1; // (방의 위치, 순서를 모를때는, 없을때 -1) 인덱스의 범위는 0~끝까지임, -1인 이유는 원하는 값이 없으면 빠져나오라는 뜻

		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => 리스트내에 방이름
			if (name.equals(list.get(i).getrName())) {
				index = i; 
//				return index; 가 여기에 있으면 berak, 밑에 return 없어도 됨.
				break;
			}
		}
		return index; // 못찾으면 return
	}

//	2) 방 번호로 찾을 시
	static int findNo(int no, List<Room> list) {
		int index = -1;

		for (int i = 0; i < list.size(); i++) {
			if (no == list.get(i).getrNo()) { // int = 숫자니까 equals 이 아니라 ==을 씀
				index = i;
				break;
			}
		}
		return index;
	}

//	1번 ▶ 방 예약하기
	private static void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
		int revCode = 0;
		System.out.println("▶원하시는 Room을 선택해주세요 (101~105) : ");
		int sel = scan.nextInt();
		if(findNo(sel, list) == -1) {
			System.out.println("없는 방입니다.");
		}else {
			System.out.println(list.get(findNo(sel, list)));
			System.out.println("예약이 가능한 방입니다. ");
			System.out.println("예약자 성함을 입력해주세요. : ");
			String customer = scan.next();
			
			for(int i = 0 ; i < 1 ; i++) {
				revCode = (int)(Math.random() * 9999) + 1000;
				for(int j = 0; j <list.size(); j++) { // 예약번호 중복 방지
					if(revCode == list.size()) {
						i--; // 번호가 중복되면 i-
						break; // 중복됐을때 또 돌아가지 않게 break
					}
				}
			}
			System.out.println("☞ 예약번호: " + revCode );		
		}
	}


//	2번 ▶ 예약 취소하기 
	private static void canselRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("예약하신 방을 입력해주세요 : ");
		int sel = scan.nextInt();
		if(findNo(sel, list) == -1) {
			System.out.println("없는 방입니다.");
		} break;
		
		for(int i = 0; i<list.size(); i++) {
			String revCode = null;
			String customer = null;
			if(customer == list.get(i).getCustomer()) {	
				System.out.println("예약자 이름을 입력해주세요 : ");
				String check =scan.next();
				if(revCode == list.get(i).getRevCode()) {
					System.out.println("예약번호를 입력해주세요: ");
					String check1 = scan.next();
				} else if(revCode != list.get(i).getRevCode())
					System.out.println("확인되지 않는 예약번호입니다. 다시 입력해주세요"); 
			} else if(customer != list.get(i).getCustomer()){
				System.out.println("확인되지 않는 예약자입니다. 다시 입력해주세요.");
			}
			break;
		} System.out.println("예약을 취소합니다.");
	}


		



//	3번 ▶ 호실확인
	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("============================================================");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★  Menu  ★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("▶ 1.전체호실 확인 2. 선택호실 번호로 확인 3. 선택호실 방이름으로 확인" );
		System.out.println("============================================================");
		System.out.println("원하시는 메뉴번호를 입력하세요 : ");

		int sel = scan.nextInt();

		if (sel == 1) { // 전체호실 확인
			for (Room r : list) { // 향상된 for문
//				for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
				System.out.println(r);
			}
			
		} else if (sel == 2) { // 선택 호실 번호로 확인
			System.out.println("선택하실 호실 번호를 입력해주세요 : ex)101~105");
			int check = scan.nextInt();
			
			if(findNo(check,list) == -1) { // 인덱스가 -1이면 원하는 값이 없으니까 없는번호로 출력
				System.out.println("없는 번호입니다.");
			}else{
				System.out.println(list.get(findNo(check,list))); // 원하는 값이 인덱스 번호와 맞을때 출력
			}
			
		} else if(sel == 3) { // 선택호실 방이름으로 확인
			System.out.println("원하시는 방 이름을 입력해주세요 : ex) 소나무");
			String check = scan.next();
			
			if(findRoom(check, list) == -1) {
				System.out.println("없는 방입니다.");
			}else {
				System.out.println(list.get(findRoom(check, list)));
			}
		}
	}

//	4번 ▶ 예약자 정보 확인	
	private static void inforRoom(List<Room> list) {
		// TODO Auto-generated method stub
		
	}
//	3번 호실확인 코드 줄이기 전
//			int count = 0;
//
//			for (int i = 0; i < list.size(); i++) {
//				if (check == list.get(i).getrNo()) {
//					System.out.println(list.get(i));// list.size()=list.get(i)..?
//					break;
//				} else {
//					count++;
//				}
//				
//			}
//			if(count == list.size()) {
//				System.out.println("없는 번호입니다.");
//			}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101, "소나무", 20000, "사는 방");
		Room r2 = new Room(102, "참나무", 20000, "사는 방");
		Room r3 = new Room(103, "동백나무", 20000, "사는 방");
		Room r4 = new Room(104, "벚나무", 20000, "사는 방");
		Room r5 = new Room(105, "은행나무", 20000, "사는 방");

//		방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

}
