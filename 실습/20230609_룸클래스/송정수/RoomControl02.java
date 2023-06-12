package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl02 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List

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
			case 2: // 방 예약취소
				cancelRoom(list);
				break;
			case 3: // 방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4: // 예약자 정보확인
				infoCheck(list);
				break;
			default:

			}
		}
	}
//	예약자 정보확인 메소드 입니당
	private static void infoCheck(List<Room> list) {
		List<Integer> indexlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCustomer() != null) {
				System.out.println("호실 : "+list.get(i).getrNo()+" 예약자명 : "+list.get(i).getCustomer()+" 예약번호 : "+list.get(i).getRevCode());
				indexlist.add(i);
			}
		}
		if(indexlist.size() == 0) {
			System.out.println("예약하신 사람이 없어요");
		}
	}
//	예약취소 메소드 입니당
	private static void cancelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		int sel = choice("취소할 호실을 입력하세요 : ");
		if(list.size() < sel%10) {
			System.out.println("없는 호실입니다.");
		}
		if(list.get(sel%10-1).getrNo() != sel) {
			System.out.println("입력하신 호실이 다릅니다.");
		}else {
			String name = stringChoice("예약자 성함을 입력하세요 : ");
			if(!list.get(sel%10-1).getCustomer().equals(name)) {
				System.out.println("예약자 성함을 다시 한번 확인해주세요.");
			}else {
				String num = stringChoice("예약 코드를 입력해주세요 : ");
				if(!list.get(sel%10-1).getRevCode().equals(num)) {
					System.out.println("예약 코드가 다릅니다. 다시 확인해주세요.");
				}else {
					System.out.println("예약이 취소되었습니다.");
					list.get(sel%10-1).setCheck(false);
					list.get(sel%10-1).setCustomer(null);;
					list.get(sel%10-1).setRevCode(null);;
				}
			}
		}
		
		
	}
//	예약하는 메소드 입니당
	private static void revRoom(List<Room> list) {
		// TODO Auto-generated method stub
//		printRoom(list);
		for(Room r : list) {
			System.out.println(r);
		}
		int sel = choice("원하는 호실을 입력하세요 : ");
		if(list.size() < sel%10) {
			System.out.println("없는 호실입니다.");
		}else {
			if(list.get(sel%10-1).getrNo() != sel || list.get(sel%10-1).isCheck() == true) {
				System.out.println("이미 예약된 호실이거나 잘못된 호실을 입력하셨습니다.");
			}else {
				String name = stringChoice("예약자 성함을 입력해주세요 : ");
				list.get(sel%10-1).setCustomer(name);
				int num = (int)(Math.random() *100) +1;
				System.out.println("예약코드 : "+num);
				list.get(sel%10-1).setRevCode(num+"");
				System.out.println("예약이 완료되었습니다.");
				list.get(sel%10-1).setCheck(true);
			}
			
		}
	}

	//	방 전체확인 메소드입니당
	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = choice("원하는 번호를 입력하세요 : ");
		if(sel == 1) {
			for(Room r : list) {
				System.out.println(r);
			}
		}else if(sel == 2) {
			sel = choice("확인하실 호실을 입력하세요 : ");
			if(sel%10 > list.size()) {
				System.out.println("없는 호실입니다.");
			}
			if(list.get(sel%10-1).getrNo() == sel) {
				String mark = "";
				if(list.get(sel%10-1).isCheck() == false) {
					mark = "예약가능";
				}else {
					mark = "예약 불가능";
				}
				System.out.println("호실 : "+list.get(sel%10-1).getrNo()+" 방이름 : "+list.get(sel%10-1).getrName()+" 가격 : "+list.get(sel%10-1).getRprice()+" 예약여부 : "+mark);
			}
		}
	}

//	msg 받으면 int.scan으로 반환
	private static int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//	msg 받으면 String.scan으로 반환
	private static String stringChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("=====호텔 메뉴=====");
		System.out.println("1.예약하기 2.예약취소 3.예약여부확인 4.예약자정보확인");
		return choice("원하는 번호를 입력하세요 : ");
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101, "소나무", 20000, "침대1개");
		Room r2 = new Room(102, "참나무", 20000, "침대1개");
		Room r3 = new Room(103, "동백나무", 40000, "침대2개");
		Room r4 = new Room(104, "벚나무", 40000, "침대2개");
		Room r5 = new Room(105, "은행나무", 50000, "침대3개");

//		방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
	}

}
