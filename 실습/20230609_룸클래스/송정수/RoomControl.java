package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
//		호텔룸(5개)의 정보를 보관 -> List
		
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
		
//		호텔의 룸 정보를 초기화하고 저장
		init(list);
		
		while(!stop) {
			int sel = menu();
			
			switch(sel) {
			case 1:		//방 예약하기
				revRoom(list);
				break;
			case 2:		//방 예약취소
				cancelRoom(list);
				break;
			case 3:		//방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4:		//예약자 정보확인
				infoCheck(list);
				break;
			default :
					
			}
		}
		
		
//		list.add(new Room(101, "소나무", 20000, "사는 방"));
		
	}

	private static void infoCheck(List<Room> list) {	//예약자 정보확인
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCustomer() != null) {
				System.out.println("호실 : "+list.get(i).getrNo()+" 고객명 :"+list.get(i).getCustomer()+" 예약번호 :"+list.get(i).getRevCode());
				
			}
			
		}
		
	}

	private static void cancelRoom(List<Room> list) {	//예약취소
		// TODO Auto-generated method stub
		System.out.println("예약 취소하실 호실을 입력해주세요 : ");
		int sel = scan.nextInt();
		if(list.get(sel%10-1).getrNo() != sel || list.get(sel%10-1).isCheck() == false) {
			System.out.println("입력하신 호실이 다르거나 예약이 되어있지 않습니다.");
		}else {
			System.out.println("예약자 성함을 입력해주세요 : ");
			scan.nextLine();
			String name = scan.nextLine();
			if(!list.get(sel%10-1).getCustomer().equals(name)) {
				System.out.println("예약자 성함이 맞지 않습니다.");
			}else {
				System.out.println("예약 코드를 입력해주세요 : ");
				String num = scan.next();
				if(!list.get(sel%10-1).getRevCode().equals(num)) {
					System.out.println("예약코드가 맞지않습니다.");
				}else {
					System.out.println("예약이 취소되었습니다.");
					list.get(sel%10-1).setCustomer(null);
					list.get(sel%10-1).setRevCode(null);;
					list.get(sel%10-1).setCheck(false);;
				}
			}
		}
		
	}

	private static void revRoom(List<Room> list) {	//예약하기
		// TODO Auto-generated method stub
		printRoom(list);
		System.out.println("원하는 호실을 입력하세요 : ");
		int sel = scan.nextInt();
		if(list.size() < sel%10) {
			System.out.println("없는 호실입니다.");
		}else {
			if(sel == list.get(sel%10-1).getrNo() ) {
				if(list.get(sel%10-1).isCheck() == true) {
					System.out.println("이미 예약된 방입니다.");
				}else {
					System.out.println("예약자 성함을 입력하세요 : ");
					scan.nextLine();
					String name = scan.nextLine();
					list.get(sel%10-1).setCustomer(name);
					int num = (int)(Math.random() * 100) +1;
					System.out.println(num);
					System.out.println("예약코드 : "+num);
					list.get(sel%10-1).setRevCode(num+"");
					System.out.println("예약완료");
					list.get(sel%10-1).setCheck(true);
				}
			}
		}
		
		
	}

	private static int menu() {	//호텔 메뉴
		// TODO Auto-generated method stub
		System.out.println("=====호텔 메뉴=====");
		System.out.println("1.예약하기 2.예약취소 3.예약여부확인 4.예약자 정보확인");
		System.out.println("원하는 번호를 입력하세요 : ");
		return scan.nextInt();
	}

	private static void printRoom(List<Room> list) {	//예약여부확인
		// TODO Auto-generated method stub
		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			for(Room r : list) {
				System.out.println(r);
			}
		}else if(sel == 2) {
			System.out.println("확인할 호실 입력 : ");
			sel = scan.nextInt();
			if(list.size() < sel%10) {
				System.out.println("없는 호실입니다.");
			}
			else if(list.get(sel%10-1).getrNo() == sel ) {
				System.out.println("호실 : "+list.get(sel%10-1).getrNo()+" 방설명 : "+list.get(sel%10-1).getrdescription()+" 가격 : "+list.get(sel%10-1).getRprice()+" 예약여부 : "+list.get(sel%10-1).isCheck());
			}
		}
	}

	private static void init(List<Room> list) {	//방 정보
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
