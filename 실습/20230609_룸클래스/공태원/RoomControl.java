package kr.co.dong.room;

import java.rmi.server.RMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
//		호텔룸의(5개) 정보를 보관 -> List
//
		
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
		
//		호텔의 룸 정보를 초기화하고 저장
		init(list);
		
		while(!stop) {
			int sel = menu();
			switch(sel) {
			case 1:			//방예약
				roomRev(list);
				break;
			case 2:			//방 예약 취소
				cancelRoom(list);
				break;
			case 3:			//방 전체확인 / 선택확인
				printRoom(list);
				break;
			case 4:	//예약자 정보 확인
				customer(list);
				break;
			}
		}
		
	}

	private static void customer(List<Room> list) {
		// TODO Auto-generated method stub
		// 성함과 코드가 맞으면 > 방 정보 출력 / 성함과 코드가 틀리면 > 예약된 정보가 없습니다 출력
		System.out.println("성함과 예약코드를 입력해주세요.");
		String uname=scan.next();
		String ucode =scan.next();
		for(Room r:list) {
			if(r.getCustomer() == uname && r.getRevCode() == ucode) {
				System.out.println(r.toString());
			}else {
				System.out.println("예약된 정보가 없습니다.");
			}
			
		}
	}

	private static void cancelRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("예약자 성함과 예약코드를 입력해주세요.");
		String uname1 =scan.next();
		String ucode1 = scan.next();
		//성함,코드가 맞을떄 > 예약 취소(false로 바꾸기)>예약취소 출력  /성함 코드가 틀렸을때...(예약내역이 없습니다.)출력
		for(Room r:list) {
			if(uname1 == r.getCustomer() && ucode1 == r.getRevCode() ) {
				r.setCheck(false);
				System.out.println("예약이 취소되었습니다.");
			}else {
				System.out.println("예약된 정보가 없습니다.");
			}
		}
		
	}

	private static int menu() {
		// TODO Auto-generated method stub
		System.out.println("1.예약 2. 예약취소 3. 객실보기 4.예약자 정보확인");
		
		return scan.nextInt();
	}

	private static void roomRev(List<Room> list) {
		// TODO Auto-generated method stub
		
		System.out.println("예약하실 호실을 입력해주세요.(101~105)");
		for(Room r:list) {
			System.out.println(r.toString());//방정보.
		}
		int sel1 = scan.nextInt();
		//예약가능하면 예약자 성함입력 예약코드.. /불가하면 예약이 불가합니다 출력.....
		for(Room r:list) {
			if(r.getrNo() == sel1 ) {
				if(r.isCheck() == true) {
					System.out.println("예약이 불가합니다.");
				}else {
					System.out.println("예약자 성함을 입력해주세요.");
					String uname = scan.next();
					r.setCustomer(uname);
					String ucode = (String.valueOf((int)Math.random()*5));
					System.out.println("예약이 되었습니다.");
					System.out.println("예약코드 :"+ucode);
					r.setRevCode(ucode);
					r.setCheck(true);
				}
			}
		}
		
		
	}

	private static void printRoom(List<Room> list) {
		// TODO Auto-generated method stub
		System.out.println("1.전체호실확인 2.선택호실확인");
		int sel = scan.nextInt();
		
		if(sel == 1) {
			for(Room r:list) {
				System.out.println(r);
			}
		}else if(sel == 2) {
			System.out.println("호실을 선택해주세요.");
			int roomN = scan.nextInt();
			for(Room r:list) {
				if(roomN == r.getrNo()) {
					System.out.println(r.toString());
				}
			}
		}
	}

	private static void init(List<Room> list) {
		// TODO Auto-generated method stub
		Room r1 = new Room(101,"소나무",20000,"사는 방");
		Room r2 = new Room(102,"참나무",20000,"사는 방");
		Room r3 = new Room(103,"동백나무",20000,"사는 방");
		Room r4 = new Room(104,"벚나무",20000,"사는 방");
		Room r5 = new Room(105,"은행나무",20000,"사는 방");
		
//		 방 저장
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
		
		
	}
}
